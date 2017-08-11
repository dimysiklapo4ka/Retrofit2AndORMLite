package com.example.d1mys1klapo4ka.retrofit2andormlite.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.d1mys1klapo4ka.retrofit2andormlite.model.AuctionRequest;
import com.example.d1mys1klapo4ka.retrofit2andormlite.R;
import com.example.d1mys1klapo4ka.retrofit2andormlite.adapter.RecyclerViewAdapter;
import com.example.d1mys1klapo4ka.retrofit2andormlite.model.Auction;
import com.example.d1mys1klapo4ka.retrofit2andormlite.model.RetrofitModel;
import com.example.d1mys1klapo4ka.retrofit2andormlite.ormlite.DataBaseHelper;
import com.example.d1mys1klapo4ka.retrofit2andormlite.repozitoryPattern.Repository;
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
 * Created by d1mys1klapo4ka on 16.05.2017.
 */

public class FragmentRecyclerView extends Fragment implements Repository.OnGetData{

    private List<Auction> modelses = new ArrayList<>();
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.recycler_view_activity, container, false);
        new Repository(getActivity(), this).getWorkers();
        return view;
    }

    private void rv(){
        RecyclerView rvInitStudent = (RecyclerView) view.findViewById(R.id.rv_init_student);
        rvInitStudent.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvInitStudent.setHasFixedSize(true);
        rvInitStudent.setAdapter(new RecyclerViewAdapter(getContext(), modelses));
    }


    @Override
    public void loadComplite(List<Auction> auctions) {
        modelses = auctions;
        rv();
    }

    @Override
    public void loadError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}



