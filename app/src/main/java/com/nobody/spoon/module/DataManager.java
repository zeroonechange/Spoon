package com.nobody.spoon.module;

import com.nobody.spoon.module.bean.GoldManagerBean;
import com.nobody.spoon.module.bean.WelcomeBean;
import com.nobody.spoon.module.db.DBHelper;
import com.nobody.spoon.module.http.HttpHelper;
import com.nobody.spoon.module.pref.PreferencesHelper;

import io.reactivex.Flowable;

/**
 * Created by zeroones on 2018/3/21.
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

    public void updateGoldManagerList(GoldManagerBean bean) {
        mDbHelper.updateGoldManagerList(bean);
    }

    @Override
    public boolean getManagerPoint() {
        return mPreferencesHelper.getManagerPoint();
    }


    @Override
    public GoldManagerBean getGoldManagerList() {
        return mDbHelper.getGoldManagerList();
    }

    @Override
    public void setManagerPoint(boolean isFirst) {
        mPreferencesHelper.setManagerPoint(isFirst);
    }
}
