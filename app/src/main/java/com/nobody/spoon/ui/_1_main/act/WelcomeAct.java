package com.nobody.spoon.ui._1_main.act;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nobody.spoon.R;
import com.nobody.spoon.base.BaseAct;
import com.nobody.spoon.base.contract.WelcomeContract;
import com.nobody.spoon.module.bean.WelcomeBean;
import com.nobody.spoon.presenter.WelcomePresenter;
import com.nobody.spoon.utils.ImageLoader;

import butterknife.BindView;

/**
 * Created by Robin on 2018/3/21.
 */

public class WelcomeAct extends BaseAct<WelcomePresenter> implements WelcomeContract.View {

    @BindView(R.id.iv_welcome_bg)
    ImageView ivWelcomeBg;
    @BindView(R.id.tv_welcome_author)
    TextView tvWelcomeAuthor;

    @Override
    public void showContent(WelcomeBean bean) {
        ImageLoader.load(this, bean.getImg(), ivWelcomeBg);
        ivWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
        tvWelcomeAuthor.setText(bean.getText());
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
        mPresenter.getWelcomeData();
    }

    @Override
    protected void onDestroy() {
        Glide.clear(ivWelcomeBg);
        super.onDestroy();
    }
}
