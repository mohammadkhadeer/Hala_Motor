package com.cars.halamotor_obeidat.view.fragments.fragmentsInSaidProfileFragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CreatorInfo;
import com.cars.halamotor_obeidat.model.Following;
import com.cars.halamotor_obeidat.view.activity.FollowingActivity;
import com.cars.halamotor_obeidat.view.activity.LoginWithSocialMedia;
import com.cars.halamotor_obeidat.view.activity.ShowPostsActivity;

import com.cars.halamotor_obeidat.view.activity.UserProfile;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import static com.cars.halamotor_obeidat.API.APIS.BASE_API;
import static com.cars.halamotor_obeidat.dataBase.ReadFunction.getFollowing;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getPlatform;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserID;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserName;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserPhoto;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;

import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserImage;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProfileDetailsInfo extends Fragment {

    View view;
    RelativeLayout buildTrustRL,numberOfPostRL,numberOfFollowerRL,numberOfFollowingRL;
    CardView userInfoCV;
    ImageView userImageIV,login_platformImageV;
    TextView userNameTV,editProfileTV,buildTrustTV,numberOfPostTV,postTV
            ,numberOfFollowingTV,followingTV,followerTV,numberOfFollowerTV;
    ArrayList<Following> followingArrayList = new ArrayList<Following>();
    CreatorInfo creatorInfo;

    public ProfileDetailsInfo(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile_details_info, container, false);

        inti();
        checkIfRegisterOrNot();
        actionListener();
        changeFont();
        userInfo();

        return view;
    }



    private void actionListener() {
        actionListenerBuildTrust();
        actionListenerToPosts();
        actionListenerToFollowing();
    }

    private void actionListenerToFollowing() {
        numberOfFollowingRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOfPostTV.getText().toString().equals("0"))
                {
                    Toast.makeText(getActivity(),getResources().getString(R.string.no_favorite),Toast.LENGTH_SHORT).show();
                }else{
//                    Bundle bundle = new Bundle();
//                    bundle.putString("userID", getUserIdInServerFromSP(getActivity()));

                    Intent intent = new Intent(getActivity(), FollowingActivity.class);
//                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                }
            }
        });
    }

    private void actionListenerToPosts() {
        numberOfPostRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(creatorInfo.getAds_count().equals("0"))
                {
                    Toast.makeText(getActivity(),getResources().getString(R.string.no_favorite),Toast.LENGTH_SHORT).show();
                }else{
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("creator_info",creatorInfo);

                    Intent intent = new Intent(getActivity(), UserProfile.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                }
            }
        });
    }

    private void actionListenerBuildTrust() {
        buildTrustRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToLoginWithSocialMedia();
            }
        });
    }

    private void changeFont() {
        userNameTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        numberOfPostTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        postTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        numberOfFollowingTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        followingTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        followerTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        numberOfFollowerTV.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void checkIfRegisterOrNot() {
        if (getUserTokenFromServer(getActivity()) != "empty")
        {
            makeUserInfoOn();
            fillUserInfoFromFB();
        }else{
            makeUserInfoOff();
        }
    }

    private void fillUserInfoFromFB() {

        followingArrayList =getFollowing(getActivity());
        userNameTV.setText(getUserName(getActivity()));
        followingTV.setText(String.valueOf(followingArrayList.size()));
        fillImageUser(getUserPhoto(getActivity()));
        fillPlatformImage();
    }

    private void fillPlatformImage() {
        if (getPlatform(getActivity()).equals("google"))
        {
            Picasso.get()
                    .load(R.drawable.g)
                    .fit()
                    .centerCrop()
                    .into(login_platformImageV);
        }else{
            Picasso.get()
                    .load(R.drawable.fb_logo)
                    .fit()
                    .centerCrop()
                    .into(login_platformImageV);
        }
    }

    private void fillImageUser(String userImageStr) {
        if (getUserImage(getActivity()) != null)
        {
            Uri uri = Uri.parse(userImageStr);
            Picasso.get()
                    .load(uri)
                    .fit()
                    .centerCrop()
                    .into(userImageIV);
                }
    }

    private void makeUserInfoOn() {
        userInfoCV.setVisibility(View.VISIBLE);
    }

    private void makeUserInfoOff() {
        userInfoCV.setVisibility(View.GONE);
    }

    private void moveToLoginWithSocialMedia() {
        Bundle bundle = new Bundle();
        bundle.putString("address", "build");

        Intent intent = new Intent(getActivity(), LoginWithSocialMedia.class);
        intent.putExtras(bundle);
        startActivityForResult(intent , 10);
        getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void inti() {
        userInfoCV = (CardView) view.findViewById(R.id.profile_details_info_details_CV);
        userImageIV = (ImageView) view.findViewById(R.id.profile_details_user_image_IV);
        login_platformImageV = (ImageView) view.findViewById(R.id.login_platform);

        userNameTV = (TextView) view.findViewById(R.id.profile_details_user_name_TV);
        editProfileTV = (TextView) view.findViewById(R.id.profile_details_info_edit_profile_TV);
        buildTrustTV = (TextView) view.findViewById(R.id.profile_details_info_build_trust_TV);
        buildTrustRL = (RelativeLayout) view.findViewById(R.id.profile_details_info_build_trust_RL);
        numberOfPostRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_post_RL);
        numberOfFollowerRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_u_i_a_m_share_RL);
        numberOfFollowingRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_u_i_a_m_report_RL);
        numberOfPostTV = (TextView) view.findViewById(R.id.fragment_profile_number_post_TV);
        postTV = (TextView) view.findViewById(R.id.fragment_profile_post_TV);
        numberOfFollowerTV = (TextView) view.findViewById(R.id.fragment_profile_number_followers_TV);
        followerTV = (TextView) view.findViewById(R.id.fragment_profile_followers_TV);
        followingTV = (TextView) view.findViewById(R.id.fragment_profile_number_following_TV);
        numberOfFollowingTV = (TextView) view.findViewById(R.id.fragment_profile_following_TV);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if (null!=data)
            {
                checkIfRegisterOrNot();
            }
        }
    }

    private void userInfo()
    {
        JSONObject obj = null,creator_info = null;
        Log.i("TAG","Bearer: "+getUserTokenFromServer(getActivity()));
        Log.i("TAG","UserID: "+getUserID(getActivity()));

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(BASE_API+"/users/"+getUserID(getActivity()))
                .method("GET", null)
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + getUserTokenFromServer(getActivity()))
                .build();

        try {
            Response response = client.newCall(request).execute();
            try {
                JSONObject objData = null,objUser=null;

                //Log.i("TAG","creator response: "+response.toString());

                obj = new JSONObject(response.body().string());
                creator_info = obj.getJSONObject("DATA");

                Log.i("TAG","obj: "+obj.toString());
                String followers_count = creator_info.getString("followers_count");

                Log.i("TAG","creatorInfo followers: "+followers_count);

                //creator_info.getString("type")

                creatorInfo = new CreatorInfo(
                        creator_info.getString("id")
                        ,creator_info.getString("name")
                        ,creator_info.getString("ads_count")
                        ,creator_info.getString("followers_count")
                        ,creator_info.getString("following_count")
                        ,"user"
                        ,creator_info.getString("photo")

                );
                numberOfPostTV.setText( creator_info.getString("ads_count"));
                followingTV.setText( creator_info.getString("following_count"));
                numberOfFollowerTV.setText( creator_info.getString("followers_count"));
                //login.whenLoginSuccess(obj,platform,platform_id,photo);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}