package com.cars.halamotor.functions;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.cars.halamotor.R;
import com.squareup.picasso.Picasso;

import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;

public class FillText {
    public static String getTextEngOrLocal(Context context, String eng, String local) {
//        if (Locale.getDefault().getLanguage().equals("en"))
        if (getUserLanguage(context).equals("en"))
            return eng;
        else
            return local;
    }

    public static void fillImageView(Context context, ImageView imageView) {
//        if (Locale.getDefault().getLanguage().equals("en"))
        if (getUserLanguage(context).equals("en"))
        {
            Picasso.get()
                    .load(R.drawable.arrow)
                    .fit()
                    .centerCrop()
                    .into(imageView);
        }
        else
            {
                Picasso.get()
                        .load(R.drawable.arrow_ar)
                        .fit()
                        .centerCrop()
                        .into(imageView);
            }
    }
}
