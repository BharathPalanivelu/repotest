package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;
import java.util.ArrayList;

final class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ArrayList f30971a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ah f30972b;

    bl(TIMGroupManagerExt.ah ahVar, ArrayList arrayList) {
        this.f30972b = ahVar;
        this.f30971a = arrayList;
    }

    public final void run() {
        this.f30972b.a(this.f30971a);
    }
}
