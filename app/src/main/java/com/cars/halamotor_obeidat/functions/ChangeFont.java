package com.cars.halamotor_obeidat.functions;

import android.content.Context;
import android.widget.TextView;

public class ChangeFont {
    public static void changeFont(Context context, TextView textView) {
        textView.setTypeface(Functions.changeFontGeneral(context));
    }

}
