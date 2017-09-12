package com.azcltd.asndroid.test.mamedov.CitiesList;

import com.azcltd.asndroid.test.mamedov.API.DataClasses.City;

/**
 * Created by ilgar on 9/12/2017.
 */

public interface ICitiesModel {

    interface OnGetCitiesListener {
        void onError(String error);
        void onSuccess(City[] cities);
    }

    void getCities(ICitiesModel.OnGetCitiesListener listener);
}
