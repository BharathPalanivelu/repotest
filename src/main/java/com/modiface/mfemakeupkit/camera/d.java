package com.modiface.mfemakeupkit.camera;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f15267a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AtomicInteger f15268b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i f15269c;

    d(i iVar, AtomicReference atomicReference, AtomicInteger atomicInteger) {
        this.f15269c = iVar;
        this.f15267a = atomicReference;
        this.f15268b = atomicInteger;
    }

    public void run() {
        SurfaceTexture surfaceTexture = (SurfaceTexture) this.f15267a.getAndSet((Object) null);
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (this.f15268b.get() != 0) {
            GLES20.glDeleteTextures(1, new int[]{this.f15268b.get()}, 0);
        }
    }
}
