package com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CreatorInfo;
import com.cars.halamotor_obeidat.presnter.FavouriteChange;
import com.cars.halamotor_obeidat.view.activity.ReportActivity;
import com.cars.halamotor_obeidat.view.activity.UserProfile;
import com.squareup.picasso.Picasso;

import static com.cars.halamotor_obeidat.algorithms.ArrangingLists.checkFavouriteOrNot1;
import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertItemsToFCS;
import static com.cars.halamotor_obeidat.presnter.UploadLogAdActions.postAdAction;

public class FragmentUserInfo extends Fragment {

    public FragmentUserInfo(){}

    String item_id,timePostStr,itemName
            ,timStampStr,messageShare,userID,category_code;
    View view;
    TextView userNameTV,userStatusTV,itemNameTV,dateTV;
    RelativeLayout userStatusRL,favouriteRL,profileInfoRL,reportRL,shareRL;
    ImageView userImageIV,favouriteIV,shareIV,reportIV;

    FavouriteChange favouriteChange;
    int numberOfChange =0;

    private static final int REPORT = 2000;
    Dialog myDialog;

    CreatorInfo creatorInfo;
    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            item_id = getArguments().getString("itemID");
            timePostStr = getArguments().getString("timePost");
            category_code = getArguments().getString("category_code");
            itemName = getArguments().getString("item_name");
            creatorInfo = getArguments().getParcelable("CreatorInfo");
        }
        super.onAttach(context);
        if (getActivity() instanceof FavouriteChange) {
            favouriteChange = (FavouriteChange) getActivity();
        }
        //favoriteChange = (FavoriteChange) activity;

        messageShare = "Text well share here";
    }


    @Override
    public void onDetach() {
        super.onDetach();
        favouriteChange = null;
    }

    private void inti() {
        userImageIV = (ImageView) view.findViewById(R.id.fragment_u_i_a_m_image_IV);
        userNameTV = (TextView) view.findViewById(R.id.fragment_u_i_a_m_user_name_TV);
        itemNameTV = (TextView) view.findViewById(R.id.fragment_u_i_a_m_user_item_name_TV);
        dateTV = (TextView) view.findViewById(R.id.fragment_u_i_a_m_user_item_date_TV);
        userStatusRL = (RelativeLayout) view.findViewById(R.id.fragment_u_i_a_m_status);
        userStatusTV = (TextView) view.findViewById(R.id.fragment_u_i_a_m_user_status_TV);

        favouriteRL = (RelativeLayout) view.findViewById(R.id.fragment_u_i_a_m_favourite_RL);
        reportRL = (RelativeLayout) view.findViewById(R.id.fragment_u_i_a_m_report_RL);
        shareRL  = (RelativeLayout) view.findViewById(R.id.fragment_u_i_a_m_share_RL);
        profileInfoRL  = (RelativeLayout) view.findViewById(R.id.fragment_u_i_RL);

        favouriteIV = (ImageView) view.findViewById(R.id.fragment_u_i_a_m_favourite_IV);
        shareIV = (ImageView) view.findViewById(R.id.fragment_u_i_a_m_share_IV);
        reportIV = (ImageView) view.findViewById(R.id.fragment_u_i_a_m_report_IV);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_info, container, false);
        inti();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeFont();
        fillUserImage();
        fillText();
        checkIfFavouriteOrNot();
        actionListenerToFavouriteOrNot();
        actionListenerToShare();
        actionListenerToProfile();
        actionListenerToReport();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REPORT && resultCode == Activity.RESULT_OK) {
            showPopup(view);
        }
    }

    public void showPopup(View anchorView) {
        myDialog = new Dialog(getActivity());
        TextView txtclose;
        RelativeLayout closeRL;
        myDialog.setContentView(R.layout.popup_layout);
        txtclose =(TextView) myDialog.findViewById(R.id.popup_layout_tv);
        txtclose.setTypeface(Functions.changeFontBold(getActivity()));
        closeRL = (RelativeLayout) myDialog.findViewById(R.id.popup_layout_rl);
        closeRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    private void actionListenerToReport() {
        reportRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("userID", userID);
                bundle.putString("itemID", item_id);

                Intent intent = new Intent(getActivity(), ReportActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent , REPORT);
                getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
        });
    }

    private void actionListenerToProfile() {
        profileInfoRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("creator_info",creatorInfo);

                Intent intent = new Intent(getActivity(), UserProfile.class);
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
        });
    }

    private void actionListenerToShare() {
        shareRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, messageShare);
                startActivity(Intent.createChooser(sharingIntent,"com.facebook.katana"));
            }
        });
    }

    private void actionListenerToFavouriteOrNot() {
        favouriteRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfChange = numberOfChange+1;
                favouriteChange.onFavouriteChange(numberOfChange);
                if (checkFavouriteOrNot1(getActivity(),item_id).equals("not_favorite"))
                {
                    favouriteIV.setBackgroundResource(R.drawable.selcted_favorite);

                    insertItemsToFCS(item_id,category_code
                            ,getDataBaseInstance(getActivity()),"favorite",getActivity());

                    postAdAction(item_id,"favorite",getActivity());

                }else
                {
                    favouriteIV.setBackgroundResource(R.drawable.item_favu);
                    getDataBaseInstance(getActivity()).deleteFCS(item_id);
                }
            }
        });
    }

    private void checkIfFavouriteOrNot() {
        if (checkFavouriteOrNot1(getActivity(),item_id).equals("not_favorite"))
        {
            favouriteIV.setBackgroundResource(R.drawable.item_favu);
        }else
        {
            favouriteIV.setBackgroundResource(R.drawable.selcted_favorite);
        }
    }

    private void fillText() {
        //Log.e("TAG time ",timStampStr);
        userNameTV.setText(creatorInfo.getName());
        itemNameTV.setText(itemName);
        userStatusTV.setText(getActivity().getResources().getString(R.string.online));
        dateTV.setText(timePostStr);
        // dateTV.setText(dateStr);
    }

    private void fillUserImage() {

        Picasso.get()
                .load(creatorInfo.getPhoto())
                .fit()
                .centerCrop()
                .into(userImageIV);
    }

    private void changeFont() {
        userNameTV.setTypeface(Functions.changeFontBold(getActivity()));
        userStatusTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        itemNameTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        dateTV.setTypeface(Functions.changeFontGeneral(getActivity()));
    }
}