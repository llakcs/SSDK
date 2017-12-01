package com.dchip.door.smartdoorsdk.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by llakcs on 2017/11/29.
 */

public class Constant {
    //sdcardpath
    public static final String SDCARD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String BASE_PATh = SDCARD_PATH + File.separator + "smdsdk" + File.separator;
    //opencv
    public static final String VISTPATH =BASE_PATh+ File.separator+"vistdata";
    //crash
    public static final String CRASH_LOG_PATH = BASE_PATh + "crashLog" + File.separator;
    public static final String CRASH_LOG_UPLOAD_FAIL_PATH = BASE_PATh + "crashLog" + File.separator + "uploadFail" + File.separator;
}
