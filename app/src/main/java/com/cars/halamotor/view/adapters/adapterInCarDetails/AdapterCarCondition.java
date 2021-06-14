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
import com.cars.halamotor.model.CarCondition;

import java.util.ArrayList;

import static com.cars.halamotor.functions.FillText.fillImageView;
import static com.cars.halamotor.functions.FillText.getTextEngOrLocal;

public class AdapterCarCondition extends RecyclerView.Adapter<AdapterCarCondition.ViewHolder>{

    private final Context context;
    public ArrayList<CarCondition> carConditionArrayL ;
    PassCarCondition passCarCondition;

    public AdapterCarCondition
            (Context context, ArrayList<CarCondition> carConditionArrayL,PassCarCondition passCarCondition)
    {   this.context = context;
        this.carConditionArrayL = carConditionArrayL;
        this.passCarCondition = passCarCondition;
    }

    public AdapterCarCondition.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_condition, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCarCondition.ViewHolder holder, final int position) {
        fillImageView(context,holder.arrowIV);
        holder.modelTV.setText(getTextEngOrLocal(context,carConditionArrayL.get(position).getSetting_content_name_en(),carConditionArrayL.get(position).getSetting_content_name_ar()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passCarCondition.onConditionClicked(carConditionArrayL.get(position));
            }
        });
        holder.modelTV.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return carConditionArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView arrowIV;
        TextView modelTV;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            modelTV = (TextView) itemView.findViewById(R.id.adapter_car_condition_TV);
            arrowIV = (ImageView) itemView.findViewById(R.id.adapter_car_condition_IV) ;
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_car_condition_container_RL) ;
        }
    }

    public interface PassCarCondition {
        void onConditionClicked(CarCondition carCarCondition);
    }

    public void filterList(ArrayList<CarCondition> filterdNames) {
        this.carConditionArrayL = filterdNames;
        notifyDataSetChanged();
    }
}