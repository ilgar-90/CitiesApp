package com.azcltd.asndroid.test.mamedov.API;


import com.azcltd.asndroid.test.mamedov.API.DataClasses.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ilgar on 9/11/2017.
 */

public interface CitiesAPI {
    @GET("cities.json")
    Call<DataResponse> getCities();
}
