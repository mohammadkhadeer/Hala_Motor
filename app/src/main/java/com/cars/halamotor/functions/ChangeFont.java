package com.cars.halamotor.functions;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.squareup.picasso.Picasso;

import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;

public class ChangeFont {
    public static void changeFont(Context context, TextView textView) {
        textView.setTypeface(Functions.changeFontGeneral(context));
    }

}
