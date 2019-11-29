package com.tencent.imsdk;

final class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMUploadProgressListener f30703a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ int f30704b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ int f30705c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ IMCoreNotify f30706d;

    am(IMCoreNotify iMCoreNotify, TIMUploadProgressListener tIMUploadProgressListener, int i, int i2) {
        this.f30706d = iMCoreNotify;
        this.f30703a = tIMUploadProgressListener;
        this.f30704b = i;
        this.f30705c = i2;
    }

    public final void run() {
        this.f30703a.onMessagesUpdate((TIMMessage) null, 0, this.f30704b, this.f30705c);
    }
}
