package com.cars.halamotor_obeidat.view.showImageFromGallery;
import com.cars.halamotor_obeidat.functions.Action;
import com.cars.halamotor_obeidat.utils.Utils;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.CustomGallery;
import com.cars.halamotor_obeidat.view.adapters.ImageListRecyclerAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomGalleryActivity extends BaseActivity {

//    @BindView(R.id.gridGallery)
//    GridView gridGallery;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.imgNoMedia)
    ImageView imgNoMedia;

    @BindView(R.id.btnGalleryOk)
    Button btnGalleryOk;

    String action;
    Handler handler;
    //    GalleryAdapter adapter;
    ImageListRecyclerAdapter imageListRecyclerAdapter;
    private HashMap<String, CustomGallery> imagesUri;
    private ImageLoader imageLoader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.gallery);
        ButterKnife.bind(this);

        statusBarColor();

        action = getIntent().getAction();
        if (action == null) {
            finish();
        }
        initImageLoader();
        init();
    }

    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorRed));
        }
    }


    public void initImageLoader() {

        imageLoader = Utils.initImageLoader(getActivity());

    }

    private void init() {
        handler = new Handler();
        imgNoMedia.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        imageListRecyclerAdapter = new ImageListRecyclerAdapter(getApplicationContext());

        recyclerView.setAdapter(imageListRecyclerAdapter);
        if (action.equalsIgnoreCase(Action.ACTION_MULTIPLE_PICK)) {
            findViewById(R.id.llBottomContainer).setVisibility(View.VISIBLE);
            imageListRecyclerAdapter.setMultiplePick(true);
        } else {
            findViewById(R.id.llBottomContainer).setVisibility(View.GONE);
        }


        imageListRecyclerAdapter.setEventListner(new ImageListRecyclerAdapter.EventListener() {
            @Override
            public void onItemClickListener(int position, ImageListRecyclerAdapter.VerticalItemHolder holder) {
                if (imageListRecyclerAdapter.isMultiSelected()) {
                    imageListRecyclerAdapter.changeSelection(holder, position);
                } else {
                    CustomGallery customGallery = imageListRecyclerAdapter.getItem(position);
                    Intent intent = new Intent();
                    intent.putExtra("single_path", customGallery.sdcardPath);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });


//		btnGalleryOk = (Button) findViewById(R.id.btnGalleryOk);
        btnGalleryOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<CustomGallery> selected = imageListRecyclerAdapter.getSelected();

                String[] allPath = new String[selected.size()];
                for (int i = 0; i < allPath.length; i++) {
                    allPath[i] = selected.get(i).sdcardPath;
                }

                Intent data = new Intent().putExtra("all_path", allPath);
                setResult(RESULT_OK, data);
                finish();
            }
        });

        new Thread() {

            @Override
            public void run() {
                Looper.prepare();
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        imageListRecyclerAdapter.addAll(getGalleryPhotos());
                        //checkImageStatus();
                    }
                });
                Looper.loop();
            }


        }.start();

    }

    private void checkImageStatus() {
        if (recyclerView.getAdapter().getItemCount() > 0) {
            imgNoMedia.setVisibility(View.VISIBLE);
        } else {
            imgNoMedia.setVisibility(View.GONE);
        }
    }


    private ArrayList<CustomGallery> getGalleryPhotos() {
        ArrayList<CustomGallery> galleryList = new ArrayList<CustomGallery>();

        try {
            final String[] columns = {MediaStore.Images.Media.DATA,
                    MediaStore.Images.Media._ID};
            final String orderBy = MediaStore.Images.Media._ID;

            Cursor imagecursor = managedQuery(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns,
                    null, null, orderBy);

            if (imagecursor != null && imagecursor.getCount() > 0) {

                while (imagecursor.moveToNext()) {
                    CustomGallery item = new CustomGallery();

                    int dataColumnIndex = imagecursor
                            .getColumnIndex(MediaStore.Images.Media.DATA);

                    item.sdcardPath = imagecursor.getString(dataColumnIndex);

                    galleryList.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // show newest photo at beginning of the list
        Collections.reverse(galleryList);
        return galleryList;
    }

}
