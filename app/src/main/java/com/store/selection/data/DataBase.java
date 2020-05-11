package com.store.selection.data;

import com.store.selection.bean.EvaluateIndex;
import com.store.selection.bean.EvaluateIndexParams;
import com.store.selection.bean.Store;

import java.util.ArrayList;
import java.util.List;

/***
 * 基础数据
 * */
public class DataBase {



    //默认的生成的评价因素
    public static List<EvaluateIndex> getDefaultEvaluateIndexs(){


        List<EvaluateIndex> mIndexs = new ArrayList<>();

        EvaluateIndex index1 = createEvaluateIndex("人流因素","房屋类型");

        EvaluateIndexParams p11 = createEvaluateIndexParams(index1.getIndex_id(),1,"普通住宅");
        EvaluateIndexParams p12 = createEvaluateIndexParams(index1.getIndex_id(),3,"公寓");
        EvaluateIndexParams p13 = createEvaluateIndexParams(index1.getIndex_id(),5,"别墅");

        index1.addParams(p11);
        index1.addParams(p12);
        index1.addParams(p13);

        EvaluateIndex index2 = createEvaluateIndex("人流因素","消费水平");

        EvaluateIndexParams p21 = createEvaluateIndexParams(index1.getIndex_id(),1,"5k以下");
        EvaluateIndexParams p22 = createEvaluateIndexParams(index1.getIndex_id(),2,"5k~1w");
        EvaluateIndexParams p23 = createEvaluateIndexParams(index1.getIndex_id(),3,"1w~1.5w");
        EvaluateIndexParams p24 = createEvaluateIndexParams(index1.getIndex_id(),4,"1.5w~2w");
        EvaluateIndexParams p25 = createEvaluateIndexParams(index1.getIndex_id(),5,"2w以上");

        index2.addParams(p21);
        index2.addParams(p22);
        index2.addParams(p23);
        index2.addParams(p24);
        index2.addParams(p25);


        EvaluateIndex index3 = createEvaluateIndex("人流因素","小区成熟度");

        EvaluateIndexParams p31 = createEvaluateIndexParams(index1.getIndex_id(),1,"3年以下");
        EvaluateIndexParams p32 = createEvaluateIndexParams(index1.getIndex_id(),2,"3~5年");
        EvaluateIndexParams p33 = createEvaluateIndexParams(index1.getIndex_id(),3,"5~8年");
        EvaluateIndexParams p34 = createEvaluateIndexParams(index1.getIndex_id(),4,"8~10年");
        EvaluateIndexParams p35 = createEvaluateIndexParams(index1.getIndex_id(),5,"10年及以上");

        index3.addParams(p31);
        index3.addParams(p32);
        index3.addParams(p33);
        index3.addParams(p34);
        index3.addParams(p35);

        EvaluateIndex index4 = createEvaluateIndex("环境因素","同类竞争店铺情况");

        EvaluateIndexParams p41 = createEvaluateIndexParams(index1.getIndex_id(),1,"4家以上");
        EvaluateIndexParams p42 = createEvaluateIndexParams(index1.getIndex_id(),2,"3家");
        EvaluateIndexParams p43 = createEvaluateIndexParams(index1.getIndex_id(),3,"2家");
        EvaluateIndexParams p44 = createEvaluateIndexParams(index1.getIndex_id(),4,"1家");
        EvaluateIndexParams p45 = createEvaluateIndexParams(index1.getIndex_id(),5,"0家");

        index4.addParams(p41);
        index4.addParams(p42);
        index4.addParams(p43);
        index4.addParams(p44);
        index4.addParams(p45);

        EvaluateIndex index5 = createEvaluateIndex("环境因素","互补类店铺情况");

        EvaluateIndexParams p51 = createEvaluateIndexParams(index1.getIndex_id(),1,"0种");
        EvaluateIndexParams p52 = createEvaluateIndexParams(index1.getIndex_id(),2,"1种");
        EvaluateIndexParams p53 = createEvaluateIndexParams(index1.getIndex_id(),3,"2种");
        EvaluateIndexParams p54 = createEvaluateIndexParams(index1.getIndex_id(),4,"3种");
        EvaluateIndexParams p55 = createEvaluateIndexParams(index1.getIndex_id(),5,"4种");

        index5.addParams(p51);
        index5.addParams(p52);
        index5.addParams(p53);
        index5.addParams(p54);
        index5.addParams(p55);

        EvaluateIndex index6 = createEvaluateIndex("环境因素","周边大中型地区数量");

        EvaluateIndexParams p61 = createEvaluateIndexParams(index1.getIndex_id(),1,"4所及以上");
        EvaluateIndexParams p62 = createEvaluateIndexParams(index1.getIndex_id(),2,"3所");
        EvaluateIndexParams p63 = createEvaluateIndexParams(index1.getIndex_id(),3,"2所");
        EvaluateIndexParams p64 = createEvaluateIndexParams(index1.getIndex_id(),4,"1所");
        EvaluateIndexParams p65 = createEvaluateIndexParams(index1.getIndex_id(),5,"0所");

        index6.addParams(p61);
        index6.addParams(p62);
        index6.addParams(p63);
        index6.addParams(p64);
        index6.addParams(p65);

        EvaluateIndex index7 = createEvaluateIndex("环境因素","门店可视性");

        EvaluateIndexParams p71 = createEvaluateIndexParams(index1.getIndex_id(),1,"门店前有障碍物直接遮挡");
        EvaluateIndexParams p72 = createEvaluateIndexParams(index1.getIndex_id(),2,"门店前有隔离带");
        EvaluateIndexParams p73 = createEvaluateIndexParams(index1.getIndex_id(),3,"门店前设置有停车位");
        EvaluateIndexParams p74 = createEvaluateIndexParams(index1.getIndex_id(),4,"门店前小花园");
        EvaluateIndexParams p75 = createEvaluateIndexParams(index1.getIndex_id(),5,"门店前无障碍物");

        index7.addParams(p71);
        index7.addParams(p72);
        index7.addParams(p73);
        index7.addParams(p74);
        index7.addParams(p75);

        EvaluateIndex index8 = createEvaluateIndex("交通因素","范围内公交线路数目");

        EvaluateIndexParams p81 = createEvaluateIndexParams(index1.getIndex_id(),1,"7条以下");
        EvaluateIndexParams p82 = createEvaluateIndexParams(index1.getIndex_id(),2,"7~9条");
        EvaluateIndexParams p83 = createEvaluateIndexParams(index1.getIndex_id(),3,"10~12条");
        EvaluateIndexParams p84 = createEvaluateIndexParams(index1.getIndex_id(),4,"13~15条");
        EvaluateIndexParams p85 = createEvaluateIndexParams(index1.getIndex_id(),5,"15条以上");

        index8.addParams(p81);
        index8.addParams(p82);
        index8.addParams(p83);
        index8.addParams(p84);
        index8.addParams(p85);



        EvaluateIndex index9 = createEvaluateIndex("交通因素","范围内公交站数量");

        EvaluateIndexParams p91 = createEvaluateIndexParams(index1.getIndex_id(),1,"1个");
        EvaluateIndexParams p92 = createEvaluateIndexParams(index1.getIndex_id(),2,"2~3个");
        EvaluateIndexParams p93 = createEvaluateIndexParams(index1.getIndex_id(),3,"4~5个");
        EvaluateIndexParams p94 = createEvaluateIndexParams(index1.getIndex_id(),4,"5~6个");
        EvaluateIndexParams p95 = createEvaluateIndexParams(index1.getIndex_id(),5,"6个及以上");

        index9.addParams(p91);
        index9.addParams(p92);
        index9.addParams(p93);
        index9.addParams(p94);
        index9.addParams(p95);

        EvaluateIndex index10 = createEvaluateIndex("交通因素","离小区主要出入口的距离");

        EvaluateIndexParams p101 = createEvaluateIndexParams(index1.getIndex_id(),1,"500m以上");
        EvaluateIndexParams p102 = createEvaluateIndexParams(index1.getIndex_id(),2,"500m以内");
        EvaluateIndexParams p103 = createEvaluateIndexParams(index1.getIndex_id(),3,"300m以内");
        EvaluateIndexParams p104 = createEvaluateIndexParams(index1.getIndex_id(),4,"200m以内");
        EvaluateIndexParams p105 = createEvaluateIndexParams(index1.getIndex_id(),5,"100m以内");

        index10.addParams(p101);
        index10.addParams(p102);
        index10.addParams(p103);
        index10.addParams(p104);
        index10.addParams(p105);

        EvaluateIndex index11 = createEvaluateIndex("交通因素","门店的位置");

        EvaluateIndexParams p111 = createEvaluateIndexParams(index1.getIndex_id(),1,"无机动车道经过");
        EvaluateIndexParams p112 = createEvaluateIndexParams(index1.getIndex_id(),2,"位于单向车道旁");
        EvaluateIndexParams p113 = createEvaluateIndexParams(index1.getIndex_id(),3,"位于双向车道旁");
        EvaluateIndexParams p114 = createEvaluateIndexParams(index1.getIndex_id(),4,"位于三叉路口");
        EvaluateIndexParams p115 = createEvaluateIndexParams(index1.getIndex_id(),5,"位于十字路口");

        index11.addParams(p111);
        index11.addParams(p112);
        index11.addParams(p113);
        index11.addParams(p114);
        index11.addParams(p115);


        mIndexs.add(index1);
        mIndexs.add(index2);
        mIndexs.add(index3);
        mIndexs.add(index4);
        mIndexs.add(index5);
        mIndexs.add(index6);
        mIndexs.add(index7);
        mIndexs.add(index8);
        mIndexs.add(index9);
        mIndexs.add(index10);
        mIndexs.add(index11);

        return mIndexs;
    }

    //默认生成的门店类别
    public void getDefaultAllStore(){
//        店铺分类：
//        一、餐饮
//        a)中餐：中式小吃、外省市菜、自助餐、家常菜、火锅、烧烤、海鲜、干锅
//        b)西餐：西式简餐、西式小吃、牛排、意大利菜、法国菜、西班牙菜、美国菜、墨西哥菜
//        c)亚洲菜：日本料理、韩国料理、东南亚菜、泰国菜、新加坡菜、印度菜、越南菜
//        d)面包甜点：甜品店、面包蛋糕
//        e)咖啡饮料：奶茶店、饮料店、咖啡厅
//        f)其他
//        二、零售
//        a)个人装扮：奢侈品、快时尚、男装、女装、眼镜、围巾、帽子、手表、男鞋、女鞋、旅行箱、手提包、化妆品、假发、老人服饰、伞
//        b)家居生活：超市、家具店、家饰家纺、茶酒店、水果生鲜、数码产品、礼品文具、花店、车、音像制品、乐器
//        c)运动户外：运动服饰、运动装备、运动综合
//        d)其他
//        三、休闲娱乐
//        a)娱乐：网吧网咖、俱乐部、棋牌桌游、私人影院、DIY手工坊、艺术空间、轰趴
//        b)运动：健身、乒乓球、桌球、舞蹈、瑜伽、跆拳道、羽毛球
//        c)休闲：足疗、按摩、洗浴、茶馆、书店
//        d)其他
//        四、生活配套及服务
//        a)生活服务：宠物服务、地产服务、婚礼服务、美容美发美甲、药店、齿科、中医养生、妇婴保健、儿童健康、摄影服务
//        b)生活配套：通信营业厅、酒店、旅行社、语言教育、音乐培训、运动培训、美术培训、职业培训
//        c)其他
//        五、儿童亲子
//        a)亲子购物：母婴用品、儿童服装、儿童玩具、儿童食品
//        b)亲子教育：早教中心、艺术培训、儿童英语、课外辅导、亲子阅读
//        c)亲子服务：儿童摄影、孕妇写真、亲子餐厅


    }

    public static Store createStore(){
        Store store = new Store();
        return null;
    }

    public static EvaluateIndex createEvaluateIndex(String factor_type,String index_title){
        EvaluateIndex index = new EvaluateIndex();
        index.setIndex_id(getRandomIndex_ID());
        index.setFactor_type(factor_type);
        index.setIndex_title(index_title);
        return index;
    }

    public static EvaluateIndexParams createEvaluateIndexParams(String index_id,int weight,String index_params_title){
        EvaluateIndexParams params = new EvaluateIndexParams();
        params.setIndex_id(index_id);
        params.setIndex_params_title(index_params_title);
        params.setWeight(weight);
        params.setIndex_params_id(getRandomIndex_Params_ID());
        return params;
    }



    //生成随机index id
    public static String getRandomIndex_ID(){
        String strRand="I" ;
        for(int i=0;i<10;i++){
            strRand += String.valueOf((int)(Math.random() * 10)) ;
        }
        return strRand;
    }

    //生成随机index id
    public static String getRandomIndex_Params_ID(){
        String strRand="P" ;
        for(int i=0;i<10;i++){
            strRand += String.valueOf((int)(Math.random() * 10)) ;
        }
        return strRand;
    }
}
