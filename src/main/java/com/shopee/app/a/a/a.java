package com.shopee.app.a.a;

import androidx.lifecycle.e;
import androidx.lifecycle.g;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final e f15756a;

    public a(com.shopee.app.ui.a.e eVar) {
        j.b(eVar, "activity");
        e lifecycle = eVar.getLifecycle();
        j.a((Object) lifecycle, "activity.lifecycle");
        this.f15756a = lifecycle;
    }

    public final void a(g gVar) {
        j.b(gVar, "observer");
        this.f15756a.a(gVar);
    }
}
