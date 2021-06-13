package com.cars.halamotor.view.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.Area;
import java.util.ArrayList;
import java.util.Locale;

import static com.cars.halamotor.functions.FillText.getTextEngOrLocal;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.saveAddressInSP;

public class AdapterCityWithNeighborhood extends RecyclerView.Adapter<AdapterCityWithNeighborhood.ViewHolder>{

    private final Context context;
    public ArrayList<Area> areaArrayList ;
    String whereComeFrom;
    SharedPreferences SharedPreferences;
    SharedPreferences.Editor editor;
    public AdapterCityWithNeighborhood
            (Context context
                    ,ArrayList<Area> areaArrayList
                    ,String whereComeFrom)
                {
                    this.context = context;
                    this.areaArrayList = areaArrayList;
                    this.whereComeFrom = whereComeFrom;
                }

    public AdapterCityWithNeighborhood.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_city_with_neighborhood, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCityWithNeighborhood.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.textViewCity.setText(getTextEngOrLocal(context,areaArrayList.get(position).getCity().getName_en(),areaArrayList.get(position).getCity().getName_ar())+ " , ");
        holder.textViewNeighborhood.setText(getTextEngOrLocal(context,areaArrayList.get(position).getName_en(),areaArrayList.get(position).getName_ar()));
        holder.textViewCity.setTypeface(Functions.changeFontBold(context));
        holder.textViewNeighborhood.setTypeface(Functions.changeFontGeneral(context));

        holder.radioRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (whereComeFrom.equals("fragment"))
                {
                 backToSelectCityFragment(holder,position);   
                }
                if (whereComeFrom.equals("activity"))
                {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("city_en", areaArrayList.get(position).getCity().getName_en());
                    resultIntent.putExtra("city_ar", areaArrayList.get(position).getCity().getName_ar());
                    resultIntent.putExtra("city_code", areaArrayList.get(position).getCity().getCode());
                    resultIntent.putExtra("city_id", areaArrayList.get(position).getCity().getId());
                    resultIntent.putExtra("area_id", areaArrayList.get(position).getId());
                    resultIntent.putExtra("area_name_en", areaArrayList.get(position).getName_en());
                    resultIntent.putExtra("area_name_ar", areaArrayList.get(position).getName_ar());

                    ((Activity)context).setResult(Activity.RESULT_OK, resultIntent);
                    ((Activity)context).finish();
                }
            }
        });
    }


    private void backToSelectCityFragment(ViewHolder holder, int position) {

        Intent resultIntent = new Intent();
        resultIntent.putExtra("city_en", areaArrayList.get(position).getCity().getName_en());
        resultIntent.putExtra("city_ar", areaArrayList.get(position).getCity().getName_ar());
        resultIntent.putExtra("area_id", areaArrayList.get(position).getId());
        resultIntent.putExtra("area_name_en", areaArrayList.get(position).getName_en());
        resultIntent.putExtra("area_name_ar", areaArrayList.get(position).getName_ar());
        ((Activity)context).setResult(Activity.RESULT_OK, resultIntent);
        ((Activity)context).finish();
    }

    @Override
    public int getItemCount() {
        return areaArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout radioRL;
        TextView textViewCity,textViewNeighborhood;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewCity = (TextView) itemView.findViewById(R.id.adapter_city_with_neighborhood_city_TV);
            textViewNeighborhood = (TextView) itemView.findViewById(R.id.adapter_city_with_neighborhood_neighborhood_TV) ;
            radioRL = (RelativeLayout) itemView.findViewById(R.id.adapter_city_with_neighborhoodRelative) ;
        }

    }

    public void filterList(ArrayList<Area> cityWithNeighborhoods) {
        this.areaArrayList = cityWithNeighborhoods;
        notifyDataSetChanged();
    }

}