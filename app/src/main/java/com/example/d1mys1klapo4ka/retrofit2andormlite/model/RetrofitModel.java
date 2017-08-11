package com.example.d1mys1klapo4ka.retrofit2andormlite.model;

import com.example.d1mys1klapo4ka.retrofit2andormlite.model.Auction;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by d1mys1klapo4ka on 28.06.2017.
 */

public class RetrofitModel implements Serializable{

    @SerializedName("auctions")
    @DatabaseField(columnName = "auctions", dataType = DataType.SERIALIZABLE)
    private ArrayList<Auction> auctions ;

    @SerializedName("count")
    private Integer count;

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(ArrayList<Auction> auctions) {
        this.auctions = auctions;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
