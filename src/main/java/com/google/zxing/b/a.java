package com.google.zxing.b;

import android.content.Context;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

final class a implements Camera.AutoFocusCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14449a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static final Collection<String> f14450b;

    /* renamed from: c  reason: collision with root package name */
    private static final Collection<String> f14451c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14452d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14453e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f14454f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f14455g;
    private final Camera h;
    private AsyncTask<?, ?, ?> i;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f14451c = new ArrayList(2);
            f14451c.add("continuous-video");
            f14451c.add("continuous-picture");
            f14450b = new ArrayList(4);
            f14450b.add("auto");
            f14450b.add("macro");
            f14450b.add("continuous-video");
            f14450b.add("continuous-picture");
            return;
        }
        f14451c = new ArrayList(1);
        f14451c.add("continuous-video");
        f14450b = new ArrayList(3);
        f14450b.add("auto");
        f14450b.add("macro");
        f14450b.add("continuous-video");
    }

    a(Context context, Camera camera) {
        this.h = camera;
        String focusMode = camera.getParameters().getFocusMode();
        this.f14454f = f14450b.contains(focusMode);
        this.f14455g = f14451c.contains(focusMode);
        String str = f14449a;
        Log.i(str, "Current focus mode '" + focusMode + "'; use auto focus? " + this.f14454f);
        a();
    }

    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.f14453e = false;
        c();
    }

    private synchronized void c() {
        if (!this.f14452d && this.i == null) {
            C0239a aVar = new C0239a();
            try {
                if (Build.VERSION.SDK_INT >= 11) {
                    aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                } else {
                    aVar.execute(new Object[0]);
                }
                this.i = aVar;
            } catch (RejectedExecutionException e2) {
                Log.w(f14449a, "Could not request auto focus", e2);
            }
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        if (this.f14454f && !this.f14455g) {
            this.i = null;
            if (!this.f14452d && !this.f14453e) {
                try {
                    this.h.autoFocus(this);
                    this.f14453e = true;
                } catch (RuntimeException e2) {
                    Log.w(f14449a, "Unexpected exception while focusing", e2);
                    c();
                }
            }
        }
        return;
    }

    private synchronized void d() {
        if (this.i != null) {
            if (this.i.getStatus() != AsyncTask.Status.FINISHED) {
                this.i.cancel(true);
            }
            this.i = null;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        this.f14452d = true;
        if (this.f14454f) {
            d();
            try {
                this.h.cancelAutoFocus();
            } catch (RuntimeException e2) {
                Log.w(f14449a, "Unexpected exception while cancelling focusing", e2);
            }
        }
        return;
    }

    /* renamed from: com.google.zxing.b.a$a  reason: collision with other inner class name */
    private final class C0239a extends AsyncTask<Object, Object, Object> {
        private C0239a() {
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException unused) {
            }
            a.this.a();
            return null;
        }
    }
}
