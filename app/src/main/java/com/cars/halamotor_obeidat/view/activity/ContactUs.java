package com.cars.halamotor_obeidat.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.ContactUsMessage;
import com.cars.halamotor_obeidat.model.ContactUsTitle;
import com.jaredrummler.materialspinner.MaterialSpinner;

import static com.cars.halamotor_obeidat.fireBaseDB.InsertToFireBase.addContactUsToFireStore;
import static com.cars.halamotor_obeidat.functions.Functions.checkIfContactUsReadyToSend;
import static com.cars.halamotor_obeidat.functions.Functions.fillTitleContactUs;
import static com.cars.halamotor_obeidat.functions.Functions.getDATE;
import static com.cars.halamotor_obeidat.functions.Functions.getObjectContactUs;
import static com.cars.halamotor_obeidat.functions.Functions.setLocale;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getPhoneNumberInSP;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserIdInServerFromSP;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserName;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserTokenInFromSP;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.savePhoneNumberInSP;
import static com.cars.halamotor_obeidat.sharedPreferences.UserInfoSP.getUserEmailFromSP;

public class ContactUs extends AppCompatActivity {
    RelativeLayout emailRL,fbPageRL,instaRL,cancelNameRL,cancelEmailRL
            ,cancelPhoneRL,cancelMessageRL,sendRL;
    TextView emailTV,fbTV,instaTV,leaveMessageTextTV;
    EditText nameEdt,emailEdt,phoneNumberEdt,messageEdt;
    MaterialSpinner spinner;
    ProgressBar progressBar;

    String nameStr,emailStr,phoneNumberStr,messageStr="",userToken,userID;
    ContactUsTitle contactUsTitle=null;
    ContactUsMessage contactUsMessage = null;

    SharedPreferences SharedPreferences;
    SharedPreferences.Editor editor;

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_contact_us);

        statusBarColor();
//        actionBarTitle();
        inti();
        getUserInfoFromSP();
        fillInfo();
        fillAndCreateAndActionListenerSpinner();
        changeFont();
        actionListener();
        actionListenerToEdt();
    }

    private void fillInfo() {
        nameEdt.setText(nameStr);
        emailEdt.setText(emailStr);
        phoneNumberEdt.setText(phoneNumberStr);
        if (nameStr != null)
        {
            if (!nameStr.equals("empty"))
                makeCancelNameVISIBLE();
        }
        if (emailStr != null)
        {
            if (!emailStr.equals("empty"))
                makeCancelEmailVISIBLE();
        }
        if (phoneNumberStr != null)
        {
            if (!phoneNumberStr.equals("empty") && !phoneNumberStr.equals(""))
                makeCancelPhoneNumberVISIBLE();
        }
    }

    private void getUserInfoFromSP() {
        userToken = getUserTokenInFromSP(this);
        userID = getUserIdInServerFromSP(this);
        nameStr = getUserName(this);
        emailStr = getUserEmailFromSP(this);
        if (getPhoneNumberInSP(this) == null)
        {
            phoneNumberStr = "";
        }else{
            phoneNumberStr = getPhoneNumberInSP(this);
        }
    }

    private void fillAndCreateAndActionListenerSpinner() {

        spinner.setItems(fillTitleContactUs(this));
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                contactUsTitle = getObjectContactUs(item,getApplicationContext());
                //Snackbar.make(view, "Clicked " + contactUsTitle.getTitle(), Snackbar.LENGTH_LONG).show();
            }
        });
        spinner.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {

            @Override public void onNothingSelected(MaterialSpinner spinner) {
                contactUsTitle = new ContactUsTitle(getResources().getString(R.string.suggestion),getResources().getString(R.string.suggestion_s));
                //Snackbar.make(spinner, contactUsTitle.getTitle(), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void actionListenerToEdt() {
        nameEdtListener();
        emailEdtListener();
        phoneNumberEdtListener();
        actionListenerToMessage();
    }

    private void actionListenerToMessage() {
        messageEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0) {
                    messageStr = String.valueOf(cs);
                    makeCancelMessageVISIBLE();
                }
                else {
                    makeCancelMessageGONE();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

        });
    }

    private void makeCancelMessageGONE() {
        cancelMessageRL.setVisibility(View.GONE);
    }

    private void makeCancelMessageVISIBLE() {
        cancelMessageRL.setVisibility(View.VISIBLE);
    }

    private void phoneNumberEdtListener() {
        phoneNumberEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0) {
                    phoneNumberStr = String.valueOf(cs);
                    makeCancelPhoneNumberVISIBLE();
                }
                else {
                    makeCancelPhoneNumberGONE();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

        });
    }

    private void makeCancelPhoneNumberGONE() {
        cancelPhoneRL.setVisibility(View.GONE);
    }

    private void makeCancelPhoneNumberVISIBLE() {
        cancelPhoneRL.setVisibility(View.VISIBLE);
    }

    private void emailEdtListener() {
        emailEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0) {
                    emailStr = String.valueOf(cs);
                    makeCancelEmailVISIBLE();
                }
                else {
                    makeCancelEmailGONE();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

        });
    }

    private void makeCancelEmailGONE() {
        cancelEmailRL.setVisibility(View.GONE);
    }

    private void makeCancelEmailVISIBLE() {
        cancelEmailRL.setVisibility(View.VISIBLE);
    }

    private void nameEdtListener() {
        nameEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0) {
                    nameStr = String.valueOf(cs);
                    makeCancelNameVISIBLE();
                }
                else {
                    makeCancelNameGONE();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

        });
    }

    private void makeCancelNameGONE() {
        cancelNameRL.setVisibility(View.GONE);
    }

    private void makeCancelNameVISIBLE() {
        cancelNameRL.setVisibility(View.VISIBLE);
    }

    private void actionListener() {
        actionListenerToEmail();
        actionListenerToFB();
        actionListenerToInsta();
        cancelNameListener();
        cancelEmailListener();
        cancelPhoneListener();
        cancelMessageListener();
        actionListenerToSend();
    }

    private void actionListenerToSend() {
        sendRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCases())
                {
                    progressBar.setVisibility(View.VISIBLE);
                    savePhoneNumberInSP(getApplicationContext(),SharedPreferences,editor,phoneNumberStr);
                    addContactUsToFireStore(contactUsMessage,"ContactUs",getApplicationContext());
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.send_suc),Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() { finish();
                        }
                    }, 1500);
                }
            }
        });
    }

    private boolean checkCases() {
        Boolean result =false;
        if (!checkIfContactUsReadyToSend(nameStr,emailStr,phoneNumberStr,messageStr,this).equals("done"))
        {
            Snackbar.make(view,checkIfContactUsReadyToSend(nameStr,emailStr,phoneNumberStr,messageStr,this), Snackbar.LENGTH_LONG).show();
        } else
        {
            String date = getDATE();
            contactUsMessage = new ContactUsMessage(nameStr,emailStr,phoneNumberStr,userToken,userID
            ,messageStr,contactUsTitle.getTitle(),contactUsTitle.getTitleS(),date,"NOTYET","0","0");
            result = true;
        }

        return result;
    }

    private void cancelMessageListener() {
        cancelMessageRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageEdt.setText("");
                messageStr ="";
            }
        });
    }

    private void cancelPhoneListener() {
        cancelPhoneRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumberEdt.setText("");
                phoneNumberStr ="";
            }
        });
    }

    private void cancelEmailListener() {
        cancelEmailRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailEdt.setText("");
                emailStr ="";
            }
        });
    }

    private void cancelNameListener() {
        cancelNameRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEdt.setText("");
                nameStr ="";
            }
        });
    }

    private void actionListenerToInsta() {
        instaRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInsta();
            }
        });
    }

    private void actionListenerToFB() {
        fbPageRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage();
            }
        });
    }

    private void openPage() {
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = getFacebookPageURL(this);
        facebookIntent.setData(Uri.parse(facebookUrl));
        startActivity(facebookIntent);
    }

    private void openInsta() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://instagram.com/_u/" + "abukhadeer92"));
            intent.setPackage("com.instagram.android");
            startActivity(intent);
        }
        catch (android.content.ActivityNotFoundException anfe)
        {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/" + "abukhadeer92")));
        }
    }

    public static String FACEBOOK_URL = "https://www.facebook.com/abukhader.obidat/";
    public static String FACEBOOK_PAGE_ID = "abukhader.obidat";

    //method to get the right URL to use in the intent
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

    private void actionListenerToEmail() {
        emailRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareEmail();
            }
        });
    }

    private void shareEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","", null));
        emailIntent.putExtra(Intent.EXTRA_TEXT, " ");
        startActivity(Intent.createChooser(emailIntent, "Send Email..."));
    }

    private void inti() {
        view = findViewById(android.R.id.content);
        emailRL = (RelativeLayout) findViewById(R.id.contact_us_activity_email_rl);
        fbPageRL = (RelativeLayout) findViewById(R.id.contact_us_activity_fb_rl);
        instaRL = (RelativeLayout) findViewById(R.id.contact_us_activity_insta_rl);
        cancelNameRL = (RelativeLayout) findViewById(R.id.contact_us_activity_cancel_name_rl);
        cancelEmailRL = (RelativeLayout) findViewById(R.id.contact_us_activity_cancel_email_rl);
        cancelPhoneRL = (RelativeLayout) findViewById(R.id.contact_us_activity_cancel_phone_rl);
        cancelMessageRL = (RelativeLayout) findViewById(R.id.contact_us_activity_cancel_message_rl);
        sendRL = (RelativeLayout) findViewById(R.id.contact_us_activity_send_rl);

        emailTV = (TextView) findViewById(R.id.contact_us_activity_email_tv);
        fbTV = (TextView) findViewById(R.id.contact_us_activity_fb_tv);
        instaTV = (TextView) findViewById(R.id.contact_us_activity_insta_tv);
        leaveMessageTextTV = (TextView) findViewById(R.id.contact_us_activity_leave_message_tv);

        nameEdt = (EditText) findViewById(R.id.contact_us_activity_name_edt);
        emailEdt = (EditText) findViewById(R.id.contact_us_activity_email_edt);
        phoneNumberEdt = (EditText) findViewById(R.id.contact_us_activity_phone_edt);
        messageEdt = (EditText) findViewById(R.id.contact_us_activity_message_edt);

        spinner = (MaterialSpinner) findViewById(R.id.contact_us_activity_spinner);
        progressBar = (ProgressBar) findViewById(R.id.contact_us_activity_progress);
    }

    private void changeFont() {
        emailTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        fbTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        instaTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        leaveMessageTextTV.setTypeface(Functions.changeFontBold(getApplicationContext()));
    }

//    private void actionBarTitle() {
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        final ActionBar abar = getSupportActionBar();
//        View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar_custom_title_view_centered, null);
//        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
//                ActionBar.LayoutParams.WRAP_CONTENT,
//                ActionBar.LayoutParams.MATCH_PARENT,
//                Gravity.CENTER);
//        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);
//        textviewTitle.setText(getResources().getString(R.string.contact_us));
//        textviewTitle.setTypeface(changeFontBold(this));
//        abar.setCustomView(viewActionBar, params);
//        abar.setDisplayShowCustomEnabled(true);
//        abar.setDisplayShowTitleEnabled(false);
//        abar.setDisplayHomeAsUpEnabled(true);
//        abar.setHomeButtonEnabled(true);
//    }

    private void statusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}
