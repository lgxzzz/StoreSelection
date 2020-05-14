package com.store.selection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.store.selection.R;
import com.store.selection.bean.Village;

import java.util.ArrayList;
import java.util.List;

public class VillageAdapter extends BaseAdapter {

    Context mContext;
    List<Village> mVillages = new ArrayList<>();


    public VillageAdapter(Context mContext){
        this.mContext = mContext;
    }

    public void setData( List<Village> mVillages){
        this.mVillages = mVillages;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mVillages.size();
    }

    @Override
    public Object getItem(int i) {
        return mVillages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String title = mVillages.get(i).getVillage_Name();
        VillageAdapter.ViewHoler holer = null;
        if (view == null){
            holer = new VillageAdapter.ViewHoler();
            view = LayoutInflater.from(mContext).inflate(R.layout.store_item,null);
            holer.mVilllageName = (TextView) view.findViewById(R.id.store_level_1_btn);
            view.setTag(holer);
        }else{
            holer = (VillageAdapter.ViewHoler) view.getTag();
        }
        holer.mVilllageName.setText(title);
        return view;
    }

    class ViewHoler{
        TextView mVilllageName;
    }
}
