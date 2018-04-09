package com.nobody.spoon.ui._1_main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nobody.spoon.ui._1_main.fragment.GoldPagerFragment;

import java.util.List;

/**
 * Created by Robin on 2018/3/30.
 */

public class GoldPagerAdapter extends FragmentStatePagerAdapter {

    private List<GoldPagerFragment> fragments;

    public GoldPagerAdapter(FragmentManager fm, List<GoldPagerFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
