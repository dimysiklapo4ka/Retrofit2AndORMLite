package com.example.d1mys1klapo4ka.retrofit2andormlite.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by d1mys1klapo4ka on 28.06.2017.
 */


public class Auction implements Serializable {

    @SerializedName("id")
    @DatabaseField(columnName = "id")
    private Integer id;
    @SerializedName("product_subtype")
    @DatabaseField(columnName = "product_subtype")
    private String productSubtype;
    @SerializedName("company_name")
    @DatabaseField(columnName = "company_name")
    private String companyName;
    @SerializedName("size")
    @DatabaseField(columnName = "size")
    private String size;
    @SerializedName("best_bid")
    @DatabaseField(columnName = "best_bit")
    private String bestBid;
    @SerializedName("bids_count")
    @DatabaseField(columnName = "bids_count")
    private String bidsCount;
    @SerializedName("till_the_end")
    @DatabaseField(columnName = "till_the_end")
    private String tillTheEnd;
    @SerializedName("status")
    @DatabaseField(columnName = "status")
    private String status;
    @SerializedName("price")
    @DatabaseField(columnName = "price")
    private String price;
    @SerializedName("currency_price_name")
    @DatabaseField(columnName = "currency_price_name")
    private String currencyPriceName;
    @SerializedName("region_name")
    @DatabaseField(columnName = "region_name")
    private String regionName;
    @SerializedName("user_id")
    @DatabaseField(columnName = "user_id")
    private String userId;
    @SerializedName("is_favorite")
    @DatabaseField(columnName = "is_favorite")
    private String isFavorite;

    public Auction(int id, String productSubtype, String bestBit, String currencyPriceName,
                  String tillTheEnd, String companyName, String regionName) {

        this.bestBid = bestBit;
        this.companyName = companyName;
        this.currencyPriceName = currencyPriceName;
        this.productSubtype = productSubtype;
        this.regionName = regionName;
        this.tillTheEnd = tillTheEnd;

        this.id = id;
    }

    public Auction(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductSubtype() {
        return productSubtype;
    }

    public void setProductSubtype(String productSubtype) {
        this.productSubtype = productSubtype;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBestBid() {
        return bestBid;
    }

    public void setBestBid(String bestBid) {
        this.bestBid = bestBid;
    }

    public String getBidsCount() {
        return bidsCount;
    }

    public void setBidsCount(String bidsCount) {
        this.bidsCount = bidsCount;
    }

    public String getTillTheEnd() {
        return tillTheEnd;
    }

    public void setTillTheEnd(String tillTheEnd) {
        this.tillTheEnd = tillTheEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrencyPriceName() {
        return currencyPriceName;
    }

    public void setCurrencyPriceName(String currencyPriceName) {
        this.currencyPriceName = currencyPriceName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(String isFavorite) {
        this.isFavorite = isFavorite;
    }
}
