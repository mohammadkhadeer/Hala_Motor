package com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;

import static com.cars.halamotor_obeidat.functions.Functions.makeTextViewResizable;

public class FragmentIDescriptionAndGeneralTips extends Fragment {

    public FragmentIDescriptionAndGeneralTips(){}

    String categoryStr,itemDescription;
    View view;
    TextView descriptionContentTV,descriptionTV,generalTips
            ,generalTips1,generalTips2,generalTips3;
    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            categoryStr = getArguments().getString("category");
            itemDescription = getArguments().getString("itemDes");
        }
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_selected_des_general, container, false);
        inti();
        return view;
    }

    private void inti() {
        descriptionContentTV = (TextView) view.findViewById(R.id.descriptionContentTV);
        descriptionTV = (TextView) view.findViewById(R.id.descriptionTV);
        generalTips = (TextView) view.findViewById(R.id.generalTips);
        generalTips1 = (TextView) view.findViewById(R.id.generalTips1);
        generalTips2 = (TextView) view.findViewById(R.id.generalTips2);
        generalTips3 = (TextView) view.findViewById(R.id.generalTips3);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeFont();
        fillDes();

    }

    private void fillDes() {
        String des = getActivity().getResources().getString(R.string.large_text);
        //Log.i("TAG SIZE", String.valueOf(des.length()));
        descriptionContentTV.setText(itemDescription);
        if (itemDescription.length() > 185)
        {
            //Log.i("TAG SIZE", String.valueOf(des.length()));
            String seeMore = getActivity().getResources().getString(R.string.see_more);
            makeTextViewResizable(descriptionContentTV, 4, seeMore, true,getActivity());
        }
    }

    private void changeFont() {
        descriptionContentTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        descriptionTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        generalTips.setTypeface(Functions.changeFontGeneral(getActivity()));
        generalTips1.setTypeface(Functions.changeFontGeneral(getActivity()));
        generalTips2.setTypeface(Functions.changeFontGeneral(getActivity()));
        generalTips3.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    }
