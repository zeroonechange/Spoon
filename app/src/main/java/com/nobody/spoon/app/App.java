package com.nobody.spoon.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.nobody.spoon.base.InitializeService;
import com.nobody.spoon.di.component.AppComponent;
import com.nobody.spoon.di.component.DaggerAppComponent;
import com.nobody.spoon.di.model.AppModule;
import com.nobody.spoon.di.model.HttpModule;

import java.util.HashSet;
import java.util.Set;

import io.realm.Realm;

/**
 * Created by zeroones on 2018/3/20.
 */

public class App extends Application {

    private static App instance;
    public static AppComponent appComponent;
    private Set<Activity> allActs;


    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;


    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        //初始化屏幕宽高
        getScreenSize();

        //初始化数据库
        Realm.init(getApplicationContext());

        //在子线程中完成其他初始化    卧槽还有这种操作
        InitializeService.start(this);
    }

    public static App getInstance() {
        return instance;
    }


    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }

    public void removeAct(Activity act) {
        if (allActs != null) allActs.remove(act);
    }

    public void addActivity(Activity act) {
        if (allActs == null) allActs = new HashSet<>();
        allActs.add(act);
    }


    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }
}
