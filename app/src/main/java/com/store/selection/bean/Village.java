package com.store.selection.bean;

import java.util.ArrayList;
import java.util.List;

public class Village {
    //小区ID
    String Village_ID;
    //小区名字
    String Village_Name;
    //小区地址
    String Village_Address;
    //指标集合
    String Village_Evalute;
    //指标参数
    List<Evaluate> mEvalutes = new ArrayList<>();

    public void insertEvalute(Evaluate evaluate){

    }
}
