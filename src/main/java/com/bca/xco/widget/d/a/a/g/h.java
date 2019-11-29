package com.bca.xco.widget.d.a.a.g;

import com.bca.xco.widget.d.a.a.g.a;
import com.bca.xco.widget.d.b.g;
import com.facebook.soloader.MinElf;
import com.tencent.imsdk.TIMGroupManager;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class h implements Closeable {
    static final /* synthetic */ boolean i = (!h.class.desiredAssertionStatus());
    /* access modifiers changed from: private */
    public static final ExecutorService j = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bca.xco.widget.d.a.a.c.a("OkHttp FramedConnection", true));

    /* renamed from: a  reason: collision with root package name */
    final boolean f4945a;

    /* renamed from: b  reason: collision with root package name */
    long f4946b;

    /* renamed from: c  reason: collision with root package name */
    long f4947c;

    /* renamed from: d  reason: collision with root package name */
    m f4948d;

    /* renamed from: e  reason: collision with root package name */
    final m f4949e;

    /* renamed from: f  reason: collision with root package name */
    final Socket f4950f;

    /* renamed from: g  reason: collision with root package name */
    final j f4951g;
    final c h;
    /* access modifiers changed from: private */
    public final b k;
    /* access modifiers changed from: private */
    public final Map<Integer, i> l;
    /* access modifiers changed from: private */
    public final String m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public boolean p;
    private final ExecutorService q;
    private Map<Integer, l> r;
    /* access modifiers changed from: private */
    public final b s;
    private int t;
    /* access modifiers changed from: private */
    public boolean u;
    /* access modifiers changed from: private */
    public final Set<Integer> v;

    public static abstract class b {
        public static final b j = new b() {
            public void a(i iVar) {
                iVar.a(c.REFUSED_STREAM);
            }
        };

        public void a(h hVar) {
        }

        public abstract void a(i iVar);
    }

    /* access modifiers changed from: private */
    public boolean d(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    private h(a aVar) {
        this.l = new HashMap();
        this.f4946b = 0;
        this.f4948d = new m();
        this.f4949e = new m();
        this.u = false;
        this.v = new LinkedHashSet();
        this.s = aVar.f4983f;
        this.f4945a = aVar.f4984g;
        this.k = aVar.f4982e;
        int i2 = 2;
        this.o = aVar.f4984g ? 1 : 2;
        if (aVar.f4984g) {
            this.o += 2;
        }
        this.t = aVar.f4984g ? 1 : i2;
        if (aVar.f4984g) {
            this.f4948d.a(7, 16777216);
        }
        this.m = aVar.f4979b;
        this.q = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bca.xco.widget.d.a.a.c.a(com.bca.xco.widget.d.a.a.c.a("OkHttp %s Push Observer", this.m), true));
        this.f4949e.a(7, MinElf.PN_XNUM);
        this.f4949e.a(5, TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
        this.f4947c = (long) this.f4949e.d();
        this.f4950f = aVar.f4978a;
        this.f4951g = new j(aVar.f4981d, this.f4945a);
        this.h = new c(new a(aVar.f4980c, this.f4945a));
    }

    /* access modifiers changed from: package-private */
    public synchronized i a(int i2) {
        return this.l.get(Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public synchronized i b(int i2) {
        i remove;
        remove = this.l.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    public synchronized int a() {
        return this.f4949e.c(Integer.MAX_VALUE);
    }

    public i a(List<d> list, boolean z) {
        return a(0, list, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bca.xco.widget.d.a.a.g.i a(int r11, java.util.List<com.bca.xco.widget.d.a.a.g.d> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            com.bca.xco.widget.d.a.a.g.j r7 = r10.f4951g
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x006e }
            boolean r0 = r10.p     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0063
            int r8 = r10.o     // Catch:{ all -> 0x006b }
            int r0 = r10.o     // Catch:{ all -> 0x006b }
            int r0 = r0 + 2
            r10.o = r0     // Catch:{ all -> 0x006b }
            com.bca.xco.widget.d.a.a.g.i r9 = new com.bca.xco.widget.d.a.a.g.i     // Catch:{ all -> 0x006b }
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x006b }
            if (r13 == 0) goto L_0x0030
            long r0 = r10.f4947c     // Catch:{ all -> 0x006b }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0030
            long r0 = r9.f4994b     // Catch:{ all -> 0x006b }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r13 = 0
            goto L_0x0031
        L_0x0030:
            r13 = 1
        L_0x0031:
            boolean r0 = r9.b()     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0040
            java.util.Map<java.lang.Integer, com.bca.xco.widget.d.a.a.g.i> r0 = r10.l     // Catch:{ all -> 0x006b }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x006b }
            r0.put(r1, r9)     // Catch:{ all -> 0x006b }
        L_0x0040:
            monitor-exit(r10)     // Catch:{ all -> 0x006b }
            if (r11 != 0) goto L_0x0049
            com.bca.xco.widget.d.a.a.g.j r0 = r10.f4951g     // Catch:{ all -> 0x006e }
            r0.a((boolean) r6, (int) r8, (int) r11, (java.util.List<com.bca.xco.widget.d.a.a.g.d>) r12)     // Catch:{ all -> 0x006e }
            goto L_0x0052
        L_0x0049:
            boolean r0 = r10.f4945a     // Catch:{ all -> 0x006e }
            if (r0 != 0) goto L_0x005b
            com.bca.xco.widget.d.a.a.g.j r0 = r10.f4951g     // Catch:{ all -> 0x006e }
            r0.a((int) r11, (int) r8, (java.util.List<com.bca.xco.widget.d.a.a.g.d>) r12)     // Catch:{ all -> 0x006e }
        L_0x0052:
            monitor-exit(r7)     // Catch:{ all -> 0x006e }
            if (r13 == 0) goto L_0x005a
            com.bca.xco.widget.d.a.a.g.j r11 = r10.f4951g
            r11.b()
        L_0x005a:
            return r9
        L_0x005b:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x006e }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x006e }
            throw r11     // Catch:{ all -> 0x006e }
        L_0x0063:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x006b }
            java.lang.String r12 = "shutdown"
            r11.<init>(r12)     // Catch:{ all -> 0x006b }
            throw r11     // Catch:{ all -> 0x006b }
        L_0x006b:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x006b }
            throw r11     // Catch:{ all -> 0x006e }
        L_0x006e:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x006e }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.g.h.a(int, java.util.List, boolean):com.bca.xco.widget.d.a.a.g.i");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.f4947c), r8.f4951g.c());
        r6 = (long) r3;
        r8.f4947c -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r9, boolean r10, com.bca.xco.widget.d.b.g r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            com.bca.xco.widget.d.a.a.g.j r12 = r8.f4951g
            r12.a((boolean) r10, (int) r9, (com.bca.xco.widget.d.b.g) r11, (int) r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0062
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f4947c     // Catch:{ InterruptedException -> 0x005a }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, com.bca.xco.widget.d.a.a.g.i> r3 = r8.l     // Catch:{ InterruptedException -> 0x005a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005a }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x005a }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x005a }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005a }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x005a }
            throw r9     // Catch:{ InterruptedException -> 0x005a }
        L_0x0030:
            long r3 = r8.f4947c     // Catch:{ all -> 0x0058 }
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0058 }
            int r4 = (int) r3     // Catch:{ all -> 0x0058 }
            com.bca.xco.widget.d.a.a.g.j r3 = r8.f4951g     // Catch:{ all -> 0x0058 }
            int r3 = r3.c()     // Catch:{ all -> 0x0058 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0058 }
            long r4 = r8.f4947c     // Catch:{ all -> 0x0058 }
            long r6 = (long) r3     // Catch:{ all -> 0x0058 }
            long r4 = r4 - r6
            r8.f4947c = r4     // Catch:{ all -> 0x0058 }
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            long r12 = r12 - r6
            com.bca.xco.widget.d.a.a.g.j r4 = r8.f4951g
            if (r10 == 0) goto L_0x0053
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            r4.a((boolean) r5, (int) r9, (com.bca.xco.widget.d.b.g) r11, (int) r3)
            goto L_0x000d
        L_0x0058:
            r9 = move-exception
            goto L_0x0060
        L_0x005a:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0058 }
            r9.<init>()     // Catch:{ all -> 0x0058 }
            throw r9     // Catch:{ all -> 0x0058 }
        L_0x0060:
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            throw r9
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.g.h.a(int, boolean, com.bca.xco.widget.d.b.g, long):void");
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.f4947c += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, c cVar) {
        final int i3 = i2;
        final c cVar2 = cVar;
        j.submit(new com.bca.xco.widget.d.a.a.b("OkHttp %s stream %d", new Object[]{this.m, Integer.valueOf(i2)}) {
            public void a() {
                try {
                    h.this.b(i3, cVar2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, c cVar) {
        this.f4951g.a(i2, cVar);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2) {
        final int i3 = i2;
        final long j3 = j2;
        j.execute(new com.bca.xco.widget.d.a.a.b("OkHttp Window Update %s stream %d", new Object[]{this.m, Integer.valueOf(i2)}) {
            public void a() {
                try {
                    h.this.f4951g.a(i3, j3);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(boolean z, int i2, int i3, l lVar) {
        final boolean z2 = z;
        final int i4 = i2;
        final int i5 = i3;
        final l lVar2 = lVar;
        j.execute(new com.bca.xco.widget.d.a.a.b("OkHttp %s ping %08x%08x", new Object[]{this.m, Integer.valueOf(i2), Integer.valueOf(i3)}) {
            public void a() {
                try {
                    h.this.b(z2, i4, i5, lVar2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(boolean z, int i2, int i3, l lVar) {
        synchronized (this.f4951g) {
            if (lVar != null) {
                lVar.a();
            }
            this.f4951g.a(z, i2, i3);
        }
    }

    /* access modifiers changed from: private */
    public synchronized l c(int i2) {
        return this.r != null ? this.r.remove(Integer.valueOf(i2)) : null;
    }

    public void b() {
        this.f4951g.b();
    }

    public void a(c cVar) {
        synchronized (this.f4951g) {
            synchronized (this) {
                if (!this.p) {
                    this.p = true;
                    int i2 = this.n;
                    this.f4951g.a(i2, cVar, com.bca.xco.widget.d.a.a.c.f4795a);
                }
            }
        }
    }

    public void close() {
        a(c.NO_ERROR, c.CANCEL);
    }

    /* access modifiers changed from: private */
    public void a(c cVar, c cVar2) {
        i[] iVarArr;
        if (i || !Thread.holdsLock(this)) {
            l[] lVarArr = null;
            try {
                a(cVar);
                e = null;
            } catch (IOException e2) {
                e = e2;
            }
            synchronized (this) {
                if (!this.l.isEmpty()) {
                    iVarArr = (i[]) this.l.values().toArray(new i[this.l.size()]);
                    this.l.clear();
                } else {
                    iVarArr = null;
                }
                if (this.r != null) {
                    this.r = null;
                    lVarArr = (l[]) this.r.values().toArray(new l[this.r.size()]);
                }
            }
            if (iVarArr != null) {
                IOException iOException = e;
                for (i a2 : iVarArr) {
                    try {
                        a2.a(cVar2);
                    } catch (IOException e3) {
                        if (iOException != null) {
                            iOException = e3;
                        }
                    }
                }
                e = iOException;
            }
            if (lVarArr != null) {
                for (l c2 : lVarArr) {
                    c2.c();
                }
            }
            try {
                this.f4951g.close();
            } catch (IOException e4) {
                if (e == null) {
                    e = e4;
                }
            }
            try {
                this.f4950f.close();
            } catch (IOException e5) {
                e = e5;
            }
            if (e != null) {
                throw e;
            }
            return;
        }
        throw new AssertionError();
    }

    public void c() {
        a(true);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        if (z) {
            this.f4951g.a();
            this.f4951g.b(this.f4948d);
            int d2 = this.f4948d.d();
            if (d2 != 65535) {
                this.f4951g.a(0, (long) (d2 - MinElf.PN_XNUM));
            }
        }
        new Thread(this.h).start();
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Socket f4978a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f4979b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public com.bca.xco.widget.d.b.b f4980c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public com.bca.xco.widget.d.b.a f4981d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public b f4982e = b.j;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public b f4983f = b.f4902a;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public boolean f4984g;

        public a(boolean z) {
            this.f4984g = z;
        }

        public a a(Socket socket, String str, com.bca.xco.widget.d.b.b bVar, com.bca.xco.widget.d.b.a aVar) {
            this.f4978a = socket;
            this.f4979b = str;
            this.f4980c = bVar;
            this.f4981d = aVar;
            return this;
        }

        public a a(b bVar) {
            this.f4982e = bVar;
            return this;
        }

        public h a() {
            return new h(this);
        }
    }

    class c extends com.bca.xco.widget.d.a.a.b implements a.C0093a {

        /* renamed from: b  reason: collision with root package name */
        final a f4985b;

        public void a(int i, int i2, int i3, boolean z) {
        }

        public void b() {
        }

        private c(a aVar) {
            super("OkHttp %s", h.this.m);
            this.f4985b = aVar;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r0 = com.bca.xco.widget.d.a.a.g.c.PROTOCOL_ERROR;
            r1 = com.bca.xco.widget.d.a.a.g.c.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r2 = r4.f4986c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            com.bca.xco.widget.d.a.a.g.h.a(r4.f4986c, r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
            com.bca.xco.widget.d.a.a.c.a((java.io.Closeable) r4.f4985b);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
            throw r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0021 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                com.bca.xco.widget.d.a.a.g.c r0 = com.bca.xco.widget.d.a.a.g.c.INTERNAL_ERROR
                com.bca.xco.widget.d.a.a.g.c r1 = com.bca.xco.widget.d.a.a.g.c.INTERNAL_ERROR
                com.bca.xco.widget.d.a.a.g.h r2 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ IOException -> 0x0021 }
                boolean r2 = r2.f4945a     // Catch:{ IOException -> 0x0021 }
                if (r2 != 0) goto L_0x000f
                com.bca.xco.widget.d.a.a.g.a r2 = r4.f4985b     // Catch:{ IOException -> 0x0021 }
                r2.a()     // Catch:{ IOException -> 0x0021 }
            L_0x000f:
                com.bca.xco.widget.d.a.a.g.a r2 = r4.f4985b     // Catch:{ IOException -> 0x0021 }
                boolean r2 = r2.a((com.bca.xco.widget.d.a.a.g.a.C0093a) r4)     // Catch:{ IOException -> 0x0021 }
                if (r2 == 0) goto L_0x0018
                goto L_0x000f
            L_0x0018:
                com.bca.xco.widget.d.a.a.g.c r0 = com.bca.xco.widget.d.a.a.g.c.NO_ERROR     // Catch:{ IOException -> 0x0021 }
                com.bca.xco.widget.d.a.a.g.c r1 = com.bca.xco.widget.d.a.a.g.c.CANCEL     // Catch:{ IOException -> 0x0021 }
                com.bca.xco.widget.d.a.a.g.h r2 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ IOException -> 0x002a }
                goto L_0x0027
            L_0x001f:
                r2 = move-exception
                goto L_0x0030
            L_0x0021:
                com.bca.xco.widget.d.a.a.g.c r0 = com.bca.xco.widget.d.a.a.g.c.PROTOCOL_ERROR     // Catch:{ all -> 0x001f }
                com.bca.xco.widget.d.a.a.g.c r1 = com.bca.xco.widget.d.a.a.g.c.PROTOCOL_ERROR     // Catch:{ all -> 0x001f }
                com.bca.xco.widget.d.a.a.g.h r2 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ IOException -> 0x002a }
            L_0x0027:
                r2.a((com.bca.xco.widget.d.a.a.g.c) r0, (com.bca.xco.widget.d.a.a.g.c) r1)     // Catch:{ IOException -> 0x002a }
            L_0x002a:
                com.bca.xco.widget.d.a.a.g.a r0 = r4.f4985b
                com.bca.xco.widget.d.a.a.c.a((java.io.Closeable) r0)
                return
            L_0x0030:
                com.bca.xco.widget.d.a.a.g.h r3 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ IOException -> 0x0035 }
                r3.a((com.bca.xco.widget.d.a.a.g.c) r0, (com.bca.xco.widget.d.a.a.g.c) r1)     // Catch:{ IOException -> 0x0035 }
            L_0x0035:
                com.bca.xco.widget.d.a.a.g.a r0 = r4.f4985b
                com.bca.xco.widget.d.a.a.c.a((java.io.Closeable) r0)
                goto L_0x003c
            L_0x003b:
                throw r2
            L_0x003c:
                goto L_0x003b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.g.h.c.a():void");
        }

        public void a(boolean z, int i, com.bca.xco.widget.d.b.b bVar, int i2) {
            if (h.this.d(i)) {
                h.this.a(i, bVar, i2, z);
                return;
            }
            i a2 = h.this.a(i);
            if (a2 == null) {
                h.this.a(i, c.PROTOCOL_ERROR);
                bVar.d((long) i2);
                return;
            }
            a2.a(bVar, i2);
            if (z) {
                a2.i();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
            r0.a(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0081, code lost:
            r0.i();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(boolean r10, int r11, int r12, java.util.List<com.bca.xco.widget.d.a.a.g.d> r13) {
            /*
                r9 = this;
                com.bca.xco.widget.d.a.a.g.h r12 = com.bca.xco.widget.d.a.a.g.h.this
                boolean r12 = r12.d((int) r11)
                if (r12 == 0) goto L_0x000e
                com.bca.xco.widget.d.a.a.g.h r12 = com.bca.xco.widget.d.a.a.g.h.this
                r12.b(r11, r13, r10)
                return
            L_0x000e:
                com.bca.xco.widget.d.a.a.g.h r12 = com.bca.xco.widget.d.a.a.g.h.this
                monitor-enter(r12)
                com.bca.xco.widget.d.a.a.g.h r0 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x0085 }
                boolean r0 = r0.p     // Catch:{ all -> 0x0085 }
                if (r0 == 0) goto L_0x001b
                monitor-exit(r12)     // Catch:{ all -> 0x0085 }
                return
            L_0x001b:
                com.bca.xco.widget.d.a.a.g.h r0 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x0085 }
                com.bca.xco.widget.d.a.a.g.i r0 = r0.a((int) r11)     // Catch:{ all -> 0x0085 }
                if (r0 != 0) goto L_0x007b
                com.bca.xco.widget.d.a.a.g.h r0 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x0085 }
                int r0 = r0.n     // Catch:{ all -> 0x0085 }
                if (r11 > r0) goto L_0x002d
                monitor-exit(r12)     // Catch:{ all -> 0x0085 }
                return
            L_0x002d:
                int r0 = r11 % 2
                com.bca.xco.widget.d.a.a.g.h r1 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x0085 }
                int r1 = r1.o     // Catch:{ all -> 0x0085 }
                r2 = 2
                int r1 = r1 % r2
                if (r0 != r1) goto L_0x003b
                monitor-exit(r12)     // Catch:{ all -> 0x0085 }
                return
            L_0x003b:
                com.bca.xco.widget.d.a.a.g.i r0 = new com.bca.xco.widget.d.a.a.g.i     // Catch:{ all -> 0x0085 }
                com.bca.xco.widget.d.a.a.g.h r5 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x0085 }
                r6 = 0
                r3 = r0
                r4 = r11
                r7 = r10
                r8 = r13
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0085 }
                com.bca.xco.widget.d.a.a.g.h r10 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x0085 }
                int unused = r10.n = r11     // Catch:{ all -> 0x0085 }
                com.bca.xco.widget.d.a.a.g.h r10 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x0085 }
                java.util.Map r10 = r10.l     // Catch:{ all -> 0x0085 }
                java.lang.Integer r13 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0085 }
                r10.put(r13, r0)     // Catch:{ all -> 0x0085 }
                java.util.concurrent.ExecutorService r10 = com.bca.xco.widget.d.a.a.g.h.j     // Catch:{ all -> 0x0085 }
                com.bca.xco.widget.d.a.a.g.h$c$1 r13 = new com.bca.xco.widget.d.a.a.g.h$c$1     // Catch:{ all -> 0x0085 }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0085 }
                r3 = 0
                com.bca.xco.widget.d.a.a.g.h r4 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x0085 }
                java.lang.String r4 = r4.m     // Catch:{ all -> 0x0085 }
                r2[r3] = r4     // Catch:{ all -> 0x0085 }
                r3 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0085 }
                r2[r3] = r11     // Catch:{ all -> 0x0085 }
                r13.<init>(r1, r2, r0)     // Catch:{ all -> 0x0085 }
                r10.execute(r13)     // Catch:{ all -> 0x0085 }
                monitor-exit(r12)     // Catch:{ all -> 0x0085 }
                return
            L_0x007b:
                monitor-exit(r12)     // Catch:{ all -> 0x0085 }
                r0.a((java.util.List<com.bca.xco.widget.d.a.a.g.d>) r13)
                if (r10 == 0) goto L_0x0084
                r0.i()
            L_0x0084:
                return
            L_0x0085:
                r10 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x0085 }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.g.h.c.a(boolean, int, int, java.util.List):void");
        }

        public void a(int i, c cVar) {
            if (h.this.d(i)) {
                h.this.c(i, cVar);
                return;
            }
            i b2 = h.this.b(i);
            if (b2 != null) {
                b2.c(cVar);
            }
        }

        /* JADX WARNING: type inference failed for: r1v13, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(boolean r11, com.bca.xco.widget.d.a.a.g.m r12) {
            /*
                r10 = this;
                com.bca.xco.widget.d.a.a.g.h r0 = com.bca.xco.widget.d.a.a.g.h.this
                monitor-enter(r0)
                com.bca.xco.widget.d.a.a.g.h r1 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x009f }
                com.bca.xco.widget.d.a.a.g.m r1 = r1.f4949e     // Catch:{ all -> 0x009f }
                int r1 = r1.d()     // Catch:{ all -> 0x009f }
                if (r11 == 0) goto L_0x0014
                com.bca.xco.widget.d.a.a.g.h r11 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x009f }
                com.bca.xco.widget.d.a.a.g.m r11 = r11.f4949e     // Catch:{ all -> 0x009f }
                r11.a()     // Catch:{ all -> 0x009f }
            L_0x0014:
                com.bca.xco.widget.d.a.a.g.h r11 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x009f }
                com.bca.xco.widget.d.a.a.g.m r11 = r11.f4949e     // Catch:{ all -> 0x009f }
                r11.a((com.bca.xco.widget.d.a.a.g.m) r12)     // Catch:{ all -> 0x009f }
                r10.a(r12)     // Catch:{ all -> 0x009f }
                com.bca.xco.widget.d.a.a.g.h r11 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x009f }
                com.bca.xco.widget.d.a.a.g.m r11 = r11.f4949e     // Catch:{ all -> 0x009f }
                int r11 = r11.d()     // Catch:{ all -> 0x009f }
                r12 = -1
                r2 = 0
                r4 = 1
                r5 = 0
                if (r11 == r12) goto L_0x006d
                if (r11 == r1) goto L_0x006d
                int r11 = r11 - r1
                long r11 = (long) r11     // Catch:{ all -> 0x009f }
                com.bca.xco.widget.d.a.a.g.h r1 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x009f }
                boolean r1 = r1.u     // Catch:{ all -> 0x009f }
                if (r1 != 0) goto L_0x0043
                com.bca.xco.widget.d.a.a.g.h r1 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x009f }
                r1.a((long) r11)     // Catch:{ all -> 0x009f }
                com.bca.xco.widget.d.a.a.g.h r1 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x009f }
                boolean unused = r1.u = r4     // Catch:{ all -> 0x009f }
            L_0x0043:
                com.bca.xco.widget.d.a.a.g.h r1 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x009f }
                java.util.Map r1 = r1.l     // Catch:{ all -> 0x009f }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x009f }
                if (r1 != 0) goto L_0x006e
                com.bca.xco.widget.d.a.a.g.h r1 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x009f }
                java.util.Map r1 = r1.l     // Catch:{ all -> 0x009f }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x009f }
                com.bca.xco.widget.d.a.a.g.h r5 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x009f }
                java.util.Map r5 = r5.l     // Catch:{ all -> 0x009f }
                int r5 = r5.size()     // Catch:{ all -> 0x009f }
                com.bca.xco.widget.d.a.a.g.i[] r5 = new com.bca.xco.widget.d.a.a.g.i[r5]     // Catch:{ all -> 0x009f }
                java.lang.Object[] r1 = r1.toArray(r5)     // Catch:{ all -> 0x009f }
                r5 = r1
                com.bca.xco.widget.d.a.a.g.i[] r5 = (com.bca.xco.widget.d.a.a.g.i[]) r5     // Catch:{ all -> 0x009f }
                goto L_0x006e
            L_0x006d:
                r11 = r2
            L_0x006e:
                java.util.concurrent.ExecutorService r1 = com.bca.xco.widget.d.a.a.g.h.j     // Catch:{ all -> 0x009f }
                com.bca.xco.widget.d.a.a.g.h$c$2 r6 = new com.bca.xco.widget.d.a.a.g.h$c$2     // Catch:{ all -> 0x009f }
                java.lang.String r7 = "OkHttp %s settings"
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x009f }
                com.bca.xco.widget.d.a.a.g.h r8 = com.bca.xco.widget.d.a.a.g.h.this     // Catch:{ all -> 0x009f }
                java.lang.String r8 = r8.m     // Catch:{ all -> 0x009f }
                r9 = 0
                r4[r9] = r8     // Catch:{ all -> 0x009f }
                r6.<init>(r7, r4)     // Catch:{ all -> 0x009f }
                r1.execute(r6)     // Catch:{ all -> 0x009f }
                monitor-exit(r0)     // Catch:{ all -> 0x009f }
                if (r5 == 0) goto L_0x009e
                int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x009e
                int r0 = r5.length
            L_0x008f:
                if (r9 >= r0) goto L_0x009e
                r1 = r5[r9]
                monitor-enter(r1)
                r1.a((long) r11)     // Catch:{ all -> 0x009b }
                monitor-exit(r1)     // Catch:{ all -> 0x009b }
                int r9 = r9 + 1
                goto L_0x008f
            L_0x009b:
                r11 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x009b }
                throw r11
            L_0x009e:
                return
            L_0x009f:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x009f }
                goto L_0x00a3
            L_0x00a2:
                throw r11
            L_0x00a3:
                goto L_0x00a2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.g.h.c.a(boolean, com.bca.xco.widget.d.a.a.g.m):void");
        }

        private void a(final m mVar) {
            h.j.execute(new com.bca.xco.widget.d.a.a.b("OkHttp %s ACK Settings", new Object[]{h.this.m}) {
                public void a() {
                    try {
                        h.this.f4951g.a(mVar);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        public void a(boolean z, int i, int i2) {
            if (z) {
                l c2 = h.this.c(i);
                if (c2 != null) {
                    c2.b();
                    return;
                }
                return;
            }
            h.this.a(true, i, i2, (l) null);
        }

        public void a(int i, c cVar, com.bca.xco.widget.d.b.h hVar) {
            i[] iVarArr;
            hVar.e();
            synchronized (h.this) {
                iVarArr = (i[]) h.this.l.values().toArray(new i[h.this.l.size()]);
                boolean unused = h.this.p = true;
            }
            for (i iVar : iVarArr) {
                if (iVar.a() > i && iVar.c()) {
                    iVar.c(c.REFUSED_STREAM);
                    h.this.b(iVar.a());
                }
            }
        }

        public void a(int i, long j) {
            if (i == 0) {
                synchronized (h.this) {
                    h.this.f4947c += j;
                    h.this.notifyAll();
                }
                return;
            }
            i a2 = h.this.a(i);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        public void a(int i, int i2, List<d> list) {
            h.this.a(i2, list);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, List<d> list) {
        synchronized (this) {
            if (this.v.contains(Integer.valueOf(i2))) {
                a(i2, c.PROTOCOL_ERROR);
                return;
            }
            this.v.add(Integer.valueOf(i2));
            final int i3 = i2;
            final List<d> list2 = list;
            this.q.execute(new com.bca.xco.widget.d.a.a.b("OkHttp %s Push Request[%s]", new Object[]{this.m, Integer.valueOf(i2)}) {
                public void a() {
                    if (h.this.s.a(i3, (List<d>) list2)) {
                        try {
                            h.this.f4951g.a(i3, c.CANCEL);
                            synchronized (h.this) {
                                h.this.v.remove(Integer.valueOf(i3));
                            }
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2, List<d> list, boolean z) {
        final int i3 = i2;
        final List<d> list2 = list;
        final boolean z2 = z;
        this.q.execute(new com.bca.xco.widget.d.a.a.b("OkHttp %s Push Headers[%s]", new Object[]{this.m, Integer.valueOf(i2)}) {
            public void a() {
                boolean a2 = h.this.s.a(i3, list2, z2);
                if (a2) {
                    try {
                        h.this.f4951g.a(i3, c.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (a2 || z2) {
                    synchronized (h.this) {
                        h.this.v.remove(Integer.valueOf(i3));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i2, com.bca.xco.widget.d.b.b bVar, int i3, boolean z) {
        final g gVar = new g();
        long j2 = (long) i3;
        bVar.c(j2);
        bVar.a(gVar, j2);
        if (gVar.m() == j2) {
            final int i4 = i2;
            final int i5 = i3;
            final boolean z2 = z;
            this.q.execute(new com.bca.xco.widget.d.a.a.b("OkHttp %s Push Data[%s]", new Object[]{this.m, Integer.valueOf(i2)}) {
                public void a() {
                    try {
                        boolean a2 = h.this.s.a(i4, gVar, i5, z2);
                        if (a2) {
                            h.this.f4951g.a(i4, c.CANCEL);
                        }
                        if (a2 || z2) {
                            synchronized (h.this) {
                                h.this.v.remove(Integer.valueOf(i4));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(gVar.m() + " != " + i3);
    }

    /* access modifiers changed from: private */
    public void c(int i2, c cVar) {
        final int i3 = i2;
        final c cVar2 = cVar;
        this.q.execute(new com.bca.xco.widget.d.a.a.b("OkHttp %s Push Reset[%s]", new Object[]{this.m, Integer.valueOf(i2)}) {
            public void a() {
                h.this.s.a(i3, cVar2);
                synchronized (h.this) {
                    h.this.v.remove(Integer.valueOf(i3));
                }
            }
        });
    }
}
