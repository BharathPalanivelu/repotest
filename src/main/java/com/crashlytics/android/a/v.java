package com.crashlytics.android.a;

import com.crashlytics.android.a.v;

public abstract class v<T extends v> extends d<T> {

    /* renamed from: d  reason: collision with root package name */
    final c f6363d;

    /* access modifiers changed from: package-private */
    public abstract String a();

    public String toString() {
        return "{type:\"" + a() + '\"' + ", predefinedAttributes:" + this.f6363d + ", customAttributes:" + this.f6313c + "}";
    }
}
