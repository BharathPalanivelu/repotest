package com.google.firebase.components;

import com.google.firebase.b.a;

final /* synthetic */ class j implements a {

    /* renamed from: a  reason: collision with root package name */
    private final i f6863a;

    /* renamed from: b  reason: collision with root package name */
    private final b f6864b;

    private j(i iVar, b bVar) {
        this.f6863a = iVar;
        this.f6864b = bVar;
    }

    public static a a(i iVar, b bVar) {
        return new j(iVar, bVar);
    }

    public Object a() {
        return this.f6864b.c().a(new u(this.f6864b, this.f6863a));
    }
}
