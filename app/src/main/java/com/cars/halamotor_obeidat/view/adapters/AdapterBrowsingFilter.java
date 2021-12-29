package com.cars.halamotor_obeidat.view.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.BrowsingFilter;

import java.util.ArrayList;

public class AdapterBrowsingFilter extends RecyclerView.Adapter<AdapterBrowsingFilter.ViewHolder>{

    private final Context context;
    public ArrayList<BrowsingFilter> filterContentArrayL ;
    PassSelectedFilter passSelectedFilter;

    public AdapterBrowsingFilter
            (Context context, ArrayList<BrowsingFilter> filterContentArrayL,PassSelectedFilter passSelectedFilter)
    {   this.context = context;
        this.filterContentArrayL = filterContentArrayL;
        this.passSelectedFilter = passSelectedFilter;
    }

    public AdapterBrowsingFilter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_browsing_filter, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterBrowsingFilter.ViewHolder holder, final int position) {
        changeFont(context,holder);
        holder.filterContentTV.setText(filterContentArrayL.get(position).getFilterString());
        holder.filterContentTV.setTypeface(Functions.changeFontGeneral(context));

        actionListener(context,position,holder);
    }

    private void changeFont(Context context, ViewHolder holder) {
        holder.filterContentTV.setTypeface(Functions.changeFontGeneral(context));
    }

    private void actionListener(final Context context, final int position, final ViewHolder holder) {
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillCoverBG(context,position,holder);
                passSelectedFilter.onFilterClicked(filterContentArrayL);
            }
        });
    }

    private void fillCoverBG(Context context, int position, ViewHolder holder) {

        if (filterContentArrayL.get(position).isSelected() == false)
        {
            filterContentArrayL.get(position).setSelected(true);
            holder.relativeLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.filter_selected_bg));
            changeTextColor(1,context,holder,position);
        }else{
            filterContentArrayL.get(position).setSelected(false);
            holder.relativeLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.filter_bg));
            changeTextColor(2,context,holder,position);
        }

    }

    private void changeTextColor(int color, Context context, ViewHolder holder, int position) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (color == 1)
                holder.filterContentTV.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
            if (color == 2)
                holder.filterContentTV.setTextColor(ContextCompat.getColor(context, R.color.colorBlack3));
        }else{
            if (color == 1)
                holder.filterContentTV.getResources().getColor(R.color.colorWhite);
            if (color == 2)
                holder.filterContentTV.getResources().getColor(R.color.colorBlack3);
        }
    }

    @Override
    public int getItemCount() {
        return filterContentArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView filterContentTV;
        RelativeLayout relativeLayout;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            filterContentTV = (TextView) itemView.findViewById(R.id.adapter_filter_browsing_text_view);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.browsing_filter_bg);
        }
    }

    public interface PassSelectedFilter {
        void onFilterClicked(ArrayList<BrowsingFilter> selectedFilter);
    }

}