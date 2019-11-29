package com.google.firebase.c;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f6840b;

    /* renamed from: a  reason: collision with root package name */
    private final Set<e> f6841a = new HashSet();

    d() {
    }

    /* access modifiers changed from: package-private */
    public Set<e> a() {
        Set<e> unmodifiableSet;
        synchronized (this.f6841a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f6841a);
        }
        return unmodifiableSet;
    }

    public static d b() {
        d dVar = f6840b;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f6840b;
                if (dVar == null) {
                    dVar = new d();
                    f6840b = dVar;
                }
            }
        }
        return dVar;
    }
}
