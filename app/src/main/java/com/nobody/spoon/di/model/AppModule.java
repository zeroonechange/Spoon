package com.nobody.spoon.di.model;

import com.nobody.spoon.app.App;
import com.nobody.spoon.module.DataManager;
import com.nobody.spoon.module.db.DBHelper;
import com.nobody.spoon.module.db.RealmHelper;
import com.nobody.spoon.module.http.HttpHelper;
import com.nobody.spoon.module.http.RetrofitHelper;
import com.nobody.spoon.module.pref.ImplPreferencesHelper;
import com.nobody.spoon.module.pref.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 在Module中构建DataManager，依赖关系
 * <p>
 * DataManager -> {HttpHelper, DBHelper, PreferencesHelper}
 */

@Module
public class AppModule {
    private final App app;  // why app here?

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    App provideApp() {
        return app;
    }

    @Provides
    @Singleton
    HttpHelper providerHttpHelper(RetrofitHelper helper) {
        return helper;
    }

    @Provides
    @Singleton
    DBHelper provideDBHelper(RealmHelper helper) {
        return helper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePrefHelper(ImplPreferencesHelper helper) {
        return helper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DBHelper dbHelper, PreferencesHelper preferencesHelper) {
        return new DataManager(httpHelper, dbHelper, preferencesHelper);
    }

}
