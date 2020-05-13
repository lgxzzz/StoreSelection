package com.store.selection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.store.selection.data.DBManger;


public class StoreDescribeActivity extends Activity{

    EditText mStoreTypeEd;

    Spinner mNearMainroadDisSp;
    Spinner mVillageTypeSp;
    Spinner mStoreAddressSp;
    Spinner mStoreVisibleSp;

    Button mSureBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_describe);
        init();
    }

    public void init(){

        mStoreTypeEd = findViewById(R.id.store_type_ed);
        mNearMainroadDisSp = findViewById(R.id.store_near_mainroad_dis_sp);
        mVillageTypeSp = findViewById(R.id.village_type_sp);
        mStoreAddressSp = findViewById(R.id.store_address_sp);
        mStoreVisibleSp = findViewById(R.id.store_visible_sp);

        mSureBtn = findViewById(R.id.store_detail_btn);
        mSureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
