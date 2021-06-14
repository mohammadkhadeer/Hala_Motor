package com.cars.halamotor.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.CityModel;
import com.cars.halamotor.model.ItemFilterModel;
import com.cars.halamotor.model.ItemSelectedFilterModel;
import com.cars.halamotor.model.Neighborhood;
import com.cars.halamotor.presnter.Filter;
import com.cars.halamotor.presnter.OnNewNotification;
import com.cars.halamotor.view.fragments.FragmentHomeScreen;
import com.cars.halamotor.view.fragments.browsingFragment.FragmentBrowsing;
import com.cars.halamotor.view.fragments.FragmentNotification;
import com.cars.halamotor.view.fragments.FragmentProfile;
import com.cars.halamotor.view.fragments.fragmentInSaidHomeScreenFragment.FragmentSearch;
import com.cars.halamotor.view.fragments.fragmentInSaidHomeScreenFragment.ListsMainScreenFragment;
import com.google.firebase.database.DatabaseReference;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

import static com.cars.halamotor.dataBase.ReadCarsAndCarModels.getModels;
import static com.cars.halamotor.functions.Functions.setLocale;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.getUnreadNotificationsInSP;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.updateAllUnreadNotificationsToChecked;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.updateNumberUnreadNotifications;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserPhone;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOrNotFromSP;

public class MainActivity extends AppCompatActivity implements Filter,FragmentSearch.FragmentSearchListener{
    private TextView appNameTV;
    DatabaseReference mDatabase;
    BottomBar bottomBar;
    EditText searchEdt;
    RelativeLayout headRL,searchRL,bottomRL;

    final FragmentHomeScreen fragmentHome = new FragmentHomeScreen();
    final Fragment fragmentMessage = new FragmentBrowsing();
    final Fragment fragmentNotification = new FragmentNotification();
    final Fragment fragmentProfile = new FragmentProfile();
    final FragmentManager fm = getSupportFragmentManager();
    FragmentSearch fragmentSearch = new FragmentSearch();
    Fragment active = fragmentHome;

    BottomBarTab homeBBT,messagesBBT, notificationsBBT, addItemBBT,profileBBT;
    private BottomBarTab[] bbtArr = {homeBBT, messagesBBT, notificationsBBT, addItemBBT, profileBBT};
    private String[] bbtArrStr = {"homeBBT", "messagesBBT", "notificationsBBT", "addItemBBT", "profileBBT"};
    String lastFragmentStr;
    private static final int ADD_NEW_ITEM = 101;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    OnNewNotification onNewNotification;
    private static final int REQUEST_SHOW_ITEM_SELECTED_DETAILS = 100;
    int numberOfFilterSelected=0,selectedAntherFragmentButStillSelectedFilter=0,searchOnTheTop=0;
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_main);

        statusBarColor();
        inti();

        changeAppNameFontType();
        changeGeneralFontType();
        BottomBarMenu();
        moveBetweenFragment();
        updateNumberUnCheckedNotifications();
        actionListenerToSearch();
        onPressOnSearch();
    }

    private void onPressOnSearch() {
        searchEdt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        searchEdt.setFocusable(true);
                        searchEdt.requestFocus();
                        intiSearchFragment();
                        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.showSoftInput(searchEdt, InputMethodManager.SHOW_IMPLICIT);
                        break;
                    case MotionEvent.ACTION_UP:
                        v.performClick();
                        break;
                    default:
                        break;
                }
                return true;

            }
        });
    }

    private void intiSearchFragment() {
        bottomRL.setVisibility(View.GONE);
        searchOnTheTop=1;
        searchRL.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_search, fragmentSearch)
                .commit();
    }

    private void actionListenerToSearch() {
        searchEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0)
                    Log.i("TAG","test");//makeCancelTitleIVVISIBLE();
                else
                    Log.i("TAG","test");//makeCancelTitleIVGONE();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                fragmentSearch.filter(editable.toString());
            }

        });
    }

    // to can inti interface in said activity
    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        if (fragment instanceof OnNewNotification) {
            onNewNotification = (OnNewNotification) fragment;
        }
    }

    public void onNewNotifications() {
        if (onNewNotification != null) {
            onNewNotification.onNewNotification(1);
        }
    }

    private void moveBetweenFragment() {
        fm.beginTransaction().add(R.id.main_container, fragmentProfile, "4").hide(fragmentProfile).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentNotification, "3").hide(fragmentNotification).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentMessage, "2").hide(fragmentMessage).commit();
        fm.beginTransaction().add(R.id.main_container,fragmentHome, "1").commit();
    }

    private void changeGeneralFontType() {
        searchEdt.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        homeBBT.setTitleTypeface(Functions.changeFontGeneral(getApplicationContext()));
        messagesBBT.setTitleTypeface(Functions.changeFontGeneral(getApplicationContext()));
        notificationsBBT.setTitleTypeface(Functions.changeFontGeneral(getApplicationContext()));
        addItemBBT.setTitleTypeface(Functions.changeFontGeneral(getApplicationContext()));
        profileBBT.setTitleTypeface(Functions.changeFontGeneral(getApplicationContext()));
    }

    private void changeAppNameFontType() {
        appNameTV.setTypeface(Functions.changeFontAppName(getApplicationContext()));
    }

    private void inti() {
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        appNameTV =(TextView) findViewById(R.id.app_name_tv);
        searchEdt = (EditText) findViewById(R.id.searchEdt);
        headRL = (RelativeLayout) findViewById(R.id.main_activity_head);
        searchRL = (RelativeLayout) findViewById(R.id.main_activity_search_rl);
        bottomRL = (RelativeLayout) findViewById(R.id.main_activity_bottom_bat);
        intiBBT();
    }

    private void BottomBarMenu() {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switchFragment(tabId);
            }
        });

        //we need this action listener when user all ready in same tab need second listener TabReselect
        actionListenerToHomeBottomBar();
        actionListenerToAddItem();

        //messagesBBT.setBadgeCount(12);
    }

    private void actionListenerToAddItem() {
        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_adv)
                {
                    moveToAddItem();
                }
            }
        });
    }

    private void actionListenerToHomeBottomBar() {
        //this listener to remove all filter if filter selected and user press on home tab
        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home)
                {
//                    Toast.makeText(getBaseContext(),"numberOfFilterSelected: "+String.valueOf(numberOfFilterSelected), Toast.LENGTH_SHORT).show();
                    if (numberOfFilterSelected !=0)
                    {
//                        Toast.makeText(getBaseContext(),getResources().getString(R.string.must_login), Toast.LENGTH_SHORT).show();
                        fragmentHome.removeAllFilter();
                    }else{
                        handelHomeFragment();
                    }
                }
                //Toast.makeText(getApplicationContext(), TabMessage.get(tabId, true), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void intiBBT() {
        homeBBT = bottomBar.getTabWithId(R.id.tab_home);
        messagesBBT = bottomBar.getTabWithId(R.id.tab_messages);
        notificationsBBT = bottomBar.getTabWithId(R.id.tab_notifications);
        addItemBBT = bottomBar.getTabWithId(R.id.tab_adv);
        profileBBT = bottomBar.getTabWithId(R.id.tab_profile);
    }

    private boolean switchFragment(int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                selectedAntherFragmentButStillSelectedFilter =0;
                handelHomeFragment();
                return true;

            case R.id.tab_messages:
                handelMessageFragment();
                return true;

            case R.id.tab_adv:
                checkWhatIsLastFragmentAndKeepItOn();
                moveToAddItem();
//                if (getUserPhone(this).equals("000000"))
//                {
//                    Toast.makeText(getBaseContext(),getResources().getString(R.string.must_login), Toast.LENGTH_SHORT).show();
//                    handelProfileFragment();
//                }else{
//                    bottomBar.selectTabWithId(R.id.tab_home);
//                    checkWhatIsLastFragmentAndKeepItOn();
//                    moveToAddItem();
//                }
                return true;

            case R.id.tab_notifications:
                updateAllUnreadNotificationsToChecked(MainActivity.this,sharedPreferences,editor,"0");
                updateNumberUnCheckedNotifications();
                onNewNotifications();
                handelNotificationsFragment();
                return true;

            case R.id.tab_profile:
                handelProfileFragment();
                return true;
        }
        return false;
    }

    private void visibleHeadRL(){
        headRL.setVisibility(View.VISIBLE);
    }

    private void handelProfileFragment() {
        checkIfSelectedFilter();
        headRL.setVisibility(View.GONE);
        fm.beginTransaction().hide(active).show(fragmentProfile).commit();
        active = fragmentProfile;
        lastFragmentStr= "fragmentProfile";
    }

    private void handelNotificationsFragment() {
        checkIfSelectedFilter();
        visibleHeadRL();
        fm.beginTransaction().hide(active).show(fragmentNotification).commit();
        active = fragmentNotification;
        lastFragmentStr= "fragmentNotification";
    }

    private void handelMessageFragment() {
        checkIfSelectedFilter();
        visibleHeadRL();
        fm.beginTransaction().hide(active).show(fragmentMessage).commit();
        active = fragmentMessage;
        lastFragmentStr= "fragmentMessage";
    }

    private void checkIfSelectedFilter() {
        if (numberOfFilterSelected !=0)
        {
            selectedAntherFragmentButStillSelectedFilter =1;
        }
    }

    private void handelHomeFragment() {
        visibleHeadRL();
        fm.beginTransaction().hide(active).show(fragmentHome).commit();
        active = fragmentHome;
        lastFragmentStr= "fragmentHome";
    }

    private void checkWhatIsLastFragmentAndKeepItOn() {
        switch (lastFragmentStr) {
            case "fragmentHome":
                fm.beginTransaction().hide(active).show(fragmentHome).commit();
                active = fragmentHome;
                //keepItPressed(homeBBT);
                break;
            case "fragmentMessage":
                fm.beginTransaction().hide(active).show(fragmentMessage).commit();
                active = fragmentMessage;
                //keepItPressed(messagesBBT);
                break;

            case "fragmentNotification":
                fm.beginTransaction().hide(active).show(fragmentNotification).commit();
                active = fragmentNotification;
                //keepItPressed(notificationsBBT);
                break;

            case "fragmentProfile":
                fm.beginTransaction().hide(active).show(fragmentProfile).commit();
                active = fragmentProfile;
                //keepItPressed(profileBBT);
                break;

        }
    }

    private void resetOtherBBTToDefault(String bbtStr,BottomBarTab bbt) {
        for (int i=0;i<bbtArrStr.length;i++)
        {
            if (!bbtArrStr[i].equals(bbtStr))
            {
                Log.i("TAGEQ",bbtArrStr[i]);
                //bbt.performClick(false);
                //bbtArr[i].isSelected();
                bbtArr[i].callOnClick();
            }
        }
    }

    private void keepItPressed(BottomBarTab bbt) {
        //bbt.performClick();
         bbt.callOnClick();

    }

    private void moveToAddItem() {
        Intent intent = new Intent(MainActivity.this, AddItem.class);
        startActivityForResult(intent, ADD_NEW_ITEM);
        overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
    }

    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorRed));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SHOW_ITEM_SELECTED_DETAILS && resultCode == RESULT_OK && data != null) {
            // to update UI in lists can't handel it via interface must to overright method
            //listsMainScreenFragment.onActivityResult(requestCode, resultCode, data);
            //to update fragment must to use new object
            //we calculate mode to know if have to change UI "Update"
            String numberOfChangeStr =data.getExtras().getString("numberOfChange");
            int numberOfChange =Integer.parseInt(numberOfChangeStr);
            int result = numberOfChange % 2;

            if (result != 0) {
                FragmentHomeScreen fragmentHomeScreen = new FragmentHomeScreen();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_container, fragmentHomeScreen);
                transaction.commit();
            }
        }
        if (requestCode == ADD_NEW_ITEM && resultCode == Activity.RESULT_OK) {
            if (getUnreadNotificationsInSP(MainActivity.this) != null)
            {
                int unreadNotification = Integer.parseInt(getUnreadNotificationsInSP(MainActivity.this));
                unreadNotification = unreadNotification + 1;
                updateNumberUnreadNotifications(MainActivity.this,sharedPreferences,editor,String.valueOf(unreadNotification));
                updateNumberUnCheckedNotifications();
            }else{
                updateNumberUnreadNotifications(MainActivity.this,sharedPreferences,editor,String.valueOf(1));
                updateNumberUnCheckedNotifications();
            }
        }
    }

    ListsMainScreenFragment listsMainScreenFragment = new ListsMainScreenFragment();
    private void updateNumberUnCheckedNotifications() {
        if (getUnreadNotificationsInSP(this) != null)
        {
            int num = Integer.parseInt(getUnreadNotificationsInSP(MainActivity.this));
            if(num >0)
                notificationsBBT.setBadgeCount(num);
            else
                notificationsBBT.setBadgeCount(0);
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    @Override
    public void onFilterClick(ItemFilterModel filterModel, String filterType) {
        numberOfFilterSelected =numberOfFilterSelected+1;
        fragmentHome.onFilterClicked(filterModel,filterType);
    }

    @Override
    public void onFilterCancel() {
        numberOfFilterSelected =numberOfFilterSelected-1;
        fragmentHome.onFilterCanceled();
    }

    @Override
    public void onFilterCityClick(CityModel cityModel) {
        fragmentHome.onCityClicked(cityModel);
    }

    @Override
    public void onFilterCityCancel(Boolean cancel) {
        fragmentHome.onCityCanceled(cancel);
    }

    @Override
    public void onFilterNeighborhoodClick(Neighborhood neighborhood) {
        fragmentHome.onNeighborhoodClicked(neighborhood);
    }

    @Override
    public void onFilterNeighborhoodCancel(Boolean cancel) {
        fragmentHome.onNeighborhoodCanceled(cancel);
    }

    @Override
    public void onBackPressed() {
        if (lastFragmentStr.equals("fragmentHome") && searchOnTheTop ==0)
        {
            //when user be press back and still in home fragment back button well remove a filter
            //from home fragment and create public method in result to update response and public
            //method in filter fragment to cancel last filter
            if (searchOnTheTop ==1){
                searchOnTheTop =0;
                searchEdt.setText("");
                searchEdt.clearFocus();
                searchRL.setVisibility(View.GONE);
                bottomRL.setVisibility(View.VISIBLE);
            }else{
                if (numberOfFilterSelected != 0)
                {
                    fragmentHome.removeLastFilter();
                }else{
                    if (searchOnTheTop ==1)
                    {
                        searchOnTheTop =0;
                        searchEdt.setText("");
                        searchEdt.clearFocus();
                        searchRL.setVisibility(View.GONE);
                        bottomRL.setVisibility(View.VISIBLE);

                    }else{
                        finish();
                    }
                }
            }
        }else{
//            Toast.makeText(getBaseContext(), "numberOfFilterSelected: " + String.valueOf(numberOfFilterSelected), Toast.LENGTH_SHORT).show();
            if (searchOnTheTop ==1){
                searchOnTheTop =0;
                searchEdt.setText("");
                searchEdt.clearFocus();
                searchRL.setVisibility(View.GONE);
                bottomRL.setVisibility(View.VISIBLE);
            }else{
                handelHomeFragment();
                bottomBar.selectTabWithId(R.id.tab_home);
            }
        }
    }

    @Override
    public void onInputSearchSent(ArrayList<ItemSelectedFilterModel> itemTypeFromFilterAdapter) {
        numberOfFilterSelected =5;
        searchRL.setVisibility(View.GONE);
        bottomRL.setVisibility(View.VISIBLE);
        searchEdt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        searchEdt.clearFocus();
        fragmentHome.onFilterClicked(itemTypeFromFilterAdapter);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
