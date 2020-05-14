package com.store.selection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.store.selection.R;
import com.store.selection.bean.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreLvThirdAdapter extends BaseAdapter {

    Context mContext;
    List<String> mStoreLv3 = new ArrayList<>();


    public StoreLvThirdAdapter(Context mContext, List<String> mStoreLv3){
        this.mContext = mContext;
        this.mStoreLv3 = mStoreLv3;
    }

    @Override
    public int getCount() {
        return mStoreLv3.size();
    }

    @Override
    public Object getItem(int i) {
        return mStoreLv3.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String title = mStoreLv3.get(i);
        StoreLvThirdAdapter.ViewHoler holer = null;
        if (view == null){
            holer = new StoreLvThirdAdapter.ViewHoler();
            view = LayoutInflater.from(mContext).inflate(R.layout.store_item,null);
            holer.mFisrtTv = (TextView) view.findViewById(R.id.store_level_1_btn);
            holer.mSecLayout = (LinearLayout) view.findViewById(R.id.store_level_2_layout);
            view.setTag(holer);
        }else{
            holer = (StoreLvThirdAdapter.ViewHoler) view.getTag();
        }
        final View v = holer.mSecLayout;
        holer.mFisrtTv.setText(title);

        return view;
    }

    class ViewHoler{
        TextView mFisrtTv;
        LinearLayout mSecLayout;
    }
}
