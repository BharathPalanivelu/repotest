package com.tencent.liteav.basic.module;

public class TXCEventRecorderProxy {

    /* renamed from: a  reason: collision with root package name */
    private long f31395a;

    private static native void nativeAddEventListener(long j, String str, String str2);

    private static native void nativeAddEventMsg(String str, int i, int i2, int i3, String str2, int i4);

    private static native long nativeInit();

    private static native void nativeRelease(long j);

    public TXCEventRecorderProxy() {
        this.f31395a = 0;
        this.f31395a = nativeInit();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        nativeRelease(this.f31395a);
        this.f31395a = 0;
        super.finalize();
    }

    public void a(String str, String str2) {
        nativeAddEventListener(this.f31395a, str, str2);
    }

    public static void a(String str, int i, int i2, int i3, String str2, int i4) {
        if (str != null && str2 != null) {
            nativeAddEventMsg(str, i, i2, i3, str2, i4);
        }
    }
}
