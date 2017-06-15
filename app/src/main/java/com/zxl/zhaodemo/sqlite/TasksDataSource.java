package com.zxl.zhaodemo.sqlite;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/8
 * @time: 15:19
 * @description:
 */

public interface TasksDataSource {
    interface LoadTasksCallback {
        void onTasksLoaded(List<People> peoples);
        void onDataNotAvailable();
    }
    interface GetTaskCallback{
        void onTaskLoaded(People people);
        void onDataNotAvailable();
    }
    void addPeople(@NonNull People people);
    void getPeoples(@NonNull LoadTasksCallback callback);
    void deletePeople(@NonNull String name );
    void deleteAllPeople();
    void changePeople(@NonNull People people,@NonNull int id);
    void getPeopleByName(@NonNull People people,@NonNull String name,@NonNull GetTaskCallback callback);
}
