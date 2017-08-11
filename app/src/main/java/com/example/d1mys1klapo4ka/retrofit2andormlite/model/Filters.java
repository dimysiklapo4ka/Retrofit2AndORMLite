package com.example.d1mys1klapo4ka.retrofit2andormlite.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by d1mys1klapo4ka on 28.06.2017.
 */

public class Filters implements Serializable{

    @SerializedName("product_type_id")
    private String typeId = "all";

//    @SerializedName("product_type_id")
//    private String ids = "all";

    @SerializedName("sort_by")
    private String sortBy = "date_start";

    @SerializedName("sort_order")
    private String sortOrder = "DESC";

    @SerializedName("offset")
    private String offset = "0";

    @SerializedName("limit")
    private String limit = "10";

    @SerializedName("user_id")
    private String userId = "103";

}
