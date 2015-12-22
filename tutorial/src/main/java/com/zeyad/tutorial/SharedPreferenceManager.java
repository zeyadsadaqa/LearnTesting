package com.zeyad.tutorial;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Zeyad Assem on 22/12/15.
 */
public class SharedPreferenceManager {
    SharedPreferences sharedPreferences;
    private final String SHARED_PREFERENCE_NAME = "tutorial";

     public SharedPreferenceManager(Context context){
         sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME,1);
     }

    public boolean getBooleanValue(String key, boolean defaultValue){
        if (key != null) {
            return sharedPreferences.getBoolean(key, defaultValue);
        }

        return defaultValue;
    }

    public void setBooleanValue(String key, boolean value){
        if (key != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit()
                    .putBoolean(key, value);
            editor.commit();
        }
    }


}
