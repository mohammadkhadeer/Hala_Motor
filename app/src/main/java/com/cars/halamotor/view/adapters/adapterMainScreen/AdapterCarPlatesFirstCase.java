package com.cars.halamotor.view.adapters.adapterMainScreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.CCEMTFirestCase;
import com.cars.halamotor.model.CarPlatesFirstCase;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.ArrayList;

import static com.cars.halamotor.functions.Functions.getCarPlatesNumber;

public class AdapterCarPlatesFirstCase extends RecyclerView.Adapter<AdapterCarPlatesFirstCase.ViewHolder>{

    private final Context context;
    public ArrayList<CarPlatesFirstCase> carPlatesArrayL;
    String fromWhereCome;

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
            holder.itemPriceTV.setText(carPlatesArrayL.get(position).getItemPrice()
                    +" "+context.getResources().getString(R.string.price_contry));
            holder.itemPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            //set new price empty to stay design
            holder.itemNewPriceTV.setText("");
            holder.itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
        }else{
            holder.itemPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            //change text color
            holder.itemPriceTV.setTextColor(context.getResources().getColor(R.color.colorSilver));
            //set line above old price
            holder.itemPriceTV.setPaintFlags(holder.itemPriceTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

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

        Picasso.with(context).load(carPlatesArrayL.get(position).getItemImage())
                .config(Bitmap.Config.RGB_565)
                .fit().centerCrop()
                .into(holder.itemImage);

        Picasso.with(context).load(carPlatesArrayL.get(position).getItemUserImage())
                .config(Bitmap.Config.RGB_565)
                .fit().centerCrop()
                .into(holder.userImage);
    }


    @Override
    public int getItemCount() {
        return carPlatesArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage,userImage,fireIV;
        TextView numberOfImageTV,numberOfCommentTV
                , text1
                , text4,itemTitleTV,itemPriceTV,itemNewPriceTV,itemCityTV
                ,userNameTV;

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
            itemNewPriceTV = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_new_price);
            userNameTV = (TextView) itemView.findViewById(R.id.adapter_car_plates_first_case_user_name);

        }
    }

}