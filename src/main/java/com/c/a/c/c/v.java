package com.c.a.c.c;

import com.c.a.c.a.b;
import com.c.a.c.c.n;
import com.c.a.c.j;
import com.c.a.g;

public class v<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final v<?> f5980a = new v<>();

    public boolean a(Model model) {
        return true;
    }

    public static <T> v<T> a() {
        return f5980a;
    }

    public n.a<Model> a(Model model, int i, int i2, j jVar) {
        return new n.a<>(new com.c.a.h.b(model), new b(model));
    }

    private static class b<Model> implements com.c.a.c.a.b<Model> {

        /* renamed from: a  reason: collision with root package name */
        private final Model f5982a;

        public void a() {
        }

        public void b() {
        }

        public b(Model model) {
            this.f5982a = model;
        }

        public void a(g gVar, b.a<? super Model> aVar) {
            aVar.a(this.f5982a);
        }

        public Class<Model> d() {
            return this.f5982a.getClass();
        }

        public com.c.a.c.a c() {
            return com.c.a.c.a.LOCAL;
        }
    }

    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final a<?> f5981a = new a<>();

        public static <T> a<T> a() {
            return f5981a;
        }

        public n<Model, Model> a(r rVar) {
            return v.a();
        }
    }
}
