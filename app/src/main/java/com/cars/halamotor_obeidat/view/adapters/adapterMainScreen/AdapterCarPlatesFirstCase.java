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
import com.cars.halamotor_obeidat.model.CarPlatesFirstCase;
import com.cars.halamotor_obeidat.permission.CheckPermission;
import com.cars.halamotor_obeidat.view.activity.ShowItemDetails;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

import static com.cars.halamotor_obeidat.algorithms.ArrangingLists.checkFavouriteOrNot1;
import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertItemsToFCS;
import static com.cars.halamotor_obeidat.fireBaseDB.UpdateFireBase.setFavouriteCallSearchOnServer;
import static com.cars.halamotor_obeidat.functions.Functions.convertCategoryToCategoryS;
import static com.cars.halamotor_obeidat.functions.Functions.getCarPlatesNumber;
import static com.cars.halamotor_obeidat.functions.Functions.openWhatsApp;
import static com.cars.halamotor_obeidat.functions.NewFunction.callAds;

public class AdapterCarPlatesFirstCase extends RecyclerView.Adapter<AdapterCarPlatesFirstCase.ViewHolder>{

    private final Context context;
    public ArrayList<CarPlatesFirstCase> carPlatesArrayL;
    String fromWhereCome;
    private static final int REQUEST_SHOW_ITEM_SELECTED_DETAILS = 100;

    public AdapterCarPlatesFirstCase
            (Context context, ArrayList<CarPlatesFirstCase> carPlatesArrayL
            ,String fromWhereCome)
    {   this.context = context;
        this.carPlatesArrayL = carPlatesArrayL;
        this.fromWhereCome = fromWhereCome;
    }

    public AdapterCarPlatesFirstCase.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_car_plates_first_case, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCarPlatesFirstCase.ViewHolder holder, final int position) {
        if (carPlatesArrayL.get(position).getItemActiveOrNot().equals("1")) {
            fillImage(holder, position, context);
            fillTitleAndUserName(holder, position, context);
            fillPrice(holder, position, context);
            checkIfCarPlatesSpecialNumber(holder,position);
            changeFont(context, holder);
            fillNumberOfImageAndNumberOfComment(holder, position);
            fillCarDetails(position, holder);
            checkIfFavouriteOrNot(context,holder,position);
            actionListenerToFavorite(context,holder,position);
            actionListenerToMessage(context,holder,position);
            actionListenerToCard(context,position,holder);
            actionListenerToCallButn(context,position,holder);
        }
    }

    private void actionListenerToMessage(final Context context, ViewHolder holder, final int position) {
        holder.messageRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItemsToFCS(carPlatesArrayL.get(position).getItemIdInServer(),convertCategoryToCategoryS("Plates",context),getDataBaseInstance(context),"message",context);
                setFavouriteCallSearchOnServer(context,carPlatesArrayL.get(position).getItemIdInServer(),"Plates","message");
                openWhatsApp(carPlatesArrayL.get(position).getItemUserPhoneNumber(),context);
            }
        });
    }

    private void actionListenerToCard(final Context context, final int position, ViewHolder holder) {
        holder.cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItemsToFCS(carPlatesArrayL.get(position).getItemIdInServer(),convertCategoryToCategoryS("Plates",context)
                        ,getDataBaseInstance(context),"seen",context);

                setFavouriteCallSearchOnServer(context,carPlatesArrayL.get(position).getItemIdInServer()
                        ,"Plates","seen");

                Bundle bundle = new Bundle();
                bundle.putString("category","Car plates");
                bundle.putString("from","ml");
                bundle.putString("itemID",carPlatesArrayL.get(position).getItemIdInServer());

                Intent intent = new Intent(context, ShowItemDetails.class);
                intent.putExtras(bundle);
                ((Activity)context).startActivityForResult(intent , REQUEST_SHOW_ITEM_SELECTED_DETAILS);
                ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
        });
    }

    private void actionListenerToCallButn(final Context context, final int position, final ViewHolder holder) {
        holder.callButtonRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.callButtonRL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (CheckPermission.checkPermissionMethodToPhone((Activity) context) == true) {
                            insertItemsToFCS(carPlatesArrayL.get(position).getItemIdInServer(),convertCategoryToCategoryS("Plates",context)
                                    ,getDataBaseInstance(context),"call",context);

                            setFavouriteCallSearchOnServer(context,carPlatesArrayL.get(position).getItemIdInServer(),"Plates","call");
                            callAds(context,carPlatesArrayL.get(position).getItemUserPhoneNumber());
                        }
                    }
                });
            }
        });
    }


    private void actionListenerToFavorite(final Context context, final ViewHolder holder, final int position) {
        holder.favoriteRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkFavouriteOrNot1(context,carPlatesArrayL.get(position).getItemIdInServer()).equals("not_favorite"))
                {
                    holder.favoriteIV.setBackgroundResource(R.drawable.selcted_favorite);
                    insertItemsToFCS(carPlatesArrayL.get(position).getItemIdInServer(),convertCategoryToCategoryS("Plates",context)
                            ,getDataBaseInstance(context),"favorite",context);

                    setFavouriteCallSearchOnServer(context,carPlatesArrayL.get(position).getItemIdInServer()
                            ,"Plates","favorite");
                }else
                {
                    holder.favoriteIV.setBackgroundResource(R.drawable.item_favu);
                    getDataBaseInstance(context).deleteFCS(carPlatesArrayL.get(position).getItemIdInServer());
                }
            }
        });
    }

    private void checkIfFavouriteOrNot(Context context, ViewHolder holder, int position) {
        if (checkFavouriteOrNot1(context,carPlatesArrayL.get(position).getItemIdInServer()).equals("not_favorite"))
        {
            holder.favoriteIV.setBackgroundResource(R.drawable.item_favu);
        }else
        {
            holder.favoriteIV.setBackgroundResource(R.drawable.selcted_favorite);
        }
    }

    private void checkIfCarPlatesSpecialNumber(ViewHolder holder, int position) {
        if (carPlatesArrayL.get(position).getSpecialOrNot().equals("1"))
        {
            holder.fireIV.setVisibility(View.VISIBLE);
        }
    }

    private void fillPrice(ViewHolder holder, int position, Context context) {
        if (carPlatesArrayL.get(position).getItemPostEdit().equals("0"))
        {
            holder.itemPriceTV.setVisibility(View.VISIBLE);
            holder.oldPrice.setVisibility(View.GONE);
            holder.fireIV.setVisibility(View.GONE);
            holder.itemPriceTV.setText(carPlatesArrayL.get(position).getItemPrice()
                    +" "+context.getResources().getString(R.string.price_contry));
            holder.itemPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            //set new price empty to stay design
            holder.itemNewPriceTV.setText("");
            holder.itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
        }else{
            holder.itemPriceTV.setVisibility(View.GONE);
            holder.oldPrice.setVisibility(View.VISIBLE);

            holder.oldPrice.setText(carPlatesArrayL.get(position).getItemPrice());
            //change text color
            holder.oldPrice.setTextColor(context.getResources().getColor(R.color.colorSilver));
            //set line above old price
            holder.oldPrice.setPaintFlags(holder.itemPriceTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            //change size new price
            holder.itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);

            holder.itemNewPriceTV.setText(carPlatesArrayL.get(position).getItemNewPrice()
                    +" "+context.getResources().getString(R.string.price_contry));
            //fill old price
            holder.itemPriceTV.setText(carPlatesArrayL.get(position).getItemPrice()
                    +" "+context.getResources().getString(R.string.price_contry));
            //VISIBLE fire image view
            holder.fireIV.setVisibility(View.VISIBLE);

        }
    }

    private void fillTitleAndUserName(ViewHolder holder, int position, Context context) {
        holder.itemTitleTV.setText(carPlatesArrayL.get(position).getItemName());
        holder.userNameTV.setText(carPlatesArrayL.get(position).getItemUserName());
    }

    private void fillCarDetails(int position, ViewHolder holder) {
        holder.text1.setText(carPlatesArrayL.get(position).getCarPlatesCity());
        holder.text4.setText(getCarPlatesNumber(carPlatesArrayL.get(position).getCarPlatesNumber()));
        holder.itemCityTV.setText(carPlatesArrayL.get(position).getItemCity());

    }

    private void changeFont(Context context, ViewHolder holder) {
        holder.numberOfImageTV.setTypeface(Functions.changeFontGeneral(context));
        holder.numberOfCommentTV.setTypeface(Functions.changeFontGeneral(context));
        holder.text1.setTypeface(Functions.changeFontGeneral(context));
        holder.text4.setTypeface(Functions.changeFontGeneral(context));
        holder.itemCityTV.setTypeface(Functions.changeFontGeneral(context));
        holder.userNameTV.setTypeface(Functions.changeFontGeneral(context));

        holder.itemPriceTV.setTypeface(Functions.changeFontBold(context));
        holder.itemTitleTV.setTypeface(Functions.changeFontBold(context));
    }

    private void fillNumberOfImageAndNumberOfComment(ViewHolder holder, int position) {
        holder.numberOfCommentTV.setText(carPlatesArrayL.get(position).getItemNumberOfComments());
        holder.numberOfImageTV.setText(carPlatesArrayL.get(position).getItemNumberOfImage());
    }

    private void fillImage(final ViewHolder holder, int position, Context context) {

        Picasso.get()
                .load(carPlatesArrayL.get(position).getItemImage())
                .fit()
                .centerCrop()
                .into(holder.itemImage);

        Picasso.get()
                .load(carPlatesArrayL.get(position).getItemUserImage())
                .fit()
                .centerCrop()
                .into(holder.userImage);
    }


    @Override
    public int getItemCount() {
        return carPlatesArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage,userImage,fireIV,favoriteIV;
        TextView numberOfImageTV,numberOfCommentTV
                , text1
                , text4,itemTitleTV,itemPriceTV,itemNewPriceTV
                ,itemCityTV,userNameTV,oldPrice;
        RelativeLayout favoriteRL,callButtonRL,cardButton,messageRL;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            numberOfImageTV = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_item_image);
            userImage = (ImageView) itemView.findViewById(R.id.adapter_car_plates_first_case_user_image);
            numberOfCommentTV = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_number_of_item_comment);
            itemImage = (ImageView) itemView.findViewById(R.id.adapter_car_plates_first_case_image_view);
            fireIV = (ImageView) itemView.findViewById(R.id.adapter_car_plates_first_case_fire_iv);

            text1 = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_text1);
            text4 = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_text4);
            itemCityTV = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_city);

            itemTitleTV = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_title);
            itemPriceTV = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_price);

            oldPrice = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_old_price);

            itemNewPriceTV = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_new_price);
            userNameTV = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_user_name);

            favoriteIV = (ImageView) itemView.findViewById(R.id.adapter_car_plates_first_f_image);
            favoriteRL = (RelativeLayout) itemView.findViewById(R.id.adapter_car_plates_first_f_rl);
            callButtonRL = (RelativeLayout) itemView.findViewById(R.id.adapter_car_plates_call_button);
            messageRL = (RelativeLayout) itemView.findViewById(R.id.adapter_car_plates_first_m_rl);
            cardButton = (RelativeLayout) itemView.findViewById(R.id.adapter_car_plates_card_button);

        }
    }

}