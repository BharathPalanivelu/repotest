package com.crashlytics.android.a;

import io.a.a.a.c;
import java.util.Locale;
import java.util.Map;

class e {

    /* renamed from: a  reason: collision with root package name */
    final int f6314a;

    /* renamed from: b  reason: collision with root package name */
    final int f6315b;

    /* renamed from: c  reason: collision with root package name */
    boolean f6316c;

    public e(int i, int i2, boolean z) {
        this.f6314a = i;
        this.f6315b = i2;
        this.f6316c = z;
    }

    public String a(String str) {
        if (str.length() <= this.f6315b) {
            return str;
        }
        a((RuntimeException) new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", new Object[]{Integer.valueOf(this.f6315b)})));
        return str.substring(0, this.f6315b);
    }

    public boolean a(Object obj, String str) {
        if (obj != null) {
            return false;
        }
        a((RuntimeException) new NullPointerException(str + " must not be null"));
        return true;
    }

    public boolean a(Map<String, Object> map, String str) {
        if (map.size() < this.f6314a || map.containsKey(str)) {
            return false;
        }
        a((RuntimeException) new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", new Object[]{Integer.valueOf(this.f6314a)})));
        return true;
    }

    private void a(RuntimeException runtimeException) {
        if (!this.f6316c) {
            c.h().e("Answers", "Invalid user input detected", runtimeException);
            return;
        }
        throw runtimeException;
    }
}
