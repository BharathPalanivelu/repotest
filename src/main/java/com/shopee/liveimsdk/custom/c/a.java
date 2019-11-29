package com.shopee.liveimsdk.custom.c;

import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import com.shopee.liveimsdk.RemoteimConfig;
import com.shopee.liveimsdk.custom.CustomIMSingleService;
import com.shopee.liveimsdk.custom.a.a;
import com.shopee.liveimsdk.custom.b.a.e;
import com.shopee.liveimsdk.custom.b.c;
import com.shopee.liveimsdk.d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CustomIMSingleService.a f29625a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public HandlerThread f29626b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Handler f29627c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f29628d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f29629e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ScheduledExecutorService f29630f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f29631g;
    /* access modifiers changed from: private */
    public long h = 0;
    /* access modifiers changed from: private */
    public String i = "";
    private int j = 0;
    private String k = "";
    /* access modifiers changed from: private */
    public String l = "";
    /* access modifiers changed from: private */
    public String m = "";
    /* access modifiers changed from: private */
    public long n;
    /* access modifiers changed from: private */
    public long o;
    /* access modifiers changed from: private */
    public List<f.b> p;
    /* access modifiers changed from: private */
    public long q;
    /* access modifiers changed from: private */
    public HandlerThread r;
    /* access modifiers changed from: private */
    public Handler s;
    /* access modifiers changed from: private */
    public BlockingQueue<a.d> t;
    /* access modifiers changed from: private */
    public List<a.d> u;
    /* access modifiers changed from: private */
    public long v = 100;
    /* access modifiers changed from: private */
    public b w;
    /* access modifiers changed from: private */
    public boolean x;

    static /* synthetic */ int f(a aVar) {
        int i2 = aVar.f29631g;
        aVar.f29631g = i2 - 1;
        return i2;
    }

    /* renamed from: com.shopee.liveimsdk.custom.c.a$a  reason: collision with other inner class name */
    private class C0452a implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public long f29644b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f29645c;

        /* renamed from: d  reason: collision with root package name */
        private b f29646d;

        C0452a(long j, long j2) {
            this.f29644b = j;
            this.f29645c = j2;
            this.f29646d = new b(a.this) {
                /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
                    java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
                    	at java.util.ArrayList.rangeCheck(ArrayList.java:657)
                    	at java.util.ArrayList.get(ArrayList.java:433)
                    	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                    	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                    	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                    	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                    	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                    	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
                    	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                    	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                    	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
                    */
                public void a() {
                    /*
                        r10 = this;
                        com.shopee.liveimsdk.custom.c.a$a r0 = com.shopee.liveimsdk.custom.c.a.C0452a.this
                        long r0 = r0.f29645c
                        com.shopee.liveimsdk.custom.c.a$a r2 = com.shopee.liveimsdk.custom.c.a.C0452a.this
                        com.shopee.liveimsdk.custom.c.a r2 = com.shopee.liveimsdk.custom.c.a.this
                        long r2 = r2.o
                        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                        if (r4 >= 0) goto L_0x0013
                        return
                    L_0x0013:
                        com.shopee.liveimsdk.custom.c.a$a r0 = com.shopee.liveimsdk.custom.c.a.C0452a.this
                        com.shopee.liveimsdk.custom.c.a r0 = com.shopee.liveimsdk.custom.c.a.this
                        int r0 = r0.f29631g
                        if (r0 > 0) goto L_0x001e
                        return
                    L_0x001e:
                        r0 = 0
                        com.shopee.liveimsdk.custom.b.b r1 = com.shopee.liveimsdk.custom.b.b.a()
                        f.n r1 = r1.b()
                        java.lang.Class<com.shopee.liveimsdk.custom.b.b.b> r2 = com.shopee.liveimsdk.custom.b.b.b.class
                        java.lang.Object r1 = r1.a(r2)
                        com.shopee.liveimsdk.custom.b.b.b r1 = (com.shopee.liveimsdk.custom.b.b.b) r1
                        com.shopee.liveimsdk.custom.c.a$a r2 = com.shopee.liveimsdk.custom.c.a.C0452a.this
                        com.shopee.liveimsdk.custom.c.a r2 = com.shopee.liveimsdk.custom.c.a.this
                        java.lang.String r2 = r2.m
                        com.shopee.liveimsdk.custom.c.a$a r3 = com.shopee.liveimsdk.custom.c.a.C0452a.this
                        com.shopee.liveimsdk.custom.c.a r3 = com.shopee.liveimsdk.custom.c.a.this
                        java.lang.String r3 = r3.i
                        com.shopee.liveimsdk.custom.c.a$a r4 = com.shopee.liveimsdk.custom.c.a.C0452a.this
                        long r4 = r4.f29644b
                        f.b r1 = r1.a(r2, r3, r4)
                        r2 = -1
                        java.lang.String r3 = "Try to get chatroom message."
                        com.shopee.liveimsdk.c.a(r3)     // Catch:{ Exception -> 0x0093 }
                        com.shopee.liveimsdk.custom.c.a$a r3 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ Exception -> 0x0093 }
                        com.shopee.liveimsdk.custom.c.a r3 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ Exception -> 0x0093 }
                        java.util.List r3 = r3.p     // Catch:{ Exception -> 0x0093 }
                        r3.add(r1)     // Catch:{ Exception -> 0x0093 }
                        f.m r3 = r1.a()     // Catch:{ Exception -> 0x0093 }
                        if (r3 == 0) goto L_0x0091
                        java.lang.Object r4 = r3.e()     // Catch:{ Exception -> 0x0093 }
                        if (r4 == 0) goto L_0x0091
                        java.lang.Object r4 = r3.e()     // Catch:{ Exception -> 0x0093 }
                        com.shopee.liveimsdk.custom.b.d r4 = (com.shopee.liveimsdk.custom.b.d) r4     // Catch:{ Exception -> 0x0093 }
                        int r4 = r4.code     // Catch:{ Exception -> 0x0093 }
                        if (r4 != 0) goto L_0x007c
                        java.lang.Object r3 = r3.e()     // Catch:{ Exception -> 0x0094 }
                        com.shopee.liveimsdk.custom.b.d r3 = (com.shopee.liveimsdk.custom.b.d) r3     // Catch:{ Exception -> 0x0094 }
                        T r3 = r3.data     // Catch:{ Exception -> 0x0094 }
                        com.shopee.liveimsdk.custom.a.a r3 = (com.shopee.liveimsdk.custom.a.a) r3     // Catch:{ Exception -> 0x0094 }
                        r0 = r3
                        goto L_0x0099
                    L_0x007c:
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0094 }
                        r3.<init>()     // Catch:{ Exception -> 0x0094 }
                        java.lang.String r5 = "GetMessage failed: code: "
                        r3.append(r5)     // Catch:{ Exception -> 0x0094 }
                        r3.append(r4)     // Catch:{ Exception -> 0x0094 }
                        java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0094 }
                        com.shopee.liveimsdk.c.a(r3)     // Catch:{ Exception -> 0x0094 }
                        goto L_0x0099
                    L_0x0091:
                        r4 = -1
                        goto L_0x0099
                    L_0x0093:
                        r4 = -1
                    L_0x0094:
                        java.lang.String r3 = "get chatroom exception"
                        com.shopee.liveimsdk.c.a(r3)
                    L_0x0099:
                        com.shopee.liveimsdk.custom.c.a$a r3 = com.shopee.liveimsdk.custom.c.a.C0452a.this
                        com.shopee.liveimsdk.custom.c.a r3 = com.shopee.liveimsdk.custom.c.a.this
                        monitor-enter(r3)
                        com.shopee.liveimsdk.custom.c.a$a r5 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        long r5 = r5.f29645c     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a$a r7 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r7 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        long r7 = r7.o     // Catch:{ all -> 0x0175 }
                        int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                        if (r9 >= 0) goto L_0x00b2
                        monitor-exit(r3)     // Catch:{ all -> 0x0175 }
                        return
                    L_0x00b2:
                        if (r4 != 0) goto L_0x00f7
                        com.shopee.liveimsdk.custom.c.a$a r4 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r4 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        int r4 = r4.f29631g     // Catch:{ all -> 0x0175 }
                        if (r4 <= 0) goto L_0x00cd
                        com.shopee.liveimsdk.custom.c.a$a r4 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r4 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        r5 = 0
                        int unused = r4.f29631g = r5     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a$a r4 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r4 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        r4.a((com.shopee.liveimsdk.custom.a.a) r0)     // Catch:{ all -> 0x0175 }
                    L_0x00cd:
                        com.shopee.liveimsdk.custom.c.a$a r0 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r0 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        java.util.List r0 = r0.p     // Catch:{ all -> 0x0175 }
                        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0175 }
                    L_0x00d9:
                        boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0175 }
                        if (r4 == 0) goto L_0x00eb
                        java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0175 }
                        f.b r4 = (f.b) r4     // Catch:{ all -> 0x0175 }
                        if (r4 == r1) goto L_0x00d9
                        r1.b()     // Catch:{ all -> 0x0175 }
                        goto L_0x00d9
                    L_0x00eb:
                        com.shopee.liveimsdk.custom.c.a$a r0 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r0 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        java.util.List r0 = r0.p     // Catch:{ all -> 0x0175 }
                        r0.clear()     // Catch:{ all -> 0x0175 }
                        goto L_0x00fe
                    L_0x00f7:
                        com.shopee.liveimsdk.custom.c.a$a r0 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r0 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a.f(r0)     // Catch:{ all -> 0x0175 }
                    L_0x00fe:
                        com.shopee.liveimsdk.custom.c.a$a r0 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r0 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        int r0 = r0.f29631g     // Catch:{ all -> 0x0175 }
                        if (r0 != 0) goto L_0x0173
                        com.shopee.liveimsdk.custom.c.a$a r0 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r0 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        boolean r0 = r0.f29628d     // Catch:{ all -> 0x0175 }
                        if (r0 == 0) goto L_0x0173
                        com.shopee.liveimsdk.custom.c.a$a r0 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r0 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        int unused = r0.f29631g = r2     // Catch:{ all -> 0x0175 }
                        long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a$a r2 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r2 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        long unused = r2.o = r0     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a$a r2 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r2 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        long r4 = r2.h     // Catch:{ all -> 0x0175 }
                        long r4 = r0 - r4
                        com.shopee.liveimsdk.custom.c.a$a r2 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r2 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        long r6 = r2.q     // Catch:{ all -> 0x0175 }
                        int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                        if (r2 >= 0) goto L_0x0160
                        com.shopee.liveimsdk.custom.c.a$a r2 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r2 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        android.os.Handler r2 = r2.f29627c     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a$a r4 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r4 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.b r4 = r4.f29629e     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a$a r5 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r5 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        long r5 = r5.q     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a$a r7 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r7 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        long r7 = r7.h     // Catch:{ all -> 0x0175 }
                        long r5 = r5 + r7
                        long r5 = r5 - r0
                        com.shopee.liveimsdk.custom.c.c.a(r2, r4, r5)     // Catch:{ all -> 0x0175 }
                        goto L_0x0173
                    L_0x0160:
                        com.shopee.liveimsdk.custom.c.a$a r0 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r0 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        android.os.Handler r0 = r0.f29627c     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a$a r1 = com.shopee.liveimsdk.custom.c.a.C0452a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.a r1 = com.shopee.liveimsdk.custom.c.a.this     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.b r1 = r1.f29629e     // Catch:{ all -> 0x0175 }
                        com.shopee.liveimsdk.custom.c.c.a(r0, r1)     // Catch:{ all -> 0x0175 }
                    L_0x0173:
                        monitor-exit(r3)     // Catch:{ all -> 0x0175 }
                        return
                    L_0x0175:
                        r0 = move-exception
                        monitor-exit(r3)     // Catch:{ all -> 0x0175 }
                        goto L_0x0179
                    L_0x0178:
                        throw r0
                    L_0x0179:
                        goto L_0x0178
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.liveimsdk.custom.c.a.C0452a.AnonymousClass1.a():void");
                }
            };
        }

        public void run() {
            c.a(this.f29646d);
        }
    }

    public void a() {
        c.a(new b() {
            public void a() {
                HandlerThread unused = a.this.f29626b = new HandlerThread("im_looper", 10);
                a.this.f29626b.start();
                boolean unused2 = a.this.f29628d = true;
                a aVar = a.this;
                Handler unused3 = aVar.f29627c = new Handler(aVar.f29626b.getLooper());
                ScheduledExecutorService unused4 = a.this.f29630f = Executors.newScheduledThreadPool(4);
                BlockingQueue unused5 = a.this.t = new LinkedBlockingQueue(100);
                List unused6 = a.this.u = new ArrayList();
                List unused7 = a.this.p = new ArrayList();
                long unused8 = a.this.q = 3000;
                HandlerThread unused9 = a.this.r = new HandlerThread("handle_message_looper", 10);
                a.this.r.start();
                a aVar2 = a.this;
                Handler unused10 = aVar2.s = new Handler(aVar2.r.getLooper());
                a.this.s.post(new Runnable() {
                    public void run() {
                        try {
                            a.d dVar = (a.d) a.this.t.take();
                            if (a.this.f29625a != null) {
                                a.this.f29625a.a(dVar);
                            }
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        if (a.this.s != null) {
                            a.this.s.postDelayed(this, a.this.v);
                        }
                    }
                });
                b unused11 = a.this.f29629e = new b() {
                    public void a() {
                        if (a.this.f29630f == null) {
                            ScheduledExecutorService unused = a.this.f29630f = Executors.newScheduledThreadPool(4);
                        }
                        int unused2 = a.this.f29631g = 3;
                        long unused3 = a.this.h = System.currentTimeMillis();
                        for (int i = 0; i < 3; i++) {
                            if (a.this.f29630f != null && !a.this.f29630f.isShutdown()) {
                                a.this.f29630f.schedule(new C0452a(a.this.n, a.this.o), ((long) i) * 3000, TimeUnit.MILLISECONDS);
                            }
                        }
                    }
                };
            }
        });
    }

    public IBinder a(Intent intent) {
        this.w = new b();
        return this.w;
    }

    /* access modifiers changed from: private */
    public void a(com.shopee.liveimsdk.custom.a.a aVar) {
        if (aVar != null) {
            this.n = aVar.f29583a;
            this.q = aVar.f29584b > 0 ? (long) (aVar.f29584b * 1000) : this.q;
            CustomIMSingleService.a aVar2 = this.f29625a;
            if (aVar2 != null) {
                aVar2.a(aVar);
            }
            if (aVar.f29585c != null) {
                int i2 = 0;
                for (a.c cVar : aVar.f29585c) {
                    i2 += cVar.f29592a.size();
                }
                int size = this.t.size();
                if (i2 + size > 100 && i2 < 100) {
                    this.t.drainTo(this.u, size);
                } else if (i2 > 100) {
                    this.t.clear();
                }
                for (a.c cVar2 : aVar.f29585c) {
                    for (a.d next : cVar2.f29592a) {
                        if (((long) this.j) != next.f29594b && !this.t.offer(next)) {
                            this.t.poll();
                            this.t.offer(next);
                        }
                    }
                }
                int size2 = this.t.size();
                if (size2 > 0) {
                    this.v = Math.min(Math.max(3000 / ((long) size2), 100), 500);
                }
            }
        }
    }

    public void b() {
        c.a(new b() {
            public void a() {
                a.this.d();
                Handler unused = a.this.f29627c = null;
                boolean unused2 = a.this.f29628d = false;
                if (Build.VERSION.SDK_INT >= 18) {
                    a.this.f29626b.quitSafely();
                } else {
                    a.this.f29626b.quit();
                }
                HandlerThread unused3 = a.this.f29626b = null;
                if (a.this.s != null) {
                    a.this.s.removeCallbacksAndMessages((Object) null);
                    Handler unused4 = a.this.s = null;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    a.this.r.quitSafely();
                } else {
                    a.this.r.quit();
                }
                HandlerThread unused5 = a.this.r = null;
                b unused6 = a.this.f29629e = null;
                CustomIMSingleService.a unused7 = a.this.f29625a = null;
                b unused8 = a.this.w = null;
                com.shopee.liveimsdk.custom.b.b.c();
            }
        });
    }

    /* access modifiers changed from: private */
    public void c() {
        this.x = true;
        ScheduledExecutorService scheduledExecutorService = this.f29630f;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown() && this.f29627c != null) {
            this.o = System.currentTimeMillis();
            c.a(this.f29627c, this.f29629e);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        this.x = false;
        ScheduledExecutorService scheduledExecutorService = this.f29630f;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            this.f29630f = null;
        }
        this.t.clear();
        Handler handler = this.f29627c;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: private */
    public void a(RemoteimConfig remoteimConfig) {
        d.f29665a = remoteimConfig.f29509a;
        d.f29666b = remoteimConfig.f29510b;
        d.f29667c = remoteimConfig.f29511c;
        String str = "";
        this.i = remoteimConfig.f29512d == null ? str : remoteimConfig.f29512d;
        this.j = remoteimConfig.f29513e;
        if (remoteimConfig.f29514f != null) {
            str = remoteimConfig.f29514f;
        }
        this.k = str;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        this.m = str;
    }

    /* access modifiers changed from: private */
    public void b(final String str) {
        this.m = str;
        c.a(str, (String) null, new com.shopee.liveimsdk.custom.b.a.c(this.i, this.k), (c.a<com.shopee.liveimsdk.custom.b.d>) new c.a<com.shopee.liveimsdk.custom.b.d>() {
            public void a(com.shopee.liveimsdk.custom.b.d dVar) {
                com.shopee.liveimsdk.custom.b.a.b bVar = (com.shopee.liveimsdk.custom.b.a.b) dVar.data;
                String unused = a.this.l = bVar.f29601a;
                long unused2 = a.this.n = bVar.f29602b;
                String unused3 = a.this.m = str;
                if (a.this.f29625a != null) {
                    a.this.f29625a.a(str);
                }
            }

            public void a(int i) {
                if (a.this.f29625a != null) {
                    a.this.f29625a.a(str, i);
                }
            }

            public void b(int i) {
                if (a.this.f29625a != null) {
                    a.this.f29625a.a(str, i);
                }
            }
        });
        if (!this.x) {
            c();
        }
    }

    /* access modifiers changed from: private */
    public void c(final String str) {
        c.a(str, new com.shopee.liveimsdk.custom.b.a.a(this.i, this.l), new c.a<com.shopee.liveimsdk.custom.b.d>() {
            public void a(com.shopee.liveimsdk.custom.b.d dVar) {
                if (a.this.f29625a != null) {
                    a.this.f29625a.b(str);
                }
                a.this.d();
            }

            public void a(int i) {
                if (a.this.f29625a != null) {
                    a.this.f29625a.b(str, i);
                }
            }

            public void b(int i) {
                if (a.this.f29625a != null) {
                    a.this.f29625a.b(str, i);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final String str, final String str2) {
        c.a(str, (String) null, new e(this.i, this.l, str2, 0), (c.a<com.shopee.liveimsdk.custom.b.a.d>) new c.a<com.shopee.liveimsdk.custom.b.a.d>() {
            public void a(com.shopee.liveimsdk.custom.b.a.d dVar) {
                if (dVar == null) {
                    com.shopee.liveimsdk.c.a("send message success");
                } else {
                    com.shopee.liveimsdk.c.a("send message success, id: " + dVar.f29605a);
                }
                if (a.this.f29625a != null) {
                    a.this.f29625a.a(str, str2);
                }
            }

            public void a(int i) {
                if (a.this.f29625a != null) {
                    a.this.f29625a.a(str, str2, i);
                }
            }

            public void b(int i) {
                if (a.this.f29625a != null) {
                    a.this.f29625a.a(str, str2, i);
                }
            }
        });
    }

    public void a(CustomIMSingleService.a aVar) {
        this.f29625a = aVar;
    }

    public class b extends Binder {
        public b() {
        }

        public boolean a(final RemoteimConfig remoteimConfig) {
            c.a(new b() {
                public void a() {
                    a.this.a(remoteimConfig);
                }
            });
            return true;
        }

        public void a(final String str) {
            c.a(new b() {
                public void a() {
                    a.this.b(str);
                }
            });
        }

        public void b(final String str) {
            c.a(new b() {
                public void a() {
                    if (a.this.l != null && !"".equals(a.this.l)) {
                        a.this.c(str);
                    }
                }
            });
        }

        public void a(final String str, final String str2) {
            c.a(new b() {
                public void a() {
                    a.this.a(str, str2);
                }
            });
        }

        public void a(final CustomIMSingleService.a aVar) {
            c.a(new b() {
                public void a() {
                    a.this.a(aVar);
                }
            });
        }

        public void c(final String str) {
            c.a(new b() {
                public void a() {
                    if (!a.this.x) {
                        a.this.a(str);
                        a.this.c();
                    }
                }
            });
        }

        public void a(long j) {
            long unused = a.this.n = j;
        }
    }
}
