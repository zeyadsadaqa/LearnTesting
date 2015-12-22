package com.zeyad.tutorial;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.viewpagerindicator.IconPageIndicator;
import com.zeyad.tutorial.adapter.TutorialStateAdapter;

import java.util.ArrayList;

/**
 * Created by Zeyad Assem on 22/12/15.
 * @author Zeyad Assem.
 *
 * The tutorial Activity that opened to show your tutorial.
 */


public class TutorialActivity extends AppCompatActivity {
    private ViewPager zTutorialPager;
    private IconPageIndicator zPageIndicator;
    private SharedPreferenceManager zSharedPreferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        zSharedPreferenceManager = new SharedPreferenceManager(this);

            if (zSharedPreferenceManager.getBooleanValue(getString(R.string.is_first_time_to_run), true)) {
                zSharedPreferenceManager.setBooleanValue(getString(R.string.is_first_time_to_run), false);
            }

            zTutorialPager = (ViewPager) findViewById(R.id.tutorial_pager);
            zPageIndicator = (IconPageIndicator) findViewById(R.id.indicator);

            zTutorialPager.setAdapter(new TutorialStateAdapter(getSupportFragmentManager(), getPicsArrayList()));
            zPageIndicator.setViewPager(zTutorialPager, getPicsArrayList().size() - 1);
    }

    /**
     * This method gets an array list of pics drawable ids in your app, sent to it through intent.
     * @return picsArrayList , a list of pics drawable ids.
     */
    private ArrayList<Integer> getPicsArrayList(){
        return getIntent().getIntegerArrayListExtra("pics");
    }
}
