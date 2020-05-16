package com.store.selection.view;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.store.selection.R;
import com.store.selection.bean.Store;
import com.store.selection.data.DBManger;
import com.store.selection.fragment.AddressFragment;

public class AddStoreDialog extends Dialog {

    private boolean iscancelable;//控制点击dialog外部是否dismiss
    private boolean isBackCancelable;//控制返回键是否dismiss
    private View view;
    private Context context;
    private Button mAddBtn;
    private Button mCanceleBtn;
    private EditText mStoreLv3Ed;
    private EditText mStoreLv3WeightEd;
    Store mStore;

    public AddStoreDialog(Context context, int layoutid, boolean isCancelable, boolean isBackCancelable) {
        super(context, R.style.MyDialog);

        this.context = context;
        this.view = LayoutInflater.from(context).inflate(layoutid, null);
        this.iscancelable = isCancelable;
        this.isBackCancelable = isBackCancelable;

    }

    public void setStore(Store store){
        this.mStore = store;
        mStoreLv3Ed = view.findViewById(R.id.add_store_lv3_ed);
        mStoreLv3WeightEd = view.findViewById(R.id.add_store_weight_ed);
        mAddBtn = view.findViewById(R.id.add_sure_btn);
        mCanceleBtn = view.findViewById(R.id.add_cancel_btn);


        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newLv3 = mStoreLv3Ed.getEditableText().toString();
                if (newLv3.length()==0){
                    Toast.makeText(getContext(),"店铺名不能为空！",Toast.LENGTH_LONG).show();
                    return;
                }
                mStore.setLevel_Third(newLv3);
                DBManger.getInstance(getContext()).insertStore(mStore, new DBManger.IListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getContext(),"添加成功！",Toast.LENGTH_LONG).show();
                        AddStoreDialog.this.dismiss();
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
                AddStoreDialog.this.dismiss();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(view);//这行一定要写在前面
        setCancelable(iscancelable);//点击外部不可dismiss
        setCanceledOnTouchOutside(isBackCancelable);


    }



}