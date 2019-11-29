package com.tencent.liteav.basic.module;

import android.os.Environment;

public class TXCKeyPointReportProxy {

    /* renamed from: a  reason: collision with root package name */
    public static final String f31396a = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/txrtmp/ssoreport.txt");

    private static native void nativeSetQuality(String str, int i, int i2);

    private static native void nativeTagKeyPoint(String str, int i);

    private static native void nativeTagKeyPointEnd(int i, int i2);

    private static native void nativeTagKeyPointStart(int i);

    public static void a(int i) {
        nativeTagKeyPointStart(i);
    }

    public static void a(int i, int i2) {
        nativeTagKeyPointEnd(i, i2);
    }

    public static void a(String str, int i) {
        nativeTagKeyPoint(str, i);
    }

    public static void a(String str, int i, int i2) {
        nativeSetQuality(str, i, i2);
    }
}
