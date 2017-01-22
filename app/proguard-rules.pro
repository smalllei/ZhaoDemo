# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#===================================================================================
# 基本指令添加
#===================================================================================
#代码混淆压缩比，0~7，默认5不做修改
-optimizationpasses 5
#混合时不使用大小写混合，混淆或类名为小写
-dontusemixedcaseclassnames
#指定不去忽略非公共的类
-dontskipnonpubliclibraryclasses
#能使我们的项目混淆后产生映射文件
#包含类名，混淆后类名的映射关系
-verbose
#不做预检验，preverify时proguard的四个步骤之一，Android不需要，去掉加快混淆
-dontpreverify
#保留注解不混淆
-keepattributes *Annotation*,InnerClasses
#避免混淆泛型
-keepattributes Signature
#抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable


#声明不压缩输入文件。默认情况下，除了-keep相关配置指定的类，
#所有其它没有被引用到的类都会被删除。每次optimizate操作之后，
#也会执行一次压缩操作，因为每次optimizate操作可能删除一部分不再需要的类
-dontshrink
#声明不优化输入文件，默认情况下，优化选项是开启的，并且所有的优化都是在字节码层进行的。
-dontoptimize
#指定混淆算法，后面的参数是一个过滤器
#谷歌推荐的算法，一般不改
-optimizations !code/simplification/cast,!field/*,!class/merging/*
#===================================================================================
# 四大组件，Application不被混淆，其子类有可能被外部调用
#===================================================================================
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Appliction
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService
#===================================================================================
# 保留support下的所有类及其内部类
#===================================================================================
-keep class android.support.**{*;}
# 保留继承的
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**
#===================================================================================
# 保留R文件下的资源
#===================================================================================
-keep class **.R$* {*;}
#保留native方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}
#保留在activity中的方法参数时view的方法，这样点击时间不会被影响
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}
#保留枚举类不被混淆
-keepclassmembers enum * {
              public static **[] values();
              public static ** valueOf(java.lang.String);
          }
#保留自定义控件（继承View）不被混淆
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
#保留Parcelable序列化类不被混淆
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
#保留Serializable序列化类不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
# 对于带有回调函数的onXXEvent、**On*Listener的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}
#===================================================================================
# webView 处理
#===============================================================================
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
    public *;
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, jav.lang.String);
}

######################################################################################
# 针对app
######################################################################################

#实体类不被混淆
#处理反射类
#-keep class 类所在的包.**{*;}
#处理js交互

#--------------------------------------------第三方依赖库---------------------------------
# butterknife混淆------------------------------------------------------------------------
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#android-gif-drawable 动态图加载库---------------------------------------------------------
-keep public class pl.droidsonroids.gif.GifIOException{<init>(int);}
-keep class pl.droidsonroids.gif.GifInfoHandle{<init>(long,int,int,int);}
#gson------------------------------------------------------------------------------------------
# Gson uses generic type information stored in a class file when working with fields. Proguard
-keepattributes EnclosingMethod
# Gson specific classes
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

#universal-image-loader-----------------------------------------------------------------
-keep class com.nostra13.universalimageloader.**{*;}
# Glide----------------------------------------------------------------------
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

## New rules for EventBus 3.0.x ##
# http://greenrobot.org/eventbus/documentation/proguard/
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

# RxJava 0.21
-keep class rx.schedulers.Schedulers {
    public static <methods>;
}
-keep class rx.schedulers.ImmediateScheduler {
    public <methods>;
}
-keep class rx.schedulers.TestScheduler {
    public <methods>;
}
-keep class rx.schedulers.Schedulers {
    public static ** test();
}
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}