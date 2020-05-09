package com.store.selection.bean;

import java.util.ArrayList;
import java.util.List;

public class EvaluateIndex {
    //指数id
    String index_id;
    //因素类型
    String factor_type;
    //指数标题
    String index_title;
    //
    List<EvaluateIndexParams> mParams = new ArrayList<>();

    public String getIndex_id() {
        return index_id;
    }

    public void setIndex_id(String index_id) {
        this.index_id = index_id;
    }

    public String getFactor_type() {
        return factor_type;
    }

    public void setFactor_type(String factor_type) {
        this.factor_type = factor_type;
    }

    public String getIndex_title() {
        return index_title;
    }

    public void setIndex_title(String index_title) {
        this.index_title = index_title;
    }

    public List<EvaluateIndexParams> getmParams() {
        return mParams;
    }

    public void setmParams(List<EvaluateIndexParams> mParams) {
        this.mParams = mParams;
    }
}
