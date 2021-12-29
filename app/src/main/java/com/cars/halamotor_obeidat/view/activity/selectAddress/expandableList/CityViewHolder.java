package com.cars.halamotor_obeidat.view.activity.selectAddress.expandableList;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static com.cars.halamotor_obeidat.functions.Functions.changeFontBold;
import static com.cars.halamotor_obeidat.functions.Functions.changeFontGeneral;

public class CityViewHolder extends GroupViewHolder {

    private TextView cityName;
    private ImageView imageView;
    Context context;

    public CityViewHolder(View itemView) {
        super(itemView);

        cityName = (TextView) itemView.findViewById(R.id.city_name_tv);
        imageView = (ImageView) itemView.findViewById(R.id.arrow);
    }

    @Override
    public void expand() {
        imageView.setBackgroundResource(R.drawable.down_arrow);
        cityName.setTypeface(changeFontGeneral(context));
//        Log.i("Adapter", "expand");
    }

    @Override
    public void collapse() {
//        Log.i("Adapter", "collapse");
        imageView.setBackgroundResource(R.drawable.up_arrow);
        cityName.setTypeface(changeFontBold(context));
    }

    public void setGroupName(ExpandableGroup group, Activity activity) {
        context = activity;
        cityName.setTypeface(changeFontGeneral(activity));
        cityName.setText(group.getTitle());
    }

}
