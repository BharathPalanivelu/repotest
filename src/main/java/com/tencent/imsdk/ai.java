package com.tencent.imsdk;

final class ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ IMCoreCallback f30695a;

    ai(IMCoreCallback iMCoreCallback) {
        this.f30695a = iMCoreCallback;
    }

    public final void run() {
        this.f30695a.onDone();
    }
}
