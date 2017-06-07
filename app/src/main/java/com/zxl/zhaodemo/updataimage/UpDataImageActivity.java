package com.zxl.zhaodemo.updataimage;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.zxl.zhaodemo.BaseActivity1;
import com.zxl.zhaodemo.R;
import com.zxl.zhaodemo.choosepicture.ChoosePictureActivity;
import com.zxl.zhaodemo.choosepicture.GetImagePath;
import com.zxl.zhaodemo.rxjava.Network;
import com.zxl.zhaodemo.rxjava.rxhelper.RxSchedulers;

import java.io.File;
import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.reactivex.ObservableTransformer;
import io.reactivex.subjects.AsyncSubject;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/6
 * @time: 10:16
 * @description:
 */

public class UpDataImageActivity extends BaseActivity1 {

    @InjectView(R.id.image_iv_1)
    ImageView imageIv1;
    @InjectView(R.id.image_iv_2)
    ImageView imageIv2;
    @InjectView(R.id.image_btn)
    Button imageBtn;
    @InjectView(R.id.image_iv_3)
    ImageView imageIv3;
    @InjectView(R.id.image_gv)
    GridView imageGv;
    int state = 0;
    File outputFile;
    private File file;
    private File outDir1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_updata_image;
    }

    @Override
    protected void initView() {
        Network.init().getsRetrofit().create(ImageApi.class).login("12323456789", "123456").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    showToast(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    protected void initEvent() {
        imageIv1.setOnClickListener(this);
        imageIv2.setOnClickListener(this);
        imageIv3.setOnClickListener(this);
        imageBtn.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.image_iv_1:
                state = 1;
                chooseDialog();
                break;
            case R.id.image_iv_2:
                state = 2;
                chooseDialog();
                break;
            case R.id.image_iv_3:
                state = 3;
                chooseDialog();
                break;
            case R.id.image_btn:
                up();
                break;
        }

    }
    private void up1(){






    }
    private void up() {
        //构建body
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("name", "zhao")
                .addFormDataPart("sex", 1 + "")
                .addFormDataPart("managerphone", "18612602404")
                .addFormDataPart("jianducardstart", "1974455")
                .addFormDataPart("jianducardend", "1974455")
                .addFormDataPart("jianduimg", new File(outDir1, "image1" + ".jpg").getName() , RequestBody.create(MediaType.parse("image/*"), new File(outDir1, "image1" + ".jpg")))
                .addFormDataPart("drivecardimg", new File(outDir1, "image2" + ".jpg").getName(), RequestBody.create(MediaType.parse("image/*"), new File(outDir1, "image2" + ".jpg")))
                .addFormDataPart("card1", new File(outDir1, "image3" + ".jpg").getName(), RequestBody.create(MediaType.parse("image/*"), new File(outDir1, "image3" + ".jpg")))
                .addFormDataPart("card2", new File(outDir1, "image1" + ".jpg").getName(), RequestBody.create(MediaType.parse("image/*"), new File(outDir1, "image1" + ".jpg")))
                .addFormDataPart("peoimg",new File(outDir1, "image2" + ".jpg").getName(), RequestBody.create(MediaType.parse("image/*"), new File(outDir1, "image2" + ".jpg")))
                .addFormDataPart("carimg", new File(outDir1, "image3" + ".jpg").getName(), RequestBody.create(MediaType.parse("image/*"), new File(outDir1, "image3" + ".jpg")))
                .build();
        Network.init()
                .getsRetrofit()
                .create(ImageApi.class)
                .upData(requestBody)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.e("success",response.message()+response.code()+response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("failure", t.toString());
                    }
                });

    }

    private void chooseDialog() {
        file = createImageFile(System.currentTimeMillis() + ".jpg");
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("选择方式");
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "相册", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chooseFromAlbum();
                dialog.dismiss();
            }
        });
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "相机", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chooseFromCamera();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /**
     * 创建一个文件
     *
     * @param fileName
     * @return
     */
    public File createImageFile(String fileName) {
        outDir1 = new File(Environment.getExternalStorageDirectory().toString());
        if (!outDir1.exists()) {
            outDir1.mkdirs();
        }
        return new File(outDir1, fileName);
    }

    private void chooseFromCamera() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {//如果大于等于7.0使用FileProvider
            Uri uriForFile = FileProvider.getUriForFile(UpDataImageActivity.this, "xyd.com.car.provider", file);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uriForFile);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivityForResult(intent, 1007);
        } else {
            startActivityForResult(intent, 1008);
        }
    }

    private void chooseFromAlbum() {
        Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {//7.0及以上
            Uri uriForFile = FileProvider.getUriForFile(this, "xyd.com.car.provider", file);
            intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, uriForFile);
            intentFromCapture.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intentFromCapture.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        } else {
            intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        }
        startActivityForResult(intentFromCapture, 1006);
    }

    /**
     * 裁剪图片方法实现
     *
     * @param inputUri
     */
    public void startPhotoZoom(Uri inputUri) {

        if (inputUri == null) {
            Log.i("", "The uri is not exist.");
            return;
        }

        outputFile = createImageFile("image" + state + ".jpg");
        Intent intent = new Intent("com.android.camera.action.CROP");
        //sdk>=24
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            Uri outPutUri = Uri.fromFile(outputFile);
            intent.setDataAndType(inputUri, "image/*");
            intent.putExtra(MediaStore.EXTRA_OUTPUT, outPutUri);
            intent.putExtra("noFaceDetection", false);//去除默认的人脸识别，否则和剪裁匡重叠
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        } else {
            Uri outPutUri = Uri.fromFile(outputFile);
            if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                String url = GetImagePath.getPath(this, inputUri);//这个方法是处理4.4以上图片返回的Uri对象不同的处理方法
                intent.setDataAndType(Uri.fromFile(new File(url)), "image/*");
            } else {
                intent.setDataAndType(inputUri, "image/*");
            }
            intent.putExtra(MediaStore.EXTRA_OUTPUT, outPutUri);
        }

        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 200);
        intent.putExtra("outputY", 200);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());// 图片格式
        startActivityForResult(intent, 1009);//这里就将裁剪后的图片的Uri返回了
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //7.0以下相册
        if (requestCode == 1008) {
            startPhotoZoom(data.getData());
        }
        //7.0以上相册
        if (requestCode == 1007) {
            File imgUri = new File(GetImagePath.getPath(this, data.getData()));
            Uri dataUri = FileProvider.getUriForFile(this, "xyd.com.car.provider", imgUri);
            startPhotoZoom(dataUri);
        }
        //拍照
        if (requestCode == 1006) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Uri inputUri = FileProvider.getUriForFile(this, "xyd.com.car.provider", file);//通过FileProvider创建一个content类型的Uri
                startPhotoZoom(inputUri);//设置输入类型
            } else {
                Uri inputUri = Uri.fromFile(file);
                startPhotoZoom(inputUri);
            }
        }
        //裁剪
        if (requestCode == 1009) {
            Bitmap b = BitmapFactory.decodeFile(outputFile.getAbsolutePath());
            if (state == 1)
                imageIv1.setImageBitmap(b);
            else if (state == 2)
                imageIv2.setImageBitmap(b);
            else if (state == 3)
                imageIv3.setImageBitmap(b);
            // dataCivHead.setImageBitmap(BitmapFactory.decodeFile(outputFile.getAbsolutePath()));
        }
    }
}
