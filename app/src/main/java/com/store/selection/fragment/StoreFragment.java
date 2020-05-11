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
import com.store.selection.adapter.StoreAdapter;
import com.store.selection.bean.Store;
import com.store.selection.bean.User;
import com.store.selection.data.DBManger;

import java.util.List;


public class StoreFragment extends Fragment {

    ListView mListView;

    StoreAdapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragement_store, container, false);
        initView(view);

        return view;
    }

    public static StoreFragment getInstance() {
        return new StoreFragment();
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
        List<Store> mStores = DBManger.getInstance(getContext()).getStoreByLevelFirst();
        mAdapter = new StoreAdapter(getContext(),mStores);
        mListView.setAdapter(mAdapter);
    }




}
