package com.nobody.spoon.ui._1_main.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.nobody.spoon.R;
import com.nobody.spoon.app.Constants;
import com.nobody.spoon.base.BaseAct;
import com.nobody.spoon.base.contract.GoldMainContract;
import com.nobody.spoon.module.bean.GoldManagerBean;
import com.nobody.spoon.module.bean.GoldManagerItemBean;
import com.nobody.spoon.presenter.GoldMainPresenter;
import com.nobody.spoon.ui._1_main.adapter.GoldPagerAdapter;
import com.nobody.spoon.ui._1_main.fragment.GoldPagerFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseAct<GoldMainPresenter> implements GoldMainContract.View {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.tab_gold_main)
    TabLayout mTabLayout;
    @BindView(R.id.iv_gold_menu)
    ImageView ivGoldMenu;
    @BindView(R.id.vp_gold_main)
    ViewPager mViewPager;

    public static String[] typeStr = {"Android", "iOS", "前端", "后端", "设计", "产品", "阅读", "工具资源"};
    public static String[] type = {"android", "ios", "frontend", "backend", "design", "product", "article", "freebie"};

    List<GoldPagerFragment> fragments = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void initInject() {
        getActComponent().injectMainAct(this);
    }

    @Override
    protected void initEventAndData() {
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
        mPresenter.initManagerList();
    }

    @OnClick(R.id.iv_gold_menu)
    public void onViewClicked() {
        mPresenter.setManagerList();
    }

    @Override
    public void updateTab(List<GoldManagerItemBean> mList) {
        fragments.clear();
        mTabLayout.removeAllTabs();
        for (GoldManagerItemBean item : mList) {
            if (item.getIsSelect()) {
                GoldPagerFragment fragment = new GoldPagerFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.IT_GOLD_TYPE, type[item.getIndex()]);
                bundle.putString(Constants.IT_GOLD_TYPE_STR, typeStr[item.getIndex()]);
                mTabLayout.addTab(mTabLayout.newTab().setText(typeStr[item.getIndex()]));
                fragment.setArguments(bundle);
                fragments.add(fragment);
            }
        }
        GoldPagerAdapter mAdapter = new GoldPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(mAdapter);
        for (GoldManagerItemBean item : mList) {
            if (item.getIsSelect()) {
                mTabLayout.getTabAt(currentIndex++).setText(typeStr[item.getIndex()]);
            }
        }
        currentIndex = 0;
    }

    @Override
    public void jumpToManager(GoldManagerBean mBean) {
        Intent intent = new Intent(this, GoldManagerActivity.class);
        intent.putExtra(Constants.IT_GOLD_MANAGER, mBean);
        mContext.startActivity(intent);
    }
}
