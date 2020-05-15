package com.store.selection.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.store.selection.EvaluteThirdActivity;
import com.store.selection.R;
import com.store.selection.StoreThirdActivity;
import com.store.selection.adapter.EvaluteAdapter;
import com.store.selection.bean.Evaluate;
import com.store.selection.bean.Store;
import com.store.selection.data.DBManger;

import java.util.List;


public class EvaluteFragment extends Fragment {

    ListView mListView;

    EvaluteAdapter mAdapter;

    LinearLayout mEvaluteLayout;

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
        mEvaluteLayout = view.findViewById(R.id.evalute_layout);
    };

    public void initData() {
        List<Evaluate> mEvalutes = DBManger.getInstance(getContext()).getEvaluteByLevelFirst();
        mEvaluteLayout.removeAllViews();
        for (int i = 0;i<mEvalutes.size();i++){
            final Evaluate evaluate = mEvalutes.get(i);
            View view = LayoutInflater.from(getContext()).inflate(R.layout.store_item,null);
            TextView mFisrtTv = (TextView) view.findViewById(R.id.store_level_1_btn);
            final LinearLayout mSecLayout = (LinearLayout) view.findViewById(R.id.store_level_2_layout);
            mFisrtTv.setText(evaluate.getLevel_First());
            mFisrtTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isShow = mSecLayout.getVisibility()==View.VISIBLE;
                    mSecLayout.setVisibility(!isShow?View.VISIBLE:View.GONE);

                }
            });
            List<String> mSecTitles = evaluate.getLevelSecTitle();
            for (int j=0;j<mSecTitles.size();j++){
                final String titile = mSecTitles.get(j);
                Button button = new Button(getContext());
                button.setText(titile);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(getContext(),EvaluteThirdActivity.class);
                        Bundle b = new Bundle();
                        b.putSerializable("evaluate",evaluate);
                        b.putSerializable("lv2",titile);
                        intent.putExtras(b);
                        getContext().startActivity(intent);
                    }
                });
                mSecLayout.addView(button);
            }
            mEvaluteLayout.addView(view);
        }

    }




}
