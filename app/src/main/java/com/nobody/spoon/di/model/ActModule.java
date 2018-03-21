package com.nobody.spoon.di.model;

import android.app.Activity;

import dagger.Module;

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

    /**
     * 构造函数用来提供给BaseAct来构造ActComponent的
     * {@link com.nobody.spoon.base.BaseAct#getActModule() }
     */
    public ActModule(Activity activity) {
        this.act = activity;
    }
}
