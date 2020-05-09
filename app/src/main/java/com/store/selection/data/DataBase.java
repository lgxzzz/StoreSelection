package com.store.selection.data;

import com.store.selection.bean.EvaluateIndex;
import com.store.selection.bean.EvaluateIndexParams;

import java.util.ArrayList;
import java.util.List;

/***
 * 基础数据
 * */
public class DataBase {

    public static List<EvaluateIndex> getEvaluateIndexs(){

        List<EvaluateIndex> mIndexs = new ArrayList<>();

        EvaluateIndex index1 = createEvaluateIndex("人流因素","房屋类型");
        EvaluateIndex index2 = createEvaluateIndex("人流因素","消费水平");
        EvaluateIndex index3 = createEvaluateIndex("人流因素","房屋类型");

        return mIndexs;
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
