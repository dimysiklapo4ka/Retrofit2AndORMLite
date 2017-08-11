package com.example.d1mys1klapo4ka.retrofit2andormlite.repozitoryPattern;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.d1mys1klapo4ka.retrofit2andormlite.adapter.RecyclerViewAdapter;
import com.example.d1mys1klapo4ka.retrofit2andormlite.model.Auction;
import com.example.d1mys1klapo4ka.retrofit2andormlite.model.AuctionRequest;
import com.example.d1mys1klapo4ka.retrofit2andormlite.model.RetrofitModel;
import com.example.d1mys1klapo4ka.retrofit2andormlite.ormlite.DataBaseHelper;
import com.example.d1mys1klapo4ka.retrofit2andormlite.retrofit.api.AuctionInterface;
import com.example.d1mys1klapo4ka.retrofit2andormlite.retrofit.api.RetrofitClient;
import com.example.d1mys1klapo4ka.retrofit2andormlite.retrofit.utils.InternetConection;
import com.google.gson.Gson;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by d1mys1klapo4ka on 05.07.2017.
 */

public class Repository {

    private List<Auction> modelses = new ArrayList<>();
    private Context context;
    private Dao<RetrofitModel, Integer> mMainFilters = null;
    private OnGetData onGetData;
    private ProgressDialog progressDialog;

    private Repository(){

    }

    public Repository(Context context, OnGetData onGetData){
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        this.onGetData = onGetData;
        try {
            mMainFilters = OpenHelperManager.getHelper(context, DataBaseHelper.class).getFilterses();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getWorkers() {
        progressDialog.show();
        if (InternetConection.checInternet(context)) {

            final AuctionInterface api = RetrofitClient.getAuctionInterface();

            AuctionRequest auction = new AuctionRequest();

            Gson gson = new Gson();
            Log.e("###", "worker: " + gson.toJson(auction));

            Call<RetrofitModel> call = api.getAllData(auction);
            call.enqueue(new Callback<RetrofitModel>() {
                @Override
                public void onResponse(Call<RetrofitModel> call, Response<RetrofitModel> response) {


                    if (response.isSuccessful()&&response.body() != null) {


                        try {
                            mMainFilters.deleteBuilder().delete();
                            mMainFilters.create(response.body());

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        modelses = response.body().getAuctions();
                        onGetData.loadComplite(modelses);
                        progressDialog.dismiss();



                    }else{
                        onGetData.loadComplite(getFromDB());
                    }


                }

                @Override
                public void onFailure(Call<RetrofitModel> call, Throwable t) {
                    onGetData.loadError(t.getLocalizedMessage());
                    onGetData.loadComplite(getFromDB());
                }
            });
        }else {

           onGetData.loadComplite(getFromDB());

        }
    }

    private List<Auction> getFromDB(){
        progressDialog.dismiss();
        try {
            assert mMainFilters != null;
            Log.e("#$%###", "onResponse: from db " + modelses.toString());
            Log.e("#$%!@#@!###", "onResponse: from db " + mMainFilters.queryForAll().size());
            return modelses = mMainFilters.queryForAll().get(0).getAuctions();
        } catch (SQLException e) {
            e.printStackTrace();
            onGetData.loadError(e.getLocalizedMessage());
            return new ArrayList<>();

        }
    }

    public interface OnGetData{

        void loadComplite(List<Auction> auctions);
        void loadError(String message);

    }


}
