package com.realeaze.realeaze.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realeaze.realeaze.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClientrecFragment extends Fragment {


    public ClientrecFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_clientrec, container, false);

   return view;
    }

}
