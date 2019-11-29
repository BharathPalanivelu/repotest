package com.modiface.mfemakeupkit.utils;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f15370a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f15371b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f15372c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ m f15373d;

    k(m mVar, ArrayList arrayList, Object obj, AtomicBoolean atomicBoolean) {
        this.f15373d = mVar;
        this.f15370a = arrayList;
        this.f15371b = obj;
        this.f15372c = atomicBoolean;
    }

    public void run() {
        if (this.f15373d.f15378e != null && this.f15373d.f15378e != EGL14.EGL_NO_DISPLAY) {
            m mVar = this.f15373d;
            boolean z = false;
            mVar.l = false;
            EGLDisplay a2 = mVar.f15378e;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(a2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            Throwable eGLError = MFEGLUtil.getEGLError();
            if (eGLError != null) {
                this.f15370a.add(eGLError);
            }
            EGLSurface unused = this.f15373d.i = EGL14.EGL_NO_SURFACE;
            boolean unused2 = this.f15373d.j = true;
            if (!(this.f15373d.h == null || this.f15373d.h == EGL14.EGL_NO_SURFACE)) {
                if (!EGL14.eglDestroySurface(this.f15373d.f15378e, this.f15373d.h)) {
                    Throwable eGLError2 = MFEGLUtil.getEGLError();
                    if (eGLError2 != null) {
                        this.f15370a.add(eGLError2);
                    }
                }
                EGLSurface unused3 = this.f15373d.h = EGL14.EGL_NO_SURFACE;
            }
            if (this.f15371b != null) {
                try {
                    EGLSurface unused4 = this.f15373d.h = EGL14.eglCreateWindowSurface(this.f15373d.f15378e, this.f15373d.f15380g, this.f15371b, new int[]{12344}, 0);
                    if (this.f15373d.h == null || this.f15373d.h == EGL14.EGL_NO_SURFACE) {
                        Throwable eGLError3 = MFEGLUtil.getEGLError();
                        if (eGLError3 != null) {
                            this.f15370a.add(eGLError3);
                            return;
                        }
                        return;
                    }
                } catch (IllegalArgumentException unused5) {
                    Throwable eGLError4 = MFEGLUtil.getEGLError();
                    if (eGLError4 != null) {
                        this.f15370a.add(eGLError4);
                        return;
                    }
                    return;
                }
            } else {
                try {
                    EGLSurface unused6 = this.f15373d.h = EGL14.eglCreatePbufferSurface(this.f15373d.f15378e, this.f15373d.f15380g, new int[]{12375, 1, 12374, 1, 12344}, 0);
                    if (this.f15373d.h == null || this.f15373d.h == EGL14.EGL_NO_SURFACE) {
                        Throwable eGLError5 = MFEGLUtil.getEGLError();
                        if (eGLError5 != null) {
                            this.f15370a.add(eGLError5);
                            return;
                        }
                        return;
                    }
                    z = true;
                } catch (IllegalArgumentException e2) {
                    this.f15370a.add(new Throwable("eglCreatePbufferSurface failed in setSurface() in MFEGLThread", e2));
                    return;
                }
            }
            m mVar2 = this.f15373d;
            mVar2.l = EGL14.eglMakeCurrent(mVar2.f15378e, this.f15373d.h, this.f15373d.h, this.f15373d.f15379f);
            m mVar3 = this.f15373d;
            if (!mVar3.l) {
                this.f15370a.add(new Throwable("failed to make current with new surface in setSurface() in MFEGLThread"));
                EGLSurface unused7 = this.f15373d.i = EGL14.EGL_NO_SURFACE;
                boolean unused8 = this.f15373d.j = true;
                return;
            }
            EGLSurface unused9 = mVar3.i = mVar3.h;
            boolean unused10 = this.f15373d.j = z;
            this.f15372c.set(true);
        }
    }
}
