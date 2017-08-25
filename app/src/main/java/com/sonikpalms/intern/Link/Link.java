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
import retrofit2.http.Query;

/**
 * Created by Sonikpalms on 09.08.2017.
 */

public interface Link {
   // @FormUrlEncoded

    @GET("v1/articles?source=the-times-of-india&sortBy=latest&apiKey=f7bfb84377e348b2b2b3fe2bd0d7156d")
    Call<MyItemsGson> getMyJson();




}
