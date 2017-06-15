package com.zxl.zhaodemo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/8
 * @time: 15:33
 * @description:
 */

public class TasksLocalDataSource implements TasksDataSource {

    private static TasksLocalDataSource instance;
    private final TasksDbHelper mTasksDbHelper;

    private TasksLocalDataSource(@NonNull Context context) {
        checkNotNull(context);
        mTasksDbHelper = new TasksDbHelper(context);

    }

    public static TasksLocalDataSource getInstance(@NonNull Context context) {
        if (instance == null)
            instance = new TasksLocalDataSource(context);
        return instance;
    }


    @Override
    public void addPeople(@NonNull People people) {

        checkNotNull(people);
        SQLiteDatabase db = mTasksDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TasksDbHelper.COLUMN_NAME_ENTRY_ID, people.getId());
        values.put(TasksDbHelper.COLUMN_NAME_NAME, people.getName());
        values.put(TasksDbHelper.COLUMN_NAME_AGE, people.getAge());
        values.put(TasksDbHelper.COLUMN_NAME_COUNTRY, people.getCountry());
        values.put(TasksDbHelper.COLUMN_NAME_SEX, people.getSex());
        db.insert(TasksDbHelper.TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void getPeoples(@NonNull LoadTasksCallback callback) {
        List<People> peoples = new ArrayList<People>();
        SQLiteDatabase db = mTasksDbHelper.getReadableDatabase();
        String[] projection = {TasksDbHelper.COLUMN_NAME_ENTRY_ID,
                TasksDbHelper.COLUMN_NAME_NAME,
                TasksDbHelper.COLUMN_NAME_COUNTRY,
                TasksDbHelper.COLUMN_NAME_AGE,
                TasksDbHelper.COLUMN_NAME_SEX};
        Cursor c = db.query(TasksDbHelper.TABLE_NAME, projection, null, null, null, null, null);

        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                int id = c.getInt(c.getColumnIndexOrThrow(TasksDbHelper.COLUMN_NAME_ENTRY_ID));
                String name = c.getString(c.getColumnIndexOrThrow(TasksDbHelper.COLUMN_NAME_NAME));
                int sex = c.getInt(c.getColumnIndexOrThrow(TasksDbHelper.COLUMN_NAME_SEX));
                int age = c.getInt(c.getColumnIndexOrThrow(TasksDbHelper.COLUMN_NAME_AGE));
                String country = c.getString(c.getColumnIndexOrThrow(TasksDbHelper.COLUMN_NAME_COUNTRY));
                People people = new People(id, name, country, age, sex);
                peoples.add(people);
            }
        }
        if (c != null) {
            c.close();
        }
        if (peoples.isEmpty()) {
            callback.onDataNotAvailable();
        } else {
            callback.onTasksLoaded(peoples);
        }

    }

    @Override
    public void deletePeople(@NonNull String name) {
        SQLiteDatabase db = mTasksDbHelper.getWritableDatabase();
        db.delete(TasksDbHelper.TABLE_NAME, TasksDbHelper.COLUMN_NAME_NAME + " LIKE ?", new String[]{name});
        db.close();
    }

    @Override
    public void deleteAllPeople() {
        SQLiteDatabase db = mTasksDbHelper.getWritableDatabase();
        db.delete(TasksDbHelper.TABLE_NAME, null, null);
        db.close();
    }

    @Override
    public void changePeople(@NonNull People people, @NonNull int id) {
        SQLiteDatabase db = mTasksDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        // values.put(TasksDbHelper.COLUMN_NAME_ENTRY_ID, people.getId());
        values.put(TasksDbHelper.COLUMN_NAME_NAME, people.getName());
        values.put(TasksDbHelper.COLUMN_NAME_AGE, people.getAge());
        values.put(TasksDbHelper.COLUMN_NAME_COUNTRY, people.getCountry());
        values.put(TasksDbHelper.COLUMN_NAME_SEX, people.getSex());
        db.update(TasksDbHelper.TABLE_NAME, values, TasksDbHelper.COLUMN_NAME_ENTRY_ID + " LIKE ?", new String[]{id + ""});
        db.close();
    }

    @Override
    public void getPeopleByName(@NonNull People people, @NonNull String name, @NonNull GetTaskCallback callback) {

        SQLiteDatabase db = mTasksDbHelper.getReadableDatabase();
        String[] projection = {TasksDbHelper.COLUMN_NAME_ENTRY_ID,
                TasksDbHelper.COLUMN_NAME_NAME,
                TasksDbHelper.COLUMN_NAME_COUNTRY,
                TasksDbHelper.COLUMN_NAME_AGE,
                TasksDbHelper.COLUMN_NAME_SEX};

        String selection = TasksDbHelper.COLUMN_NAME_NAME + " LIKE ?";
        String[] selectionArgs = {name};
        Cursor c = db.query(TasksDbHelper.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        People people1=null;
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            int id = c.getInt(c.getColumnIndexOrThrow(TasksDbHelper.COLUMN_NAME_ENTRY_ID));
            String name1 = c.getString(c.getColumnIndexOrThrow(TasksDbHelper.COLUMN_NAME_NAME));
            int sex = c.getInt(c.getColumnIndexOrThrow(TasksDbHelper.COLUMN_NAME_SEX));
            int age = c.getInt(c.getColumnIndexOrThrow(TasksDbHelper.COLUMN_NAME_AGE));
            String country = c.getString(c.getColumnIndexOrThrow(TasksDbHelper.COLUMN_NAME_COUNTRY));
             people1 = new People(id, name1, country, age, sex);


        }
        if (c != null) {
            c.close();
        }
        if (people==null) {
            callback.onDataNotAvailable();
        } else {
            callback.onTaskLoaded(people1);
        }
    }
}
