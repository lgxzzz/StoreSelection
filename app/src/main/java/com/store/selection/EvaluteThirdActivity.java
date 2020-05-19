package com.store.selection;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.store.selection.adapter.StoreLvThirdAdapter;
import com.store.selection.bean.Evaluate;
import com.store.selection.bean.Store;
import com.store.selection.data.DBManger;
import com.store.selection.view.AddEvaluteDialog;
import com.store.selection.view.AddStoreDialog;

import java.util.List;


public class EvaluteThirdActivity extends Activity{

    ListView mListView;

    StoreLvThirdAdapter mAdapter;

    AddEvaluteDialog mDialog;

    Button mAddBtn;

    Evaluate mEvalute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evalute_lv_third);
        initView();
        initData();
    }

    public void initView(){
        mListView = findViewById(R.id.eva_listview);
        mAddBtn = findViewById(R.id.eva_add_btn);
        mDialog = new AddEvaluteDialog(EvaluteThirdActivity.this,R.layout.dialog_add_evluate ,true,true);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.setEvaluate(mEvalute);
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
        Evaluate evaluate = (Evaluate) getIntent().getExtras().getSerializable("evaluate");
        mEvalute = new Evaluate();
        mEvalute.setLevel_First(lv1);
        mEvalute.setLevel_Sec(lv2);
        mEvalute.setLv1_weight(evaluate.getLv1_weight());
        mEvalute.setLv2_weight(evaluate.getLv2_weight());
        List<String> mEvalutes = DBManger.getInstance(this).getEvluatesByLv2(lv2);
        mAdapter = new StoreLvThirdAdapter(this, mEvalutes);
        mListView.setAdapter(mAdapter);

    }

}
