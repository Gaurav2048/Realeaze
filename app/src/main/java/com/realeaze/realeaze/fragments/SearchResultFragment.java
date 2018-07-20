package com.realeaze.realeaze.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realeaze.realeaze.Adapters.ProjectAdapter;
import com.realeaze.realeaze.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchResultFragment extends Fragment {

RecyclerView recycler_searchResult;
    public SearchResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_search_result, container, false);

        recycler_searchResult = (RecyclerView) view.findViewById(R.id.recycler_searchResult);
        recycler_searchResult.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler_searchResult.setHasFixedSize(true);
        recycler_searchResult.setAdapter(new ProjectAdapter(getContext()));

        return view;
    }

}
