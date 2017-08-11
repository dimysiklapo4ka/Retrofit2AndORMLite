package com.example.d1mys1klapo4ka.retrofit2andormlite.ormlite;

import com.example.d1mys1klapo4ka.retrofit2andormlite.model.Auction;
import com.example.d1mys1klapo4ka.retrofit2andormlite.model.RetrofitModel;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by d1mys1klapo4ka on 29.06.2017.
 */

public class AuctionDAO extends BaseDaoImpl<Auction, Integer> {
    protected AuctionDAO(ConnectionSource connectionSource, Class<Auction> dataClass) throws SQLException {
        super(dataClass);
    }

    public List<Auction> getAllRoles() throws SQLException {
        return this.queryForAll();
    }
}
