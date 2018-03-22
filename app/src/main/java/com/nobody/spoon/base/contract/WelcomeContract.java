package com.nobody.spoon.base.contract;

import com.nobody.spoon.base.BasePresenter;
import com.nobody.spoon.base.BaseView;
import com.nobody.spoon.module.bean.WelcomeBean;

/**
 * Created by Robin on 2018/3/21.
 */

public interface WelcomeContract {
    interface View extends BaseView {
        void showContent(WelcomeBean bean);

        void jumpToMain();
    }

    interface Presenter extends BasePresenter<View> {
        void getWelcomeData();
    }
}
