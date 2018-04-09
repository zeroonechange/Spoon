package com.nobody.spoon.presenter;

import com.nobody.spoon.base.RxPresenter;
import com.nobody.spoon.base.contract.GoldContract;
import com.nobody.spoon.base.rx.CommonSubscriber;
import com.nobody.spoon.module.DataManager;
import com.nobody.spoon.module.bean.GoldListBean;
import com.nobody.spoon.module.http.response.GoldHttpResponse;
import com.nobody.spoon.utils.RxUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Robin on 2018/3/30.
 */

public class GoldPresenter extends RxPresenter<GoldContract.View> implements GoldContract.Presenter {
    private static final int NUM_EACH_PAGE = 20;
    private static final int NUM_HOT_LIMIT = 3;
    private DataManager mDataManager;
    private List<GoldListBean> totalList = new ArrayList<>();

    private boolean isHotList = true;
    private int currentPage = 0;
    private String mType;

    @Inject
    public GoldPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getGoldData(String type) {
        mType = type;
        currentPage = 0;
        totalList.clear();
        Flowable<List<GoldListBean>> list = mDataManager.fetchGoldList(type, NUM_EACH_PAGE, currentPage++)
                .compose(RxUtil.<GoldHttpResponse<List<GoldListBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GoldListBean>>handleGoldResult());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -3);

        Flowable<List<GoldListBean>> hotList = mDataManager.fetchGoldHotList(type,
                new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()), NUM_HOT_LIMIT)
                .compose(RxUtil.<GoldHttpResponse<List<GoldListBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GoldListBean>>handleGoldResult());

        addSubscribe(Flowable.concat(hotList, list)
                .subscribeWith(new CommonSubscriber<List<GoldListBean>>(view) {
                    @Override
                    public void onNext(List<GoldListBean> goldListBean) {
                        if (isHotList) {
                            isHotList = false;
                            totalList.addAll(goldListBean);
                        } else {
                            isHotList = true;
                            totalList.addAll(goldListBean);
                            view.showContent(totalList);
                        }
                    }
                })
        );
    }

    @Override
    public void getMoreGoldData() {
        addSubscribe(mDataManager.fetchGoldList(mType, NUM_EACH_PAGE, currentPage++)
                .compose(RxUtil.<GoldHttpResponse<List<GoldListBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GoldListBean>>handleGoldResult())
                .subscribeWith(new CommonSubscriber<List<GoldListBean>>(view, false) {
                    @Override
                    public void onNext(List<GoldListBean> goldListBeen) {
                        totalList.addAll(goldListBeen);
                        view.showMoreContent(totalList, totalList.size(), totalList.size() + NUM_EACH_PAGE);
                    }
                })
        );
    }
}
