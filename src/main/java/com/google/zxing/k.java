package com.google.zxing;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BBQRScannerControl f14766a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<j, Object> f14767b = new EnumMap(j.class);

    /* renamed from: c  reason: collision with root package name */
    private Handler f14768c;

    /* renamed from: d  reason: collision with root package name */
    private final CountDownLatch f14769d = new CountDownLatch(1);

    k(BBQRScannerControl bBQRScannerControl, Collection<c> collection, Map<j, ?> map, String str, z zVar) {
        this.f14766a = bBQRScannerControl;
        if (map != null) {
            this.f14767b.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            collection = EnumSet.noneOf(c.class);
            if (bBQRScannerControl.getCodeType() == 0) {
                collection.addAll(h.f14759c);
            } else {
                collection.addAll(h.f14758b);
            }
        }
        this.f14767b.put(j.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.f14767b.put(j.CHARACTER_SET, str);
        }
        this.f14767b.put(j.NEED_RESULT_POINT_CALLBACK, zVar);
        Log.i("DecodeThread", "Hints: " + this.f14767b);
    }

    /* access modifiers changed from: package-private */
    public Handler a() {
        try {
            this.f14769d.await();
        } catch (InterruptedException unused) {
        }
        return this.f14768c;
    }

    public void run() {
        Looper.prepare();
        this.f14768c = new i(this.f14766a, this.f14767b);
        this.f14769d.countDown();
        Looper.loop();
    }
}
