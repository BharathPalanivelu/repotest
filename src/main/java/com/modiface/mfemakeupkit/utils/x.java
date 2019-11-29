package com.modiface.mfemakeupkit.utils;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class x extends HandlerThread implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15405a = "MFEThread";

    /* renamed from: b  reason: collision with root package name */
    protected WeakReference<a> f15406b = new WeakReference<>((Object) null);

    /* renamed from: c  reason: collision with root package name */
    protected Handler f15407c = null;

    public interface a {
        boolean handleMessage(Message message);
    }

    public x(String str) {
        super(str);
        start();
        this.f15407c = new Handler(getLooper(), this);
    }

    public void a(a aVar) {
        this.f15406b = new WeakReference<>(aVar);
    }

    public boolean b(Runnable runnable) {
        return b(runnable, false);
    }

    public void finalize() throws Throwable {
        a();
        super.finalize();
    }

    public boolean handleMessage(Message message) {
        a aVar = (a) this.f15406b.get();
        if (aVar != null) {
            return aVar.handleMessage(message);
        }
        return false;
    }

    public void a() {
        b(new v(this));
        if (Build.VERSION.SDK_INT >= 18) {
            quitSafely();
        } else {
            quit();
        }
        this.f15407c = null;
    }

    public boolean b(Runnable runnable, boolean z) {
        if (runnable == null) {
            throw new IllegalArgumentException("cannot run null runnable in runSynchronously in MFEThread");
        } else if (this.f15407c == null) {
            return false;
        } else {
            Object obj = new Object();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            boolean a2 = a(new w(this, obj, runnable, atomicBoolean), z);
            if (!a2) {
                atomicBoolean.set(true);
            }
            synchronized (obj) {
                try {
                    if (!atomicBoolean.get()) {
                        obj.wait();
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    a2 = false;
                }
            }
            return a2;
        }
    }

    public boolean a(Runnable runnable) {
        return a(runnable, false);
    }

    public boolean a(Runnable runnable, boolean z) {
        if (runnable != null) {
            Handler handler = this.f15407c;
            if (handler == null) {
                return false;
            }
            return z ? handler.postAtFrontOfQueue(runnable) : handler.post(runnable);
        }
        throw new IllegalArgumentException("cannot run null runnable in runAsync in MFEThread");
    }

    public Handler b() {
        return this.f15407c;
    }
}
