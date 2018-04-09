package com.nobody.spoon.di.component;

import com.nobody.spoon.app.App;
import com.nobody.spoon.di.model.AppModule;
import com.nobody.spoon.di.model.HttpModule;
import com.nobody.spoon.module.DataManager;
import com.nobody.spoon.module.db.RealmHelper;
import com.nobody.spoon.module.http.RetrofitHelper;
import com.nobody.spoon.module.pref.ImplPreferencesHelper;
import com.nobody.spoon.utils.ImageLoader;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by zeroones on 2018/3/21.
 * AppModule 是准备
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();       // 提供App的Context

    DataManager getDataManager();   // 数据中心

    RetrofitHelper retrofitHelper();  // 不太清楚

    RealmHelper realmHelper();          // 本地数据库的操作都在这

    ImplPreferencesHelper preferencesHelper();  // 这里貌似可以做个工具类  不用在这里写
}
