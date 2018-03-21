package com.nobody.spoon.base.contract;

import com.nobody.spoon.base.BasePresenter;
import com.nobody.spoon.base.BaseView;
import com.nobody.spoon.base.RxPresenter;

/**
 * Created by Robin on 2018/3/21.
 */

public interface MainContract {

    interface View extends BaseView {
        void showUpdateDialog(String content);

        void startDownloadService();
    }

    interface Presenter extends BasePresenter<View> {
        void checkVersion(String curVersion);

    }
}
