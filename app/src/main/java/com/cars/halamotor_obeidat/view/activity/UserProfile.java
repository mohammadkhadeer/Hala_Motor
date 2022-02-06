package com.cars.halamotor_obeidat.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.CCEMTModel;
import com.cars.halamotor_obeidat.model.CreatorInfo;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.model.UserProfileInfo;
import com.cars.halamotor_obeidat.new_presenter.UserInfoP;
import com.cars.halamotor_obeidat.presnter.RelatedAds;
import com.cars.halamotor_obeidat.presnter.UserInfo;
import com.cars.halamotor_obeidat.view.fragments.userProfileFragment.UserProfileDetailsInfo;
import com.cars.halamotor_obeidat.view.fragments.userProfileFragment.UserProfilePostsList;

import static com.cars.halamotor_obeidat.fireBaseDB.GetFromFireBaseDB.getProfileUserInfo;
import static com.cars.halamotor_obeidat.functions.Functions.setLocale;

import java.util.List;

public class UserProfile extends AppCompatActivity implements RelatedAds, UserInfoP {

    UserProfileDetailsInfo userProfileDetailsInfo = new UserProfileDetailsInfo();
    UserProfilePostsList userProfilePostsList = new UserProfilePostsList();

    CreatorInfo creatorInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_user_profile);
        getInfoFromIntent();
        statusBarColorWhite();

        intiFragment();
//        userInfo = (UserInfo) this;
//        getProfileUserInfo(userID,userInfo);
        intiUserPostsFragment();

    }

    private void intiUserPostsFragment() {
        Log.i("TAG","Type: "+creatorInfo.getType());
        Bundle bundle = new Bundle();
        bundle.putParcelable("creator_info", creatorInfo);
        userProfilePostsList.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_user_profile_posts, userProfilePostsList)
                .commit();
    }


    private void statusBarColorWhite() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private void getInfoFromIntent() {
        Bundle bundle = getIntent().getExtras();
        creatorInfo = bundle.getParcelable("creator_info");

    }

    private void intiFragment() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("creator_info", creatorInfo);

        userProfileDetailsInfo.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_user_profile_comp, userProfileDetailsInfo)
                .commit();

    }


    @Override
    public void relatedAdsToSameUser(List<CCEMTModel> relatedAdsToSameUserList) {
        //Log.i("TAG","I'm here in activity");
        userProfilePostsList.handleList(relatedAdsToSameUserList);
    }

    @Override
    public void updateNumberOfFollowers(String numberOfFollowers) {
        userProfileDetailsInfo.updateNumberOfFollower(numberOfFollowers);
    }
}
