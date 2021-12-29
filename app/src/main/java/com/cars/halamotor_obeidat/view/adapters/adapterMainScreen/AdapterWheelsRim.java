package com.cars.halamotor_obeidat.view.adapters.adapterMainScreen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.WheelsRimFirstCase;
import com.cars.halamotor_obeidat.permission.CheckPermission;
import com.cars.halamotor_obeidat.view.activity.ShowItemDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.algorithms.ArrangingLists.checkFavouriteOrNot1;
import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertItemsToFCS;
import static com.cars.halamotor_obeidat.fireBaseDB.UpdateFireBase.setFavouriteCallSearchOnServer;
import static com.cars.halamotor_obeidat.functions.Functions.convertCategoryToCategoryS;
import static com.cars.halamotor_obeidat.functions.Functions.openWhatsApp;
import static com.cars.halamotor_obeidat.functions.NewFunction.callAds;

public class AdapterWheelsRim extends RecyclerView.Adapter<AdapterWheelsRim.ViewHolder>{

    private final Context context;
    public ArrayList<WheelsRimFirstCase> wheelsRimArrayL ;
    String fromWhereCome;
    private static final int REQUEST_SHOW_ITEM_SELECTED_DETAILS = 100;

    public AdapterWheelsRim
            (Context context, ArrayList<WheelsRimFirstCase> wheelsRimArrayL
            ,String fromWhereCome)
    {   this.context = context;
        this.wheelsRimArrayL = wheelsRimArrayL;
        this.fromWhereCome = fromWhereCome;
    }

    public AdapterWheelsRim.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_wheels_rim, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterWheelsRim.ViewHolder holder, final int position) {
        if (wheelsRimArrayL.get(position).getItemActiveOrNot().equals("1")) {
            fillImage(holder, position, context);
            fillTitleAndUserName(holder, position, context);
            fillPrice(holder, position, context);
            changeFont(context, holder);
            fillNumberOfImageAndNumberOfComment(holder, position);
            checkTypeAndFillTypeDetails(context, holder, position);
            checkIfFavouriteOrNot(context,holder,position);
            actionListenerToFavorite(context,holder,position);
            actionListenerToMessage(context,position,holder);
            actionListenerToCard(context,position,holder);
            actionListenerToCallBtu(context,holder,position);
        }
    }

    private void actionListenerToMessage(final Context context, final int position, ViewHolder holder) {
        holder.messageRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItemsToFCS(wheelsRimArrayL.get(position).getItemIdInServer(),convertCategoryToCategoryS("Wheels_Rim",context),getDataBaseInstance(context),"message",context);
                setFavouriteCallSearchOnServer(context,wheelsRimArrayL.get(position).getItemIdInServer(),"Wheels_Rim","message");
                openWhatsApp(wheelsRimArrayL.get(position).getItemUserPhoneNumber(),context);
            }
        });
    }

    private void actionListenerToCard(final Context context, final int position, ViewHolder holder) {
        holder.cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItemsToFCS(wheelsRimArrayL.get(position).getItemIdInServer(),convertCategoryToCategoryS("Wheels_Rim",context)
                        ,getDataBaseInstance(context),"seen",context);

                setFavouriteCallSearchOnServer(context,wheelsRimArrayL.get(position).getItemIdInServer()
                        ,"Wheels_Rim","seen");

                Bundle bundle = new Bundle();
                bundle.putString("category","Wheels rim");
                bundle.putString("from","ml");
                bundle.putString("itemID",wheelsRimArrayL.get(position).getItemIdInServer());

                Intent intent = new Intent(context, ShowItemDetails.class);
                intent.putExtras(bundle);
                ((Activity)context).startActivityForResult(intent , REQUEST_SHOW_ITEM_SELECTED_DETAILS);
                ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
        });
    }

    private void actionListenerToCallBtu(final Context context, ViewHolder holder, final int position) {
        holder.callButtonRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckPermission.checkPermissionMethodToPhone((Activity) context) == true) {
                    insertItemsToFCS(wheelsRimArrayL.get(position).getItemIdInServer(),convertCategoryToCategoryS("Wheels_Rim",context)
                            ,getDataBaseInstance(context),"call",context);

                    setFavouriteCallSearchOnServer(context,wheelsRimArrayL.get(position).getItemIdInServer(),"Wheels_Rim","call");
                    callAds(context,wheelsRimArrayL.get(position).getItemUserPhoneNumber());
                }
            }
        });
    }

    private void checkIfFavouriteOrNot(Context context, ViewHolder holder, int position) {
        if (checkFavouriteOrNot1(context,wheelsRimArrayL.get(position).getItemIdInServer()).equals("not_favorite"))
        {
            holder.favoriteIV.setBackgroundResource(R.drawable.item_favu);
        }else
        {
            holder.favoriteIV.setBackgroundResource(R.drawable.selcted_favorite);
        }
    }

    private void actionListenerToFavorite(final Context context, final ViewHolder holder, final int position) {
        holder.favoriteRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkFavouriteOrNot1(context,wheelsRimArrayL.get(position).getItemIdInServer()).equals("not_favorite"))
                {
                    holder.favoriteIV.setBackgroundResource(R.drawable.selcted_favorite);
                    insertItemsToFCS(wheelsRimArrayL.get(position).getItemIdInServer(),convertCategoryToCategoryS("Wheels_Rim",context)
                            ,getDataBaseInstance(context),"favorite",context);

                    setFavouriteCallSearchOnServer(context,wheelsRimArrayL.get(position).getItemIdInServer()
                            ,"Wheels_Rim","favorite");
                }else
                {
                    holder.favoriteIV.setBackgroundResource(R.drawable.item_favu);
                    getDataBaseInstance(context).deleteFCS(wheelsRimArrayL.get(position).getItemIdInServer());
                }
            }
        });
    }

    private void fillPrice(ViewHolder holder, int position, Context context) {
        if (wheelsRimArrayL.get(position).getItemPostEdit().equals("0"))
        {
            holder.itemPriceTV.setVisibility(View.VISIBLE);
            holder.oldPrice.setVisibility(View.GONE);
            holder.fireIV.setVisibility(View.GONE);
            holder.itemPriceTV.setText(wheelsRimArrayL.get(position).getItemPrice()
                    +" "+context.getResources().getString(R.string.price_contry));
            holder.itemPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            //set new price empty to stay design
            holder.itemNewPriceTV.setText("");
            holder.itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
        }else{
            holder.itemPriceTV.setVisibility(View.GONE);
            holder.oldPrice.setVisibility(View.VISIBLE);

            holder.oldPrice.setText(wheelsRimArrayL.get(position).getItemPrice());
            //change text color
            holder.oldPrice.setTextColor(context.getResources().getColor(R.color.colorSilver));
            //set line above old price
            holder.oldPrice.setPaintFlags(holder.itemPriceTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            //change size new price
            holder.itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);

            holder.itemNewPriceTV.setText(wheelsRimArrayL.get(position).getItemNewPrice()
                    +" "+context.getResources().getString(R.string.price_contry));
            //fill old price
            holder.itemPriceTV.setText(wheelsRimArrayL.get(position).getItemPrice()
                    +" "+context.getResources().getString(R.string.price_contry));
            //VISIBLE fire image view
            holder.fireIV.setVisibility(View.VISIBLE);

        }
    }

    private void checkTypeAndFillTypeDetails(Context context, ViewHolder holder, int position) {
        fillCarDetails(position, holder);
    }

    private void fillTitleAndUserName(ViewHolder holder, int position, Context context) {
        holder.itemTitleTV.setText(wheelsRimArrayL.get(position).getItemName());
        holder.userNameTV.setText(wheelsRimArrayL.get(position).getItemUserName());
    }

    private void fillCarDetails(int position, ViewHolder holder) {
        holder.text1.setText(wheelsRimArrayL.get(position).getItemCity());
        holder.text4.setText(wheelsRimArrayL.get(position).getWheelsSize());

    }

    private void changeFont(Context context, ViewHolder holder) {
        holder.numberOfImageTV.setTypeface(Functions.changeFontGeneral(context));
        holder.numberOfCommentTV.setTypeface(Functions.changeFontGeneral(context));
        holder.text1.setTypeface(Functions.changeFontGeneral(context));
        holder.text4.setTypeface(Functions.changeFontGeneral(context));
        holder.userNameTV.setTypeface(Functions.changeFontGeneral(context));

        holder.itemPriceTV.setTypeface(Functions.changeFontBold(context));
        holder.itemTitleTV.setTypeface(Functions.changeFontBold(context));
    }

    private void fillNumberOfImageAndNumberOfComment(ViewHolder holder, int position) {
        holder.numberOfCommentTV.setText(wheelsRimArrayL.get(position).getItemNumberOfComments());
        holder.numberOfImageTV.setText(wheelsRimArrayL.get(position).getItemNumberOfImage());
    }

    private void fillImage(final ViewHolder holder, int position, Context context) {

        Picasso.get()
                .load(wheelsRimArrayL.get(position).getItemImage())
                .fit()
                .centerCrop()
                .into(holder.itemImage);

        Picasso.get()
                .load(wheelsRimArrayL.get(position).getItemUserImage())
                .fit()
                .centerCrop()
                .into(holder.userImage);

    }


    @Override
    public int getItemCount() {
        return wheelsRimArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage,userImage,fireIV,favoriteIV;
        TextView numberOfImageTV,numberOfCommentTV
                , text1
                , text4,itemTitleTV,itemPriceTV
                ,itemNewPriceTV,oldPrice,userNameTV;
        RelativeLayout favoriteRL,callButtonRL,cardButton,messageRL;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            numberOfImageTV = (TextView) itemView.findViewById(R.id.adapter_wheels_rim_number_of_item_image);
            userImage = (ImageView) itemView.findViewById(R.id.adapter_wheels_rim_user_image);
            numberOfCommentTV = (TextView) itemView.findViewById(R.id.adapter_wheels_rim_number_of_item_comment);
            itemImage = (ImageView) itemView.findViewById(R.id.adapter_wheels_rim_image_view);
            fireIV = (ImageView) itemView.findViewById(R.id.adapter_wheels_rim_fire_iv);

            text1 = (TextView) itemView.findViewById(R.id.adapter_wheels_rim_text1);

            text4 = (TextView) itemView.findViewById(R.id.adapter_wheels_rim_text4);

            itemTitleTV = (TextView) itemView.findViewById(R.id.adapter_wheels_rim_title);
            itemPriceTV = (TextView) itemView.findViewById(R.id.adapter_wheels_rim_price);
            oldPrice = (TextView) itemView.findViewById(R.id.adapter_wheels_rim_old_price);
            itemNewPriceTV = (TextView) itemView.findViewById(R.id.adapter_wheels_rim_new_price);
            userNameTV = (TextView) itemView.findViewById(R.id.adapter_wheels_rim_user_name);

            favoriteIV = (ImageView) itemView.findViewById(R.id.adapter_wheels_rim_number_of_f_rl);
            favoriteRL = (RelativeLayout) itemView.findViewById(R.id.adapter_wheels_rim_number_of_f_iv);
            callButtonRL = (RelativeLayout) itemView.findViewById(R.id.adapter_wheels_call_button);
            messageRL = (RelativeLayout) itemView.findViewById(R.id.adapter_wheels_rim_m_rl);
            cardButton = (RelativeLayout) itemView.findViewById(R.id.adapter_wheels_card_button);
        }
    }

}