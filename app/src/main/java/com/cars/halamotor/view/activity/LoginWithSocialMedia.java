package com.cars.halamotor.view.activity;

import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.UserInfo;
import com.cars.halamotor.view.activity.selectAddress.SelectCityAndNeighborhood;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collections;

import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addNewUser;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getUserInfo;
import static com.cars.halamotor.functions.Functions.changeFontBold;
import static com.cars.halamotor.functions.Functions.getDAY;
import static com.cars.halamotor.functions.Functions.getMONTH;
import static com.cars.halamotor.functions.Functions.getYEAR;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.checkFBLoginOrNot;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOnServerSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOrNotFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserIdInServerFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserTokenInFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.saveFBInfoInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.saveServerIDInfoInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.saveUserInfoInSP;

public class LoginWithSocialMedia extends AppCompatActivity {

    LoginButton loginButtonFB;
    CallbackManager callbackManager;
    SharedPreferences.Editor fbEditor, rgEditor;
    SharedPreferences fbSharedPreferences, rgSharedPreferences;
    private FirebaseAuth mAuth;
    TextView welcomeTV;
    SignInButton signInButton;
    ProgressBar progressBar;

    private WeakReference<LoginWithSocialMedia> weakAct = new WeakReference<>(this);

    GoogleSignInClient mGoogleSignInClient;
    GoogleApiClient mGoogleApiClient;
    private GoogleSignInAccount account;

    int RC_SIGN_IN = 0;
    int test =0;
    int numberOfAllowedPosts = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_social_media);

        getStringFromIntent();
        inti();
        changeFont();
        statusBarColor();
        actionBarTitle();
    }

    @Override
    protected void onStart() {
        super.onStart();
        handelFBLoginButton();
        handelGoogleButton();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }

//        if (requestCode == SELECT_LOCATION && resultCode == Activity.RESULT_OK) {
//
//            Intent intent = new Intent();
//            setResult(Activity.RESULT_OK, intent);
//            finish();
//        }

    }

    private static final int SELECT_LOCATION = 555;
    private static final int LOGIN = 556;

    public void moveBack() {
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {

        try {
            final GoogleSignInAccount acct = completedTask.getResult(ApiException.class);
            if (acct != null) {
                mAuth.createUserWithEmailAndPassword(acct.getEmail(), "@ajfhafjb#$ASW1235")
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    String year =getYEAR();
                                    String month = getMONTH();
                                    String day = getDAY();
                                    String date = year+"/"+month+"/"+day;

                                    UserInfo newUser = new UserInfo(acct.getGivenName()
                                            ,String.valueOf(acct.getPhotoUrl())
                                            ,acct.getFamilyName(),acct.getEmail()
                                            ,"000","notYet","notYet"
                                            ,"notYet","notYet"
                                            ,"notYet","notYet",getUserTokenInFromSP(getApplicationContext())
                                            ,0,1,0,0
                                            ,1,0,0,numberOfAllowedPosts,date);

                                    checkIfUserRegisterOrNotFromSP(getApplicationContext(), rgSharedPreferences, rgEditor, "1");

                                    addNewUser(newUser,rgSharedPreferences,rgEditor,getApplicationContext());

                                    saveUserInfoInSP(getApplicationContext(), fbSharedPreferences, fbEditor, acct.getGivenName()
                                            , acct.getFamilyName(), acct.getEmail()
                                            , acct.getId(), "1/1/2020"
                                            , String.valueOf(acct.getPhotoUrl()));
                                    moveBack();

                                }else{
                                    progressBar.setVisibility(View.VISIBLE);
                                    ///////////////here google///////////////////////
                                    getUserInfo(acct.getEmail(),rgSharedPreferences,rgEditor,fbSharedPreferences,fbEditor,LoginWithSocialMedia.this,acct.getId());
                                    //moveBack();
                                }
                            }
                        });

            }

            // Signed in successfully, show authenticated UI.
            //updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("TAG", "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }


    }

    private void handelGoogleButton() {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (test ==1)
                {
                    signOut();
                    test =0;
                }else{
                    signIn();
                    //moveBack();
                    test =1;
                }

            }
        });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
    }

    private String getStringFromIntent() {
        String address;
        Bundle bundle = getIntent().getExtras();
        address =bundle.getString("splash");
        return address;
    }

    private void changeFont() {
        welcomeTV.setTypeface(Functions.changeFontBold(getApplicationContext()));
    }

    private void handelFBLoginButton() {
        callbackManager = CallbackManager.Factory.create();
        loginButtonFB.setPermissions("email", "public_profile");

        loginButtonFB.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.i("TAG fn", error.toString());
            }
        });
    }

    private void inti() {
        mAuth = FirebaseAuth.getInstance();
        loginButtonFB = (LoginButton) findViewById(R.id.login_with_s_m_fb);
        welcomeTV = (TextView) findViewById(R.id.login_with_social_media_tv);
        signInButton = findViewById(R.id.login_with_s_m_g);
        progressBar = (ProgressBar) findViewById(R.id.login_with_social_media_progress);
    }

    AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if (currentAccessToken != null) {
                checkIfUserRegisterOrNotFromSP(getApplicationContext(), rgSharedPreferences, rgEditor, "1");
                checkFBLoginOrNot(getApplicationContext(), fbSharedPreferences, fbEditor, "1");
                loadUserProfile(currentAccessToken);
            } else {
                checkIfUserRegisterOrNotFromSP(getApplicationContext(), rgSharedPreferences, rgEditor, "0");
                checkFBLoginOrNot(getApplicationContext(), fbSharedPreferences, fbEditor, "0");
                moveBack();
            }
        }
    };

    private void loadUserProfile(AccessToken accessToken) {
        progressBar.setVisibility(View.VISIBLE);
        GraphRequest graphRequest = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(final JSONObject object, GraphResponse response) {
                try {
                    mAuth.createUserWithEmailAndPassword(object.getString("email"), "@ajfhafjb#$ASW1235")
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        progressBar.setVisibility(View.VISIBLE);
                                        try {
                                            Log.i("TAG", "mAuth");
                                            String year =getYEAR();
                                            String month = getMONTH();
                                            String day = getDAY();
                                            String date = year+"/"+month+"/"+day;

                                            UserInfo newUser = new UserInfo(object.getString("first_name")
                                                    ,"https://graph.facebook.com/" + object.getString("id") + "/picture?type=normal"
                                                    ,object.getString("last_name"),object.getString("email")
                                                    ,"000","notYet","notYet"
                                                    ,"notYet","notYet"
                                                    ,"notYet","notYet",getUserTokenInFromSP(getApplicationContext())
                                                    ,0,1,0,0
                                                    ,1,0,0,numberOfAllowedPosts,date);

                                            registerUserInServer(newUser);

                                            saveFBInfoInSP(getApplicationContext(), fbSharedPreferences, fbEditor, object.getString("first_name")
                                                    , object.getString("last_name"), object.getString("email")
                                                    , object.getString("id"), "1/1/2020"
                                                    , "https://graph.facebook.com/" + object.getString("id") + "/picture?type=normal");

                                            saveUserInfoIfNotRegister(object.getString("first_name")
                                                    , object.getString("last_name"), object.getString("email")
                                                    , object.getString("id"), "1/1/2020"
                                                    , "https://graph.facebook.com/" + object.getString("id") + "/picture?type=normal");

                                            moveBack();

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }else{
                                        Log.i("TAG", "Alredy have it");
                                        ///////////////here google///////////////////////
                                        try {
                                            progressBar.setVisibility(View.VISIBLE);
                                            getUserInfo(object.getString("email"),rgSharedPreferences,rgEditor,fbSharedPreferences,fbEditor,LoginWithSocialMedia.this,object.getString("id"));
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            });
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.i("TAG ERORR", ": "+e.toString());
                }
            }
        });


        Bundle parmeters = new Bundle();
        parmeters.putString("fields", "first_name,last_name,email,id,birthday,gender,location");
        graphRequest.setParameters(parmeters);
        graphRequest.executeAsync();
    }

    private void registerUserInServer(UserInfo newUser) {
        if(checkIfUserRegisterOnServerSP(getApplicationContext()) == false)
        {
            addNewUser(newUser,rgSharedPreferences,rgEditor,getApplicationContext());
        }
    }

    private void saveUserInfoIfNotRegister(String first_name, String last_name, String email, String id, String birthday, String user_image) {
        if (checkIfUserRegisterOrNotFromSP(getApplicationContext())) {
            saveUserInfoInSP(getApplicationContext(), rgSharedPreferences, rgEditor, first_name, last_name, email, id, birthday, user_image);
        }
    }

    private void actionBarTitle() {
        actionBarTitleText();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ActionBar abar = getSupportActionBar();
        View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar_custom_title_view_centered, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);
        textviewTitle.setText(actionBarTitleText());
        textviewTitle.setTypeface(changeFontBold(this));
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(true);
        abar.setHomeButtonEnabled(true);
    }

    private String actionBarTitleText() {
        String titleStr = null;
        if (checkIfUserRegisterOrNotFromSP(this) == false)
        {
            titleStr = getResources().getString(R.string.login_with_social_media);
        }
        else{
            titleStr = getResources().getString(R.string.build_trust);
        }
        return titleStr;
    }

    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorRed));
        }
    }

}
