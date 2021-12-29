package com.cars.halamotor_obeidat.view.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor_obeidat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.Locale;

import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.getObjectPathInServerFireStore;
import static com.cars.halamotor_obeidat.functions.Functions.setLocale;

public class EditPostActivity extends AppCompatActivity {

    private static final int REQUEST_EDIT_POST = 55;
    TextView textView,textViewNameAndPrice;
    ImageView imageView,cancel;
    EditText editText;
    RelativeLayout relativeLayout,deleteNumberRL,backRL;
    String userMessageStr;
    String itemID,category,imagePath;
    String itemName,numberOfEdit;
    Long itemPrice;
    LinearLayout linearLayoutNewP,linearLayoutBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_edit_post);

        statusBarColor();
        actionBarTitle();
        getItemIDFromIntent();
        inti();
        fillImage();
        getDataFromServer();
        actionListenerToRemoveTextInPriceEdt();
        actionListenerToPriceEdt();
        actionListenerToEditPrice();
        actionListenerToBack();
    }

    private void actionListenerToBack() {
        backRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void actionListenerToEditPrice() {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int y = Integer.parseInt(numberOfEdit);
                if (!editText.getText().toString().isEmpty())
                {
                    long x = Long.parseLong(editText.getText().toString());
                    if (x <= itemPrice)
                    {
                     if (y <=3)
                     {
                         updateInfo();
                     }
                    }else{
                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.price_m1),Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.fill_new_price),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateInfo() {
        int x = Integer.parseInt(numberOfEdit);
        int sum = x+1;
        String newNumberOfEdit = String.valueOf(sum);
        DocumentReference documentReference=getObjectPathInServerFireStore(category,itemID);
        documentReference.update("newPrice",editText.getText().toString(),
                                "postEdit","1"
                                ,"numberOfEdit",newNumberOfEdit).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.edited_successfully),Toast.LENGTH_SHORT).show();
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("edit","yes");
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("TAG","erorr "+ e.toString());
            }
        });
    }

    private void actionListenerToPriceEdt() {
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0)
                    makeCancelTitleIVVISIBLE();
                else
                    makeCancelTitleIVGONE();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
    }

    private void makeCancelTitleIVVISIBLE() {
        cancel.setVisibility(View.VISIBLE);
    }

    private void makeCancelTitleIVGONE() {
        cancel.setVisibility(View.GONE);
    }

    private void actionListenerToRemoveTextInPriceEdt() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }

    private void fillNameAndPrice() {
        String text1,text2,text3,text4;
        text1 = getResources().getString(R.string.item_name)+" ";
        text2 = itemName;
        text3 = "  "+getResources().getString(R.string.item_price)+" ";
        text4 = String.valueOf(itemPrice);
        textViewNameAndPrice.setText(text1+text2+text3+text4);
    }

    private void fillImage() {
        Picasso.get()
                .load(imagePath)
                .fit()
                .centerCrop()
                .into(imageView);
    }

    private void inti() {
        textViewNameAndPrice = (TextView) findViewById(R.id.edit_post_itemName);
        textView = (TextView) findViewById(R.id.edit_post_message);
        imageView = (ImageView) findViewById(R.id.item_image_iv);
        cancel = (ImageView) findViewById(R.id.activity_edit_ImageV);
        editText = (EditText) findViewById(R.id.activity_edit_searchEdt);
        relativeLayout = (RelativeLayout) findViewById(R.id.edit_activity_button);
        deleteNumberRL = (RelativeLayout) findViewById(R.id.edit_activity_RL);
        backRL = (RelativeLayout) findViewById(R.id.edit_activity_back);
        linearLayoutNewP = (LinearLayout) findViewById(R.id.edit_activity_new_price_l);
        linearLayoutBack = (LinearLayout) findViewById(R.id.edit_activity_back_l);
    }

    private void getDataFromServer() {
        DocumentReference documentReference=getObjectPathInServerFireStore(category,itemID);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        itemName = document.getString("itemName");
                        numberOfEdit = document.getString("numberOfEdit");
                        if (numberOfEdit.equals("0"))
                        {
                            itemPrice = document.getLong("price");
                        }
                        else
                        {
                            String p = document.getString("newPrice");
                            itemPrice = Long.parseLong(p);
                        }
                        fillNameAndPrice();
                        handelMessage();
                    }
                }
            }
        });

    }

    private void handelMessage() {
        String text1,text2,text3,text4,text5;
        if (numberOfEdit.equals("0"))
        {
            text1 = getResources().getString(R.string.user_message_1)+" ";
            text2 = itemName;
            text5 = getResources().getString(R.string.user_message_3);
            userMessageStr = text1 + text2 + text5;
            textView.setText(userMessageStr);
        }
        if (numberOfEdit.equals("1"))
        {
            text1 = getResources().getString(R.string.user_message_4)+" ";
            text2 = itemName;
            text5 = getResources().getString(R.string.user_message_5);
            userMessageStr = text1 + text2 + text5;
            textView.setText(userMessageStr);
        }
        if (numberOfEdit.equals("2"))
        {
            text1 = getResources().getString(R.string.user_message_6)+" ";
            text2 = itemName;
            text5 = getResources().getString(R.string.user_message_7);
            userMessageStr = text1 + text2 + text5;
            textView.setText(userMessageStr);
        }
        if (numberOfEdit.equals("3"))
        {
            text1 = getResources().getString(R.string.user_message_8)+" ";
            text2 = itemName+" ";
            text5 = getResources().getString(R.string.user_message_9);
            userMessageStr = text1 + text2 + text5;
            textView.setText(userMessageStr);
            linearLayoutNewP.setVisibility(View.GONE);
            linearLayoutBack.setVisibility(View.VISIBLE);
        }

    }


    private void getItemIDFromIntent() {
        Bundle bundle = getIntent().getExtras();
        itemID =bundle.getString("itemID");
        category =bundle.getString("category");
        imagePath =bundle.getString("imagePath");
    }

    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorRed));
        }
    }

    private void actionBarTitle() {
        Typeface typeface;
        final ActionBar abar = getSupportActionBar();
        View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar_custom_title_view_centered, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        if (Locale.getDefault().getLanguage().equals("ar")) {
            typeface = Typeface.createFromAsset(getAssets(), "GE_DINAR_ONE_LIGHT.TTF");
        }else{
            typeface = Typeface.createFromAsset(getAssets(), "NTAILU.TTF");
        }
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);
        textviewTitle.setText(getResources().getString(R.string.edit_option));
        textviewTitle.setTypeface(typeface);
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(false);
        abar.setHomeButtonEnabled(false);
    }

}
