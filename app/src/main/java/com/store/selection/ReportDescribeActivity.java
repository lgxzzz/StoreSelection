package com.store.selection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.store.selection.bean.Evaluate;
import com.store.selection.bean.Report;
import com.store.selection.bean.Store;
import com.store.selection.data.DBManger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReportDescribeActivity extends Activity{

    LinearLayout mLv1Layout;
    LinearLayout mLv2Layout;
    TextView mFinalTv;
    TextView mVillageNameTv;

    Report mReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_detail);
        init();
    }

    public void init(){
        mLv1Layout = findViewById(R.id.report_lv1_layout);
        mLv2Layout = findViewById(R.id.report_lv2_layout);
        mFinalTv = findViewById(R.id.report_final_tv);
        mVillageNameTv = findViewById(R.id.village_name_tv);

        mReport =  (Report) getIntent().getExtras().getSerializable("report");

        String[] EvaluteLv1 = mReport.getEvaluteLv1();
        for (int i=0;i<EvaluteLv1.length;i++){
            TextView textView = new TextView(getApplicationContext());
            textView.setText(EvaluteLv1[i]);
            mLv1Layout.addView(textView);
        }

        String[] EvaluteLv2 = mReport.getEvaluteLv2();
        for (int i=0;i<EvaluteLv2.length;i++){
            TextView textView = new TextView(getApplicationContext());
            textView.setText(EvaluteLv2[i]);
            mLv2Layout.addView(textView);
        }
        mVillageNameTv.setText(mReport.getVillage().getVillage_Name());
        mFinalTv.setText(mReport.getFinal());
    }


}
