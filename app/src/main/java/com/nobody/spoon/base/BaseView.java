package com.nobody.spoon.base;

/**
 * Created by zeroones on 2018/3/20.
 */

public interface BaseView {

    void showError(String msg);

    void useNightMode(boolean isNight);

    //=======  State  =======
    void stateError();

    void stateEmpty();

    void stateLoading();

    void stateMain();

}
