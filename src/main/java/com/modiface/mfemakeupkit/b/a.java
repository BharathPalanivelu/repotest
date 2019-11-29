package com.modiface.mfemakeupkit.b;

import com.modiface.mfemakeupkit.b.m;
import com.modiface.mfemakeupkit.data.MFEMakeupRenderingParameters;
import com.modiface.mfemakeupkit.utils.MFEDebugInfo;
import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import com.modiface.mfemakeupkit.utils.MFENativeError;
import com.modiface.mfemakeupkit.utils.u;
import java.util.ArrayList;

class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f15229a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m.a f15230b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ u f15231c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ m f15232d;

    a(m mVar, ArrayList arrayList, m.a aVar, u uVar) {
        this.f15232d = mVar;
        this.f15229a = arrayList;
        this.f15230b = aVar;
        this.f15231c = uVar;
    }

    public void run() {
        boolean z;
        if (this.f15232d.l.get()) {
            this.f15229a.add(new Throwable("cannot apply makeup in background when we are on paused"));
            this.f15230b.a(false, this.f15229a, this.f15231c, (MFEGLFramebuffer) null, (MFEGLFramebuffer) null);
            return;
        }
        MFEGLFramebuffer mFEGLFramebuffer = new MFEGLFramebuffer("originalclone_background");
        MFEGLFramebuffer mFEGLFramebuffer2 = new MFEGLFramebuffer("before_background");
        MFEGLFramebuffer mFEGLFramebuffer3 = new MFEGLFramebuffer("output_background");
        mFEGLFramebuffer3.loadBitmap(this.f15231c.f15398a.getImageBitmap());
        mFEGLFramebuffer.generateEmptyWithSize(mFEGLFramebuffer3.getWidth(), mFEGLFramebuffer3.getHeight());
        mFEGLFramebuffer2.generateEmptyWithSize(mFEGLFramebuffer3.getWidth(), mFEGLFramebuffer3.getHeight());
        if (mFEGLFramebuffer.hasError() || !mFEGLFramebuffer.isValid() || mFEGLFramebuffer3.hasError() || !mFEGLFramebuffer3.isValid() || mFEGLFramebuffer2.hasError()) {
            this.f15229a.addAll(mFEGLFramebuffer.getAndClearErrors());
            this.f15229a.addAll(mFEGLFramebuffer2.getAndClearErrors());
            this.f15229a.addAll(mFEGLFramebuffer3.getAndClearErrors());
            if (!mFEGLFramebuffer.isValid()) {
                this.f15229a.add(new Throwable("original clone framebuffer for applying makeup in background is invalid"));
            }
            if (!mFEGLFramebuffer3.isValid()) {
                this.f15229a.add(new Throwable("output framebuffer for applying makeup in background is invalid"));
            }
            this.f15229a.add(new Throwable("failed to initialize framebuffers to apply makeup in background"));
            this.f15230b.a(false, this.f15229a, this.f15231c, (MFEGLFramebuffer) null, (MFEGLFramebuffer) null);
            return;
        }
        if (this.f15232d.o.j()) {
            MFENativeError mFENativeError = new MFENativeError();
            boolean f2 = this.f15232d.o.f(mFEGLFramebuffer3, mFEGLFramebuffer2, mFEGLFramebuffer, this.f15231c.f15398a, (MFEMakeupRenderingParameters) this.f15232d.u.get(), new MFEDebugInfo("background render"), mFENativeError.getNativeState());
            Throwable nativeError = mFENativeError.getNativeError();
            if (nativeError != null) {
                this.f15229a.add(nativeError);
            }
            z = f2;
        } else {
            this.f15229a.add(new Throwable("native state is invalid when applying makeup in background"));
            z = false;
        }
        this.f15230b.a(z, this.f15229a, this.f15231c, mFEGLFramebuffer, mFEGLFramebuffer3);
    }
}
