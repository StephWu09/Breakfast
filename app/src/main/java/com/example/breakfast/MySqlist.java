package com.example.breakfast;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlist extends SQLiteOpenHelper {
    private String sql="create table if not exists user(_id Integer primary key autoincrement,account varchar(30) not null,pass varchar(50) not null,name varchar(50) not null,phone varchar(50) not null)";
    public MySqlist(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
    }
}