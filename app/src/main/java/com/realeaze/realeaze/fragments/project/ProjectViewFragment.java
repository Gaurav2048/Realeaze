package com.realeaze.realeaze.fragments.project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.realeaze.realeaze.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectViewFragment extends Fragment {

ImageView prject_sight;
    public ProjectViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view = inflater.inflate(R.layout.fragment_project_view, container, false);

     prject_sight = (ImageView) view.findViewById(R.id.image_project_sigt);
        Picasso.get().load(R.drawable.view).into(prject_sight);

     return view;
    }

}
