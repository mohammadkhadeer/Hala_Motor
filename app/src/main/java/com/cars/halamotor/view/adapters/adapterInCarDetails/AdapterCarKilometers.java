package com.cars.halamotor.view.adapters.adapterInCarDetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;

import java.util.ArrayList;

import static com.cars.halamotor.functions.FillText.fillImageView;

public class AdapterCarKilometers extends RecyclerView.Adapter<AdapterCarKilometers.ViewHolder>{

    private final Context context;
    public ArrayList<String> carKilometersArrayL ;
    PassKilometers passKilometers;

    public AdapterCarKilometers
            (Context context, ArrayList<String> carKilometersArrayL,PassKilometers passKilometers)
    {   this.context = context;
        this.carKilometersArrayL = carKilometersArrayL;
        this.passKilometers = passKilometers;
    }

    public AdapterCarKilometers.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_kilometers, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCarKilometers.ViewHolder holder, final int position) {
        fillImageView(context,holder.arrowIV);
        holder.modelTV.setText(carKilometersArrayL.get(position));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passKilometers.onKilometersClicked(carKilometersArrayL.get(position));
            }
        });
        holder.modelTV.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return carKilometersArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView arrowIV;
        TextView modelTV;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            modelTV = (TextView) itemView.findViewById(R.id.adapter_car_kilometers_TV);
            arrowIV = (ImageView) itemView.findViewById(R.id.adapter_car_kilometers_IV) ;
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_car_kilometers_container_RL) ;
        }
    }

    public interface PassKilometers {
        void onKilometersClicked(String carKilometersStr);
    }

    public void filterList(ArrayList<String> filterdNames) {
        this.carKilometersArrayL = filterdNames;
        notifyDataSetChanged();
    }
}