package com.store.selection.data;

import android.content.Context;

import com.store.selection.bean.Report;

public class ReportMgr {
    private Context mContext;
    private Report mCurrentReport;

    public ReportMgr(Context mContext){
        this.mContext = mContext;
    }
}
