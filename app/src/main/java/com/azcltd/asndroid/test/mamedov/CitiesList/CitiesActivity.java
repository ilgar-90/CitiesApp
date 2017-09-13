package com.azcltd.asndroid.test.mamedov.CitiesList;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.azcltd.asndroid.test.mamedov.API.DataClasses.City;
import com.azcltd.asndroid.test.mamedov.Adapters.CitiesListAdapter;
import com.azcltd.asndroid.test.mamedov.BasePresenter;
import com.azcltd.asndroid.test.mamedov.PresenterHolder;
import com.azcltd.asndroid.test.mamedov.R;

public class CitiesActivity extends AppCompatActivity implements ICitiesView{
    ProgressDialog mProgress;
    private RecyclerView mRecyclerView;
    private TextView tvEmpty;
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
        tvEmpty = (TextView)findViewById(R.id.tvEmpty);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvCities);
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
        mProgress = new ProgressDialog(this, R.style.DialogStyle);
        mProgress.setMessage(messageToDisplay);
        mProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgress.setIndeterminate(true);
        mProgress.setCancelable(false);
        mProgress.setProgress(0);
        mProgress.show();
    }

    public void hideProgressDialog(){
        if (mProgress != null) {
            mProgress.dismiss();
            mProgress = null;
        }
    }

    @Override
    public void showError(String messageToDisplay) {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.DialogStyle));
        builder.setMessage(messageToDisplay)
                .setTitle("Can't get list of cities");
        builder.setPositiveButton("Try again", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                mPresenter.getCitiesList();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onGetCities(City[] cities) {
        mAdapter.setCities(cities);
    }

    @Override
    public void showEmptyView() {
        tvEmpty.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideEmptyView() {
        tvEmpty.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterHolder.getInstance().savePresenter((BasePresenter<?, ?>) mPresenter, outState);
    }
}
