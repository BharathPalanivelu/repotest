package com.google.c;

import com.facebook.soloader.MinElf;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.c.ac;
import com.google.c.ad;
import com.google.c.ap;
import com.google.c.ay;
import com.google.c.i;
import com.google.c.q;
import com.google.c.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;

public final class j {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f13905a = Logger.getLogger(j.class.getName());

    public static abstract class h {
        public abstract String b();

        public abstract String c();

        public abstract g d();

        public abstract ac j();
    }

    public static final class g extends h {

        /* renamed from: a  reason: collision with root package name */
        private i.o f13946a;

        /* renamed from: b  reason: collision with root package name */
        private final a[] f13947b;

        /* renamed from: c  reason: collision with root package name */
        private final d[] f13948c;

        /* renamed from: d  reason: collision with root package name */
        private final k[] f13949d;

        /* renamed from: e  reason: collision with root package name */
        private final f[] f13950e;

        /* renamed from: f  reason: collision with root package name */
        private final g[] f13951f;

        /* renamed from: g  reason: collision with root package name */
        private final g[] f13952g;
        /* access modifiers changed from: private */
        public final b h;

        public interface a {
            n a(g gVar);
        }

        public g d() {
            return this;
        }

        /* renamed from: a */
        public i.o j() {
            return this.f13946a;
        }

        public String b() {
            return this.f13946a.i();
        }

        public String c() {
            return this.f13946a.i();
        }

        public String e() {
            return this.f13946a.k();
        }

        public i.q f() {
            return this.f13946a.A();
        }

        public List<a> g() {
            return Collections.unmodifiableList(Arrays.asList(this.f13947b));
        }

        public List<g> h() {
            return Collections.unmodifiableList(Arrays.asList(this.f13952g));
        }

        public enum b {
            UNKNOWN("unknown"),
            PROTO2("proto2"),
            PROTO3("proto3");
            
            /* access modifiers changed from: private */
            public final String name;

            private b(String str) {
                this.name = str;
            }
        }

        public b i() {
            if (b.PROTO3.name.equals(this.f13946a.E())) {
                return b.PROTO3;
            }
            return b.PROTO2;
        }

        public static g a(i.o oVar, g[] gVarArr, boolean z) throws c {
            g gVar = new g(oVar, gVarArr, new b(gVarArr, z), z);
            gVar.l();
            return gVar;
        }

        public static void a(String[] strArr, g[] gVarArr, a aVar) {
            StringBuilder sb = new StringBuilder();
            for (String append : strArr) {
                sb.append(append);
            }
            byte[] bytes = sb.toString().getBytes(u.f14059b);
            try {
                i.o a2 = i.o.a(bytes);
                try {
                    g a3 = a(a2, gVarArr, true);
                    n a4 = aVar.a(a3);
                    if (a4 != null) {
                        try {
                            a3.a(i.o.a(bytes, (p) a4));
                        } catch (v e2) {
                            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e2);
                        }
                    }
                } catch (c e3) {
                    throw new IllegalArgumentException("Invalid embedded descriptor for \"" + a2.i() + "\".", e3);
                }
            } catch (v e4) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e4);
            }
        }

        private g(i.o oVar, g[] gVarArr, b bVar, boolean z) throws c {
            this.h = bVar;
            this.f13946a = oVar;
            this.f13951f = (g[]) gVarArr.clone();
            HashMap hashMap = new HashMap();
            for (g gVar : gVarArr) {
                hashMap.put(gVar.b(), gVar);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < oVar.o(); i++) {
                int b2 = oVar.b(i);
                if (b2 < 0 || b2 >= oVar.m()) {
                    throw new c(this, "Invalid public dependency index.", (AnonymousClass1) null);
                }
                String a2 = oVar.a(b2);
                g gVar2 = (g) hashMap.get(a2);
                if (gVar2 != null) {
                    arrayList.add(gVar2);
                } else if (!z) {
                    throw new c(this, "Invalid public dependency: " + a2, (AnonymousClass1) null);
                }
            }
            this.f13952g = new g[arrayList.size()];
            arrayList.toArray(this.f13952g);
            bVar.a(e(), this);
            this.f13947b = new a[oVar.s()];
            for (int i2 = 0; i2 < oVar.s(); i2++) {
                this.f13947b[i2] = new a(oVar.c(i2), this, (a) null, i2, (AnonymousClass1) null);
            }
            this.f13948c = new d[oVar.u()];
            for (int i3 = 0; i3 < oVar.u(); i3++) {
                this.f13948c[i3] = new d(oVar.d(i3), this, (a) null, i3, (AnonymousClass1) null);
            }
            this.f13949d = new k[oVar.w()];
            for (int i4 = 0; i4 < oVar.w(); i4++) {
                this.f13949d[i4] = new k(oVar.e(i4), this, i4, (AnonymousClass1) null);
            }
            this.f13950e = new f[oVar.y()];
            for (int i5 = 0; i5 < oVar.y(); i5++) {
                this.f13950e[i5] = new f(oVar.f(i5), this, (a) null, i5, true, (AnonymousClass1) null);
            }
        }

        g(String str, a aVar) throws c {
            this.h = new b(new g[0], true);
            i.o.a M = i.o.M();
            this.f13946a = M.a(aVar.c() + ".placeholder.proto").b(str).a(aVar.j()).w();
            this.f13951f = new g[0];
            this.f13952g = new g[0];
            this.f13947b = new a[]{aVar};
            this.f13948c = new d[0];
            this.f13949d = new k[0];
            this.f13950e = new f[0];
            this.h.a(str, this);
            this.h.c(aVar);
        }

        private void l() throws c {
            for (a a2 : this.f13947b) {
                a2.k();
            }
            for (k a3 : this.f13949d) {
                a3.e();
            }
            for (f b2 : this.f13950e) {
                b2.A();
            }
        }

        private void a(i.o oVar) {
            this.f13946a = oVar;
            int i = 0;
            int i2 = 0;
            while (true) {
                a[] aVarArr = this.f13947b;
                if (i2 >= aVarArr.length) {
                    break;
                }
                aVarArr[i2].a(oVar.c(i2));
                i2++;
            }
            int i3 = 0;
            while (true) {
                d[] dVarArr = this.f13948c;
                if (i3 >= dVarArr.length) {
                    break;
                }
                dVarArr[i3].a(oVar.d(i3));
                i3++;
            }
            int i4 = 0;
            while (true) {
                k[] kVarArr = this.f13949d;
                if (i4 >= kVarArr.length) {
                    break;
                }
                kVarArr[i4].a(oVar.e(i4));
                i4++;
            }
            while (true) {
                f[] fVarArr = this.f13950e;
                if (i < fVarArr.length) {
                    fVarArr[i].a(oVar.f(i));
                    i++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return i() == b.PROTO3;
        }
    }

    public static final class a extends h {

        /* renamed from: a  reason: collision with root package name */
        private final int f13908a;

        /* renamed from: b  reason: collision with root package name */
        private i.a f13909b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13910c;

        /* renamed from: d  reason: collision with root package name */
        private final g f13911d;

        /* renamed from: e  reason: collision with root package name */
        private final a f13912e;

        /* renamed from: f  reason: collision with root package name */
        private final a[] f13913f;

        /* renamed from: g  reason: collision with root package name */
        private final d[] f13914g;
        private final f[] h;
        private final f[] i;
        private final C0232j[] j;

        /* synthetic */ a(i.a aVar, g gVar, a aVar2, int i2, AnonymousClass1 r5) throws c {
            this(aVar, gVar, aVar2, i2);
        }

        /* renamed from: a */
        public i.a j() {
            return this.f13909b;
        }

        public String b() {
            return this.f13909b.n_();
        }

        public String c() {
            return this.f13910c;
        }

        public g d() {
            return this.f13911d;
        }

        public i.s e() {
            return this.f13909b.w();
        }

        public List<f> f() {
            return Collections.unmodifiableList(Arrays.asList(this.h));
        }

        public List<C0232j> g() {
            return Collections.unmodifiableList(Arrays.asList(this.j));
        }

        public List<a> h() {
            return Collections.unmodifiableList(Arrays.asList(this.f13913f));
        }

        public List<d> i() {
            return Collections.unmodifiableList(Arrays.asList(this.f13914g));
        }

        public boolean a(int i2) {
            for (i.a.b next : this.f13909b.r()) {
                if (next.i() <= i2 && i2 < next.k()) {
                    return true;
                }
            }
            return false;
        }

        public f a(String str) {
            b a2 = this.f13911d.h;
            h a3 = a2.a(this.f13910c + '.' + str);
            if (a3 == null || !(a3 instanceof f)) {
                return null;
            }
            return (f) a3;
        }

        public f b(int i2) {
            return (f) this.f13911d.h.f13919e.get(new b.a(this, i2));
        }

        a(String str) throws c {
            String str2;
            String str3;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str2 = str.substring(lastIndexOf + 1);
                str3 = str.substring(0, lastIndexOf);
            } else {
                str3 = "";
                str2 = str;
            }
            this.f13908a = 0;
            this.f13909b = i.a.C().a(str2).a(i.a.b.m().a(1).b(536870912).w()).w();
            this.f13910c = str;
            this.f13912e = null;
            this.f13913f = new a[0];
            this.f13914g = new d[0];
            this.h = new f[0];
            this.i = new f[0];
            this.j = new C0232j[0];
            this.f13911d = new g(str3, this);
        }

        private a(i.a aVar, g gVar, a aVar2, int i2) throws c {
            this.f13908a = i2;
            this.f13909b = aVar;
            this.f13910c = j.b(gVar, aVar2, aVar.n_());
            this.f13911d = gVar;
            this.f13912e = aVar2;
            this.j = new C0232j[aVar.u()];
            for (int i3 = 0; i3 < aVar.u(); i3++) {
                this.j[i3] = new C0232j(aVar.e(i3), gVar, this, i3, (AnonymousClass1) null);
            }
            this.f13913f = new a[aVar.o()];
            for (int i4 = 0; i4 < aVar.o(); i4++) {
                this.f13913f[i4] = new a(aVar.c(i4), gVar, this, i4);
            }
            this.f13914g = new d[aVar.q()];
            for (int i5 = 0; i5 < aVar.q(); i5++) {
                this.f13914g[i5] = new d(aVar.d(i5), gVar, this, i5, (AnonymousClass1) null);
            }
            this.h = new f[aVar.k()];
            for (int i6 = 0; i6 < aVar.k(); i6++) {
                this.h[i6] = new f(aVar.a(i6), gVar, this, i6, false, (AnonymousClass1) null);
            }
            this.i = new f[aVar.m()];
            for (int i7 = 0; i7 < aVar.m(); i7++) {
                this.i[i7] = new f(aVar.b(i7), gVar, this, i7, true, (AnonymousClass1) null);
            }
            for (int i8 = 0; i8 < aVar.u(); i8++) {
                C0232j[] jVarArr = this.j;
                f[] unused = jVarArr[i8].f13966g = new f[jVarArr[i8].c()];
                int unused2 = this.j[i8].f13965f = 0;
            }
            for (int i9 = 0; i9 < aVar.k(); i9++) {
                C0232j w = this.h[i9].w();
                if (w != null) {
                    w.f13966g[C0232j.b(w)] = this.h[i9];
                }
            }
            gVar.h.c(this);
        }

        /* access modifiers changed from: private */
        public void k() throws c {
            for (a k : this.f13913f) {
                k.k();
            }
            for (f b2 : this.h) {
                b2.A();
            }
            for (f b3 : this.i) {
                b3.A();
            }
        }

        /* access modifiers changed from: private */
        public void a(i.a aVar) {
            this.f13909b = aVar;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                a[] aVarArr = this.f13913f;
                if (i3 >= aVarArr.length) {
                    break;
                }
                aVarArr[i3].a(aVar.c(i3));
                i3++;
            }
            int i4 = 0;
            while (true) {
                C0232j[] jVarArr = this.j;
                if (i4 >= jVarArr.length) {
                    break;
                }
                jVarArr[i4].a(aVar.e(i4));
                i4++;
            }
            int i5 = 0;
            while (true) {
                d[] dVarArr = this.f13914g;
                if (i5 >= dVarArr.length) {
                    break;
                }
                dVarArr[i5].a(aVar.d(i5));
                i5++;
            }
            int i6 = 0;
            while (true) {
                f[] fVarArr = this.h;
                if (i6 >= fVarArr.length) {
                    break;
                }
                fVarArr[i6].a(aVar.a(i6));
                i6++;
            }
            while (true) {
                f[] fVarArr2 = this.i;
                if (i2 < fVarArr2.length) {
                    fVarArr2[i2].a(aVar.b(i2));
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public static final class f extends h implements q.a<f>, Comparable<f> {

        /* renamed from: a  reason: collision with root package name */
        private static final ay.a[] f13939a = ay.a.values();

        /* renamed from: b  reason: collision with root package name */
        private final int f13940b;

        /* renamed from: c  reason: collision with root package name */
        private i.k f13941c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13942d;

        /* renamed from: e  reason: collision with root package name */
        private final String f13943e;

        /* renamed from: f  reason: collision with root package name */
        private final g f13944f;

        /* renamed from: g  reason: collision with root package name */
        private final a f13945g;
        private b h;
        private a i;
        private a j;
        private C0232j k;
        private d l;
        private Object m;

        /* synthetic */ f(i.k kVar, g gVar, a aVar, int i2, boolean z, AnonymousClass1 r6) throws c {
            this(kVar, gVar, aVar, i2, z);
        }

        public int a() {
            return this.f13940b;
        }

        /* renamed from: e */
        public i.k j() {
            return this.f13941c;
        }

        public String b() {
            return this.f13941c.j();
        }

        public int f() {
            return this.f13941c.l();
        }

        public String c() {
            return this.f13942d;
        }

        public a g() {
            return this.h.getJavaType();
        }

        public ay.b h() {
            return k().getJavaType();
        }

        public g d() {
            return this.f13944f;
        }

        public b i() {
            return this.h;
        }

        public ay.a k() {
            return f13939a[this.h.ordinal()];
        }

        public boolean l() {
            if (this.h != b.STRING) {
                return false;
            }
            if (!v().e().o() && d().i() != g.b.PROTO3) {
                return d().f().r();
            }
            return true;
        }

        public boolean m() {
            return i() == b.MESSAGE && p() && y().e().o();
        }

        static {
            if (b.values().length != i.k.c.values().length) {
                throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
            }
        }

        public boolean n() {
            return this.f13941c.n() == i.k.b.LABEL_REQUIRED;
        }

        public boolean o() {
            return this.f13941c.n() == i.k.b.LABEL_OPTIONAL;
        }

        public boolean p() {
            return this.f13941c.n() == i.k.b.LABEL_REPEATED;
        }

        public boolean q() {
            if (!r()) {
                return false;
            }
            if (d().i() == g.b.PROTO2) {
                return t().l();
            }
            if (!t().k() || t().l()) {
                return true;
            }
            return false;
        }

        public boolean r() {
            return p() && k().isPackable();
        }

        public Object s() {
            if (g() != a.MESSAGE) {
                return this.m;
            }
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        public i.m t() {
            return this.f13941c.B();
        }

        public boolean u() {
            return this.f13941c.s();
        }

        public a v() {
            return this.i;
        }

        public C0232j w() {
            return this.k;
        }

        public a x() {
            if (u()) {
                return this.f13945g;
            }
            throw new UnsupportedOperationException("This field is not an extension.");
        }

        public a y() {
            if (g() == a.MESSAGE) {
                return this.j;
            }
            throw new UnsupportedOperationException("This field is not of message type.");
        }

        public d z() {
            if (g() == a.ENUM) {
                return this.l;
            }
            throw new UnsupportedOperationException("This field is not of enum type.");
        }

        /* renamed from: a */
        public int compareTo(f fVar) {
            if (fVar.i == this.i) {
                return f() - fVar.f();
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        public String toString() {
            return c();
        }

        public enum b {
            DOUBLE(a.DOUBLE),
            FLOAT(a.FLOAT),
            INT64(a.LONG),
            UINT64(a.LONG),
            INT32(a.INT),
            FIXED64(a.LONG),
            FIXED32(a.INT),
            BOOL(a.BOOLEAN),
            STRING(a.STRING),
            GROUP(a.MESSAGE),
            MESSAGE(a.MESSAGE),
            BYTES(a.BYTE_STRING),
            UINT32(a.INT),
            ENUM(a.ENUM),
            SFIXED32(a.INT),
            SFIXED64(a.LONG),
            SINT32(a.INT),
            SINT64(a.LONG);
            
            private a javaType;

            private b(a aVar) {
                this.javaType = aVar;
            }

            public i.k.c toProto() {
                return i.k.c.forNumber(ordinal() + 1);
            }

            public a getJavaType() {
                return this.javaType;
            }

            public static b valueOf(i.k.c cVar) {
                return values()[cVar.getNumber() - 1];
            }
        }

        public enum a {
            INT(0),
            LONG(0L),
            FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
            DOUBLE(Double.valueOf(0.0d)),
            BOOLEAN(false),
            STRING(""),
            BYTE_STRING(f.f13707a),
            ENUM((String) null),
            MESSAGE((String) null);
            
            /* access modifiers changed from: private */
            public final Object defaultDefault;

            private a(Object obj) {
                this.defaultDefault = obj;
            }
        }

        private static String a(String str) {
            StringBuilder sb = new StringBuilder(str.length());
            boolean z = false;
            for (int i2 = 0; i2 < str.length(); i2++) {
                Character valueOf = Character.valueOf(str.charAt(i2));
                if (Character.isLowerCase(valueOf.charValue())) {
                    if (z) {
                        sb.append(Character.toUpperCase(valueOf.charValue()));
                    } else {
                        sb.append(valueOf);
                    }
                } else if (Character.isUpperCase(valueOf.charValue())) {
                    if (i2 == 0) {
                        sb.append(Character.toLowerCase(valueOf.charValue()));
                    } else {
                        sb.append(valueOf);
                    }
                } else if (Character.isDigit(valueOf.charValue())) {
                    sb.append(valueOf);
                } else {
                    z = true;
                }
                z = false;
            }
            return sb.toString();
        }

        private f(i.k kVar, g gVar, a aVar, int i2, boolean z) throws c {
            this.f13940b = i2;
            this.f13941c = kVar;
            this.f13942d = j.b(gVar, aVar, kVar.j());
            this.f13944f = gVar;
            if (kVar.y()) {
                this.f13943e = kVar.z();
            } else {
                this.f13943e = a(kVar.j());
            }
            if (kVar.o()) {
                this.h = b.valueOf(kVar.p());
            }
            if (f() > 0) {
                if (z) {
                    if (kVar.s()) {
                        this.i = null;
                        if (aVar != null) {
                            this.f13945g = aVar;
                        } else {
                            this.f13945g = null;
                        }
                        if (!kVar.w()) {
                            this.k = null;
                        } else {
                            throw new c((h) this, "FieldDescriptorProto.oneof_index set for extension field.", (AnonymousClass1) null);
                        }
                    } else {
                        throw new c((h) this, "FieldDescriptorProto.extendee not set for extension field.", (AnonymousClass1) null);
                    }
                } else if (!kVar.s()) {
                    this.i = aVar;
                    if (!kVar.w()) {
                        this.k = null;
                    } else if (kVar.x() < 0 || kVar.x() >= aVar.j().u()) {
                        throw new c((h) this, "FieldDescriptorProto.oneof_index is out of range for type " + aVar.b(), (AnonymousClass1) null);
                    } else {
                        this.k = aVar.g().get(kVar.x());
                        C0232j.b(this.k);
                    }
                    this.f13945g = null;
                } else {
                    throw new c((h) this, "FieldDescriptorProto.extendee set for non-extension field.", (AnonymousClass1) null);
                }
                gVar.h.c(this);
                return;
            }
            throw new c((h) this, "Field numbers must be positive integers.", (AnonymousClass1) null);
        }

        /* access modifiers changed from: private */
        public void A() throws c {
            if (this.f13941c.s()) {
                h a2 = this.f13944f.h.a(this.f13941c.t(), this, b.c.TYPES_ONLY);
                if (a2 instanceof a) {
                    this.i = (a) a2;
                    if (!v().a(f())) {
                        throw new c((h) this, '\"' + v().c() + "\" does not declare " + f() + " as an extension number.", (AnonymousClass1) null);
                    }
                } else {
                    throw new c((h) this, '\"' + this.f13941c.t() + "\" is not a message type.", (AnonymousClass1) null);
                }
            }
            if (this.f13941c.q()) {
                h a3 = this.f13944f.h.a(this.f13941c.r(), this, b.c.TYPES_ONLY);
                if (!this.f13941c.o()) {
                    if (a3 instanceof a) {
                        this.h = b.MESSAGE;
                    } else if (a3 instanceof d) {
                        this.h = b.ENUM;
                    } else {
                        throw new c((h) this, '\"' + this.f13941c.r() + "\" is not a type.", (AnonymousClass1) null);
                    }
                }
                if (g() == a.MESSAGE) {
                    if (a3 instanceof a) {
                        this.j = (a) a3;
                        if (this.f13941c.u()) {
                            throw new c((h) this, "Messages can't have default values.", (AnonymousClass1) null);
                        }
                    } else {
                        throw new c((h) this, '\"' + this.f13941c.r() + "\" is not a message type.", (AnonymousClass1) null);
                    }
                } else if (g() != a.ENUM) {
                    throw new c((h) this, "Field with primitive type has type_name.", (AnonymousClass1) null);
                } else if (a3 instanceof d) {
                    this.l = (d) a3;
                } else {
                    throw new c((h) this, '\"' + this.f13941c.r() + "\" is not an enum type.", (AnonymousClass1) null);
                }
            } else if (g() == a.MESSAGE || g() == a.ENUM) {
                throw new c((h) this, "Field with message or enum type missing type_name.", (AnonymousClass1) null);
            }
            if (!this.f13941c.B().l() || r()) {
                if (this.f13941c.u()) {
                    if (!p()) {
                        try {
                            switch (i()) {
                                case INT32:
                                case SINT32:
                                case SFIXED32:
                                    this.m = Integer.valueOf(ap.b(this.f13941c.v()));
                                    break;
                                case UINT32:
                                case FIXED32:
                                    this.m = Integer.valueOf(ap.c(this.f13941c.v()));
                                    break;
                                case INT64:
                                case SINT64:
                                case SFIXED64:
                                    this.m = Long.valueOf(ap.d(this.f13941c.v()));
                                    break;
                                case UINT64:
                                case FIXED64:
                                    this.m = Long.valueOf(ap.e(this.f13941c.v()));
                                    break;
                                case FLOAT:
                                    if (!this.f13941c.v().equals("inf")) {
                                        if (!this.f13941c.v().equals("-inf")) {
                                            if (!this.f13941c.v().equals("nan")) {
                                                this.m = Float.valueOf(this.f13941c.v());
                                                break;
                                            } else {
                                                this.m = Float.valueOf(Float.NaN);
                                                break;
                                            }
                                        } else {
                                            this.m = Float.valueOf(Float.NEGATIVE_INFINITY);
                                            break;
                                        }
                                    } else {
                                        this.m = Float.valueOf(Float.POSITIVE_INFINITY);
                                        break;
                                    }
                                case DOUBLE:
                                    if (!this.f13941c.v().equals("inf")) {
                                        if (!this.f13941c.v().equals("-inf")) {
                                            if (!this.f13941c.v().equals("nan")) {
                                                this.m = Double.valueOf(this.f13941c.v());
                                                break;
                                            } else {
                                                this.m = Double.valueOf(Double.NaN);
                                                break;
                                            }
                                        } else {
                                            this.m = Double.valueOf(Double.NEGATIVE_INFINITY);
                                            break;
                                        }
                                    } else {
                                        this.m = Double.valueOf(Double.POSITIVE_INFINITY);
                                        break;
                                    }
                                case BOOL:
                                    this.m = Boolean.valueOf(this.f13941c.v());
                                    break;
                                case STRING:
                                    this.m = this.f13941c.v();
                                    break;
                                case BYTES:
                                    this.m = ap.a((CharSequence) this.f13941c.v());
                                    break;
                                case ENUM:
                                    this.m = this.l.a(this.f13941c.v());
                                    if (this.m != null) {
                                        break;
                                    } else {
                                        throw new c((h) this, "Unknown enum default value: \"" + this.f13941c.v() + '\"', (AnonymousClass1) null);
                                    }
                                case MESSAGE:
                                case GROUP:
                                    throw new c((h) this, "Message type had default value.", (AnonymousClass1) null);
                            }
                        } catch (ap.a e2) {
                            throw new c(this, "Couldn't parse default value: " + e2.getMessage(), e2, (AnonymousClass1) null);
                        } catch (NumberFormatException e3) {
                            throw new c(this, "Could not parse default value: \"" + this.f13941c.v() + '\"', e3, (AnonymousClass1) null);
                        }
                    } else {
                        throw new c((h) this, "Repeated fields cannot have default values.", (AnonymousClass1) null);
                    }
                } else if (p()) {
                    this.m = Collections.emptyList();
                } else {
                    int i2 = AnonymousClass1.f13907b[g().ordinal()];
                    if (i2 == 1) {
                        this.m = this.l.e().get(0);
                    } else if (i2 != 2) {
                        this.m = g().defaultDefault;
                    } else {
                        this.m = null;
                    }
                }
                if (!u()) {
                    this.f13944f.h.a(this);
                }
                a aVar = this.i;
                if (aVar != null && aVar.e().i()) {
                    if (!u()) {
                        throw new c((h) this, "MessageSets cannot have fields, only extensions.", (AnonymousClass1) null);
                    } else if (!o() || i() != b.MESSAGE) {
                        throw new c((h) this, "Extensions of MessageSets must be optional messages.", (AnonymousClass1) null);
                    }
                }
            } else {
                throw new c((h) this, "[packed = true] can only be specified for repeated primitive fields.", (AnonymousClass1) null);
            }
        }

        /* access modifiers changed from: private */
        public void a(i.k kVar) {
            this.f13941c = kVar;
        }

        public ad.a a(ad.a aVar, ad adVar) {
            return ((ac.a) aVar).c((ac) adVar);
        }
    }

    /* renamed from: com.google.c.j$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f13907b = new int[f.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x008b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00bb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00c7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00d3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00df */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00eb */
        static {
            /*
                com.google.c.j$f$a[] r0 = com.google.c.j.f.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13907b = r0
                r0 = 1
                int[] r1 = f13907b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.c.j$f$a r2 = com.google.c.j.f.a.ENUM     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f13907b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.c.j$f$a r3 = com.google.c.j.f.a.MESSAGE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                com.google.c.j$f$b[] r2 = com.google.c.j.f.b.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f13906a = r2
                int[] r2 = f13906a     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.google.c.j$f$b r3 = com.google.c.j.f.b.INT32     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x003c }
                com.google.c.j$f$b r2 = com.google.c.j.f.b.SINT32     // Catch:{ NoSuchFieldError -> 0x003c }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.UINT32     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x005d }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.FIXED32     // Catch:{ NoSuchFieldError -> 0x005d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.INT64     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.SINT64     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x007f }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.SFIXED64     // Catch:{ NoSuchFieldError -> 0x007f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x008b }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.UINT64     // Catch:{ NoSuchFieldError -> 0x008b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008b }
            L_0x008b:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x0097 }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.FIXED64     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x00a3 }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.FLOAT     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x00af }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.DOUBLE     // Catch:{ NoSuchFieldError -> 0x00af }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00af }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00af }
            L_0x00af:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x00bb }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.BOOL     // Catch:{ NoSuchFieldError -> 0x00bb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bb }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00bb }
            L_0x00bb:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x00c7 }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.STRING     // Catch:{ NoSuchFieldError -> 0x00c7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c7 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c7 }
            L_0x00c7:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x00d3 }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.BYTES     // Catch:{ NoSuchFieldError -> 0x00d3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d3 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d3 }
            L_0x00d3:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x00df }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.ENUM     // Catch:{ NoSuchFieldError -> 0x00df }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00df }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00df }
            L_0x00df:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x00eb }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00eb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00eb }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00eb }
            L_0x00eb:
                int[] r0 = f13906a     // Catch:{ NoSuchFieldError -> 0x00f7 }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.GROUP     // Catch:{ NoSuchFieldError -> 0x00f7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f7 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f7 }
            L_0x00f7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.j.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class d extends h implements u.b<e> {

        /* renamed from: a  reason: collision with root package name */
        private final int f13926a;

        /* renamed from: b  reason: collision with root package name */
        private i.c f13927b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13928c;

        /* renamed from: d  reason: collision with root package name */
        private final g f13929d;

        /* renamed from: e  reason: collision with root package name */
        private final a f13930e;

        /* renamed from: f  reason: collision with root package name */
        private e[] f13931f;

        /* renamed from: g  reason: collision with root package name */
        private final WeakHashMap<Integer, WeakReference<e>> f13932g;

        /* synthetic */ d(i.c cVar, g gVar, a aVar, int i, AnonymousClass1 r5) throws c {
            this(cVar, gVar, aVar, i);
        }

        /* renamed from: a */
        public i.c j() {
            return this.f13927b;
        }

        public String b() {
            return this.f13927b.i();
        }

        public String c() {
            return this.f13928c;
        }

        public g d() {
            return this.f13929d;
        }

        public List<e> e() {
            return Collections.unmodifiableList(Arrays.asList(this.f13931f));
        }

        public e a(String str) {
            b a2 = this.f13929d.h;
            h a3 = a2.a(this.f13928c + '.' + str);
            if (a3 == null || !(a3 instanceof e)) {
                return null;
            }
            return (e) a3;
        }

        public e a(int i) {
            return (e) this.f13929d.h.f13920f.get(new b.a(this, i));
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.google.c.j$e} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.c.j.e b(int r4) {
            /*
                r3 = this;
                com.google.c.j$e r0 = r3.a((int) r4)
                if (r0 == 0) goto L_0x0007
                return r0
            L_0x0007:
                monitor-enter(r3)
                java.lang.Integer r1 = new java.lang.Integer     // Catch:{ all -> 0x0034 }
                r1.<init>(r4)     // Catch:{ all -> 0x0034 }
                java.util.WeakHashMap<java.lang.Integer, java.lang.ref.WeakReference<com.google.c.j$e>> r4 = r3.f13932g     // Catch:{ all -> 0x0034 }
                java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x0034 }
                java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4     // Catch:{ all -> 0x0034 }
                if (r4 == 0) goto L_0x001e
                java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x0034 }
                r0 = r4
                com.google.c.j$e r0 = (com.google.c.j.e) r0     // Catch:{ all -> 0x0034 }
            L_0x001e:
                if (r0 != 0) goto L_0x0032
                com.google.c.j$e r0 = new com.google.c.j$e     // Catch:{ all -> 0x0034 }
                com.google.c.j$g r4 = r3.f13929d     // Catch:{ all -> 0x0034 }
                r2 = 0
                r0.<init>((com.google.c.j.g) r4, (com.google.c.j.d) r3, (java.lang.Integer) r1, (com.google.c.j.AnonymousClass1) r2)     // Catch:{ all -> 0x0034 }
                java.util.WeakHashMap<java.lang.Integer, java.lang.ref.WeakReference<com.google.c.j$e>> r4 = r3.f13932g     // Catch:{ all -> 0x0034 }
                java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0034 }
                r2.<init>(r0)     // Catch:{ all -> 0x0034 }
                r4.put(r1, r2)     // Catch:{ all -> 0x0034 }
            L_0x0032:
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return r0
            L_0x0034:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.j.d.b(int):com.google.c.j$e");
        }

        private d(i.c cVar, g gVar, a aVar, int i) throws c {
            this.f13932g = new WeakHashMap<>();
            this.f13926a = i;
            this.f13927b = cVar;
            this.f13928c = j.b(gVar, aVar, cVar.i());
            this.f13929d = gVar;
            this.f13930e = aVar;
            if (cVar.k() != 0) {
                this.f13931f = new e[cVar.k()];
                for (int i2 = 0; i2 < cVar.k(); i2++) {
                    this.f13931f[i2] = new e(cVar.a(i2), gVar, this, i2, (AnonymousClass1) null);
                }
                gVar.h.c(this);
                return;
            }
            throw new c((h) this, "Enums must contain at least one value.", (AnonymousClass1) null);
        }

        /* access modifiers changed from: private */
        public void a(i.c cVar) {
            this.f13927b = cVar;
            int i = 0;
            while (true) {
                e[] eVarArr = this.f13931f;
                if (i < eVarArr.length) {
                    eVarArr[i].a(cVar.a(i));
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final class e extends h implements u.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f13933a;

        /* renamed from: b  reason: collision with root package name */
        private i.g f13934b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13935c;

        /* renamed from: d  reason: collision with root package name */
        private final g f13936d;

        /* renamed from: e  reason: collision with root package name */
        private final d f13937e;

        /* renamed from: f  reason: collision with root package name */
        private Integer f13938f;

        /* synthetic */ e(i.g gVar, g gVar2, d dVar, int i, AnonymousClass1 r5) throws c {
            this(gVar, gVar2, dVar, i);
        }

        /* synthetic */ e(g gVar, d dVar, Integer num, AnonymousClass1 r4) {
            this(gVar, dVar, num);
        }

        public int a() {
            return this.f13933a;
        }

        /* renamed from: e */
        public i.g j() {
            return this.f13934b;
        }

        public String b() {
            return this.f13934b.i();
        }

        public int getNumber() {
            return this.f13934b.k();
        }

        public String toString() {
            return this.f13934b.i();
        }

        public String c() {
            return this.f13935c;
        }

        public g d() {
            return this.f13936d;
        }

        public d f() {
            return this.f13937e;
        }

        private e(i.g gVar, g gVar2, d dVar, int i) throws c {
            this.f13933a = i;
            this.f13934b = gVar;
            this.f13936d = gVar2;
            this.f13937e = dVar;
            this.f13935c = dVar.c() + '.' + gVar.i();
            gVar2.h.c(this);
            gVar2.h.a(this);
        }

        private e(g gVar, d dVar, Integer num) {
            i.g i = i.g.o().a("UNKNOWN_ENUM_VALUE_" + dVar.b() + "_" + num).a(num.intValue()).w();
            this.f13933a = -1;
            this.f13934b = i;
            this.f13936d = gVar;
            this.f13937e = dVar;
            this.f13935c = dVar.c() + '.' + i.i();
            this.f13938f = num;
        }

        /* access modifiers changed from: private */
        public void a(i.g gVar) {
            this.f13934b = gVar;
        }
    }

    public static final class k extends h {

        /* renamed from: a  reason: collision with root package name */
        private final int f13967a;

        /* renamed from: b  reason: collision with root package name */
        private i.ac f13968b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13969c;

        /* renamed from: d  reason: collision with root package name */
        private final g f13970d;

        /* renamed from: e  reason: collision with root package name */
        private i[] f13971e;

        /* synthetic */ k(i.ac acVar, g gVar, int i, AnonymousClass1 r4) throws c {
            this(acVar, gVar, i);
        }

        /* renamed from: a */
        public i.ac j() {
            return this.f13968b;
        }

        public String b() {
            return this.f13968b.i();
        }

        public String c() {
            return this.f13969c;
        }

        public g d() {
            return this.f13970d;
        }

        private k(i.ac acVar, g gVar, int i) throws c {
            this.f13967a = i;
            this.f13968b = acVar;
            this.f13969c = j.b(gVar, (a) null, acVar.i());
            this.f13970d = gVar;
            this.f13971e = new i[acVar.k()];
            for (int i2 = 0; i2 < acVar.k(); i2++) {
                this.f13971e[i2] = new i(acVar.a(i2), gVar, this, i2, (AnonymousClass1) null);
            }
            gVar.h.c(this);
        }

        /* access modifiers changed from: private */
        public void e() throws c {
            for (i a2 : this.f13971e) {
                a2.e();
            }
        }

        /* access modifiers changed from: private */
        public void a(i.ac acVar) {
            this.f13968b = acVar;
            int i = 0;
            while (true) {
                i[] iVarArr = this.f13971e;
                if (i < iVarArr.length) {
                    iVarArr[i].a(acVar.a(i));
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final class i extends h {

        /* renamed from: a  reason: collision with root package name */
        private final int f13953a;

        /* renamed from: b  reason: collision with root package name */
        private i.u f13954b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13955c;

        /* renamed from: d  reason: collision with root package name */
        private final g f13956d;

        /* renamed from: e  reason: collision with root package name */
        private final k f13957e;

        /* renamed from: f  reason: collision with root package name */
        private a f13958f;

        /* renamed from: g  reason: collision with root package name */
        private a f13959g;

        /* synthetic */ i(i.u uVar, g gVar, k kVar, int i, AnonymousClass1 r5) throws c {
            this(uVar, gVar, kVar, i);
        }

        /* renamed from: a */
        public i.u j() {
            return this.f13954b;
        }

        public String b() {
            return this.f13954b.i();
        }

        public String c() {
            return this.f13955c;
        }

        public g d() {
            return this.f13956d;
        }

        private i(i.u uVar, g gVar, k kVar, int i) throws c {
            this.f13953a = i;
            this.f13954b = uVar;
            this.f13956d = gVar;
            this.f13957e = kVar;
            this.f13955c = kVar.c() + '.' + uVar.i();
            gVar.h.c(this);
        }

        /* access modifiers changed from: private */
        public void e() throws c {
            h a2 = this.f13956d.h.a(this.f13954b.k(), this, b.c.TYPES_ONLY);
            if (a2 instanceof a) {
                this.f13958f = (a) a2;
                h a3 = this.f13956d.h.a(this.f13954b.m(), this, b.c.TYPES_ONLY);
                if (a3 instanceof a) {
                    this.f13959g = (a) a3;
                    return;
                }
                throw new c((h) this, '\"' + this.f13954b.m() + "\" is not a message type.", (AnonymousClass1) null);
            }
            throw new c((h) this, '\"' + this.f13954b.k() + "\" is not a message type.", (AnonymousClass1) null);
        }

        /* access modifiers changed from: private */
        public void a(i.u uVar) {
            this.f13954b = uVar;
        }
    }

    /* access modifiers changed from: private */
    public static String b(g gVar, a aVar, String str) {
        if (aVar != null) {
            return aVar.c() + '.' + str;
        } else if (gVar.e().length() <= 0) {
            return str;
        } else {
            return gVar.e() + '.' + str;
        }
    }

    public static class c extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;
        private final ac proto;

        /* synthetic */ c(g gVar, String str, AnonymousClass1 r3) {
            this(gVar, str);
        }

        /* synthetic */ c(h hVar, String str, AnonymousClass1 r3) {
            this(hVar, str);
        }

        /* synthetic */ c(h hVar, String str, Throwable th, AnonymousClass1 r4) {
            this(hVar, str, th);
        }

        private c(h hVar, String str) {
            super(hVar.c() + ": " + str);
            this.name = hVar.c();
            this.proto = hVar.j();
            this.description = str;
        }

        private c(h hVar, String str, Throwable th) {
            this(hVar, str);
            initCause(th);
        }

        private c(g gVar, String str) {
            super(gVar.b() + ": " + str);
            this.name = gVar.b();
            this.proto = gVar.j();
            this.description = str;
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f13915a = (!j.class.desiredAssertionStatus());

        /* renamed from: b  reason: collision with root package name */
        private final Set<g> f13916b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private boolean f13917c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<String, h> f13918d = new HashMap();
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final Map<a, f> f13919e = new HashMap();
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final Map<a, e> f13920f = new HashMap();

        enum c {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        b(g[] gVarArr, boolean z) {
            this.f13917c = z;
            for (int i = 0; i < gVarArr.length; i++) {
                this.f13916b.add(gVarArr[i]);
                a(gVarArr[i]);
            }
            for (g next : this.f13916b) {
                try {
                    a(next.e(), next);
                } catch (c unused) {
                    if (!f13915a) {
                        throw new AssertionError();
                    }
                }
            }
        }

        private void a(g gVar) {
            for (g next : gVar.h()) {
                if (this.f13916b.add(next)) {
                    a(next);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public h a(String str) {
            return a(str, c.ALL_SYMBOLS);
        }

        /* access modifiers changed from: package-private */
        public h a(String str, c cVar) {
            h hVar = this.f13918d.get(str);
            if (hVar != null && (cVar == c.ALL_SYMBOLS || ((cVar == c.TYPES_ONLY && a(hVar)) || (cVar == c.AGGREGATES_ONLY && b(hVar))))) {
                return hVar;
            }
            for (g a2 : this.f13916b) {
                h hVar2 = a2.h.f13918d.get(str);
                if (hVar2 != null && (cVar == c.ALL_SYMBOLS || ((cVar == c.TYPES_ONLY && a(hVar2)) || (cVar == c.AGGREGATES_ONLY && b(hVar2))))) {
                    return hVar2;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean a(h hVar) {
            return (hVar instanceof a) || (hVar instanceof d);
        }

        /* access modifiers changed from: package-private */
        public boolean b(h hVar) {
            return (hVar instanceof a) || (hVar instanceof d) || (hVar instanceof C0231b) || (hVar instanceof k);
        }

        /* access modifiers changed from: package-private */
        public h a(String str, h hVar, c cVar) throws c {
            h hVar2;
            String str2;
            String str3;
            if (str.startsWith(".")) {
                str2 = str.substring(1);
                hVar2 = a(str2, cVar);
            } else {
                int indexOf = str.indexOf(46);
                if (indexOf == -1) {
                    str3 = str;
                } else {
                    str3 = str.substring(0, indexOf);
                }
                StringBuilder sb = new StringBuilder(hVar.c());
                while (true) {
                    int lastIndexOf = sb.lastIndexOf(".");
                    if (lastIndexOf == -1) {
                        hVar2 = a(str, cVar);
                        str2 = str;
                        break;
                    }
                    int i = lastIndexOf + 1;
                    sb.setLength(i);
                    sb.append(str3);
                    h a2 = a(sb.toString(), c.AGGREGATES_ONLY);
                    if (a2 != null) {
                        if (indexOf != -1) {
                            sb.setLength(i);
                            sb.append(str);
                            hVar2 = a(sb.toString(), cVar);
                        } else {
                            hVar2 = a2;
                        }
                        str2 = sb.toString();
                    } else {
                        sb.setLength(lastIndexOf);
                    }
                }
            }
            if (hVar2 != null) {
                return hVar2;
            }
            if (!this.f13917c || cVar != c.TYPES_ONLY) {
                throw new c(hVar, '\"' + str + "\" is not defined.", (AnonymousClass1) null);
            }
            Logger a3 = j.f13905a;
            a3.warning("The descriptor for message type \"" + str + "\" can not be found and a placeholder is created for it");
            a aVar = new a(str2);
            this.f13916b.add(aVar.d());
            return aVar;
        }

        /* access modifiers changed from: package-private */
        public void c(h hVar) throws c {
            d(hVar);
            String c2 = hVar.c();
            int lastIndexOf = c2.lastIndexOf(46);
            h put = this.f13918d.put(c2, hVar);
            if (put != null) {
                this.f13918d.put(c2, put);
                if (hVar.d() != put.d()) {
                    throw new c(hVar, '\"' + c2 + "\" is already defined in file \"" + put.d().b() + "\".", (AnonymousClass1) null);
                } else if (lastIndexOf == -1) {
                    throw new c(hVar, '\"' + c2 + "\" is already defined.", (AnonymousClass1) null);
                } else {
                    throw new c(hVar, '\"' + c2.substring(lastIndexOf + 1) + "\" is already defined in \"" + c2.substring(0, lastIndexOf) + "\".", (AnonymousClass1) null);
                }
            }
        }

        /* renamed from: com.google.c.j$b$b  reason: collision with other inner class name */
        private static final class C0231b extends h {

            /* renamed from: a  reason: collision with root package name */
            private final String f13923a;

            /* renamed from: b  reason: collision with root package name */
            private final String f13924b;

            /* renamed from: c  reason: collision with root package name */
            private final g f13925c;

            public ac j() {
                return this.f13925c.j();
            }

            public String b() {
                return this.f13923a;
            }

            public String c() {
                return this.f13924b;
            }

            public g d() {
                return this.f13925c;
            }

            C0231b(String str, String str2, g gVar) {
                this.f13925c = gVar;
                this.f13924b = str2;
                this.f13923a = str;
            }
        }

        /* access modifiers changed from: package-private */
        public void a(String str, g gVar) throws c {
            String str2;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                str2 = str;
            } else {
                a(str.substring(0, lastIndexOf), gVar);
                str2 = str.substring(lastIndexOf + 1);
            }
            h put = this.f13918d.put(str, new C0231b(str2, str, gVar));
            if (put != null) {
                this.f13918d.put(str, put);
                if (!(put instanceof C0231b)) {
                    throw new c(gVar, '\"' + str2 + "\" is already defined (as something other than a " + "package) in file \"" + put.d().b() + "\".", (AnonymousClass1) null);
                }
            }
        }

        private static final class a {

            /* renamed from: a  reason: collision with root package name */
            private final h f13921a;

            /* renamed from: b  reason: collision with root package name */
            private final int f13922b;

            a(h hVar, int i) {
                this.f13921a = hVar;
                this.f13922b = i;
            }

            public int hashCode() {
                return (this.f13921a.hashCode() * MinElf.PN_XNUM) + this.f13922b;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.f13921a == aVar.f13921a && this.f13922b == aVar.f13922b) {
                    return true;
                }
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void a(f fVar) throws c {
            a aVar = new a(fVar.v(), fVar.f());
            f put = this.f13919e.put(aVar, fVar);
            if (put != null) {
                this.f13919e.put(aVar, put);
                throw new c((h) fVar, "Field number " + fVar.f() + " has already been used in \"" + fVar.v().c() + "\" by field \"" + put.b() + "\".", (AnonymousClass1) null);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(e eVar) {
            a aVar = new a(eVar.f(), eVar.getNumber());
            e put = this.f13920f.put(aVar, eVar);
            if (put != null) {
                this.f13920f.put(aVar, put);
            }
        }

        static void d(h hVar) throws c {
            String b2 = hVar.b();
            if (b2.length() != 0) {
                boolean z = true;
                for (int i = 0; i < b2.length(); i++) {
                    char charAt = b2.charAt(i);
                    if (charAt >= 128) {
                        z = false;
                    }
                    if (!Character.isLetter(charAt) && charAt != '_' && (!Character.isDigit(charAt) || i <= 0)) {
                        z = false;
                    }
                }
                if (!z) {
                    throw new c(hVar, '\"' + b2 + "\" is not a valid identifier.", (AnonymousClass1) null);
                }
                return;
            }
            throw new c(hVar, "Missing name.", (AnonymousClass1) null);
        }
    }

    /* renamed from: com.google.c.j$j  reason: collision with other inner class name */
    public static final class C0232j {

        /* renamed from: a  reason: collision with root package name */
        private final int f13960a;

        /* renamed from: b  reason: collision with root package name */
        private i.y f13961b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13962c;

        /* renamed from: d  reason: collision with root package name */
        private final g f13963d;

        /* renamed from: e  reason: collision with root package name */
        private a f13964e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f13965f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public f[] f13966g;

        /* synthetic */ C0232j(i.y yVar, g gVar, a aVar, int i, AnonymousClass1 r5) throws c {
            this(yVar, gVar, aVar, i);
        }

        static /* synthetic */ int b(C0232j jVar) {
            int i = jVar.f13965f;
            jVar.f13965f = i + 1;
            return i;
        }

        public int a() {
            return this.f13960a;
        }

        public a b() {
            return this.f13964e;
        }

        public int c() {
            return this.f13965f;
        }

        /* access modifiers changed from: private */
        public void a(i.y yVar) {
            this.f13961b = yVar;
        }

        private C0232j(i.y yVar, g gVar, a aVar, int i) throws c {
            this.f13961b = yVar;
            this.f13962c = j.b(gVar, aVar, yVar.i());
            this.f13963d = gVar;
            this.f13960a = i;
            this.f13964e = aVar;
            this.f13965f = 0;
        }
    }
}
