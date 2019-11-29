package com.shopee.live.livestreaming.util;

import java.util.LinkedList;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<String> f29483a = new LinkedList<>();

    public void a(String str) {
        if (this.f29483a.size() >= 20) {
            this.f29483a.removeLast();
        }
        this.f29483a.addFirst(str);
    }

    public String a() {
        if (this.f29483a.isEmpty()) {
            return "";
        }
        return this.f29483a.removeFirst();
    }
}
