package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<? super T>> f6842a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<n> f6843b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6844c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6845d;

    /* renamed from: e  reason: collision with root package name */
    private final g<T> f6846e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<Class<?>> f6847f;

    static /* synthetic */ Object a(Object obj, e eVar) {
        return obj;
    }

    static /* synthetic */ Object b(Object obj, e eVar) {
        return obj;
    }

    private b(Set<Class<? super T>> set, Set<n> set2, int i, int i2, g<T> gVar, Set<Class<?>> set3) {
        this.f6842a = Collections.unmodifiableSet(set);
        this.f6843b = Collections.unmodifiableSet(set2);
        this.f6844c = i;
        this.f6845d = i2;
        this.f6846e = gVar;
        this.f6847f = Collections.unmodifiableSet(set3);
    }

    public Set<Class<? super T>> a() {
        return this.f6842a;
    }

    public Set<n> b() {
        return this.f6843b;
    }

    public g<T> c() {
        return this.f6846e;
    }

    public Set<Class<?>> d() {
        return this.f6847f;
    }

    public boolean e() {
        return this.f6844c == 1;
    }

    public boolean f() {
        return this.f6844c == 2;
    }

    public boolean g() {
        return this.f6845d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f6842a.toArray()) + ">{" + this.f6844c + ", type=" + this.f6845d + ", deps=" + Arrays.toString(this.f6843b.toArray()) + "}";
    }

    @KeepForSdk
    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls, new Class[0]);
    }

    @KeepForSdk
    @SafeVarargs
    public static <T> a<T> a(Class<T> cls, Class<? super T>... clsArr) {
        return new a<>(cls, clsArr);
    }

    @KeepForSdk
    @SafeVarargs
    public static <T> b<T> a(T t, Class<T> cls, Class<? super T>... clsArr) {
        return a(cls, clsArr).a(c.a((Object) t)).c();
    }

    @KeepForSdk
    public static <T> a<T> b(Class<T> cls) {
        return a(cls).d();
    }

    @KeepForSdk
    public static <T> b<T> a(T t, Class<T> cls) {
        return b(cls).a(d.a((Object) t)).c();
    }

    @KeepForSdk
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<? super T>> f6848a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<n> f6849b;

        /* renamed from: c  reason: collision with root package name */
        private int f6850c;

        /* renamed from: d  reason: collision with root package name */
        private int f6851d;

        /* renamed from: e  reason: collision with root package name */
        private g<T> f6852e;

        /* renamed from: f  reason: collision with root package name */
        private Set<Class<?>> f6853f;

        @SafeVarargs
        private a(Class<T> cls, Class<? super T>... clsArr) {
            this.f6848a = new HashSet();
            this.f6849b = new HashSet();
            this.f6850c = 0;
            this.f6851d = 0;
            this.f6853f = new HashSet();
            Preconditions.checkNotNull(cls, "Null interface");
            this.f6848a.add(cls);
            for (Class<? super T> checkNotNull : clsArr) {
                Preconditions.checkNotNull(checkNotNull, "Null interface");
            }
            Collections.addAll(this.f6848a, clsArr);
        }

        @KeepForSdk
        public a<T> a(n nVar) {
            Preconditions.checkNotNull(nVar, "Null dependency");
            a(nVar.a());
            this.f6849b.add(nVar);
            return this;
        }

        @KeepForSdk
        public a<T> a() {
            return a(1);
        }

        @KeepForSdk
        public a<T> b() {
            return a(2);
        }

        private a<T> a(int i) {
            Preconditions.checkState(this.f6850c == 0, "Instantiation type has already been set.");
            this.f6850c = i;
            return this;
        }

        private void a(Class<?> cls) {
            Preconditions.checkArgument(!this.f6848a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        @KeepForSdk
        public a<T> a(g<T> gVar) {
            this.f6852e = (g) Preconditions.checkNotNull(gVar, "Null factory");
            return this;
        }

        /* access modifiers changed from: private */
        public a<T> d() {
            this.f6851d = 1;
            return this;
        }

        @KeepForSdk
        public b<T> c() {
            Preconditions.checkState(this.f6852e != null, "Missing required property: factory.");
            return new b(new HashSet(this.f6848a), new HashSet(this.f6849b), this.f6850c, this.f6851d, this.f6852e, this.f6853f);
        }
    }
}
