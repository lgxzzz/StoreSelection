package com.store.selection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.store.selection.adapter.StoreLvThirdAdapter;
import com.store.selection.bean.Store;
import com.store.selection.data.DBManger;

import java.util.List;


public class StoreThirdActivity extends Activity{

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
        Store store = (Store) getIntent().getExtras().getSerializable("store");
        mAdapter = new StoreLvThirdAdapter(this, store.getLevelThirdTitle());
        mListView.setAdapter(mAdapter);

    }

}
