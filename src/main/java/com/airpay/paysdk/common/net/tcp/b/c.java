package com.airpay.paysdk.common.net.tcp.b;

import com.airpay.paysdk.common.c.b;
import com.airpay.paysdk.common.net.a.a.d;
import com.airpay.paysdk.common.net.tcp.b.c;
import com.airpay.paysdk.common.net.tcp.c.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c implements com.airpay.paysdk.common.net.b.a, e {

    /* renamed from: a  reason: collision with root package name */
    private com.airpay.paysdk.common.net.tcp.a.b f4029a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentLinkedQueue f4030b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Map<Integer, b> f4031c;

    /* renamed from: d  reason: collision with root package name */
    private Map<Integer, C0081c> f4032d;

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, com.airpay.paysdk.common.net.tcp.c.c> f4033e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airpay.paysdk.common.c.b f4034f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public com.airpay.paysdk.common.net.tcp.a.c f4035g;
    private d h;

    private c(a aVar) {
        this.f4030b = new ConcurrentLinkedQueue();
        this.f4031c = new ConcurrentHashMap();
        this.f4032d = new ConcurrentHashMap();
        this.f4033e = new ConcurrentHashMap();
        com.airpay.paysdk.common.net.b.c.a().a((com.airpay.paysdk.common.net.b.a) this);
        this.f4034f = com.airpay.paysdk.common.c.b.a(b.c.CACHE);
        this.f4035g = new com.airpay.paysdk.common.net.tcp.a.c(aVar.f4038a, aVar.f4039b, aVar.f4040c, this);
        this.f4029a = new com.airpay.paysdk.common.net.tcp.a.b(new com.airpay.paysdk.common.net.tcp.c.d() {
            public int a() {
                return 3;
            }

            public int a(int i) {
                if (i > 3) {
                    i = 3;
                }
                int i2 = ((i - 1) * 2 * 1000) + 1000;
                if (i2 > 10000) {
                    return 10000;
                }
                return i2;
            }
        });
        this.h = aVar.f4041d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void g(int i) {
        if (!c()) {
            this.f4035g.a(i);
        }
    }

    public void a(int i, e eVar, com.airpay.paysdk.common.net.tcp.c.a aVar) {
        if (eVar.c() > 1048576) {
            aVar.a(10010, "failed due to tcp-exceed-max-size : " + eVar.c());
            return;
        }
        b bVar = new b(eVar, aVar, i);
        this.f4031c.put(Integer.valueOf(eVar.a().b()), bVar);
        this.f4034f.execute(bVar);
    }

    public synchronized void b() {
        if (this.f4035g != null) {
            this.f4034f.execute(new Runnable() {
                public final void run() {
                    c.this.f();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.f4035g.a();
    }

    public synchronized boolean c() {
        return this.f4035g != null && this.f4035g.b();
    }

    public void b(int i) {
        this.f4029a.c();
        b bVar = this.f4031c.get(Integer.valueOf(i));
        if (bVar != null) {
            if (bVar.b() != 1) {
                d dVar = this.h;
                if (dVar != null) {
                    dVar.a(new com.airpay.paysdk.common.net.a.a.c() {
                        public void a() {
                            c.this.d();
                        }

                        public void a(int i, String str) {
                            c.this.a(i, str);
                        }
                    });
                    return;
                }
            }
            d();
            return;
        }
        d();
    }

    public void a(int i, int i2, String str) {
        synchronized (this) {
            this.f4029a.b();
            if (!this.f4029a.a() && i2 != 10002) {
                if (com.airpay.paysdk.common.e.a.b()) {
                    com.airpay.paysdk.common.b.a.a("连接重连次数：" + this.f4029a.f4017a, new Object[0]);
                    com.airpay.paysdk.common.c.a.a().b(new Runnable(i) {
                        private final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            c.this.f(this.f$1);
                        }
                    }, (long) this.f4029a.e());
                }
            }
            a(i2, str);
            this.f4029a.d();
            com.airpay.paysdk.common.b.a.a("连接重连失败。。。", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(int i) {
        this.f4034f.execute(new Runnable(i) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                c.this.g(this.f$1);
            }
        });
    }

    public void a(f fVar) {
        com.airpay.paysdk.common.b.a.b("koneng: " + fVar.d() + ", error: " + fVar.e(), new Object[0]);
        int a2 = fVar.a();
        C0081c cVar = this.f4032d.get(Integer.valueOf(a2));
        if (cVar != null) {
            cVar.a();
            this.f4032d.remove(Integer.valueOf(a2));
        }
        b bVar = this.f4031c.get(Integer.valueOf(a2));
        if (bVar != null) {
            bVar.a().a(fVar);
            this.f4031c.remove(Integer.valueOf(a2));
        }
    }

    public void b(f fVar) {
        com.airpay.paysdk.common.net.tcp.c.c cVar = this.f4033e.get(Integer.valueOf(fVar.c()));
        if (cVar != null) {
            cVar.onReceive(fVar);
        }
    }

    public void a(int i, com.airpay.paysdk.common.net.tcp.c.c cVar) {
        if (!c()) {
            this.f4034f.execute(new Runnable() {
                public final void run() {
                    c.this.e();
                }
            });
        }
        this.f4033e.put(Integer.valueOf(i), cVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        g(-10001);
    }

    /* access modifiers changed from: private */
    public void d() {
        while (!this.f4030b.isEmpty()) {
            b bVar = this.f4031c.get(Integer.valueOf(((Integer) this.f4030b.poll()).intValue()));
            if (bVar != null) {
                this.f4034f.execute(bVar);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, String str) {
        while (!this.f4030b.isEmpty()) {
            int intValue = ((Integer) this.f4030b.poll()).intValue();
            b bVar = this.f4031c.get(Integer.valueOf(intValue));
            if (bVar != null) {
                bVar.a().a(i, str);
                this.f4031c.remove(Integer.valueOf(intValue));
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(int i) {
        C0081c cVar = new C0081c(i);
        this.f4032d.put(Integer.valueOf(i), cVar);
        this.f4034f.execute(cVar);
    }

    private synchronized void d(int i) {
        this.f4029a.d();
        b();
        this.f4034f.execute(new Runnable(i) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                c.this.e(this.f$1);
            }
        });
    }

    public void a() {
        if (com.airpay.paysdk.common.e.a.b()) {
            d(-10001);
        }
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private volatile e f4043b;

        /* renamed from: c  reason: collision with root package name */
        private volatile com.airpay.paysdk.common.net.tcp.c.a f4044c;

        /* renamed from: d  reason: collision with root package name */
        private volatile int f4045d;

        b(e eVar, com.airpay.paysdk.common.net.tcp.c.a aVar, int i) {
            this.f4043b = eVar;
            this.f4044c = aVar;
            this.f4045d = i;
        }

        public com.airpay.paysdk.common.net.tcp.c.a a() {
            return this.f4044c;
        }

        public int b() {
            return this.f4045d;
        }

        public void run() {
            c();
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (c.this.c()) {
                c.this.c(this.f4043b.a().b());
                c.this.f4035g.a(this.f4043b);
                return;
            }
            com.airpay.paysdk.common.b.a.a("koneng----------un connect ---------", new Object[0]);
            int b2 = this.f4043b.a().b();
            c.this.f4030b.add(Integer.valueOf(b2));
            c.this.g(b2);
        }
    }

    /* renamed from: com.airpay.paysdk.common.net.tcp.b.c$c  reason: collision with other inner class name */
    private class C0081c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private volatile int f4047b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f4048c;

        public void a() {
            this.f4048c = true;
        }

        C0081c(int i) {
            this.f4047b = i;
        }

        public void run() {
            com.airpay.paysdk.common.c.a.a().b(new Runnable() {
                public final void run() {
                    c.C0081c.this.b();
                }
            }, 10000);
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ void b() {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = r3.f4048c     // Catch:{ all -> 0x0037 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0037 }
                return
            L_0x0007:
                com.airpay.paysdk.common.net.tcp.b.c r0 = com.airpay.paysdk.common.net.tcp.b.c.this     // Catch:{ all -> 0x0037 }
                java.util.Map r0 = r0.f4031c     // Catch:{ all -> 0x0037 }
                int r1 = r3.f4047b     // Catch:{ all -> 0x0037 }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0037 }
                java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0037 }
                com.airpay.paysdk.common.net.tcp.b.c$b r0 = (com.airpay.paysdk.common.net.tcp.b.c.b) r0     // Catch:{ all -> 0x0037 }
                if (r0 == 0) goto L_0x0035
                com.airpay.paysdk.common.net.tcp.b.c r1 = com.airpay.paysdk.common.net.tcp.b.c.this     // Catch:{ all -> 0x0037 }
                java.util.Map r1 = r1.f4031c     // Catch:{ all -> 0x0037 }
                int r2 = r3.f4047b     // Catch:{ all -> 0x0037 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0037 }
                r1.remove(r2)     // Catch:{ all -> 0x0037 }
                com.airpay.paysdk.common.net.tcp.c.a r0 = r0.a()     // Catch:{ all -> 0x0037 }
                r1 = 10012(0x271c, float:1.403E-41)
                java.lang.String r2 = "request is time out !"
                r0.a(r1, r2)     // Catch:{ all -> 0x0037 }
            L_0x0035:
                monitor-exit(r3)     // Catch:{ all -> 0x0037 }
                return
            L_0x0037:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0037 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airpay.paysdk.common.net.tcp.b.c.C0081c.b():void");
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f4038a;

        /* renamed from: b  reason: collision with root package name */
        int f4039b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4040c;

        /* renamed from: d  reason: collision with root package name */
        d f4041d;

        public a a(String str) {
            this.f4038a = str;
            return this;
        }

        public a a(int i) {
            this.f4039b = i;
            return this;
        }

        public a a(boolean z) {
            this.f4040c = z;
            return this;
        }

        public a a(d dVar) {
            this.f4041d = dVar;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }
}
