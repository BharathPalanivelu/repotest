package com.shopee.live.livestreaming.ui.view.b;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.garena.android.appkit.f.f;
import com.shopee.live.livestreaming.a.h;
import java.text.DecimalFormat;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private C0445a f29230a = new C0445a("custom_tick_timer_" + (System.currentTimeMillis() % 1000));

    /* renamed from: b  reason: collision with root package name */
    private Application f29231b;

    /* renamed from: c  reason: collision with root package name */
    private h f29232c;

    public a() {
        this.f29230a.b();
        this.f29230a.a(100);
    }

    public void a() {
        this.f29230a.d();
        this.f29230a.c();
        h hVar = this.f29232c;
        if (hVar != null) {
            hVar.a();
            this.f29232c = null;
        }
    }

    public void a(int i) {
        this.f29230a.b(i);
        Application application = this.f29231b;
        if (application != null && this.f29232c == null) {
            this.f29232c = new h(application);
            this.f29232c.a((h.a) new h.a() {
                public void a() {
                    a.this.b(60);
                }

                public void b() {
                    a.this.b();
                }
            });
        }
    }

    public void b(int i) {
        this.f29230a.c(i);
    }

    public void b() {
        this.f29230a.e();
    }

    public void c(int i) {
        this.f29230a.a(1000 / Math.min(100, Math.max(1, i)));
    }

    public void a(b bVar) {
        this.f29230a.a(bVar);
    }

    public void a(Application application) {
        this.f29231b = application;
    }

    /* renamed from: com.shopee.live.livestreaming.ui.view.b.a$a  reason: collision with other inner class name */
    private static class C0445a {

        /* renamed from: a  reason: collision with root package name */
        HandlerThread f29234a;

        /* renamed from: b  reason: collision with root package name */
        C0446a f29235b;

        /* renamed from: c  reason: collision with root package name */
        String f29236c;

        /* renamed from: d  reason: collision with root package name */
        boolean f29237d;

        /* renamed from: e  reason: collision with root package name */
        long f29238e;

        /* renamed from: f  reason: collision with root package name */
        long f29239f;

        /* renamed from: g  reason: collision with root package name */
        int f29240g;
        int h;
        int i;
        long j;
        b k = new b() {
            public void b(int i) {
            }

            public void n() {
            }

            public void o() {
            }
        };

        C0445a(String str) {
            this.f29236c = str;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f29237d;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f29238e = (long) i2;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f29234a = new HandlerThread(this.f29236c, 10);
            this.f29234a.start();
            this.f29237d = true;
            this.f29235b = new C0446a(this.f29234a.getLooper());
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (a()) {
                this.f29237d = false;
                this.f29235b.removeCallbacksAndMessages((Object) null);
                this.f29235b = null;
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f29234a.quitSafely();
                } else {
                    this.f29234a.quit();
                }
                this.f29234a = null;
                this.k = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            if (bVar != null) {
                this.k = bVar;
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void b(int i2) {
            if (a() && i2 > 0) {
                this.f29240g = i2;
                this.h = i2;
                f();
                this.f29235b.sendEmptyMessage(2);
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void d() {
            if (a()) {
                this.f29235b.sendEmptyMessage(1);
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void c(int i2) {
            if (a() && this.h > 0 && this.i == 0) {
                this.f29235b.sendMessage(this.f29235b.obtainMessage(4, i2, 0));
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void e() {
            if (a() && this.h > 0 && this.i != 0) {
                this.f29235b.sendEmptyMessage(5);
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void f() {
            if (a()) {
                this.f29235b.removeCallbacksAndMessages((Object) null);
            }
        }

        /* renamed from: com.shopee.live.livestreaming.ui.view.b.a$a$a  reason: collision with other inner class name */
        private class C0446a extends Handler {
            C0446a(Looper looper) {
                super(looper);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:41:0x013f, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public synchronized void handleMessage(android.os.Message r11) {
                /*
                    r10 = this;
                    monitor-enter(r10)
                    com.shopee.live.livestreaming.ui.view.b.a$a r0 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r0 = r0.h     // Catch:{ all -> 0x0140 }
                    if (r0 >= 0) goto L_0x0009
                    monitor-exit(r10)
                    return
                L_0x0009:
                    int r0 = r11.what     // Catch:{ all -> 0x0140 }
                    r1 = 0
                    r2 = 0
                    r3 = 1
                    if (r0 == r3) goto L_0x012b
                    r4 = 2
                    r5 = 3
                    if (r0 == r4) goto L_0x00f0
                    if (r0 == r5) goto L_0x0093
                    r6 = 4
                    if (r0 == r6) goto L_0x0069
                    r11 = 5
                    if (r0 == r11) goto L_0x001e
                    goto L_0x013e
                L_0x001e:
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r11 = r11.i     // Catch:{ all -> 0x0140 }
                    if (r11 <= 0) goto L_0x013e
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r11 = r11.h     // Catch:{ all -> 0x0140 }
                    if (r11 <= 0) goto L_0x013e
                    r10.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x0140 }
                    long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    long r6 = r11.j     // Catch:{ all -> 0x0140 }
                    long r0 = r0 - r6
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r11 = r11.i     // Catch:{ all -> 0x0140 }
                    int r11 = r11 * 1000
                    long r6 = (long) r11     // Catch:{ all -> 0x0140 }
                    int r11 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                    if (r11 <= 0) goto L_0x004d
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r0 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r0 = r0.f29240g     // Catch:{ all -> 0x0140 }
                    r11.h = r0     // Catch:{ all -> 0x0140 }
                    r10.sendEmptyMessage(r4)     // Catch:{ all -> 0x0140 }
                    goto L_0x0058
                L_0x004d:
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0140 }
                    r11.f29239f = r0     // Catch:{ all -> 0x0140 }
                    r10.sendEmptyMessage(r5)     // Catch:{ all -> 0x0140 }
                L_0x0058:
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    r11.i = r2     // Catch:{ all -> 0x0140 }
                    java.lang.String r11 = "CICCountDownTicker %s"
                    java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x0140 }
                    java.lang.String r1 = "resume"
                    r0[r2] = r1     // Catch:{ all -> 0x0140 }
                    com.shopee.e.a.a.a(r11, r0)     // Catch:{ all -> 0x0140 }
                    goto L_0x013e
                L_0x0069:
                    com.shopee.live.livestreaming.ui.view.b.a$a r0 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r0 = r0.i     // Catch:{ all -> 0x0140 }
                    if (r0 != 0) goto L_0x013e
                    com.shopee.live.livestreaming.ui.view.b.a$a r0 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r0 = r0.h     // Catch:{ all -> 0x0140 }
                    if (r0 <= 0) goto L_0x013e
                    com.shopee.live.livestreaming.ui.view.b.a$a r0 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r11 = r11.arg1     // Catch:{ all -> 0x0140 }
                    r0.i = r11     // Catch:{ all -> 0x0140 }
                    r10.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0140 }
                    r11.j = r0     // Catch:{ all -> 0x0140 }
                    java.lang.String r11 = "CICCountDownTicker %s"
                    java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x0140 }
                    java.lang.String r1 = "pause"
                    r0[r2] = r1     // Catch:{ all -> 0x0140 }
                    com.shopee.e.a.a.a(r11, r0)     // Catch:{ all -> 0x0140 }
                    goto L_0x013e
                L_0x0093:
                    long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    long r6 = r11.f29239f     // Catch:{ all -> 0x0140 }
                    long r6 = r0 - r6
                    r8 = 1000(0x3e8, double:4.94E-321)
                    int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    if (r11 < 0) goto L_0x00d3
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r4 = r11.h     // Catch:{ all -> 0x0140 }
                    int r4 = r4 - r3
                    r11.h = r4     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    r11.f29239f = r0     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r11 = r11.h     // Catch:{ all -> 0x0140 }
                    r10.a(r11)     // Catch:{ all -> 0x0140 }
                    java.lang.String r11 = "CICCountDownTicker %s"
                    java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x0140 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0140 }
                    r1.<init>()     // Catch:{ all -> 0x0140 }
                    java.lang.String r4 = "tick "
                    r1.append(r4)     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r4 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r4 = r4.h     // Catch:{ all -> 0x0140 }
                    r1.append(r4)     // Catch:{ all -> 0x0140 }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0140 }
                    r0[r2] = r1     // Catch:{ all -> 0x0140 }
                    com.shopee.e.a.a.a(r11, r0)     // Catch:{ all -> 0x0140 }
                L_0x00d3:
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r11 = r11.h     // Catch:{ all -> 0x0140 }
                    if (r11 <= 0) goto L_0x00e1
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    long r0 = r11.f29238e     // Catch:{ all -> 0x0140 }
                    r10.sendEmptyMessageDelayed(r5, r0)     // Catch:{ all -> 0x0140 }
                    goto L_0x013e
                L_0x00e1:
                    r10.c()     // Catch:{ all -> 0x0140 }
                    java.lang.String r11 = "CICCountDownTicker %s"
                    java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x0140 }
                    java.lang.String r1 = "end"
                    r0[r2] = r1     // Catch:{ all -> 0x0140 }
                    com.shopee.e.a.a.a(r11, r0)     // Catch:{ all -> 0x0140 }
                    goto L_0x013e
                L_0x00f0:
                    r10.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0140 }
                    r11.f29239f = r0     // Catch:{ all -> 0x0140 }
                    r10.b()     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r11 = r11.h     // Catch:{ all -> 0x0140 }
                    r10.a(r11)     // Catch:{ all -> 0x0140 }
                    java.lang.String r11 = "CICCountDownTicker %s"
                    java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x0140 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0140 }
                    r1.<init>()     // Catch:{ all -> 0x0140 }
                    java.lang.String r3 = "start "
                    r1.append(r3)     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r3 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    int r3 = r3.h     // Catch:{ all -> 0x0140 }
                    r1.append(r3)     // Catch:{ all -> 0x0140 }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0140 }
                    r0[r2] = r1     // Catch:{ all -> 0x0140 }
                    com.shopee.e.a.a.a(r11, r0)     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    long r0 = r11.f29238e     // Catch:{ all -> 0x0140 }
                    r10.sendEmptyMessageDelayed(r5, r0)     // Catch:{ all -> 0x0140 }
                    goto L_0x013e
                L_0x012b:
                    r10.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x0140 }
                    java.lang.String r11 = "CICCountDownTicker %s"
                    java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x0140 }
                    java.lang.String r1 = "stop"
                    r0[r2] = r1     // Catch:{ all -> 0x0140 }
                    com.shopee.e.a.a.a(r11, r0)     // Catch:{ all -> 0x0140 }
                    com.shopee.live.livestreaming.ui.view.b.a$a r11 = com.shopee.live.livestreaming.ui.view.b.a.C0445a.this     // Catch:{ all -> 0x0140 }
                    r0 = -1
                    r11.h = r0     // Catch:{ all -> 0x0140 }
                L_0x013e:
                    monitor-exit(r10)
                    return
                L_0x0140:
                    r11 = move-exception
                    monitor-exit(r10)
                    throw r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.ui.view.b.a.C0445a.C0446a.handleMessage(android.os.Message):void");
            }

            /* access modifiers changed from: package-private */
            public b a() {
                b bVar = C0445a.this.k != null ? C0445a.this.k : null;
                return bVar == null ? new b() {
                    public void b(int i) {
                    }

                    public void n() {
                    }

                    public void o() {
                    }
                } : bVar;
            }

            /* access modifiers changed from: package-private */
            public void b() {
                f.a().a(new Runnable() {
                    public void run() {
                        C0446a.this.a().n();
                    }
                });
            }

            /* access modifiers changed from: package-private */
            public void a(final int i) {
                f.a().a(new Runnable() {
                    public void run() {
                        C0446a.this.a().b(i);
                    }
                });
            }

            /* access modifiers changed from: package-private */
            public void c() {
                f.a().a(new Runnable() {
                    public void run() {
                        C0446a.this.a().o();
                    }
                });
            }
        }
    }

    public static String d(int i) {
        int i2;
        String str;
        String str2;
        int i3 = 0;
        if (i >= 60) {
            i2 = i / 60;
            i %= 60;
        } else {
            i2 = 0;
        }
        if (i2 >= 60) {
            i3 = i2 / 60;
            i2 %= 60;
        }
        DecimalFormat decimalFormat = new DecimalFormat("00");
        StringBuilder sb = new StringBuilder();
        if (i3 != 0) {
            str = decimalFormat.format((long) i3) + ":";
        } else {
            str = "";
        }
        sb.append(str);
        if (i2 != 0) {
            str2 = decimalFormat.format((long) i2) + ":";
        } else {
            str2 = "00:";
        }
        sb.append(str2);
        sb.append(decimalFormat.format((long) i));
        return sb.toString();
    }
}
