package com.modiface.mfemakeupkit.b;

import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;

class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f15246a;

    g(m mVar) {
        this.f15246a = mVar;
    }

    public void run() {
        if ((this.f15246a.r == null || this.f15246a.r.hasError() || !this.f15246a.r.isValid()) && this.f15246a.o.j()) {
            MFEGLFramebuffer h = this.f15246a.r;
            if (h == null || h.hasError()) {
                h = new MFEGLFramebuffer("original");
            }
            if (!h.hasError() && this.f15246a.o.g(h) && h.isValid()) {
                MFEGLFramebuffer unused = this.f15246a.r = h;
                if (this.f15246a.p == null || this.f15246a.p.hasError() || !this.f15246a.p.isValid()) {
                    MFEGLFramebuffer unused2 = this.f15246a.p = new MFEGLFramebuffer("makeup");
                }
                if (!this.f15246a.p.hasError()) {
                    this.f15246a.p.generateEmptyWithSize(this.f15246a.r.getWidth(), this.f15246a.r.getHeight());
                }
                if (this.f15246a.p.hasError()) {
                    MFEGLFramebuffer unused3 = this.f15246a.p = null;
                }
                if (this.f15246a.q == null || this.f15246a.q.hasError() || !this.f15246a.q.isValid()) {
                    MFEGLFramebuffer unused4 = this.f15246a.q = new MFEGLFramebuffer("before");
                }
                if (!this.f15246a.q.hasError()) {
                    this.f15246a.q.generateEmptyWithSize(this.f15246a.r.getWidth(), this.f15246a.r.getHeight());
                }
                if (this.f15246a.q.hasError()) {
                    MFEGLFramebuffer unused5 = this.f15246a.q = null;
                }
            }
        }
    }
}
