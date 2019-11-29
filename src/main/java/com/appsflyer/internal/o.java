package com.appsflyer.internal;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class o {

    /* renamed from: ˊ  reason: contains not printable characters */
    static final BitSet f208 = new BitSet(6);

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private static volatile o f209;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static final Handler f210 = new Handler(Looper.getMainLooper());

    /* renamed from: ʻ  reason: contains not printable characters */
    public final Runnable f211 = new Runnable() {
        public final void run() {
            synchronized (o.this.f218) {
                if (o.this.f220) {
                    o.this.f217.removeCallbacks(o.this.f213);
                    o.this.f217.removeCallbacks(o.this.f219);
                    o.this.m171();
                    o.this.f220 = false;
                }
            }
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    boolean f212;

    /* renamed from: ʽ  reason: contains not printable characters */
    public final Runnable f213 = new Runnable() {
        /* JADX WARNING: Can't wrap try/catch for region: R(9:2|3|4|5|6|(5:9|(1:14)(1:13)|(4:16|(1:18)|19|29)(1:28)|27|7)|20|21|22) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0052 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r8 = this;
                com.appsflyer.internal.o r0 = com.appsflyer.internal.o.this
                java.lang.Object r0 = r0.f218
                monitor-enter(r0)
                com.appsflyer.internal.o r1 = com.appsflyer.internal.o.this     // Catch:{ all -> 0x0067 }
                r2 = 1
                android.hardware.SensorManager r3 = r1.f214     // Catch:{ Throwable -> 0x0052 }
                r4 = -1
                java.util.List r3 = r3.getSensorList(r4)     // Catch:{ Throwable -> 0x0052 }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ Throwable -> 0x0052 }
            L_0x0013:
                boolean r4 = r3.hasNext()     // Catch:{ Throwable -> 0x0052 }
                if (r4 == 0) goto L_0x0052
                java.lang.Object r4 = r3.next()     // Catch:{ Throwable -> 0x0052 }
                android.hardware.Sensor r4 = (android.hardware.Sensor) r4     // Catch:{ Throwable -> 0x0052 }
                int r5 = r4.getType()     // Catch:{ Throwable -> 0x0052 }
                r6 = 0
                if (r5 < 0) goto L_0x0030
                java.util.BitSet r7 = com.appsflyer.internal.o.f208     // Catch:{ Throwable -> 0x0052 }
                boolean r5 = r7.get(r5)     // Catch:{ Throwable -> 0x0052 }
                if (r5 == 0) goto L_0x0030
                r5 = 1
                goto L_0x0031
            L_0x0030:
                r5 = 0
            L_0x0031:
                if (r5 == 0) goto L_0x0013
                com.appsflyer.internal.k r5 = com.appsflyer.internal.k.m157(r4)     // Catch:{ Throwable -> 0x0052 }
                java.util.Map<com.appsflyer.internal.k, com.appsflyer.internal.k> r7 = r1.f216     // Catch:{ Throwable -> 0x0052 }
                boolean r7 = r7.containsKey(r5)     // Catch:{ Throwable -> 0x0052 }
                if (r7 != 0) goto L_0x0044
                java.util.Map<com.appsflyer.internal.k, com.appsflyer.internal.k> r7 = r1.f216     // Catch:{ Throwable -> 0x0052 }
                r7.put(r5, r5)     // Catch:{ Throwable -> 0x0052 }
            L_0x0044:
                java.util.Map<com.appsflyer.internal.k, com.appsflyer.internal.k> r7 = r1.f216     // Catch:{ Throwable -> 0x0052 }
                java.lang.Object r5 = r7.get(r5)     // Catch:{ Throwable -> 0x0052 }
                android.hardware.SensorEventListener r5 = (android.hardware.SensorEventListener) r5     // Catch:{ Throwable -> 0x0052 }
                android.hardware.SensorManager r7 = r1.f214     // Catch:{ Throwable -> 0x0052 }
                r7.registerListener(r5, r4, r6)     // Catch:{ Throwable -> 0x0052 }
                goto L_0x0013
            L_0x0052:
                r1.f212 = r2     // Catch:{ all -> 0x0067 }
                com.appsflyer.internal.o r1 = com.appsflyer.internal.o.this     // Catch:{ all -> 0x0067 }
                android.os.Handler r1 = r1.f217     // Catch:{ all -> 0x0067 }
                com.appsflyer.internal.o r3 = com.appsflyer.internal.o.this     // Catch:{ all -> 0x0067 }
                java.lang.Runnable r3 = r3.f219     // Catch:{ all -> 0x0067 }
                r4 = 500(0x1f4, double:2.47E-321)
                r1.postDelayed(r3, r4)     // Catch:{ all -> 0x0067 }
                com.appsflyer.internal.o r1 = com.appsflyer.internal.o.this     // Catch:{ all -> 0x0067 }
                r1.f220 = r2     // Catch:{ all -> 0x0067 }
                monitor-exit(r0)     // Catch:{ all -> 0x0067 }
                return
            L_0x0067:
                r1 = move-exception
                monitor-exit(r0)
                goto L_0x006b
            L_0x006a:
                throw r1
            L_0x006b:
                goto L_0x006a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.o.AnonymousClass2.run():void");
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    final SensorManager f214;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final Map<k, Map<String, Object>> f215 = new HashMap(f208.size());

    /* renamed from: ˎ  reason: contains not printable characters */
    final Map<k, k> f216 = new HashMap(f208.size());

    /* renamed from: ˏ  reason: contains not printable characters */
    public final Handler f217;

    /* renamed from: ॱ  reason: contains not printable characters */
    final Object f218 = new Object();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    final Runnable f219 = new Runnable() {
        public final void run() {
            synchronized (o.this.f218) {
                o.this.m171();
                o.this.f217.postDelayed(o.this.f213, 1800000);
            }
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    boolean f220;

    static {
        f208.set(1);
        f208.set(2);
        f208.set(4);
    }

    private o(SensorManager sensorManager, Handler handler) {
        this.f214 = sensorManager;
        this.f217 = handler;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static o m168(Context context) {
        return m169((SensorManager) context.getApplicationContext().getSystemService("sensor"), f210);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static o m169(SensorManager sensorManager, Handler handler) {
        if (f209 == null) {
            synchronized (o.class) {
                if (f209 == null) {
                    f209 = new o(sensorManager, handler);
                }
            }
        }
        return f209;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m171() {
        try {
            if (!this.f216.isEmpty()) {
                for (k next : this.f216.values()) {
                    this.f214.unregisterListener(next);
                    next.m159(this.f215, true);
                }
            }
        } catch (Throwable unused) {
        }
        this.f212 = false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final List<Map<String, Object>> m170() {
        synchronized (this.f218) {
            if (!this.f216.isEmpty() && this.f212) {
                for (k r2 : this.f216.values()) {
                    r2.m159(this.f215, false);
                }
            }
            if (this.f215.isEmpty()) {
                List<Map<String, Object>> emptyList = Collections.emptyList();
                return emptyList;
            }
            ArrayList arrayList = new ArrayList(this.f215.values());
            return arrayList;
        }
    }
}
