package com.cars.halamotor_obeidat.view.activity.selectAddress.expandableList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.Area;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import static com.cars.halamotor_obeidat.functions.FillText.getTextEngOrLocal;

public class NeighborhoodViewHolder extends ChildViewHolder {

    private TextView neighborhoodTV;
    RelativeLayout relativeLayout;
    Dialog myDialog;

    public NeighborhoodViewHolder(View itemView) {
        super(itemView);

        neighborhoodTV = (TextView) itemView.findViewById(R.id.neighborhoodChild);
        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeChild);
    }

    public void onBind(final Area area, ExpandableGroup group, final Context context, final int position) {

        if (getTextEngOrLocal(context,area.getName_en(),area.getName_ar()).equals(context.getResources().getString(R.string.can_not_find))){
            neighborhoodTV.setTextColor(Color.BLUE);
            neighborhoodTV.setText(getTextEngOrLocal(context,area.getName_en(),area.getName_ar()));
        }
        else{
            relativeLayout.setBackgroundResource(R.drawable.neighborhood_bg);
            neighborhoodTV.setText(getTextEngOrLocal(context,area.getName_en(),area.getName_ar()));
        }

        actionListenerToRL(position,context,group.getItems().size(),area);
    }

    private void actionListenerToRL(final int position, final Context context, final int size, final Area area) {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundResource(R.drawable.neighborhood_selected_bg);
                checkIfSelectAddressOrNotFound(context,size,area,position);
            }
        });
    }

    private void checkIfSelectAddressOrNotFound(Context context, int size, Area area,int position) {
        String city_ar,city_en,area_en,area_ar,area_id;
        area_id = area.getId();
        city_ar = area.getCity().getName_ar();
        city_en = area.getCity().getName_en();
        area_en = area.getName_en();
        area_ar = area.getName_ar();

        if (!neighborhoodTV.getText().toString().equals(context.getResources().getString(R.string.can_not_find)))
        {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("city_en", city_en);
            resultIntent.putExtra("city_ar", city_ar);
            resultIntent.putExtra("area_id", area_id);
            resultIntent.putExtra("area_name_en", area_en);
            resultIntent.putExtra("area_name_ar", area_ar);
            ((Activity)context).setResult(Activity.RESULT_OK, resultIntent);
            ((Activity)context).finish();
        }else{
            myDialog = new Dialog(context);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("city_en", city_en);
            resultIntent.putExtra("city_ar", city_ar);
            resultIntent.putExtra("area_id", area_id);
            resultIntent.putExtra("area_name_en", area_en);
            resultIntent.putExtra("area_name_ar", area_ar);
            ((Activity)context).setResult(Activity.RESULT_OK, resultIntent);
            ((Activity)context).finish();
             neighborhoodTV.setTextColor(Color.WHITE);
        }
    }

}
