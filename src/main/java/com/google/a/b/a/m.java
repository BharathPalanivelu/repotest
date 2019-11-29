package com.google.a.b.a;

import com.google.a.b.a.i;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class m<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    private final f f8797a;

    /* renamed from: b  reason: collision with root package name */
    private final w<T> f8798b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f8799c;

    m(f fVar, w<T> wVar, Type type) {
        this.f8797a = fVar;
        this.f8798b = wVar;
        this.f8799c = type;
    }

    public T read(a aVar) throws IOException {
        return this.f8798b.read(aVar);
    }

    public void write(c cVar, T t) throws IOException {
        w<T> wVar = this.f8798b;
        Type a2 = a(this.f8799c, t);
        if (a2 != this.f8799c) {
            wVar = this.f8797a.a(com.google.a.c.a.get(a2));
            if (wVar instanceof i.a) {
                w<T> wVar2 = this.f8798b;
                if (!(wVar2 instanceof i.a)) {
                    wVar = wVar2;
                }
            }
        }
        wVar.write(cVar, t);
    }

    private Type a(Type type, Object obj) {
        if (obj != null) {
            return (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type;
        }
        return type;
    }
}
