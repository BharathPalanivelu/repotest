package com.tencent.liteav.beauty;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f31434a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Context f31435b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f31436c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f31437d = false;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f31438e = false;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f31439f = false;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f31440g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean n = false;
    private static boolean o = false;
    private String p = "ReportDuaManage";

    public static a a() {
        if (f31434a == null) {
            f31434a = new a();
        }
        return f31434a;
    }

    public void a(Context context) {
        f();
        f31435b = context.getApplicationContext();
        if (!f31436c) {
            TXCLog.i(this.p, "reportSDKInit");
            TXCDRApi.txReportDAU(f31435b, 1201, 0, "reportSDKInit!");
        }
        f31436c = true;
    }

    public void b() {
        if (!f31437d) {
            TXCLog.i(this.p, "reportBeautyDua");
            TXCDRApi.txReportDAU(f31435b, 1202, 0, "reportBeautyDua");
        }
        f31437d = true;
    }

    public void c() {
        if (!f31438e) {
            TXCLog.i(this.p, "reportWhiteDua");
            TXCDRApi.txReportDAU(f31435b, 1203, 0, "reportWhiteDua");
        }
        f31438e = true;
    }

    public void d() {
        if (!j) {
            TXCLog.i(this.p, "reportFilterImageDua");
            TXCDRApi.txReportDAU(f31435b, 1208, 0, "reportFilterImageDua");
        }
        j = true;
    }

    public void e() {
        if (!n) {
            TXCLog.i(this.p, "reportWarterMarkDua");
            TXCDRApi.txReportDAU(f31435b, 1212, 0, "reportWarterMarkDua");
        }
        n = true;
    }

    private void f() {
        TXCLog.i(this.p, "resetReportState");
        f31436c = false;
        f31437d = false;
        f31438e = false;
        f31439f = false;
        f31440g = false;
        h = false;
        i = false;
        j = false;
        k = false;
        l = false;
        m = false;
        n = false;
        o = false;
    }
}
