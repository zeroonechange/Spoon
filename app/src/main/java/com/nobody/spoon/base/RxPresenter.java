package com.nobody.spoon.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by zeroones on 2018/3/20.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T view;
    private CompositeDisposable compositeDisposable;

    @Override
    public void attachView(T v) {
        this.view = v;
    }

    @Override
    public void detachView() {
        this.view = null;
        unSubscribe();
    }

    protected void unSubscribe() {
        if (compositeDisposable != null) compositeDisposable.clear();
    }

    protected void addSubscribe(Disposable subscribe) {
        if (compositeDisposable == null) compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(subscribe);
    }
}
