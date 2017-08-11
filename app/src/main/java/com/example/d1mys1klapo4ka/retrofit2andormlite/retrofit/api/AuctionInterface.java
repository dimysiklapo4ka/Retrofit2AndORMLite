package com.example.d1mys1klapo4ka.retrofit2andormlite.retrofit.api;

import com.example.d1mys1klapo4ka.retrofit2andormlite.model.AuctionRequest;
import com.example.d1mys1klapo4ka.retrofit2andormlite.model.RetrofitModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by d1mys1klapo4ka on 28.06.2017.
 */

public interface AuctionInterface {

//    @FormUrlEncoded
    @POST("/api/auctions")
    Call<RetrofitModel> getAllData(@Body AuctionRequest auction);
}
