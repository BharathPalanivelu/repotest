package com.google.c;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.c.ac;
import com.google.c.ah;
import com.google.c.at;
import com.google.c.b;
import com.google.c.j;
import com.google.c.u;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a extends b implements ac {
    protected int memoizedSize = -1;

    protected interface b {
        void a();
    }

    public boolean a() {
        return ah.a(this);
    }

    /* access modifiers changed from: protected */
    public ac.a a(b bVar) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    public boolean a(j.C0232j jVar) {
        throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }

    public j.f b(j.C0232j jVar) {
        throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }

    public final String toString() {
        return ap.a((ag) this);
    }

    public void a(h hVar) throws IOException {
        ah.a((ac) this, o_(), hVar, false);
    }

    public int b() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        this.memoizedSize = ah.a(this, o_());
        return this.memoizedSize;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        if (g() == acVar.g() && a(o_(), acVar.o_()) && f().equals(acVar.f())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int a2 = (a(779 + g().hashCode(), o_()) * 29) + f().hashCode();
        this.memoizedHashCode = a2;
        return a2;
    }

    private static f a(Object obj) {
        if (obj instanceof byte[]) {
            return f.a((byte[]) obj);
        }
        return (f) obj;
    }

    private static boolean a(Object obj, Object obj2) {
        if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
            return a(obj).equals(a(obj2));
        }
        return Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    private static Map a(List list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        ac acVar = (ac) it.next();
        j.a g2 = acVar.g();
        j.f a2 = g2.a("key");
        j.f a3 = g2.a(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        Object b2 = acVar.b(a3);
        if (b2 instanceof j.e) {
            b2 = Integer.valueOf(((j.e) b2).getNumber());
        }
        hashMap.put(acVar.b(a2), b2);
        while (it.hasNext()) {
            ac acVar2 = (ac) it.next();
            Object b3 = acVar2.b(a3);
            if (b3 instanceof j.e) {
                b3 = Integer.valueOf(((j.e) b3).getNumber());
            }
            hashMap.put(acVar2.b(a2), b3);
        }
        return hashMap;
    }

    private static boolean b(Object obj, Object obj2) {
        return ab.a(a((List) obj), a((List) obj2));
    }

    static boolean a(Map<j.f, Object> map, Map<j.f, Object> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (j.f next : map.keySet()) {
            if (!map2.containsKey(next)) {
                return false;
            }
            Object obj = map.get(next);
            Object obj2 = map2.get(next);
            if (next.i() == j.f.b.BYTES) {
                if (next.p()) {
                    List list = (List) obj;
                    List list2 = (List) obj2;
                    if (list.size() != list2.size()) {
                        return false;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        if (!a(list.get(i), list2.get(i))) {
                            return false;
                        }
                    }
                    continue;
                } else if (!a(obj, obj2)) {
                    return false;
                }
            } else if (next.m()) {
                if (!b(obj, obj2)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static int b(Object obj) {
        return ab.a(a((List) obj));
    }

    protected static int a(int i, Map<j.f, Object> map) {
        int i2;
        int a2;
        for (Map.Entry next : map.entrySet()) {
            j.f fVar = (j.f) next.getKey();
            Object value = next.getValue();
            int f2 = (i * 37) + fVar.f();
            if (fVar.m()) {
                i2 = f2 * 53;
                a2 = b(value);
            } else if (fVar.i() != j.f.b.ENUM) {
                i2 = f2 * 53;
                a2 = value.hashCode();
            } else if (fVar.p()) {
                i2 = f2 * 53;
                a2 = u.a((List<? extends u.a>) (List) value);
            } else {
                i2 = f2 * 53;
                a2 = u.a((u.a) value);
            }
            i = i2 + a2;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public as c() {
        return C0223a.b((ac) this);
    }

    /* renamed from: com.google.c.a$a  reason: collision with other inner class name */
    public static abstract class C0223a<BuilderType extends C0223a<BuilderType>> extends b.a implements ac.a {
        /* renamed from: b */
        public abstract BuilderType d();

        public boolean a(j.C0232j jVar) {
            throw new UnsupportedOperationException("hasOneof() is not implemented.");
        }

        public j.f b(j.C0232j jVar) {
            throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        }

        /* renamed from: a */
        public BuilderType c(ac acVar) {
            if (acVar.g() == g()) {
                for (Map.Entry next : acVar.o_().entrySet()) {
                    j.f fVar = (j.f) next.getKey();
                    if (fVar.p()) {
                        for (Object e2 : (List) next.getValue()) {
                            e(fVar, e2);
                        }
                    } else if (fVar.g() == j.f.a.MESSAGE) {
                        ac acVar2 = (ac) b(fVar);
                        if (acVar2 == acVar2.L()) {
                            f(fVar, next.getValue());
                        } else {
                            f(fVar, acVar2.H().c(acVar2).c((ac) next.getValue()).u());
                        }
                    } else {
                        f(fVar, next.getValue());
                    }
                }
                a(acVar.f());
                return this;
            }
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }

        /* renamed from: a */
        public BuilderType b(g gVar) throws IOException {
            return c(gVar, (p) n.a());
        }

        /* renamed from: a */
        public BuilderType c(g gVar, p pVar) throws IOException {
            int a2;
            at.a a3 = at.a(f());
            do {
                a2 = gVar.a();
                if (a2 == 0) {
                    break;
                }
            } while (ah.a(gVar, a3, pVar, g(), new ah.a(this), a2));
            f(a3.w());
            return this;
        }

        public BuilderType a(at atVar) {
            f(at.a(f()).a(atVar).w());
            return this;
        }

        public String toString() {
            return ap.a((ag) this);
        }

        protected static as b(ac acVar) {
            return new as(ah.b(acVar));
        }

        /* access modifiers changed from: package-private */
        public void c() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        /* renamed from: a */
        public BuilderType c(f fVar, p pVar) throws v {
            return (C0223a) super.b(fVar, pVar);
        }

        /* renamed from: a */
        public BuilderType c(byte[] bArr) throws v {
            return (C0223a) super.c(bArr);
        }

        /* renamed from: a */
        public BuilderType b(byte[] bArr, int i, int i2) throws v {
            return (C0223a) super.b(bArr, i, i2);
        }
    }
}
