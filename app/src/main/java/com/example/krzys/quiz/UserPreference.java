package com.example.krzys.quiz;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by krzys on 23.11.2016.
 */

public class UserPreference {

    public static final String LEVEL = "level";
    public static final String USERNAME = "username";
    private final SharedPreferences mPreferences;

    public UserPreference(Context context){
        this.mPreferences= context.getSharedPreferences("user",Context.MODE_PRIVATE);
    }

    public String getUsername() {
        return mPreferences.getString(USERNAME,"");
    }

    public void setUsername(String username) {
mPreferences.edit().putString(USERNAME,username).apply();
    }

    public int getLevel() {
return mPreferences.getInt(LEVEL,0);
    }

    public void setLevel(int level) {
mPreferences.edit().putInt(LEVEL,level).apply();
    }
}
