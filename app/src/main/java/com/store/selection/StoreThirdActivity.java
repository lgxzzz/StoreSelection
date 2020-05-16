package com.store.selection;

import android.app.Activity;
import android.content.DialogInterface;
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
import com.store.selection.view.AddStoreDialog;

import java.util.List;


public class StoreThirdActivity extends Activity{

    ListView mListView;

    StoreLvThirdAdapter mAdapter;

    LinearLayout mStoreLayout;

    Button mAddStoreBtn;

    AddStoreDialog mDialog;

    Store mStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_lv_third);
        initView();
        initData();
    }

    public void initView(){
        mListView = findViewById(R.id.store_listview);
        mAddStoreBtn = findViewById(R.id.store_add_btn);
        mStoreLayout = findViewById(R.id.store_layout);
        mDialog = new AddStoreDialog(StoreThirdActivity.this,R.layout.dialog_add_store,true,true);
        mAddStoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.setStore(mStore);
                mDialog.show();
            }
        });

        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                initData();
            }
        });
    };

    public void initData() {
        String lv1 = (String) getIntent().getExtras().getSerializable("lv1");
        String lv2 = (String) getIntent().getExtras().getSerializable("lv2");
        mStore = new Store();
        mStore.setLevel_First(lv1);
        mStore.setLevel_Sec(lv2);
        List<String> mStores = DBManger.getInstance(this).getStoresByLv2(lv2);
        mAdapter = new StoreLvThirdAdapter(this, mStores);
        mListView.setAdapter(mAdapter);

    }

}
