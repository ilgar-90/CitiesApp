package com.azcltd.asndroid.test.mamedov.API;

import com.azcltd.asndroid.test.mamedov.API.DataClasses.DataResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ilgar on 9/11/2017.
 */

public class CitiesAPIHandler {
    public static final String WEB_SERVICE_URL = "http://azcltd.com/testTask/android/";

    public static void getCities(Callback<DataResponse> callback) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WEB_SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        CitiesAPI service = retrofit.create(CitiesAPI.class);
        Call<DataResponse> cities = service.getCities();
        cities.enqueue(callback);
    }



}
