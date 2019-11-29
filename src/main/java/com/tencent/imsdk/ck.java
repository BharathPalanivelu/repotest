package com.tencent.imsdk;

final class ck implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ byte[] f30823a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ cj f30824b;

    ck(cj cjVar, byte[] bArr) {
        this.f30824b = cjVar;
        this.f30823a = bArr;
    }

    public final void run() {
        this.f30824b.f30820a.onSuccess(this.f30823a);
    }
}
