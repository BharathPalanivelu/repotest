package androidx.databinding;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.view.Choreographer;
import android.view.View;
import androidx.databinding.a.a;
import androidx.databinding.c;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class ViewDataBinding extends a {

    /* renamed from: a  reason: collision with root package name */
    static int f1971a = Build.VERSION.SDK_INT;

    /* renamed from: b  reason: collision with root package name */
    private static final int f1972b = 8;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f1973c = (f1971a >= 16);

    /* renamed from: d  reason: collision with root package name */
    private static final a f1974d = new a() {
    };

    /* renamed from: e  reason: collision with root package name */
    private static final a f1975e = new a() {
    };

    /* renamed from: f  reason: collision with root package name */
    private static final a f1976f = new a() {
    };

    /* renamed from: g  reason: collision with root package name */
    private static final a f1977g = new a() {
    };
    private static final c.a<e, ViewDataBinding, Void> h = new c.a<e, ViewDataBinding, Void>() {
        public void a(e eVar, ViewDataBinding viewDataBinding, int i, Void voidR) {
            if (i != 1) {
                if (i == 2) {
                    eVar.b(viewDataBinding);
                } else if (i == 3) {
                    eVar.c(viewDataBinding);
                }
            } else if (!eVar.a(viewDataBinding)) {
                boolean unused = viewDataBinding.m = true;
            }
        }
    };
    private static final ReferenceQueue<ViewDataBinding> i = new ReferenceQueue<>();
    private static final View.OnAttachStateChangeListener j;
    /* access modifiers changed from: private */
    public final Runnable k;
    private boolean l;
    /* access modifiers changed from: private */
    public boolean m;
    private c<e, ViewDataBinding, Void> n;
    private boolean o;
    private Choreographer p;
    private final Choreographer.FrameCallback q;
    private Handler r;
    private ViewDataBinding s;
    private h t;

    private interface a {
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    public abstract boolean c();

    static {
        if (Build.VERSION.SDK_INT < 19) {
            j = null;
        } else {
            j = new View.OnAttachStateChangeListener() {
                public void onViewDetachedFromWindow(View view) {
                }

                @TargetApi(19)
                public void onViewAttachedToWindow(View view) {
                    ViewDataBinding.a(view).k.run();
                    view.removeOnAttachStateChangeListener(this);
                }
            };
        }
    }

    public void a() {
        ViewDataBinding viewDataBinding = this.s;
        if (viewDataBinding == null) {
            e();
        } else {
            viewDataBinding.a();
        }
    }

    private void e() {
        if (this.o) {
            d();
        } else if (c()) {
            this.o = true;
            this.m = false;
            c<e, ViewDataBinding, Void> cVar = this.n;
            if (cVar != null) {
                cVar.a(this, 1, null);
                if (this.m) {
                    this.n.a(this, 2, null);
                }
            }
            if (!this.m) {
                b();
                c<e, ViewDataBinding, Void> cVar2 = this.n;
                if (cVar2 != null) {
                    cVar2.a(this, 3, null);
                }
            }
            this.o = false;
        }
    }

    static ViewDataBinding a(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(a.C0042a.dataBinding);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        if (f1973c == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        r2.p.postFrameCallback(r2.q);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r2.r.post(r2.k);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r2 = this;
            androidx.databinding.ViewDataBinding r0 = r2.s
            if (r0 == 0) goto L_0x0008
            r0.d()
            goto L_0x003b
        L_0x0008:
            androidx.lifecycle.h r0 = r2.t
            if (r0 == 0) goto L_0x001d
            androidx.lifecycle.e r0 = r0.getLifecycle()
            androidx.lifecycle.e$b r0 = r0.a()
            androidx.lifecycle.e$b r1 = androidx.lifecycle.e.b.STARTED
            boolean r0 = r0.isAtLeast(r1)
            if (r0 != 0) goto L_0x001d
            return
        L_0x001d:
            monitor-enter(r2)
            boolean r0 = r2.l     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0024
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            return
        L_0x0024:
            r0 = 1
            r2.l = r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            boolean r0 = f1973c
            if (r0 == 0) goto L_0x0034
            android.view.Choreographer r0 = r2.p
            android.view.Choreographer$FrameCallback r1 = r2.q
            r0.postFrameCallback(r1)
            goto L_0x003b
        L_0x0034:
            android.os.Handler r0 = r2.r
            java.lang.Runnable r1 = r2.k
            r0.post(r1)
        L_0x003b:
            return
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.d():void");
    }

    static class OnStartListener implements g {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<ViewDataBinding> f1978a;

        @o(a = e.a.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) this.f1978a.get();
            if (viewDataBinding != null) {
                viewDataBinding.a();
            }
        }
    }
}
