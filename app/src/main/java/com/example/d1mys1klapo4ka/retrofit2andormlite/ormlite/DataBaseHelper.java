package com.example.d1mys1klapo4ka.retrofit2andormlite.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.d1mys1klapo4ka.retrofit2andormlite.model.Auction;
import com.example.d1mys1klapo4ka.retrofit2andormlite.model.RetrofitModel;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by d1mys1klapo4ka on 29.06.2017.
 */

public class DataBaseHelper extends OrmLiteSqliteOpenHelper{

    private static final String DATABASE_NAME = "auctions.db";

    private static final int DATABASE_VERSION = 1;

   private Dao<RetrofitModel, Integer> mMainFilters;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try
        {
            TableUtils.createTable(connectionSource, RetrofitModel.class);
        }
        catch (SQLException e) {
            Log.e("@@@@", "error creating DB " + DATABASE_NAME);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try{
            //Так делают ленивые, гораздо предпочтительнее не удаляя БД аккуратно вносить изменения
            TableUtils.dropTable(connectionSource, Auction.class, true);
            onCreate(database, connectionSource);
        }
        catch (SQLException e){
            Log.e("@@@@","error upgrading db "+DATABASE_NAME+"from ver "+oldVersion);
            throw new RuntimeException(e);
        }
    }

    public Dao<RetrofitModel, Integer> getFilterses() throws SQLException {
        if (mMainFilters == null) {
            mMainFilters = getDao(RetrofitModel.class);
        }
        return mMainFilters;
    }
}
