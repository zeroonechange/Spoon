package com.nobody.spoon.ui._1_main.act;

import android.content.Intent;

import com.nobody.spoon.R;
import com.nobody.spoon.base.BaseAct;
import com.nobody.spoon.base.contract.WelcomeContract;
import com.nobody.spoon.presenter.WelcomePresenter;
import com.nobody.spoon.ui._0_welcome.WelcomeBean;

/**
 * Created by Robin on 2018/3/21.
 */

public class WelcomeAct extends BaseAct<WelcomePresenter> implements WelcomeContract.View {

    @Override
    public void showContent(WelcomeBean bean) {

    }

    @Override
    public void jumpToMain() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    // 稍会儿测试 如果不inject会怎样
    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void onDestroy() {
//        Glide.clear(ivWelcomeBg);
        super.onDestroy();
    }
}
