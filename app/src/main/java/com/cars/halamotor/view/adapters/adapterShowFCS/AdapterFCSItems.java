package com.cars.halamotor.view.adapters.adapterShowFCS;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.SuggestedItem;
import com.cars.halamotor.permission.CheckPermission;
import com.cars.halamotor.view.activity.ShowItemDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.cars.halamotor.algorithms.ArrangingLists.checkFavouriteOrNot1;
import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.dataBase.InsertFunctions.insertItemsToFCS;
import static com.cars.halamotor.fireBaseDB.UpdateFireBase.setFavouriteCallSearchOnServer;
import static com.cars.halamotor.functions.NewFunction.callAds;

public class AdapterFCSItems extends RecyclerView.Adapter<AdapterFCSItems.ViewHolder>{
    private static final int VIEW_TYPE_LOADING = 0;
    private static final int VIEW_TYPE_NORMAL = 1;
    private boolean isLoaderVisible = false;


    private final Context context;
    public ArrayList<SuggestedItem> suggestedItemsArrayL ;

    public AdapterFCSItems
            (Context context, ArrayList<SuggestedItem> suggestedItemsArrayL)
    {   this.context = context;
        this.suggestedItemsArrayL = suggestedItemsArrayL;
    }

    public AdapterFCSItems.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(context).inflate(R.layout.adapter_fcs_items, viewGroup, false));
            case VIEW_TYPE_LOADING:
                return new ViewHolder(
                        LayoutInflater.from(context).inflate(R.layout.item_loading, viewGroup, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(final AdapterFCSItems.ViewHolder holder, final int position) {
        makeAllTextViewVISIBLE(holder);
        fillImage(holder, position, context);
        fillTitleAndUserName(holder, position, context);
        fillPrice(holder, position, context);
        changeFont(context, holder);
        checkTypeAndFillTypeDetails(context, holder, position);
        checkIfFavouriteOrNot(context, holder, position);
        actionListenerToFavorite(context, holder, position);
        actionListenerToGoShowItemDetails(context, holder, position);
        actionListenerToCallButton(context, holder, position);
    }

    private void actionListenerToCallButton(final Context context, ViewHolder holder, final int position) {
        holder.callButtonRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItemsToFCS(suggestedItemsArrayL.get(position).getItemIdInServer(),suggestedItemsArrayL.get(position).getItemType()
                        ,getDataBaseInstance(context),"seen");

                if (CheckPermission.checkPermissionMethodToPhone((Activity) context) == true) {
                    setFavouriteCallSearchOnServer(context,suggestedItemsArrayL.get(position).getItemIdInServer(),suggestedItemsArrayL.get(position).getItemType(),"call");
                    callAds(context,suggestedItemsArrayL.get(position).getItemUserPhoneNumber());
                }
            }
        });
    }

    private void actionListenerToGoShowItemDetails(final Context context, ViewHolder holder, final int position) {
        holder.cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItemsToFCS(suggestedItemsArrayL.get(position).getItemIdInServer(),suggestedItemsArrayL.get(position).getItemType()
                        ,getDataBaseInstance(context),"seen");

                setFavouriteCallSearchOnServer(context,suggestedItemsArrayL.get(position).getItemIdInServer()
                        ,suggestedItemsArrayL.get(position).getItemType(),"seen");

                Bundle bundle = new Bundle();
                bundle.putString("category",suggestedItemsArrayL.get(position).getItemType());
                bundle.putString("from","stu");
                bundle.putString("itemID",suggestedItemsArrayL.get(position).getItemIdInServer());

                Intent intent = new Intent(context, ShowItemDetails.class);
                intent.putExtras(bundle);
                ((Activity)context).startActivity(intent);
                ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);

            }
        });
    }

    private void actionListenerToFavorite(final Context context, final ViewHolder holder, final int position) {
        holder.favoriteRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkFavouriteOrNot1(context,suggestedItemsArrayL.get(position).getItemIdInServer()).equals("not_favorite"))
                {
                    holder.favoriteIV.setBackgroundResource(R.drawable.selcted_favorite);
                    insertItemsToFCS(suggestedItemsArrayL.get(position).getItemIdInServer(),suggestedItemsArrayL.get(position).getItemType()
                            ,getDataBaseInstance(context),"favorite");

                    setFavouriteCallSearchOnServer(context,suggestedItemsArrayL.get(position).getItemIdInServer()
                            ,suggestedItemsArrayL.get(position).getItemType(),"favorite");
                }else
                {
                    holder.favoriteIV.setBackgroundResource(R.drawable.item_favu);
                    getDataBaseInstance(context).deleteFCS(suggestedItemsArrayL.get(position).getItemIdInServer());
                }
            }
        });
    }

    private void checkIfFavouriteOrNot(Context context, ViewHolder holder, int position) {
        if (checkFavouriteOrNot1(context,suggestedItemsArrayL.get(position).getItemIdInServer()).equals("not_favorite"))
        {
            holder.favoriteIV.setBackgroundResource(R.drawable.item_favu);
        }else
        {
            holder.favoriteIV.setBackgroundResource(R.drawable.selcted_favorite);
        }
    }

    private void fillPrice(ViewHolder holder, int position, Context context) {
        if (suggestedItemsArrayL.get(position).getItemPostEdit().equals("0"))
        {
            holder.itemPriceTV.setVisibility(View.VISIBLE);
            holder.oldPriceTV.setVisibility(View.GONE);
            holder.fireIV.setVisibility(View.GONE);
            holder.itemPriceTV.setText(suggestedItemsArrayL.get(position).getItemPrice()
                    +" "+context.getResources().getString(R.string.price_contry));
            holder.itemPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            //set new price empty to stay design
            holder.itemNewPriceTV.setText("");
            holder.itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
        }else{
            holder.itemPriceTV.setVisibility(View.GONE);
            holder.oldPriceTV.setVisibility(View.VISIBLE);

            holder.oldPriceTV.setText(suggestedItemsArrayL.get(position).getItemPrice());
                    //change text color
            holder.oldPriceTV.setTextColor(context.getResources().getColor(R.color.colorSilver));
            //set line above old price
            holder.oldPriceTV.setPaintFlags(holder.itemPriceTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            //change size new price
            holder.itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);

            holder.itemNewPriceTV.setText(suggestedItemsArrayL.get(position).getItemNewPrice()
                    +" "+context.getResources().getString(R.string.price_contry));
            //fill old price
            holder.itemPriceTV.setText(suggestedItemsArrayL.get(position).getItemPrice()
                    +" "+context.getResources().getString(R.string.price_contry));
            //VISIBLE fire image view
            holder.fireIV.setVisibility(View.VISIBLE);

        }
    }

    private void makeAllTextViewVISIBLE(ViewHolder holder) {
        //we use this method because some time need to gone some textView
        holder.text1.setAlpha(1);
        holder.text2.setAlpha(1);
        holder.text3.setAlpha(1);
        holder.text4.setAlpha(1);
        holder.itemCityTV.setAlpha(1);

        holder.text2RL.setAlpha(1);
        holder.text3RL.setAlpha(1);
        holder.text4RL.setAlpha(1);
        holder.itemCityRL.setAlpha(1);
    }

    private void checkTypeAndFillTypeDetails(Context context, ViewHolder holder, int position) {
        if (suggestedItemsArrayL.get(position).getItemType().equals("Car for sale")
                ||suggestedItemsArrayL.get(position).getItemType().equals("Car for rent")
                ||suggestedItemsArrayL.get(position).getItemType().equals("Exchange car")
                ||suggestedItemsArrayL.get(position).getItemType().equals("Motorcycle")
                ||suggestedItemsArrayL.get(position).getItemType().equals("Trucks")
        ) {
            fillCarDetails(position, holder);
        }
        if (suggestedItemsArrayL.get(position).getItemType().equals("Plates"))
        {
            fillCarPlates(context,position, holder);
        }
        if (suggestedItemsArrayL.get(position).getItemType().equals("Wheels_Rim"))
        {
            fillWheelsRim(context,position,holder);
        }
        if (suggestedItemsArrayL.get(position).getItemType().equals("Accessories"))
        {
            fillAccAndJunk(context,holder,position);
        }
        if (suggestedItemsArrayL.get(position).getItemType().equals("Junk car"))
        {
            fillAccAndJunk(context,holder,position);
        }
    }

    private void fillAccAndJunk(Context context, ViewHolder holder, int position) {
        holder.text1.setText(suggestedItemsArrayL.get(position).getItemCity());
        holder.text2.setAlpha(0);
        holder.text3.setAlpha(0);
        holder.text4.setAlpha(0);
        holder.itemCityTV.setAlpha(0);

        holder.text2RL.setAlpha(0);
        holder.text3RL.setAlpha(0);
        holder.text4RL.setAlpha(0);
        holder.itemCityRL.setAlpha(0);
    }

    private void fillWheelsRim(Context context, int position, ViewHolder holder) {
        holder.text1.setText(suggestedItemsArrayL.get(position).getItemCity());
        holder.text2.setText(suggestedItemsArrayL.get(position).getItemWheelsSize());
        holder.text3.setAlpha(0);
        holder.text4.setAlpha(0);
        holder.itemCityTV.setAlpha(0);

        holder.text3RL.setAlpha(0);
        holder.text4RL.setAlpha(0);
        holder.itemCityRL.setAlpha(0);
    }

    private void fillCarPlates(Context context, int position, ViewHolder holder) {
        holder.text1.setText(suggestedItemsArrayL.get(position).getItemCarPlatesCity());
        holder.text2.setText(suggestedItemsArrayL.get(position).getItemCarPlatesNumber().replace(".0",""));
        if(suggestedItemsArrayL.get(position).getItemCarPlatesSpecial().equals(context.getResources().getString(R.string.special)))
        {
            holder.text3.setText(context.getResources().getString(R.string.special));
        }else{
            holder.text3.setAlpha(0);
            holder.text3RL.setAlpha(0);
        }
        holder.text4RL.setAlpha(0);
        holder.text4.setAlpha(0);
        holder.itemCityTV.setAlpha(0);
        holder.itemCityRL.setAlpha(0);
        holder.itemCityTV.setText(suggestedItemsArrayL.get(position).getItemCity());
    }

    private void fillTitleAndUserName(ViewHolder holder, int position, Context context) {
        holder.itemTitleTV.setText(suggestedItemsArrayL.get(position).getItemName());
        holder.userNameTV.setText(suggestedItemsArrayL.get(position).getUserName());
    }

    private void fillCarDetails(int position, ViewHolder holder) {
        holder.text1.setText(suggestedItemsArrayL.get(position).getItemCarMake());
        holder.text2.setText(suggestedItemsArrayL.get(position).getItemCarYear());
        holder.text3.setText(suggestedItemsArrayL.get(position).getItemType());
        holder.text4.setText(suggestedItemsArrayL.get(position).getItemCarKilometers());
        //well set item category as alternative to city just to temporary time
       // holder.itemCityTV.setText(suggestedItemsArrayL.get(position).getItemType());

    }

    private void changeFont(Context context, ViewHolder holder) {
        holder.text1.setTypeface(Functions.changeFontGeneral(context));
        holder.text2.setTypeface(Functions.changeFontGeneral(context));
        holder.text3.setTypeface(Functions.changeFontGeneral(context));
        holder.text4.setTypeface(Functions.changeFontGeneral(context));
        holder.itemCityTV.setTypeface(Functions.changeFontGeneral(context));
        holder.userNameTV.setTypeface(Functions.changeFontGeneral(context));

        holder.itemPriceTV.setTypeface(Functions.changeFontGeneral(context));
        holder.itemTitleTV.setTypeface(Functions.changeFontBold(context));
    }

    private void fillImage(final ViewHolder holder, int position, Context context) {

        Picasso.with(context).load(suggestedItemsArrayL.get(position).getItemImage())
                .config(Bitmap.Config.RGB_565)
                .fit().centerCrop()
                .into(holder.itemImage);

        Picasso.with(context).load(suggestedItemsArrayL.get(position).getUserImage())
                .config(Bitmap.Config.RGB_565)
                .fit().centerCrop()
                .into(holder.userImage);
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoaderVisible) {
            return position == suggestedItemsArrayL.size() - 1 ? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_NORMAL;
        }
    }

    public void addItems(ArrayList<SuggestedItem> postItems) {
        suggestedItemsArrayL.addAll(postItems);
        notifyDataSetChanged();
    }

    public void addLoading() {
        isLoaderVisible = true;
        suggestedItemsArrayL.add(new SuggestedItem());
        notifyItemInserted(suggestedItemsArrayL.size() - 1);
    }

    public void removeLoading() {
        isLoaderVisible = false;
        int position = suggestedItemsArrayL.size() - 1;
        SuggestedItem item = getItem(position);
        if (item != null) {
            suggestedItemsArrayL.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        suggestedItemsArrayL.clear();
        notifyDataSetChanged();
    }

    SuggestedItem getItem(int position) {
        return suggestedItemsArrayL.get(position);
    }


    @Override
    public int getItemCount() {
        return  suggestedItemsArrayL == null ? 0 : suggestedItemsArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView itemImage,userImage,fireIV,favoriteIV;
        TextView text1, text2, text3
                , text4,itemTitleTV,itemPriceTV,itemCityTV
                ,userNameTV,itemNewPriceTV,oldPriceTV;
        RelativeLayout text2RL,text3RL,text4RL,itemCityRL,favoriteRL,cardButton,callButtonRL;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.adapter_suggested_item_CV);
            userImage = (ImageView) itemView.findViewById(R.id.adapter_suggested_item_user_image);
            fireIV = (ImageView) itemView.findViewById(R.id.adapter_suggested_fire_iv);
            favoriteIV = (ImageView) itemView.findViewById(R.id.adapter_suggested_favorite_iv);
            itemImage = (ImageView) itemView.findViewById(R.id.adapter_suggested_item_image_view);

            text1 = (TextView) itemView.findViewById(R.id.adapter_suggested_item_text1);
            text2 = (TextView) itemView.findViewById(R.id.adapter_suggested_item_text2);
            text3 = (TextView) itemView.findViewById(R.id.adapter_suggested_item_text3);
            text4 = (TextView) itemView.findViewById(R.id.adapter_suggested_item_text4);
            itemCityTV = (TextView) itemView.findViewById(R.id.adapter_suggested_item_city);

            text2RL = (RelativeLayout) itemView.findViewById(R.id.adapter_suggested_item_container_text2);
            text3RL = (RelativeLayout) itemView.findViewById(R.id.adapter_suggested_item_container_text3);
            text4RL = (RelativeLayout) itemView.findViewById(R.id.adapter_suggested_item_container_text4);
            itemCityRL = (RelativeLayout) itemView.findViewById(R.id.adapter_suggested_item_container_city);
            cardButton = (RelativeLayout) itemView.findViewById(R.id.adapter_suggested_item_card_button);

            itemTitleTV = (TextView) itemView.findViewById(R.id.adapter_suggested_item_car_title);
            itemPriceTV = (TextView) itemView.findViewById(R.id.adapter_suggested_item_car_price);
            itemNewPriceTV = (TextView) itemView.findViewById(R.id.adapter_suggested_item_car_new_price);
            oldPriceTV = (TextView) itemView.findViewById(R.id.adapter_suggested_item_car_old_price);
            userNameTV = (TextView) itemView.findViewById(R.id.adapter_suggested_item_user_name);

            favoriteRL = (RelativeLayout) itemView.findViewById(R.id.adapter_suggested_favorite_rl);
            callButtonRL = (RelativeLayout) itemView.findViewById(R.id.adapter_suggested_call_button);
        }
    }

    public class ProgressHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;

        @SuppressLint("WrongViewCast")
        public ProgressHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.item_loding_progressBar);
        }
    }

}