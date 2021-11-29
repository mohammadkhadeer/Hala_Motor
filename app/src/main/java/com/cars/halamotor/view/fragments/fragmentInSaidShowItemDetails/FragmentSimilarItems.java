package com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cars.halamotor.R;
import com.cars.halamotor.dataBase.DBHelper;
import com.cars.halamotor.model.CCEMTModel;
import com.cars.halamotor.model.SimilarNeeded;
import com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.userAds.FragmentSuggestedAds;
import com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.userAds.FragmentUserAds;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.functions.Functions.replace;

import java.util.ArrayList;

public class FragmentSimilarItems extends Fragment {

    public FragmentSimilarItems(){}

    String category,item_id,user_type,user_id,user_name;
    DBHelper myDB;
    View view;

    //SimilarNeeded similarNeeded;
    FragmentUserAds fragmentUserAds = new FragmentUserAds();
    FragmentSuggestedAds fragmentSuggestedAds = new FragmentSuggestedAds();

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            category = getArguments().getString("category");
            category = replace(category);
            item_id = getArguments().getString("item_id");
            user_id = getArguments().getString("user_id");
            user_type = getArguments().getString("user_type");
            user_name = getArguments().getString("user_name");
            category = getArguments().getString("category");

            //similarNeeded = (SimilarNeeded) getArguments().getParcelable("similarNeeded");
//            categoryStr = "Car_For_Exchange";
        }
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_selected_suggested, container, false);
        //intiUserAds();
        intiSuggestedAds();
        return view;
    }

    private void intiUserAds() {
        Bundle bundle = new Bundle();
        bundle.putString("user_id", user_id);
        bundle.putString("user_name", user_name);
        bundle.putString("user_type", user_type);
        fragmentUserAds.setArguments(bundle);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment_user_ads, fragmentUserAds)
                .commit();
    }

    private void intiSuggestedAds() {
        Bundle bundle = new Bundle();
        bundle.putString("userID", user_id);
        bundle.putString("category", category);
        bundle.putString("itemID", item_id);
        //bundle.putParcelable("similarNeeded", similarNeeded);
        fragmentSuggestedAds.setArguments(bundle);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment_suggested_ads, fragmentSuggestedAds)
                .commit();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getDataBaseInstance(getActivity()).deleteSimilarAds();
    }

    public void recivedARelativeRe(ArrayList<CCEMTModel> ccemtModelArrayList){
        fragmentSuggestedAds.handleResult(ccemtModelArrayList);
    }

}
