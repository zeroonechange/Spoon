package com.nobody.spoon.base.contract;


import com.nobody.spoon.base.BasePresenter;
import com.nobody.spoon.base.BaseView;
import com.nobody.spoon.module.bean.GoldManagerBean;
import com.nobody.spoon.module.bean.GoldManagerItemBean;

import java.util.List;

/**
 * Created by codeest on 16/11/28.
 */

public interface GoldMainContract {

    interface View extends BaseView {

        void updateTab(List<GoldManagerItemBean> mList);

        void jumpToManager(GoldManagerBean mBean);
    }

    interface Presenter extends BasePresenter<View> {

        void initManagerList();

        void setManagerList();
    }
}
