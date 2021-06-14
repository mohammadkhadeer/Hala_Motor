package com.cars.halamotor.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.presnter.Login;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.Locale;

import static com.cars.halamotor.functions.Functions.setLocale;
import static com.cars.halamotor.presnter.LoginAndUpdateProfile.whenLoginCompleteSuccess;
import static com.cars.halamotor.sharedPreferences.PersonalSP.saveUserInfoSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.checkFBLoginOrNot;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOrNotFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserTokenInFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.saveUserInfoInSP;

public class LoginWithSocialMedia extends AppCompatActivity implements Login{

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
    Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_login_with_social_media);

        getStringFromIntent();
        inti();
        changeFont();
        statusBarColor();
        this.login = (Login) this;
        //actionBarTitle();
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
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    public void moveBack() {
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    // google login
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            final GoogleSignInAccount acct = completedTask.getResult(ApiException.class);
            if (acct != null) {
                progressBar.setVisibility(View.VISIBLE);
                Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run() {

                        whenLoginCompleteSuccess(acct.getGivenName() +" "+acct.getFamilyName(),acct.getEmail(),"123456"
                        ,"google",acct.getId(),getUserTokenInFromSP(getApplicationContext()),String.valueOf(acct.getPhotoUrl())
                        ,"00000000",login);

                    }
                });
                thread.start();
            }
        } catch (ApiException e) {
            Log.w("TAG", "signInResult:failed code=" + e.getStatusCode());
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
       // welcomeTV.setTypeface(Functions.changeFontBold(getApplicationContext()));
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

                Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        try {
                            String photo = "https://graph.facebook.com/" + object.getString("id") + "/picture?type=normal";
                            whenLoginCompleteSuccess(object.getString("first_name") + " " + object.getString("last_name"),
                                    object.getString("email"), "123456", "facebook", object.getString("id"),
                                    getUserTokenInFromSP(getApplicationContext()), photo, "00000000", login);
                        } catch (JSONException e) {
                            Log.w("TAG","error");
                            Log.w("TAG",e.getMessage());
                            e.printStackTrace();
                        }

                    }
                });
                thread.start();

            }
        });


        Bundle parmeters = new Bundle();
        parmeters.putString("fields", "first_name,last_name,email,id,birthday,gender,location");
        graphRequest.setParameters(parmeters);
        graphRequest.executeAsync();
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
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    @Override
    public void whenLoginSuccess(JSONObject obj,String platform,String platform_id,String photo) {
        JSONObject objData = null,objUser=null;
        try {
            objData = obj.getJSONObject("DATA");
            objUser =objData.getJSONObject("user");

            saveResponseInSP(objData,objUser,platform,platform_id,photo);

            checkIfUserRegisterOrNotFromSP(getApplicationContext(), rgSharedPreferences, rgEditor, "1");

            saveUserInfoInSP(getApplicationContext(), fbSharedPreferences, fbEditor, objUser.getString("name")
                    , objUser.getString("name"), objUser.getString("email")
                    , objUser.getString("id"), "1/1/2020"
                    , photo);

            moveBack();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void saveResponseInSP(JSONObject objData, JSONObject objUser,String platform,String platform_id,String photo) {
        try {
            saveUserInfoSP(this,objUser.getString("id")
                    ,objUser.getString("name")
                    ,objUser.getString("email")
                    ,objUser.getString("phone")
                    ,photo
                    ,objUser.getString("phone_is_verified")
                    ,objUser.getString("email_is_verified")
                    ,Locale.getDefault().getLanguage()
                    ,objUser.getString("mute_notification")
                    ,objUser.getString("area_id")
                    ,objUser.getString("area")
                    ,objData.getString("token")
                    ,platform
                    ,platform_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
