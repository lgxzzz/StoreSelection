package com.store.selection.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.store.selection.PersonMgrActivity;
import com.store.selection.R;
import com.store.selection.UpdateUserActivity;
import com.store.selection.VillageMgrActivity;
import com.store.selection.bean.User;
import com.store.selection.data.DBManger;


public class AboutFragment extends Fragment {

    //个人信息
    TextView mUserID;
    TextView mUserName;
    TextView mUserTel;
    TextView mUserMail;
    Button mUpdateBtn;
    Button mAddVillageBtn;
    Button mAddPersonBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragement_about, container, false);
        initView(view);

        return view;
    }

    public static AboutFragment getInstance() {
        return new AboutFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    public void initView(View view){
        mUserID = view.findViewById(R.id.user_id);
        mUserName = view.findViewById(R.id.user_name);
        mUserTel = view.findViewById(R.id.user_tel);
        mUserMail = view.findViewById(R.id.user_mail);
        mUpdateBtn = view.findViewById(R.id.user_update_btn);
        mAddVillageBtn = view.findViewById(R.id.add_village_btn);
        mAddPersonBtn = view.findViewById(R.id.add_person_btn);

    };

    public void initData() {
        final User user = DBManger.getInstance(getContext()).mUser;
        mUserID.setText(user.getUserId());
        mUserName.setText(user.getUserName());
        mUserMail.setText(user.getMail());
        mUserTel.setText(user.getTelephone());

        if (user.getRole().equals("普通用户")){
            mAddPersonBtn.setVisibility(View.GONE);
            mAddVillageBtn.setVisibility(View.GONE);
        }

        mUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), UpdateUserActivity.class));
            }
        });

        mAddVillageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), VillageMgrActivity.class));
            }
        });

        mAddPersonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PersonMgrActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("user",user);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }




}
