package com.nobody.spoon.module.db;

import com.nobody.spoon.module.bean.GoldManagerBean;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by zeroones on 2018/3/22.
 */

public class RealmHelper implements DBHelper {

    private static final String DB_NAME = "myRealm.realm";

    private Realm mRealm;

    @Inject
    public RealmHelper() {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }

    @Override
    public void updateGoldManagerList(GoldManagerBean bean) {

    }

    @Override
    public GoldManagerBean getGoldManagerList() {
        return null;
    }
}
