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

import com.store.selection.LoginActivity;
import com.store.selection.MainActivity;
import com.store.selection.R;
import com.store.selection.StoreThirdActivity;
import com.store.selection.adapter.StoreLvThirdAdapter;
import com.store.selection.bean.Store;
import com.store.selection.data.DBManger;

import java.util.List;


public class StoreFragment extends Fragment {

    LinearLayout mStoreLayout;

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
        mStoreLayout = view.findViewById(R.id.store_layout);
    };

    public void initData() {
        List<Store> mStores = DBManger.getInstance(getContext()).getStoreByLevelFirst();
        mStoreLayout.removeAllViews();
        for (int i = 0;i<mStores.size();i++){
            final Store store = mStores.get(i);
            View view = LayoutInflater.from(getContext()).inflate(R.layout.store_item,null);
            TextView mFisrtTv = (TextView) view.findViewById(R.id.store_level_1_btn);
            final LinearLayout mSecLayout = (LinearLayout) view.findViewById(R.id.store_level_2_layout);
            mFisrtTv.setText(store.getLevel_First());
            mFisrtTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isShow = mSecLayout.getVisibility()==View.VISIBLE;
                    mSecLayout.setVisibility(!isShow?View.VISIBLE:View.GONE);

                }
            });
            List<String> mSecTitles = store.getLevelSecTitle();
            for (int j=0;j<mSecTitles.size();j++){
                final String title = mSecTitles.get(j);
                Button button = new Button(getContext());
                button.setText(title);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(getContext(),StoreThirdActivity.class);
                        Bundle b = new Bundle();
                        b.putSerializable("lv1",store.getLevel_First());
                        b.putSerializable("lv2",title);
                        intent.putExtras(b);
                        getContext().startActivity(intent);
                    }
                });
                mSecLayout.addView(button);
            }
            mStoreLayout.addView(view);
        }

    }




}
