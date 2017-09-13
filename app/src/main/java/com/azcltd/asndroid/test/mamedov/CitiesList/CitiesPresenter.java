package com.azcltd.asndroid.test.mamedov.CitiesList;

import android.content.Context;
import android.content.Intent;

import com.azcltd.asndroid.test.mamedov.API.DataClasses.City;
import com.azcltd.asndroid.test.mamedov.BasePresenter;
import com.azcltd.asndroid.test.mamedov.CityDetails.DetailsActivity;

/**
 * Created by ilgar on 9/12/2017.
 */

public class CitiesPresenter extends BasePresenter<ICitiesInteractor, ICitiesView> implements ICitiesPresenter, ICitiesInteractor.OnGetCitiesListener {
    private City[] loadedCities;

    public CitiesPresenter() {
        this.model = new CitiesInteractor();
    }

    @Override
    public void openCityDetails(City city) {
        Intent intent = new Intent((Context)view, DetailsActivity.class);
        intent.putExtra("city", city);
        ((Context)view).startActivity(intent);
    }

    @Override
    public void getCitiesList() {
        if (loadedCities != null){
            this.view.onGetCities(loadedCities);
            return;
        }
        this.view.showProgressDialog("Getting cities list...");
        this.model.getCities(this);
    }

    @Override
    public void bindView(ICitiesView view) {
        super.bindView((ICitiesView) view);
    }

    @Override
    public void onError(String error) {
        this.view.hideProgressDialog();
        this.view.showError(error);
    }

    @Override
    public void onSuccess(City[] cities) {
        loadedCities = cities;
        this.view.hideProgressDialog();
        this.view.onGetCities(cities);
    }
}
