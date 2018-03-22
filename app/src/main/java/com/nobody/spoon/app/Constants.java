package com.nobody.spoon.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by Robin on 2018/3/21.
 */

public class Constants {
    public static final String SP_NO_IMAGE = "no_image";


    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";

}
