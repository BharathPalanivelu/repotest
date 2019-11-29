package com.airbnb.lottie;

import java.util.Map;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f3777a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3778b;

    private String b(String str) {
        return str;
    }

    public final String a(String str) {
        if (this.f3778b && this.f3777a.containsKey(str)) {
            return this.f3777a.get(str);
        }
        String b2 = b(str);
        if (this.f3778b) {
            this.f3777a.put(str, b2);
        }
        return b2;
    }
}
