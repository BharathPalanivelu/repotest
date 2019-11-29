package com.shopee.app.network.c.i;

import b.a.b;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.network.c.i.r;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class s implements b<r.a> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ActivityCounter> f17982a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<n> f17983b;

    /* renamed from: a */
    public r.a get() {
        return new r.a(this.f17982a.get(), this.f17983b.get());
    }

    public static r.a a(ActivityCounter activityCounter, n nVar) {
        return new r.a(activityCounter, nVar);
    }
}
