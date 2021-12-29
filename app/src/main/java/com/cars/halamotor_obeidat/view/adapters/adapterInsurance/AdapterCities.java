package com.cars.halamotor_obeidat.view.adapters.adapterInsurance;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CityModel;

import java.util.ArrayList;

public class AdapterCities extends RecyclerView.Adapter<AdapterCities.ViewHolder>{

    private final Context context;
    public ArrayList<CityModel> citiesModelArrayL ;
    PassCities passCities;

    public AdapterCities
            (Context context, ArrayList<CityModel> citiesModelArrayL, PassCities passCities)
    {   this.context = context;
        this.citiesModelArrayL = citiesModelArrayL;
        this.passCities = passCities;
    }

    public AdapterCities.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_model, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCities.ViewHolder holder, final int position) {

        holder.modelTV.setText(citiesModelArrayL.get(position).getCity());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passCities.onCityClicked(citiesModelArrayL.get(position));
            }
        });
        holder.modelTV.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return citiesModelArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView arrowIV;
        TextView modelTV;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            modelTV = (TextView) itemView.findViewById(R.id.adapter_car_model_TV);
            arrowIV = (ImageView) itemView.findViewById(R.id.adapter_car_make_image_IV) ;
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_car_make_container_RL) ;
        }
    }

    public interface PassCities {
        void onCityClicked(CityModel cityModel);
    }

    public void filterList(ArrayList<CityModel> filterCities) {
        this.citiesModelArrayL = citiesModelArrayL;
        notifyDataSetChanged();
    }
}