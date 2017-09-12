package com.azcltd.asndroid.test.mamedov.CitiesList;

import com.azcltd.asndroid.test.mamedov.API.CitiesAPIHandler;
import com.azcltd.asndroid.test.mamedov.API.DataClasses.City;
import com.azcltd.asndroid.test.mamedov.API.DataClasses.DataResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ilgar on 9/12/2017.
 */

public class CitiesModel implements ICitiesModel {
    @Override
    public void getCities(final OnGetCitiesListener listener) {
        CitiesAPIHandler.getCities(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    City[] cities = response.body().getCities();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    listener.onSuccess(cities);
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
}
