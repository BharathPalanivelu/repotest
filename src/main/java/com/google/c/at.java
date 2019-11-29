package com.google.c;

import com.google.c.ad;
import com.google.c.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class at implements ad {

    /* renamed from: a  reason: collision with root package name */
    private static final at f13669a = new at(Collections.emptyMap());

    /* renamed from: c  reason: collision with root package name */
    private static final c f13670c = new c();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, b> f13671b;

    public boolean a() {
        return true;
    }

    private at() {
    }

    public static a c() {
        return a.g();
    }

    public static a a(at atVar) {
        return c().a(atVar);
    }

    public static at f() {
        return f13669a;
    }

    /* renamed from: g */
    public at K() {
        return f13669a;
    }

    private at(Map<Integer, b> map) {
        this.f13671b = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof at) || !this.f13671b.equals(((at) obj).f13671b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f13671b.hashCode();
    }

    public Map<Integer, b> h() {
        return this.f13671b;
    }

    public void a(h hVar) throws IOException {
        for (Map.Entry next : this.f13671b.entrySet()) {
            ((b) next.getValue()).a(((Integer) next.getKey()).intValue(), hVar);
        }
    }

    public String toString() {
        return ap.a(this);
    }

    public f d() {
        try {
            f.e b2 = f.b(b());
            a(b2.b());
            return b2.a();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e2);
        }
    }

    public byte[] e() {
        try {
            byte[] bArr = new byte[b()];
            h a2 = h.a(bArr);
            a(a2);
            a2.b();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public int b() {
        int i = 0;
        for (Map.Entry next : this.f13671b.entrySet()) {
            i += ((b) next.getValue()).a(((Integer) next.getKey()).intValue());
        }
        return i;
    }

    public void b(h hVar) throws IOException {
        for (Map.Entry next : this.f13671b.entrySet()) {
            ((b) next.getValue()).b(((Integer) next.getKey()).intValue(), hVar);
        }
    }

    public int i() {
        int i = 0;
        for (Map.Entry next : this.f13671b.entrySet()) {
            i += ((b) next.getValue()).b(((Integer) next.getKey()).intValue());
        }
        return i;
    }

    /* renamed from: j */
    public a J() {
        return c();
    }

    /* renamed from: k */
    public a I() {
        return c().a(this);
    }

    public static final class a implements ad.a {

        /* renamed from: a  reason: collision with root package name */
        private Map<Integer, b> f13672a;

        /* renamed from: b  reason: collision with root package name */
        private int f13673b;

        /* renamed from: c  reason: collision with root package name */
        private b.a f13674c;

        public boolean a() {
            return true;
        }

        private a() {
        }

        /* access modifiers changed from: private */
        public static a g() {
            a aVar = new a();
            aVar.h();
            return aVar;
        }

        private b.a b(int i) {
            b.a aVar = this.f13674c;
            if (aVar != null) {
                int i2 = this.f13673b;
                if (i == i2) {
                    return aVar;
                }
                b(i2, aVar.a());
            }
            if (i == 0) {
                return null;
            }
            b bVar = this.f13672a.get(Integer.valueOf(i));
            this.f13673b = i;
            this.f13674c = b.a();
            if (bVar != null) {
                this.f13674c.a(bVar);
            }
            return this.f13674c;
        }

        /* renamed from: b */
        public at w() {
            at atVar;
            b(0);
            if (this.f13672a.isEmpty()) {
                atVar = at.f();
            } else {
                atVar = new at(Collections.unmodifiableMap(this.f13672a));
            }
            this.f13672a = null;
            return atVar;
        }

        /* renamed from: c */
        public at v() {
            return w();
        }

        /* renamed from: d */
        public a clone() {
            b(0);
            return at.c().a(new at(this.f13672a));
        }

        /* renamed from: e */
        public at K() {
            return at.f();
        }

        private void h() {
            this.f13672a = Collections.emptyMap();
            this.f13673b = 0;
            this.f13674c = null;
        }

        public a a(at atVar) {
            if (atVar != at.f()) {
                for (Map.Entry entry : atVar.f13671b.entrySet()) {
                    a(((Integer) entry.getKey()).intValue(), (b) entry.getValue());
                }
            }
            return this;
        }

        public a a(int i, b bVar) {
            if (i != 0) {
                if (a(i)) {
                    b(i).a(bVar);
                } else {
                    b(i, bVar);
                }
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public a a(int i, int i2) {
            if (i != 0) {
                b(i).a((long) i2);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public boolean a(int i) {
            if (i != 0) {
                return i == this.f13673b || this.f13672a.containsKey(Integer.valueOf(i));
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public a b(int i, b bVar) {
            if (i != 0) {
                if (this.f13674c != null && this.f13673b == i) {
                    this.f13674c = null;
                    this.f13673b = 0;
                }
                if (this.f13672a.isEmpty()) {
                    this.f13672a = new TreeMap();
                }
                this.f13672a.put(Integer.valueOf(i), bVar);
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public a a(g gVar) throws IOException {
            int a2;
            do {
                a2 = gVar.a();
                if (a2 == 0) {
                    break;
                }
            } while (a(a2, gVar));
            return this;
        }

        public boolean a(int i, g gVar) throws IOException {
            int b2 = ay.b(i);
            int a2 = ay.a(i);
            if (a2 == 0) {
                b(b2).a(gVar.f());
                return true;
            } else if (a2 == 1) {
                b(b2).b(gVar.h());
                return true;
            } else if (a2 == 2) {
                b(b2).a(gVar.m());
                return true;
            } else if (a2 == 3) {
                a c2 = at.c();
                gVar.a(b2, (ad.a) c2, (p) n.a());
                b(b2).a(c2.w());
                return true;
            } else if (a2 == 4) {
                return false;
            } else {
                if (a2 == 5) {
                    b(b2).a(gVar.i());
                    return true;
                }
                throw v.h();
            }
        }

        /* renamed from: a */
        public a c(byte[] bArr) throws v {
            try {
                g a2 = g.a(bArr);
                a(a2);
                a2.a(0);
                return this;
            } catch (v e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
            }
        }

        /* renamed from: a */
        public a c(g gVar, p pVar) throws IOException {
            return a(gVar);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final b f13675a = a().a();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public List<Long> f13676b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public List<Integer> f13677c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public List<Long> f13678d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public List<f> f13679e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public List<at> f13680f;

        private b() {
        }

        public static a a() {
            return a.c();
        }

        public List<Long> b() {
            return this.f13676b;
        }

        public List<Integer> c() {
            return this.f13677c;
        }

        public List<Long> d() {
            return this.f13678d;
        }

        public List<f> e() {
            return this.f13679e;
        }

        public List<at> f() {
            return this.f13680f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            return Arrays.equals(g(), ((b) obj).g());
        }

        public int hashCode() {
            return Arrays.hashCode(g());
        }

        private Object[] g() {
            return new Object[]{this.f13676b, this.f13677c, this.f13678d, this.f13679e, this.f13680f};
        }

        public void a(int i, h hVar) throws IOException {
            for (Long longValue : this.f13676b) {
                hVar.b(i, longValue.longValue());
            }
            for (Integer intValue : this.f13677c) {
                hVar.c(i, intValue.intValue());
            }
            for (Long longValue2 : this.f13678d) {
                hVar.c(i, longValue2.longValue());
            }
            for (f a2 : this.f13679e) {
                hVar.a(i, a2);
            }
            for (at e2 : this.f13680f) {
                hVar.e(i, (ad) e2);
            }
        }

        public int a(int i) {
            int i2 = 0;
            for (Long longValue : this.f13676b) {
                i2 += h.e(i, longValue.longValue());
            }
            for (Integer intValue : this.f13677c) {
                i2 += h.g(i, intValue.intValue());
            }
            for (Long longValue2 : this.f13678d) {
                i2 += h.f(i, longValue2.longValue());
            }
            for (f c2 : this.f13679e) {
                i2 += h.c(i, c2);
            }
            for (at f2 : this.f13680f) {
                i2 += h.f(i, (ad) f2);
            }
            return i2;
        }

        public void b(int i, h hVar) throws IOException {
            for (f b2 : this.f13679e) {
                hVar.b(i, b2);
            }
        }

        public int b(int i) {
            int i2 = 0;
            for (f d2 : this.f13679e) {
                i2 += h.d(i, d2);
            }
            return i2;
        }

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private b f13681a;

            private a() {
            }

            /* access modifiers changed from: private */
            public static a c() {
                a aVar = new a();
                aVar.f13681a = new b();
                return aVar;
            }

            public b a() {
                if (this.f13681a.f13676b == null) {
                    List unused = this.f13681a.f13676b = Collections.emptyList();
                } else {
                    b bVar = this.f13681a;
                    List unused2 = bVar.f13676b = Collections.unmodifiableList(bVar.f13676b);
                }
                if (this.f13681a.f13677c == null) {
                    List unused3 = this.f13681a.f13677c = Collections.emptyList();
                } else {
                    b bVar2 = this.f13681a;
                    List unused4 = bVar2.f13677c = Collections.unmodifiableList(bVar2.f13677c);
                }
                if (this.f13681a.f13678d == null) {
                    List unused5 = this.f13681a.f13678d = Collections.emptyList();
                } else {
                    b bVar3 = this.f13681a;
                    List unused6 = bVar3.f13678d = Collections.unmodifiableList(bVar3.f13678d);
                }
                if (this.f13681a.f13679e == null) {
                    List unused7 = this.f13681a.f13679e = Collections.emptyList();
                } else {
                    b bVar4 = this.f13681a;
                    List unused8 = bVar4.f13679e = Collections.unmodifiableList(bVar4.f13679e);
                }
                if (this.f13681a.f13680f == null) {
                    List unused9 = this.f13681a.f13680f = Collections.emptyList();
                } else {
                    b bVar5 = this.f13681a;
                    List unused10 = bVar5.f13680f = Collections.unmodifiableList(bVar5.f13680f);
                }
                b bVar6 = this.f13681a;
                this.f13681a = null;
                return bVar6;
            }

            public a a(b bVar) {
                if (!bVar.f13676b.isEmpty()) {
                    if (this.f13681a.f13676b == null) {
                        List unused = this.f13681a.f13676b = new ArrayList();
                    }
                    this.f13681a.f13676b.addAll(bVar.f13676b);
                }
                if (!bVar.f13677c.isEmpty()) {
                    if (this.f13681a.f13677c == null) {
                        List unused2 = this.f13681a.f13677c = new ArrayList();
                    }
                    this.f13681a.f13677c.addAll(bVar.f13677c);
                }
                if (!bVar.f13678d.isEmpty()) {
                    if (this.f13681a.f13678d == null) {
                        List unused3 = this.f13681a.f13678d = new ArrayList();
                    }
                    this.f13681a.f13678d.addAll(bVar.f13678d);
                }
                if (!bVar.f13679e.isEmpty()) {
                    if (this.f13681a.f13679e == null) {
                        List unused4 = this.f13681a.f13679e = new ArrayList();
                    }
                    this.f13681a.f13679e.addAll(bVar.f13679e);
                }
                if (!bVar.f13680f.isEmpty()) {
                    if (this.f13681a.f13680f == null) {
                        List unused5 = this.f13681a.f13680f = new ArrayList();
                    }
                    this.f13681a.f13680f.addAll(bVar.f13680f);
                }
                return this;
            }

            public a a(long j) {
                if (this.f13681a.f13676b == null) {
                    List unused = this.f13681a.f13676b = new ArrayList();
                }
                this.f13681a.f13676b.add(Long.valueOf(j));
                return this;
            }

            public a a(int i) {
                if (this.f13681a.f13677c == null) {
                    List unused = this.f13681a.f13677c = new ArrayList();
                }
                this.f13681a.f13677c.add(Integer.valueOf(i));
                return this;
            }

            public a b(long j) {
                if (this.f13681a.f13678d == null) {
                    List unused = this.f13681a.f13678d = new ArrayList();
                }
                this.f13681a.f13678d.add(Long.valueOf(j));
                return this;
            }

            public a a(f fVar) {
                if (this.f13681a.f13679e == null) {
                    List unused = this.f13681a.f13679e = new ArrayList();
                }
                this.f13681a.f13679e.add(fVar);
                return this;
            }

            public a a(at atVar) {
                if (this.f13681a.f13680f == null) {
                    List unused = this.f13681a.f13680f = new ArrayList();
                }
                this.f13681a.f13680f.add(atVar);
                return this;
            }
        }
    }

    public static final class c extends c<at> {
        /* renamed from: a */
        public at b(g gVar, p pVar) throws v {
            a c2 = at.c();
            try {
                c2.a(gVar);
                return c2.v();
            } catch (v e2) {
                throw e2.a(c2.v());
            } catch (IOException e3) {
                throw new v(e3.getMessage()).a(c2.v());
            }
        }
    }

    /* renamed from: l */
    public final c F() {
        return f13670c;
    }
}
