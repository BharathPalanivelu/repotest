package com.threatmetrix.TrustDefenderMobile;

class n extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f32599a = null;

    public n(Runnable runnable) {
        this.f32599a = runnable;
    }

    public i a() {
        Runnable runnable = this.f32599a;
        if (runnable instanceof i) {
            return (i) runnable;
        }
        return null;
    }

    public void run() {
        this.f32599a.run();
    }

    public void interrupt() {
        Runnable runnable = this.f32599a;
        if (runnable instanceof i) {
            ((i) runnable).d();
        }
        super.interrupt();
    }
}
