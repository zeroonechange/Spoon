package com.nobody.spoon.presenter;

import com.nobody.spoon.base.RxPresenter;
import com.nobody.spoon.base.contract.GoldMainContract;
import com.nobody.spoon.base.rx.CommonSubscriber;
import com.nobody.spoon.base.rx.RxBus;
import com.nobody.spoon.module.DataManager;
import com.nobody.spoon.module.bean.GoldManagerBean;
import com.nobody.spoon.module.bean.GoldManagerItemBean;
import com.nobody.spoon.utils.RxUtil;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Robin on 2018/3/30.
 */

public class GoldMainPresenter extends RxPresenter<GoldMainContract.View> implements GoldMainContract.Presenter {

    private DataManager mDataManager;
    private RealmList<GoldManagerItemBean> mList;

    @Inject
    public GoldMainPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(GoldMainContract.View v) {
        super.attachView(v);
        registerEvent();
    }


    private void registerEvent() {
        addSubscribe(RxBus.getDefault().toFlowable(GoldManagerBean.class)
                .compose(RxUtil.<GoldManagerBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<GoldManagerBean>(view, "设置失败", false) {
                    @Override
                    public void onNext(GoldManagerBean goldManagerBean) {
                        mDataManager.updateGoldManagerList(goldManagerBean);
                        view.updateTab(goldManagerBean.getManagerList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        registerEvent();
                    }
                })
        );
    }

    @Override
    public void initManagerList() {
        if (mDataManager.getManagerPoint()) {
            //第一次使用，生成默认ManagerList
            initList();
            mDataManager.updateGoldManagerList(new GoldManagerBean(mList));
            view.updateTab(mList);
        } else {
            if (mDataManager.getGoldManagerList() == null) {
                initList();
                mDataManager.updateGoldManagerList(new GoldManagerBean(mList));
            } else {
                mList = mDataManager.getGoldManagerList().getManagerList();
            }
            view.updateTab(mList);
        }
    }

    @Override
    public void setManagerList() {
        view.jumpToManager(mDataManager.getGoldManagerList());
    }

    private void initList() {
        mList = new RealmList<>();
        mList.add(new GoldManagerItemBean(0, true));
        mList.add(new GoldManagerItemBean(1, true));
        mList.add(new GoldManagerItemBean(2, true));
        mList.add(new GoldManagerItemBean(3, true));
        mList.add(new GoldManagerItemBean(4, false));
        mList.add(new GoldManagerItemBean(5, false));
        mList.add(new GoldManagerItemBean(6, false));
        mList.add(new GoldManagerItemBean(7, false));
    }
}
