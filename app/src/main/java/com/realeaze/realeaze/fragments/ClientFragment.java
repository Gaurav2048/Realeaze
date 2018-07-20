package com.realeaze.realeaze.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.realeaze.realeaze.Adapters.ClientAdapter;
import com.realeaze.realeaze.R;
import com.realeaze.realeaze.model.client;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClientFragment extends Fragment {
RecyclerView recyclerView;
ArrayList<client>  clientList = new ArrayList<>();

    public ClientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_client, container, false);
      clientList.add(new client("Allen Chandler", "+91 123 456 6789        ", "client@gmail.com", "2BHK", "1.5 Lkh"));
        clientList.add(new client("John Smith", "+91 123 456 6789        ", "client@gmail.com", "1BHK", "2.5 Lkh"));
        clientList.add(new client("Code Martin", "+91 123 456 6789        ", "client@gmail.com", "3BHK", "2.0 Lkh"));

        recyclerView = view.findViewById(R.id.clientRecycler);
      recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      //Adapter
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ClientAdapter(getContext(), clientList, getActivity()));
        return view;
    }

}