package com.realeaze.realeaze.fragments.project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realeaze.realeaze.Adapters.ProjectAdapter;
import com.realeaze.realeaze.Adapters.RemarkAdapter;
import com.realeaze.realeaze.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemarkFragment extends Fragment {

RecyclerView remark_recyclerview;
    public RemarkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_remark, container, false);
        remark_recyclerview = (RecyclerView) view.findViewById(R.id.remark_recyclerview);
        remark_recyclerview.setHasFixedSize(true);
        remark_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
       // remark_recyclerview.addItemDecoration(new DividerItemDecoration(remark_recyclerview.getContext(), DividerItemDecoration.VERTICAL));
        remark_recyclerview.setHasFixedSize(true);
         remark_recyclerview.setAdapter(new RemarkAdapter(getContext()));

        return view;
    }

}
