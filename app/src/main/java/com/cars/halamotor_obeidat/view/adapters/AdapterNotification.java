package com.cars.halamotor_obeidat.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CategoryComp;
import com.cars.halamotor_obeidat.model.NotificationComp;
import com.cars.halamotor_obeidat.view.activity.AboutUs;
import com.cars.halamotor_obeidat.view.activity.ShowItemDetails;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.functions.FillText.getTextEngOrLocal;
import static com.cars.halamotor_obeidat.functions.Functions.splitNotification;
import static com.cars.halamotor_obeidat.functions.Functions.splitString;

public class AdapterNotification extends RecyclerView.Adapter<AdapterNotification.ViewHolder>{

    private final Context context;
    public ArrayList<NotificationComp> notificationCompsArrayL ;

    public AdapterNotification
            (Context context, ArrayList<NotificationComp> notificationCompsArrayL)
    {   this.context = context;
        this.notificationCompsArrayL = notificationCompsArrayL;
    }

    public AdapterNotification.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_notification, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterNotification.ViewHolder holder, final int position) {
        changeFont(context, holder);
//        Log.i("TAG","Image path: "+notificationCompsArrayL.get(position).getImagePath());
        changeNotificationColorIfUserOpen(position,holder,context);
        fillTextHeadAndDes(context,position,holder);
        fillProcessImageAndUserUserImage(context,holder,position);
        fillProcessName(position,context,holder);
        actionListenerToNotification(context,holder,position);
    }

    private void fillProcessName(int position, Context context, ViewHolder holder) {
        if (!notificationCompsArrayL.get(position).getInOrOut().equals("welcome"))
        {
            String[] stringProcess = splitNotification(notificationCompsArrayL.get(position).getProcess());
            holder.processTV.setText(getTextEngOrLocal(context,stringProcess[0],stringProcess[1]));
        }else{
            holder.processTV.setText(notificationCompsArrayL.get(position).getProcess());
        }
    }

    private void fillProcessImageAndUserUserImage(Context context, ViewHolder holder, int position) {
        if (notificationCompsArrayL.get(position).getInOrOut().equals("welcome"))
        {
            Picasso.get()
                    .load(R.drawable.logo)
                    .fit()
                    .centerCrop()
                    .into(holder.processIV);
        }else {
            if (notificationCompsArrayL.get(position).getImagePath().equals("no_image"))
            {
                Picasso.get()
                        .load(R.drawable.no_image)
                        .fit()
                        .centerCrop()
                        .into(holder.processIV);
            }else{
                Picasso.get()
                        .load(notificationCompsArrayL.get(position).getImagePath())
                        .fit()
                        .centerCrop()
                        .into(holder.processIV);
            }

        }

    }

    private void actionListenerToNotification(final Context context, final ViewHolder holder, final int position) {
        holder.coverRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.coverRL.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));
                if (notificationCompsArrayL.get(position).getInOrOut().equals("welcome"))
                {
                    moveToAboutUs();
                }else{
                    getDataBaseInstance(context).updateNotification(notificationCompsArrayL.get(position).getItemServerID(),"1");
                    transporteToShowItemSelectedDetails(context,position,holder);
                }
            }
        });
    }

    private void moveToAboutUs() {
        Intent intent = new Intent(context, AboutUs.class);
        ((Activity)context).startActivity(intent);
        ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void transporteToShowItemSelectedDetails(Context context, int position, ViewHolder holder) {
        String cat =notificationCompsArrayL.get(position).getProcess();
        String cat_en,cat_ar;
        String[] cat_en_and_ar = splitString(cat,"#");
        cat_en = cat_en_and_ar[0];
        cat_ar = cat_en_and_ar[1];

        String category_id =notificationCompsArrayL.get(position).getCategory_id();

        CategoryComp categoryComp =null;

        if (cat_en.equals("Car for sale"))
        {
            categoryComp = new CategoryComp(0,category_id,"car_for_sale"
                    ,context.getResources().getString(R.string.car_for_sale)
            ,cat_en
            ,cat_ar);
        }
        if (cat_en.equals("Car for rent"))
        {
            categoryComp = new CategoryComp(0,category_id,"car_for_rent"
                    ,context.getResources().getString(R.string.car_for_rent_s)
                    ,cat_en
                    ,cat_ar);
        }
        if (cat_en.equals("Exchange"))
        {
            categoryComp = new CategoryComp(0,category_id,"exchange"
                    ,context.getResources().getString(R.string.exchange_car_s)
                    ,cat_en
                    ,cat_ar);
        }

        if (cat_en.equals("Plates"))
        {
            categoryComp = new CategoryComp(0,category_id,"plates"
                    ,context.getResources().getString(R.string.car_plates_s)
                    ,cat_en
                    ,cat_ar);
        }
        if (cat_en.equals("Wheels rim"))
        {
            categoryComp = new CategoryComp(0,category_id,"wheels_rim"
                    ,context.getResources().getString(R.string.wheels_rim_s)
                    ,cat_en
                    ,cat_ar);

        }
        if (cat_en.equals("Junk car"))
        {
            categoryComp = new CategoryComp(0,category_id,"junk_car"
                    ,context.getResources().getString(R.string.junk_car_s)
                    ,cat_en
                    ,cat_ar);
        }

//        Log.i("TAG","image_id:"+ String.valueOf(categoryComp.getImageIdInt()));
//        Log.i("TAG","category_id:"+ categoryComp.getId());
//        Log.i("TAG","code:"+ categoryComp.getCode());
//        Log.i("TAG","name:"+ categoryComp.getName());
//        Log.i("TAG","name_en:"+ categoryComp.getName_en());
//        Log.i("TAG","name_ar:"+ categoryComp.getName_ar());
//
//        Log.i("TAG","ad_id:"+ notificationCompsArrayL.get(position).getItemServerID());

        Bundle bundle = new Bundle();
        bundle.putString("category",categoryComp.getCode());
        bundle.putParcelable("category_comp",categoryComp);
        bundle.putString("from","ml");
        bundle.putString("itemID",notificationCompsArrayL.get(position).getItemServerID());

        Intent intent = new Intent(context, ShowItemDetails.class);
        intent.putExtras(bundle);
        ((Activity)context).startActivity(intent);
        ((Activity)context).overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void fillTextHeadAndDes(Context context, int position, ViewHolder holder) {
        holder.notificationTitleTV.setText(notificationCompsArrayL.get(position).getNotificationTitle());
        String notificationDes = null;

        if (notificationCompsArrayL.get(position).getInOrOut().equals("welcome")) {
            notificationDes = context.getResources().getString(R.string.welcome_notifications);
        }

        if (notificationCompsArrayL.get(position).getInOrOut().equals("out") || notificationCompsArrayL.get(position).getInOrOut().equals("in")) {
            if (notificationCompsArrayL.get(position).getInOrOut().equals("out"))
            {
                notificationDes = context.getResources().getString(R.string.ur_product) + " " + notificationCompsArrayL.get(position).getNotificationTitle() + " " + context.getResources().getString(R.string.live);
            }else{
//                String[] stringProcess = splitNotification(notificationCompsArrayL.get(position).getProcess());
//                + getTextEngOrLocal(context,stringProcess[0],stringProcess[1])
                notificationDes = notificationCompsArrayL.get(position).getCreator_name() + " " +context.getResources().getString(R.string.new_post)
                        + " " + notificationCompsArrayL.get(position).getAds_des();
            }
        }

        holder.notificationDesTV.setText(notificationDes);
    }

    private void changeNotificationColorIfUserOpen(int position, ViewHolder holder,Context context) {
        if (notificationCompsArrayL.get(position).getOpenOrNotYet().equals("0"))
        {
            holder.coverRL.setBackgroundColor(ContextCompat.getColor(context, R.color.notificationNotOpenYet));
        }else{
            holder.coverRL.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite));
        }
    }

    private void changeFont(Context context, ViewHolder holder) {
        holder.notificationTitleTV.setTypeface(Functions.changeFontBold(context));
        holder.notificationDesTV.setTypeface(Functions.changeFontGeneral(context));
        holder.processTV.setTypeface(Functions.changeFontGeneral(context));
    }

    @Override
    public int getItemCount() {
        return notificationCompsArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView processIV;
        TextView notificationTitleTV,notificationDesTV,processTV;
        RelativeLayout coverRL;
        public ViewHolder(View itemView) {
            super(itemView);
            notificationTitleTV = (TextView) itemView.findViewById(R.id.adapter_notification_head_tv);
            notificationDesTV = (TextView) itemView.findViewById(R.id.adapter_notification_des_tv);
            processTV = (TextView) itemView.findViewById(R.id.adapter_notification_process_tv);
            processIV = (ImageView) itemView.findViewById(R.id.adapter_notification_process_iv) ;
            coverRL = (RelativeLayout) itemView.findViewById(R.id.adapter_notification_cover) ;
        }
    }

}