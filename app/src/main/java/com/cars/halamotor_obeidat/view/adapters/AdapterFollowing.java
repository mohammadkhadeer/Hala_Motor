package com.cars.halamotor_obeidat.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.Following;
import com.cars.halamotor_obeidat.view.activity.UserProfile;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class AdapterFollowing extends RecyclerView.Adapter<AdapterFollowing.ViewHolder>{

    private final Context context;
    public ArrayList<Following> followingArrayL ;
    String typeFollowingOrFollower;

    public AdapterFollowing
            (Context context, ArrayList<Following> followingArrayL,String typeFollowingOrFollower)
    {   this.context = context;
        this.followingArrayL = followingArrayL;
        this.typeFollowingOrFollower = typeFollowingOrFollower;
    }

    public AdapterFollowing.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_following, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterFollowing.ViewHolder holder, final int position) {
        changeFont(context, holder);
        fillFollowingName(context,position,holder);
        fillImageUserImage(context,holder,position);
        actionListenerToCard(context,holder,position);
    }

    private void fillFollowingName(Context context, int position, ViewHolder holder) {
        holder.followingNameTV.setText(followingArrayL.get(position).getName());
    }

    private void fillImageUserImage(Context context, ViewHolder holder, int position) {
        Picasso.get()
                .load(followingArrayL.get(position).getImage())
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    private void actionListenerToCard(final Context context, final ViewHolder holder, final int position) {
        holder.coverRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToShowItemSelectedDetails(context,position,holder);
            }
        });
    }

    private void moveToShowItemSelectedDetails(Context context, int position, ViewHolder holder) {
        Bundle bundle = new Bundle();
        bundle.putString("userID",followingArrayL.get(position).getUserID());
        bundle.putString("type","person");

        Intent intent = new Intent(context, UserProfile.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
//        context.getApplicationContext().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }



    private void changeFont(Context context, ViewHolder holder) {
        holder.followingNameTV.setTypeface(Functions.changeFontBold(context));
        holder.followingTextTV.setTypeface(Functions.changeFontGeneral(context));
    }

    @Override
    public int getItemCount() {
        return followingArrayL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView followingNameTV,followingTextTV;
        RelativeLayout coverRL;
        public ViewHolder(View itemView) {
            super(itemView);
            followingNameTV = (TextView) itemView.findViewById(R.id.adapter_following_following_name_tv);
            followingTextTV = (TextView) itemView.findViewById(R.id.adapter_following_text_tv);
            imageView = (ImageView) itemView.findViewById(R.id.adapter_following_process_iv) ;
            coverRL = (RelativeLayout) itemView.findViewById(R.id.adapter_following_container_RL) ;
        }
    }

}