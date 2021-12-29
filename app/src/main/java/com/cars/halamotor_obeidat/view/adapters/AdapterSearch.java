package com.cars.halamotor_obeidat.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.SearchCar;

import java.util.ArrayList;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.ViewHolder>{

    private final Context context;
    public ArrayList<SearchCar> searchCarsArrayL ;
    PassSearch passSearch;

    public AdapterSearch
            (Context context, ArrayList<SearchCar> searchCarsArrayL,PassSearch passSearch)
    {   this.context = context;
        this.searchCarsArrayL = searchCarsArrayL;
        this.passSearch = passSearch;
    }

    public AdapterSearch.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_search, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterSearch.ViewHolder holder, final int position) {

//        Picasso.get()
//                .load(searchCarsArrayL.get(position).getImage())
//                .fit()
//                .centerCrop()
//                .into(holder.imageView);

        holder.carMakeTV.setText(searchCarsArrayL.get(position).getCarMake()+"  ");
        holder.modelTV.setText(searchCarsArrayL.get(position).getCarModel());
        holder.categoryTV.setText("\""+searchCarsArrayL.get(position).getCategory()+"\"");
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passSearch.onSearchClicked(searchCarsArrayL.get(position));
            }
        });
        holder.modelTV.setTypeface(Functions.changeFontGeneral(context));

    }

    @Override
    public int getItemCount() {
        return searchCarsArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView carMakeTV,modelTV,categoryTV;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.adapter_search_IV) ;
            carMakeTV = (TextView) itemView.findViewById(R.id.adapter_search_car_make_tv);
            modelTV = (TextView) itemView.findViewById(R.id.adapter_search_car_model_tv);
            categoryTV = (TextView) itemView.findViewById(R.id.adapter_search_car_category_tv);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter_search_container_RL) ;
        }
    }

    public interface PassSearch {
        void onSearchClicked(SearchCar searchCar);
    }

    public void filterList(ArrayList<SearchCar> filterdNames) {
        this.searchCarsArrayL = filterdNames;
        notifyDataSetChanged();
    }
}