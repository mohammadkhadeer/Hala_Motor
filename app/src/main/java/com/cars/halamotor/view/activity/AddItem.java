package com.cars.halamotor.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Transition;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Action;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.CategoryComp;
import com.cars.halamotor.model.CustomGallery;
import com.cars.halamotor.permission.CheckPermission;
import com.cars.halamotor.utils.Utils;
import com.cars.halamotor.view.adapters.AdapterSelectCategory;
import com.cars.halamotor.view.adapters.SelectedImageAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import butterknife.ButterKnife;

import static com.cars.halamotor.functions.Functions.fillCategoryArrayList;

public class AddItem extends AppCompatActivity {

    RelativeLayout cancelRL,selectImageFGRL,selectVideoRL,coverVideoViewRL
            ,cancelVideoRL,cancelSelectedCategoryRL,add_activity_complete_car_dCV;
    TextView insertAddTV,textTitleTV,categorySelectedNameTV;
    RecyclerView viewSelectedImageRV,selectCategoryRV;
    VideoView viewVideoSelected;
    ImageView imageCategorySelectedIV;

    CardView viewSelectedCategoryCV;

    private static final int PICK_FROM_GALLERY = 1;
    private static final int REQUEST_TAKE_GALLERY_VIDEO = 2;

    ImageLoader imageLoader;

    SelectedImageAdapter selectedImageAdapter;
    AdapterSelectCategory adapterSelectCategory;

    ArrayList<String> imagePathArrL = new ArrayList<String>();
    public ArrayList<CategoryComp> categoryCompsArrayL ;

    RecyclerView.LayoutManager layoutManager,layoutManagerCategory;
    static int selectVideoOrNotYet = 0;

    Uri mVideoURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        ButterKnife.bind(this);

        statusBarColor();
        inti();
        hideVideoShowBeforeSelected();
        initImageLoader();
        changeFontType();
        actionListener();
        careateSelectCategoryRV();
        showSelectedCategoryAfterUserChoose();

    }

    private void showSelectedCategoryAfterUserChoose() {
        selectCategoryRV.addOnItemTouchListener(
                new AdapterSelectCategory.RecyclerItemClickListener(AddItem.this, selectCategoryRV ,new AdapterSelectCategory.RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        goneRVAndVisableSelectedCategoryAndFillSelectedInfo(position);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    private void goneRVAndVisableSelectedCategoryAndFillSelectedInfo(int position) {
        viewSelectedCategoryCV.setVisibility(View.VISIBLE);
        selectCategoryRV.setVisibility(View.GONE);
        imageCategorySelectedIV.setBackgroundResource(categoryCompsArrayL.get(position).getImageIdInt());
        categorySelectedNameTV.setText(categoryCompsArrayL.get(position).getCategoryNameStr());
        textTitleTV.setText(getResources().getText(R.string.process_now));
    }

    private void careateSelectCategoryRV() {
        categoryCompsArrayL = fillCategoryArrayList(categoryCompsArrayL,getApplicationContext());
        selectCategoryRV.setNestedScrollingEnabled(false);
        selectCategoryRV.setHasFixedSize(true);
        layoutManagerCategory = new LinearLayoutManager(AddItem.this,
                LinearLayoutManager.HORIZONTAL, false);
        selectCategoryRV.setLayoutManager(layoutManagerCategory);
        adapterSelectCategory =new AdapterSelectCategory(AddItem.this
                ,categoryCompsArrayL);
        selectCategoryRV.setAdapter(adapterSelectCategory);
    }

    private void hideVideoShowBeforeSelected() {
        viewVideoSelected.setVisibility(View.GONE);
        coverVideoViewRL.setVisibility(View.GONE);
    }

    public void initImageLoader() {
        imageLoader = Utils.initImageLoader(AddItem.this);
    }

    private void actionListener() {
        cancelRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        selectImageFGRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckPermission.checkPermissionMethodToSelectPhoto(AddItem.this) == true) {
                    Intent i = new Intent(Action.ACTION_MULTIPLE_PICK);
                    startActivityForResult(i, 200);
                }
            }
        });

        selectVideoRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckPermission.checkPermissionMethodToSelectPhoto(AddItem.this) == true) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent , REQUEST_TAKE_GALLERY_VIDEO);
                }
            }
        });

        cancelVideoRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coverVideoViewRL.setVisibility(View.GONE);
                selectVideoOrNotYet = 0;
                mVideoURI = null;
            }
        });

        cancelSelectedCategoryRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSelectedCategoryCV.setVisibility(View.GONE);
                selectCategoryRV.setVisibility(View.VISIBLE);
                textTitleTV.setText(getResources().getText(R.string.what_do));
            }
        });

        add_activity_complete_car_dCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transition fade = new Fade();
                fade.excludeTarget(android.R.id.statusBarBackground, true);
                 getWindow().setExitTransition(fade);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults)
    {
        switch (requestCode) {
            case PICK_FROM_GALLERY:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    Intent i = new Intent(Action.ACTION_MULTIPLE_PICK);
                    startActivityForResult(i, 200);
                } else {
                }
                break;
        }
    }

    private void changeFontType() {
        insertAddTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        textTitleTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        categorySelectedNameTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
    }

    private void inti() {
        viewSelectedImageRV = (RecyclerView) findViewById(R.id.add_activity_view_selected_image_RV);
        selectCategoryRV = (RecyclerView) findViewById(R.id.add_activity_view_select_category_RV);
        cancelRL = (RelativeLayout) findViewById(R.id.add_activity_cancelRL);
        textTitleTV = (TextView) findViewById(R.id.add_activity_titleTV);
        insertAddTV = (TextView) findViewById(R.id.add_activity_insert_titleTV);
        categorySelectedNameTV = (TextView) findViewById(R.id.add_activity_view_select_category_from_RV_TV);
        selectImageFGRL = (RelativeLayout) findViewById(R.id.add_activity_selectIFG_RL);
        selectVideoRL = (RelativeLayout) findViewById(R.id.add_activity_select_videoRL);
        coverVideoViewRL = (RelativeLayout) findViewById(R.id.add_activity_cover_show_video);
        viewVideoSelected = (VideoView) findViewById(R.id.add_activity_show_video);
        cancelVideoRL = (RelativeLayout) findViewById(R.id.add_activity_cancel_videoRL);
        viewSelectedCategoryCV = (CardView) findViewById(R.id.add_activity_view_select_category_from_RV);
        add_activity_complete_car_dCV = (RelativeLayout) findViewById(R.id.add_activity_complete_car_dCV);
        cancelSelectedCategoryRL = (RelativeLayout) findViewById(R.id.add_activity_view_select_category_from_RV_delete);
        imageCategorySelectedIV = (ImageView) findViewById(R.id.add_activity_view_select_category_from_RV_IV);
    }

    private void statusBarColor() {
       getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == Activity.RESULT_OK) {
            getSelectedImagePathes(data);
            showSelectedImage();
            if (selectVideoOrNotYet == 1)
            replayVideo();
        }
        if (requestCode == REQUEST_TAKE_GALLERY_VIDEO && resultCode == Activity.RESULT_OK) {
            selectVideoOrNotYet =1;
            showSelectedVideo(data);
        }
    }

    private void showSelectedVideo(Intent data) {
        // String pickedVideoUrl = getRealPathFromUri(getApplicationContext(), data.getData());
        viewVideoSelected.setVisibility(View.VISIBLE);
        coverVideoViewRL.setVisibility(View.VISIBLE);
        mVideoURI  = data.getData();
        viewVideoSelected.setVideoURI(mVideoURI);

        viewVideoSelected.requestFocus();
        viewVideoSelected.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                viewVideoSelected.start();
                replayVideo();
            }
        });
    }

    private void replayVideo() {
        viewVideoSelected.setOnCompletionListener ( new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                viewVideoSelected.start();
            }
        });
    }

    private void getSelectedImagePathes(Intent data) {
        String[] all_path = data.getStringArrayExtra("all_path");

        ArrayList<CustomGallery> dataT = new ArrayList<CustomGallery>();
        imagePathArrL = new ArrayList<String>();

        for (String string : all_path) {
            CustomGallery item = new CustomGallery();
            item.sdcardPath = string;
            imagePathArrL.add(item.sdcardPath);
            dataT.add(item);
        }
    }

    private void showSelectedImage() {
        viewSelectedImageRV.setNestedScrollingEnabled(false);
        viewSelectedImageRV.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(AddItem.this,
                LinearLayoutManager.HORIZONTAL, false);
        viewSelectedImageRV.setLayoutManager(layoutManager);

        selectedImageAdapter =new SelectedImageAdapter(AddItem.this
                ,imagePathArrL);
        viewSelectedImageRV.setAdapter(selectedImageAdapter);
    }

}
