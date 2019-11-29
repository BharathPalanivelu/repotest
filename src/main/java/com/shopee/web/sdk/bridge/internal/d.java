package com.shopee.web.sdk.bridge.internal;

import android.text.TextUtils;

public class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f30487a;

    /* renamed from: b  reason: collision with root package name */
    private final c f30488b;

    d(String str, c cVar) {
        this.f30487a = str;
        this.f30488b = cVar;
    }

    public void a(T t) {
        if (!TextUtils.isEmpty(this.f30487a)) {
            this.f30488b.a(this.f30487a, (Object) t);
        }
    }
}
