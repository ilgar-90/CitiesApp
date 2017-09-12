package com.azcltd.asndroid.test.mamedov.CitiesList;

import com.azcltd.asndroid.test.mamedov.API.DataClasses.City;

/**
 * Created by ilgar on 9/12/2017.
 */

public interface ICitiesPresenter {
    void openCityDetails(City city);
    void getCitiesList();
    void bindView(ICitiesView view);
    void unbindView();
}
