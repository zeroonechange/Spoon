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
}
