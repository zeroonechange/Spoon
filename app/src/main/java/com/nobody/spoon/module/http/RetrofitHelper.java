package com.nobody.spoon.module.http;

import com.nobody.spoon.module.bean.WelcomeBean;
import com.nobody.spoon.module.http.api.GankApis;
import com.nobody.spoon.module.http.api.GoldApis;
import com.nobody.spoon.module.http.api.MyApis;
import com.nobody.spoon.module.http.api.VtexApis;
import com.nobody.spoon.module.http.api.WeChatApis;
import com.nobody.spoon.module.http.api.ZhihuApis;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Robin on 2018/3/22.
 */

public class RetrofitHelper implements HttpHelper {

    private ZhihuApis mZhihuApiService;
    private GankApis mGankApiService;
    private WeChatApis mWechatApiService;
    private MyApis mMyApiService;
    private GoldApis mGoldApiService;
    private VtexApis mVtexApiService;

    @Inject
    public RetrofitHelper(ZhihuApis zhihuApiService, GankApis gankApiService, WeChatApis wechatApiService,
                          MyApis myApiService, GoldApis goldApiService, VtexApis vtexApiService) {
        this.mZhihuApiService = zhihuApiService;
        this.mGankApiService = gankApiService;
        this.mWechatApiService = wechatApiService;
        this.mMyApiService = myApiService;
        this.mGoldApiService = goldApiService;
        this.mVtexApiService = vtexApiService;
    }


    @Override
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return null;
    }
}
