package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;
import java.util.ArrayList;

final class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ArrayList f30946a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ac f30947b;

    bb(TIMGroupManagerExt.ac acVar, ArrayList arrayList) {
        this.f30947b = acVar;
        this.f30946a = arrayList;
    }

    public final void run() {
        this.f30947b.a(this.f30946a);
    }
}
