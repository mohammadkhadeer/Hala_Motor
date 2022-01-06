package com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.cars.halamotor_obeidat.new_presenter.UserInfoP;
import com.cars.halamotor_obeidat.presnter.RelatedAds;
import com.cars.halamotor_obeidat.view.activity.ShowItemDetails;
import com.cars.halamotor_obeidat.view.activity.UserProfile;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.algorithms.FollowingTest.checkIfFollow;
import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertFollowingTable;
import static com.cars.halamotor_obeidat.dataBase.ReadFunction.getFollowing;
import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.insertFollowing;
import static com.cars.halamotor_obeidat.new_presenter.AddAndDeleteFollower.addNewFollower;
import static com.cars.halamotor_obeidat.new_presenter.AddAndDeleteFollower.deleteFollow;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserID;

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
    UserInfoP userInfoP;
    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            creatorInfo = getArguments().getParcelable("CreatorInfo");
        }
        super.onAttach(context);
        followOrNot = checkIfFollow(getActivity(), creatorInfo.getUser_id());
        if (context instanceof UserInfoP) {
            userInfoP = (UserInfoP) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
        //set userName in followID just as init value well need it to insert in
        //fireBase as object after added well updated
        //userFollowingInfo = new Following(userNameStr, creatorInfo.getPhoto(), userID, userNameStr,userNameStr);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        userInfoP = null;
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

        fillUserImageAndUserName();
        fillFollowerNumberAndFollowingNumberAndPostNumber();
        fillFollowOrNot();
        actionListenerToFollow();
        actionListenerToIV();
    }

    private void actionListenerToIV() {
        userImageIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToUserProfile();
            }
        });
    }

    private void moveToUserProfile() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("creator_info",creatorInfo);

        Intent intent = new Intent(getActivity(), UserProfile.class);
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void fillFollowerNumberAndFollowingNumberAndPostNumber() {
        numberOfPostsTV.setText(creatorInfo.getAds_count());
        numberOfFollowersTV.setText(creatorInfo.getFollowers_count());
        numberOfFollowingTV.setText(creatorInfo.getFollowing_count());
    }

    private void actionListenerToFollow() {
        followRL.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (499 < followingArrayList.size()) {
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

    private void makeButtonFreezeTowSec() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // this method cos insert and delete need some time
                test2Seconed = 1;
            }
        }, 1000);
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
        //userFollowingInfoFromDB = getFollowingObjectFromDB(userID, getActivity());
        //deleteFollowingFromUserSaid(userFollowingInfoFromDB.getFollowID(), getActivity());
        myDB.deleteFollowing(creatorInfo.getUser_id());
        deleteFollow(creatorInfo.getUser_id(),getActivity(),creatorInfo.getFollowers_count(),userInfoP);
    }

    private void fullMessage() {
        String message = getActivity().getResources().getString(R.string.u_cant);
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    private void fillFollowOrNot() {
        if (creatorInfo.getUser_id().equals(getUserID(getActivity()))) {
            followRL.setVisibility(View.GONE);
        } else {
            if (followOrNot == true) {
                followRL.setBackgroundResource(R.drawable.edit_profile);
                followTV.setText(getActivity().getResources().getString(R.string.unfollow));
                followTV.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }
    }

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

    public void updateNumberOfFollowers(String new_number) {
        numberOfFollowersTV.setText(new_number);
    }
}
