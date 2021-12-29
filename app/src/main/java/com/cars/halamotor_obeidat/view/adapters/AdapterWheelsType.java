package com.cars.halamotor_obeidat.view.adapters;

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
import com.cars.halamotor_obeidat.model.WheelsType;

import java.util.ArrayList;

public class AdapterWheelsType extends RecyclerView.Adapter<AdapterWheelsType.ViewHolder>{

    private final Context context;
    public ArrayList<WheelsType> wheelsTypeArrayL ;
    PassType passType;

    public AdapterWheelsType
            (Context context, ArrayList<WheelsType> wheelsTypeArrayL,PassType passType)
    {   this.context = context;
        this.wheelsTypeArrayL = wheelsTypeArrayL;
        this.passType = passType;
    }

    public AdapterWheelsType.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_wheels_type, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterWheelsType.ViewHolder holder, final int position) {

        holder.inchSizeTV.setText(wheelsTypeArrayL.get(position).getWheelsTypeStr());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passType.onFuelClicked(wheelsTypeArrayL.get(position));
//                Intent resultIntent = new Intent();
//                resultIntent.putExtra("inchSize", wheelsInchesArrayL.get(position));
//                ((Activity)context).setResult(Activity.RESULT_OK, resultIntent);
//                ((Activity)context).finish();
            }
        });
        holder.inchSizeTV.setTypeface(Functions.changeFontBold(context));

    }

    @Override
    public int getItemCount() {
        return wheelsTypeArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView arrowIV;
        TextView inchSizeTV;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            inchSizeTV = (TextView) itemView.findViewById(R.id.adapter_wheels_type_TV);
            arrowIV = (ImageView) itemView.findViewById(R.id.adapter_wheels_type_IV) ;
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_wheels_type_container_RL) ;
        }
    }

    public void filterList(ArrayList<WheelsType> filterdNames) {
        this.wheelsTypeArrayL = filterdNames;
        notifyDataSetChanged();
    }

    public interface PassType {
        void onFuelClicked(WheelsType wheelsType);
    }
}