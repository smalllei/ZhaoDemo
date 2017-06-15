package com.zxl.zhaodemo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/8
 * @time: 14:54
 * @description:
 */

public class TasksDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Tasks.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "task";
    private static final String COMMA_SEP = ",";
    public static final String COLUMN_NAME_ENTRY_ID = "id";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_COUNTRY = "country";
    public static final String COLUMN_NAME_SEX = "sex";
    public static final String COLUMN_NAME_AGE = "age";
   // "CREATE TABLE IF NOT EXISTS task (id integer,name text,sex integer)"
    private static final String SQL_CREATE_ENTRIES ="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("+
            COLUMN_NAME_ENTRY_ID+INTEGER_TYPE+" PRIMARY KEY,"+
            COLUMN_NAME_NAME+TEXT_TYPE+COMMA_SEP+
            COLUMN_NAME_COUNTRY+TEXT_TYPE+COMMA_SEP+
            COLUMN_NAME_AGE+INTEGER_TYPE+COMMA_SEP+
            COLUMN_NAME_SEX+INTEGER_TYPE+")";

    public TasksDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
