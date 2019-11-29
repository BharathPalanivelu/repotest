package com.otaliastudios.cameraview;

import android.os.Handler;
import android.os.HandlerThread;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

class ap {

    /* renamed from: a  reason: collision with root package name */
    private static final g f15560a = g.a(ap.class.getSimpleName());

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap<String, WeakReference<ap>> f15561b = new ConcurrentHashMap<>(4);

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f15562c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f15563d = new Handler(this.f15562c.getLooper());

    public static ap a(String str) {
        if (f15561b.containsKey(str)) {
            ap apVar = (ap) f15561b.get(str).get();
            if (apVar != null) {
                HandlerThread handlerThread = apVar.f15562c;
                if (handlerThread.isAlive() && !handlerThread.isInterrupted()) {
                    f15560a.c("get:", "Reusing cached worker handler.", str);
                    return apVar;
                }
            }
            f15560a.c("get:", "Thread reference died, removing.", str);
            f15561b.remove(str);
        }
        f15560a.b("get:", "Creating new handler.", str);
        ap apVar2 = new ap(str);
        f15561b.put(str, new WeakReference(apVar2));
        return apVar2;
    }

    public static void a(Runnable runnable) {
        a("FallbackCameraThread").b(runnable);
    }

    private ap(String str) {
        this.f15562c = new HandlerThread(str);
        this.f15562c.setDaemon(true);
        this.f15562c.start();
    }

    public Handler a() {
        return this.f15563d;
    }

    public void b(Runnable runnable) {
        this.f15563d.post(runnable);
    }

    public Thread b() {
        return this.f15562c;
    }
}
