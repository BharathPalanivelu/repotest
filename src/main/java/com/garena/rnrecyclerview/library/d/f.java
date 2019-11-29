package com.garena.rnrecyclerview.library.d;

import java.util.HashMap;
import java.util.Map;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, String> f8570a = new HashMap();

    public void a(int i, String str) {
        this.f8570a.put(Integer.valueOf(i), str);
    }

    public String a(int i) {
        return this.f8570a.get(Integer.valueOf(i));
    }
}
