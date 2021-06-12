package com.cars.halamotor.view.adapters.adapterInCarDetails;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.CarOption;

import java.util.ArrayList;

import butterknife.BindView;

import static com.cars.halamotor.functions.FillText.getTextEngOrLocal;

public class AdapterCarOptions extends RecyclerView.Adapter<AdapterCarOptions.ViewHolder> {

    private final Context context;
    public ArrayList<CarOption> carOptionsArrayL;
    ;
    PassOptions passOptions;


    public AdapterCarOptions
            (Context context, ArrayList<CarOption> carOptionsArrayL, PassOptions passOptions) {
        this.context = context;
        this.carOptionsArrayL = carOptionsArrayL;
        this.passOptions = passOptions;
    }

    public AdapterCarOptions.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_options, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCarOptions.ViewHolder holder, final int position) {

        holder.modelTV.setText(getTextEngOrLocal(context,carOptionsArrayL.get(position).getSetting_content_name_en(),carOptionsArrayL.get(position).getSetting_content_name_ar()));
        checkIfAlredyCheckedOrNot(holder,position);
        actionListenerOption(holder,position);
        changeFont(holder);

    }

    private void changeFont(ViewHolder holder) {
        holder.modelTV.setTypeface(Functions.changeFontGeneral(context));
    }

    private void actionListenerOption(final ViewHolder holder, final int position) {
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(carOptionsArrayL.get(position).getIsSelected() == 1)
                {
                    carOptionsArrayL.get(position).setIsSelected(0);
                    holder.checkBox.setChecked(false);
                    passOptions.onOptionClicked(carOptionsArrayL.get(position),position);
                    holder.relativeLayoutSplit.setVisibility(View.GONE);
                    reActiveSplit(context, holder);
                }else{
                    carOptionsArrayL.get(position).setIsSelected(1);
                    holder.checkBox
                            .setChecked(true);
                    passOptions.onOptionClicked(carOptionsArrayL.get(position),position);
                    holder.relativeLayoutSplit.setVisibility(View.GONE);
                    reActiveSplit(context, holder);
                }
            }

        });

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(carOptionsArrayL.get(position).getIsSelected() == 1)
                {
                    carOptionsArrayL.get(position).setIsSelected(0);
                    holder.checkBox.setChecked(false);
                    passOptions.onOptionClicked(carOptionsArrayL.get(position),position);
                    holder.relativeLayoutSplit.setVisibility(View.GONE);
                    reActiveSplit(context, holder);
                }else{
                    carOptionsArrayL.get(position).setIsSelected(1);
                    holder.checkBox
                            .setChecked(true);
                    passOptions.onOptionClicked(carOptionsArrayL.get(position),position);
                    holder.relativeLayoutSplit.setVisibility(View.GONE);
                    reActiveSplit(context, holder);
                }
            }

        });
    }

    private void checkIfAlredyCheckedOrNot(ViewHolder holder, int position) {
        if(carOptionsArrayL.get(position).getIsSelected() == 0)
        {
            holder.checkBox.setChecked(false);

        }else{
            holder.checkBox.setChecked(true);
        }
    }

    private void reActiveSplit(Context context, final ViewHolder holder) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                holder.relativeLayoutSplit.setVisibility(View.VISIBLE);
            }
        }, 300);
    }

    @Override
    public int getItemCount() {
        return carOptionsArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView modelTV;
        RelativeLayout relativeLayout, relativeLayoutSplit, relativeLayoutSelect;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            modelTV = (TextView) itemView.findViewById(R.id.adapter_car_options_TV);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_car_options_container_RL);
            relativeLayoutSplit = (RelativeLayout) itemView.findViewById(R.id.adapter_car_options_split_TV);
            relativeLayoutSelect = (RelativeLayout) itemView.findViewById(R.id.adapter_car_options_select_RL);
            checkBox = (CheckBox) itemView.findViewById(R.id.imgQueueMultiSelected);
        }
    }

    public interface PassOptions {
        void onOptionClicked(CarOption carOption,int position);
    }

    public void filterList(ArrayList<CarOption> filterdNames) {
        this.carOptionsArrayL = filterdNames;
        notifyDataSetChanged();
    }

}