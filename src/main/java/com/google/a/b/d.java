package com.google.a.b;

import com.google.a.a.e;
import com.google.a.b;
import com.google.a.c.a;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public final class d implements x, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final d f8856a = new d();

    /* renamed from: b  reason: collision with root package name */
    private double f8857b = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    private int f8858c = 136;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8859d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8860e;

    /* renamed from: f  reason: collision with root package name */
    private List<b> f8861f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    private List<b> f8862g = Collections.emptyList();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean a2 = a((Class<?>) rawType);
        final boolean z = a2 || b(rawType, true);
        final boolean z2 = a2 || b(rawType, false);
        if (!z && !z2) {
            return null;
        }
        final f fVar2 = fVar;
        final a<T> aVar2 = aVar;
        return new w<T>() {

            /* renamed from: f  reason: collision with root package name */
            private w<T> f8868f;

            public T read(com.google.a.d.a aVar) throws IOException {
                if (!z2) {
                    return a().read(aVar);
                }
                aVar.n();
                return null;
            }

            public void write(c cVar, T t) throws IOException {
                if (z) {
                    cVar.f();
                } else {
                    a().write(cVar, t);
                }
            }

            private w<T> a() {
                w<T> wVar = this.f8868f;
                if (wVar != null) {
                    return wVar;
                }
                w<T> a2 = fVar2.a((x) d.this, aVar2);
                this.f8868f = a2;
                return a2;
            }
        };
    }

    public boolean a(Field field, boolean z) {
        if ((this.f8858c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f8857b != -1.0d && !a((com.google.a.a.d) field.getAnnotation(com.google.a.a.d.class), (e) field.getAnnotation(e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f8860e) {
            com.google.a.a.a aVar = (com.google.a.a.a) field.getAnnotation(com.google.a.a.a.class);
            if (aVar == null || (!z ? !aVar.b() : !aVar.a())) {
                return true;
            }
        }
        if ((!this.f8859d && c(field.getType())) || b(field.getType())) {
            return true;
        }
        List<b> list = z ? this.f8861f : this.f8862g;
        if (list.isEmpty()) {
            return false;
        }
        com.google.a.c cVar = new com.google.a.c(field);
        for (b a2 : list) {
            if (a2.a(cVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Class<?> cls) {
        if (this.f8857b != -1.0d && !a((com.google.a.a.d) cls.getAnnotation(com.google.a.a.d.class), (e) cls.getAnnotation(e.class))) {
            return true;
        }
        if ((this.f8859d || !c(cls)) && !b(cls)) {
            return false;
        }
        return true;
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    private boolean b(Class<?> cls, boolean z) {
        for (b a2 : z ? this.f8861f : this.f8862g) {
            if (a2.a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean b(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.a.a.d dVar, e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.a.a.d dVar) {
        return dVar == null || dVar.a() <= this.f8857b;
    }

    private boolean a(e eVar) {
        return eVar == null || eVar.a() > this.f8857b;
    }
}
