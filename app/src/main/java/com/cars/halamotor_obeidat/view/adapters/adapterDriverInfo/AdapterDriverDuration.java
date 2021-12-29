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
import com.cars.halamotor_obeidat.model.LicenseDuration;

import java.util.ArrayList;

public class AdapterDriverDuration extends RecyclerView.Adapter<AdapterDriverDuration.ViewHolder>{

    private final Context context;
    public ArrayList<LicenseDuration> licenseDurationsArrayL ;
    PassLicenseDuration passLicenseDuration;

    public AdapterDriverDuration
            (Context context, ArrayList<LicenseDuration> licenseDurationsArrayL,PassLicenseDuration passLicenseDuration)
    {   this.context = context;
        this.licenseDurationsArrayL = licenseDurationsArrayL;
        this.passLicenseDuration = passLicenseDuration;
    }

    public AdapterDriverDuration.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_driver_nationality, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterDriverDuration.ViewHolder holder, final int position) {

        holder.textView.setText(licenseDurationsArrayL.get(position).getDuration());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passLicenseDuration.onLicenseDurationClicked(licenseDurationsArrayL.get(position));
            }
        });
        holder.textView.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return licenseDurationsArrayL.size();
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

    public interface PassLicenseDuration {
        void onLicenseDurationClicked(LicenseDuration licenseDuration);
    }

    public void filterList(ArrayList<LicenseDuration> filterLicenseDuration) {
        this.licenseDurationsArrayL = filterLicenseDuration;
        notifyDataSetChanged();
    }
}