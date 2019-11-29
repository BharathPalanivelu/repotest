package com.google.a.b.a;

import com.google.a.c.a;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.util.ArrayList;

public final class h extends w<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f8763a = new x() {
        public <T> w<T> create(f fVar, a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new h(fVar);
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final f f8764b;

    h(f fVar) {
        this.f8764b = fVar;
    }

    public Object read(com.google.a.d.a aVar) throws IOException {
        switch (aVar.f()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(read(aVar));
                }
                aVar.b();
                return arrayList;
            case BEGIN_OBJECT:
                com.google.a.b.h hVar = new com.google.a.b.h();
                aVar.c();
                while (aVar.e()) {
                    hVar.put(aVar.g(), read(aVar));
                }
                aVar.d();
                return hVar;
            case STRING:
                return aVar.h();
            case NUMBER:
                return Double.valueOf(aVar.k());
            case BOOLEAN:
                return Boolean.valueOf(aVar.i());
            case NULL:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public void write(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        w<?> a2 = this.f8764b.a(obj.getClass());
        if (a2 instanceof h) {
            cVar.d();
            cVar.e();
            return;
        }
        a2.write(cVar, obj);
    }
}
