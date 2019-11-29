package com.tencent.qalsdk.util;

import android.content.Context;
import android.util.Log;
import com.shopee.livequiz.data.bean.LiveParams;
import com.tencent.qalsdk.sdk.m;

public class ALog {
    private static m helper = new m();

    public static void init(Context context) {
        helper.a(context, LiveParams.SYNC_TYPE_APP);
    }

    public static String getFilePath() {
        return helper.b();
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
        m mVar = helper;
        mVar.a(str, "[E] " + str2, (Throwable) null);
    }

    public static void w(String str, String str2) {
        Log.w(str, str2);
        m mVar = helper;
        mVar.a(str, "[W] " + str2, (Throwable) null);
    }

    public static void i(String str, String str2) {
        Log.i(str, str2);
        m mVar = helper;
        mVar.a(str, "[I] " + str2, (Throwable) null);
    }

    public static void d(String str, String str2) {
        Log.d(str, str2);
    }

    public static String getLogFileName(long j) {
        m mVar = helper;
        return mVar.a(mVar.a(j));
    }
}
