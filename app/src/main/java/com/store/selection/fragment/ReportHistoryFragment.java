package com.store.selection.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.store.selection.R;
import com.store.selection.ReportDescribeActivity;
import com.store.selection.SelectReportActivity;
import com.store.selection.adapter.EvaluteAdapter;
import com.store.selection.adapter.ReportAdapter;
import com.store.selection.bean.Report;
import com.store.selection.bean.User;
import com.store.selection.data.DBManger;

import java.util.ArrayList;
import java.util.List;


public class ReportHistoryFragment extends Fragment {

    ListView mListView;

    ReportAdapter mAdapter;

    List<Report> mReport = new ArrayList<>();
    //选择的报告
    public static List<Report> mSelectReport = new ArrayList<>();

    LinearLayout mSelectLayout;

    Button mSureBtn;
    Button mCancelBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_report_his, container, false);
        initView(view);

        return view;
    }

    public static ReportHistoryFragment getInstance() {
        return new ReportHistoryFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    public void initView(View view){
        mListView  = view.findViewById(R.id.report_listview);
        mSelectLayout = view.findViewById(R.id.select_layout);
        mSureBtn = view.findViewById(R.id.select_sure_btn);
        mCancelBtn = view.findViewById(R.id.select_cancel_btn);
    };

    public void initData() {
        mSelectReport.clear();
        mSelectLayout.setVisibility(View.GONE);
        mReport = DBManger.getInstance(getContext()).getAllReports();
        mAdapter = new ReportAdapter(getContext(),mReport);
        mAdapter.setOnShowItemClickListener(new ReportAdapter.OnShowItemClickListener() {
            @Override
            public void onShowItemClick(Report bean) {
                mSelectReport.add(bean);
            }
        });
        mListView.setAdapter(mAdapter);

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mSelectLayout.setVisibility(View.VISIBLE);
                mAdapter.setSelect(true);
                return false;
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!mAdapter.isSelect()){
                    Report report = mReport.get(position);
                    Intent intent = new Intent();
                    intent.setClass(getContext(), ReportDescribeActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("report",report);
                    intent.putExtras(b);
                    getContext().startActivity(intent);
                }
            }
        });



        mSureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), SelectReportActivity.class);
                getContext().startActivity(intent);
            }
        });

        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectReport.clear();
                mAdapter.setSelect(false);
                mSelectLayout.setVisibility(View.GONE);
            }
        });
    }




}
