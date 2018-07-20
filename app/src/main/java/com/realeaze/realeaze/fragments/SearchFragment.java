package com.realeaze.realeaze.fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.realeaze.realeaze.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View vview = inflater.inflate(R.layout.fragment_search, container, false);
        /*AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(),  R.style.full_screen_dialog);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }

        LayoutInflater inflater_dialog = getActivity().getLayoutInflater();
        View dialogView = inflater_dialog.inflate(R.layout.activity_main, null);
        builder.setView(dialogView);

        AlertDialog a_dilaog = builder.create();
        a_dilaog.show();*/
        Dialog dialog2 = new Dialog(getContext(), R.style.full_screen_dialog);
        dialog2.setContentView(R.layout.search_layout);
        Toolbar toolbar = dialog2.findViewById(R.id.toolbar);
        WindowManager.LayoutParams lp = dialog2.getWindow().getAttributes();
        Window window = dialog2.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        lp.gravity = Gravity.CENTER;

        dialog2.show();
         return vview;
    }

}
