package com.zxl.zhaodemo.customview;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.zxl.zhaodemo.R;
import com.zxl.zhaodemo.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ${zxl} on 2017/4/12.
 * D: 国际区号适配器
 * C:
 */

public class SidebarAdapter extends ArrayAdapter<SidebarEntity> implements SectionIndexer {
    private static final String TAG = "QuhaoAdapter";
    private Context context;
    private List<String> sList;
    private List<SidebarEntity> qList;
    private List<SidebarEntity> copyqList;
    private LayoutInflater layoutInflater;
    private SparseIntArray positionOfSection;
    private SparseIntArray sectionOfPosition;
    private MyFilter myFilter;
    private int res;
    private boolean notiyfyByFilter;

    public SidebarAdapter(Context context, int resource, List<SidebarEntity> list) {
        super(context, resource, list);
        this.res = resource;
        this.qList = list;
        this.context = context;
        copyqList = new ArrayList<>();
        copyqList.addAll(list);
        layoutInflater = LayoutInflater.from(context);
    }

    private static class ViewHolder {
        TextView headerView;
        TextView nameView;
        TextView numberView;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_quhao, parent, false);
            holder.headerView = (TextView) convertView.findViewById(R.id.quhao_header);
            holder.nameView = (TextView) convertView.findViewById(R.id.quhao_name);
            holder.numberView = (TextView) convertView.findViewById(R.id.quhao_number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SidebarEntity entity = qList.get(position);
        if (entity == null) {
            LogUtils.e(TAG, "entity" + position);
        }
        String name = entity.getName();
        String header = entity.getInitialLetter();
        if (position == 0 || header != null && !header.equals(getItem(position - 1).getInitialLetter())) {
            if (TextUtils.isEmpty(header)) {
                holder.headerView.setVisibility(View.GONE);
            } else {
                holder.headerView.setText(header);
                holder.headerView.setVisibility(View.VISIBLE);

            }
        } else {
            holder.headerView.setVisibility(View.GONE);
        }
        holder.nameView.setText(name);

        return convertView;
    }
    @Override
    public SidebarEntity getItem(int position) {
        return super.getItem(position);
    }
    @Override
    public int getCount() {
        return super.getCount();
    }
    @Override
    public int getPositionForSection(int sectionIndex) {
        return positionOfSection.get(sectionIndex);
    }

    @Override
    public int getSectionForPosition(int position) {
        return sectionOfPosition.get(position);
    }
    @Override
    public Object[] getSections() {
        positionOfSection = new SparseIntArray();
        sectionOfPosition = new SparseIntArray();
        int count = getCount();
        sList = new ArrayList<String>();
        //热门、搜等等
        sList.add("A");
        positionOfSection.put(0, 0);
        sectionOfPosition.put(0, 0);
        for (int i = 1; i < count; i++) {

            String letter = getItem(i).getInitialLetter();
            int section = sList.size()-1;
            if (sList.get(section) != null && !sList.get(section).equals(letter)) {
                sList.add(letter);
                section++;
                positionOfSection.put(section, i);
            }
            sectionOfPosition.put(i, section);
        }
        return sList.toArray(new String[sList.size()]);
    }



    @Override
    public Filter getFilter() {
        if (myFilter == null) {
            myFilter = new MyFilter(qList);
        }
        return myFilter;
    }

    protected class MyFilter extends Filter {
        List<SidebarEntity> mOriginalList = null;

        public MyFilter(List<SidebarEntity> myList) {
            this.mOriginalList = myList;
        }

        @Override
        protected synchronized FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();
            if (mOriginalList == null) {
                mOriginalList = new ArrayList<SidebarEntity>();
            }
            LogUtils.d(TAG, "contacts original size: " + mOriginalList.size());
            LogUtils.d(TAG, "contacts copy size: " + copyqList.size());

            if (prefix == null || prefix.length() == 0) {
                results.values = copyqList;
                results.count = copyqList.size();
            } else {
                String prefixString = prefix.toString();
                final int count = mOriginalList.size();
                final ArrayList<SidebarEntity> newValues = new ArrayList<SidebarEntity>();
                for (int i = 0; i < count; i++) {
                    final SidebarEntity quaho = mOriginalList.get(i);
                    String username = quaho.getName();

                    if (username.startsWith(prefixString)) {
                        newValues.add(quaho);
                    } else {
                        final String[] words = username.split(" ");
                        final int wordCount = words.length;

                        // Start at index 0, in case valueText starts with space(s)
                        for (String word : words) {
                            if (word.startsWith(prefixString)) {
                                newValues.add(quaho);
                                break;
                            }
                        }
                    }
                }
                results.values = newValues;
                results.count = newValues.size();
            }
            LogUtils.d(TAG, "contacts filter results size: " + results.count);
            return results;
        }

        @Override
        protected synchronized void publishResults(CharSequence constraint,
                                                   FilterResults results) {
            qList.clear();
            qList.addAll((List<SidebarEntity>) results.values);
            LogUtils.d(TAG, "publish contacts filter results size: " + results.count);
            if (results.count > 0) {
                notiyfyByFilter = true;
                notifyDataSetChanged();
                notiyfyByFilter = false;
            } else {
                notifyDataSetInvalidated();
            }
        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (!notiyfyByFilter) {
            copyqList.clear();
            copyqList.addAll(qList);
        }
    }
}
