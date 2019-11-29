package com.modiface.mfemakeupkit;

import android.opengl.EGLContext;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import com.modiface.mfemakeupkit.effects.MFEMakeupProductCategory;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.utils.m;
import com.modiface.mfemakeupkit.utils.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15220a = "Surface";

    /* renamed from: b  reason: collision with root package name */
    private static AtomicLong f15221b = new AtomicLong(0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.modiface.mfemakeupkit.mfea.a f15222c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f15223d;

    /* renamed from: e  reason: collision with root package name */
    private Object f15224e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f15225f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public AtomicInteger f15226g;
    /* access modifiers changed from: private */
    public m h;
    /* access modifiers changed from: private */
    public WeakReference<a> i;
    private WeakReference<b> j;

    public interface a {
        MFEDebugInfo getDebugInfoToPopulateOn();

        void onRenderDone(MFEDebugInfo mFEDebugInfo);
    }

    interface b {
        void onMFEMakeupSurfaceRenderFrameError(aa aaVar, Throwable th);

        void onMFEMakeupSurfaceSetSurfaceError(aa aaVar, ArrayList<Throwable> arrayList);

        void requestToRender(aa aaVar);
    }

    protected aa() {
        this(false);
    }

    public void finalize() throws Throwable {
        d();
        super.finalize();
    }

    protected aa(boolean z) {
        this.f15222c = new com.modiface.mfemakeupkit.mfea.a();
        this.f15223d = new AtomicBoolean(false);
        this.f15224e = null;
        this.f15225f = new AtomicInteger(0);
        this.f15226g = new AtomicInteger(0);
        this.i = new WeakReference<>((Object) null);
        this.j = new WeakReference<>((Object) null);
        this.h = new s(f(), z);
    }

    private static String f() {
        return "MFESurfGL" + f15221b.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        this.j = new WeakReference<>(bVar);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.h.c((Runnable) new y(this));
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.h.b((EGLContext) null);
        ArrayList arrayList = new ArrayList();
        boolean a2 = this.h.a(this.f15224e, (ArrayList<Throwable>) arrayList);
        if (!arrayList.isEmpty()) {
            a(a2, arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.h.e(new x(this));
        this.h.a();
    }

    public void e() {
        b bVar = (b) this.j.get();
        if (bVar != null) {
            bVar.requestToRender(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(MFEGLFramebuffer mFEGLFramebuffer, MFEGLFramebuffer mFEGLFramebuffer2, Long l, MFETrackingData mFETrackingData, MFEMakeupProductCategory mFEMakeupProductCategory) {
        this.h.e(new z(this, mFEGLFramebuffer, mFEGLFramebuffer2, mFETrackingData, mFEMakeupProductCategory, l));
    }

    public void a(boolean z) {
        this.f15223d.set(z);
        e();
    }

    public void a(a aVar) {
        this.i = new WeakReference<>(aVar);
    }

    public void a(Object obj, int i2, int i3) {
        b bVar = (b) this.j.get();
        ArrayList arrayList = new ArrayList();
        boolean a2 = this.h.a(obj, (ArrayList<Throwable>) arrayList);
        if (!arrayList.isEmpty()) {
            a(a2, arrayList);
        }
        this.f15224e = obj;
        this.f15225f.set(i2);
        this.f15226g.set(i3);
        if (bVar != null) {
            bVar.requestToRender(this);
        }
    }

    public void a() {
        a((Object) null, 0, 0);
    }

    /* access modifiers changed from: protected */
    public float[] a(int i2, int i3, int i4, int i5) {
        return new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    }

    /* access modifiers changed from: protected */
    public float[] a(int i2, int i3, int i4, int i5, MFETrackingData mFETrackingData, MFEMakeupProductCategory mFEMakeupProductCategory) {
        return new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED};
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, ArrayList<Throwable> arrayList) {
        b bVar = (b) this.j.get();
        if (bVar != null) {
            bVar.onMFEMakeupSurfaceSetSurfaceError(this, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Throwable th) {
        b bVar = (b) this.j.get();
        if (bVar != null) {
            bVar.onMFEMakeupSurfaceRenderFrameError(this, th);
        }
    }
}
