package com.nobody.spoon.module.http;

import com.nobody.spoon.module.bean.GoldListBean;
import com.nobody.spoon.module.bean.WelcomeBean;
import com.nobody.spoon.module.http.response.GoldHttpResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by zeroones on 2018/3/21.
 */

public interface HttpHelper {

    Flowable<WelcomeBean> fetchWelcomeInfo(String res);

    Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldList(String type, int num, int page);

    Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldHotList(String type, String dataTime, int limit);
}
