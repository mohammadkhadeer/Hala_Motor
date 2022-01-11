package com.cars.halamotor_obeidat.view.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.view.activity.AboutUs;
import com.cars.halamotor_obeidat.view.activity.AddItem;
import com.cars.halamotor_obeidat.view.activity.ContactUs;
import com.cars.halamotor_obeidat.view.activity.PrivacyPolicy;
import com.cars.halamotor_obeidat.view.activity.Setting;
import com.cars.halamotor_obeidat.view.activity.ShowFCS;
import com.cars.halamotor_obeidat.view.activity.ShowPostsActivity;
import com.cars.halamotor_obeidat.view.fragments.fragmentsInSaidProfileFragment.ProfileDetailsInfo;

import static com.cars.halamotor_obeidat.functions.FillText.fillImageView;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOrNotFromSP;
import static com.facebook.FacebookSdk.getApplicationContext;

public class FragmentProfile extends Fragment {

    final Fragment fragmentLoginWithSocialMedia = new ProfileDetailsInfo();

    RelativeLayout postAdRL,recentVRL,recentSRL,favouriteRL,myAdsRL
            ,myWalletRL,inviteRL,helpRL,contactRL,aboutRL
            ,settingRL,callsRL,messageRL;
    TextView postAdTV,recentVTV,recentSTV,favouriteTV,myAdsTV
            ,myWalletTV,inviteTV,helpTV,contactTV,aboutTV
            ,settingTV,callsTV,messageTV;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6
            ,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13;

    View view;

    public FragmentProfile(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        inti();
        fillArrowsInIV();
        actionListener();
        head();
        changeFont();

        return view;
    }

    private void changeFont() {
        postAdTV.setTypeface(Functions.changeFontBold(getApplicationContext()));
        recentVTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        recentSTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        favouriteTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        myAdsTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        myWalletTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        inviteTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        helpTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        contactTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        aboutTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        settingTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        callsTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        messageTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
    }

    private void actionListener() {
        actionListenerToPostAd();
        actionListenerToResarchAds();
        actionListenerToFavourite();
        actionListenerRecentViewedAds();
        actionListenerToCallButton();
        actionListenerToMessage();
        actionListenerToMyAds();
        actionListenerToContactUs();
        actionListenerAboutTheApp();
        actionListenerSetting();
        actionListenerToPP();
    }

    private void actionListenerToPP() {
        helpRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToPP();
            }
        });
    }

    private void actionListenerSetting() {
        settingRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToSetting();
            }
        });
    }

    private void moveToSetting() {
        Bundle bundle = new Bundle();
        bundle.putString("from","setting");

        Intent intent = new Intent(getActivity(), Setting.class);
//                intent.putExtras(bundle);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
    }

    private void moveToPP() {
        Intent intent = new Intent(getActivity(), PrivacyPolicy.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
    }

    private void actionListenerAboutTheApp() {
        aboutRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAboutTheApp();
            }
        });
    }

    private void moveToAboutTheApp() {
        Intent intent = new Intent(getActivity(), AboutUs.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void actionListenerToContactUs() {
        contactRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToContactUsActivity();
            }
        });
    }

    private void moveToContactUsActivity() {
        Intent intent = new Intent(getActivity(), ContactUs.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void actionListenerToMyAds() {
        myAdsRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToShowPostsActivity();
            }
        });
    }

    private void moveToShowPostsActivity() {
        Intent intent = new Intent(getActivity(), ShowPostsActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void actionListenerToResarchAds() {
        recentSRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFCSActivity("search");
            }
        });
    }

    private void actionListenerToMessage() {
        messageRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFCSActivity("message");
            }
        });
    }

    private void actionListenerToCallButton() {
        callsRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFCSActivity("call");
            }
        });
    }

    private void actionListenerRecentViewedAds() {
        recentVRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFCSActivity("seen");
            }
        });
    }

    private void actionListenerToFavourite() {
        favouriteRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFCSActivity("favorite");
            }
        });
    }

    private void moveToFCSActivity(String fcsTypeStr) {
        Bundle bundle = new Bundle();
        bundle.putString("fcsTypeStr",fcsTypeStr);

        Intent intent = new Intent(getActivity(), ShowFCS.class);
        intent.putExtras(bundle);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void actionListenerToPostAd() {
        postAdRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfUserRegisterOrNotFromSP(getActivity()) == false)
                {
                    Toast.makeText(getActivity(),getResources().getString(R.string.must_login), Toast.LENGTH_SHORT).show();
                }else{
                    moveToAddItem();
                }
            }
        });
    }

    private void moveToAddItem() {
        Intent intent = new Intent(getActivity(), AddItem.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
    }

    private void inti() {
        postAdRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_post_free_RL);
        recentVRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_recent_v_RL);
        recentSRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_recent_RL);
        favouriteRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_favourite_RL);
        myAdsRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_my_ads_RL);
        myWalletRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_wallet_RL);
        inviteRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_invite_friends_RL);
        helpRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_help_RL);
        contactRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_contact_us_RL);
        aboutRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_about_app_RL);
        settingRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_setting_RL);
        callsRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_calls_RL);
        messageRL = (RelativeLayout) view.findViewById(R.id.fragment_profile_message_RL);

        postAdTV = (TextView) view.findViewById(R.id.fragment_profile_post_free_TV);
        recentVTV = (TextView) view.findViewById(R.id.fragment_profile_recent_v_TV);
        recentSTV = (TextView) view.findViewById(R.id.fragment_profile_recent_search_TV);
        favouriteTV = (TextView) view.findViewById(R.id.fragment_profile_favourite_TV);
        myAdsTV = (TextView) view.findViewById(R.id.fragment_profile_my_ads_TV);
        myWalletTV = (TextView) view.findViewById(R.id.fragment_profile_wallet_TV);
        inviteTV = (TextView) view.findViewById(R.id.fragment_profile_invite_friends_TV);
        helpTV = (TextView) view.findViewById(R.id.fragment_profile_help_TV);
        contactTV = (TextView) view.findViewById(R.id.fragment_profile_contact_us_TV);
        aboutTV = (TextView) view.findViewById(R.id.fragment_profile_about_app_TV);
        settingTV = (TextView) view.findViewById(R.id.fragment_profile_setting_TV);
        callsTV = (TextView) view.findViewById(R.id.fragment_profile_call_TV);
        messageTV = (TextView) view.findViewById(R.id.fragment_profile_message_TV);

        imageView1= (ImageView) view.findViewById(R.id.fragment_profile_post_free_arrow_IV);
        imageView2= (ImageView) view.findViewById(R.id.fragment_profile_recent_arrow_IV);
        imageView3= (ImageView) view.findViewById(R.id.fragment_profile_recent_search_arrow_IV);
        imageView4= (ImageView) view.findViewById(R.id.fragment_profile_favourite_arrow_IV_1);
        imageView5= (ImageView) view.findViewById(R.id.fragment_profile_calls_arrow_IV);
        imageView6= (ImageView) view.findViewById(R.id.fragment_profile_favourite_arrow_IV);
        imageView7= (ImageView) view.findViewById(R.id.fragment_profile_my_ads_arrow_IV);
        imageView8= (ImageView) view.findViewById(R.id.fragment_profile_wallet_arrow_IV);
        imageView9= (ImageView) view.findViewById(R.id.fragment_profile_invite_friends_arrow_IV);
        imageView10= (ImageView) view.findViewById(R.id.fragment_profile_help_arrow_IV);
        imageView11= (ImageView) view.findViewById(R.id.fragment_profile_contact_us_arrow_IV);
        imageView12= (ImageView) view.findViewById(R.id.fragment_profile_invite_about_app_arrow_IV);
        imageView13= (ImageView) view.findViewById(R.id.fragment_profile_setting_arrow_IV);
    }

    private void head() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.profile_container, fragmentLoginWithSocialMedia);
        transaction.show(fragmentLoginWithSocialMedia);
        //transaction.addToBackStack(null);
        transaction.commit();
    }

    private void fillArrowsInIV() {
        fillImageView(getActivity(),imageView1);
        fillImageView(getActivity(),imageView2);
        fillImageView(getActivity(),imageView3);
        fillImageView(getActivity(),imageView4);
        fillImageView(getActivity(),imageView5);
        fillImageView(getActivity(),imageView6);
        fillImageView(getActivity(),imageView7);
        fillImageView(getActivity(),imageView8);
        fillImageView(getActivity(),imageView9);
        fillImageView(getActivity(),imageView10);
        fillImageView(getActivity(),imageView11);
        fillImageView(getActivity(),imageView12);
        fillImageView(getActivity(),imageView13);
    }
}
