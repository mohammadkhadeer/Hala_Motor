package com.cars.halamotor_obeidat.view.activity.selectAddress.expandableList;

import android.annotation.SuppressLint;

import com.cars.halamotor_obeidat.model.Area;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

@SuppressLint("ParcelCreator")
public class SubFavoriteType extends ExpandableGroup<Area> {

    public SubFavoriteType(String title, List<Area> items) {
        super(title, items);
    }
}

