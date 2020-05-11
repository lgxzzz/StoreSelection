package com.store.selection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.store.selection.R;
import com.store.selection.bean.Evaluate;
import com.store.selection.bean.Store;

import java.util.ArrayList;
import java.util.List;

public class EvaluteAdapter extends BaseAdapter {

    Context mContext;
    List<Evaluate> mEvalutes = new ArrayList<>();


    public EvaluteAdapter(Context mContext, List<Evaluate> mEvalutes){
        this.mContext = mContext;
        this.mEvalutes = mEvalutes;
    }

    @Override
    public int getCount() {
        return mEvalutes.size();
    }

    @Override
    public Object getItem(int i) {
        return mEvalutes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Evaluate evaluate = mEvalutes.get(i);
        EvaluteAdapter.ViewHoler holer = null;
        if (view == null){
            holer = new EvaluteAdapter.ViewHoler();
            view = LayoutInflater.from(mContext).inflate(R.layout.store_item,null);
            holer.mFisrtTv = (TextView) view.findViewById(R.id.store_level_1_btn);
            holer.mSecLayout = (LinearLayout) view.findViewById(R.id.store_level_2_layout);
            view.setTag(holer);
        }else{
            holer = (EvaluteAdapter.ViewHoler) view.getTag();
        }

        holer.mFisrtTv.setText(evaluate.getLevel_First());
        List<String> mSecTitles = evaluate.getLevelSecTitle();
        for (int j=0;j<mSecTitles.size();j++){
            Button button = new Button(mContext);
            button.setText(mSecTitles.get(j));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转三级界面
                }
            });
            holer.mSecLayout.addView(button);
        }
        return view;
    }

    class ViewHoler{
        TextView mFisrtTv;
        LinearLayout mSecLayout;
    }
}
