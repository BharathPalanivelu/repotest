package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;
import java.util.ArrayList;

final class bd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ArrayList f30951a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ad f30952b;

    bd(TIMGroupManagerExt.ad adVar, ArrayList arrayList) {
        this.f30952b = adVar;
        this.f30951a = arrayList;
    }

    public final void run() {
        this.f30952b.a(this.f30951a);
    }
}
