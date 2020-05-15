package com.store.selection;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.store.selection.adapter.StoreLvThirdAdapter;
import com.store.selection.bean.Evaluate;
import com.store.selection.bean.Store;
import com.store.selection.data.DBManger;

import java.util.List;


public class EvaluteThirdActivity extends Activity{

    ListView mListView;

    StoreLvThirdAdapter mAdapter;

    LinearLayout mStoreLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_lv_third);
        initView();
        initData();
    }

    public void initView(){
        mListView = findViewById(R.id.store_listview);
        mStoreLayout = findViewById(R.id.store_layout);
    };

    public void initData() {
        String lv2 = (String) getIntent().getExtras().getSerializable("lv2");
        List<String> mEvalutes = DBManger.getInstance(this).getEvluatesByLv2(lv2);
        mAdapter = new StoreLvThirdAdapter(this, mEvalutes);
        mListView.setAdapter(mAdapter);

    }

}
