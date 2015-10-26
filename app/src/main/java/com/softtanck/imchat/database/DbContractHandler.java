package com.softtanck.imchat.database;

import android.database.sqlite.SQLiteDatabase;

import com.softtanck.imchat.App;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 10/8/2015
 */
public class DbContractHandler  {

    private SQLiteDatabase database;

    public DbContractHandler() {
        database = App.getInstance().dbHelper.getWritableDatabase();
    }
}
