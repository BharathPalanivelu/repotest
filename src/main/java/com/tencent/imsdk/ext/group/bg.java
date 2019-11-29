package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class bg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30958a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30959b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ae f30960c;

    bg(TIMGroupManagerExt.ae aeVar, int i, String str) {
        this.f30960c = aeVar;
        this.f30958a = i;
        this.f30959b = str;
    }

    public final void run() {
        this.f30960c.a(this.f30958a, this.f30959b);
    }
}
