package com.azcltd.asndroid.test.mamedov.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.azcltd.asndroid.test.mamedov.API.CitiesAPIHandler;
import com.azcltd.asndroid.test.mamedov.API.DataClasses.City;
import com.azcltd.asndroid.test.mamedov.CitiesList.ICitiesPresenter;
import com.azcltd.asndroid.test.mamedov.R;
import com.squareup.picasso.Picasso;

/**
 * Created by ilgar on 9/11/2017.
 */

public class CitiesListAdapter extends RecyclerView.Adapter<CitiesListAdapter.SingleItemRowHolder> {
    private City[] cities;
    private Context mContext;
    private ICitiesPresenter mPresenter;

    public CitiesListAdapter(City[] cities, Context context, ICitiesPresenter presenter) {
        this.cities = cities;
        this.mContext = context;
        this.mPresenter = presenter;
    }

    public void setCities(City[] cities){
        this.cities = cities;
        notifyDataSetChanged();
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_list_item, null);

        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(lp);


        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        City city = cities[i];

        holder.city_name.setText(city.getName());
        Picasso.with(mContext).load(String.format("%s%s", CitiesAPIHandler.WEB_SERVICE_URL, city.getImage_url())).fit().into(holder.city_image);
    }

    @Override
    public int getItemCount() {
        return cities.length;
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView city_name;
        protected ImageView city_image;


        public SingleItemRowHolder(View view) {
            super(view);
            this.city_name = (TextView) view.findViewById(R.id.cityName);
            this.city_image = (ImageView) view.findViewById(R.id.cityImage);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.openCityDetails(cities[getAdapterPosition()]);
                }
            });

        }

    }
}
