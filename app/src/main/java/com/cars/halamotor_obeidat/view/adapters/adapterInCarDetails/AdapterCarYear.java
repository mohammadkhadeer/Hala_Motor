package com.cars.halamotor_obeidat.view.adapters.adapterInCarDetails;

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

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.functions.FillText.fillImageView;

public class AdapterCarYear extends RecyclerView.Adapter<AdapterCarYear.ViewHolder>{

    private final Context context;
    public ArrayList<String> carYearArrayL ;
    PassCarYear passCarYear;

    public AdapterCarYear
            (Context context, ArrayList<String> carYearArrayL,PassCarYear passCarYear)
    {   this.context = context;
        this.carYearArrayL = carYearArrayL;
        this.passCarYear = passCarYear;
    }

    public AdapterCarYear.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_year, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCarYear.ViewHolder holder, final int position) {
        fillImageView(context,holder.arrowIV);
        holder.modelTV.setText(carYearArrayL.get(position));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passCarYear.onYearClicked(carYearArrayL.get(position));
            }
        });
        holder.modelTV.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return carYearArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView arrowIV;
        TextView modelTV;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            modelTV = (TextView) itemView.findViewById(R.id.adapter_car_year_TV);
            arrowIV = (ImageView) itemView.findViewById(R.id.adapter_car_year_IV) ;
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_car_year_container_RL) ;
        }
    }

    public interface PassCarYear {
        void onYearClicked(String carYearStr);
    }

    public void filterList(ArrayList<String> filterdNames) {
        this.carYearArrayL = filterdNames;
        notifyDataSetChanged();
    }
}