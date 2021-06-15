package com.cars.halamotor.view.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.CategoryComp;
import com.cars.halamotor.presnter.PassCCEMT;

import java.util.ArrayList;

import static com.cars.halamotor.functions.ChangeFont.changeFont;
import static com.cars.halamotor.functions.FillText.getTextEngOrLocal;
import static com.cars.halamotor.view.fragments.fragmentInSaidHomeScreenFragment.FillCCEMTType.handelCCEMTAdsList;
import static com.cars.halamotor.view.fragments.fragmentInSaidHomeScreenFragment.FillWheelsRimType.handelWheelsRimAdsList;

public class AdapterAdsList extends RecyclerView.Adapter<AdapterAdsList.ViewHolder>{

    private final Context context;
    public ArrayList<CategoryComp> categoryCompsArrayL ;
    PassCategoryCompWhenUserPressSeeAll passSeeAll;
    public AdapterAdsList
            (Context context, ArrayList<CategoryComp> categoryCompsArrayL,PassCategoryCompWhenUserPressSeeAll passSeeAll)
    {   this.context = context;
        this.categoryCompsArrayL = categoryCompsArrayL;
        this.passSeeAll = passSeeAll;
    }

    public AdapterAdsList.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_ads_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterAdsList.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        changeAllTextViewFont(context,holder);
        fillText(context,position,holder);
        holder.category_see_all_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passSeeAll.onSeeAllClicked(categoryCompsArrayL.get(position));

            }
        });

        handelCCEMTAdsList(context,categoryCompsArrayL.get(position),holder.recyclerView_ads);
        handelWheelsRimAdsList(context,categoryCompsArrayL.get(position),holder.recyclerView_ads);
    }

    private void fillText(Context context, int position, ViewHolder holder) {
        holder.category_name_tv.setText(getTextEngOrLocal(context,categoryCompsArrayL.get(position).getName_en(),categoryCompsArrayL.get(position).getName_ar()));
        holder.category_see_all_tv.setText(context.getResources().getString(R.string.see_all));
    }

    private void changeAllTextViewFont(Context context,ViewHolder holder) {
        changeFont(context,holder.category_name_tv);
        changeFont(context,holder.category_see_all_tv);
    }

    @Override
    public int getItemCount() {
        return categoryCompsArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView category_name_tv,category_see_all_tv;
        RelativeLayout category_see_all_rl;
        RecyclerView recyclerView_ads,recyclerView_loading;

        public ViewHolder(View itemView) {
            super(itemView);
            category_name_tv = (TextView) itemView.findViewById(R.id.adapter_ads_list_category_name_TV);
            category_see_all_tv = (TextView) itemView.findViewById(R.id.adapter_ads_list_see_all_TV);
            category_see_all_rl = (RelativeLayout) itemView.findViewById(R.id.adapter_ads_list_see_all_RL) ;
            recyclerView_ads = (RecyclerView) itemView.findViewById(R.id.ads_RV) ;
            recyclerView_loading = (RecyclerView) itemView.findViewById(R.id.loading_RV) ;
        }
    }

    public interface PassCategoryCompWhenUserPressSeeAll {
        void onSeeAllClicked(CategoryComp categoryComp);
    }
}