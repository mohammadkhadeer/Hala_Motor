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
import com.cars.halamotor_obeidat.model.CylinderNumber;

import java.util.ArrayList;

public class AdapterCylinderNumber extends RecyclerView.Adapter<AdapterCylinderNumber.ViewHolder>{

    private final Context context;
    public ArrayList<CylinderNumber> cylinderNumbersArrayL ;
    PassCylinderNumber passCylinderNumber;

    public AdapterCylinderNumber
            (Context context, ArrayList<CylinderNumber> cylinderNumbersArrayL, PassCylinderNumber passCylinderNumber)
    {   this.context = context;
        this.cylinderNumbersArrayL = cylinderNumbersArrayL;
        this.passCylinderNumber = passCylinderNumber;
    }

    public AdapterCylinderNumber.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_model, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCylinderNumber.ViewHolder holder, final int position) {

        holder.modelTV.setText(cylinderNumbersArrayL.get(position).getCylinderNumber());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passCylinderNumber.onCylinderNumberClicked(cylinderNumbersArrayL.get(position));
            }
        });
        holder.modelTV.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return cylinderNumbersArrayL.size();
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

    public interface PassCylinderNumber {
        void onCylinderNumberClicked(CylinderNumber cylinderNumber);
    }

    public void filterList(ArrayList<CylinderNumber> filterdCylinderNumber) {
        this.cylinderNumbersArrayL = filterdCylinderNumber;
        notifyDataSetChanged();
    }
}