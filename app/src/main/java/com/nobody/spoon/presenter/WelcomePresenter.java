package com.nobody.spoon.presenter;

import com.nobody.spoon.base.RxPresenter;
import com.nobody.spoon.base.contract.WelcomeContract;

import javax.inject.Inject;

/**
 * Created by Robin on 2018/3/21.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {

    @Inject
    public WelcomePresenter() {

    }

    @Override
    public void getWelcomeData() {

    }
}
