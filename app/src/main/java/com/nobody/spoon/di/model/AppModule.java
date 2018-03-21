package com.nobody.spoon.di.model;

import com.nobody.spoon.app.App;
import com.nobody.spoon.module.http.HttpHelper;

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
    HttpHelper providerHttpHelper() {
        return null;
    }


}
