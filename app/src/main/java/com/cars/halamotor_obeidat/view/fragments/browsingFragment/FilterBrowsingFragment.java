package com.cars.halamotor_obeidat.view.fragments.browsingFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.BrowsingFilter;
import com.cars.halamotor_obeidat.view.adapters.AdapterBrowsingFilter;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.functions.NewFunction.fillBrowsingArrayL;

public class FilterBrowsingFragment extends Fragment implements AdapterBrowsingFilter.PassSelectedFilter {

    ArrayList<BrowsingFilter> favouriteCallSearchesArrayList;
    RecyclerView recyclerView;
    AdapterBrowsingFilter adapterBrowsingFilter;
    RecyclerView.LayoutManager layoutManagerSuggested;
    View view;
    public ArrayList<BrowsingFilter> filterContentArrayL ;
    TextView textView,browsingDep;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_browsing_filters_fragment, container, false);
        init();
        changeFont();
        createSelectedFilterRV();
        return view;
    }

    private void changeFont() {
        textView.setTypeface(Functions.changeFontGeneral(getActivity()));
        browsingDep.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void createSelectedFilterRV() {
        favouriteCallSearchesArrayList = new ArrayList<>();
        favouriteCallSearchesArrayList = fillBrowsingArrayL(getActivity());

        recyclerView.setHasFixedSize(true);
        layoutManagerSuggested = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManagerSuggested);
        adapterBrowsingFilter =new AdapterBrowsingFilter(getActivity()
                , favouriteCallSearchesArrayList,this);
        recyclerView.setAdapter(adapterBrowsingFilter);
    }

    private void init() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_browsing_filter_1_RV);
        textView = (TextView) view.findViewById(R.id.browsing_by_text_view);
        browsingDep = (TextView) view.findViewById(R.id.browsing_dep_text_view);
    }

    @Override
    public void onFilterClicked(ArrayList<BrowsingFilter> selectedFilter) {
        String filterBy = "";
        filterContentArrayL = new ArrayList<>();
        for (int j =0;j<selectedFilter.size();j++)
        {
            if (selectedFilter.get(j).isSelected() == true)
            {
                filterContentArrayL.add(selectedFilter.get(j));
            }
        }

        if (filterContentArrayL.isEmpty())
        {
            filterBy = getActivity().getResources().getString(R.string.all);
        }else{
            if (1 <filterContentArrayL.size())
            {
                for (int i =0 ;i <filterContentArrayL.size();i++)
                {
                    if (i ==0)
                    {
                        filterBy = filterContentArrayL.get(i).getFilterString();
                    }else{
                        filterBy = filterBy + " | "+  filterContentArrayL.get(i).getFilterString();
                    }
                }
            }else{
                filterBy = filterContentArrayL.get(0).getFilterString();
            }
        }
        textView.setText(filterBy);
    }
}
