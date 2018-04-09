package com.nobody.spoon.base;

import android.view.ViewGroup;

import com.nobody.spoon.app.App;
import com.nobody.spoon.di.component.ActComponent;
import com.nobody.spoon.di.component.DaggerActComponent;
import com.nobody.spoon.di.model.ActModule;
import com.nobody.spoon.utils.SnackbarUtil;

import javax.inject.Inject;

/**
 * Created by zeroones on 2018/3/20.
 */
public abstract class BaseAct<T extends BasePresenter> extends SimpleAct implements BaseView {

    @Inject
    public T mPresenter;

    protected ActComponent getActComponent() {
        return DaggerActComponent.builder()
                .appComponent(App.getAppComponent())
                .actModule(getActModule())
                .build();
    }

    private ActModule getActModule() {
        return new ActModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null) mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }

    @Override
    public void showError(String msg) {
        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {
        // TODO: 2018/3/21
    }

    protected abstract void initInject();

    @Override
    public void stateError() {

    }


    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

}
