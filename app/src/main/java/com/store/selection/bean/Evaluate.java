package com.store.selection.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Evaluate implements Serializable{
    //指数参数id
    public String evalute_id;
    //权重
    public String weight = "0";
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
