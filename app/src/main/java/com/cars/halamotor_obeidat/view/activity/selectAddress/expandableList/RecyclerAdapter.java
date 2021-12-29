package com.cars.halamotor_obeidat.view.activity.selectAddress.expandableList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.Area;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import java.util.List;

public class RecyclerAdapter extends ExpandableRecyclerViewAdapter<CityViewHolder, NeighborhoodViewHolder> {

    private Activity activity;

    public RecyclerAdapter(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.activity = activity;
    }

    @Override
    public CityViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.group_view_holder, parent, false);

        return new CityViewHolder(view);
    }

    @Override
    public NeighborhoodViewHolder onCreateChildViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.child_view_holder, parent, false);

        return new NeighborhoodViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(NeighborhoodViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Area area = ((SubFavoriteType) group).getItems().get(childIndex);
        holder.onBind(area,group,activity,flatPosition);
    }

    @Override
    public void onBindGroupViewHolder(CityViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGroupName(group,activity);
    }
}
