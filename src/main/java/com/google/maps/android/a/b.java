package com.google.maps.android.a;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class b extends Observable {

    /* renamed from: a  reason: collision with root package name */
    private final String f14382a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f14383b;

    /* renamed from: c  reason: collision with root package name */
    private c f14384c;

    public b(c cVar, String str, Map<String, String> map) {
        this.f14384c = cVar;
        this.f14382a = str;
        if (map == null) {
            this.f14383b = new HashMap();
        } else {
            this.f14383b = map;
        }
    }

    public Iterable a() {
        return this.f14383b.entrySet();
    }

    public String a(String str) {
        return this.f14383b.get(str);
    }

    public String b() {
        return this.f14382a;
    }

    public boolean b(String str) {
        return this.f14383b.containsKey(str);
    }

    public c c() {
        return this.f14384c;
    }

    public boolean d() {
        return this.f14384c != null;
    }
}
