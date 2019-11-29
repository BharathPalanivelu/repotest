package com.shopee.navigator.c;

import java.util.ArrayList;
import java.util.Iterator;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f30128a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<b> f30129b = new ArrayList<>();

    public c(String str) {
        this.f30128a = str;
    }

    public c a(b bVar) {
        this.f30129b.add(bVar);
        return this;
    }

    public b a(a aVar) {
        Iterator<b> it = this.f30129b.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.a().a(aVar)) {
                return next;
            }
        }
        return null;
    }
}
