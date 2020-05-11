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
import com.store.selection.data.DBManger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StoreAdapter extends BaseAdapter {

    Context mContext;
    List<Store> mStore = new ArrayList<>();


    public StoreAdapter(Context mContext,  List<Store> mStore){
        this.mContext = mContext;
        this.mStore = mStore;
    }

    @Override
    public int getCount() {
        return mStore.size();
    }

    @Override
    public Object getItem(int i) {
        return mStore.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Store store = mStore.get(i);
        StoreAdapter.ViewHoler holer = null;
        if (view == null){
            holer = new StoreAdapter.ViewHoler();
            view = LayoutInflater.from(mContext).inflate(R.layout.store_item,null);
            holer.mFisrtTv = (TextView) view.findViewById(R.id.store_level_1_btn);
            holer.mSecLayout = (LinearLayout) view.findViewById(R.id.store_level_2_layout);
            view.setTag(holer);
        }else{
            holer = (StoreAdapter.ViewHoler) view.getTag();
        }

        holer.mFisrtTv.setText(store.getLevel_First());
        List<String> mSecTitles = store.getLevelSecTitle();
        for (int j=0;j<mSecTitles.size();j++){
            Button button = new Button(mContext);
            button.setText(mSecTitles.get(j));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转三级界面
                }
            });
            holer.mSecLayout.addView(button);
        }
        return view;
    }

    class ViewHoler{
        TextView mFisrtTv;
        LinearLayout mSecLayout;
    }
}
