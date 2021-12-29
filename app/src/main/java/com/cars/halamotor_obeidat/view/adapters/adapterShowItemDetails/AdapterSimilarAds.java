package com.cars.halamotor_obeidat.view.adapters.adapterShowItemDetails;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.SimilarItem;
import com.cars.halamotor_obeidat.view.activity.ShowItemDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertItemsToFCS;
import static com.cars.halamotor_obeidat.fireBaseDB.UpdateFireBase.setFavouriteCallSearchOnServer;
import static com.cars.halamotor_obeidat.functions.Functions.convertCategoryToCategoryS;

public class AdapterSimilarAds extends RecyclerView.Adapter<AdapterSimilarAds.ViewHolder>{

    private final Context context;
    public ArrayList<SimilarItem> similarAdsArrayL ;
    String loadedOrDownloading;

    public AdapterSimilarAds
            (Context context, ArrayList<SimilarItem> similarAdsArrayL
            ,String loadedOrDownloading)
    {   this.context = context;
        this.similarAdsArrayL = similarAdsArrayL;
        this.loadedOrDownloading = loadedOrDownloading;
    }

    public AdapterSimilarAds.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_similar_ads, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterSimilarAds.ViewHolder holder, final int position) {
        //holder.filterContentTV.setText(filterContentArrayL.get(position));
        //holder.filterContentTV.setTypeface(Functions.changeFontGeneral(context));
        fillImage(context,holder,position);
        fillUserName(holder,position);
        fillPrice(holder,position,context);
        actioListenerToContainer(context,holder,position);
    }

    private void actioListenerToContainer(final Context context, ViewHolder holder, final int position) {
        holder.similar_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItemsToFCS(similarAdsArrayL.get(position).getItemIdInServer(),convertCategoryToCategoryS(similarAdsArrayL.get(position).getItemType(),context)
                        ,getDataBaseInstance(context),"seen",context);

                setFavouriteCallSearchOnServer(context,similarAdsArrayL.get(position).getItemIdInServer()
                        ,similarAdsArrayL.get(position).getItemType(),"seen");

                Bundle bundle = new Bundle();
                bundle.putString("category",similarAdsArrayL.get(position).getItemType());
                bundle.putString("from","s");
                bundle.putString("itemID",similarAdsArrayL.get(position).getItemIdInServer());

                Intent intent = new Intent(context, ShowItemDetails.class);
                intent.putExtras(bundle);
                ((Activity)context).startActivity(intent);
                ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
        });
    }

    private void fillPrice(ViewHolder holder, int position, Context context) {
        if (loadedOrDownloading.equals("loaded"))
        {
            if (similarAdsArrayL.get(position).getItemPostEdit().equals("0"))
            {
                holder.itemPriceTV.setVisibility(View.VISIBLE);
                holder.oldPriceTV.setVisibility(View.GONE);
                holder.fireIV.setVisibility(View.GONE);
                holder.itemPriceTV.setText(similarAdsArrayL.get(position).getItemPrice()
                        +" "+context.getResources().getString(R.string.price_contry));
                holder.itemPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
                //set new price empty to stay design
                holder.itemNewPriceTV.setText("");
                holder.itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            }else{
                holder.itemPriceTV.setVisibility(View.GONE);
                holder.oldPriceTV.setVisibility(View.VISIBLE);

                holder.oldPriceTV.setText(similarAdsArrayL.get(position).getItemPrice());
                //change text color
                holder.oldPriceTV.setTextColor(context.getResources().getColor(R.color.colorWhite));
                //set line above old price
                holder.oldPriceTV.setPaintFlags(holder.itemPriceTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                //change size new price
                holder.itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);

                holder.itemNewPriceTV.setText(similarAdsArrayL.get(position).getItemNewPrice()
                        +" "+context.getResources().getString(R.string.price_contry));
                //fill old price
                holder.itemPriceTV.setText(similarAdsArrayL.get(position).getItemPrice()
                        +" "+context.getResources().getString(R.string.price_contry));
                //VISIBLE fire image view
                holder.fireIV.setVisibility(View.VISIBLE);

            }
        }
    }

    private void fillUserName(ViewHolder holder, int position) {
        if (loadedOrDownloading.equals("loaded"))
        {
            holder.userName.setText(similarAdsArrayL.get(position).getUserName());
            changeFont(context,holder);
        }
    }

    private void changeFont(Context context, ViewHolder holder) {
        holder.userName.setTypeface(Functions.changeFontGeneral(context));
    }

    private void fillImage(Context context, ViewHolder holder, int position) {
        if (loadedOrDownloading.equals("loaded"))
        {
            loadingCompVisibleAndGone(holder);
            //fill item image
            Picasso.get()
                    .load(similarAdsArrayL.get(position).getItemImage())
                    .fit()
                    .centerCrop()
                    .into(holder.itemImage);

            Picasso.get()
                    .load(similarAdsArrayL.get(position).getUserImage())
                    .fit()
                    .centerCrop()
                    .into(holder.userImage);
        }else{
            loadingCompVisibleAndGone(holder);
        }
    }

    private void loadingCompVisibleAndGone(ViewHolder holder) {
        if (loadedOrDownloading.equals("loaded"))
        {
            holder.itemImageLoadingRL.setVisibility(View.GONE);
            holder.itemUserInfoLoadingRL.setVisibility(View.GONE);

            holder.priceLinearLayout.setVisibility(View.VISIBLE);
            holder.process.setVisibility(View.VISIBLE);
        }else{
            holder.priceLinearLayout.setVisibility(View.GONE);

            holder.itemUserInfoLoadingRL.setVisibility(View.VISIBLE);
            holder.itemImageLoadingRL.setVisibility(View.VISIBLE);

            AddShineEffect(holder.itemImageLoadingRL,holder.itemImageLoadingIV);
            AddShineEffect(holder.itemUserInfoLoadingRL,holder.itemUserInShineIV);

            holder.process.setVisibility(View.GONE);
        }
    }

    private void AddShineEffect(final RelativeLayout father, final ImageView child) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                animationEffect(father,child);
                if (loadedOrDownloading.equals("downloading"))
                    AddShineEffect(father,child);
            }
        }, 700);
    }

    private void animationEffect(RelativeLayout father, ImageView child) {
        Animation animation = new TranslateAnimation(0,
                father.getWidth()+child.getWidth(),0, 0);
        animation.setDuration(550);
        animation.setFillAfter(false);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        child.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName,itemPriceTV,itemNewPriceTV,oldPriceTV;
        ImageView itemImageLoadingIV,itemImageLoading2IV
                    ,itemUserImageLoadIV,itemUserInfoLoadIV,itemUserInShineIV;
        ProgressBar process;
        RelativeLayout itemImageLoadingRL,itemUserInfoLoadingRL,similar_container;

        ImageView itemImage,userImage,fireIV;
        LinearLayout priceLinearLayout;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image_iv);
            userImage = (ImageView) itemView.findViewById(R.id.adapter_similar_user_image);
            fireIV = (ImageView) itemView.findViewById(R.id.adapter_similar_fire_iv);

            userName = (TextView) itemView.findViewById(R.id.adapter_similar_user_name_tv);
            itemPriceTV = (TextView) itemView.findViewById(R.id.adapter_similar_item_car_price);
            itemNewPriceTV = (TextView) itemView.findViewById(R.id.adapter_similar_item_car_new_price);
            oldPriceTV = (TextView) itemView.findViewById(R.id.adapter_similar_item_car_old_price);

            process = (ProgressBar) itemView.findViewById(R.id.adapter_similar_progress);

            itemImageLoadingRL = (RelativeLayout) itemView.findViewById(R.id.item_image_load_rl);
            similar_container = (RelativeLayout) itemView.findViewById(R.id.similar_container);
            itemImageLoadingIV = (ImageView) itemView.findViewById(R.id.item_image_load_iv);
            itemImageLoading2IV = (ImageView) itemView.findViewById(R.id.item_image_load2_iv);

            itemUserInfoLoadingRL = (RelativeLayout) itemView.findViewById(R.id.item_user_info_load_rl);
            itemUserImageLoadIV = (ImageView) itemView.findViewById(R.id.adapter_similar_user_image_load);
            itemUserInfoLoadIV = (ImageView) itemView.findViewById(R.id.adapter_similar_user_name_load_tv);
            itemUserInShineIV = (ImageView) itemView.findViewById(R.id.adapter_similar_user_info_shine_load_tv);

            priceLinearLayout = (LinearLayout) itemView.findViewById(R.id.adapter_similar_price_ll);

        }
    }

}