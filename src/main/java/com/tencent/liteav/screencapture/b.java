package com.tencent.liteav.screencapture;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.rtmp.video.TXScreenCapture;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import tencent.tls.platform.SigType;

@TargetApi(21)
public class b {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f31985b = "b";

    /* renamed from: c  reason: collision with root package name */
    private static b f31986c = new b();

    /* renamed from: a  reason: collision with root package name */
    MediaProjection.Callback f31987a;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public HashMap<Surface, VirtualDisplay> f31988d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f31989e;

    /* renamed from: f  reason: collision with root package name */
    private MediaProjectionManager f31990f;

    /* renamed from: g  reason: collision with root package name */
    private MediaProjection f31991g;
    private HashSet<C0492b> h;
    private int i;
    private Handler j;
    private HashSet<Object> k;
    /* access modifiers changed from: private */
    public boolean l;
    /* access modifiers changed from: private */
    public WeakReference<com.tencent.liteav.basic.c.a> m;
    private HandlerThread n;
    private Handler o;
    /* access modifiers changed from: private */
    public int p;
    /* access modifiers changed from: private */
    public HashSet<a> q;
    private Runnable r;
    private BroadcastReceiver s;

    public interface a {
        void a(int i);
    }

    private b() {
        this.f31988d = new HashMap<>();
        this.f31989e = null;
        this.f31990f = null;
        this.f31991g = null;
        this.h = new HashSet<>();
        this.i = 1;
        this.j = null;
        this.k = new HashSet<>();
        this.l = false;
        this.m = null;
        this.n = new HandlerThread("TXCScreenCaptureImplSingleton");
        this.o = null;
        this.p = 0;
        this.q = new HashSet<>();
        this.r = new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
                if (r0 != 2) goto L_0x002d;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
                if (com.tencent.liteav.screencapture.b.c(r4.f31992a) == 90) goto L_0x0075;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
                r0 = com.tencent.liteav.screencapture.b.c();
                com.tencent.liteav.basic.log.TXCLog.d(r0, "ORIENTATION_LANDSCAPE, mDelegateSet size = " + com.tencent.liteav.screencapture.b.d(r4.f31992a).size());
                r0 = com.tencent.liteav.screencapture.b.d(r4.f31992a).iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
                if (r0.hasNext() == false) goto L_0x0075;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
                r2 = (com.tencent.liteav.screencapture.b.a) r0.next();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x006f, code lost:
                if (r2 == null) goto L_0x0063;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
                r2.a(90);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0075, code lost:
                com.tencent.liteav.screencapture.b.a(r4.f31992a, 90);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x007a, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
                if (com.tencent.liteav.screencapture.b.c(r4.f31992a) == 0) goto L_0x00c2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
                r0 = com.tencent.liteav.screencapture.b.c();
                com.tencent.liteav.basic.log.TXCLog.d(r0, "ORIENTATION_PORTRAIT, mDelegateSet size = " + com.tencent.liteav.screencapture.b.d(r4.f31992a).size());
                r0 = com.tencent.liteav.screencapture.b.d(r4.f31992a).iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b4, code lost:
                if (r0.hasNext() == false) goto L_0x00c2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b6, code lost:
                r2 = (com.tencent.liteav.screencapture.b.a) r0.next();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bc, code lost:
                if (r2 == null) goto L_0x00b0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x00be, code lost:
                r2.a(0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c2, code lost:
                com.tencent.liteav.screencapture.b.a(r4.f31992a, 0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c7, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
                if (r0 == 0) goto L_0x007b;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.tencent.liteav.screencapture.b r0 = com.tencent.liteav.screencapture.b.this
                    r0.f()
                    monitor-enter(r4)
                    com.tencent.liteav.screencapture.b r0 = com.tencent.liteav.screencapture.b.this     // Catch:{ all -> 0x00c8 }
                    android.content.Context r0 = r0.f31989e     // Catch:{ all -> 0x00c8 }
                    if (r0 != 0) goto L_0x0010
                    monitor-exit(r4)     // Catch:{ all -> 0x00c8 }
                    return
                L_0x0010:
                    com.tencent.liteav.screencapture.b r0 = com.tencent.liteav.screencapture.b.this     // Catch:{ all -> 0x00c8 }
                    android.content.Context r0 = r0.f31989e     // Catch:{ all -> 0x00c8 }
                    java.lang.String r1 = "window"
                    java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x00c8 }
                    android.view.WindowManager r0 = (android.view.WindowManager) r0     // Catch:{ all -> 0x00c8 }
                    android.view.Display r0 = r0.getDefaultDisplay()     // Catch:{ all -> 0x00c8 }
                    int r0 = r0.getRotation()     // Catch:{ all -> 0x00c8 }
                    monitor-exit(r4)     // Catch:{ all -> 0x00c8 }
                    if (r0 == 0) goto L_0x007b
                    r1 = 2
                    if (r0 != r1) goto L_0x002d
                    goto L_0x007b
                L_0x002d:
                    com.tencent.liteav.screencapture.b r0 = com.tencent.liteav.screencapture.b.this
                    int r0 = r0.p
                    r1 = 90
                    if (r0 == r1) goto L_0x0075
                    java.lang.String r0 = com.tencent.liteav.screencapture.b.f31985b
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "ORIENTATION_LANDSCAPE, mDelegateSet size = "
                    r2.append(r3)
                    com.tencent.liteav.screencapture.b r3 = com.tencent.liteav.screencapture.b.this
                    java.util.HashSet r3 = r3.q
                    int r3 = r3.size()
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    com.tencent.liteav.basic.log.TXCLog.d(r0, r2)
                    com.tencent.liteav.screencapture.b r0 = com.tencent.liteav.screencapture.b.this
                    java.util.HashSet r0 = r0.q
                    java.util.Iterator r0 = r0.iterator()
                L_0x0063:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto L_0x0075
                    java.lang.Object r2 = r0.next()
                    com.tencent.liteav.screencapture.b$a r2 = (com.tencent.liteav.screencapture.b.a) r2
                    if (r2 == 0) goto L_0x0063
                    r2.a(r1)
                    goto L_0x0063
                L_0x0075:
                    com.tencent.liteav.screencapture.b r0 = com.tencent.liteav.screencapture.b.this
                    int unused = r0.p = r1
                    return
                L_0x007b:
                    com.tencent.liteav.screencapture.b r0 = com.tencent.liteav.screencapture.b.this
                    int r0 = r0.p
                    r1 = 0
                    if (r0 == 0) goto L_0x00c2
                    java.lang.String r0 = com.tencent.liteav.screencapture.b.f31985b
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "ORIENTATION_PORTRAIT, mDelegateSet size = "
                    r2.append(r3)
                    com.tencent.liteav.screencapture.b r3 = com.tencent.liteav.screencapture.b.this
                    java.util.HashSet r3 = r3.q
                    int r3 = r3.size()
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    com.tencent.liteav.basic.log.TXCLog.d(r0, r2)
                    com.tencent.liteav.screencapture.b r0 = com.tencent.liteav.screencapture.b.this
                    java.util.HashSet r0 = r0.q
                    java.util.Iterator r0 = r0.iterator()
                L_0x00b0:
                    boolean r2 = r0.hasNext()
                    if (r2 == 0) goto L_0x00c2
                    java.lang.Object r2 = r0.next()
                    com.tencent.liteav.screencapture.b$a r2 = (com.tencent.liteav.screencapture.b.a) r2
                    if (r2 == 0) goto L_0x00b0
                    r2.a(r1)
                    goto L_0x00b0
                L_0x00c2:
                    com.tencent.liteav.screencapture.b r0 = com.tencent.liteav.screencapture.b.this
                    int unused = r0.p = r1
                    return
                L_0x00c8:
                    r0 = move-exception
                    monitor-exit(r4)     // Catch:{ all -> 0x00c8 }
                    goto L_0x00cc
                L_0x00cb:
                    throw r0
                L_0x00cc:
                    goto L_0x00cb
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.screencapture.b.AnonymousClass1.run():void");
            }
        };
        this.f31987a = new MediaProjection.Callback() {
            public void onStop() {
                if (b.this.l) {
                    boolean unused = b.this.l = false;
                }
            }
        };
        this.s = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (intent != null && intent.getAction().equalsIgnoreCase("TXScreenCapture.OnAssistantActivityResult")) {
                    b.this.a(intent.getIntExtra("TXScreenCapture.RequestCode", 0), intent.getIntExtra("TXScreenCapture.ResultCode", 0), (Intent) intent.getParcelableExtra("TXScreenCapture.ResultData"));
                }
            }
        };
        this.j = new Handler(Looper.getMainLooper());
        this.n.start();
        this.o = new Handler(this.n.getLooper());
    }

    public static b a() {
        return f31986c;
    }

    public void a(com.tencent.liteav.basic.c.a aVar) {
        if (aVar == null) {
            this.m = null;
        } else {
            this.m = new WeakReference<>(aVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.Context r0 = r1.f31989e     // Catch:{ all -> 0x0025 }
            if (r0 == r2) goto L_0x0023
            r1.b()     // Catch:{ all -> 0x0025 }
            r0 = 0
            r1.f31990f = r0     // Catch:{ all -> 0x0025 }
            r1.f31989e = r2     // Catch:{ all -> 0x0025 }
            android.content.Context r2 = r1.f31989e     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x0013
            monitor-exit(r1)     // Catch:{ all -> 0x0025 }
            return
        L_0x0013:
            android.media.projection.MediaProjectionManager r2 = r1.f31990f     // Catch:{ all -> 0x0025 }
            if (r2 != 0) goto L_0x0023
            android.content.Context r2 = r1.f31989e     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = "media_projection"
            java.lang.Object r2 = r2.getSystemService(r0)     // Catch:{ all -> 0x0025 }
            android.media.projection.MediaProjectionManager r2 = (android.media.projection.MediaProjectionManager) r2     // Catch:{ all -> 0x0025 }
            r1.f31990f = r2     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r1)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0025 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.screencapture.b.a(android.content.Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[Catch:{ Exception -> 0x004a }] */
    @android.annotation.TargetApi(21)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.Surface r13, int r14, int r15) {
        /*
            r12 = this;
            monitor-enter(r12)
            r0 = 0
            int r1 = r12.i     // Catch:{ Exception -> 0x004a }
            r2 = 3
            if (r1 == r2) goto L_0x0024
            int r1 = r12.i     // Catch:{ Exception -> 0x004a }
            r3 = 4
            if (r1 != r3) goto L_0x000d
            goto L_0x0024
        L_0x000d:
            com.tencent.liteav.screencapture.b$b r1 = new com.tencent.liteav.screencapture.b$b     // Catch:{ Exception -> 0x004a }
            r2 = 0
            r1.<init>()     // Catch:{ Exception -> 0x004a }
            r1.f32003c = r15     // Catch:{ Exception -> 0x004a }
            r1.f32002b = r14     // Catch:{ Exception -> 0x004a }
            r1.f32001a = r13     // Catch:{ Exception -> 0x004a }
            java.util.HashSet<com.tencent.liteav.screencapture.b$b> r13 = r12.h     // Catch:{ Exception -> 0x004a }
            r13.add(r1)     // Catch:{ Exception -> 0x004a }
            boolean r13 = r12.h()     // Catch:{ Exception -> 0x004a }
            r0 = r13
            goto L_0x004e
        L_0x0024:
            android.media.projection.MediaProjection r1 = r12.f31991g     // Catch:{ Exception -> 0x004a }
            android.media.projection.MediaProjection r1 = r12.f31991g     // Catch:{ Exception -> 0x004a }
            if (r1 == 0) goto L_0x004e
            r1 = 1
            r12.l = r1     // Catch:{ Exception -> 0x004a }
            android.media.projection.MediaProjection r3 = r12.f31991g     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = "TXCScreenCapture"
            r7 = 1
            r8 = 1
            r10 = 0
            r11 = 0
            r5 = r14
            r6 = r15
            r9 = r13
            android.hardware.display.VirtualDisplay r14 = r3.createVirtualDisplay(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x004a }
            if (r14 != 0) goto L_0x003f
            goto L_0x004e
        L_0x003f:
            r12.i = r2     // Catch:{ Exception -> 0x004a }
            java.util.HashMap<android.view.Surface, android.hardware.display.VirtualDisplay> r15 = r12.f31988d     // Catch:{ Exception -> 0x004a }
            r15.put(r13, r14)     // Catch:{ Exception -> 0x004a }
            r0 = 1
            goto L_0x004e
        L_0x0048:
            r13 = move-exception
            goto L_0x005b
        L_0x004a:
            r13 = move-exception
            r13.printStackTrace()     // Catch:{ all -> 0x0048 }
        L_0x004e:
            if (r0 != 0) goto L_0x0059
            java.lang.ref.WeakReference<com.tencent.liteav.basic.c.a> r13 = r12.m     // Catch:{ all -> 0x0048 }
            r14 = -1308(0xfffffffffffffae4, float:NaN)
            java.lang.String r15 = "录屏失败"
            com.tencent.liteav.basic.util.b.a((java.lang.ref.WeakReference<com.tencent.liteav.basic.c.a>) r13, (int) r14, (java.lang.String) r15)     // Catch:{ all -> 0x0048 }
        L_0x0059:
            monitor-exit(r12)     // Catch:{ all -> 0x0048 }
            return r0
        L_0x005b:
            monitor-exit(r12)     // Catch:{ all -> 0x0048 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.screencapture.b.a(android.view.Surface, int, int):boolean");
    }

    public void a(Surface surface) {
        synchronized (this) {
            Iterator<C0492b> it = this.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0492b next = it.next();
                if (!(next == null || next.f32001a == null || next.f32002b == 0)) {
                    if (next.f32003c != 0) {
                        if (next.f32001a == surface) {
                            this.h.remove(next);
                            break;
                        }
                    }
                }
            }
            if (this.f31988d.containsKey(surface)) {
                this.f31988d.get(surface).release();
                this.f31988d.remove(surface);
                d();
            }
        }
    }

    public void b() {
        synchronized (this) {
            e();
        }
    }

    private void d() {
        this.i = 4;
        this.j.postDelayed(new Runnable() {
            public void run() {
                synchronized (b.this) {
                    if (b.this.f31988d.size() == 0) {
                        b.this.i();
                    }
                }
            }
        }, 1000);
    }

    private void e() {
        for (VirtualDisplay next : this.f31988d.values()) {
            if (next != null) {
                next.release();
            }
        }
        this.f31988d.clear();
        this.k.clear();
        i();
    }

    /* access modifiers changed from: private */
    public void f() {
        this.o.postDelayed(this.r, 50);
    }

    private void g() {
        this.o.removeCallbacks(this.r);
    }

    public void a(final a aVar) {
        this.j.post(new Runnable() {
            public void run() {
                b.this.q.add(aVar);
            }
        });
    }

    public void b(final a aVar) {
        this.j.post(new Runnable() {
            public void run() {
                b.this.q.remove(aVar);
            }
        });
    }

    @TargetApi(21)
    private boolean h() {
        if (this.i != 1) {
            return true;
        }
        if (this.f31989e == null || this.f31990f == null) {
            return false;
        }
        f();
        this.i = 2;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("TXScreenCapture.OnAssistantActivityResult");
        this.f31989e.registerReceiver(this.s, intentFilter);
        Intent intent = new Intent(this.f31989e, TXScreenCapture.TXScreenCaptureAssistantActivity.class);
        intent.addFlags(SigType.TLS);
        intent.putExtra("TXScreenCapture.ScreenCaptureIntent", this.f31990f.createScreenCaptureIntent());
        this.f31989e.startActivity(intent);
        return true;
    }

    /* access modifiers changed from: private */
    @TargetApi(21)
    public void i() {
        if (this.k.isEmpty()) {
            this.l = false;
            MediaProjection mediaProjection = this.f31991g;
            if (mediaProjection != null) {
                mediaProjection.stop();
                this.f31991g.unregisterCallback(this.f31987a);
            }
            try {
                if (this.f31989e != null) {
                    this.f31989e.unregisterReceiver(this.s);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f31991g = null;
            this.i = 1;
            g();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009e, code lost:
        if (r11.m == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a0, code lost:
        new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.tencent.liteav.screencapture.b.AnonymousClass6(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    @android.annotation.TargetApi(21)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r12, int r13, android.content.Intent r14) {
        /*
            r11 = this;
            r0 = -1308(0xfffffffffffffae4, float:NaN)
            r1 = 1
            monitor-enter(r11)     // Catch:{ Exception -> 0x00bf }
            android.content.Context r2 = r11.f31989e     // Catch:{ Exception -> 0x0013 }
            if (r2 == 0) goto L_0x0017
            android.content.Context r2 = r11.f31989e     // Catch:{ Exception -> 0x0013 }
            android.content.BroadcastReceiver r3 = r11.s     // Catch:{ Exception -> 0x0013 }
            r2.unregisterReceiver(r3)     // Catch:{ Exception -> 0x0013 }
            goto L_0x0017
        L_0x0010:
            r12 = move-exception
            goto L_0x00bd
        L_0x0013:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x0010 }
        L_0x0017:
            r2 = 1001(0x3e9, float:1.403E-42)
            if (r12 != r2) goto L_0x00b2
            r12 = -1
            if (r13 != r12) goto L_0x00b2
            int r12 = r11.i     // Catch:{ all -> 0x0010 }
            r2 = 2
            if (r12 == r2) goto L_0x0025
            goto L_0x00b2
        L_0x0025:
            android.media.projection.MediaProjectionManager r12 = r11.f31990f     // Catch:{ all -> 0x0010 }
            android.media.projection.MediaProjection r12 = r12.getMediaProjection(r13, r14)     // Catch:{ all -> 0x0010 }
            r11.f31991g = r12     // Catch:{ all -> 0x0010 }
            android.media.projection.MediaProjection r12 = r11.f31991g     // Catch:{ all -> 0x0010 }
            android.media.projection.MediaProjection$Callback r13 = r11.f31987a     // Catch:{ all -> 0x0010 }
            android.os.Handler r14 = r11.j     // Catch:{ all -> 0x0010 }
            r12.registerCallback(r13, r14)     // Catch:{ all -> 0x0010 }
            r11.l = r1     // Catch:{ all -> 0x0010 }
            java.util.HashSet<com.tencent.liteav.screencapture.b$b> r12 = r11.h     // Catch:{ all -> 0x0010 }
            int r12 = r12.size()     // Catch:{ all -> 0x0010 }
            if (r12 != 0) goto L_0x004b
            java.lang.ref.WeakReference<com.tencent.liteav.basic.c.a> r12 = r11.m     // Catch:{ all -> 0x0010 }
            java.lang.String r13 = "录屏失败"
            com.tencent.liteav.basic.util.b.a((java.lang.ref.WeakReference<com.tencent.liteav.basic.c.a>) r12, (int) r0, (java.lang.String) r13)     // Catch:{ all -> 0x0010 }
            r11.i = r1     // Catch:{ all -> 0x0010 }
            monitor-exit(r11)     // Catch:{ all -> 0x0010 }
            return
        L_0x004b:
            java.util.HashSet<com.tencent.liteav.screencapture.b$b> r12 = r11.h     // Catch:{ all -> 0x0010 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x0010 }
        L_0x0051:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0010 }
            if (r13 == 0) goto L_0x0093
            java.lang.Object r13 = r12.next()     // Catch:{ all -> 0x0010 }
            com.tencent.liteav.screencapture.b$b r13 = (com.tencent.liteav.screencapture.b.C0492b) r13     // Catch:{ all -> 0x0010 }
            if (r13 == 0) goto L_0x0051
            android.view.Surface r14 = r13.f32001a     // Catch:{ all -> 0x0010 }
            if (r14 == 0) goto L_0x0051
            int r14 = r13.f32002b     // Catch:{ all -> 0x0010 }
            if (r14 == 0) goto L_0x0051
            int r14 = r13.f32003c     // Catch:{ all -> 0x0010 }
            if (r14 != 0) goto L_0x006c
            goto L_0x0051
        L_0x006c:
            android.media.projection.MediaProjection r2 = r11.f31991g     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = "TXCScreenCapture"
            int r4 = r13.f32002b     // Catch:{ all -> 0x0010 }
            int r5 = r13.f32003c     // Catch:{ all -> 0x0010 }
            r6 = 1
            r7 = 1
            android.view.Surface r8 = r13.f32001a     // Catch:{ all -> 0x0010 }
            r9 = 0
            r10 = 0
            android.hardware.display.VirtualDisplay r14 = r2.createVirtualDisplay(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0010 }
            if (r14 != 0) goto L_0x008b
            java.lang.ref.WeakReference<com.tencent.liteav.basic.c.a> r12 = r11.m     // Catch:{ all -> 0x0010 }
            java.lang.String r13 = "录屏失败"
            com.tencent.liteav.basic.util.b.a((java.lang.ref.WeakReference<com.tencent.liteav.basic.c.a>) r12, (int) r0, (java.lang.String) r13)     // Catch:{ all -> 0x0010 }
            r11.i = r1     // Catch:{ all -> 0x0010 }
            monitor-exit(r11)     // Catch:{ all -> 0x0010 }
            return
        L_0x008b:
            java.util.HashMap<android.view.Surface, android.hardware.display.VirtualDisplay> r2 = r11.f31988d     // Catch:{ all -> 0x0010 }
            android.view.Surface r13 = r13.f32001a     // Catch:{ all -> 0x0010 }
            r2.put(r13, r14)     // Catch:{ all -> 0x0010 }
            goto L_0x0051
        L_0x0093:
            java.util.HashSet<com.tencent.liteav.screencapture.b$b> r12 = r11.h     // Catch:{ all -> 0x0010 }
            r12.clear()     // Catch:{ all -> 0x0010 }
            r12 = 3
            r11.i = r12     // Catch:{ all -> 0x0010 }
            monitor-exit(r11)     // Catch:{ all -> 0x0010 }
            java.lang.ref.WeakReference<com.tencent.liteav.basic.c.a> r12 = r11.m
            if (r12 == 0) goto L_0x00b1
            android.os.Handler r12 = new android.os.Handler
            android.os.Looper r13 = android.os.Looper.getMainLooper()
            r12.<init>(r13)
            com.tencent.liteav.screencapture.b$6 r13 = new com.tencent.liteav.screencapture.b$6
            r13.<init>()
            r12.post(r13)
        L_0x00b1:
            return
        L_0x00b2:
            r11.i = r1     // Catch:{ all -> 0x0010 }
            java.lang.ref.WeakReference<com.tencent.liteav.basic.c.a> r12 = r11.m     // Catch:{ all -> 0x0010 }
            java.lang.String r13 = "录屏失败"
            com.tencent.liteav.basic.util.b.a((java.lang.ref.WeakReference<com.tencent.liteav.basic.c.a>) r12, (int) r0, (java.lang.String) r13)     // Catch:{ all -> 0x0010 }
            monitor-exit(r11)     // Catch:{ all -> 0x0010 }
            return
        L_0x00bd:
            monitor-exit(r11)     // Catch:{ all -> 0x0010 }
            throw r12     // Catch:{ Exception -> 0x00bf }
        L_0x00bf:
            r12 = move-exception
            r12.printStackTrace()
            r11.i = r1
            java.lang.ref.WeakReference<com.tencent.liteav.basic.c.a> r12 = r11.m
            java.lang.String r13 = "录屏失败"
            com.tencent.liteav.basic.util.b.a((java.lang.ref.WeakReference<com.tencent.liteav.basic.c.a>) r12, (int) r0, (java.lang.String) r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.screencapture.b.a(int, int, android.content.Intent):void");
    }

    /* renamed from: com.tencent.liteav.screencapture.b$b  reason: collision with other inner class name */
    private class C0492b {

        /* renamed from: a  reason: collision with root package name */
        Surface f32001a;

        /* renamed from: b  reason: collision with root package name */
        int f32002b;

        /* renamed from: c  reason: collision with root package name */
        int f32003c;

        private C0492b() {
        }
    }
}
