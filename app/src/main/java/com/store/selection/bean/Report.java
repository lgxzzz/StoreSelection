package com.store.selection.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Report implements Serializable {
    //报告ID
    String Report_ID;

    //报告日期
    String Report_Time;

    //小区信息
    Village village;

    //指标集合
    String Report_Evalute;

    //指标参数
    List<Evaluate> mEvalutes = new ArrayList<>();

    //店铺信息
    Store  store;

    public String getReport_ID() {
        return Report_ID;
    }

    public void setReport_ID(String report_ID) {
        Report_ID = report_ID;
    }

    public String getReport_Time() {
        return Report_Time;
    }

    public void setReport_Time(String report_Time) {
        Report_Time = report_Time;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public String getReport_Evalute() {
        return Report_Evalute;
    }

    public void setReport_Evalute(String report_Evalute) {
        Report_Evalute = report_Evalute;
    }

    public List<Evaluate> getmEvalutes() {
        return mEvalutes;
    }

    public void setmEvalutes(List<Evaluate> mEvalutes) {
        this.mEvalutes = mEvalutes;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String[] getEvaluteLv1(){
        String[] reportLv1 = new String[3];
        int person_point = 0;
        int evirment_point = 0;
        int traffic_point = 0;
        for (int i=0;i<mEvalutes.size();i++){
            Evaluate evaluate = mEvalutes.get(i);
            if (evaluate.getLevel_First().equals("人流因素")){
                person_point = person_point+ Integer.parseInt(evaluate.getWeight());
            }else  if (evaluate.getLevel_First().equals("环境因素")){
                evirment_point = evirment_point+ Integer.parseInt(evaluate.getWeight());
            }else  if (evaluate.getLevel_First().equals("交通因素")){
                traffic_point = traffic_point+ Integer.parseInt(evaluate.getWeight());
            }
        }
        reportLv1[0] = "人流因素:"+person_point;
        reportLv1[1] = "环境因素:"+evirment_point;
        reportLv1[2] = "交通因素:"+traffic_point;
        return reportLv1;
    }

    public String[] getEvaluteLv2(){
        String[] reportLv2 = new String[mEvalutes.size()];
        for (int i=0;i<reportLv2.length;i++){
            Evaluate evaluate = mEvalutes.get(i);
            reportLv2[i] = evaluate.getLevel_Sec()+":"+evaluate.getLevel_Third()+" 分数："+evaluate.getWeight();
        }
        return reportLv2;
    }

    public String getStoreInfo(){
        if (store!=null){
            String info = store.getLevel_First()+store.getLevel_Sec()+store.getLevel_Third();
            return info;
        }
        return "无";
    }

    //最终评价
    public String getFinal(){
        String finaltv = "无";
        int person_point = 0;
        int evirment_point = 0;
        int traffic_point = 0;
        for (int i=0;i<mEvalutes.size();i++){
            Evaluate evaluate = mEvalutes.get(i);
            if (evaluate.getLevel_First().equals("人流因素")){
                person_point = person_point+ Integer.parseInt(evaluate.getWeight());
            }else  if (evaluate.getLevel_First().equals("环境因素")){
                evirment_point = evirment_point+ Integer.parseInt(evaluate.getWeight());
            }else  if (evaluate.getLevel_First().equals("交通因素")){
                traffic_point = traffic_point+ Integer.parseInt(evaluate.getWeight());
            }
        }

        int count = person_point+evirment_point+traffic_point;
        if (count<5){
            finaltv = "不推荐";
        }else if(count >10 && count<15){
            finaltv = "良好";
        }else {
            finaltv = "推荐";
        }
        return finaltv;
    }
}
