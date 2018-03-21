package com.nobody.spoon.di.component;

import android.app.Activity;

import com.nobody.spoon.di.model.ActModule;
import com.nobody.spoon.di.scope.ActScope;
import com.nobody.spoon.ui.main.act.MainActivity;

import dagger.Component;

/**
 * Created by zeroones on 2018/3/21.
 */

/**
 * Scope 范围  使用范围
 *
 * @Singleton可以保持类的单例。
 * @ApplicationScope注解的Component类与Applicaiton对象的生命周期一致。
 * @ActivityScope注解的Component类与Activity的生命周期一致
 * @Component关联的@Module中的任何一个@Provides有@scope，则该整个@Component要加上这个scope。
 * @Component的dependencies与@Component自身的scope不能相同，即组件之间的scope不能相同,否则出现错误。
 * @Singleton的组件不能依赖其他scope的组件，但是其他scope的组件可以依赖@Singleton组件。否则出现错误。 没有scope的不能依赖有scope的组件。
 * 一个component不能同时有多个scope(Subcomponent除外)，否则出现错误
 */
@ActScope   // todo: 需要深究 ---  ↑↑↑↑↑   finished
@Component(dependencies = AppComponent.class, modules = ActModule.class)
public interface ActComponent {

    Activity getActivity();

    void injectMainAct(MainActivity mainAct);
}
