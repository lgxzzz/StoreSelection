package com.store.selection.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Village implements Serializable{
    //小区ID
    String Village_ID;
    //小区名字
    String Village_Name;
    //小区地址  省+市+县
    String Village_Address;
    //小区经纬度
    String Village_Position;
    //指标集合
    String Village_Evalute;
    //指标参数
    List<Evaluate> mEvalutes = new ArrayList<>();

    public void insertEvalute(Evaluate evaluate){

    }

    public String getVillage_Position() {
        return Village_Position;
    }

    public void setVillage_Position(String village_Position) {
        Village_Position = village_Position;
    }

    public String getVillage_ID() {
        return Village_ID;
    }

    public void setVillage_ID(String village_ID) {
        Village_ID = village_ID;
    }

    public String getVillage_Name() {
        return Village_Name;
    }

    public void setVillage_Name(String village_Name) {
        Village_Name = village_Name;
    }

    public String getVillage_Address() {
        return Village_Address;
    }

    public void setVillage_Address(String village_Address) {
        Village_Address = village_Address;
    }

    public String getVillage_Evalute() {
        return Village_Evalute;
    }

    public void setVillage_Evalute(String village_Evalute) {
        Village_Evalute = village_Evalute;
    }

    public List<Evaluate> getmEvalutes() {
        return mEvalutes;
    }

    public void setmEvalutes(List<Evaluate> mEvalutes) {
        this.mEvalutes = mEvalutes;
    }
}
