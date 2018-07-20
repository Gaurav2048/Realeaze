package com.realeaze.realeaze.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.realeaze.realeaze.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

TextView taskPending, name_;
TextView day;
    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detail, container, false);
           taskPending = (TextView) view.findViewById(R.id.taskpending);
           day= (TextView) view.findViewById(R.id.day);
        name_ = (TextView) view.findViewById(R.id.name_);

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Regular.ttf");
        taskPending.setTypeface(typeface);
        day.setTypeface(typeface);
        name_.setTypeface(typeface);



    return view;
    }

}
