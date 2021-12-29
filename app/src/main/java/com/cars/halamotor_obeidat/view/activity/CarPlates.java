package com.cars.halamotor_obeidat.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.PlatesChar;
import com.cars.halamotor_obeidat.view.adapters.AdapterPlatesChar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.functions.Functions.changeFontBold;
import static com.cars.halamotor_obeidat.functions.Functions.fillEmiratesEmirate;
import static com.cars.halamotor_obeidat.functions.Functions.setLocale;
import static com.cars.halamotor_obeidat.functions.NewFunction.fillPlatesChar;

public class CarPlates extends AppCompatActivity implements AdapterPlatesChar.PassChar{

    MaterialSpinner spinner;
    String [] emiratesEmirate;
    String selectedCity;
    Switch switchCompat;
    EditText carPlatesEdt;
    ImageView cancelCarPlatesIV;
    RelativeLayout cancelCarPlatesRL;
    TextView messageTV,charTV;
    int specialIntOrNot;
    String specialIntOrNotStr;
    RecyclerView recyclerView;
    ArrayList<PlatesChar> platesChar = new ArrayList<>();
    AdapterPlatesChar adapterPlatesChar;
    RecyclerView.LayoutManager layoutManager;
    String platesCharStr = "A";
    RelativeLayout relativeLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_car_plates);

        statusBarColor();
        actionBarTitle();
        inti();
        fillAndCreateAndActionListenerSpinner();
        getStringFromIntent();
        fillSwitch();
        makeKeyBordOn();
        actionListenerToSwitch();
        actionListenerToDoneInKeyBoard();
        listenerCarPlatesEdt();
        actionListenerToCanselTextInEdt();
        createRV();
    }

    private void createRV() {
        platesChar = fillPlatesChar(this);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        adapterPlatesChar =new AdapterPlatesChar(getApplicationContext()
                , platesChar,this);
        recyclerView.setAdapter(adapterPlatesChar);
    }

    private void fillSwitch() {
        if (specialIntOrNotStr.equals("special"))
        {
            switchCompat.setChecked(true);
            specialIntOrNot =1;
            messageTV.setVisibility(View.VISIBLE);
        }else{
            switchCompat.setChecked(false);
            specialIntOrNot =0;
            messageTV.setVisibility(View.GONE);
        }
    }

    private void actionListenerToSwitch() {
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {

                if (isChecked) {
                    specialIntOrNot =1;
                    messageTV.setVisibility(View.VISIBLE);
                }
                else {
                    specialIntOrNot =0;
                    messageTV.setVisibility(View.GONE);
                }
            }
        });
    }

    private void getStringFromIntent() {
        Bundle bundle = getIntent().getExtras();
        specialIntOrNotStr =bundle.getString("specialIntOrNot");
    }

    private void actionListenerToCanselTextInEdt() {
        cancelCarPlatesRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carPlatesEdt.setText("");
            }
        });
    }

    private void makeCancelTitleIVVISIBLE() {
        cancelCarPlatesIV.setVisibility(View.VISIBLE);
    }

    private void makeCancelTitleIVGONE() {
        cancelCarPlatesIV.setVisibility(View.GONE);
    }

    private void listenerCarPlatesEdt() {
        carPlatesEdt.addTextChangedListener(new TextWatcher() {

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
            public void afterTextChanged(Editable arg0) {
            }

        });
    }

    private void actionListenerToDoneInKeyBoard() {
        carPlatesEdt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(carPlatesEdt.getText().toString().isEmpty())
                {
                    Snackbar.make(spinner, getResources().getString(R.string.message_fill_car_plates), Snackbar.LENGTH_LONG).show();
                }else{
                    translateToAddItem();
                }
                return false;
            }
        });
    }

    private void translateToAddItem() {
        String specialOrNot;
        if (specialIntOrNot ==1)
            specialOrNot = "special";
        else
            specialOrNot = "normal";
        if (selectedCity == null)
            selectedCity = getResources().getString(R.string.abu_dhabi);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("carPlatesNum", carPlatesEdt.getText().toString());
        resultIntent.putExtra("carPlatesCity", platesCharStr+"  "+selectedCity);
        resultIntent.putExtra("specialOrNot", specialOrNot);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void makeKeyBordOn() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    private void fillAndCreateAndActionListenerSpinner() {
        spinner.setItems(fillEmiratesEmirate(emiratesEmirate,this));
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                selectedCity = item;
                //Snackbar.make(view, "Clicked " + selectedCity, Snackbar.LENGTH_LONG).show();
            }
        });
        spinner.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {

            @Override public void onNothingSelected(MaterialSpinner spinner) {
                selectedCity = getResources().getString(R.string.abu_dhabi);
                //Snackbar.make(spinner, selectedCity, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void inti() {
        spinner = (MaterialSpinner) findViewById(R.id.spinner);
        switchCompat = (Switch) findViewById(R.id.car_plates_description_switch);
        carPlatesEdt = (EditText) findViewById(R.id.car_plates_number_Edt);
        cancelCarPlatesIV = (ImageView) findViewById(R.id.car_plates_cancel_IV);
        cancelCarPlatesRL = (RelativeLayout) findViewById(R.id.car_plates_cancel_RL);
        messageTV = (TextView) findViewById(R.id.car_plates_description_message_TV);
        recyclerView = (RecyclerView) findViewById(R.id.activity_car_plates_char_rv);
        charTV = (TextView) findViewById(R.id.activity_car_plates_tv);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_car_plates_coverRL);
    }

    private void actionBarTitle() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ActionBar abar = getSupportActionBar();
        View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar_custom_title_view_centered, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);
        textviewTitle.setText(getResources().getString(R.string.car_plates));
        textviewTitle.setTypeface(changeFontBold(this));
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(true);
        abar.setHomeButtonEnabled(true);
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
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onClicked(String platesChar) {
        platesCharStr = platesChar;
        charTV.setText(platesChar);
    }
}
