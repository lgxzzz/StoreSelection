package com.store.selection.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.store.selection.R;
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
    };

    public void initData() {
        mReport = DBManger.getInstance(getContext()).getAllReports();
        mAdapter = new ReportAdapter(getContext(),mReport);
        mListView.setAdapter(mAdapter);
    }




}
