package com.store.selection.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.store.selection.R;
import com.store.selection.adapter.EvaluteAdapter;
import com.store.selection.adapter.StoreAdapter;
import com.store.selection.bean.Evaluate;
import com.store.selection.bean.Store;
import com.store.selection.data.DBManger;

import java.util.List;


public class EvaluteFragment extends Fragment {

    ListView mListView;

    EvaluteAdapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragement_evalute, container, false);
        initView(view);

        return view;
    }

    public static EvaluteFragment getInstance() {
        return new EvaluteFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    public void initView(View view){
        mListView = view.findViewById(R.id.store_listview);
    };

    public void initData() {
        List<Evaluate> mEvalutes = DBManger.getInstance(getContext()).getEvaluteByLevelFirst();
        mAdapter = new EvaluteAdapter(getContext(),mEvalutes);
        mListView.setAdapter(mAdapter);
    }




}
