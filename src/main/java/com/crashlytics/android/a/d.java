package com.crashlytics.android.a;

import com.crashlytics.android.a.d;
import io.a.a.a.c;
import java.util.Map;

public abstract class d<T extends d> {

    /* renamed from: b  reason: collision with root package name */
    final e f6312b = new e(20, 100, c.i());

    /* renamed from: c  reason: collision with root package name */
    final c f6313c = new c(this.f6312b);

    /* access modifiers changed from: package-private */
    public Map<String, Object> b() {
        return this.f6313c.f6311b;
    }

    public T a(String str, String str2) {
        this.f6313c.a(str, str2);
        return this;
    }
}
