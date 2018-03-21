package com.nobody.spoon.presenter;

import com.nobody.spoon.base.RxPresenter;
import com.nobody.spoon.base.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by zeroones on 2018/3/21.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter(){

    }

    @Override
    public void checkVersion(String curVersion) {

    }
}
