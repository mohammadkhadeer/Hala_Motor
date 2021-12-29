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
import com.cars.halamotor_obeidat.model.License_Nationality;

import java.util.ArrayList;

public class AdapterDriverLicenceNationality extends RecyclerView.Adapter<AdapterDriverLicenceNationality.ViewHolder>{

    private final Context context;
    public ArrayList<License_Nationality> licenceNationalitiesArrayL ;
    PassLicenceNationality passLicenceNationality;

    public AdapterDriverLicenceNationality
            (Context context, ArrayList<License_Nationality> licenceNationalitiesArrayL,PassLicenceNationality passLicenceNationality)
    {   this.context = context;
        this.licenceNationalitiesArrayL = licenceNationalitiesArrayL;
        this.passLicenceNationality = passLicenceNationality;
    }

    public AdapterDriverLicenceNationality.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_driver_nationality, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterDriverLicenceNationality.ViewHolder holder, final int position) {

        holder.textView.setText(licenceNationalitiesArrayL.get(position).getLicenseNationality());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passLicenceNationality.onLicenceNationalityClicked(licenceNationalitiesArrayL.get(position));
            }
        });
        holder.textView.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return licenceNationalitiesArrayL.size();
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

    public interface PassLicenceNationality {
        void onLicenceNationalityClicked(License_Nationality license_nationality);
    }

    public void filterList(ArrayList<License_Nationality> filterLicenceNationality) {
        this.licenceNationalitiesArrayL = filterLicenceNationality;
        notifyDataSetChanged();
    }
}