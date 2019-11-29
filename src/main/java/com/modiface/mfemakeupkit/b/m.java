package com.modiface.mfemakeupkit.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import com.google.a.f;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.data.MFEMakeupRenderingParameters;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.effects.MFEMakeupLook;
import com.modiface.mfemakeupkit.effects.MFEMakeupProductCategory;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.utils.MFEImage;
import com.modiface.mfemakeupkit.utils.o;
import com.modiface.mfemakeupkit.utils.s;
import com.modiface.mfemakeupkit.utils.u;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15252a = "MFEMakeupRenderEngine";

    /* renamed from: b  reason: collision with root package name */
    private static final String f15253b = "MFEMakeupRenderThread";

    /* renamed from: c  reason: collision with root package name */
    private static final String f15254c = "MFELiveMakeup";

    /* renamed from: d  reason: collision with root package name */
    private static final String f15255d = "Makeup Rendering";

    /* renamed from: e  reason: collision with root package name */
    private static final String f15256e = "Rendering Tracking Data";

    /* renamed from: f  reason: collision with root package name */
    private static final String f15257f = "MFE Makeup Rendering Engine";

    /* renamed from: g  reason: collision with root package name */
    private static final String f15258g = "makeup";
    private static final String h = "before";
    private static final String i = "original";
    /* access modifiers changed from: private */
    public WeakReference<c> j = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public WeakReference<d> k = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */
    public AtomicBoolean l = new AtomicBoolean(false);
    private final s m;
    private final f n = o.a();
    /* access modifiers changed from: private */
    public final com.modiface.mfemakeupkit.mfea.c o = new com.modiface.mfemakeupkit.mfea.c();
    /* access modifiers changed from: private */
    public MFEGLFramebuffer p = null;
    /* access modifiers changed from: private */
    public MFEGLFramebuffer q = null;
    /* access modifiers changed from: private */
    public MFEGLFramebuffer r = null;
    /* access modifiers changed from: private */
    public MFETrackingData s = new MFETrackingData((MFEImage) null, 0);
    /* access modifiers changed from: private */
    public MFEMakeupProductCategory t = MFEMakeupProductCategory.Undefined;
    /* access modifiers changed from: private */
    public AtomicReference<MFEMakeupRenderingParameters> u = new AtomicReference<>(new MFEMakeupRenderingParameters(false));
    /* access modifiers changed from: private */
    public AtomicReference<u> v = new AtomicReference<>((Object) null);
    private AtomicReference<b> w = new AtomicReference<>(new b(ServiceLogger.PLACEHOLDER, (d) null));
    /* access modifiers changed from: private */
    public MFEDebugInfo x = new MFEDebugInfo(f15257f);

    public interface a {
        void a(boolean z, ArrayList<Throwable> arrayList, u uVar, MFEGLFramebuffer mFEGLFramebuffer, MFEGLFramebuffer mFEGLFramebuffer2);
    }

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f15259a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f15260b;

        /* synthetic */ b(String str, d dVar) {
            this(str);
        }

        private b(String str) {
            this.f15260b = false;
            this.f15259a = str;
        }
    }

    public interface c {
        void onMakeupApplied(boolean z, ArrayList<Throwable> arrayList, MFEGLFramebuffer mFEGLFramebuffer, MFEGLFramebuffer mFEGLFramebuffer2, MFETrackingData mFETrackingData, MFEMakeupProductCategory mFEMakeupProductCategory);
    }

    public interface d {
        void onFinishedWithTrackingData(u uVar);

        void onRenderingEngineErrors(ArrayList<Throwable> arrayList);
    }

    public interface e {
        void a(MFEGLFramebuffer mFEGLFramebuffer, MFEGLFramebuffer mFEGLFramebuffer2, MFETrackingData mFETrackingData, MFEMakeupProductCategory mFEMakeupProductCategory);
    }

    public m(Context context, MFEMakeupEngine.Region region) {
        AssetManager assets = context.getAssets();
        String packageName = context.getPackageName();
        this.m = new s(f15253b);
        this.m.d((Runnable) new d(this, packageName, region, assets));
    }

    public void finalize() throws Throwable {
        a();
        super.finalize();
    }

    public void d() {
        this.m.d((Runnable) new j(this));
    }

    public void e() {
        this.m.e();
    }

    public void b(Runnable runnable) {
        this.m.d(runnable);
    }

    public void c() {
        this.m.b((EGLContext) null);
        this.m.d((Runnable) new g(this));
        this.l.set(false);
        this.m.d((Runnable) new h(this));
    }

    public MFEDebugInfo b() {
        return this.x;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.util.ArrayList<java.lang.Throwable> r18) {
        /*
            r17 = this;
            r0 = r17
            r3 = r18
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.l
            boolean r1 = r1.get()
            if (r1 == 0) goto L_0x000d
            return
        L_0x000d:
            com.modiface.mfemakeupkit.utils.MFEDebugInfo r1 = new com.modiface.mfemakeupkit.utils.MFEDebugInfo
            java.lang.String r2 = "Makeup Rendering"
            r1.<init>(r2)
            com.modiface.mfemakeupkit.utils.y r2 = new com.modiface.mfemakeupkit.utils.y
            r2.<init>()
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r13 = r0.r
            com.modiface.mfemakeupkit.effects.MFEMakeupProductCategory r4 = com.modiface.mfemakeupkit.effects.MFEMakeupProductCategory.Undefined
            r0.t = r4
            r4 = 0
            if (r13 == 0) goto L_0x012f
            boolean r5 = r13.isValid()
            if (r5 == 0) goto L_0x012f
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r5 = r0.p
            if (r5 == 0) goto L_0x0032
            boolean r6 = r5.hasError()
            if (r6 == 0) goto L_0x0039
        L_0x0032:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r5 = new com.modiface.mfemakeupkit.utils.MFEGLFramebuffer
            java.lang.String r6 = "makeup"
            r5.<init>(r6)
        L_0x0039:
            r14 = r5
            boolean r5 = r14.hasError()
            r6 = 1
            if (r5 == 0) goto L_0x004a
            java.util.ArrayList r5 = r14.getAndClearErrors()
            r3.addAll(r5)
            r5 = 0
            goto L_0x004b
        L_0x004a:
            r5 = 1
        L_0x004b:
            if (r5 == 0) goto L_0x007c
            int r7 = r13.getWidth()
            int r8 = r13.getHeight()
            r14.generateEmptyWithSize(r7, r8)
            boolean r7 = r14.hasError()
            if (r7 != 0) goto L_0x0064
            boolean r7 = r14.isValid()
            if (r7 != 0) goto L_0x007c
        L_0x0064:
            java.util.ArrayList r5 = r14.getAndClearErrors()
            r3.addAll(r5)
            boolean r5 = r14.isValid()
            if (r5 != 0) goto L_0x007b
            java.lang.Throwable r5 = new java.lang.Throwable
            java.lang.String r7 = "original clone framebuffer required for rendering is invalid"
            r5.<init>(r7)
            r3.add(r5)
        L_0x007b:
            r5 = 0
        L_0x007c:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r7 = r0.q
            if (r5 == 0) goto L_0x00d0
            if (r7 == 0) goto L_0x0088
            boolean r8 = r7.hasError()
            if (r8 == 0) goto L_0x008f
        L_0x0088:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r7 = new com.modiface.mfemakeupkit.utils.MFEGLFramebuffer
            java.lang.String r8 = "before"
            r7.<init>(r8)
        L_0x008f:
            boolean r8 = r7.hasError()
            if (r8 == 0) goto L_0x009d
            java.util.ArrayList r5 = r7.getAndClearErrors()
            r3.addAll(r5)
            r5 = 0
        L_0x009d:
            if (r5 == 0) goto L_0x00d0
            int r8 = r13.getWidth()
            int r9 = r13.getHeight()
            r7.generateEmptyWithSize(r8, r9)
            boolean r8 = r7.hasError()
            if (r8 != 0) goto L_0x00b6
            boolean r8 = r7.isValid()
            if (r8 != 0) goto L_0x00d0
        L_0x00b6:
            java.util.ArrayList r5 = r7.getAndClearErrors()
            r3.addAll(r5)
            boolean r5 = r7.isValid()
            if (r5 != 0) goto L_0x00cd
            java.lang.Throwable r5 = new java.lang.Throwable
            java.lang.String r8 = "before render framebuffer required for rendering is invalid"
            r5.<init>(r8)
            r3.add(r5)
        L_0x00cd:
            r15 = r7
            r5 = 0
            goto L_0x00d1
        L_0x00d0:
            r15 = r7
        L_0x00d1:
            if (r5 == 0) goto L_0x0126
            com.modiface.mfemakeupkit.mfea.c r5 = r0.o
            boolean r5 = r5.j()
            if (r5 == 0) goto L_0x011c
            java.util.concurrent.atomic.AtomicReference<com.modiface.mfemakeupkit.b.m$b> r4 = r0.w
            java.lang.Object r4 = r4.get()
            com.modiface.mfemakeupkit.b.m$b r4 = (com.modiface.mfemakeupkit.b.m.b) r4
            boolean r5 = r4.f15260b
            if (r5 != 0) goto L_0x00f5
            com.modiface.mfemakeupkit.mfea.c r5 = r0.o
            java.lang.String r7 = r4.f15259a
            r5.d(r7)
            boolean unused = r4.f15260b = r6
        L_0x00f5:
            com.modiface.mfemakeupkit.utils.MFENativeError r16 = new com.modiface.mfemakeupkit.utils.MFENativeError
            r16.<init>()
            com.modiface.mfemakeupkit.mfea.c r4 = r0.o
            java.util.concurrent.atomic.AtomicReference<com.modiface.mfemakeupkit.data.MFEMakeupRenderingParameters> r5 = r0.u
            java.lang.Object r5 = r5.get()
            r9 = r5
            com.modiface.mfemakeupkit.data.MFEMakeupRenderingParameters r9 = (com.modiface.mfemakeupkit.data.MFEMakeupRenderingParameters) r9
            long r11 = r16.getNativeState()
            r8 = 0
            r5 = r13
            r6 = r15
            r7 = r14
            r10 = r1
            boolean r4 = r4.f(r5, r6, r7, r8, r9, r10, r11)
            java.lang.Throwable r5 = r16.getNativeError()
            if (r5 == 0) goto L_0x0126
            r3.add(r5)
            goto L_0x0126
        L_0x011c:
            java.lang.Throwable r5 = new java.lang.Throwable
            java.lang.String r6 = "invalid native state to apply makeup"
            r5.<init>(r6)
            r3.add(r5)
        L_0x0126:
            if (r4 == 0) goto L_0x0148
            r0.p = r13
            r0.q = r15
            r0.r = r14
            goto L_0x0148
        L_0x012f:
            if (r13 == 0) goto L_0x0148
            java.util.ArrayList r5 = r13.getAndClearErrors()
            r3.addAll(r5)
            boolean r5 = r13.isValid()
            if (r5 != 0) goto L_0x0148
            java.lang.Throwable r5 = new java.lang.Throwable
            java.lang.String r6 = "output framebuffer to apply makeup is invalid"
            r5.<init>(r6)
            r3.add(r5)
        L_0x0148:
            java.lang.String r5 = "makeup applied"
            r1.addSimpleDebugInfo((java.lang.String) r5, (boolean) r4)
            long r5 = r2.d()
            java.lang.String r2 = "total apply makeup time (ms)"
            r1.addSimpleDebugInfo((java.lang.String) r2, (long) r5)
            com.modiface.mfemakeupkit.utils.MFEDebugInfo r2 = r0.x
            r2.addSubDebugInfo(r1)
            java.lang.ref.WeakReference<com.modiface.mfemakeupkit.b.m$c> r1 = r0.j
            java.lang.Object r1 = r1.get()
            com.modiface.mfemakeupkit.b.m$c r1 = (com.modiface.mfemakeupkit.b.m.c) r1
            if (r1 == 0) goto L_0x0177
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r5 = r0.q
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r6 = r0.p
            com.modiface.mfemakeupkit.data.MFETrackingData r7 = r0.s
            com.modiface.mfemakeupkit.effects.MFEMakeupProductCategory r8 = r0.t
            r2 = r4
            r3 = r18
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r1.onMakeupApplied(r2, r3, r4, r5, r6, r7)
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.b.m.b(java.util.ArrayList):void");
    }

    public void a() {
        this.m.e(new e(this));
        this.m.a();
    }

    public void a(Runnable runnable) {
        this.l.set(true);
        this.m.c((Runnable) new f(this, runnable));
    }

    public void c(Runnable runnable) {
        this.m.e(runnable);
    }

    public void a(c cVar) {
        this.j = new WeakReference<>(cVar);
    }

    public void a(Runnable runnable, Runnable runnable2) {
        if (!this.m.a(runnable, runnable2) && runnable2 != null) {
            runnable2.run();
        }
    }

    public boolean a(EGLSurface eGLSurface, boolean z) {
        return this.m.a(eGLSurface, z);
    }

    public void a(long j2) {
        this.m.a(j2);
    }

    public void a(MFEMakeupLook mFEMakeupLook) {
        this.w.set(new b(this.n.b(mFEMakeupLook, MFEMakeupLook.class), (d) null));
        d();
    }

    public void a(MFEMakeupRenderingParameters mFEMakeupRenderingParameters) {
        if (mFEMakeupRenderingParameters == null) {
            mFEMakeupRenderingParameters = new MFEMakeupRenderingParameters(false);
        }
        this.u.set(mFEMakeupRenderingParameters);
        this.m.d((Runnable) new i(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.modiface.mfemakeupkit.data.MFETrackingData r12, com.modiface.mfemakeupkit.utils.MFEDebugInfo r13, java.util.ArrayList<java.lang.Throwable> r14) {
        /*
            r11 = this;
            com.modiface.mfemakeupkit.utils.y r0 = new com.modiface.mfemakeupkit.utils.y
            r0.<init>()
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r1 = r11.r
            if (r1 == 0) goto L_0x000f
            boolean r1 = r1.hasError()
            if (r1 == 0) goto L_0x0018
        L_0x000f:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r1 = new com.modiface.mfemakeupkit.utils.MFEGLFramebuffer
            java.lang.String r2 = "original"
            r1.<init>(r2)
            r11.r = r1
        L_0x0018:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r1 = r11.r
            boolean r1 = r1.hasError()
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x002e
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.r
            java.util.ArrayList r12 = r12.getAndClearErrors()
            r14.addAll(r12)
            r11.r = r2
            return r3
        L_0x002e:
            com.modiface.mfemakeupkit.utils.MFEImage r1 = r12.getImage()
            int r1 = r1.textureId
            r4 = 1
            if (r1 == 0) goto L_0x00c8
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r1 = r11.r
            int r1 = r1.detachTexture()
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r5 = r11.r
            int r5 = r5.getWidth()
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r6 = r11.r
            int r6 = r6.getHeight()
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r7 = r11.r
            boolean r7 = r7.hasError()
            if (r7 != 0) goto L_0x008c
            com.modiface.mfemakeupkit.utils.MFEImage r7 = r12.getImage()
            int r7 = r7.textureId
            if (r1 == r7) goto L_0x008c
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r7 = r11.r
            com.modiface.mfemakeupkit.utils.MFEImage r8 = r12.getImage()
            int r8 = r8.textureId
            com.modiface.mfemakeupkit.utils.MFEImage r9 = r12.getImage()
            int r9 = r9.textureWidth
            com.modiface.mfemakeupkit.utils.MFEImage r10 = r12.getImage()
            int r10 = r10.textureHeight
            r7.attachTexture(r8, r9, r10)
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r7 = r11.r
            boolean r7 = r7.hasError()
            if (r7 != 0) goto L_0x008c
            com.modiface.mfemakeupkit.utils.MFEImage r7 = r12.getImage()
            r7.textureId = r1
            com.modiface.mfemakeupkit.utils.MFEImage r7 = r12.getImage()
            r7.textureWidth = r5
            com.modiface.mfemakeupkit.utils.MFEImage r5 = r12.getImage()
            r5.textureHeight = r6
            r5 = 1
            goto L_0x008d
        L_0x008c:
            r5 = 0
        L_0x008d:
            if (r5 != 0) goto L_0x00c9
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r6 = r11.r
            java.util.ArrayList r6 = r6.getAndClearErrors()
            r14.addAll(r6)
            com.modiface.mfemakeupkit.utils.MFEImage r6 = r12.getImage()
            int r6 = r6.textureId
            if (r1 != r6) goto L_0x00c9
            java.lang.Throwable r6 = new java.lang.Throwable
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "original framebuffer has same texture id as new tracking data: "
            r7.append(r8)
            r7.append(r1)
            java.lang.String r1 = ", "
            r7.append(r1)
            com.modiface.mfemakeupkit.utils.MFEImage r1 = r12.getImage()
            int r1 = r1.textureId
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            r6.<init>(r1)
            r14.add(r6)
            goto L_0x00c9
        L_0x00c8:
            r5 = 0
        L_0x00c9:
            if (r5 != 0) goto L_0x00d4
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r1 = r11.r
            android.graphics.Bitmap r12 = r12.getImageBitmap()
            r1.loadBitmap(r12)
        L_0x00d4:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.r
            boolean r12 = r12.hasError()
            if (r12 != 0) goto L_0x01be
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.r
            boolean r12 = r12.isValid()
            if (r12 != 0) goto L_0x00e6
            goto L_0x01be
        L_0x00e6:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.p
            if (r12 == 0) goto L_0x00f0
            boolean r12 = r12.hasError()
            if (r12 == 0) goto L_0x00f9
        L_0x00f0:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = new com.modiface.mfemakeupkit.utils.MFEGLFramebuffer
            java.lang.String r1 = "makeup"
            r12.<init>(r1)
            r11.p = r12
        L_0x00f9:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.p
            boolean r12 = r12.hasError()
            if (r12 == 0) goto L_0x010d
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.p
            java.util.ArrayList r12 = r12.getAndClearErrors()
            r14.addAll(r12)
            r11.p = r2
            return r3
        L_0x010d:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.p
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r1 = r11.r
            int r1 = r1.getWidth()
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r5 = r11.r
            int r5 = r5.getHeight()
            r12.generateEmptyWithSize(r1, r5)
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.p
            boolean r12 = r12.hasError()
            if (r12 != 0) goto L_0x01a0
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.p
            boolean r12 = r12.isValid()
            if (r12 != 0) goto L_0x012f
            goto L_0x01a0
        L_0x012f:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.q
            if (r12 == 0) goto L_0x0139
            boolean r12 = r12.hasError()
            if (r12 == 0) goto L_0x0142
        L_0x0139:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = new com.modiface.mfemakeupkit.utils.MFEGLFramebuffer
            java.lang.String r1 = "before"
            r12.<init>(r1)
            r11.q = r12
        L_0x0142:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.q
            boolean r12 = r12.hasError()
            if (r12 == 0) goto L_0x0156
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.q
            java.util.ArrayList r12 = r12.getAndClearErrors()
            r14.addAll(r12)
            r11.q = r2
            return r3
        L_0x0156:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.q
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r1 = r11.r
            int r1 = r1.getWidth()
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r5 = r11.r
            int r5 = r5.getHeight()
            r12.generateEmptyWithSize(r1, r5)
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.q
            boolean r12 = r12.hasError()
            if (r12 != 0) goto L_0x0182
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.q
            boolean r12 = r12.isValid()
            if (r12 != 0) goto L_0x0178
            goto L_0x0182
        L_0x0178:
            long r0 = r0.d()
            java.lang.String r12 = "initialize buffer time (ms)"
            r13.addDetailedDebugInfo((java.lang.String) r12, (long) r0)
            return r4
        L_0x0182:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.q
            java.util.ArrayList r12 = r12.getAndClearErrors()
            r14.addAll(r12)
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.q
            boolean r12 = r12.isValid()
            if (r12 != 0) goto L_0x019d
            java.lang.Throwable r12 = new java.lang.Throwable
            java.lang.String r13 = "before makeup render framebuffer invalid"
            r12.<init>(r13)
            r14.add(r12)
        L_0x019d:
            r11.q = r2
            return r3
        L_0x01a0:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.p
            java.util.ArrayList r12 = r12.getAndClearErrors()
            r14.addAll(r12)
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.p
            boolean r12 = r12.isValid()
            if (r12 != 0) goto L_0x01bb
            java.lang.Throwable r12 = new java.lang.Throwable
            java.lang.String r13 = "makeup render framebuffer invalid"
            r12.<init>(r13)
            r14.add(r12)
        L_0x01bb:
            r11.p = r2
            return r3
        L_0x01be:
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.r
            java.util.ArrayList r12 = r12.getAndClearErrors()
            r14.addAll(r12)
            com.modiface.mfemakeupkit.utils.MFEGLFramebuffer r12 = r11.r
            boolean r12 = r12.isValid()
            if (r12 != 0) goto L_0x01d9
            java.lang.Throwable r12 = new java.lang.Throwable
            java.lang.String r13 = "original framebuffer invalid"
            r12.<init>(r13)
            r14.add(r12)
        L_0x01d9:
            r11.r = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.b.m.a(com.modiface.mfemakeupkit.data.MFETrackingData, com.modiface.mfemakeupkit.utils.MFEDebugInfo, java.util.ArrayList):boolean");
    }

    public void a(u uVar) {
        if (uVar != null) {
            MFETrackingData mFETrackingData = uVar.f15398a;
            if (mFETrackingData != null && mFETrackingData.getImage() != null && uVar.f15398a.getImageBitmap() != null && !uVar.f15398a.getImageBitmap().isRecycled() && uVar.f15398a.getImageBitmap().getWidth() > 0 && uVar.f15398a.getImageBitmap().getHeight() > 0 && uVar.f15398a.getImageBitmap().getConfig() == Bitmap.Config.ARGB_8888) {
                u andSet = this.v.getAndSet(uVar);
                d dVar = (d) this.k.get();
                if (!(andSet == null || dVar == null)) {
                    dVar.onFinishedWithTrackingData(andSet);
                }
                this.m.a((Runnable) new k(this), (Runnable) new l(this));
                return;
            }
        }
        throw new IllegalArgumentException("cannot apply makeup to tracking data is null or has no image in it");
    }

    public void a(u uVar, a aVar) {
        ArrayList arrayList = new ArrayList();
        if (uVar != null) {
            MFETrackingData mFETrackingData = uVar.f15398a;
            if (mFETrackingData != null && mFETrackingData.getImageBitmap() != null && !uVar.f15398a.getImageBitmap().isRecycled() && uVar.f15398a.getImageBitmap().getConfig() == Bitmap.Config.ARGB_8888) {
                a((Runnable) new a(this, arrayList, aVar, uVar), (Runnable) new b(this, arrayList, aVar, uVar));
                return;
            }
        }
        arrayList.add(new Throwable("tagged tracking data is invalid"));
        aVar.a(false, arrayList, uVar, (MFEGLFramebuffer) null, (MFEGLFramebuffer) null);
    }

    public com.modiface.mfemakeupkit.utils.c a(ArrayList<Throwable> arrayList) {
        com.modiface.mfemakeupkit.utils.c cVar = new com.modiface.mfemakeupkit.utils.c();
        MFEGLFramebuffer mFEGLFramebuffer = this.q;
        if (mFEGLFramebuffer != null && !mFEGLFramebuffer.hasError()) {
            cVar.f15354a = this.q.captureToBitmap();
            if (this.q.hasError()) {
                arrayList.addAll(this.q.getAndClearErrors());
                cVar.f15354a = null;
            }
        }
        MFEGLFramebuffer mFEGLFramebuffer2 = this.p;
        if (mFEGLFramebuffer2 != null && !mFEGLFramebuffer2.hasError()) {
            cVar.f15355b = this.p.captureToBitmap();
            if (this.p.hasError()) {
                arrayList.addAll(this.p.getAndClearErrors());
                cVar.f15355b = null;
            }
        }
        return cVar;
    }

    public void a(e eVar) {
        this.m.d((Runnable) new c(this, eVar));
    }

    public void a(d dVar) {
        this.k = new WeakReference<>(dVar);
    }
}
