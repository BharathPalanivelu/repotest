package com.tencent.qalsdk;

import android.content.Context;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f32141a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f32142b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ byte[] f32143c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ Context f32144d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ QALOfflinePushListener f32145e;

    a(QALBroadcastReceiver qALBroadcastReceiver, String str, String str2, byte[] bArr, Context context, QALOfflinePushListener qALOfflinePushListener) {
        this.f32141a = str;
        this.f32142b = str2;
        this.f32143c = bArr;
        this.f32144d = context;
        this.f32145e = qALOfflinePushListener;
    }

    public final void run() {
        QALOffLineMsg qALOffLineMsg = new QALOffLineMsg();
        qALOffLineMsg.setID(this.f32141a);
        qALOffLineMsg.setCmd(this.f32142b);
        qALOffLineMsg.setBody(this.f32143c);
        qALOffLineMsg.setContext(this.f32144d);
        this.f32145e.onPushMsg(qALOffLineMsg);
    }
}
