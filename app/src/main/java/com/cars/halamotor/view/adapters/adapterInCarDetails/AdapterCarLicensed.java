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
import com.cars.halamotor.model.CarLicensed;

import java.util.ArrayList;

import static com.cars.halamotor.functions.FillText.getTextEngOrLocal;

public class AdapterCarLicensed extends RecyclerView.Adapter<AdapterCarLicensed.ViewHolder>{

    private final Context context;
    public ArrayList<CarLicensed> carLicensedArrayL ;
    PassLicensed passLicensed;

    public AdapterCarLicensed
            (Context context, ArrayList<CarLicensed> carLicensedArrayL,PassLicensed passLicensed)
    {   this.context = context;
        this.carLicensedArrayL = carLicensedArrayL;
        this.passLicensed = passLicensed;
    }

    public AdapterCarLicensed.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_licensed, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCarLicensed.ViewHolder holder, final int position) {

        holder.modelTV.setText(getTextEngOrLocal(context,carLicensedArrayL.get(position).getSetting_content_name_en(),carLicensedArrayL.get(position).getSetting_content_name_ar()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passLicensed.onLicensedClicked(carLicensedArrayL.get(position));
            }
        });
        holder.modelTV.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return carLicensedArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView arrowIV;
        TextView modelTV;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            modelTV = (TextView) itemView.findViewById(R.id.adapter_car_licensed_TV);
            arrowIV = (ImageView) itemView.findViewById(R.id.adapter_car_licensed_IV) ;
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_car_licensed_container_RL) ;
        }
    }

    public interface PassLicensed {
        void onLicensedClicked(CarLicensed carLicensed);
    }

    public void filterList(ArrayList<CarLicensed> filterdNames) {
        this.carLicensedArrayL = filterdNames;
        notifyDataSetChanged();
    }
}