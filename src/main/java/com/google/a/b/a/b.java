package com.google.a.b.a;

import com.google.a.b.c;
import com.google.a.b.i;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class b implements x {

    /* renamed from: a  reason: collision with root package name */
    private final c f8740a;

    public b(c cVar) {
        this.f8740a = cVar;
    }

    public <T> w<T> create(f fVar, com.google.a.c.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type a2 = com.google.a.b.b.a(type, (Class<?>) rawType);
        return new a(fVar, a2, fVar.a(com.google.a.c.a.get(a2)), this.f8740a.a(aVar));
    }

    private static final class a<E> extends w<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final w<E> f8741a;

        /* renamed from: b  reason: collision with root package name */
        private final i<? extends Collection<E>> f8742b;

        public a(f fVar, Type type, w<E> wVar, i<? extends Collection<E>> iVar) {
            this.f8741a = new m(fVar, wVar, type);
            this.f8742b = iVar;
        }

        /* renamed from: a */
        public Collection<E> read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Collection<E> collection = (Collection) this.f8742b.a();
            aVar.a();
            while (aVar.e()) {
                collection.add(this.f8741a.read(aVar));
            }
            aVar.b();
            return collection;
        }

        /* renamed from: a */
        public void write(com.google.a.d.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.f();
                return;
            }
            cVar.b();
            for (E write : collection) {
                this.f8741a.write(cVar, write);
            }
            cVar.c();
        }
    }
}
