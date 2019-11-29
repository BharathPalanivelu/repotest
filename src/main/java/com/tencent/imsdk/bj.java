package com.tencent.imsdk;

final class bj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ bf f30765a;

    bj(bf bfVar) {
        this.f30765a = bfVar;
    }

    public final void run() {
        if (this.f30765a.f30754a != null) {
            this.f30765a.f30754a.onSuccess();
        }
    }
}
