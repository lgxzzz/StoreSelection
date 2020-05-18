package com.store.selection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.google.gson.Gson;
import com.store.selection.adapter.VillageMgrAdapter;
import com.store.selection.bean.Evaluate;
import com.store.selection.bean.JsonBean;
import com.store.selection.bean.Village;
import com.store.selection.data.DBManger;
import com.store.selection.data.DataBase;
import com.store.selection.util.GetJsonDataUtil;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class AddVillageActivity extends Activity {

    Village mCurrentVillage;

    Button mAddBtn;
    Button mCancelBtn;

    EditText mVillageAddressEd;
    EditText mVillagePositonEd;
    EditText mVillageNameEd;

    Spinner mXiaofeiSp;//消费水平
    Spinner mChengshuduSp;//小区成熟度
    Spinner mTongleiSp;//同类竞争店铺情况
    Spinner mHubuSp;//互补类店铺情况
    Spinner mGongjiaoluxianSp;//范围内公交线路数目
    Spinner mGongjiaoshuliangSp;//范围内公交站数量

    List<String> mXiaofeiData = new ArrayList<>();
    List<String> mChengshuduData =  new ArrayList<>();
    List<String> mTongleiData =  new ArrayList<>();
    List<String> mHubuData = new ArrayList<>();
    List<String> mGongjiaoluxianData = new ArrayList<>();
    List<String> mGongjiaoshuliangData =  new ArrayList<>();

    String mSelectXiaofei;
    String mSelectChengshudu;
    String mSelectTonglei;
    String mSelectHubu;
    String mSelectGongjiaoluxian;
    String mSelectGongjiaoshuliang;

    private List<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_village);


        mCurrentVillage = new Village();
        mCurrentVillage.setVillage_ID(DataBase.getRandomVillage_ID());

        mAddBtn = findViewById(R.id.add_sure_btn);
        mCancelBtn = findViewById(R.id.add_cancel_btn);

        mVillageAddressEd = findViewById(R.id.village_address_ed);
        mVillagePositonEd = findViewById(R.id.village_position_ed);
        mVillageNameEd = findViewById(R.id.village_name_sp);

        mXiaofeiSp = findViewById(R.id.eva_xiaofei_sp);
        mChengshuduSp = findViewById(R.id.eva_chengshudu_sp);
        mTongleiSp = findViewById(R.id.eva_tonglei_sp);
        mHubuSp = findViewById(R.id.eva_hubu_sp);
        mGongjiaoluxianSp = findViewById(R.id.eva_gongjiaoluxian_sp);
        mGongjiaoshuliangSp = findViewById(R.id.eva_gongjiaoshuliang_sp);


        mXiaofeiData = DBManger.getInstance(this).getEvluatesByLv2("消费水平");
        mChengshuduData = DBManger.getInstance(this).getEvluatesByLv2("小区成熟度");
        mTongleiData = DBManger.getInstance(this).getEvluatesByLv2("同类竞争店铺情况");
        mHubuData = DBManger.getInstance(this).getEvluatesByLv2("互补类店铺情况");
        mGongjiaoluxianData = DBManger.getInstance(this).getEvluatesByLv2("范围内公交线路数目");
        mGongjiaoshuliangData = DBManger.getInstance(this).getEvluatesByLv2("范围内公交站数量");

        //省城市县选择
        mVillageAddressEd.setInputType(InputType.TYPE_NULL);
        mVillageAddressEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickerView();
            }
        });


        SpinnerAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mXiaofeiData);
        mXiaofeiSp.setAdapter(adapter);
        mSelectXiaofei = mXiaofeiData.get(0);

        mXiaofeiSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectXiaofei = mXiaofeiData.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinnerAdapter adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mChengshuduData);
        mChengshuduSp.setAdapter(adapter1);

        mSelectChengshudu = mXiaofeiData.get(0);

        mChengshuduSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectChengshudu = mChengshuduData.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinnerAdapter adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mTongleiData);
        mTongleiSp.setAdapter(adapter2);

        mSelectTonglei = mTongleiData.get(0);

        mTongleiSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectTonglei = mTongleiData.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinnerAdapter adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mHubuData);
        mHubuSp.setAdapter(adapter3);

        mSelectHubu = mHubuData.get(0);

        mHubuSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectHubu = mHubuData.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinnerAdapter adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mGongjiaoluxianData);
        mGongjiaoluxianSp.setAdapter(adapter4);

        mSelectGongjiaoluxian = mGongjiaoluxianData.get(0);

        mGongjiaoluxianSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectGongjiaoluxian = mGongjiaoluxianData.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinnerAdapter adapter5 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mGongjiaoshuliangData);
        mGongjiaoshuliangSp.setAdapter(adapter5);

        mSelectGongjiaoshuliang = mGongjiaoshuliangData.get(0);

        mGongjiaoshuliangSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSelectGongjiaoshuliang = mGongjiaoshuliangData.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        mVillagePositonEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mCurrentVillage.setVillage_Position(s.toString());
            }
        });
        mVillagePositonEd.setText("116.472995,39.993743");

        mVillageNameEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mCurrentVillage.setVillage_Name(s.toString());
            }
        });




        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentVillage.getVillage_Name()==null){
                    Toast.makeText(AddVillageActivity.this,"小区名字不能为空！", Toast.LENGTH_LONG).show();
                    return;
                }
                if (mCurrentVillage.getVillage_Position()==null){
                    Toast.makeText(AddVillageActivity.this,"小区位置不能为空！", Toast.LENGTH_LONG).show();
                    return;
                }
                if (mCurrentVillage.getVillage_Address()==null){
                    Toast.makeText(AddVillageActivity.this,"小区地址不能为空！", Toast.LENGTH_LONG).show();
                    return;
                }

                mXiaofeiSp = findViewById(R.id.eva_xiaofei_sp);
                mChengshuduSp = findViewById(R.id.eva_chengshudu_sp);
                mTongleiSp = findViewById(R.id.eva_tonglei_sp);
                mHubuSp = findViewById(R.id.eva_hubu_sp);
                mGongjiaoluxianSp = findViewById(R.id.eva_gongjiaoluxian_sp);
                mGongjiaoshuliangSp = findViewById(R.id.eva_gongjiaoshuliang_sp);

                Evaluate xiaofeiEv = DBManger.getInstance(AddVillageActivity.this).getEvaluateByLv3(mSelectXiaofei);
                Evaluate chengshuduEv = DBManger.getInstance(AddVillageActivity.this).getEvaluateByLv3(mSelectChengshudu);
                Evaluate tongleiEv = DBManger.getInstance(AddVillageActivity.this).getEvaluateByLv3(mSelectTonglei);
                Evaluate hubuEv = DBManger.getInstance(AddVillageActivity.this).getEvaluateByLv3(mSelectHubu);
                Evaluate GongjiaoluxianEv = DBManger.getInstance(AddVillageActivity.this).getEvaluateByLv3(mSelectGongjiaoluxian);
                Evaluate GongjiaoshuliangEv = DBManger.getInstance(AddVillageActivity.this).getEvaluateByLv3(mSelectGongjiaoshuliang);

                mCurrentVillage.getmEvalutes().add(xiaofeiEv);
                mCurrentVillage.getmEvalutes().add(chengshuduEv);
                mCurrentVillage.getmEvalutes().add(tongleiEv);
                mCurrentVillage.getmEvalutes().add(hubuEv);
                mCurrentVillage.getmEvalutes().add(GongjiaoluxianEv);
                mCurrentVillage.getmEvalutes().add(GongjiaoshuliangEv);

                DBManger.getInstance(AddVillageActivity.this).insertVillage(mCurrentVillage);
                Toast.makeText(AddVillageActivity.this,"添加小区信息成功！", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mHandler.sendEmptyMessage(MSG_LOAD_DATA);
    }

    private void showPickerView() {// 弹出选择器

        OptionsPickerView pvOptions = new OptionsPickerBuilder(AddVillageActivity.this, new OnOptionsSelectListener() {
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
                Toast.makeText(AddVillageActivity.this, tx, Toast.LENGTH_SHORT).show();
                mVillageAddressEd.setText(tx);
                mCurrentVillage.setVillage_Address(tx);
            }
        })

                .setTitleText("城市选择")
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

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(AddVillageActivity.this, "province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> cityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String cityName = jsonBean.get(i).getCityList().get(c).getName();
                cityList.add(cityName);//添加城市
                ArrayList<String> city_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                /*if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    city_AreaList.add("");
                } else {
                    city_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                }*/
                city_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                province_AreaList.add(city_AreaList);//添加该省所有地区数据
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

//                        Toast.makeText(getContext(), "Begin Parse Data", Toast.LENGTH_SHORT).show();
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
//                    Toast.makeText(getContext(), "Parse Succeed", Toast.LENGTH_SHORT).show();
                    break;

                case MSG_LOAD_FAILED:
//                    Toast.makeText(getContext(), "Parse Failed", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }
}
