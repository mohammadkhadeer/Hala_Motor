package com.cars.halamotor.view.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.CategoryComp;
import com.cars.halamotor.presnter.PassCategories;

import java.util.ArrayList;

import static com.cars.halamotor.functions.FillText.getTextEngOrLocal;

public class AdapterSelectCategory extends RecyclerView.Adapter<AdapterSelectCategory.ViewHolder>{

    private final Context context;
    public ArrayList<CategoryComp> categoryCompsArrayL ;
    PassCategories passCategories;

    public AdapterSelectCategory
            (Context context,ArrayList<CategoryComp> categoryCompsArryL,PassCategories passCategories)
                {
                     this.context = context;
                    this.categoryCompsArrayL = categoryCompsArryL;
                    this.passCategories = passCategories;
                }

    public AdapterSelectCategory.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_select_category, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterSelectCategory.ViewHolder holder, final int position) {

        holder.imageView.setBackgroundResource(categoryCompsArrayL.get(position).getImageIdInt());
        holder.textView.setText(getTextEngOrLocal(context,categoryCompsArrayL.get(position).getName_en(),categoryCompsArrayL.get(position).getName_ar()));
        holder.textView.setTypeface(Functions.changeFontGeneral(context));
        actionListenerToCategory(position,holder,context);
    }

    private void actionListenerToCategory(final int position, ViewHolder holder, Context context) {
        holder.category_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passCategories.passCategoriesInfo(categoryCompsArrayL.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryCompsArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        RelativeLayout radioRL,category_cover;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.adapter_select_category_NameTV);
            imageView = (ImageView) itemView.findViewById(R.id.adapter_select_category_image_category) ;
            radioRL = (RelativeLayout) itemView.findViewById(R.id.adapter_select_category_radioRelative) ;
            category_cover = (RelativeLayout) itemView.findViewById(R.id.category_cover) ;
        }

    }


}