package com.store.selection.data;

import android.content.Context;

import com.store.selection.bean.Evaluate;
import com.store.selection.bean.Report;
import com.store.selection.bean.Village;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReportMgr {
    public Context mContext;
    public  Report mCurrentReport;
    public Village mCurrentVillage;
    public HashMap<String,Evaluate> mUserChooseEvalutes = new HashMap<>();
    public ReportMgr(Context mContext){
        this.mContext = mContext;
    }

    public void setVillageToCreateReport(Village village){
        mCurrentVillage = village;
    }

    //用户选择的评价标准
    public void updateUserChooseEvalute(Evaluate evaluate){
        mUserChooseEvalutes.put(evaluate.getLevel_Sec(),evaluate);
    }

    public void insertReport(){
        mCurrentReport = new Report();
    }

    public Report createReport(){
        mCurrentReport = new Report();
        mCurrentReport.setReport_Time(System.currentTimeMillis()+"");
        mCurrentReport.setVillage(mCurrentVillage);
        //合并所有评价
        List<Evaluate> mEvalutes = mCurrentVillage.getmEvalutes();
        Iterator<Map.Entry<String,Evaluate>> iter = mUserChooseEvalutes.entrySet()
                .iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Evaluate evaluate = (Evaluate)entry.getValue();
            mEvalutes.add(evaluate);
        }
        mCurrentReport.setmEvalutes(mEvalutes);
        return mCurrentReport;
    }

    //生成随机index id
    public static String getRandomReport_ID(){
        String strRand="R" ;
        for(int i=0;i<10;i++){
            strRand += String.valueOf((int)(Math.random() * 10)) ;
        }
        return strRand;
    }
}
