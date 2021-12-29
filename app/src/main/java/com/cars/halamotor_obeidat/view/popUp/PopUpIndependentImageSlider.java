package com.cars.halamotor_obeidat.view.popUp;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.SlidImage;
import com.cars.halamotor_obeidat.view.adapters.PopUp_SlidingImage_Adapter;
import java.util.ArrayList;
import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class PopUpIndependentImageSlider {
    public static void createPopUp(Context context, View view, ArrayList<String> imagesUrlArrayL,ArrayList<SlidImage> imageModelArrayList) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_image_slider, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.setAnimationStyle(R.style.popup_window_animation_phone);
        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        ViewPager viewPager = popupView.findViewById(R.id.view_pager);
        viewPager.setAdapter(new PopUp_SlidingImage_Adapter(context,imageModelArrayList));

        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
    }
}
