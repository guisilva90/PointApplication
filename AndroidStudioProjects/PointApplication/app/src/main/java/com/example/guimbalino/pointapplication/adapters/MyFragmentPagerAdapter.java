package com.example.guimbalino.pointapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guimbalino.pointapplication.fragments.FragmentA;
import com.example.guimbalino.pointapplication.fragments.FragmentB;
import com.example.guimbalino.pointapplication.fragments.FragmentC;

/**
 * Created by guimbalino on 11/3/16.
 */


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabTitles;

    public MyFragmentPagerAdapter(FragmentManager fm, String[] mTabTitles) {
        super(fm);
        this.mTabTitles = mTabTitles;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FragmentA();
            case 1:
                return new FragmentB();
            case 2:
                return new FragmentC();
            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return this.mTabTitles.length;
    }
}
