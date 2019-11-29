package com.beetalklib.network.e;

import android.os.HandlerThread;
import android.os.Looper;
import com.beetalklib.network.d.a;
import com.beetalklib.network.d.c;
import com.beetalklib.network.d.d;
import com.beetalklib.network.d.e;
import com.beetalklib.network.d.f;
import com.beetalklib.network.d.g;
import com.beetalklib.network.d.h;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class b extends HandlerThread implements a {

    /* renamed from: a  reason: collision with root package name */
    private h f5534a;

    /* renamed from: b  reason: collision with root package name */
    private a f5535b;

    /* renamed from: c  reason: collision with root package name */
    private final c f5536c;

    /* renamed from: d  reason: collision with root package name */
    private d f5537d;

    /* renamed from: e  reason: collision with root package name */
    private final ExecutorService f5538e = Executors.newSingleThreadExecutor();

    public b(h hVar, c cVar) {
        super("NETWORK_THREAD");
        this.f5534a = hVar;
        this.f5536c = cVar;
    }

    /* access modifiers changed from: protected */
    public void onLooperPrepared() {
        super.onLooperPrepared();
        this.f5537d = new d(getLooper(), this.f5536c);
    }

    public void a() {
        if (this.f5534a.d()) {
            this.f5537d.b(this.f5534a.a());
            return;
        }
        try {
            this.f5534a.b();
            if (e()) {
                this.f5537d.b(this.f5534a.a());
            } else {
                b();
            }
        } catch (com.beetalklib.network.b.d e2) {
            com.beetalklib.network.c.a.a(e2);
            this.f5537d.a(this.f5534a.a(), e2.a());
        } catch (RejectedExecutionException e3) {
            com.beetalklib.network.c.a.a(e3);
            this.f5537d.a(this.f5534a.a(), 3);
        }
    }

    public void a(f fVar) {
        try {
            if (this.f5534a.d()) {
                this.f5534a.a(fVar.c());
            } else {
                this.f5537d.a(fVar);
            }
        } catch (com.beetalklib.network.b.b e2) {
            com.beetalklib.network.c.a.a(e2);
            this.f5537d.a(fVar);
        }
    }

    private boolean e() throws RejectedExecutionException {
        if (this.f5538e.isShutdown() || this.f5538e.isTerminated()) {
            com.beetalklib.network.c.a.a("unable to initPacketReceiver ", new Object[0]);
            return false;
        }
        this.f5538e.submit(new e(this.f5534a, new g(this.f5534a.c()), this.f5536c));
        return true;
    }

    public com.beetalklib.network.d.b c() {
        Looper looper = getLooper();
        if (this.f5535b == null && looper != null) {
            this.f5535b = new a(looper, this);
        }
        return this.f5535b;
    }

    public void b() {
        this.f5534a.e();
    }

    public void d() {
        this.f5538e.shutdownNow();
        quit();
    }
}
