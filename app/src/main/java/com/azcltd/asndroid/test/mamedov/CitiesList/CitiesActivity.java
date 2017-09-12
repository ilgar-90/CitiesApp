package com.azcltd.asndroid.test.mamedov.CitiesList;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.azcltd.asndroid.test.mamedov.API.DataClasses.City;
import com.azcltd.asndroid.test.mamedov.Adapters.CitiesListAdapter;
import com.azcltd.asndroid.test.mamedov.BasePresenter;
import com.azcltd.asndroid.test.mamedov.PresenterHolder;
import com.azcltd.asndroid.test.mamedov.R;

public class CitiesActivity extends AppCompatActivity implements ICitiesView{

    ProgressDialog mProgress;
    private RecyclerView mRecyclerView;
    private CitiesListAdapter mAdapter;

    ICitiesPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            mPresenter = new CitiesPresenter();
        } else {
            mPresenter = PresenterHolder.getInstance().restorePresenter(savedInstanceState);
        }

        setContentView(R.layout.activity_cities_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.cities_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(CitiesActivity.this, LinearLayoutManager.VERTICAL, false));

        mAdapter = new CitiesListAdapter(new City[0], this, mPresenter);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.bindView(this);
        mPresenter.getCitiesList();
    }

    @Override
    protected void onPause() {
        mPresenter.unbindView();
        super.onPause();
    }

    public void showProgressDialog(String messageToDisplay){
        mProgress = new ProgressDialog(this);
        mProgress.setMessage(messageToDisplay);
        mProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgress.setIndeterminate(true);
        mProgress.setCancelable(false);
        mProgress.setProgress(0);
        mProgress.show();
    }

    public void hideProgressDialog(){
        mProgress.hide();
    }


    @Override
    public void showMessage(String messageToDisplay) {
        Toast.makeText(CitiesActivity.this, messageToDisplay, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGetCities(City[] cities) {
        mAdapter.setCities(cities);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        PresenterHolder.getInstance().savePresenter((BasePresenter<?, ?>) mPresenter, outState);
    }

}
