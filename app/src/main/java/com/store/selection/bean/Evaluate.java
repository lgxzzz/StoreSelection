package com.store.selection.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Evaluate implements Serializable{
    //指数参数id
    public String evalute_id;
    //三级分数
    public String weight = "0";
    //一级权重
    public String lv1_weight = "0";
    //二级权重
    public String lv2_weight = "0";
    //一级分类
    String Level_First;
    //二级分类
    String Level_Sec;
    //三级分类
    String Level_Third;

    List<String> levelSecTitle = new ArrayList<>();

    List<String> levelThirdTitle = new ArrayList<>();

    public String getEvalute_id() {
        return evalute_id;
    }

    public void setEvalute_id(String evalute_id) {
        this.evalute_id = evalute_id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLevel_First() {
        return Level_First;
    }

    public void setLevel_First(String level_First) {
        Level_First = level_First;
    }

    public String getLevel_Sec() {
        return Level_Sec;
    }

    public void setLevel_Sec(String level_Sec) {
        Level_Sec = level_Sec;
    }

    public String getLevel_Third() {
        return Level_Third;
    }

    public String getLv1_weight() {
        return lv1_weight;
    }

    public void setLv1_weight(String lv1_weight) {
        this.lv1_weight = lv1_weight;
    }

    public String getLv2_weight() {
        return lv2_weight;
    }

    public void setLv2_weight(String lv2_weight) {
        this.lv2_weight = lv2_weight;
    }

    public void setLevel_Third(String level_Third) {
        Level_Third = level_Third;
    }

    public List<String> getLevelSecTitle() {
        return levelSecTitle;
    }

    public void setLevelSecTitle(List<String> levelSecTitle) {
        this.levelSecTitle = levelSecTitle;
    }

    public List<String> getLevelThirdTitle() {
        return levelThirdTitle;
    }

    public void setLevelThirdTitle(List<String> levelThirdTitle) {
        this.levelThirdTitle = levelThirdTitle;
    }
}
