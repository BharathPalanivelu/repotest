package com.google.firebase.components;

import com.google.firebase.a.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class u extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<?>> f6883a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Class<?>> f6884b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Class<?>> f6885c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<Class<?>> f6886d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<Class<?>> f6887e;

    /* renamed from: f  reason: collision with root package name */
    private final e f6888f;

    u(b<?> bVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (n next : bVar.b()) {
            if (next.d()) {
                if (next.c()) {
                    hashSet3.add(next.a());
                } else {
                    hashSet.add(next.a());
                }
            } else if (next.c()) {
                hashSet4.add(next.a());
            } else {
                hashSet2.add(next.a());
            }
        }
        if (!bVar.d().isEmpty()) {
            hashSet.add(c.class);
        }
        this.f6883a = Collections.unmodifiableSet(hashSet);
        this.f6884b = Collections.unmodifiableSet(hashSet2);
        this.f6885c = Collections.unmodifiableSet(hashSet3);
        this.f6886d = Collections.unmodifiableSet(hashSet4);
        this.f6887e = bVar.d();
        this.f6888f = eVar;
    }

    public <T> T a(Class<T> cls) {
        if (this.f6883a.contains(cls)) {
            T a2 = this.f6888f.a(cls);
            if (!cls.equals(c.class)) {
                return a2;
            }
            return new a(this.f6887e, (c) a2);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public <T> com.google.firebase.b.a<T> c(Class<T> cls) {
        if (this.f6884b.contains(cls)) {
            return this.f6888f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{cls}));
    }

    public <T> com.google.firebase.b.a<Set<T>> d(Class<T> cls) {
        if (this.f6886d.contains(cls)) {
            return this.f6888f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{cls}));
    }

    public <T> Set<T> b(Class<T> cls) {
        if (this.f6885c.contains(cls)) {
            return this.f6888f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{cls}));
    }

    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<?>> f6889a;

        /* renamed from: b  reason: collision with root package name */
        private final c f6890b;

        public a(Set<Class<?>> set, c cVar) {
            this.f6889a = set;
            this.f6890b = cVar;
        }
    }
}
