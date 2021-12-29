package com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.AccAndJunkFirstCase;
import com.cars.halamotor_obeidat.model.CCEMT;
import com.cars.halamotor_obeidat.model.CarPlatesFirstCase;
import com.cars.halamotor_obeidat.model.CommentsComp;
import com.cars.halamotor_obeidat.model.WheelsRimFirstCase;
import com.cars.halamotor_obeidat.presnter.ItemModel;

import static com.cars.halamotor_obeidat.fireBaseDB.GetFromFireBaseDB.getCCEMTObject;
import static com.cars.halamotor_obeidat.fireBaseDB.UploadModelsToFireBase.writeComment;
import static com.cars.halamotor_obeidat.functions.Functions.getTimeStamp;
import static com.cars.halamotor_obeidat.functions.Functions.replace;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserImage;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserTokenInFromSP;

public class FragmentComments extends Fragment {

    public FragmentComments(){}

    String test;
    View view;
    EditText writeCommentEdt;
    ImageView sendCommentIV;
    String itemIDStr,categoryStr,userID;

    CCEMT ccemtComment;
    CarPlatesFirstCase carPlatesFirstCase;
    WheelsRimFirstCase wheelsRimFirstCase;
    AccAndJunkFirstCase accAndJunkFirstCase;
    CommentsComp commentsComp;
    int haveCommentContent = 0;

    ItemModel itemModel;
    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            categoryStr = getArguments().getString("category");
            itemIDStr = getArguments().getString("itemID");
            userID = getArguments().getString("userID");
            categoryStr = replace(categoryStr);

        }
        Log.i("categoryStr",categoryStr);
        Log.i("itemIDStr",itemIDStr);
        Log.i("userID",userID);

        super.onAttach(context);

        if (getActivity() instanceof ItemModel) {
            itemModel = (ItemModel) getActivity();
        }
        //++++++++++++
        getCCEMTObject(categoryStr,itemIDStr,itemModel);


        detectObject();
    }

    private void detectObject() {
        if (categoryStr.equals("Car for sale")
                ||categoryStr.equals("Car for rent")
                ||categoryStr.equals("Exchange car")
                ||categoryStr.equals("Motorcycle")
                ||categoryStr.equals("Trucks")
        ) {
            //ccemtFirestCase =getCCEMTFirstCaseFromDB(itemIDStr,getActivity());
        }
        if (categoryStr.equals("Car plates"))
        {
            //carPlatesFirstCase =getCarPlatesFirstCaseFromDB(itemIDStr,getActivity());
        }
        if (categoryStr.equals("Wheels rim"))
        {
            //wheelsRimFirstCase =getWheelsRimFirstCaseFromDB(itemIDStr,getActivity());
        }
        if (categoryStr.equals("Accessories") || categoryStr.equals("Junk car"))
        {
            //accAndJunkFirstCase =getAccAndJunkFirstCaseFromDB(itemIDStr,getActivity());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_selected_comment, container, false);
        //Log.i("TAG",test);
        init();
        listenerToComment();
        actionListenerToSendComment();
        return view;
    }

    private void actionListenerToSendComment() {
        sendCommentIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (haveCommentContent == 1)
                {
                    writeComment(commentsComp,categoryStr,itemIDStr);
                }
            }
        });
    }

    private void listenerToComment() {
        writeCommentEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0) {
                    String commentContant = String.valueOf(cs);
                    sendCommentIV.setAlpha((float) 1.0);
                    haveCommentContent = 1;
                    commentsComp = new CommentsComp(commentContant,
                            getUserTokenInFromSP(getActivity()),getUserImage(getActivity())
                            ,getTimeStamp());
                }
                else {
                    sendCommentIV.setAlpha((float) 0.5);
                    haveCommentContent = 0;
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

        });
    }

    private void init() {
        writeCommentEdt = (EditText) view.findViewById(R.id.writeYourComment);
        sendCommentIV = (ImageView) view.findViewById(R.id.send_comment);
    }

}
