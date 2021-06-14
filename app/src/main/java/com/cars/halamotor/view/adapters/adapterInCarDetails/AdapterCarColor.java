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
import com.cars.halamotor.model.CarColor;

import java.util.ArrayList;

import static com.cars.halamotor.functions.FillText.fillImageView;
import static com.cars.halamotor.functions.FillText.getTextEngOrLocal;

public class AdapterCarColor extends RecyclerView.Adapter<AdapterCarColor.ViewHolder>{

    private final Context context;
    public ArrayList<CarColor> carColorArrayL ;
    PassColor passColor;

    public AdapterCarColor
            (Context context, ArrayList<CarColor> carColorArrayL,PassColor passColor)
    {   this.context = context;
        this.carColorArrayL = carColorArrayL;
        this.passColor = passColor;
    }

    public AdapterCarColor.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_color, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCarColor.ViewHolder holder, final int position) {
        fillImageView(context,holder.arrowIV);
        changeColorBG(context,holder,position);
        holder.modelTV.setText(getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passColor.onColorClicked(carColorArrayL.get(position));
            }
        });
        holder.modelTV.setTypeface(Functions.changeFontGeneral(context));

    }

    private void changeColorBG(Context context, ViewHolder holder, int position) {
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_beige)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_beige_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_black)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_black_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_blue)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_blue_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_brown)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_brown_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_green)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_green_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_grey)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_grey_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_maroon)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_maroon_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_orange)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_orange_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_pink)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_pink_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_purple)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_purple_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_red)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_red_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_silver)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_silver_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_turquoise)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_turquoise_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_white)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_white_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_yellow)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_yellow_bg);
        }
        if (getTextEngOrLocal(context,carColorArrayL.get(position).getSetting_content_name_en(),carColorArrayL.get(position).getSetting_content_name_ar()).equals(context.getResources().getString(R.string.color_gold)))
        {
            holder.relativeLayoutColor.setBackgroundResource(R.drawable.circl_gold_bg);
        }
    }

    @Override
    public int getItemCount() {
        return carColorArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView arrowIV;
        TextView modelTV;
        RelativeLayout relativeLayout,relativeLayoutColor;
        public ViewHolder(View itemView) {
            super(itemView);
            modelTV = (TextView) itemView.findViewById(R.id.adapter_car_color_TV);
            arrowIV = (ImageView) itemView.findViewById(R.id.adapter_car_color_IV) ;
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_car_color_container_RL) ;
            relativeLayoutColor = (RelativeLayout) itemView.findViewById(R.id.adapter_car_color_RL) ;
        }
    }

    public interface PassColor {
        void onColorClicked(CarColor carColor);
    }

    public void filterList(ArrayList<CarColor> filterdNames) {
        this.carColorArrayL = filterdNames;
        notifyDataSetChanged();
    }
}