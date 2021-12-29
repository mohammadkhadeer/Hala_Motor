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
import com.cars.halamotor_obeidat.model.CertificateClaims;

import java.util.ArrayList;

public class AdapterCertificateClaims extends RecyclerView.Adapter<AdapterCertificateClaims.ViewHolder>{

    private final Context context;
    public ArrayList<CertificateClaims> certificateClaimsArrayL ;
    PassCertificateClaims passCertificateClaims;

    public AdapterCertificateClaims
            (Context context, ArrayList<CertificateClaims> certificateClaimsArrayL,PassCertificateClaims passCertificateClaims)
    {   this.context = context;
        this.certificateClaimsArrayL = certificateClaimsArrayL;
        this.passCertificateClaims = passCertificateClaims;
    }

    public AdapterCertificateClaims.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_driver_nationality, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCertificateClaims.ViewHolder holder, final int position) {

        holder.textView.setText(certificateClaimsArrayL.get(position).getClaims());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passCertificateClaims.onLicenseCertificateClaimsClicked(certificateClaimsArrayL.get(position));
            }
        });
        holder.textView.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return certificateClaimsArrayL.size();
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

    public interface PassCertificateClaims {
        void onLicenseCertificateClaimsClicked(CertificateClaims certificateClaims);
    }

}