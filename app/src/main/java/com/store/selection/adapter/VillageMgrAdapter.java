package com.store.selection.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.store.selection.R;
import com.store.selection.UpdateUserActivity;
import com.store.selection.bean.User;
import com.store.selection.bean.Village;
import com.store.selection.data.DBManger;

import java.util.ArrayList;
import java.util.List;

public class VillageMgrAdapter extends BaseAdapter {

    Context mContext;
    List<Village> mVillage = new ArrayList<>();


    public VillageMgrAdapter(Context mContext, List<Village> mVillage){
        this.mContext = mContext;
        this.mVillage = mVillage;
    }

    @Override
    public int getCount() {
        return mVillage.size();
    }

    @Override
    public Object getItem(int i) {
        return mVillage.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Village village = mVillage.get(i);
        VillageMgrAdapter.ViewHoler holer = null;
        if (view == null){
            holer = new VillageMgrAdapter.ViewHoler();
            view = LayoutInflater.from(mContext).inflate(R.layout.village_item,null);
            holer.mVillageNameTv = (TextView) view.findViewById(R.id.village_name_tv);
            holer.mDeleteBtn = (Button) view.findViewById(R.id.delete_village_btn);
            view.setTag(holer);
        }else{
            holer = (VillageMgrAdapter.ViewHoler) view.getTag();
        }
        holer.mVillageNameTv.setText(village.getVillage_Name());
        holer.mDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"删除成功",Toast.LENGTH_LONG).show();
                DBManger.getInstance(mContext).deleteVillage(village);
                mVillage.remove(village);
                notifyDataSetChanged();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(mContext, UpdateUserActivity.class);
//                Bundle b = new Bundle();
//                b.putSerializable("village",village);
//                intent.putExtras(b);
//                mContext.startActivity(intent);
            }
        });
        return view;
    }

    class ViewHoler{
        TextView mVillageNameTv;
        Button mDeleteBtn;
    }
}
