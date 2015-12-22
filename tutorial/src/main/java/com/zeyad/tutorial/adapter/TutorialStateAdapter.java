package com.zeyad.tutorial.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;
import com.zeyad.tutorial.R;
import com.zeyad.tutorial.TutorialFragment;

import java.util.ArrayList;

/**
 * Created by Zeyad Assem on 22/12/15.
 * @author Zeyad Assem.
 *
 * The tutorial pager adapter.
 */
public class TutorialStateAdapter extends FragmentStatePagerAdapter implements IconPagerAdapter {

    private ArrayList<Integer> zPicsIDsArrayList;

    /**
     * This is the constructor, initialize the adapter with the pictures drawable ids.
     * @param fm is the fragment manager needed for the adapter.
     * @param picsArrayList is the list of drawable ids.
     */
    public TutorialStateAdapter(FragmentManager fm , ArrayList<Integer> picsArrayList) {
        super(fm);
        zPicsIDsArrayList = picsArrayList;
    }

    @Override
    public Fragment getItem(int position) {

        TutorialFragment tutorialFragment = new TutorialFragment();
        Bundle args = new Bundle();
        args.putInt("imgResId", zPicsIDsArrayList.get(position));
        args.putInt("pos", position);
        tutorialFragment.setArguments(args);

        return tutorialFragment;
    }

    @Override
    public int getCount() {
        return zPicsIDsArrayList.size();
    }

    @Override
    public int getIconResId(int index) {
        return R.drawable.indicator_selector;
    }
}
