package com.modiface.mfemakeupkit.camera;

import com.modiface.mfemakeupkit.utils.MFEGLFramebuffer;

class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f15262a;

    a(i iVar) {
        this.f15262a = iVar;
    }

    public void run() {
        if (this.f15262a.s != null) {
            this.f15262a.s.close();
            if (this.f15262a.s.hasError()) {
                MFEGLFramebuffer unused = this.f15262a.s = null;
            }
        }
        this.f15262a.x.e();
    }
}
