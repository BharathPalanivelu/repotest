package com.modiface.mfemakeupkit.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.data.MFEFaceTrackingParameters;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.u;
import com.modiface.mfemakeupkit.utils.x;
import com.modiface.mfemakeupkit.utils.y;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15213a = "MFEFaceTrackingEngine";

    /* renamed from: b  reason: collision with root package name */
    private static final String f15214b = "MFEFaceTrackingThread";

    /* renamed from: c  reason: collision with root package name */
    private static final String f15215c = "MFE Face Tracking Engine";

    /* renamed from: d  reason: collision with root package name */
    private static final String f15216d = "Face Tracker Initialization";

    /* renamed from: e  reason: collision with root package name */
    private static final String f15217e = "Face Tracker Load Resources";

    /* renamed from: f  reason: collision with root package name */
    private static final String f15218f = "Face Tracking";

    /* renamed from: g  reason: collision with root package name */
    private static final String f15219g = "MFEFaceTrackerBundle";
    private static final String h = "MFEFaceTrackerLiteBundle";
    private static j i;
    /* access modifiers changed from: private */
    public final com.modiface.mfemakeupkit.mfea.b j = new com.modiface.mfemakeupkit.mfea.b();
    private final x k;
    /* access modifiers changed from: private */
    public HashMap<Object, AtomicReference<u>> l = new HashMap<>();
    /* access modifiers changed from: private */
    public final MFEDebugInfo m = new MFEDebugInfo(f15215c);
    private y n = new y();
    private double o = 0.0d;
    /* access modifiers changed from: private */
    public AtomicBoolean p = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final String q;
    /* access modifiers changed from: private */
    public final MFEMakeupEngine.Region r;
    /* access modifiers changed from: private */
    public String s = null;
    /* access modifiers changed from: private */
    public boolean t = false;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();
    }

    public interface d {
        void a(u uVar);
    }

    private j(Context context, MFEMakeupEngine.Region region) {
        if (context != null) {
            this.q = context.getPackageName();
            this.r = region;
            this.k = new x(f15214b);
            this.k.a((Runnable) new a(this));
            return;
        }
        throw new IllegalArgumentException("cannot pass in null context to MFEFaceTrackingEngine constructor");
    }

    public void finalize() throws Throwable {
        e();
        super.finalize();
    }

    private void e() {
        this.k.b(new f(this));
        this.k.a();
    }

    public boolean b() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.k.b(new e(this, atomicBoolean), true);
        return atomicBoolean.get();
    }

    public void c() {
        if (!this.p.get()) {
            this.p.set(true);
            this.k.b(new i(this));
        }
    }

    public void d() {
        this.p.set(false);
    }

    public static synchronized j a(Context context, MFEMakeupEngine.Region region) {
        j jVar;
        synchronized (j.class) {
            if (context != null) {
                if (i == null) {
                    i = new j(context, region);
                }
                jVar = i;
            } else {
                throw new IllegalArgumentException("context cannot be null when getting singleton instance of MFEAndroidCamera");
            }
        }
        return jVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r2.length > 0) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r5, com.modiface.mfemakeupkit.a.j.c r6) {
        /*
            r4 = this;
            java.lang.String r0 = "MFEFaceTrackerBundle"
            if (r5 == 0) goto L_0x0043
            r1 = 0
            android.content.res.AssetManager r2 = r5.getAssets()     // Catch:{ IOException -> 0x0013 }
            java.lang.String[] r2 = r2.list(r0)     // Catch:{ IOException -> 0x0013 }
            if (r2 == 0) goto L_0x0013
            int r2 = r2.length     // Catch:{ IOException -> 0x0013 }
            if (r2 <= 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r3 = "MFEFaceTrackerLiteBundle"
            if (r2 == 0) goto L_0x002c
            android.content.res.AssetManager r2 = r5.getAssets()     // Catch:{ IOException -> 0x002b }
            java.lang.String[] r2 = r2.list(r3)     // Catch:{ IOException -> 0x002b }
            if (r2 == 0) goto L_0x002c
            int r1 = r2.length     // Catch:{ IOException -> 0x002b }
            if (r1 <= 0) goto L_0x002c
            r0 = r3
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x003b
            r1 = 1
            java.lang.String r5 = com.modiface.mfemakeupkit.utils.a.a(r5, r0, r0, r1)
            r4.a((java.lang.String) r5, (com.modiface.mfemakeupkit.a.j.c) r6)
            return
        L_0x003b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "failed to obtain assets for face tracker"
            r5.<init>(r6)
            throw r5
        L_0x0043:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "cannot pass in null context to MFEFaceTrackingEngine constructor"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.a.j.a(android.content.Context, com.modiface.mfemakeupkit.a.j$c):void");
    }

    public void a(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                throw new IllegalStateException("path to face tracker bundle does not exist or is not a directory");
            }
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                throw new IllegalStateException("face tracker bundle must not be empty");
            }
            String name = file.getName();
            boolean equals = TextUtils.equals(name, f15219g);
            boolean equals2 = TextUtils.equals(name, h);
            if (equals || equals2) {
                this.k.a((Runnable) new b(this, str, equals2, cVar));
                return;
            }
            throw new IllegalStateException("face tracker bundle must point to a \"MFEFaceTrackerBundle\" or \"MFEFaceTrackerLiteBundle\" folder");
        }
        throw new IllegalArgumentException("path to face tracker bundle cannot be null");
    }

    public void a(a aVar) {
        if (!this.k.a((Runnable) new c(this, aVar)) && aVar != null) {
            aVar.a();
        }
    }

    public void a(b bVar) {
        if (!this.k.a(new d(this, bVar), true) && bVar != null) {
            bVar.a();
        }
    }

    public void a(u uVar, MFEFaceTrackingParameters mFEFaceTrackingParameters, d dVar) {
        if (uVar != null) {
            MFETrackingData mFETrackingData = uVar.f15398a;
            if (mFETrackingData != null && mFETrackingData.getImageBitmap() != null && !uVar.f15398a.getImageBitmap().isRecycled() && uVar.f15398a.getImageBitmap().getWidth() > 0 && uVar.f15398a.getImageBitmap().getHeight() > 0 && uVar.f15398a.getImageBitmap().getConfig() == Bitmap.Config.ARGB_8888) {
                if (mFEFaceTrackingParameters == null) {
                    mFEFaceTrackingParameters = new MFEFaceTrackingParameters(0, true);
                }
                if (!this.k.a((Runnable) new g(this, uVar, mFEFaceTrackingParameters, dVar)) && dVar != null) {
                    dVar.a(uVar);
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("Invalid bitmap to face track on");
    }

    public u a(Object obj, u uVar, MFEFaceTrackingParameters mFEFaceTrackingParameters, d dVar) {
        if (this.p.get()) {
            return uVar;
        }
        if (obj != null) {
            if (uVar != null) {
                MFETrackingData mFETrackingData = uVar.f15398a;
                if (mFETrackingData != null && mFETrackingData.getImageBitmap() != null && !uVar.f15398a.getImageBitmap().isRecycled() && uVar.f15398a.getImageBitmap().getWidth() > 0 && uVar.f15398a.getImageBitmap().getHeight() > 0 && uVar.f15398a.getImageBitmap().getConfig() == Bitmap.Config.ARGB_8888) {
                    if (mFEFaceTrackingParameters == null) {
                        mFEFaceTrackingParameters = new MFEFaceTrackingParameters(0, true);
                    }
                    if (!this.l.containsKey(obj)) {
                        this.l.put(obj, new AtomicReference((Object) null));
                    }
                    u uVar2 = (u) this.l.get(obj).getAndSet(uVar);
                    this.k.a((Runnable) new h(this, obj, mFEFaceTrackingParameters, dVar));
                    return uVar2;
                }
            }
            throw new IllegalArgumentException("Invalid bitmap to face track on");
        }
        throw new IllegalArgumentException("stream tag cannot be null when doing live face tracking");
    }

    public u a(Object obj) {
        if (!this.l.containsKey(obj)) {
            return null;
        }
        return (u) this.l.get(obj).get();
    }

    public MFEDebugInfo a() {
        return this.m;
    }

    /* access modifiers changed from: private */
    public void a(u uVar, MFEFaceTrackingParameters mFEFaceTrackingParameters, boolean z, d dVar) {
        if (mFEFaceTrackingParameters == null) {
            mFEFaceTrackingParameters = new MFEFaceTrackingParameters(0, true);
        }
        if (this.j.g()) {
            MFETrackingData mFETrackingData = uVar.f15398a;
            MFEDebugInfo mFEDebugInfo = new MFEDebugInfo(f15218f);
            boolean c2 = this.j.c(mFETrackingData, mFEFaceTrackingParameters, mFEDebugInfo);
            if (z) {
                this.j.d();
            }
            mFETrackingData.setHasFacePoints(c2);
            this.o = (this.o * 0.9d) + (this.n.a() * 0.1d);
            this.n.c();
            mFEDebugInfo.addSimpleDebugInfo("face tracking fps", this.o);
            this.m.addSubDebugInfo(mFEDebugInfo);
        }
        if (dVar != null) {
            dVar.a(uVar);
        }
    }
}
