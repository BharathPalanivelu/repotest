package com.tencent.imsdk;

final class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMUploadProgressListener f30707a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMMessage f30708b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ int f30709c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ int f30710d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ int f30711e;

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ IMCoreNotify f30712f;

    an(IMCoreNotify iMCoreNotify, TIMUploadProgressListener tIMUploadProgressListener, TIMMessage tIMMessage, int i, int i2, int i3) {
        this.f30712f = iMCoreNotify;
        this.f30707a = tIMUploadProgressListener;
        this.f30708b = tIMMessage;
        this.f30709c = i;
        this.f30710d = i2;
        this.f30711e = i3;
    }

    public final void run() {
        this.f30707a.onMessagesUpdate(this.f30708b, this.f30709c, this.f30710d, this.f30711e);
    }
}
