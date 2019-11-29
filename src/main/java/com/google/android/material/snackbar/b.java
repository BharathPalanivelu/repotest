package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;

class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f13462a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f13463b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Handler f13464c = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.a((C0220b) message.obj);
            return true;
        }
    });

    /* renamed from: d  reason: collision with root package name */
    private C0220b f13465d;

    /* renamed from: e  reason: collision with root package name */
    private C0220b f13466e;

    interface a {
        void a();

        void a(int i);
    }

    static b a() {
        if (f13462a == null) {
            f13462a = new b();
        }
        return f13462a;
    }

    private b() {
    }

    public void a(int i, a aVar) {
        synchronized (this.f13463b) {
            if (f(aVar)) {
                this.f13465d.f13469b = i;
                this.f13464c.removeCallbacksAndMessages(this.f13465d);
                b(this.f13465d);
                return;
            }
            if (g(aVar)) {
                this.f13466e.f13469b = i;
            } else {
                this.f13466e = new C0220b(i, aVar);
            }
            if (this.f13465d == null || !a(this.f13465d, 4)) {
                this.f13465d = null;
                b();
            }
        }
    }

    public void a(a aVar, int i) {
        synchronized (this.f13463b) {
            if (f(aVar)) {
                a(this.f13465d, i);
            } else if (g(aVar)) {
                a(this.f13466e, i);
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.f13463b) {
            if (f(aVar)) {
                this.f13465d = null;
                if (this.f13466e != null) {
                    b();
                }
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.f13463b) {
            if (f(aVar)) {
                b(this.f13465d);
            }
        }
    }

    public void c(a aVar) {
        synchronized (this.f13463b) {
            if (f(aVar) && !this.f13465d.f13470c) {
                this.f13465d.f13470c = true;
                this.f13464c.removeCallbacksAndMessages(this.f13465d);
            }
        }
    }

    public void d(a aVar) {
        synchronized (this.f13463b) {
            if (f(aVar) && this.f13465d.f13470c) {
                this.f13465d.f13470c = false;
                b(this.f13465d);
            }
        }
    }

    public boolean e(a aVar) {
        boolean z;
        synchronized (this.f13463b) {
            if (!f(aVar)) {
                if (!g(aVar)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* renamed from: com.google.android.material.snackbar.b$b  reason: collision with other inner class name */
    private static class C0220b {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<a> f13468a;

        /* renamed from: b  reason: collision with root package name */
        int f13469b;

        /* renamed from: c  reason: collision with root package name */
        boolean f13470c;

        C0220b(int i, a aVar) {
            this.f13468a = new WeakReference<>(aVar);
            this.f13469b = i;
        }

        /* access modifiers changed from: package-private */
        public boolean a(a aVar) {
            return aVar != null && this.f13468a.get() == aVar;
        }
    }

    private void b() {
        C0220b bVar = this.f13466e;
        if (bVar != null) {
            this.f13465d = bVar;
            this.f13466e = null;
            a aVar = (a) this.f13465d.f13468a.get();
            if (aVar != null) {
                aVar.a();
            } else {
                this.f13465d = null;
            }
        }
    }

    private boolean a(C0220b bVar, int i) {
        a aVar = (a) bVar.f13468a.get();
        if (aVar == null) {
            return false;
        }
        this.f13464c.removeCallbacksAndMessages(bVar);
        aVar.a(i);
        return true;
    }

    private boolean f(a aVar) {
        C0220b bVar = this.f13465d;
        return bVar != null && bVar.a(aVar);
    }

    private boolean g(a aVar) {
        C0220b bVar = this.f13466e;
        return bVar != null && bVar.a(aVar);
    }

    private void b(C0220b bVar) {
        if (bVar.f13469b != -2) {
            int i = 2750;
            if (bVar.f13469b > 0) {
                i = bVar.f13469b;
            } else if (bVar.f13469b == -1) {
                i = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            }
            this.f13464c.removeCallbacksAndMessages(bVar);
            Handler handler = this.f13464c;
            handler.sendMessageDelayed(Message.obtain(handler, 0, bVar), (long) i);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(C0220b bVar) {
        synchronized (this.f13463b) {
            if (this.f13465d == bVar || this.f13466e == bVar) {
                a(bVar, 2);
            }
        }
    }
}
