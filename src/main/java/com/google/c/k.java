package com.google.c;

import com.google.c.a;
import com.google.c.j;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class k extends a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final j.a f13972a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final q<j.f> f13973b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final j.f[] f13974c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final at f13975d;

    /* renamed from: e  reason: collision with root package name */
    private int f13976e = -1;

    k(j.a aVar, q<j.f> qVar, j.f[] fVarArr, at atVar) {
        this.f13972a = aVar;
        this.f13973b = qVar;
        this.f13974c = fVarArr;
        this.f13975d = atVar;
    }

    public static k a(j.a aVar) {
        return new k(aVar, q.b(), new j.f[aVar.j().u()], at.f());
    }

    public static a b(j.a aVar) {
        return new a(aVar);
    }

    public j.a g() {
        return this.f13972a;
    }

    /* renamed from: h */
    public k L() {
        return a(this.f13972a);
    }

    public Map<j.f, Object> o_() {
        return this.f13973b.f();
    }

    public boolean a(j.C0232j jVar) {
        c(jVar);
        return this.f13974c[jVar.a()] != null;
    }

    public j.f b(j.C0232j jVar) {
        c(jVar);
        return this.f13974c[jVar.a()];
    }

    public boolean a(j.f fVar) {
        c(fVar);
        return this.f13973b.a(fVar);
    }

    public Object b(j.f fVar) {
        c(fVar);
        Object b2 = this.f13973b.b(fVar);
        if (b2 != null) {
            return b2;
        }
        if (fVar.p()) {
            return Collections.emptyList();
        }
        if (fVar.g() == j.f.a.MESSAGE) {
            return a(fVar.y());
        }
        return fVar.s();
    }

    public at f() {
        return this.f13975d;
    }

    static boolean a(j.a aVar, q<j.f> qVar) {
        for (j.f next : aVar.f()) {
            if (next.n() && !qVar.a(next)) {
                return false;
            }
        }
        return qVar.h();
    }

    public boolean a() {
        return a(this.f13972a, this.f13973b);
    }

    public void a(h hVar) throws IOException {
        if (this.f13972a.e().i()) {
            this.f13973b.b(hVar);
            this.f13975d.b(hVar);
            return;
        }
        this.f13973b.a(hVar);
        this.f13975d.a(hVar);
    }

    public int b() {
        int i;
        int i2;
        int i3 = this.f13976e;
        if (i3 != -1) {
            return i3;
        }
        if (this.f13972a.e().i()) {
            i2 = this.f13973b.j();
            i = this.f13975d.i();
        } else {
            i2 = this.f13973b.i();
            i = this.f13975d.b();
        }
        int i4 = i2 + i;
        this.f13976e = i4;
        return i4;
    }

    /* renamed from: j */
    public a J() {
        return new a(this.f13972a);
    }

    /* renamed from: k */
    public a I() {
        return J().c((ac) this);
    }

    public aj<k> F() {
        return new c<k>() {
            /* renamed from: a */
            public k b(g gVar, p pVar) throws v {
                a b2 = k.b(k.this.f13972a);
                try {
                    b2.c(gVar, pVar);
                    return b2.v();
                } catch (v e2) {
                    throw e2.a(b2.v());
                } catch (IOException e3) {
                    throw new v(e3.getMessage()).a(b2.v());
                }
            }
        };
    }

    private void c(j.f fVar) {
        if (fVar.v() != this.f13972a) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    private void c(j.C0232j jVar) {
        if (jVar.b() != this.f13972a) {
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }
    }

    public static final class a extends a.C0223a<a> {

        /* renamed from: a  reason: collision with root package name */
        private final j.a f13978a;

        /* renamed from: b  reason: collision with root package name */
        private q<j.f> f13979b;

        /* renamed from: c  reason: collision with root package name */
        private final j.f[] f13980c;

        /* renamed from: d  reason: collision with root package name */
        private at f13981d;

        private a(j.a aVar) {
            this.f13978a = aVar;
            this.f13979b = q.a();
            this.f13981d = at.f();
            this.f13980c = new j.f[aVar.j().u()];
        }

        /* renamed from: d */
        public a c(ac acVar) {
            if (!(acVar instanceof k)) {
                return (a) super.c(acVar);
            }
            k kVar = (k) acVar;
            if (kVar.f13972a == this.f13978a) {
                l();
                this.f13979b.a(kVar.f13973b);
                a(kVar.f13975d);
                int i = 0;
                while (true) {
                    j.f[] fVarArr = this.f13980c;
                    if (i >= fVarArr.length) {
                        return this;
                    }
                    if (fVarArr[i] == null) {
                        fVarArr[i] = kVar.f13974c[i];
                    } else if (!(kVar.f13974c[i] == null || this.f13980c[i] == kVar.f13974c[i])) {
                        this.f13979b.c(this.f13980c[i]);
                        this.f13980c[i] = kVar.f13974c[i];
                    }
                    i++;
                }
            } else {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
        }

        /* renamed from: e */
        public k w() {
            if (a()) {
                return v();
            }
            j.a aVar = this.f13978a;
            q<j.f> qVar = this.f13979b;
            j.f[] fVarArr = this.f13980c;
            throw b((ac) new k(aVar, qVar, (j.f[]) Arrays.copyOf(fVarArr, fVarArr.length), this.f13981d));
        }

        /* renamed from: h */
        public k v() {
            this.f13979b.c();
            j.a aVar = this.f13978a;
            q<j.f> qVar = this.f13979b;
            j.f[] fVarArr = this.f13980c;
            return new k(aVar, qVar, (j.f[]) Arrays.copyOf(fVarArr, fVarArr.length), this.f13981d);
        }

        /* renamed from: j */
        public a d() {
            a aVar = new a(this.f13978a);
            aVar.f13979b.a(this.f13979b);
            aVar.a(this.f13981d);
            j.f[] fVarArr = this.f13980c;
            System.arraycopy(fVarArr, 0, aVar.f13980c, 0, fVarArr.length);
            return aVar;
        }

        public boolean a() {
            return k.a(this.f13978a, this.f13979b);
        }

        public j.a g() {
            return this.f13978a;
        }

        /* renamed from: k */
        public k L() {
            return k.a(this.f13978a);
        }

        public Map<j.f, Object> o_() {
            return this.f13979b.f();
        }

        /* renamed from: c */
        public a d(j.f fVar) {
            e(fVar);
            if (fVar.g() == j.f.a.MESSAGE) {
                return new a(fVar.y());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        public boolean a(j.C0232j jVar) {
            c(jVar);
            return this.f13980c[jVar.a()] != null;
        }

        public j.f b(j.C0232j jVar) {
            c(jVar);
            return this.f13980c[jVar.a()];
        }

        public boolean a(j.f fVar) {
            e(fVar);
            return this.f13979b.a(fVar);
        }

        public Object b(j.f fVar) {
            e(fVar);
            Object b2 = this.f13979b.b(fVar);
            if (b2 != null) {
                return b2;
            }
            if (fVar.p()) {
                return Collections.emptyList();
            }
            if (fVar.g() == j.f.a.MESSAGE) {
                return k.a(fVar.y());
            }
            return fVar.s();
        }

        /* renamed from: a */
        public a f(j.f fVar, Object obj) {
            e(fVar);
            l();
            if (fVar.i() == j.f.b.ENUM) {
                d(fVar, obj);
            }
            j.C0232j w = fVar.w();
            if (w != null) {
                int a2 = w.a();
                j.f fVar2 = this.f13980c[a2];
                if (!(fVar2 == null || fVar2 == fVar)) {
                    this.f13979b.c(fVar2);
                }
                this.f13980c[a2] = fVar;
            } else if (fVar.d().i() == j.g.b.PROTO3 && !fVar.p() && fVar.g() != j.f.a.MESSAGE && obj.equals(fVar.s())) {
                this.f13979b.c(fVar);
                return this;
            }
            this.f13979b.a(fVar, obj);
            return this;
        }

        /* renamed from: b */
        public a e(j.f fVar, Object obj) {
            e(fVar);
            l();
            this.f13979b.b(fVar, obj);
            return this;
        }

        public at f() {
            return this.f13981d;
        }

        /* renamed from: b */
        public a f(at atVar) {
            if (g().d().i() == j.g.b.PROTO3) {
                return this;
            }
            this.f13981d = atVar;
            return this;
        }

        /* renamed from: c */
        public a a(at atVar) {
            if (g().d().i() == j.g.b.PROTO3) {
                return this;
            }
            this.f13981d = at.a(this.f13981d).a(atVar).w();
            return this;
        }

        private void e(j.f fVar) {
            if (fVar.v() != this.f13978a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void c(j.C0232j jVar) {
            if (jVar.b() != this.f13978a) {
                throw new IllegalArgumentException("OneofDescriptor does not match message type.");
            }
        }

        private void c(j.f fVar, Object obj) {
            if (obj == null) {
                throw new NullPointerException();
            } else if (!(obj instanceof j.e)) {
                throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
            }
        }

        private void d(j.f fVar, Object obj) {
            if (fVar.p()) {
                for (Object c2 : (List) obj) {
                    c(fVar, c2);
                }
                return;
            }
            c(fVar, obj);
        }

        private void l() {
            if (this.f13979b.d()) {
                this.f13979b = this.f13979b.clone();
            }
        }
    }
}
