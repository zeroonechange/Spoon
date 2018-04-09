package com.nobody.spoon.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.nobody.spoon.app.App;
import com.nobody.spoon.di.component.DaggerFragmentComponent;
import com.nobody.spoon.di.component.FragmentComponent;
import com.nobody.spoon.di.model.FragmentModule;
import com.nobody.spoon.utils.SnackbarUtil;

import javax.inject.Inject;

/**
 * Created by Robin on 2018/3/30.
 */
public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView {

    @Inject
    protected T presenter;

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        presenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (presenter != null) presenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showError(String msg) {
        SnackbarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {

    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    protected abstract void initInject();

}
