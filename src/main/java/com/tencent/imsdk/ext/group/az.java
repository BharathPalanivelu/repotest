package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.ext.group.TIMGroupManagerExt;
import java.util.ArrayList;

final class az implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ArrayList f30941a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt.ab f30942b;

    az(TIMGroupManagerExt.ab abVar, ArrayList arrayList) {
        this.f30942b = abVar;
        this.f30941a = arrayList;
    }

    public final void run() {
        this.f30942b.a(this.f30941a);
    }
}
