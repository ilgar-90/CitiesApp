package com.azcltd.asndroid.test.mamedov.CityDetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.azcltd.asndroid.test.mamedov.API.CitiesAPIHandler;
import com.azcltd.asndroid.test.mamedov.API.DataClasses.City;
import com.azcltd.asndroid.test.mamedov.BasePresenter;
import com.azcltd.asndroid.test.mamedov.PresenterHolder;
import com.azcltd.asndroid.test.mamedov.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity implements IDetailsView {

    ImageView cityImage;
    TextView cityDetails;
    IDetailsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            mPresenter = new DetailsPresenter();
        } else {
            mPresenter = PresenterHolder.getInstance().restorePresenter(savedInstanceState);
        }
        setContentView(R.layout.activity_details);
        cityImage = (ImageView) findViewById(R.id.cityImage);
        cityDetails = (TextView)findViewById(R.id.cityDescription);
        Intent intent = getIntent();
        City city = (City) intent.getSerializableExtra("city");
        Picasso.with(this)
                .load(String.format("%s%s", CitiesAPIHandler.WEB_SERVICE_URL, city.getImageUrl()))
                .into(cityImage);
        cityDetails.setText(city.getDescription());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.bindView(this);
    }

    @Override
    protected void onPause() {
        mPresenter.unbindView();
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterHolder.getInstance().savePresenter((BasePresenter<?, ?>) mPresenter, outState);
    }
}
