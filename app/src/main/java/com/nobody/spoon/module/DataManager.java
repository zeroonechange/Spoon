package com.nobody.spoon.module;

import com.nobody.spoon.module.bean.WelcomeBean;
import com.nobody.spoon.module.db.DBHelper;
import com.nobody.spoon.module.http.HttpHelper;
import com.nobody.spoon.module.pref.PreferencesHelper;

import io.reactivex.Flowable;

/**
 * Created by Robin on 2018/3/21.
 */

public class DataManager implements HttpHelper, DBHelper, PreferencesHelper {

    HttpHelper mHttpHelper;
    DBHelper mDbHelper;
    PreferencesHelper mPreferencesHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper, PreferencesHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public boolean getNoImageState() {
        return mPreferencesHelper.getNoImageState();
    }

    @Override
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mHttpHelper.fetchWelcomeInfo(res);
    }
}
