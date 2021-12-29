package com.cars.halamotor_obeidat.view.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;

import java.util.ArrayList;

public class AdapterCarOption extends RecyclerView.Adapter<AdapterCarOption.ViewHolder>{

    private final Context context;
    public ArrayList<String> carOptionArrayL;

    public AdapterCarOption
            (Context context, ArrayList<String> carOptionArrayL)
    {   this.context = context;
        this.carOptionArrayL = carOptionArrayL;
    }

    public AdapterCarOption.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_selected_options, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCarOption.ViewHolder holder, final int position) {
        holder.carOptionTV.setText(carOptionArrayL.get(position));
        holder.carOptionTV.setTypeface(Functions.changeFontGeneral(context));
    }

    @Override
    public int getItemCount() {
        return carOptionArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView carOptionTV;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            carOptionTV = (TextView) itemView.findViewById(R.id.adapter_car_selected_options);
        }
    }

}