package com.store.selection;

import android.app.Activity;
import android.arch.lifecycle.ReportFragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.store.selection.bean.Report;
import com.store.selection.data.DBManger;
import com.store.selection.fragment.ReportHistoryFragment;

import java.util.List;
import java.util.zip.Inflater;


public class SelectReportActivity extends Activity{

    LinearLayout mSelectReportLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_report);
        init();
    }

    public void init(){
        mSelectReportLayout = findViewById(R.id.select_report_layout);

        List<Report> mSelectReports = ReportHistoryFragment.mSelectReport;

        for (int i=0;i<mSelectReports.size();i++){
            Report report = mSelectReports.get(i);
            View view = LayoutInflater.from(SelectReportActivity.this).inflate(R.layout.activity_report_detail,null);

            LinearLayout mLv1Layout;
            LinearLayout mLv2Layout;
            TextView mFinalTv;
            TextView mVillageNameTv;

            mLv1Layout = view.findViewById(R.id.report_lv1_layout);
            mLv2Layout = view.findViewById(R.id.report_lv2_layout);
            mFinalTv = view.findViewById(R.id.report_final_tv);
            mVillageNameTv = view.findViewById(R.id.village_name_tv);

            String[] EvaluteLv1 = report.getEvaluteLv1();
            for (int j=0;j<EvaluteLv1.length;j++){
                TextView textView = new TextView(getApplicationContext());
                textView.setText(EvaluteLv1[j]);
                mLv1Layout.addView(textView);
            }

            String[] EvaluteLv2 = report.getEvaluteLv2();
            for (int k=0;k<EvaluteLv2.length;k++){
                TextView textView = new TextView(getApplicationContext());
                textView.setText(EvaluteLv2[k]);
                mLv2Layout.addView(textView);
            }

            mFinalTv.setText(report.getFinal());
            mVillageNameTv.setText(report.getVillage().getVillage_Name());
            mSelectReportLayout.addView(view);
        }

    }


}
