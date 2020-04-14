package com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Action;
import com.cars.halamotor.permission.CheckPermission;

import static com.cars.halamotor.functions.NewFunction.callAds;

public class FragmentContact extends Fragment {

    public FragmentContact() {
    }

    View view;
    RelativeLayout sendMessage, call;
    String phoneNumber;
    private static final int PHONE = 102;

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            phoneNumber = getArguments().getString("phoneN");
        }
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact, container, false);
        inti();
        actionListener();
        return view;
    }

    private void actionListener() {
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", phoneNumber);
                callAdsHere();
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void callAdsHere() {
        if (CheckPermission.checkPermissionMethodToPhone(getActivity()) == true) {
            callAds(getActivity(),phoneNumber);
        }else{
            //Toast.makeText(getActivity(),getActivity().getResources().getString(R.string.we_cant),Toast.LENGTH_SHORT).show();
        }
    }

    private void inti() {
        sendMessage = (RelativeLayout) view.findViewById(R.id.contact_send_message);
        call = (RelativeLayout) view.findViewById(R.id.contact_call);
    }

}
