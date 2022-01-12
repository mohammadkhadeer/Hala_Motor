package com.cars.halamotor_obeidat.view.adapters.adapterFilterFragment;

import static com.cars.halamotor_obeidat.functions.NewFunction.getTitle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.Neighborhood;

import java.util.ArrayList;

public class AdapterFiltersNeighborhood extends RecyclerView.Adapter<AdapterFiltersNeighborhood.ViewHolder>{

    PassNeighborhood passNeighborhood;
    private final Context context;
    public ArrayList<Neighborhood> filterNeighborhoodArrayL ;
    String fromWhereCome;
    //Neighborhood

    public AdapterFiltersNeighborhood
            (Context context, ArrayList<Neighborhood> filterNeighborhoodArrayL
            ,String fromWhereCome,PassNeighborhood passNeighborhood)
    {   this.context = context;
        this.filterNeighborhoodArrayL = filterNeighborhoodArrayL;
        this.fromWhereCome = fromWhereCome;
        this.passNeighborhood = passNeighborhood;
    }

    public AdapterFiltersNeighborhood.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_filter_content, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterFiltersNeighborhood.ViewHolder holder, final int position) {
        holder.filterContentTV.setText(getTitle(filterNeighborhoodArrayL.get(position).getNeighborhood(),filterNeighborhoodArrayL.get(position).getNeighborhoodAr(),context));
        holder.filterContentTV.setTypeface(Functions.changeFontGeneral(context));
        actionListenerToCardView(context,position,holder);
    }

    private void actionListenerToCardView(Context context, final int position, ViewHolder holder) {
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passNeighborhood.onNeighborhoodClicked(filterNeighborhoodArrayL.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return filterNeighborhoodArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView filterContentTV;
        RelativeLayout relativeLayout;
        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            filterContentTV = (TextView) itemView.findViewById(R.id.adapter_filter_content_text_view);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.coverRL);
        }
    }

    public interface PassNeighborhood {
        void onNeighborhoodClicked(Neighborhood neighborhood);
    }

}