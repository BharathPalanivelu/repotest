package com.airbnb.lottie.c;

import androidx.b.e;
import com.airbnb.lottie.d;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final g f3647a = new g();

    /* renamed from: b  reason: collision with root package name */
    private final e<String, d> f3648b = new e<>(10485760);

    public static g a() {
        return f3647a;
    }

    g() {
    }

    public d a(String str) {
        if (str == null) {
            return null;
        }
        return this.f3648b.get(str);
    }

    public void a(String str, d dVar) {
        if (str != null) {
            this.f3648b.put(str, dVar);
        }
    }
}
