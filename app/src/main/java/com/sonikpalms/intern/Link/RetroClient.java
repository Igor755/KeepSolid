package com.sonikpalms.intern.Link;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sonikpalms on 10.08.2017.
 */

public class RetroClient {

    private static final String URL = "https://newsapi.org";
    private final String KEY = "f95725ad56c04956b0f37a5a4e1d36b1";
    private static Gson gson = new GsonBuilder().create();

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

        // private Link inter = retrofit.create(Link.class);

    public static Link getApiService() {
        return getRetrofitInstance().create(Link.class);
    }

}
