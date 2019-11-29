package com.google.a.b.a;

import com.google.a.b.c;
import com.google.a.b.d;
import com.google.a.b.k;
import com.google.a.e;
import com.google.a.f;
import com.google.a.u;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class i implements x {

    /* renamed from: a  reason: collision with root package name */
    private final c f8766a;

    /* renamed from: b  reason: collision with root package name */
    private final e f8767b;

    /* renamed from: c  reason: collision with root package name */
    private final d f8768c;

    /* renamed from: d  reason: collision with root package name */
    private final d f8769d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.a.b.b.b f8770e = com.google.a.b.b.b.a();

    public i(c cVar, e eVar, d dVar, d dVar2) {
        this.f8766a = cVar;
        this.f8767b = eVar;
        this.f8768c = dVar;
        this.f8769d = dVar2;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.f8768c);
    }

    static boolean a(Field field, boolean z, d dVar) {
        return !dVar.a(field.getType(), z) && !dVar.a(field, z);
    }

    private List<String> a(Field field) {
        com.google.a.a.c cVar = (com.google.a.a.c) field.getAnnotation(com.google.a.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f8767b.translateName(field));
        }
        String a2 = cVar.a();
        String[] b2 = cVar.b();
        if (b2.length == 0) {
            return Collections.singletonList(a2);
        }
        ArrayList arrayList = new ArrayList(b2.length + 1);
        arrayList.add(a2);
        for (String add : b2) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public <T> w<T> create(f fVar, com.google.a.c.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new a(this.f8766a.a(aVar), a(fVar, (com.google.a.c.a<?>) aVar, (Class<?>) rawType));
    }

    private b a(f fVar, Field field, String str, com.google.a.c.a<?> aVar, boolean z, boolean z2) {
        f fVar2 = fVar;
        com.google.a.c.a<?> aVar2 = aVar;
        final boolean a2 = k.a((Type) aVar.getRawType());
        Field field2 = field;
        com.google.a.a.b bVar = (com.google.a.a.b) field.getAnnotation(com.google.a.a.b.class);
        w<?> a3 = bVar != null ? this.f8769d.a(this.f8766a, fVar, aVar2, bVar) : null;
        final boolean z3 = a3 != null;
        if (a3 == null) {
            a3 = fVar.a(aVar2);
        }
        final w<?> wVar = a3;
        final Field field3 = field;
        final f fVar3 = fVar;
        final com.google.a.c.a<?> aVar3 = aVar;
        return new b(str, z, z2) {
            /* access modifiers changed from: package-private */
            public void a(com.google.a.d.c cVar, Object obj) throws IOException, IllegalAccessException {
                w wVar;
                Object obj2 = field3.get(obj);
                if (z3) {
                    wVar = wVar;
                } else {
                    wVar = new m(fVar3, wVar, aVar3.getType());
                }
                wVar.write(cVar, obj2);
            }

            /* access modifiers changed from: package-private */
            public void a(com.google.a.d.a aVar, Object obj) throws IOException, IllegalAccessException {
                Object read = wVar.read(aVar);
                if (read != null || !a2) {
                    field3.set(obj, read);
                }
            }

            public boolean a(Object obj) throws IOException, IllegalAccessException {
                if (this.i && field3.get(obj) != obj) {
                    return true;
                }
                return false;
            }
        };
    }

    private Map<String, b> a(f fVar, com.google.a.c.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        com.google.a.c.a<?> aVar2 = aVar;
        Class<? super Object> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean a2 = a(field, true);
                boolean a3 = a(field, z);
                if (a2 || a3) {
                    this.f8770e.a(field);
                    Type a4 = com.google.a.b.b.a(aVar2.getType(), (Class<?>) cls2, field.getGenericType());
                    List<String> a5 = a(field);
                    int size = a5.size();
                    b bVar = null;
                    int i2 = 0;
                    while (i2 < size) {
                        String str = a5.get(i2);
                        boolean z2 = i2 != 0 ? false : a2;
                        String str2 = str;
                        b bVar2 = bVar;
                        int i3 = i2;
                        int i4 = size;
                        List<String> list = a5;
                        Field field2 = field;
                        bVar = bVar2 == null ? (b) linkedHashMap.put(str2, a(fVar, field, str2, com.google.a.c.a.get(a4), z2, a3)) : bVar2;
                        i2 = i3 + 1;
                        a2 = z2;
                        a5 = list;
                        size = i4;
                        field = field2;
                    }
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + bVar3.h);
                    }
                }
                i++;
                z = false;
            }
            aVar2 = com.google.a.c.a.get(com.google.a.b.b.a(aVar2.getType(), (Class<?>) cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.getRawType();
        }
        return linkedHashMap;
    }

    static abstract class b {
        final String h;
        final boolean i;
        final boolean j;

        /* access modifiers changed from: package-private */
        public abstract void a(com.google.a.d.a aVar, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void a(com.google.a.d.c cVar, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract boolean a(Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.h = str;
            this.i = z;
            this.j = z2;
        }
    }

    public static final class a<T> extends w<T> {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.a.b.i<T> f8778a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, b> f8779b;

        a(com.google.a.b.i<T> iVar, Map<String, b> map) {
            this.f8778a = iVar;
            this.f8779b = map;
        }

        public T read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            T a2 = this.f8778a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.f8779b.get(aVar.g());
                    if (bVar != null) {
                        if (bVar.j) {
                            bVar.a(aVar, (Object) a2);
                        }
                    }
                    aVar.n();
                }
                aVar.d();
                return a2;
            } catch (IllegalStateException e2) {
                throw new u((Throwable) e2);
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        public void write(com.google.a.d.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.f();
                return;
            }
            cVar.d();
            try {
                for (b next : this.f8779b.values()) {
                    if (next.a(t)) {
                        cVar.a(next.h);
                        next.a(cVar, (Object) t);
                    }
                }
                cVar.e();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }
}
