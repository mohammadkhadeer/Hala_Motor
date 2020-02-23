package com.cars.halamotor.view.activity.selectAddress.expandableList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cars.halamotor.R;
import com.cars.halamotor.model.Neighborhood;
import com.cars.halamotor.view.activity.AddItem;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import java.util.ArrayList;

import static com.cars.halamotor.functions.Functions.check;

public class NeighborhoodViewHolder extends ChildViewHolder {

    private TextView neighborhoodTV;
    RelativeLayout relativeLayout;
    Dialog myDialog;

    public NeighborhoodViewHolder(View itemView) {
        super(itemView);

        neighborhoodTV = (TextView) itemView.findViewById(R.id.neighborhoodChild);
        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeChild);
    }

    public void onBind(final Neighborhood subFavorite, ExpandableGroup group, final Context context, final int position) {

        if (subFavorite.getNeighborhood().equals(context.getResources().getString(R.string.can_not_find))){
            neighborhoodTV.setTextColor(Color.BLUE);
            neighborhoodTV.setText(subFavorite.getNeighborhood());
        }
        else{
            relativeLayout.setBackgroundResource(R.drawable.neighborhood_bg);
            neighborhoodTV.setText(subFavorite.getNeighborhood());
        }

        actionListenerToRL(position,context,group.getItems().size());
    }

    private void actionListenerToRL(final int position, final Context context, final int size) {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundResource(R.drawable.neighborhood_selected_bg);
                checkIfSelectAddressOrNotFound(context,size);
            }
        });
    }

    private void checkIfSelectAddressOrNotFound(Context context, int size) {
        if (!neighborhoodTV.getText().toString().equals(context.getResources().getString(R.string.can_not_find)))
        {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("city", check(size,context));
            resultIntent.putExtra("nei", neighborhoodTV.getText().toString());
            ((Activity)context).setResult(Activity.RESULT_OK, resultIntent);
            ((Activity)context).finish();
        }else{
            myDialog = new Dialog(context);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("city", check(size,context));
            resultIntent.putExtra("nei", check(size,context));
            ((Activity)context).setResult(Activity.RESULT_OK, resultIntent);
            ((Activity)context).finish();
             neighborhoodTV.setTextColor(Color.WHITE);
        }
    }

}