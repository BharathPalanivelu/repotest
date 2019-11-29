package com.tencent.imsdk.ext.message;

final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMMessageRevokedListener f30978a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMMessageLocator f30979b;

    aa(TIMMessageRevokedListener tIMMessageRevokedListener, TIMMessageLocator tIMMessageLocator) {
        this.f30978a = tIMMessageRevokedListener;
        this.f30979b = tIMMessageLocator;
    }

    public final void run() {
        this.f30978a.onMessageRevoked(this.f30979b);
    }
}
