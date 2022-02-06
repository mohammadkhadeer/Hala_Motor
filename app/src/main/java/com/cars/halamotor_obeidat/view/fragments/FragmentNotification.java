package com.cars.halamotor_obeidat.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.NotificationComp;
import com.cars.halamotor_obeidat.presnter.OnNewNotification;
import com.cars.halamotor_obeidat.view.adapters.AdapterNotification;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.ReadFunction.getNotificationFromDatabase;

public class FragmentNotification extends Fragment implements OnNewNotification {

    public FragmentNotification(){}
    RecyclerView recyclerView;
    View view;
    AdapterNotification adapterNotification;
    public ArrayList<NotificationComp> notificationCompsArrayL = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notification, container, false);

        init();
        createRV();
        return view;
    }

    private void createRV() {
        notificationCompsArrayL = getNotificationFromDatabase(getActivity(),30);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterNotification = new AdapterNotification(getActivity(), notificationCompsArrayL);
        recyclerView.setAdapter(adapterNotification);
    }

    private void init() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_notification_rv);
    }

    @Override
    public void onNewNotification(int newNotification) {
        createRV();
    }
}