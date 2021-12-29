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
import com.cars.halamotor_obeidat.model.CarMake;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.functions.FillText.fillImageView;
import static com.cars.halamotor_obeidat.functions.FillText.getTextEngOrLocal;

public class AdapterCarMake extends RecyclerView.Adapter<AdapterCarMake.ViewHolder>{

    private final Context context;
    public ArrayList<CarMake> carMakeArrayList ;
    PassCarMake passCarMake;

    public AdapterCarMake
            (Context context, ArrayList<CarMake> carMakeArrayList, PassCarMake passCarMake)
    {   this.context = context;
        this.carMakeArrayList = carMakeArrayList;
        this.passCarMake = passCarMake;
    }

    public AdapterCarMake.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_make, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCarMake.ViewHolder holder, final int position) {

        fillImage(context,position,holder);
        fillImageView(context,holder.arrowIV);

        holder.makeTV.setText(getTextEngOrLocal(context,carMakeArrayList.get(position).getName_en(),carMakeArrayList.get(position).getName_ar()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passCarMake.onCarMakeClicked(carMakeArrayList.get(position));
            }
        });
        holder.makeTV.setTypeface(Functions.changeFontGeneral(context));

    }

    private void fillImage(Context context, int position, ViewHolder holder) {

//        holder.carMakeIV.setBackgroundResource(carMakeArrayList.get(position).getImageIdInt());

    }

    @Override
    public int getItemCount() {
        return carMakeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView carMakeIV,arrowIV;
        TextView makeTV;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            makeTV = (TextView) itemView.findViewById(R.id.adapter_car_make_make_TV);
            carMakeIV = (ImageView) itemView.findViewById(R.id.adapter_car_make_image_IV) ;
            arrowIV = (ImageView) itemView.findViewById(R.id.arrow) ;
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_car_make_container_RL) ;
        }
    }

    public interface PassCarMake {
        void onCarMakeClicked(CarMake carMake);
    }

    public void filterList(ArrayList<CarMake> filterdNames) {
        this.carMakeArrayList = filterdNames;
        notifyDataSetChanged();
    }
}