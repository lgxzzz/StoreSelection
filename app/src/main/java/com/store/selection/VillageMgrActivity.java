package com.store.selection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.store.selection.adapter.PersonMgrAdapter;
import com.store.selection.adapter.VillageAdapter;
import com.store.selection.adapter.VillageMgrAdapter;
import com.store.selection.bean.User;
import com.store.selection.bean.Village;
import com.store.selection.data.DBManger;

import java.util.ArrayList;
import java.util.List;

public class VillageMgrActivity extends Activity {

    ListView mPersonListview;

    List<Village> mAllVillage = new ArrayList<>();

    VillageMgrAdapter mAdapter;

    Button mAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village_mgr);

        mAddBtn = findViewById(R.id.village_add_btn);
        mPersonListview = findViewById(R.id.village_listview);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mAllVillage = DBManger.getInstance(this).getAllVillges();

        mAdapter = new VillageMgrAdapter(this,mAllVillage);
        mPersonListview.setAdapter(mAdapter);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VillageMgrActivity.this,AddVillageActivity.class));
            }
        });
    }
}
