package com.store.selection.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteDbHelper extends SQLiteOpenHelper {

    //数据库名称
    public static final String DB_NAME = "Elevator.db";
    //数据库版本号
    public static int DB_VERSION = 17;
    //用户表
    public static final String TAB_USER = "UserInfo";
    //商店表
    public static final String TAB_STORE = "Store";
    //评价表
    public static final String TAB_EVALUTE = "Evalute";

    Context context;
    public SQLiteDbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableUser(db);
        createTableStore(db);
        createTableEvalute(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TAB_USER);
        db.execSQL("DROP TABLE IF EXISTS "+TAB_STORE);
        onCreate(db);
    }

    //创建人员表
    public void createTableUser(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TAB_USER +
                "(USER_ID varchar(20) primary key, " +
                "USER_NAME varchar(20), " +
                "USER_PASSWORD varchar(20), " +
                "USER_TEL varchar(20), " +
                "USER_MAIL varchar(20), " +
                "USER_ROLE varchar(20))");
    }

    //创建商店表
    public void createTableStore(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TAB_STORE +
                "(STORE_ID varchar(20) primary key, " +
                "STORE_LEVLE_1 varchar(20), " +
                "STORE_LEVLE_2 varchar(20), " +
                "STORE_LEVLE_3 varchar(20))");
    }

    //创建评价表
    public void createTableEvalute(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TAB_EVALUTE +
                "(EVA_ID varchar(20) primary key, " +
                "WEIGHT varchar(20), " +
                "EVA_LEVLE_1 varchar(20), " +
                "EVA_LEVLE_2 varchar(20), " +
                "EVA_LEVLE_3 varchar(20))");
    }
}
