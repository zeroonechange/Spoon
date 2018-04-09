package com.nobody.spoon.presenter;

import com.nobody.spoon.base.RxPresenter;
import com.nobody.spoon.base.contract.GoldContract;
import com.nobody.spoon.module.DataManager;

import javax.inject.Inject;

/**
 * Created by Robin on 2018/3/30.
 */

public class GoldPresenter extends RxPresenter<GoldContract.View> implements GoldContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public GoldPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getGoldData(String type) {

    }

    @Override
    public void getMoreGoldData() {

    }
}
