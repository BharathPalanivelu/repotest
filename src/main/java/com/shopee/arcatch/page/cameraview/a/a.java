package com.shopee.arcatch.page.cameraview.a;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Tracker;
import com.shopee.arcatch.page.cameraview.common.b;

public abstract class a<T> extends Tracker<T> implements b {
    public void a() {
    }

    /* access modifiers changed from: protected */
    public abstract void a(Frame frame);

    /* access modifiers changed from: protected */
    public abstract void a(T t);

    /* access modifiers changed from: protected */
    public abstract void b();

    public synchronized void b(Frame frame) {
        if (frame != null) {
            a(frame);
        }
    }

    public void onUpdate(Detector.Detections<T> detections, T t) {
        if (t != null) {
            a(t);
        }
    }

    public void onMissing(Detector.Detections<T> detections) {
        b();
    }
}
