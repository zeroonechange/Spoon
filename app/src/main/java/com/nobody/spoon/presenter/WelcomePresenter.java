package com.nobody.spoon.presenter;

import com.nobody.spoon.base.RxPresenter;
import com.nobody.spoon.base.contract.WelcomeContract;
import com.nobody.spoon.module.DataManager;
import com.nobody.spoon.module.bean.WelcomeBean;
import com.nobody.spoon.utils.RxUtil;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * Created by zeroones on 2018/3/21.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {

    private static final String RES = "1080*1776";
    private static final int COUNT_DOWN_TIME = 2200;
    private DataManager dataManager;

    @Inject
    public WelcomePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    // 具体实现在哪儿?
    @Override
    public void getWelcomeData() {
        addSubscribe(dataManager.fetchWelcomeInfo(RES)
                .compose(RxUtil.<WelcomeBean>rxSchedulerHelper())
                .subscribe(new Consumer<WelcomeBean>() {
                    @Override
                    public void accept(WelcomeBean welcomeBean) throws Exception {
                        view.showContent(welcomeBean);
                        startCountDown();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.jumpToMain();
                    }
                }));
    }

    // 不懂  倒计时也能写的这么清新脱俗  ???
    private void startCountDown() {
        addSubscribe(Flowable.timer(COUNT_DOWN_TIME, java.util.concurrent.TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        view.jumpToMain();
                    }
                }));
    }
}
