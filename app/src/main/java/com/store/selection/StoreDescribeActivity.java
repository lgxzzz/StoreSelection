package com.store.selection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.store.selection.bean.Evaluate;
import com.store.selection.data.DBManger;

import java.util.ArrayList;
import java.util.List;


public class StoreDescribeActivity extends Activity{

    EditText mStoreTypeEd;

    Spinner mNearMainroadDisSp;
    Spinner mVillageTypeSp;
    Spinner mStoreAddressSp;
    Spinner mStoreVisibleSp;

    Button mSureBtn;

    List<Evaluate> mEvalutes;

    List<String> mNearMainroadDisData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_describe);
        init();
    }

    public void init(){
        mEvalutes = DBManger.getInstance(this).getAllEvalute();


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


        mNearMainroadDisData = getEvaluteByKey("离小区主要出入口的距离");
        SpinnerAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mNearMainroadDisData);
        mNearMainroadDisSp.setAdapter(adapter);
        mNearMainroadDisSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public List<String> getEvaluteByKey(String title_sec){
        List<String> evaluates = new ArrayList<>();
        for (int i =0;i<mEvalutes.size();i++){
            Evaluate evaluate = mEvalutes.get(i);
            if (evaluate.getLevel_Sec().equals(title_sec)){
                evaluates.add(evaluate.getLevel_Third());
            }
        }
        return evaluates;
    }

}
