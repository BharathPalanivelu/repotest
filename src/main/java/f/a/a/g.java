package f.a.a;

import f.b;
import f.c;
import io.b.a;
import io.b.j;
import io.b.p;
import java.lang.reflect.Type;

final class g<R> implements c<R, Object> {

    /* renamed from: a  reason: collision with root package name */
    private final Type f32880a;

    /* renamed from: b  reason: collision with root package name */
    private final p f32881b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f32882c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32883d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f32884e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f32885f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f32886g;
    private final boolean h;
    private final boolean i;

    g(Type type, p pVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f32880a = type;
        this.f32881b = pVar;
        this.f32882c = z;
        this.f32883d = z2;
        this.f32884e = z3;
        this.f32885f = z4;
        this.f32886g = z5;
        this.h = z6;
        this.i = z7;
    }

    public Type a() {
        return this.f32880a;
    }

    public Object a(b<R> bVar) {
        j jVar;
        j jVar2;
        if (this.f32882c) {
            jVar = new b(bVar);
        } else {
            jVar = new c(bVar);
        }
        if (this.f32883d) {
            jVar2 = new f(jVar);
        } else {
            jVar2 = this.f32884e ? new a(jVar) : jVar;
        }
        p pVar = this.f32881b;
        if (pVar != null) {
            jVar2 = jVar2.b(pVar);
        }
        if (this.f32885f) {
            return jVar2.a(a.LATEST);
        }
        if (this.f32886g) {
            return jVar2.g();
        }
        if (this.h) {
            return jVar2.f();
        }
        return this.i ? jVar2.e() : jVar2;
    }
}
