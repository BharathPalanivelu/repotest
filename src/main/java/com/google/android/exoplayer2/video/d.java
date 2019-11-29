package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.WindowManager;

@TargetApi(16)
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f12250a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f12251b;

    /* renamed from: c  reason: collision with root package name */
    private final long f12252c;

    /* renamed from: d  reason: collision with root package name */
    private final long f12253d;

    /* renamed from: e  reason: collision with root package name */
    private long f12254e;

    /* renamed from: f  reason: collision with root package name */
    private long f12255f;

    /* renamed from: g  reason: collision with root package name */
    private long f12256g;
    private boolean h;
    private long i;
    private long j;
    private long k;

    /* access modifiers changed from: protected */
    public void c() {
    }

    public d() {
        this(-1.0d);
    }

    public d(Context context) {
        this(a(context));
    }

    private d(double d2) {
        this.f12251b = d2 != -1.0d;
        if (this.f12251b) {
            this.f12250a = a.a();
            this.f12252c = (long) (1.0E9d / d2);
            this.f12253d = (this.f12252c * 80) / 100;
            return;
        }
        this.f12250a = null;
        this.f12252c = -1;
        this.f12253d = -1;
    }

    public void a() {
        this.h = false;
        if (this.f12251b) {
            this.f12250a.b();
        }
    }

    public void b() {
        if (this.f12251b) {
            this.f12250a.c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(long r11, long r13) {
        /*
            r10 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r11
            boolean r2 = r10.h
            if (r2 == 0) goto L_0x0042
            long r2 = r10.f12254e
            int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0019
            long r2 = r10.k
            r4 = 1
            long r2 = r2 + r4
            r10.k = r2
            long r2 = r10.f12256g
            r10.f12255f = r2
        L_0x0019:
            long r2 = r10.k
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x003a
            long r4 = r10.j
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r10.f12255f
            long r2 = r2 + r4
            boolean r4 = r10.b(r2, r13)
            if (r4 == 0) goto L_0x0033
            r10.h = r6
            goto L_0x0042
        L_0x0033:
            long r4 = r10.i
            long r4 = r4 + r2
            long r6 = r10.j
            long r4 = r4 - r6
            goto L_0x0044
        L_0x003a:
            boolean r2 = r10.b(r0, r13)
            if (r2 == 0) goto L_0x0042
            r10.h = r6
        L_0x0042:
            r4 = r13
            r2 = r0
        L_0x0044:
            boolean r6 = r10.h
            r7 = 0
            if (r6 != 0) goto L_0x0056
            r10.j = r0
            r10.i = r13
            r10.k = r7
            r13 = 1
            r10.h = r13
            r10.c()
        L_0x0056:
            r10.f12254e = r11
            r10.f12256g = r2
            com.google.android.exoplayer2.video.d$a r11 = r10.f12250a
            if (r11 == 0) goto L_0x0073
            long r11 = r11.f12258a
            int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r13 != 0) goto L_0x0065
            goto L_0x0073
        L_0x0065:
            com.google.android.exoplayer2.video.d$a r11 = r10.f12250a
            long r6 = r11.f12258a
            long r8 = r10.f12252c
            long r11 = a(r4, r6, r8)
            long r13 = r10.f12253d
            long r11 = r11 - r13
            return r11
        L_0x0073:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.d.a(long, long):long");
    }

    private boolean b(long j2, long j3) {
        return Math.abs((j3 - this.i) - (j2 - this.j)) > 20000000;
    }

    private static long a(long j2, long j3, long j4) {
        long j5;
        long j6 = j3 + (((j2 - j3) / j4) * j4);
        if (j2 <= j6) {
            j5 = j6 - j4;
        } else {
            long j7 = j6;
            j6 = j4 + j6;
            j5 = j7;
        }
        return j6 - j2 < j2 - j5 ? j6 : j5;
    }

    private static double a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager.getDefaultDisplay() != null) {
            return (double) windowManager.getDefaultDisplay().getRefreshRate();
        }
        return -1.0d;
    }

    private static final class a implements Handler.Callback, Choreographer.FrameCallback {

        /* renamed from: b  reason: collision with root package name */
        private static final a f12257b = new a();

        /* renamed from: a  reason: collision with root package name */
        public volatile long f12258a;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f12259c;

        /* renamed from: d  reason: collision with root package name */
        private final HandlerThread f12260d = new HandlerThread("ChoreographerOwner:Handler");

        /* renamed from: e  reason: collision with root package name */
        private Choreographer f12261e;

        /* renamed from: f  reason: collision with root package name */
        private int f12262f;

        public static a a() {
            return f12257b;
        }

        private a() {
            this.f12260d.start();
            this.f12259c = new Handler(this.f12260d.getLooper(), this);
            this.f12259c.sendEmptyMessage(0);
        }

        public void b() {
            this.f12259c.sendEmptyMessage(1);
        }

        public void c() {
            this.f12259c.sendEmptyMessage(2);
        }

        public void doFrame(long j) {
            this.f12258a = j;
            this.f12261e.postFrameCallbackDelayed(this, 500);
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                d();
                return true;
            } else if (i == 1) {
                e();
                return true;
            } else if (i != 2) {
                return false;
            } else {
                f();
                return true;
            }
        }

        private void d() {
            this.f12261e = Choreographer.getInstance();
        }

        private void e() {
            this.f12262f++;
            if (this.f12262f == 1) {
                this.f12261e.postFrameCallback(this);
            }
        }

        private void f() {
            this.f12262f--;
            if (this.f12262f == 0) {
                this.f12261e.removeFrameCallback(this);
                this.f12258a = 0;
            }
        }
    }
}
