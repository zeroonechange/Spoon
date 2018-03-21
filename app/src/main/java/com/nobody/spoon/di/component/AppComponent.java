package com.nobody.spoon.di.component;

import com.nobody.spoon.di.model.AppModule;
import com.nobody.spoon.di.model.HttpModule;
import com.nobody.spoon.module.pref.ImplPreferencesHelper;
import com.nobody.spoon.utils.ImageLoader;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zeroones on 2018/3/21.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {


    /**
     * 提供sp帮助 {@link ImageLoader#load(android.content.Context, java.lang.String, android.widget.ImageView)}
     */
    ImplPreferencesHelper preferencesHelper();
}
