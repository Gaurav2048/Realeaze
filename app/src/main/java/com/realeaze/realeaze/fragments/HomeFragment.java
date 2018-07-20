package com.realeaze.realeaze.fragments;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.realeaze.realeaze.R;
import com.realeaze.realeaze.fragments.project.AmenityFragment;
import com.realeaze.realeaze.fragments.project.OverViewFragment;
import com.realeaze.realeaze.fragments.project.ProjectViewFragment;
import com.realeaze.realeaze.fragments.project.RemarkFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
ViewPager viewPager;
TabLayout tabLayout;
OverViewFragment overViewFragment;
AmenityFragment amenityFragment;
ProjectViewFragment projectViewFragment;
RemarkFragment remarkFragment;
TextView location_id,project_title;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        overViewFragment = new OverViewFragment();
        amenityFragment = new AmenityFragment();
        projectViewFragment = new ProjectViewFragment();
        remarkFragment = new RemarkFragment();
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        project_title= (TextView) view.findViewById(R.id.project_title);
        location_id = (TextView) view.findViewById(R.id.location_id);
        createViewPager(viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);
        createTabIcons();
       TabLayout.Tab tab= tabLayout.getTabAt(0);
       tab.select();
       highlIghtTab(tab, 0);
       typeFace();


tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {


highlIghtTab(tab, tabLayout.getSelectedTabPosition());


    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
shlwTab(tab);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
});


        return  view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        viewPager.setAdapter(null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        viewPager.setAdapter(null);

    }

    private void typeFace() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Bold.ttf");
        project_title.setTypeface(typeface);
        Typeface typeface_reg = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Regular.ttf");
        location_id.setTypeface(typeface_reg);
    }

    private void shlwTab(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        TextView name = view.findViewById(R.id.text);
        view.setBackground(null);
        name.setTextColor(Color.argb(255, 187, 192, 198));
        ImageView front = view.findViewById(R.id.front);
        ImageView back = view.findViewById(R.id.back);
        front.setEnabled(false);
        back.setEnabled(false);
        front.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
    }

    private void highlIghtTab(final TabLayout.Tab tab, final int i) {
    View view = tab.getCustomView();
    TextView name = view.findViewById(R.id.text);
    view.setBackgroundResource(R.drawable.tab_back);
    name.setTextColor(Color.argb(255, 247, 93, 67));
    ImageView front = view.findViewById(R.id.front);
    ImageView back = view.findViewById(R.id.back);
  front.setEnabled(true);
  back.setEnabled(true);
    front.setVisibility(View.VISIBLE);
    back.setVisibility(View.VISIBLE);
    front.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         // toast
  if(i!=3) {
     tabLayout.getTabAt(i + 1).select();
     shlwTab(tab);
     highlIghtTab(tabLayout.getTabAt(i + 1), i + 1);
 }
        }
    });
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           if(i!=0){
              tabLayout.getTabAt(i-1).select();
              shlwTab(tab);
              highlIghtTab(tabLayout.getTabAt(i-1), i-1);
          }
        }
    });
    // click listner
    }

    private void createTabIcons() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Regular.ttf");
        LinearLayout tabOne = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.amaze_tab, null);
        tabOne.setBackground(null);
        TextView tv_= (TextView) tabOne.findViewById(R.id.text);
        tv_.setTypeface(typeface);
        tv_.setText("Overview");
        ImageView im_back = (ImageView) tabOne.findViewById(R.id.back);
        im_back.setVisibility(View.INVISIBLE);
        ImageView im_front = (ImageView) tabOne.findViewById(R.id.front);
        im_front.setVisibility(View.INVISIBLE);
        im_back.setEnabled(false);
        im_front.setEnabled(false);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        LinearLayout tabOne1 = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.amaze_tab, null);
        tabOne1.setBackground(null);
        TextView tv_1= (TextView) tabOne1.findViewById(R.id.text);
        tv_1.setTypeface(typeface);
        tv_1.setText("Amenities");
        ImageView im_back1 = (ImageView) tabOne1.findViewById(R.id.back);
        im_back1.setVisibility(View.INVISIBLE);
        ImageView im_front1 = (ImageView) tabOne1.findViewById(R.id.front);
        im_front1.setVisibility(View.INVISIBLE);
        im_back1.setEnabled(false);
        im_front1.setEnabled(false);
        tabLayout.getTabAt(1).setCustomView(tabOne1);

        LinearLayout tabOne2 = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.amaze_tab, null);
        tabOne2.setBackground(null);
        TextView tv_2= (TextView) tabOne2.findViewById(R.id.text);
        tv_2.setTypeface(typeface);
        tv_2.setText("Project view");
        ImageView im_back2 = (ImageView) tabOne2.findViewById(R.id.back);
        im_back2.setVisibility(View.INVISIBLE);
        ImageView im_front2 = (ImageView) tabOne2.findViewById(R.id.front);
        im_front2.setVisibility(View.INVISIBLE);
        im_back2.setEnabled(false);
        im_front2.setEnabled(false);
        tabLayout.getTabAt(2).setCustomView(tabOne2);

        LinearLayout tabOne3 = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.amaze_tab, null);
        tabOne3.setBackground(null);
        TextView tv_3= (TextView) tabOne3.findViewById(R.id.text);
        tv_3.setTypeface(typeface);
        tv_3.setText("Project Remark");
        ImageView im_back3 = (ImageView) tabOne3.findViewById(R.id.back);
        im_back3.setVisibility(View.INVISIBLE);
        ImageView im_front3 = (ImageView) tabOne3.findViewById(R.id.front);
        im_front3.setVisibility(View.INVISIBLE);
        im_back3.setEnabled(false);
        im_front3.setEnabled(false);
        tabLayout.getTabAt(3).setCustomView(tabOne3);

    }

    private void createViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag( overViewFragment, "Overview");
        adapter.addFrag(amenityFragment, "Amenities");
        adapter.addFrag(projectViewFragment, "Project view");
        adapter.addFrag(remarkFragment, "Project Remark");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
