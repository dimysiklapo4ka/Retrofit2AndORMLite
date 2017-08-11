package com.example.d1mys1klapo4ka.retrofit2andormlite.ormlite;

import android.content.Context;

import com.example.d1mys1klapo4ka.retrofit2andormlite.model.RetrofitModel;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by d1mys1klapo4ka on 29.06.2017.
 */

public class HelperFactory {

    private static DataBaseHelper dataBaseHelper;

    public static DataBaseHelper getDataBaseHelper(){
        return dataBaseHelper;
    }

    public static void setDataBaseHelper(Context context){
        dataBaseHelper = OpenHelperManager.getHelper(context,DataBaseHelper.class);
    }

    public static void realeaseHelper(){
        OpenHelperManager.releaseHelper();
        dataBaseHelper = null;
    }

}
