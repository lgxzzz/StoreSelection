package com.store.selection;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.store.selection.adapter.VillageMgrAdapter;
import com.store.selection.bean.Village;
import com.store.selection.data.DBManger;

import java.util.ArrayList;
import java.util.List;

public class AddVillageActivity extends Activity {

    Button mAddBtn;
    Button mCancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_village);

        mAddBtn = findViewById(R.id.add_sure_btn);
        mCancelBtn = findViewById(R.id.add_cancel_btn);

    }
}
