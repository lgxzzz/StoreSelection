package com.store.selection;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.store.selection.adapter.PersonMgrAdapter;
import com.store.selection.bean.User;
import com.store.selection.data.DBManger;

import java.util.ArrayList;
import java.util.List;

public class PersonMgrActivity extends Activity {

    ListView mPersonListview;

    List<User> mAllUser = new ArrayList<>();

    PersonMgrAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_mgr);

        mPersonListview = findViewById(R.id.person_mgr_listview);

        mAllUser = DBManger.getInstance(this).getAllUsers();

        User user = DBManger.getInstance(this).mUser;
        for (int i=0;i<mAllUser.size();i++){
            User temp = mAllUser.get(i);
            if (temp.getUserId().equals(user.getUserId())){
                mAllUser.remove(temp);
                break;
            }
        }

        mAdapter = new PersonMgrAdapter(this,mAllUser);
        mPersonListview.setAdapter(mAdapter);
    }
}
