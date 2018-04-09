package com.nobody.spoon.base.contract;


import com.nobody.spoon.base.BasePresenter;
import com.nobody.spoon.base.BaseView;
import com.nobody.spoon.module.bean.GoldListBean;

import java.util.List;

/**
 * Created by codeest on 16/11/27.
 */

public interface GoldContract {

    interface View extends BaseView {

        void showContent(List<GoldListBean> goldListBean);

        void showMoreContent(List<GoldListBean> goldMoreListBean, int start, int end);
    }

    interface Presenter extends BasePresenter<View> {

        void getGoldData(String type);

        void getMoreGoldData();
    }
}
