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
import com.cars.halamotor_obeidat.model.Follower;
import com.cars.halamotor_obeidat.model.Following;
import com.cars.halamotor_obeidat.model.UserProfileInfo;
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
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOrNotFromSP;
import static com.cars.halamotor_obeidat.sharedPreferences.UserInfoSP.getUserInfoFromSP;

public class UserProfileDetailsInfo extends Fragment {

    View view;
    LinearLayout linearLayout;
    TextView userNameTV, numberOfPostsTV, postsTV, numberOfFollowersTV
            , followersTV, numberOfFollowingTV, followingTV, followTV;
    RelativeLayout userStatusRL, followRL;
    ImageView userImageIV;
    String userID,type;

    Boolean followOrNot;
    long numberOfFollowing;
    int test2Seconed = 1;
    DBHelper myDB;
    ArrayList<Following> followingArrayList = new ArrayList<Following>();
    Following userFollowingInfo, userFollowingInfoFromDB;
    UserProfileInfo userProfileInfo;

    public UserProfileDetailsInfo(){}

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            userProfileInfo = getArguments().getParcelable("object");
            userID = getArguments().getString("userID");
            type = getArguments().getString("type");
        }
        super.onAttach(context);
//        if (context instanceof UserInfo) {
//            userInfo = (UserInfo) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement FragmentAListener");
//        }
    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        userInfo = null;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        myDB = getDataBaseInstance(getActivity());
        followingArrayList =getFollowing(getActivity());
        numberOfFollowing = checkIfTableFollowing(getActivity());
        inti();
        changeFont();
        getProfileInfo();

        return view;
    }

    private void getProfileInfo() {
        if (type.equals("person"))
        {
            fillInfo(userProfileInfo);
        }
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

    private void fillInfo(UserProfileInfo userProfileInfo) {
        followOrNot = checkIfFollow(getActivity(), userID);
        userFollowingInfo = new Following(userProfileInfo.getNameStr()
                , userProfileInfo.getUserImageStr(), userID, userProfileInfo.getNameStr(),userProfileInfo.getNameStr());
        fillUserImageAndUserName(userProfileInfo.getNameStr(),userProfileInfo.getUserImageStr());
        fillNumberOfPostAndAntherInfo(userProfileInfo.getNumberOfAdvStr());
        fillFollowOrNot();
        actionListenerToFollow(userProfileInfo.getNameStr(),userProfileInfo.getUserImageStr());
    }

    private void fillNumberOfPostAndAntherInfo(String numberOfAdvStr) {
        numberOfPostsTV.setText(numberOfAdvStr);
    }

    private void actionListenerToFollow(final String userNameStr, final String imagePathStr) {
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
                            addFollowing(userNameStr,imagePathStr);
                        }
                    }
                }
            }
        });
    }

    private void addFollowing(String userNameStr,String imagePathStr) {
        followRL.setBackgroundResource(R.drawable.edit_profile);
        followTV.setText(getActivity().getResources().getString(R.string.unfollow));
        followTV.setTextColor(Color.parseColor("#FFFFFF"));
        addNewFollower(getActivity(),userNameStr,imagePathStr);
        //addNewFollowing(userFollowingInfo, getActivity());
    }

    public void addNewFollower(final Context context, final String userNameStr, final String imagePathStr) {
        Follower followerInfo = getUserInfoFromSP(context);
        insertFollower(context,userID)
                .push().setValue(followerInfo
                , new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError,
                                           DatabaseReference databaseReference) {
                        String uniqueKey = databaseReference.getKey();
                        //insertFollowing(context).child(uniqueKey).child("followID").setValue(uniqueKey);
                        addNewFollowing(getActivity(),uniqueKey,userNameStr,imagePathStr);
                    }
                });
    }

    public void addNewFollowing(final Context context, final String otherID, final String userNameStr, final String imagePathStr) {
        insertFollowing(context)
                .push().setValue(userFollowingInfo
                , new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError,
                                           DatabaseReference databaseReference) {
                        String uniqueKey = databaseReference.getKey();
                        insertFollowing(context).child(uniqueKey).child("followID").setValue(uniqueKey);
                        userFollowingInfo.setFollowerIDOtherSaid(otherID);
                        Following insertFollowing = new Following(userNameStr, imagePathStr, userID, uniqueKey,otherID);
                        insertFollowingTable(insertFollowing, myDB);
                    }
                });
    }

    @SuppressLint("ResourceAsColor")
    private void deleteFollowing() {
        followRL.setBackgroundResource(R.drawable.follow_bg);
        followTV.setText(getActivity().getResources().getString(R.string.follow));
        followTV.setTextColor(R.color.colorBlue5);
        userFollowingInfoFromDB = getFollowingObjectFromDB(userID, getActivity());
        deleteFollowerFromOtherSaid(userFollowingInfoFromDB.getFollowerIDOtherSaid());
        deleteFollowingFromUserSaid(userFollowingInfoFromDB.getFollowID(), getActivity());
        myDB.deleteFollowing(userID);
    }

    private void deleteFollowingFromUserSaid(String followIDInServer, Context context) {
        insertFollowing(context).child(followIDInServer).removeValue();
    }

    private void deleteFollowerFromOtherSaid(String followIDInOtherSaid) {
        insertNewUser().child(userID).child("follower").child(followIDInOtherSaid).removeValue();
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
}