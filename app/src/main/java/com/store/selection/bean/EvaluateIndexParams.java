package com.store.selection.bean;

public class EvaluateIndexParams {
    //指数参数id
    public String index_params_id;
    //指数id
    public String index_id;
    //权重
    public int weight = 0;
    //指数参数描述
    public String index_params_title;

    public String getIndex_params_id() {
        return index_params_id;
    }

    public void setIndex_params_id(String index_params_id) {
        this.index_params_id = index_params_id;
    }

    public String getIndex_id() {
        return index_id;
    }

    public void setIndex_id(String index_id) {
        this.index_id = index_id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getIndex_params_title() {
        return index_params_title;
    }

    public void setIndex_params_title(String index_params_title) {
        this.index_params_title = index_params_title;
    }
}
