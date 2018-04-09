package com.nobody.spoon.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by zeroones on 2018/3/21.
 */

public class Constants {
    public static final String SP_NO_IMAGE = "no_image";


    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";


    public static final String IT_GOLD_TYPE = "gold_type";

    public static final String IT_GOLD_TYPE_STR = "gold_type_str";

    public static final String IT_GOLD_MANAGER = "gold_manager";


    public static final int TYPE_GOLD = 108;


    public static final String IT_GANK_TYPE = "gank_type";

    public static final String IT_GANK_TYPE_CODE = "gank_type_code";

    public static final String IT_GANK_DETAIL_TITLE = "gank_detail_title";

    public static final String IT_GANK_DETAIL_URL = "gank_detail_url";

    public static final String IT_GANK_DETAIL_IMG_URL = "gank_detail_img_url";

    public static final String IT_GANK_DETAIL_ID = "gank_detail_id";

    public static final String IT_GANK_DETAIL_TYPE = "gank_detail_type";

    public static final String IT_GANK_GRIL_ID = "gank_girl_id";

    public static final String IT_GANK_GRIL_URL = "gank_girl_url";


    public static final String LEANCLOUD_ID = "mhke0kuv33myn4t4ghuid4oq2hjj12li374hvcif202y5bm6";

    public static final String LEANCLOUD_SIGN = "badc5461a25a46291054b902887a68eb,1480438132702";

    public static final String SP_AUTO_CACHE = "auto_cache";

}
