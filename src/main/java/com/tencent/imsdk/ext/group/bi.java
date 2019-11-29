package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;

final class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f30963a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30964b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.af f30965c;

    bi(TIMGroupManagerExt.af afVar, int i, String str) {
        this.f30965c = afVar;
        this.f30963a = i;
        this.f30964b = str;
    }

    public final void run() {
        this.f30965c.a(this.f30963a, this.f30964b);
    }
}
