package com.store.selection.bean;

import java.util.ArrayList;
import java.util.List;

public class Store {
    String STORE_ID;
    String Level_First;//一级分类
    String Level_Sec;//二级分类
    String Level_Third;//三级分类

    List<String> levelSecTitle = new ArrayList<>();

    List<String> levelThirdTitle = new ArrayList<>();

    public String getSTORE_ID() {
        return STORE_ID;
    }

    public void setSTORE_ID(String STORE_ID) {
        this.STORE_ID = STORE_ID;
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
