package com.realeaze.realeaze.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.realeaze.realeaze.fragments.Progress.GraphprojectFragment;
import com.realeaze.realeaze.fragments.Progress.LiinearprojectFragment;

/**
 * Created by saurav on 6/5/2018.
 */

public class ProgressPagerAdapter extends FragmentPagerAdapter {
    public ProgressPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {

            case 0:
                return new LiinearprojectFragment();
            case 1:
                return new GraphprojectFragment();

            default: return  null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
