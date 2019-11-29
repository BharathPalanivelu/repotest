package com.threatmetrix.TrustDefenderMobile;

import java.util.concurrent.CountDownLatch;

class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private aa f32566a = null;

    /* renamed from: b  reason: collision with root package name */
    private CountDownLatch f32567b = null;

    public d(aa aaVar, CountDownLatch countDownLatch) {
        this.f32566a = aaVar;
        this.f32567b = countDownLatch;
    }

    public void run() {
        this.f32566a.b();
        CountDownLatch countDownLatch = this.f32567b;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }
}
