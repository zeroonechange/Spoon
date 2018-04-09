package com.nobody.spoon.di.component;

import android.app.Activity;

import com.nobody.spoon.di.model.FragmentModule;
import com.nobody.spoon.di.scope.FragmentScope;
import com.nobody.spoon.ui._1_main.fragment.GoldPagerFragment;

import dagger.Component;

/**
 * Created by zeroones on 2018/3/21.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(GoldPagerFragment goldPagerFragment);
}
