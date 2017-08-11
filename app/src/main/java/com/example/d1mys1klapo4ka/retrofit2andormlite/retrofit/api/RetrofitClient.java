package com.example.d1mys1klapo4ka.retrofit2andormlite.retrofit.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String BASE_URL = " https://api.dev.agroyard.com.ua/";

    private static OkHttpClient okHttpClient;
    private static Retrofit retrofitClient;

    private RetrofitClient() {
    }

    private static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()

                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .authenticator(new Authenticator() {
                        @Override
                        public Request authenticate(Route route, Response response) throws IOException {
                            String credential = Credentials.basic("UT-agroyard", "![8a1ypLKE6-]9K");
                            return response.request().newBuilder().header("Authorization", credential)
                                    .addHeader("Accept-Language", "ru")
                                    .build();
                        }
                    })
                    .build();
        }
        return okHttpClient;
    }


    private static Retrofit getRetrofitInstance() {

        if (retrofitClient == null) {

            retrofitClient =  new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitClient;
    }


    public static AuctionInterface getAuctionInterface() {
        return getRetrofitInstance().create(AuctionInterface.class);
    }


    }

