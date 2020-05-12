package com.store.selection.bean;

import java.util.ArrayList;
import java.util.List;

public class Report {
    //报告ID
    String Report_ID;

    //报告日期
    String Report_Time;

    //指标参数
    List<Evaluate> mEvalutes = new ArrayList<>();
}
