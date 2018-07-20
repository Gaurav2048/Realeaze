package com.realeaze.realeaze.fragments;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.realeaze.realeaze.Adapters.ProgressPagerAdapter;
import com.realeaze.realeaze.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgressFragment extends Fragment {

ViewPager viewPager;
TextView name_progress;
TabLayout tabLayout;
TextView project_word;
    public ProgressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_progress, container, false);
      tabLayout = (TabLayout) view.findViewById(R.id.viewpager_tabl);


       name_progress = (TextView) view.findViewById(R.id.name_progress);
       project_word = (TextView) view.findViewById(R.id.progressing_project);
       viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        Typeface typeface= Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Regular.ttf");
        project_word.setTypeface(typeface);
        name_progress.setTypeface(typeface);

        viewPager.setAdapter(new ProgressPagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        createTabs();
        highlIghtTab(tabLayout.getTabAt(0));
     tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
         @Override
         public void onTabSelected(TabLayout.Tab tab) {
             highlIghtTab(tab);
         }

         @Override
         public void onTabUnselected(TabLayout.Tab tab) {
shallowTab(tab);
         }

         @Override
         public void onTabReselected(TabLayout.Tab tab) {

         }
     });
       return view;
    }

    private void shallowTab(TabLayout.Tab tab) {
      //  tab.setCustomView(null);
        //tab.setCustomView((LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fade, null));
View view = tab.getCustomView();
   ImageView on_viw= view.findViewById(R.id.one);
        ImageView tw_viw= view.findViewById(R.id.two);
    if(tabLayout.getSelectedTabPosition()==0){

        on_viw.setVisibility(View.INVISIBLE);
        on_viw.setBackgroundColor(Color.argb(255, 203, 203, 203));
        tw_viw.setBackgroundColor(Color.argb(255, 203, 203, 203));

    }else if(tabLayout.getSelectedTabPosition()==1){
        tw_viw.setVisibility(View.INVISIBLE);
        on_viw.setBackgroundColor(Color.argb(255, 203, 203, 203));
        tw_viw.setBackgroundColor(Color.argb(255, 203, 203, 203));

    }
    }

    private void highlIghtTab(final TabLayout.Tab tab ) {

        View view = tab.getCustomView();
        ImageView on_viw= view.findViewById(R.id.one);
        ImageView tw_viw= view.findViewById(R.id.two);

        if(tabLayout.getSelectedTabPosition()==0){

            on_viw.setVisibility(View.VISIBLE);
            on_viw.setBackgroundColor(Color.argb(255, 247, 93, 67));
            tw_viw.setBackgroundColor(Color.argb(255, 247, 93, 67));

        }else if(tabLayout.getSelectedTabPosition()==1){
            tw_viw.setVisibility(View.VISIBLE);
            on_viw.setBackgroundColor(Color.argb(255, 247, 93, 67));
            tw_viw.setBackgroundColor(Color.argb(255, 247, 93, 67));

        }
    }
    private void createTabs() {
         LinearLayout tabOne = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.appear, null);

        tabLayout.getTabAt(0).setCustomView(tabOne);

        LinearLayout tabOne1 = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fade, null);

        tabLayout.getTabAt(1).setCustomView(tabOne1);

    }

}
