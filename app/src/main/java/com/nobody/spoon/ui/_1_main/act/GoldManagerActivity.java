package com.nobody.spoon.ui._1_main.act;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.nobody.spoon.R;
import com.nobody.spoon.app.Constants;
import com.nobody.spoon.base.SimpleAct;
import com.nobody.spoon.base.rx.RxBus;
import com.nobody.spoon.module.bean.GoldManagerBean;
import com.nobody.spoon.module.bean.GoldManagerItemBean;
import com.nobody.spoon.ui._1_main.adapter.GoldManagerAdapter;
import com.nobody.spoon.widget.DefaultItemTouchHelpCallback;

import java.util.Collections;

import butterknife.BindView;
import io.realm.RealmList;

/**
 * Created by Robin on 2018/3/30.
 */

public class GoldManagerActivity extends SimpleAct {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.rv_gold_manager_list)
    RecyclerView rvGoldManagerList;

    @Override
    protected int getLayout() {
        return R.layout.activity_gold_manager;
    }



    RealmList<GoldManagerItemBean> mList;
    GoldManagerAdapter mAdapter;
    DefaultItemTouchHelpCallback mCallback;

    @Override
    protected void initEventAndData() {
        setToolBar(toolBar, "首页特别展示");
        mList = ((GoldManagerBean) getIntent().getParcelableExtra(Constants.IT_GOLD_MANAGER)).getManagerList();
        mAdapter = new GoldManagerAdapter(mContext, mList);
        rvGoldManagerList.setLayoutManager(new LinearLayoutManager(mContext));
        rvGoldManagerList.setAdapter(mAdapter);
        mCallback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {
            }

            @Override
            public boolean onMove(int srcPosition, int targetPosition) {
                if (mList != null) {
                    Collections.swap(mList, srcPosition, targetPosition);
                    mAdapter.notifyItemMoved(srcPosition, targetPosition);
                    return true;
                }
                return false;
            }
        });
        mCallback.setDragEnable(true);
        mCallback.setSwipeEnable(false);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(rvGoldManagerList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getDefault().post(new GoldManagerBean(mList));
    }
}
