package com.modiface.mfemakeupkit.b;

import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;
import java.util.ArrayList;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f15243a;

    e(m mVar) {
        this.f15243a = mVar;
    }

    public void run() {
        ArrayList arrayList = new ArrayList();
        if (this.f15243a.p != null) {
            this.f15243a.p.close();
            arrayList.addAll(this.f15243a.p.getAndClearErrors());
            MFEGLFramebuffer unused = this.f15243a.p = null;
        }
        if (this.f15243a.q != null) {
            this.f15243a.q.close();
            arrayList.addAll(this.f15243a.q.getAndClearErrors());
            MFEGLFramebuffer unused2 = this.f15243a.q = null;
        }
        if (this.f15243a.r != null) {
            this.f15243a.r.close();
            arrayList.addAll(this.f15243a.r.getAndClearErrors());
            MFEGLFramebuffer unused3 = this.f15243a.r = null;
        }
        this.f15243a.o.i();
    }
}
