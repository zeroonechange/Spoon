package com.nobody.spoon.module.db;


import com.nobody.spoon.module.bean.GoldManagerBean;
import com.nobody.spoon.module.bean.RealmLikeBean;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface DBHelper {

    /**
     * 更新 掘金首页管理列表
     *
     * @param bean
     */
    void updateGoldManagerList(GoldManagerBean bean);

    /**
     * 获取 掘金首页管理列表
     *
     * @return
     */
    GoldManagerBean getGoldManagerList();

    boolean queryLikeId(String id);

    void deleteLikeBean(String id);

    void insertLikeBean(RealmLikeBean bean);
}
