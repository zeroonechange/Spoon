package com.nobody.spoon.base;

/**
 * Created by Robin on 2018/3/20.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T v);

    void detachView();
}
