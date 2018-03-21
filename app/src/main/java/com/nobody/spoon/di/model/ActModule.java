package com.nobody.spoon.di.model;

import android.app.Activity;

import com.nobody.spoon.di.scope.ActScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zeroones on 2018/3/21.
 * well 这个module看起来没啥用  事实上在这里真的没啥用  O(∩_∩)O
 * <p>
 * module一般放一些第三方的  没法依赖注入的  需要直接new的那种东西  比如这里可以放一些和Activity相关的  暂时我也没想出来
 * <p>
 * 参考AppModule  那里提供了本地数据库  远程访问的 入口
 * 参考HttpModule 那里提供了Okhttp相关的  统一的第三方配置都在那
 */
@Module
public class ActModule {
    private Activity act;

    // 构造函数用来提供给BaseAct来构造ActComponent的
    public ActModule(Activity activity) {
        this.act = activity;
    }

    /** 这个方法纯粹是因为Dagger2需要  ActComponent有 那么这里也需要
     * Error:(28, 10) 错误: com.nobody.spoon.presenter.MainPresenter cannot be provided without an @Inject constructor or from an @Provides- or @Produces-annotated method.
     * com.nobody.spoon.base.BaseAct.mPresenter
     * [injected field of type: com.nobody.spoon.presenter.MainPresenter mPresenter]
     */
    @Provides
    @ActScope
    public Activity provideAct() {
        return act;
    }
}
