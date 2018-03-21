package com.nobody.spoon.ui._1_main.act;

import com.nobody.spoon.R;
import com.nobody.spoon.base.BaseAct;
import com.nobody.spoon.base.contract.MainContract;
import com.nobody.spoon.presenter.MainPresenter;

public class MainActivity extends BaseAct<MainPresenter> implements MainContract.View {

    @Override
    protected void initInject() {
        getActComponent().injectMainAct(this);  // why ??
    }

    @Override
    public void showUpdateDialog(String content) {

    }

    @Override
    public void startDownloadService() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {

    }
}
