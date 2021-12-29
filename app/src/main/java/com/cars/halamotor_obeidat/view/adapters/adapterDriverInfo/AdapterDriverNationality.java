package com.cars.halamotor_obeidat.view.adapters.adapterDriverInfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.Nationality;

import java.util.ArrayList;

public class AdapterDriverNationality extends RecyclerView.Adapter<AdapterDriverNationality.ViewHolder>{

    private final Context context;
    public ArrayList<Nationality> nationalitiesArrayL ;
    PassNationality passNationality;

    public AdapterDriverNationality
            (Context context, ArrayList<Nationality> nationalitiesArrayL,PassNationality passNationality)
    {   this.context = context;
        this.nationalitiesArrayL = nationalitiesArrayL;
        this.passNationality = passNationality;
    }

    public AdapterDriverNationality.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_driver_nationality, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterDriverNationality.ViewHolder holder,final int position) {

        holder.textView.setText(nationalitiesArrayL.get(position).getNationality());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passNationality.onNationalityClicked(nationalitiesArrayL.get(position));
            }
        });
        holder.textView.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return nationalitiesArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.adapter_driver_nationality_TV);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_driver_nationality_container_RL) ;
        }
    }

    public interface PassNationality {
        void onNationalityClicked(Nationality nationality);
    }

    public void filterList(ArrayList<Nationality> filterNationality) {
        this.nationalitiesArrayL = filterNationality;
        notifyDataSetChanged();
    }
}