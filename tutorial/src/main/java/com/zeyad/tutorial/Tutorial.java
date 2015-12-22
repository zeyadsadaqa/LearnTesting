package com.zeyad.tutorial;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by Zeyad Assem on 22/12/15.
 * @author Zeyad Assem.
 * @version one
 *
 * The first class to start you tutorial.
 */
public class Tutorial {

    private static Activity zContext;
    private static SharedPreferenceManager zSharedPreferenceManager;

    /**
     * This method starts your tutorial that you want to show it for the first time only.
     * @param context is the Activity that will call this function.
     * @param picsArrayList this is an array list of drawable images to be shown in the tutorial.
     */
    public static void startFirstTimeTutorial(Activity context, ArrayList<Integer> picsArrayList) {
        zContext = context;

        zSharedPreferenceManager = new SharedPreferenceManager(context);
        if (zSharedPreferenceManager.getBooleanValue(
                zContext.getString(R.string.is_first_time_to_run), true)) {
            Intent intent =  new Intent(zContext, TutorialActivity.class);
            intent.putIntegerArrayListExtra("pics",picsArrayList);
            context.startActivity(intent);
        }
    }

    /**
     * This method starts your tutorial again if you want to show it again.
     * @param context is the Activity that will call this function.
     * @param picsArrayList this is an array list of drawable images to be shown in the tutorial.
     */
    public static void startTutorial(Activity context, ArrayList<Integer> picsArrayList) {
        zContext = context;

        zSharedPreferenceManager = new SharedPreferenceManager(context);
        Intent intent =  new Intent(zContext, TutorialActivity.class);
        intent.putIntegerArrayListExtra("pics",picsArrayList);
        context.startActivity(intent);
    }

}
