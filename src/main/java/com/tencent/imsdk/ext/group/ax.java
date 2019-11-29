package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;
import java.util.ArrayList;

final class ax implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ArrayList f30936a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.aa f30937b;

    ax(TIMGroupManagerExt.aa aaVar, ArrayList arrayList) {
        this.f30937b = aaVar;
        this.f30936a = arrayList;
    }

    public final void run() {
        this.f30937b.a(this.f30936a);
    }
}
