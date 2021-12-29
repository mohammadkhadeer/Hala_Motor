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

import java.util.ArrayList;

public class AdapterWheelsInches extends RecyclerView.Adapter<AdapterWheelsInches.ViewHolder>{

    private final Context context;
    public ArrayList<String> wheelsInchesArrayL ;
    PassSize passSize;

    public AdapterWheelsInches
            (Context context, ArrayList<String> wheelsInchesArrayL,PassSize passSize)
    {   this.context = context;
        this.wheelsInchesArrayL = wheelsInchesArrayL;
        this.passSize = passSize;
    }

    public AdapterWheelsInches.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_wheels_inches, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterWheelsInches.ViewHolder holder, final int position) {

        holder.inchSizeTV.setText(context.getResources().getString(R.string.wheels_inch) + " "+
                wheelsInchesArrayL.get(position));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passSize.onFuelClicked(wheelsInchesArrayL.get(position));

            }
        });
        holder.inchSizeTV.setTypeface(Functions.changeFontBold(context));

    }

    @Override
    public int getItemCount() {
        return wheelsInchesArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView arrowIV;
        TextView inchSizeTV;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            inchSizeTV = (TextView) itemView.findViewById(R.id.adapter_wheels_inches_TV);
            arrowIV = (ImageView) itemView.findViewById(R.id.adapter_wheels_inches_IV) ;
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_wheels_inches_container_RL) ;
        }
    }

    public void filterList(ArrayList<String> filterdNames) {
        this.wheelsInchesArrayL = filterdNames;
        notifyDataSetChanged();
    }

    public interface PassSize {
        void onFuelClicked(String wheelsSizeStr);
    }
}