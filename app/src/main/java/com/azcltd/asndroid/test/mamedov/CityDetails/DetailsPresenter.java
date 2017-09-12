package com.azcltd.asndroid.test.mamedov.CityDetails;

/**
 * Created by ilgar on 9/12/2017.
 */

public class DetailsPresenter implements IDetailsPresenter {
    private IDetailsView detailsView;
    private IDetailsModel detailsModel;

    public DetailsPresenter(IDetailsView view) {
        this.detailsView = view;
        this.detailsModel = new DetailsModel();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
        this.detailsView = null;
    }
}
