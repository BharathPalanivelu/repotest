package com.google.a.b.a;

import com.google.a.b.b;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class a<E> extends w<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f8736a = new x() {
        public <T> w<T> create(f fVar, com.google.a.c.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type g2 = b.g(type);
            return new a(fVar, fVar.a(com.google.a.c.a.get(g2)), b.e(g2));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final Class<E> f8737b;

    /* renamed from: c  reason: collision with root package name */
    private final w<E> f8738c;

    public a(f fVar, w<E> wVar, Class<E> cls) {
        this.f8738c = new m(fVar, wVar, cls);
        this.f8737b = cls;
    }

    public Object read(com.google.a.d.a aVar) throws IOException {
        if (aVar.f() == com.google.a.d.b.NULL) {
            aVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.f8738c.read(aVar));
        }
        aVar.b();
        int size = arrayList.size();
        Object newInstance = Array.newInstance(this.f8737b, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    public void write(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        cVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f8738c.write(cVar, Array.get(obj, i));
        }
        cVar.c();
    }
}
