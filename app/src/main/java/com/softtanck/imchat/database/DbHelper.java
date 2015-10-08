package com.softtanck.imchat.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 10/8/2015
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "IMChat.db";

    private static final int DATABASE_VERSION = 1;
    private String TABLE_NAME = "Contract";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // 数据库实际被创建是在getWritableDatabase()或getReadableDatabase()方法调用时
        // CursorFactory设置为null,使用系统默认的工厂类
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 构建创建表的SQL语句（可以从SQLite Expert工具的DDL粘贴过来加进StringBuffer中）
        StringBuffer sBuffer = new StringBuffer();

        sBuffer.append("CREATE TABLE [" + TABLE_NAME + "] (");
        sBuffer.append("[_id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sBuffer.append("[name] TEXT,");
        sBuffer.append("[age] INTEGER,");
        sBuffer.append("[info] TEXT)");

        // 执行创建表的SQL语句
        db.execSQL(sBuffer.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
