package com.nobody.spoon.module.http;

import com.nobody.spoon.module.bean.WelcomeBean;

import io.reactivex.Flowable;

/**
 * Created by zeroones on 2018/3/21.
 */

public interface HttpHelper {

    Flowable<WelcomeBean> fetchWelcomeInfo(String res);

}
