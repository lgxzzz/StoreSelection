package com.store.selection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.google.gson.Gson;
import com.store.selection.bean.Evaluate;
import com.store.selection.bean.JsonBean;
import com.store.selection.bean.Store;
import com.store.selection.data.DBManger;
import com.store.selection.util.GetJsonDataUtil;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class StoreDescribeActivity extends Activity{

    EditText mStoreTypeEd;

    Spinner mNearMainroadDisSp;
    Spinner mVillageTypeSp;
    Spinner mStoreAddressSp;
    Spinner mStoreVisibleSp;

    Button mSureBtn;

    List<Evaluate> mAllEvalutes;
    public HashMap<String,Evaluate> mUserChooseEvalutes = new HashMap<>();

    List<String> mNearMainroadDisData;
    List<String> mVillageTypeData;
    List<String> mStoreAddressData;
    List<String> mStoreVisibleData;

    private List<Store> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;

    private static boolean isLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_describe);
        init();
    }

    public void init(){
        mAllEvalutes = DBManger.getInstance(this).getAllEvalute();


        mStoreTypeEd = findViewById(R.id.store_type_ed);
        mNearMainroadDisSp = findViewById(R.id.store_near_mainroad_dis_sp);
        mVillageTypeSp = findViewById(R.id.village_type_sp);
        mStoreAddressSp = findViewById(R.id.store_address_sp);
        mStoreVisibleSp = findViewById(R.id.store_visible_sp);

        mSureBtn = findViewById(R.id.store_detail_btn);
        mSureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        mNearMainroadDisData = getEvaluteByLv2("离小区主要出入口的距离");
        SpinnerAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mNearMainroadDisData);
        mNearMainroadDisSp.setAdapter(adapter);
        mNearMainroadDisSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 String lv3 = mNearMainroadDisData.get(i);
                 Evaluate evaluate = getEvaluteByLv3(lv3);
                mUserChooseEvalutes.put("离小区主要出入口的距离",evaluate);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mVillageTypeData = getEvaluteByLv2("房屋类型");
        SpinnerAdapter adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mVillageTypeData);
        mVillageTypeSp.setAdapter(adapter1);
        mVillageTypeSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String lv3 = mVillageTypeData.get(i);
                Evaluate evaluate = getEvaluteByLv3(lv3);
                mUserChooseEvalutes.put("房屋类型",evaluate);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mStoreAddressData = getEvaluteByLv2("门店的位置");
        SpinnerAdapter adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mStoreAddressData);
        mStoreAddressSp.setAdapter(adapter2);
        mStoreAddressSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String lv3 = mStoreAddressData.get(i);
                Evaluate evaluate = getEvaluteByLv3(lv3);
                mUserChooseEvalutes.put("门店的位置",evaluate);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        mStoreVisibleData = getEvaluteByLv2("门店可视性");
        SpinnerAdapter adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mStoreVisibleData);
        mStoreVisibleSp.setAdapter(adapter3);
        mStoreVisibleSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String lv3 = mStoreVisibleData.get(i);
                Evaluate evaluate = getEvaluteByLv3(lv3);
                mUserChooseEvalutes.put("门店可视性",evaluate);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mSureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBManger.getInstance(getBaseContext()).mReportMgr.mUserChooseEvalutes = mUserChooseEvalutes;
                finish();
            }
        });

        mHandler.sendEmptyMessage(MSG_LOAD_DATA);
    }

    public List<String> getEvaluteByLv2(String title_sec){
        List<String> evaluates = new ArrayList<>();
        for (int i =0;i<mAllEvalutes.size();i++){
            Evaluate evaluate = mAllEvalutes.get(i);
            if (evaluate.getLevel_Sec().equals(title_sec)){
                evaluates.add(evaluate.getLevel_Third());
            }
        }
        return evaluates;
    }

    public Evaluate getEvaluteByLv3(String title_third){
        List<String> evaluates = new ArrayList<>();
        for (int i =0;i<mAllEvalutes.size();i++){
            Evaluate evaluate = mAllEvalutes.get(i);
            if (evaluate.getLevel_Third().equals(title_third)){
               return evaluate;
            }
        }
        return null;
    }

    private void showPickerView() {// 弹出选择器

        OptionsPickerView pvOptions = new OptionsPickerBuilder(StoreDescribeActivity.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String opt1tx = options1Items.size() > 0 ?
                        options1Items.get(options1).getPickerViewText() : "";

                String opt2tx = options2Items.size() > 0
                        && options2Items.get(options1).size() > 0 ?
                        options2Items.get(options1).get(options2) : "";

                String opt3tx = options2Items.size() > 0
                        && options3Items.get(options1).size() > 0
                        && options3Items.get(options1).get(options2).size() > 0 ?
                        options3Items.get(options1).get(options2).get(options3) : "";

                String tx = opt1tx + opt2tx + opt3tx;
                Toast.makeText(StoreDescribeActivity.this, tx, Toast.LENGTH_SHORT).show();
                mStoreTypeEd.setText(tx);
            }
        })

                .setTitleText("店铺类型选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    private void initJsonData() {//解析数据


        options1Items = DBManger.getInstance(this).getStoreByLevelFirst();

        for (int i = 0; i < options1Items.size(); i++) {
            ArrayList<String> cityList =options1Items.get(i).getLevelSecTitle();
            ArrayList<ArrayList<String>> province_AreaList = new ArrayList<>();

            for (int c = 0; c < cityList.size(); c++) {
                String cityName = cityList.get(c);
                ArrayList<String> city_AreaList = new ArrayList<>();

                for (int j =0;j<options1Items.get(i).getLevelThirdTitle().size();j++){
                    city_AreaList.add(options1Items.get(i).getLevelThirdTitle().get(j));
                }
                province_AreaList.add(city_AreaList);
            }

            /**
             * 添加城市数据
             */
            options2Items.add(cityList);

            /**
             * 添加地区数据
             */
            options3Items.add(province_AreaList);
        }

        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS);

    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread == null) {//如果已创建就不再重新创建子线程了

                        Toast.makeText(StoreDescribeActivity.this, "Begin Parse Data", Toast.LENGTH_SHORT).show();
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // 子线程中解析省市区数据
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;

                case MSG_LOAD_SUCCESS:
                    Toast.makeText(StoreDescribeActivity.this, "Parse Succeed", Toast.LENGTH_SHORT).show();
                    isLoaded = true;
                    break;

                case MSG_LOAD_FAILED:
                    Toast.makeText(StoreDescribeActivity.this, "Parse Failed", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
