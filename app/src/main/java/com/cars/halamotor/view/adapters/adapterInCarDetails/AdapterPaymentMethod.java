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
import com.cars.halamotor.model.PaymentMethod;

import java.util.ArrayList;

import static com.cars.halamotor.functions.FillText.getTextEngOrLocal;

public class AdapterPaymentMethod extends RecyclerView.Adapter<AdapterPaymentMethod.ViewHolder>{

    private final Context context;
    public ArrayList<PaymentMethod> carPaymentArrayL ;
    PassPayment passPayment;

    public AdapterPaymentMethod
            (Context context, ArrayList<PaymentMethod> carPaymentArrayL,PassPayment passPayment)
    {   this.context = context;
        this.carPaymentArrayL = carPaymentArrayL;
        this.passPayment = passPayment;
    }

    public AdapterPaymentMethod.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_payment_method, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterPaymentMethod.ViewHolder holder, final int position) {

        holder.modelTV.setText(getTextEngOrLocal(context,carPaymentArrayL.get(position).getSetting_content_name_en(),carPaymentArrayL.get(position).getSetting_content_name_ar()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passPayment.onPaymentClicked(carPaymentArrayL.get(position));
            }
        });
        holder.modelTV.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return carPaymentArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView arrowIV;
        TextView modelTV;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            modelTV = (TextView) itemView.findViewById(R.id.adapter_car_payment_TV);
            arrowIV = (ImageView) itemView.findViewById(R.id.adapter_car_payment_IV) ;
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_car_payment_container_RL) ;
        }
    }

    public interface PassPayment {
        void onPaymentClicked(PaymentMethod carPaymentStr);
    }

    public void filterList(ArrayList<PaymentMethod> filterdNames) {
        this.carPaymentArrayL = filterdNames;
        notifyDataSetChanged();
    }
}