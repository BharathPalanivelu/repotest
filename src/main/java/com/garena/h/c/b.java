package com.garena.h.c;

import android.os.HandlerThread;
import android.os.Looper;
import com.garena.h.a.d;
import com.garena.h.a.e;
import com.garena.h.f;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class b extends HandlerThread {

    /* renamed from: a  reason: collision with root package name */
    private com.garena.h.b.a f8022a;

    /* renamed from: b  reason: collision with root package name */
    private a f8023b;

    /* renamed from: c  reason: collision with root package name */
    private final f f8024c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final com.garena.h.b f8025d;

    /* renamed from: e  reason: collision with root package name */
    private c f8026e;

    /* renamed from: f  reason: collision with root package name */
    private final ExecutorService f8027f = Executors.newSingleThreadExecutor();

    public b(com.garena.h.b.a aVar, f fVar, com.garena.h.b bVar) {
        super("NETWORK_THREAD");
        this.f8022a = aVar;
        this.f8024c = fVar;
        this.f8025d = bVar;
    }

    /* access modifiers changed from: protected */
    public void onLooperPrepared() {
        super.onLooperPrepared();
        this.f8026e = new d(getLooper(), new C0133b());
    }

    public com.garena.h.a a() {
        Looper looper = getLooper();
        if (this.f8023b == null && looper != null) {
            this.f8023b = new a(looper, new a());
        }
        return this.f8023b;
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.f8022a.e()) {
            this.f8025d.b(this.f8022a.c());
            return;
        }
        try {
            this.f8022a.a();
            if (c()) {
                this.f8025d.b(this.f8022a.c());
            } else {
                this.f8022a.b();
            }
        } catch (e e2) {
            this.f8025d.a(this.f8022a.c(), e2.a());
        } catch (RejectedExecutionException unused) {
            this.f8025d.a(this.f8022a.c(), d.UNKNOWN);
        }
    }

    /* access modifiers changed from: private */
    public void a(com.garena.h.e eVar) {
        try {
            if (this.f8022a.e()) {
                this.f8022a.a(eVar.b());
            } else {
                this.f8025d.a(eVar);
            }
        } catch (com.garena.h.a.b unused) {
            this.f8025d.a(eVar);
        }
    }

    private boolean c() throws RejectedExecutionException {
        if (this.f8027f.isShutdown() || this.f8027f.isTerminated()) {
            return false;
        }
        this.f8027f.submit(new e(this.f8022a, this.f8024c, this.f8026e));
        return true;
    }

    /* access modifiers changed from: private */
    public void d() {
        this.f8022a.b();
        this.f8027f.shutdownNow();
        quit();
    }

    private class a implements com.garena.h.a {
        private a() {
        }

        public void a() {
            b.this.b();
        }

        public void a(com.garena.h.e eVar) {
            b.this.a(eVar);
        }

        public void b() {
            b.this.d();
        }
    }

    /* renamed from: com.garena.h.c.b$b  reason: collision with other inner class name */
    private class C0133b implements c {
        private C0133b() {
        }

        public void a(com.garena.h.e eVar) {
            b.this.f8025d.b(eVar);
        }

        public void a(String str) {
            b.this.f8025d.a(str);
        }
    }
}
