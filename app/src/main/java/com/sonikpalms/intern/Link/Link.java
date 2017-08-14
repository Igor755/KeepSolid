package com.sonikpalms.intern.Link;

import com.sonikpalms.intern.modelclass.MyItems;
import com.sonikpalms.intern.modelclass.MyItemsGson;

import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Sonikpalms on 09.08.2017.
 */

public interface Link {
   // @FormUrlEncoded
    //todo have to 30 news
    @GET("v1/articles?source=the-times-of-india&sortBy=latest&apiKey=ee4f08cf787540f5be2b9276684e9efe")
    Call<MyItemsGson> getMyJson();
}
