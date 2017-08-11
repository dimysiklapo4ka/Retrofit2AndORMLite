package com.example.d1mys1klapo4ka.retrofit2andormlite.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by d1mys1klapo4ka on 28.06.2017.
 */

public class AuctionRequest implements Serializable {

    private AuctionRequest auctionRequest;


    @SerializedName("action")
    private String action = "auctions";

    @SerializedName("filters")
    private Filters filters = new Filters();
}
