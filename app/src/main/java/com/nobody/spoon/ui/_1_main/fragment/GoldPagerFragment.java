package com.nobody.spoon.ui._1_main.fragment;

import com.nobody.spoon.R;
import com.nobody.spoon.base.RootFragment;
import com.nobody.spoon.base.contract.GoldContract;
import com.nobody.spoon.module.bean.GoldListBean;
import com.nobody.spoon.presenter.GoldPresenter;

import java.util.List;

/**
 * Created by Robin on 2018/3/30.
 */

public class GoldPagerFragment extends RootFragment<GoldPresenter> implements GoldContract.View {


    @Override
    public void stateEmpty() {

    }

    @Override
    public void showContent(List<GoldListBean> goldListBean) {

    }

    @Override
    public void showMoreContent(List<GoldListBean> goldMoreListBean, int start, int end) {

    }

    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold_page;
    }
}
