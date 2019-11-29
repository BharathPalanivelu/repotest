package f.a.a;

import f.c;
import f.m;
import f.n;
import io.b.b;
import io.b.f;
import io.b.g;
import io.b.j;
import io.b.p;
import io.b.q;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class h extends c.a {

    /* renamed from: a  reason: collision with root package name */
    private final p f32887a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32888b;

    public static h a() {
        return new h((p) null, false);
    }

    private h(p pVar, boolean z) {
        this.f32887a = pVar;
        this.f32888b = z;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        boolean z;
        boolean z2;
        Type type2;
        Class<?> a2 = a(type);
        if (a2 == b.class) {
            return new g(Void.class, this.f32887a, this.f32888b, false, true, false, false, false, true);
        }
        boolean z3 = a2 == f.class;
        boolean z4 = a2 == q.class;
        boolean z5 = a2 == g.class;
        if (a2 != j.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type a3 = a(0, (ParameterizedType) type);
        Class<?> a4 = a(a3);
        if (a4 == m.class) {
            if (a3 instanceof ParameterizedType) {
                type2 = a(0, (ParameterizedType) a3);
                z2 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (a4 != e.class) {
            type2 = a3;
            z2 = false;
            z = true;
            return new g(type2, this.f32887a, this.f32888b, z2, z, z3, z4, z5, false);
        } else if (a3 instanceof ParameterizedType) {
            type2 = a(0, (ParameterizedType) a3);
            z2 = true;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        z = false;
        return new g(type2, this.f32887a, this.f32888b, z2, z, z3, z4, z5, false);
    }
}
