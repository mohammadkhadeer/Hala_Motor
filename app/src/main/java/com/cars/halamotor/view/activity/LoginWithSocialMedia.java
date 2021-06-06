package com.cars.halamotor.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
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

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.UserInfo;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addNewUser;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getUserInfo;
import static com.cars.halamotor.functions.Functions.changeFontBold;
import static com.cars.halamotor.functions.Functions.getDAY;
import static com.cars.halamotor.functions.Functions.getMONTH;
import static com.cars.halamotor.functions.Functions.getYEAR;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.checkFBLoginOrNot;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOnServerSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOrNotFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserTokenInFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.saveFBInfoInSP;
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
                progressBar.setVisibility(View.VISIBLE);
                Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        insertUser(acct);

                        checkIfUserRegisterOrNotFromSP(getApplicationContext(), rgSharedPreferences, rgEditor, "1");

                        saveUserInfoInSP(getApplicationContext(), fbSharedPreferences, fbEditor, acct.getGivenName()
                                , acct.getFamilyName(), acct.getEmail()
                                , acct.getId(), "1/1/2020"
                                , String.valueOf(acct.getPhotoUrl()));
                        //moveBack();
                    }
                });
                thread.start();
//                mAuth.createUserWithEmailAndPassword(acct.getEmail(), "@ajfhafjb#$ASW1235")
//                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    String year =getYEAR();
//                                    String month = getMONTH();
//                                    String day = getDAY();
//                                    String date = year+"/"+month+"/"+day;
//
//                                    UserInfo newUser = new UserInfo(acct.getGivenName()
//                                            ,String.valueOf(acct.getPhotoUrl())
//                                            ,acct.getFamilyName(),acct.getEmail()
//                                            ,"000","notYet","notYet"
//                                            ,"notYet","notYet"
//                                            ,"notYet","notYet",getUserTokenInFromSP(getApplicationContext())
//                                            ,0,1,0,0
//                                            ,1,0,0,numberOfAllowedPosts,date);
//
//                                    checkIfUserRegisterOrNotFromSP(getApplicationContext(), rgSharedPreferences, rgEditor, "1");
//
//                                    addNewUser(newUser,rgSharedPreferences,rgEditor,getApplicationContext());
//
//                                    saveUserInfoInSP(getApplicationContext(), fbSharedPreferences, fbEditor, acct.getGivenName()
//                                            , acct.getFamilyName(), acct.getEmail()
//                                            , acct.getId(), "1/1/2020"
//                                            , String.valueOf(acct.getPhotoUrl()));
//                                    moveBack();
//
//                                }else{
//                                    progressBar.setVisibility(View.VISIBLE);
//                                    ///////////////here google///////////////////////
//                                    getUserInfo(acct.getEmail(),rgSharedPreferences,rgEditor,fbSharedPreferences,fbEditor,LoginWithSocialMedia.this,acct.getId());
//                                    //moveBack();
//                                }
//                            }
//                        });
            }
            // Signed in successfully, show authenticated UI.
            //updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("TAG", "Error");
            Log.w("TAG", "signInResult:failed code=" + e.getStatusCode());
            Log.w("TAG", "Error" + e.getMessage());
            //updateUI(null);
        }


    }

    private void insertUser(GoogleSignInAccount acct) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");

        Log.i("TAG name ",acct.getGivenName() +" "+acct.getFamilyName());
        Log.i("TAG email",acct.getEmail());
        Log.i("TAG id",acct.getId());
        //Log.i("TAG",acct.getIdToken());
        Log.i("TAG",String.valueOf(acct.getPhotoUrl()));


        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("name",acct.getGivenName() +" "+acct.getFamilyName())
                .addFormDataPart("email",acct.getEmail())
                .addFormDataPart("password","123456")
                .addFormDataPart("platform","google")
                .addFormDataPart("platform_id",acct.getId())
                .addFormDataPart("platform_token",getUserTokenInFromSP(getApplicationContext()))
                .addFormDataPart("photo",String.valueOf(acct.getPhotoUrl()))
                .addFormDataPart("phone","000000")
                .build();
        Request request = new Request.Builder()
                .url("http://174.138.4.155/api/login")
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            Log.i("TAG Response",response.toString());

            //Log.i("TAG Response body",response.body().string());

            JSONObject obj ,objData ,objUser;

            try {


                 obj = new JSONObject(response.body().string());
                Log.i("TAG STATUS ",obj.getString("STATUS"));
                Log.i("TAG MESSAGE ",obj.getString("STATUS"));
                objData =obj.getJSONObject("DATA");
                objUser =objData.getJSONObject("user");
                Log.i("TAG id",objUser.getString("id"));
                Log.i("TAG name",objUser.getString("name"));
                Log.i("TAG email",objUser.getString("email"));
                Log.i("TAG phone",objUser.getString("phone"));
                Log.i("TAG photo",objUser.getString("photo"));
                Log.i("TAG phone_is_verified",objUser.getString("phone_is_verified"));
                Log.i("TAG email_is_verified",objUser.getString("email_is_verified"));
                Log.i("TAG language",objUser.getString("language"));
                Log.i("TAG mute_notification",objUser.getString("mute_notification"));
                Log.i("TAG area_id",objUser.getString("area_id"));
                Log.i("TAG area",objUser.getString("area"));
                Log.i("TAG token",objData.getString("token"));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
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
                    Log.i("TAG","signOut");
                    test =0;
                }else{
                    Log.i("TAG","signIn");
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

//    private void actionBarTitle() {
//        actionBarTitleText();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        final ActionBar abar = getSupportActionBar();
//        View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar_custom_title_view_centered, null);
//        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
//                ActionBar.LayoutParams.WRAP_CONTENT,
//                ActionBar.LayoutParams.MATCH_PARENT,
//                Gravity.CENTER);
//        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);
//        textviewTitle.setText(actionBarTitleText());
//        textviewTitle.setTypeface(changeFontBold(this));
//        abar.setCustomView(viewActionBar, params);
//        abar.setDisplayShowCustomEnabled(true);
//        abar.setDisplayShowTitleEnabled(false);
//        abar.setDisplayHomeAsUpEnabled(true);
//        abar.setHomeButtonEnabled(true);
//    }

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

}
