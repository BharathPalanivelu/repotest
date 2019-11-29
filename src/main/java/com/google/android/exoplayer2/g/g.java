package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.s.a;
import java.lang.Exception;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {

    /* renamed from: a  reason: collision with root package name */
    private final Thread f9886a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f9887b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final LinkedList<I> f9888c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    private final LinkedList<O> f9889d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    private final I[] f9890e;

    /* renamed from: f  reason: collision with root package name */
    private final O[] f9891f;

    /* renamed from: g  reason: collision with root package name */
    private int f9892g;
    private int h;
    private I i;
    private E j;
    private boolean k;
    private boolean l;
    private int m;

    /* access modifiers changed from: protected */
    public abstract E a(I i2, O o, boolean z);

    /* access modifiers changed from: protected */
    public abstract I g();

    /* access modifiers changed from: protected */
    public abstract O h();

    protected g(I[] iArr, O[] oArr) {
        this.f9890e = iArr;
        this.f9892g = iArr.length;
        for (int i2 = 0; i2 < this.f9892g; i2++) {
            this.f9890e[i2] = g();
        }
        this.f9891f = oArr;
        this.h = oArr.length;
        for (int i3 = 0; i3 < this.h; i3++) {
            this.f9891f[i3] = h();
        }
        this.f9886a = new Thread() {
            public void run() {
                g.this.k();
            }
        };
        this.f9886a.start();
    }

    /* access modifiers changed from: protected */
    public final void a(int i2) {
        a.b(this.f9892g == this.f9890e.length);
        for (I e2 : this.f9890e) {
            e2.e(i2);
        }
    }

    /* renamed from: e */
    public final I a() throws Exception {
        I i2;
        I i3;
        synchronized (this.f9887b) {
            i();
            a.b(this.i == null);
            if (this.f9892g == 0) {
                i2 = null;
            } else {
                I[] iArr = this.f9890e;
                int i4 = this.f9892g - 1;
                this.f9892g = i4;
                i2 = iArr[i4];
            }
            this.i = i2;
            i3 = this.i;
        }
        return i3;
    }

    public final void a(I i2) throws Exception {
        synchronized (this.f9887b) {
            i();
            a.a(i2 == this.i);
            this.f9888c.addLast(i2);
            j();
            this.i = null;
        }
    }

    /* renamed from: f */
    public final O b() throws Exception {
        synchronized (this.f9887b) {
            i();
            if (this.f9889d.isEmpty()) {
                return null;
            }
            O o = (f) this.f9889d.removeFirst();
            return o;
        }
    }

    /* access modifiers changed from: protected */
    public void a(O o) {
        synchronized (this.f9887b) {
            b(o);
            j();
        }
    }

    public final void c() {
        synchronized (this.f9887b) {
            this.k = true;
            this.m = 0;
            if (this.i != null) {
                b(this.i);
                this.i = null;
            }
            while (!this.f9888c.isEmpty()) {
                b((e) this.f9888c.removeFirst());
            }
            while (!this.f9889d.isEmpty()) {
                b((f) this.f9889d.removeFirst());
            }
        }
    }

    public void d() {
        synchronized (this.f9887b) {
            this.l = true;
            this.f9887b.notify();
        }
        try {
            this.f9886a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    private void i() throws Exception {
        E e2 = this.j;
        if (e2 != null) {
            throw e2;
        }
    }

    private void j() {
        if (m()) {
            this.f9887b.notify();
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (l());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r1.c() == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r3.b(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1.l_() == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r3.b(com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity.NULL_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        r6.j = a(r1, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (r6.j == null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        r0 = r6.f9887b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
        r4 = r6.f9887b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005e, code lost:
        if (r6.k == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0060, code lost:
        b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0068, code lost:
        if (r3.l_() == false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006a, code lost:
        r6.m++;
        b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0073, code lost:
        r3.f9885b = r6.m;
        r6.m = 0;
        r6.f9889d.addLast(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007e, code lost:
        b(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0081, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0082, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean l() throws java.lang.InterruptedException {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f9887b
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r6.l     // Catch:{ all -> 0x0086 }
            if (r1 != 0) goto L_0x0013
            boolean r1 = r6.m()     // Catch:{ all -> 0x0086 }
            if (r1 != 0) goto L_0x0013
            java.lang.Object r1 = r6.f9887b     // Catch:{ all -> 0x0086 }
            r1.wait()     // Catch:{ all -> 0x0086 }
            goto L_0x0003
        L_0x0013:
            boolean r1 = r6.l     // Catch:{ all -> 0x0086 }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            return r2
        L_0x001a:
            java.util.LinkedList<I> r1 = r6.f9888c     // Catch:{ all -> 0x0086 }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0086 }
            com.google.android.exoplayer2.g.e r1 = (com.google.android.exoplayer2.g.e) r1     // Catch:{ all -> 0x0086 }
            O[] r3 = r6.f9891f     // Catch:{ all -> 0x0086 }
            int r4 = r6.h     // Catch:{ all -> 0x0086 }
            r5 = 1
            int r4 = r4 - r5
            r6.h = r4     // Catch:{ all -> 0x0086 }
            r3 = r3[r4]     // Catch:{ all -> 0x0086 }
            boolean r4 = r6.k     // Catch:{ all -> 0x0086 }
            r6.k = r2     // Catch:{ all -> 0x0086 }
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            boolean r0 = r1.c()
            if (r0 == 0) goto L_0x003c
            r0 = 4
            r3.b(r0)
            goto L_0x0059
        L_0x003c:
            boolean r0 = r1.l_()
            if (r0 == 0) goto L_0x0047
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.b(r0)
        L_0x0047:
            java.lang.Exception r0 = r6.a(r1, r3, r4)
            r6.j = r0
            E r0 = r6.j
            if (r0 == 0) goto L_0x0059
            java.lang.Object r0 = r6.f9887b
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            return r2
        L_0x0056:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            throw r1
        L_0x0059:
            java.lang.Object r4 = r6.f9887b
            monitor-enter(r4)
            boolean r0 = r6.k     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x0064
            r6.b(r3)     // Catch:{ all -> 0x0083 }
            goto L_0x007e
        L_0x0064:
            boolean r0 = r3.l_()     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x0073
            int r0 = r6.m     // Catch:{ all -> 0x0083 }
            int r0 = r0 + r5
            r6.m = r0     // Catch:{ all -> 0x0083 }
            r6.b(r3)     // Catch:{ all -> 0x0083 }
            goto L_0x007e
        L_0x0073:
            int r0 = r6.m     // Catch:{ all -> 0x0083 }
            r3.f9885b = r0     // Catch:{ all -> 0x0083 }
            r6.m = r2     // Catch:{ all -> 0x0083 }
            java.util.LinkedList<O> r0 = r6.f9889d     // Catch:{ all -> 0x0083 }
            r0.addLast(r3)     // Catch:{ all -> 0x0083 }
        L_0x007e:
            r6.b(r1)     // Catch:{ all -> 0x0083 }
            monitor-exit(r4)     // Catch:{ all -> 0x0083 }
            return r5
        L_0x0083:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0083 }
            throw r0
        L_0x0086:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            goto L_0x008a
        L_0x0089:
            throw r1
        L_0x008a:
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.g.l():boolean");
    }

    private boolean m() {
        return !this.f9888c.isEmpty() && this.h > 0;
    }

    private void b(I i2) {
        i2.a();
        I[] iArr = this.f9890e;
        int i3 = this.f9892g;
        this.f9892g = i3 + 1;
        iArr[i3] = i2;
    }

    private void b(O o) {
        o.a();
        O[] oArr = this.f9891f;
        int i2 = this.h;
        this.h = i2 + 1;
        oArr[i2] = o;
    }
}
