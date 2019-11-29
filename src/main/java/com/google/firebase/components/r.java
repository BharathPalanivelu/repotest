package com.google.firebase.components;

import com.google.firebase.a.a;
import com.google.firebase.a.b;
import java.util.Map;

final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Map.Entry f6878a;

    /* renamed from: b  reason: collision with root package name */
    private final a f6879b;

    private r(Map.Entry entry, a aVar) {
        this.f6878a = entry;
        this.f6879b = aVar;
    }

    public static Runnable a(Map.Entry entry, a aVar) {
        return new r(entry, aVar);
    }

    public void run() {
        ((b) this.f6878a.getKey()).a(this.f6879b);
    }
}
