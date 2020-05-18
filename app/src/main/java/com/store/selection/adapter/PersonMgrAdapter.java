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

import com.store.selection.PersonMgrActivity;
import com.store.selection.R;
import com.store.selection.ReportDescribeActivity;
import com.store.selection.UpdateUserActivity;
import com.store.selection.bean.Report;
import com.store.selection.bean.User;
import com.store.selection.data.DBManger;

import java.util.ArrayList;
import java.util.List;

public class PersonMgrAdapter extends BaseAdapter {

    Context mContext;
    List<User> mUsers = new ArrayList<>();


    public PersonMgrAdapter(Context mContext, List<User> mUsers){
        this.mContext = mContext;
        this.mUsers = mUsers;
    }

    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public Object getItem(int i) {
        return mUsers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final User user = mUsers.get(i);
        PersonMgrAdapter.ViewHoler holer = null;
        if (view == null){
            holer = new PersonMgrAdapter.ViewHoler();
            view = LayoutInflater.from(mContext).inflate(R.layout.person_item,null);
            holer.mUserNameTv = (TextView) view.findViewById(R.id.user_name_tv);
            holer.mDeleteBtn = (Button) view.findViewById(R.id.delete_user_btn);
            view.setTag(holer);
        }else{
            holer = (PersonMgrAdapter.ViewHoler) view.getTag();
        }
        holer.mUserNameTv.setText(user.getUserName());
        holer.mDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"删除成功",Toast.LENGTH_LONG).show();
                DBManger.getInstance(mContext).deleteUser(user);
                mUsers.remove(user);
                notifyDataSetChanged();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mContext, UpdateUserActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("user",user);
                intent.putExtras(b);
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    class ViewHoler{
        TextView mUserNameTv;
        Button mDeleteBtn;
    }
}
