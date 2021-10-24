package com.cars.halamotor.view.adapters.adapterMainScreen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.CCEMTFirestCase;
import com.cars.halamotor.model.CCEMTModel;
import com.cars.halamotor.permission.CheckPermission;
import com.cars.halamotor.view.activity.ShowItemDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.cars.halamotor.algorithms.ArrangingLists.checkFavouriteOrNot1;
import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.dataBase.InsertFunctions.insertItemsToFCS;
import static com.cars.halamotor.fireBaseDB.UpdateFireBase.setFavouriteCallSearchOnServer;
import static com.cars.halamotor.functions.Functions.convertCategoryToCategoryS;
import static com.cars.halamotor.functions.Functions.openWhatsApp;
import static com.cars.halamotor.functions.NewFunction.callAds;
import static com.cars.halamotor.functions.NewFunction.getTitle;
import static com.cars.halamotor.presnter.UploadLogAdActions.postAdAction;

public class AdapterCCEMTAllCases extends RecyclerView.Adapter<AdapterCCEMTAllCases.ViewHolder>{

    private final Context context;
    public ArrayList<CCEMTModel> ccemtArrayL ;

    public AdapterCCEMTAllCases
            (Context context, ArrayList<CCEMTModel> ccemtArrayL
            ,String fromWhereCome)
    {   this.context = context;
        this.ccemtArrayL = ccemtArrayL;
    }

    public AdapterCCEMTAllCases.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_ccemt_first_case, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCCEMTAllCases.ViewHolder holder, final int position) {
        makeAllTextViewVISIBLE(holder);
        fillImage(holder, position, context);
        fillTitleAndUserName(holder, position, context);
        fillPrice(holder, position, context);
        changeFont(context, holder);
        fillNumberOfImageAndNumberOfComment(holder, position);
        checkTypeAndFillTypeDetails(context, holder, position);
        fillCreatorInfo(context,holder,position);
        checkIfFavouriteOrNot(context,holder,position);
        actionListenerToFavorite(context,holder,position);
        actionListenerToMessage(context,position,holder);
        actionListenerToCardButton(context,holder,position);
        actionListenerToCallBtn(context,holder,position);

        //set as a view
        postAdAction(ccemtArrayL.get(position).getAd_id(),"view",context);

    }

    private void fillCreatorInfo(Context context, ViewHolder holder, int position) {
        Picasso.get()
                .load(ccemtArrayL.get(position).getCreatorInfo().getPhoto())
                .fit()
                .centerCrop()
                .into(holder.userImage);

        holder.userNameTV.setText(ccemtArrayL.get(position).getCreatorInfo().getName());
    }

    private void actionListenerToMessage(final Context context, final int position, ViewHolder holder) {
        holder.messageRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItemsToFCS(ccemtArrayL.get(position).getAd_id(),ccemtArrayL.get(position).getCategoryComp().getCode(),getDataBaseInstance(context),"message",context);
                postAdAction(ccemtArrayL.get(position).getAd_id(),"message",context);
                openWhatsApp(ccemtArrayL.get(position).getAd_phone(),context);
            }
        });
    }

    private void actionListenerToCallBtn(final Context context, ViewHolder holder, final int position) {
        holder.call_buttonRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckPermission.checkPermissionMethodToPhone((Activity) context) == true) {
                    insertItemsToFCS(ccemtArrayL.get(position).getAd_id(),ccemtArrayL.get(position).getCategoryComp().getCode()
                            ,getDataBaseInstance(context),"call",context);

                    postAdAction(ccemtArrayL.get(position).getAd_id(),"call",context);
                    callAds(context,ccemtArrayL.get(position).getAd_id());
                }
            }
        });
    }

    private void actionListenerToCardButton(final Context context, ViewHolder holder, final int position) {
        holder.cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItemsToFCS(ccemtArrayL.get(position).getAd_id(),ccemtArrayL.get(position).getCategoryComp().getCode()
                        ,getDataBaseInstance(context),"seen",context);

                postAdAction(ccemtArrayL.get(position).getAd_id(),"view",context);

                Bundle bundle = new Bundle();
                bundle.putString("category",ccemtArrayL.get(position).getCategoryComp().getCode());
                bundle.putParcelable("category_comp",ccemtArrayL.get(position).getCategoryComp());
                bundle.putString("from","ml");
                bundle.putString("itemID",ccemtArrayL.get(position).getAd_id());

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
                if (checkFavouriteOrNot1(context,ccemtArrayL.get(position).getAd_id()).equals("not_favorite"))
                {
                    holder.favoriteIV.setBackgroundResource(R.drawable.selcted_favorite);
                    insertItemsToFCS(ccemtArrayL.get(position).getAd_id(),ccemtArrayL.get(position).getCategoryComp().getCode()
                            ,getDataBaseInstance(context),"favorite",context);

                    postAdAction(ccemtArrayL.get(position).getAd_id(),"favorite",context);
                }else
                {
                    holder.favoriteIV.setBackgroundResource(R.drawable.item_favu);
                    getDataBaseInstance(context).deleteFCS(ccemtArrayL.get(position).getAd_id());
                }
            }
        });
    }

    private void checkIfFavouriteOrNot(Context context, ViewHolder holder, int position) {
        if (checkFavouriteOrNot1(context,ccemtArrayL.get(position).getAd_id()).equals("not_favorite"))
        {
            holder.favoriteIV.setBackgroundResource(R.drawable.item_favu);
        }else
        {
            holder.favoriteIV.setBackgroundResource(R.drawable.selcted_favorite);
        }
    }

    private void fillPrice(ViewHolder holder, int position, Context context) {

        holder.itemPriceTV.setVisibility(View.VISIBLE);
        holder.oldPrice.setVisibility(View.GONE);
        holder.fireIV.setVisibility(View.GONE);
        holder.itemPriceTV.setText(ccemtArrayL.get(position).getAd_price()
                +" "+context.getResources().getString(R.string.price_contry));
        holder.itemPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        //set new price empty to stay design
        holder.itemNewPriceTV.setText("");
        holder.itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);

//        if (carForSaleArrayL.get(position).getItemPostEdit().equals("0"))
//        {
//
//        }else{
////            holder.itemPriceTV.setVisibility(View.GONE);
////            holder.oldPrice.setVisibility(View.VISIBLE);
////
////            holder.oldPrice.setText(carForSaleArrayL.get(position).getItemPrice());
////            //change text color
////            holder.oldPrice.setTextColor(context.getResources().getColor(R.color.colorSilver));
////            //set line above old price
////            holder.oldPrice.setPaintFlags(holder.itemPriceTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
////
////            //change size new price
////            holder.itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
////
////            holder.itemNewPriceTV.setText(carForSaleArrayL.get(position).getItemNewPrice()
////                    +" "+context.getResources().getString(R.string.price_contry));
////            //fill old price
////            holder.itemPriceTV.setText(carForSaleArrayL.get(position).getItemPrice()
////                    +" "+context.getResources().getString(R.string.price_contry));
////            //VISIBLE fire image view
////            holder.fireIV.setVisibility(View.VISIBLE);
//
//        }

    }

    private void makeAllTextViewVISIBLE(ViewHolder holder) {
        //we use this method because some time need to gone some textView
        holder.text1.setVisibility(View.VISIBLE);
        holder.text2.setVisibility(View.VISIBLE);
        holder.text3.setVisibility(View.VISIBLE);
        holder.text4.setVisibility(View.VISIBLE);
        holder.itemCityTV.setVisibility(View.VISIBLE);
    }

    private void checkTypeAndFillTypeDetails(Context context, ViewHolder holder, int position) {
        fillCarDetails(position, holder);
    }

    private void fillTitleAndUserName(ViewHolder holder, int position, Context context) {
//        holder.itemTitleTV.setText(ccemtArrayL.get(position).getAd_title());
        holder.itemTitleTV.setText(getTitle(ccemtArrayL.get(position).getAd_title(),
                ccemtArrayL.get(position).getAttributesArrayList().get(0).getTitle()
                        +" "+ccemtArrayL.get(position).getAttributesArrayList().get(1).getTitle(),context));
        //holder.userNameTV.setText(carForSaleArrayL.get(position).getItemUserName());
    }

    private void fillCarDetails(int position, ViewHolder holder) {
        holder.text1.setText(ccemtArrayL.get(position).getAttributesArrayList().get(0).getTitle());
        holder.text2.setText(ccemtArrayL.get(position).getAttributesArrayList().get(1).getTitle());
        holder.text3.setText(ccemtArrayL.get(position).getAttributesArrayList().get(2).getTitle());
        holder.text4.setText(ccemtArrayL.get(position).getAttributesArrayList().get(3).getTitle());
        holder.itemCityTV.setText(ccemtArrayL.get(position).getAttributesArrayList().get(4).getTitle());

    }

    private void changeFont(Context context, ViewHolder holder) {
        holder.numberOfImageTV.setTypeface(Functions.changeFontGeneral(context));
        holder.numberOfCommentTV.setTypeface(Functions.changeFontGeneral(context));
        holder.text1.setTypeface(Functions.changeFontGeneral(context));
        holder.text2.setTypeface(Functions.changeFontGeneral(context));
        holder.text3.setTypeface(Functions.changeFontGeneral(context));
        holder.text4.setTypeface(Functions.changeFontGeneral(context));
        holder.itemCityTV.setTypeface(Functions.changeFontGeneral(context));
        holder.userNameTV.setTypeface(Functions.changeFontGeneral(context));

        holder.itemPriceTV.setTypeface(Functions.changeFontBold(context));
        holder.itemTitleTV.setTypeface(Functions.changeFontBold(context));
    }

    private void fillNumberOfImageAndNumberOfComment(ViewHolder holder, int position) {
        //holder.numberOfCommentTV.setText(carForSaleArrayL.get(position).getItemNumberOfComments());
        holder.numberOfImageTV.setText(String.valueOf(ccemtArrayL.get(position).getPhotosArrayList().size()));
    }

    private void fillImage(final ViewHolder holder, int position, Context context) {

        if (ccemtArrayL.get(position).getPhotosArrayList().size() == 0)
        {
            Picasso.get()
                    .load(R.drawable.no_image)
                    .fit()
                    .centerCrop()
                    .into(holder.itemImage);
        }else{
            Picasso.get()
                    .load(ccemtArrayL.get(position).getPhotosArrayList().get(0))
                    .fit()
                    .centerCrop()
                    .into(holder.itemImage);
        }


//        Picasso.get()
//                .load(carForSaleArrayL.get(position).getItemUserImage())
//                .fit()
//                .centerCrop()
//                .into(holder.userImage);

    }


    @Override
    public int getItemCount() {
        return ccemtArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage,userImage,fireIV,favoriteIV;
        TextView numberOfImageTV,numberOfCommentTV
                , text1, text2, text3
                , text4,itemTitleTV,itemPriceTV,itemNewPriceTV
                ,itemCityTV,userNameTV,oldPrice;
        RelativeLayout favoriteRL,cardButton,call_buttonRL,messageRL;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            numberOfImageTV = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_number_of_item_image);
            userImage = (ImageView) itemView.findViewById(R.id.adapter_car_for_sale_item_user_image);
            numberOfCommentTV = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_number_of_item_comment);
            itemImage = (ImageView) itemView.findViewById(R.id.adapter_car_for_sale_image_view);
            fireIV = (ImageView) itemView.findViewById(R.id.adapter_car_for_sale_fire_iv);

            text1 = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_item_text1);
            text2 = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_item_text2);
            text3 = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_item_text3);
            text4 = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_item_text4);
            itemCityTV = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_item_city);

            itemTitleTV = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_car_title);
            itemPriceTV = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_item_car_price);
            oldPrice = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_item_car_old_price);
            itemNewPriceTV = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_item_car_new_price);
            userNameTV = (TextView) itemView.findViewById(R.id.adapter_car_for_sale_item_user_name);

            favoriteIV = (ImageView) itemView.findViewById(R.id.adapter_car_for_sale_case_iv);
            favoriteRL = (RelativeLayout) itemView.findViewById(R.id.adapter_car_for_sale_case_rl);
            cardButton = (RelativeLayout) itemView.findViewById(R.id.adapter_ccemt_card_button);
            call_buttonRL = (RelativeLayout) itemView.findViewById(R.id.adapter_ccemt_call_button);
            messageRL = (RelativeLayout) itemView.findViewById(R.id.adapter_car_for_sale_m_rl);
        }
    }

}