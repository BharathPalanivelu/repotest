package com.shopee.app.a;

import android.app.Activity;
import b.a.b;
import b.a.c;

public final class d implements b<Activity> {

    /* renamed from: a  reason: collision with root package name */
    private final b f15759a;

    public d(b bVar) {
        this.f15759a = bVar;
    }

    /* renamed from: a */
    public Activity get() {
        return (Activity) c.a(this.f15759a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static d a(b bVar) {
        return new d(bVar);
    }
}
