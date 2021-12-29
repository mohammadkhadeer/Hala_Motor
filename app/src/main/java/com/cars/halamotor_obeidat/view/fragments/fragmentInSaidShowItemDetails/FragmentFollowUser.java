package com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.dataBase.DBHelper;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CreatorInfo;
import com.cars.halamotor_obeidat.model.Following;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.ReadFunction.getFollowing;
import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.getUserPathInServer;
import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.insertFollowing;

public class FragmentFollowUser extends Fragment {

    public FragmentFollowUser() {
    }

    Boolean followOrNot;
    String followerToken;
    View view;
    TextView userNameTV, numberOfPostsTV, postsTV, numberOfFollowersTV
            , followersTV, numberOfFollowingTV, followingTV, followTV;
    RelativeLayout userStatusRL, followRL;
    ImageView userImageIV;
    Following userFollowingInfo, userFollowingInfoFromDB;
    DBHelper myDB;
    ArrayList<Following> followingArrayList = new ArrayList<Following>();
    int test2Seconed = 1;
    CreatorInfo creatorInfo;
    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            creatorInfo = getArguments().getParcelable("CreatorInfo");
        }
        super.onAttach(context);
        //followOrNot = checkIfFollow(getActivity(), userID);
        //set userName in followID just as init value well need it to insert in
        //fireBase as object after added well updated
        //userFollowingInfo = new Following(userNameStr, creatorInfo.getPhoto(), userID, userNameStr,userNameStr);
    }

    private void inti() {
        userImageIV = (ImageView) view.findViewById(R.id.fragment_follow_image_IV);
        userNameTV = (TextView) view.findViewById(R.id.fragment_follow_user_name_TV);
        userStatusRL = (RelativeLayout) view.findViewById(R.id.fragment_follow_status);
        numberOfPostsTV = (TextView) view.findViewById(R.id.fragment_follow_number_post_TV);
        postsTV = (TextView) view.findViewById(R.id.fragment_follow_post_TV);
        numberOfFollowersTV = (TextView) view.findViewById(R.id.fragment_follow_number_followers_TV);
        followersTV = (TextView) view.findViewById(R.id.fragment_follow_followers_TV);
        numberOfFollowingTV = (TextView) view.findViewById(R.id.fragment_follow_number_following_TV);
        followingTV = (TextView) view.findViewById(R.id.fragment_follow_following_TV);
        followTV = (TextView) view.findViewById(R.id.fragment_follow_follow_TV);
        followRL = (RelativeLayout) view.findViewById(R.id.fragment_follow_follow_RL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_follow_user, container, false);
        inti();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeFont();
        myDB = getDataBaseInstance(getActivity());
        followingArrayList =getFollowing(getActivity());
//        for (int i =0;i<followingArrayList.size();i++)
//        {
//            Log.i("TAG","FollowOtherSaid "+ followingArrayList.get(i).getFollowerIDOtherSaid());
//            Log.i("TAG","FollowID "+ followingArrayList.get(i).getFollowID());
//            Log.i("TAG","userID"+ followingArrayList.get(i).getUserID());
//            Log.i("TAG","USERID "+ userID);
//        }



        fillUserImageAndUserName();
        fillFollowerNumberAndFollowingNumberAndPostNumber();
//        fillFollowOrNot();
//        actionListenerToFollow();
//        actionListenerToIV();
    }

    private void fillFollowerNumberAndFollowingNumberAndPostNumber() {
        numberOfPostsTV.setText(creatorInfo.getAds_count());
        numberOfFollowersTV.setText(creatorInfo.getFollowers_count());
        numberOfFollowingTV.setText(creatorInfo.getFollowing_count());
    }

//    private void actionListenerToFollow() {
//        followRL.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceAsColor")
//            @Override
//            public void onClick(View v) {
//                if (499 < numberOfFollowing) {
//                    fullMessage();
//                } else {
//                    if (test2Seconed == 1) {
//                        test2Seconed = 0;
//                        makeButtonFreezeTowSec();
//                        if (followTV.getText().toString().equals(getActivity().getResources().getString(R.string.unfollow))) {
//                            deleteFollowing();
//                        } else {
//                            addFollowing();
//                        }
//                    }
//                }
//            }
//        });
//    }

    private void makeButtonFreezeTowSec() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // this method cos insert and delete need some time
                test2Seconed = 1;
            }
        }, 2000);
    }

    private void addFollowing() {
        followRL.setBackgroundResource(R.drawable.edit_profile);
        followTV.setText(getActivity().getResources().getString(R.string.unfollow));
        followTV.setTextColor(Color.parseColor("#FFFFFF"));
        //addNewFollowing(userFollowingInfo, getActivity());
    }

    @SuppressLint("ResourceAsColor")
    private void deleteFollowing() {
        followRL.setBackgroundResource(R.drawable.follow_bg);
        followTV.setText(getActivity().getResources().getString(R.string.follow));
        followTV.setTextColor(R.color.colorBlue5);
        //userFollowingInfoFromDB = getFollowingObjectFromDB(userID, getActivity());
        deleteFollowingFromUserSaid(userFollowingInfoFromDB.getFollowID(), getActivity());
        //myDB.deleteFollowing(userID);
    }

    private void fullMessage() {
        String message = getActivity().getResources().getString(R.string.u_cant);
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

//    private void fillFollowOrNot() {
//        if (userID.equals(getUserIdInServerFromSP(getActivity()))) {
//            followRL.setVisibility(View.GONE);
//        } else {
//            if (followOrNot == true) {
//                followRL.setBackgroundResource(R.drawable.edit_profile);
//                followTV.setText(getActivity().getResources().getString(R.string.unfollow));
//                followTV.setTextColor(Color.parseColor("#FFFFFF"));
//            }
//        }
//    }

    private void fillUserImageAndUserName() {
        Picasso.get()
                .load(creatorInfo.getPhoto())
                .fit()
                .centerCrop()
                .into(userImageIV);

        userNameTV.setText(creatorInfo.getName());
    }

    private void changeFont() {
        userNameTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        numberOfPostsTV.setTypeface(Functions.changeFontBold(getActivity()));
        postsTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        numberOfFollowersTV.setTypeface(Functions.changeFontBold(getActivity()));
        followersTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        numberOfFollowingTV.setTypeface(Functions.changeFontBold(getActivity()));
        followingTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        followTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        // userStatusTV.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    //here well set connection with server here cos cant return in fireBase database
    public void getNumberOfAdsFromServer(String userID) {
        getUserPathInServer(userID).child("numberOfAds")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            numberOfPostsTV.setText(dataSnapshot.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }

                });

    }

    private void deleteFollowingFromUserSaid(String followIDInServer, Context context) {
        insertFollowing(context).child(followIDInServer).removeValue();
    }
}
