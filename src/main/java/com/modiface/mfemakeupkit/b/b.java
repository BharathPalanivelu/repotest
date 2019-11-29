package com.modiface.mfemakeupkit.b;

import com.modiface.mfemakeupkit.b.m;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.utils.u;
import java.util.ArrayList;

class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f15233a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m.a f15234b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ u f15235c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ m f15236d;

    b(m mVar, ArrayList arrayList, m.a aVar, u uVar) {
        this.f15236d = mVar;
        this.f15233a = arrayList;
        this.f15234b = aVar;
        this.f15235c = uVar;
    }

    public void run() {
        this.f15233a.add(new Throwable("render thread is not setup for applying makeup"));
        this.f15234b.a(false, this.f15233a, this.f15235c, (MFEGLFramebuffer) null, (MFEGLFramebuffer) null);
    }
}
