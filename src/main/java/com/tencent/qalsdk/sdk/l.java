package com.tencent.qalsdk.sdk;

import com.tencent.qalsdk.im_open.logParams;

final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ logParams.LogParams f32258a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ k f32259b;

    l(k kVar, logParams.LogParams logParams) {
        this.f32259b = kVar;
        this.f32258a = logParams;
    }

    public final void run() {
        k.a(this.f32259b, this.f32258a);
    }
}
