package com.cars.halamotor_obeidat.view.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.SlidImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PopUp_SlidingImage_Adapter extends PagerAdapter {

    private ArrayList<SlidImage> imageModelArrayList;
    private LayoutInflater inflater;
    private Context context;

    ImageView imageView;

    public PopUp_SlidingImage_Adapter(Context context, ArrayList<SlidImage> imageModelArrayList) {
        this.context = context;
        this.imageModelArrayList = imageModelArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imageModelArrayList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.popup_slidingimages_layout, view, false);

        assert imageLayout != null;

        imageView = (ImageView) imageLayout
                .findViewById(R.id.popup_sliding_image_image);

//        final TextView numberOfImage = (TextView) imageLayout
//                .findViewById(R.id.numberOfImage);

        Picasso.get()
                .load(imageModelArrayList.get(position).getImagePath())
                .fit()
                .centerCrop()
                .into(imageView);


//        numberOfImage.setText(imageModelArrayList.get(position).getImageNumber()
//                +"/"+imageModelArrayList.get(position).getTotalImage());
//
//        numberOfImage.setTypeface(Functions.changeFontBold(context));

        view.addView(imageLayout, 0);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("TAG","HERE");
            }
        });

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}