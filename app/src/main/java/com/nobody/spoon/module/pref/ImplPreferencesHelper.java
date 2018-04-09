package com.nobody.spoon.module.pref;


import android.content.Context;
import android.content.SharedPreferences;

import com.nobody.spoon.app.App;
import com.nobody.spoon.app.Constants;

import javax.inject.Inject;

/**
 * Created by zeroones on 2018/3/21.
 */

public class ImplPreferencesHelper implements PreferencesHelper {
    private static final boolean DEFAULT_NO_IMAGE = false;

    private static final String SHAREDPREFERENCES_NAME = "my_sp";
    private final SharedPreferences mSPrefs;

    @Inject
    public ImplPreferencesHelper() {
        mSPrefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public boolean getNoImageState() {
        return mSPrefs.getBoolean(Constants.SP_NO_IMAGE, DEFAULT_NO_IMAGE);
    }

    @Override
    public boolean getManagerPoint() {
        return false;
    }

    @Override
    public void setManagerPoint(boolean isFirst) {

    }
}
