package com.cars.halamotor_obeidat.view.fragments.userProfileFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.dataBase.DBHelper;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CreatorInfo;
import com.cars.halamotor_obeidat.model.Follower;
import com.cars.halamotor_obeidat.model.Following;
import com.cars.halamotor_obeidat.model.UserProfileInfo;
import com.cars.halamotor_obeidat.new_presenter.UserInfoP;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.algorithms.FollowingTest.checkIfFollow;
import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertFollowingTable;
import static com.cars.halamotor_obeidat.dataBase.ReadFunction.checkIfTableFollowing;
import static com.cars.halamotor_obeidat.dataBase.ReadFunction.getFollowing;
import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.insertFollower;
import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.insertFollowing;
import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.insertNewUser;
import static com.cars.halamotor_obeidat.functions.HandelItemObjectBeforePass.getFollowingObjectFromDB;
import static com.cars.halamotor_obeidat.new_presenter.AddAndDeleteFollower.addNewFollower;
import static com.cars.halamotor_obeidat.new_presenter.AddAndDeleteFollower.deleteFollow;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserID;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOrNotFromSP;
import static com.cars.halamotor_obeidat.sharedPreferences.UserInfoSP.getUserInfoFromSP;

public class UserProfileDetailsInfo extends Fragment {

    View view;
    LinearLayout linearLayout;
    TextView userNameTV, numberOfPostsTV, postsTV, numberOfFollowersTV
            , followersTV, numberOfFollowingTV, followingTV, followTV;
    RelativeLayout userStatusRL, followRL;
    ImageView userImageIV;

    Boolean followOrNot;
    long numberOfFollowing;
    int test2Seconed = 1;
    DBHelper myDB;
    ArrayList<Following> followingArrayList = new ArrayList<Following>();
    Following  userFollowingInfoFromDB;

    CreatorInfo creatorInfo;

    public UserProfileDetailsInfo(){}
    UserInfoP userInfoP;

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            creatorInfo = getArguments().getParcelable("creator_info");
        }
        super.onAttach(context);
        if (context instanceof UserInfoP) {
            userInfoP = (UserInfoP) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        userInfoP = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        inti();
        myDB = getDataBaseInstance(getActivity());
        followingArrayList =getFollowing(getActivity());
        if (creatorInfo.getUser_id().equals(getUserID(getActivity())))
        {
            followRL.setVisibility(View.GONE);
        }else{
            followRL.setVisibility(View.VISIBLE);
        }
        numberOfFollowing = checkIfTableFollowing(getActivity());


        changeFont();

        fillInfo();


        return view;
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
    }

    private void inti() {
        linearLayout = (LinearLayout) view.findViewById(R.id.fragment_user_profile_cover);

        userImageIV = (ImageView) view.findViewById(R.id.fragment_user_profile_image_IV);
        userNameTV = (TextView) view.findViewById(R.id.fragment_user_profile_user_name_TV);
        userStatusRL = (RelativeLayout) view.findViewById(R.id.fragment_user_profile_status);
        numberOfPostsTV = (TextView) view.findViewById(R.id.fragment_user_profile_number_post_TV);
        postsTV = (TextView) view.findViewById(R.id.fragment_user_profile_post_TV);
        numberOfFollowersTV = (TextView) view.findViewById(R.id.fragment_user_profile_number_followers_TV);
        followersTV = (TextView) view.findViewById(R.id.fragment_user_profile_followers_TV);
        numberOfFollowingTV = (TextView) view.findViewById(R.id.fragment_user_profile_number_following_TV);
        followingTV = (TextView) view.findViewById(R.id.fragment_user_profile_following_TV);
        followTV = (TextView) view.findViewById(R.id.fragment_user_profile_follow_TV);
        followRL = (RelativeLayout) view.findViewById(R.id.fragment_user_profile_follow_RL);
    }

    private void fillInfo() {
        followOrNot = checkIfFollow(getActivity(), creatorInfo.getUser_id());

        fillUserImageAndUserName(creatorInfo.getName(),creatorInfo.getPhoto());
        fillNumberOfPostAndAntherInfo(creatorInfo.getAds_count());
        numberOfFollowersTV.setText(creatorInfo.getFollowers_count());
        numberOfFollowingTV.setText(creatorInfo.getFollowing_count());
        fillFollowOrNot();
        actionListenerToFollow();
    }

    private void fillNumberOfPostAndAntherInfo(String numberOfAdvStr) {
        numberOfPostsTV.setText(numberOfAdvStr);
    }

    private void actionListenerToFollow() {
        followRL.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (499 < numberOfFollowing) {
                    fullMessage();
                } else {
                    if (test2Seconed == 1) {
                        test2Seconed = 0;
                        makeButtonFreezeTowSec();
                        if (followTV.getText().toString().equals(getActivity().getResources().getString(R.string.unfollow))) {
                            deleteFollowing();
                        } else {
                            addFollowing();
                        }
                    }
                }
            }
        });
    }

    private void addFollowing() {
        followRL.setBackgroundResource(R.drawable.edit_profile);
        followTV.setText(getActivity().getResources().getString(R.string.unfollow));
        followTV.setTextColor(Color.parseColor("#FFFFFF"));
        addNewFollowing();
    }

    private void addNewFollowing() {
        insertFollowingTable(creatorInfo,myDB);
        addNewFollower(creatorInfo.getUser_id(),getActivity(),creatorInfo.getFollowers_count(),userInfoP);
    }

    @SuppressLint("ResourceAsColor")
    private void deleteFollowing() {
        followRL.setBackgroundResource(R.drawable.follow_bg);
        followTV.setText(getActivity().getResources().getString(R.string.follow));
        followTV.setTextColor(R.color.colorBlue5);

        myDB.deleteFollowing(creatorInfo.getUser_id());
        deleteFollow(creatorInfo.getUser_id(),getActivity(),creatorInfo.getFollowers_count(),userInfoP);
    }

    private void makeButtonFreezeTowSec() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // this method cos insert and delete need some time
                test2Seconed = 1;
            }
        }, 2000);
    }

    private void fullMessage() {
        String message = getActivity().getResources().getString(R.string.u_cant);
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    private void fillFollowOrNot() {
            if (followOrNot == true) {
                followRL.setBackgroundResource(R.drawable.edit_profile);
                followTV.setText(getActivity().getResources().getString(R.string.unfollow));
                followTV.setTextColor(Color.parseColor("#FFFFFF"));
            }
    }

    private void fillUserImageAndUserName(String userNameStr,String imagePathStr) {
        Picasso.get()
                .load(imagePathStr)
                .fit()
                .centerCrop()
                .into(userImageIV);

        userNameTV.setText(userNameStr);
    }

    public void updateNumberOfFollower(String new_number) {
        numberOfFollowersTV.setText(new_number);
    }
}