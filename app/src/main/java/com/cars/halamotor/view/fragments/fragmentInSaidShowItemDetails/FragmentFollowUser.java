package com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.dataBase.DBHelper;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.Follower;
import com.cars.halamotor.model.Following;
import com.cars.halamotor.view.activity.UserProfile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.cars.halamotor.algorithms.FollowingTest.checkIfFollow;
import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.dataBase.InsertFunctions.insertFollowingTable;
import static com.cars.halamotor.dataBase.ReadFunction.checkIfTableFollowing;
import static com.cars.halamotor.dataBase.ReadFunction.getFollowing;
import static com.cars.halamotor.fireBaseDB.FireBaseDBPaths.getUserPathInServer;
import static com.cars.halamotor.fireBaseDB.FireBaseDBPaths.insertFollower;
import static com.cars.halamotor.fireBaseDB.FireBaseDBPaths.insertFollowing;
import static com.cars.halamotor.fireBaseDB.FireBaseDBPaths.insertNewUser;
import static com.cars.halamotor.functions.HandelItemObjectBeforePass.getFollowingObjectFromDB;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserIdInServerFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.saveServerIDInfoInSP;
import static com.cars.halamotor.sharedPreferences.UserInfoSP.getUserInfoFromSP;

public class FragmentFollowUser extends Fragment {

    public FragmentFollowUser() {
    }

    String categoryStr, userNameStr, userImage, userID;
    Boolean followOrNot;
    String followerToken;
    long numberOfFollowing;
    View view;
    TextView userNameTV, numberOfPostsTV, postsTV, numberOfFollowersTV
            , followersTV, numberOfFollowingTV, followingTV, followTV;
    RelativeLayout userStatusRL, followRL;
    ImageView userImageIV;
    Following userFollowingInfo, userFollowingInfoFromDB;
    DBHelper myDB;
    ArrayList<Following> followingArrayList = new ArrayList<Following>();
    int test2Seconed = 1;

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            categoryStr = getArguments().getString("category");
            userNameStr = getArguments().getString("userName");
            userImage = getArguments().getString("userImage");
            userID = getArguments().getString("userID");
        }
        super.onAttach(context);
        getNumberOfAdsFromServer(userID);
        numberOfFollowing = checkIfTableFollowing(getActivity());
        followOrNot = checkIfFollow(getActivity(), userID);
        //set userName in followID just as init value well need it to insert in
        //fireBase as object after added well updated
        userFollowingInfo = new Following(userNameStr, userImage, userID, userNameStr,userNameStr);
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



//        fillUserImageAndUserName();
//        fillFollowOrNot();
//        actionListenerToFollow();
//        actionListenerToIV();
    }

    private void actionListenerToIV() {
        userImageIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userID.equals(getUserIdInServerFromSP(getActivity()))) {

                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("userID", userID);
                    bundle.putString("type", "person");

                    Intent intent = new Intent(getActivity(), UserProfile.class);
                    intent.putExtras(bundle);
                    startActivityForResult(intent , 10);
                    getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);

                }
            }
        });
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
        addNewFollower(getActivity());
        //addNewFollowing(userFollowingInfo, getActivity());
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

    private void fullMessage() {
        String message = getActivity().getResources().getString(R.string.u_cant);
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    private void fillFollowOrNot() {
        if (userID.equals(getUserIdInServerFromSP(getActivity()))) {
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
                .load(userImage)
                .fit()
                .centerCrop()
                .into(userImageIV);

        userNameTV.setText(userNameStr);
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

    public void addNewFollower(final Context context) {
        Follower followerInfo = getUserInfoFromSP(context);
        insertFollower(context,userID)
                .push().setValue(followerInfo
                , new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError,
                                           DatabaseReference databaseReference) {
                        String uniqueKey = databaseReference.getKey();
                        //insertFollowing(context).child(uniqueKey).child("followID").setValue(uniqueKey);
                        addNewFollowing(getActivity(),uniqueKey);
                    }
                });
    }

    public void addNewFollowing(final Context context, final String otherID) {
        insertFollowing(context)
                .push().setValue(userFollowingInfo
                , new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError,
                                           DatabaseReference databaseReference) {
                        String uniqueKey = databaseReference.getKey();
                        insertFollowing(context).child(uniqueKey).child("followID").setValue(uniqueKey);
                        userFollowingInfo.setFollowerIDOtherSaid(otherID);
                        Following insertFollowing = new Following(userNameStr, userImage, userID, uniqueKey,otherID);
                        insertFollowingTable(insertFollowing, myDB);
                    }
                });
    }

    private void deleteFollowingFromUserSaid(String followIDInServer, Context context) {
        insertFollowing(context).child(followIDInServer).removeValue();
    }

    private void deleteFollowerFromOtherSaid(String followIDInOtherSaid) {
        insertNewUser().child(userID).child("follower").child(followIDInOtherSaid).removeValue();
    }
}
