package com.azcltd.asndroid.test.mamedov.CitiesList;

import com.azcltd.asndroid.test.mamedov.API.DataClasses.City;

/**
 * Created by ilgar on 9/12/2017.
 */

public interface ICitiesView {
    void showProgressDialog(String messageToDisplay);
    void hideProgressDialog();
    void showError(String messageToDisplay);
    void onGetCities(City[] cities);
}
