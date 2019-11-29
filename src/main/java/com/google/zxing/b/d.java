package com.google.zxing.b;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

final class d implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14473a = "d";

    /* renamed from: b  reason: collision with root package name */
    private final b f14474b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f14475c;

    /* renamed from: d  reason: collision with root package name */
    private int f14476d;

    d(b bVar) {
        this.f14474b = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a(Handler handler, int i) {
        this.f14475c = handler;
        this.f14476d = i;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a2 = this.f14474b.a();
        Handler handler = this.f14475c;
        if (a2 == null || handler == null) {
            Log.d(f14473a, "Got preview callback, but no handler or resolution available");
            return;
        }
        handler.obtainMessage(this.f14476d, a2.x, a2.y, bArr).sendToTarget();
        this.f14475c = null;
    }
}
