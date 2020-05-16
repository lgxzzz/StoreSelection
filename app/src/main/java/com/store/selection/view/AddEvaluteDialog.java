package com.store.selection.view;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.store.selection.R;
import com.store.selection.bean.Evaluate;
import com.store.selection.bean.Store;
import com.store.selection.data.DBManger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEvaluteDialog extends Dialog {

    private boolean iscancelable;//控制点击dialog外部是否dismiss
    private boolean isBackCancelable;//控制返回键是否dismiss
    private View view;
    private Context context;
    private Button mAddBtn;
    private Button mCanceleBtn;
    private EditText mStoreLv3Ed;
    private EditText mStoreLv3WeightEd;
    Evaluate mEvaluate;

    public AddEvaluteDialog(Context context, int layoutid, boolean isCancelable, boolean isBackCancelable) {
        super(context, R.style.MyDialog);

        this.context = context;
        this.view = LayoutInflater.from(context).inflate(layoutid, null);
        this.iscancelable = isCancelable;
        this.isBackCancelable = isBackCancelable;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(view);//这行一定要写在前面
        setCancelable(iscancelable);//点击外部不可dismiss
        setCanceledOnTouchOutside(isBackCancelable);


    }

    public void setEvaluate(Evaluate evaluate){
        this.mEvaluate = evaluate;
        mStoreLv3Ed = view.findViewById(R.id.add_eva_lv3_ed);
        mStoreLv3WeightEd = view.findViewById(R.id.add_eva_weight_ed);
        mAddBtn = view.findViewById(R.id.add_sure_btn);
        mCanceleBtn = view.findViewById(R.id.add_cancel_btn);


        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newLv3 = mStoreLv3Ed.getEditableText().toString();
                String weight = mStoreLv3WeightEd.getEditableText().toString();
                if (newLv3.length()==0){
                    Toast.makeText(getContext(),"店铺名不能为空！",Toast.LENGTH_LONG).show();
                    return;
                }
                if (weight.length()==0){
                    Toast.makeText(getContext(),"权重不能为空！",Toast.LENGTH_LONG).show();
                    return;
                }
                mEvaluate.setLevel_Third(newLv3);
                mEvaluate.setWeight(weight);
                DBManger.getInstance(getContext()).insertEvalute(mEvaluate, new DBManger.IListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getContext(),"添加成功！",Toast.LENGTH_LONG).show();
                        AddEvaluteDialog.this.dismiss();
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(getContext(),error,Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        mCanceleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddEvaluteDialog.this.dismiss();
            }
        });
    }
}