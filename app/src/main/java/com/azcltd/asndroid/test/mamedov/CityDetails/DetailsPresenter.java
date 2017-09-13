package com.azcltd.asndroid.test.mamedov.CityDetails;

import com.azcltd.asndroid.test.mamedov.BasePresenter;

/**
 * Created by ilgar on 9/12/2017.
 */

public class DetailsPresenter extends BasePresenter<IDetailsInteractor, IDetailsView> implements IDetailsPresenter {
    private IDetailsView detailsView;
    private IDetailsInteractor detailsModel;

    public DetailsPresenter() {
        this.detailsModel = new DetailsInteractor();
    }

    @Override
    public void bindView(IDetailsView view) {
        super.bindView((IDetailsView) view);
    }
}
