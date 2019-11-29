package com.google.c;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.c.a;
import com.google.c.ac;
import com.google.c.ah;
import com.google.c.at;
import com.google.c.ay;
import com.google.c.j;
import com.google.c.q;
import com.google.c.s;
import com.google.c.u;
import com.google.c.w;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class t extends a implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    protected static boolean f14020b = false;
    private static final long serialVersionUID = 1;
    protected at unknownFields;

    protected interface b extends a.b {
    }

    public interface e extends ag {
    }

    /* access modifiers changed from: protected */
    public void Y() {
    }

    /* access modifiers changed from: protected */
    public abstract ac.a b(b bVar);

    /* access modifiers changed from: protected */
    public abstract f m_();

    protected t() {
        this.unknownFields = at.f();
    }

    protected t(a<?> aVar) {
        this.unknownFields = aVar.f();
    }

    public aj<? extends t> F() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public j.a g() {
        return m_().f14033a;
    }

    /* access modifiers changed from: private */
    public Map<j.f, Object> a(boolean z) {
        TreeMap treeMap = new TreeMap();
        List<j.f> f2 = m_().f14033a.f();
        int i = 0;
        while (i < f2.size()) {
            j.f fVar = f2.get(i);
            j.C0232j w = fVar.w();
            if (w != null) {
                i += w.c() - 1;
                if (!a(w)) {
                    i++;
                } else {
                    fVar = b(w);
                }
            } else {
                if (fVar.p()) {
                    List list = (List) b(fVar);
                    if (!list.isEmpty()) {
                        treeMap.put(fVar, list);
                    }
                } else if (!a(fVar)) {
                }
                i++;
            }
            if (!z || fVar.g() != j.f.a.STRING) {
                treeMap.put(fVar, b(fVar));
                i++;
            } else {
                treeMap.put(fVar, c(fVar));
                i++;
            }
        }
        return treeMap;
    }

    public boolean a() {
        for (j.f next : g().f()) {
            if (next.n() && !a(next)) {
                return false;
            }
            if (next.g() == j.f.a.MESSAGE) {
                if (next.p()) {
                    for (ac a2 : (List) b(next)) {
                        if (!a2.a()) {
                            return false;
                        }
                    }
                    continue;
                } else if (a(next) && !((ac) b(next)).a()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Map<j.f, Object> o_() {
        return Collections.unmodifiableMap(a(false));
    }

    /* access modifiers changed from: package-private */
    public Map<j.f, Object> X() {
        return Collections.unmodifiableMap(a(true));
    }

    public boolean a(j.C0232j jVar) {
        return m_().a(jVar).a(this);
    }

    public j.f b(j.C0232j jVar) {
        return m_().a(jVar).b(this);
    }

    public boolean a(j.f fVar) {
        return m_().b(fVar).c(this);
    }

    public Object b(j.f fVar) {
        return m_().b(fVar).a(this);
    }

    /* access modifiers changed from: package-private */
    public Object c(j.f fVar) {
        return m_().b(fVar).b(this);
    }

    public at f() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* access modifiers changed from: protected */
    public boolean a(g gVar, at.a aVar, p pVar, int i) throws IOException {
        return aVar.a(i, gVar);
    }

    public void a(h hVar) throws IOException {
        ah.a((ac) this, X(), hVar, false);
    }

    public int b() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        this.memoizedSize = ah.a(this, X());
        return this.memoizedSize;
    }

    /* access modifiers changed from: protected */
    public ac.a a(final a.b bVar) {
        return b((b) new b() {
            public void a() {
                bVar.a();
            }
        });
    }

    public static abstract class a<BuilderType extends a<BuilderType>> extends a.C0223a<BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        private b f14023a;

        /* renamed from: b  reason: collision with root package name */
        private a<BuilderType>.a f14024b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f14025c;

        /* renamed from: d  reason: collision with root package name */
        private at f14026d;

        /* access modifiers changed from: protected */
        public abstract f e();

        protected a() {
            this((b) null);
        }

        protected a(b bVar) {
            this.f14026d = at.f();
            this.f14023a = bVar;
        }

        /* access modifiers changed from: protected */
        public void x() {
            if (this.f14023a != null) {
                c();
            }
        }

        /* access modifiers changed from: protected */
        public void c() {
            this.f14025c = true;
        }

        /* access modifiers changed from: protected */
        public boolean y() {
            return this.f14025c;
        }

        /* renamed from: s */
        public BuilderType d() {
            BuilderType buildertype = (a) L().H();
            buildertype.c(t());
            return buildertype;
        }

        public j.a g() {
            return e().f14033a;
        }

        public Map<j.f, Object> o_() {
            return Collections.unmodifiableMap(h());
        }

        /* access modifiers changed from: private */
        public Map<j.f, Object> h() {
            TreeMap treeMap = new TreeMap();
            List<j.f> f2 = e().f14033a.f();
            int i = 0;
            while (i < f2.size()) {
                j.f fVar = f2.get(i);
                j.C0232j w = fVar.w();
                if (w != null) {
                    i += w.c() - 1;
                    if (!a(w)) {
                        i++;
                    } else {
                        fVar = b(w);
                    }
                } else {
                    if (fVar.p()) {
                        List list = (List) b(fVar);
                        if (!list.isEmpty()) {
                            treeMap.put(fVar, list);
                        }
                    } else if (!a(fVar)) {
                    }
                    i++;
                }
                treeMap.put(fVar, b(fVar));
                i++;
            }
            return treeMap;
        }

        public ac.a d(j.f fVar) {
            return e().b(fVar).a();
        }

        public boolean a(j.C0232j jVar) {
            return e().a(jVar).a(this);
        }

        public j.f b(j.C0232j jVar) {
            return e().a(jVar).b(this);
        }

        public boolean a(j.f fVar) {
            return e().b(fVar).b(this);
        }

        public Object b(j.f fVar) {
            Object a2 = e().b(fVar).a(this);
            return fVar.p() ? Collections.unmodifiableList((List) a2) : a2;
        }

        /* renamed from: d */
        public BuilderType f(j.f fVar, Object obj) {
            e().b(fVar).a(this, obj);
            return this;
        }

        /* renamed from: c */
        public BuilderType e(j.f fVar, Object obj) {
            e().b(fVar).b(this, obj);
            return this;
        }

        /* renamed from: e */
        public BuilderType f(at atVar) {
            this.f14026d = atVar;
            A();
            return this;
        }

        /* renamed from: d */
        public BuilderType a(at atVar) {
            this.f14026d = at.a(this.f14026d).a(atVar).w();
            A();
            return this;
        }

        public boolean a() {
            for (j.f next : g().f()) {
                if (next.n() && !a(next)) {
                    return false;
                }
                if (next.g() == j.f.a.MESSAGE) {
                    if (next.p()) {
                        for (ac a2 : (List) b(next)) {
                            if (!a2.a()) {
                                return false;
                            }
                        }
                        continue;
                    } else if (a(next) && !((ac) b(next)).a()) {
                        return false;
                    }
                }
            }
            return true;
        }

        public final at f() {
            return this.f14026d;
        }

        /* renamed from: com.google.c.t$a$a  reason: collision with other inner class name */
        private class C0233a implements b {
            private C0233a() {
            }

            public void a() {
                a.this.A();
            }
        }

        /* access modifiers changed from: protected */
        public b z() {
            if (this.f14024b == null) {
                this.f14024b = new C0233a();
            }
            return this.f14024b;
        }

        /* access modifiers changed from: protected */
        public final void A() {
            if (this.f14025c) {
                b bVar = this.f14023a;
                if (bVar != null) {
                    bVar.a();
                    this.f14025c = false;
                }
            }
        }

        /* access modifiers changed from: protected */
        public aa f(int i) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        /* access modifiers changed from: protected */
        public aa g(int i) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }
    }

    public static abstract class d<MessageType extends d> extends t implements e<MessageType> {
        private static final long serialVersionUID = 1;
        /* access modifiers changed from: private */
        public final q<j.f> extensions;

        protected d() {
            this.extensions = q.a();
        }

        protected d(c<MessageType, ?> cVar) {
            super(cVar);
            this.extensions = cVar.j();
        }

        /* access modifiers changed from: protected */
        public boolean Z() {
            return this.extensions.h();
        }

        public boolean a() {
            return t.super.a() && Z();
        }

        /* access modifiers changed from: protected */
        public boolean a(g gVar, at.a aVar, p pVar, int i) throws IOException {
            return ah.a(gVar, aVar, pVar, g(), new ah.b(this.extensions), i);
        }

        /* access modifiers changed from: protected */
        public void Y() {
            this.extensions.c();
        }

        protected class a {

            /* renamed from: b  reason: collision with root package name */
            private final Iterator<Map.Entry<j.f, Object>> f14030b;

            /* renamed from: c  reason: collision with root package name */
            private Map.Entry<j.f, Object> f14031c;

            /* renamed from: d  reason: collision with root package name */
            private final boolean f14032d;

            private a(boolean z) {
                this.f14030b = d.this.extensions.g();
                if (this.f14030b.hasNext()) {
                    this.f14031c = this.f14030b.next();
                }
                this.f14032d = z;
            }

            public void a(int i, h hVar) throws IOException {
                while (true) {
                    Map.Entry<j.f, Object> entry = this.f14031c;
                    if (entry != null && entry.getKey().f() < i) {
                        j.f key = this.f14031c.getKey();
                        if (!this.f14032d || key.h() != ay.b.MESSAGE || key.p()) {
                            q.a((q.a<?>) key, this.f14031c.getValue(), hVar);
                        } else if (this.f14031c instanceof w.a) {
                            hVar.b(key.f(), ((w.a) this.f14031c).a().c());
                        } else {
                            hVar.b(key.f(), (ad) (ac) this.f14031c.getValue());
                        }
                        if (this.f14030b.hasNext()) {
                            this.f14031c = this.f14030b.next();
                        } else {
                            this.f14031c = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public d<MessageType>.a aa() {
            return new a(false);
        }

        /* access modifiers changed from: protected */
        public int ab() {
            return this.extensions.i();
        }

        /* access modifiers changed from: protected */
        public Map<j.f, Object> ac() {
            return this.extensions.f();
        }

        public Map<j.f, Object> o_() {
            Map a2 = a(false);
            a2.putAll(ac());
            return Collections.unmodifiableMap(a2);
        }

        public Map<j.f, Object> X() {
            Map a2 = a(false);
            a2.putAll(ac());
            return Collections.unmodifiableMap(a2);
        }

        public boolean a(j.f fVar) {
            if (!fVar.u()) {
                return t.super.a(fVar);
            }
            d(fVar);
            return this.extensions.a(fVar);
        }

        public Object b(j.f fVar) {
            if (!fVar.u()) {
                return t.super.b(fVar);
            }
            d(fVar);
            Object b2 = this.extensions.b(fVar);
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

        private void d(j.f fVar) {
            if (fVar.v() != g()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public static abstract class c<MessageType extends d, BuilderType extends c<MessageType, BuilderType>> extends a<BuilderType> implements e<MessageType> {

        /* renamed from: a  reason: collision with root package name */
        private q<j.f> f14028a = q.b();

        protected c() {
        }

        protected c(b bVar) {
            super(bVar);
        }

        /* renamed from: m */
        public BuilderType s() {
            return (c) super.d();
        }

        private void h() {
            if (this.f14028a.d()) {
                this.f14028a = this.f14028a.clone();
            }
        }

        /* access modifiers changed from: protected */
        public boolean n() {
            return this.f14028a.h();
        }

        /* access modifiers changed from: private */
        public q<j.f> j() {
            this.f14028a.c();
            return this.f14028a;
        }

        public boolean a() {
            return super.a() && n();
        }

        public Map<j.f, Object> o_() {
            Map a2 = h();
            a2.putAll(this.f14028a.f());
            return Collections.unmodifiableMap(a2);
        }

        public Object b(j.f fVar) {
            if (!fVar.u()) {
                return super.b(fVar);
            }
            c(fVar);
            Object b2 = this.f14028a.b(fVar);
            if (b2 != null) {
                return b2;
            }
            if (fVar.g() == j.f.a.MESSAGE) {
                return k.a(fVar.y());
            }
            return fVar.s();
        }

        public boolean a(j.f fVar) {
            if (!fVar.u()) {
                return super.a(fVar);
            }
            c(fVar);
            return this.f14028a.a(fVar);
        }

        /* renamed from: h */
        public BuilderType f(j.f fVar, Object obj) {
            if (!fVar.u()) {
                return (c) super.f(fVar, obj);
            }
            c(fVar);
            h();
            this.f14028a.a(fVar, obj);
            A();
            return this;
        }

        /* renamed from: g */
        public BuilderType e(j.f fVar, Object obj) {
            if (!fVar.u()) {
                return (c) super.e(fVar, obj);
            }
            c(fVar);
            h();
            this.f14028a.b(fVar, obj);
            A();
            return this;
        }

        /* access modifiers changed from: protected */
        public final void a(d dVar) {
            h();
            this.f14028a.a(dVar.extensions);
            A();
        }

        private void c(j.f fVar) {
            if (fVar.v() != g()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    /* access modifiers changed from: private */
    public static Method b(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e2);
        }
    }

    /* access modifiers changed from: private */
    public static Object b(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    /* access modifiers changed from: protected */
    public aa g(int i) {
        throw new RuntimeException("No map fields found in " + getClass().getName());
    }

    public static final class f {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final j.a f14033a;

        /* renamed from: b  reason: collision with root package name */
        private final a[] f14034b;

        /* renamed from: c  reason: collision with root package name */
        private String[] f14035c;

        /* renamed from: d  reason: collision with root package name */
        private final c[] f14036d;

        /* renamed from: e  reason: collision with root package name */
        private volatile boolean f14037e = false;

        private interface a {
            ac.a a();

            Object a(a aVar);

            Object a(t tVar);

            void a(a aVar, Object obj);

            Object b(t tVar);

            void b(a aVar, Object obj);

            boolean b(a aVar);

            boolean c(t tVar);
        }

        private boolean a(j.f fVar) {
            return true;
        }

        public f(j.a aVar, String[] strArr) {
            this.f14033a = aVar;
            this.f14035c = strArr;
            this.f14034b = new a[aVar.f().size()];
            this.f14036d = new c[aVar.g().size()];
        }

        public f a(Class<? extends t> cls, Class<? extends a> cls2) {
            if (this.f14037e) {
                return this;
            }
            synchronized (this) {
                if (this.f14037e) {
                    return this;
                }
                int length = this.f14034b.length;
                int i2 = 0;
                while (true) {
                    String str = null;
                    if (i2 >= length) {
                        break;
                    }
                    j.f fVar = this.f14033a.f().get(i2);
                    if (fVar.w() != null) {
                        str = this.f14035c[fVar.w().a() + length];
                    }
                    String str2 = str;
                    if (fVar.p()) {
                        if (fVar.g() == j.f.a.MESSAGE) {
                            if (!fVar.m() || !a(fVar)) {
                                this.f14034b[i2] = new C0234f(fVar, this.f14035c[i2], cls, cls2);
                            } else {
                                this.f14034b[i2] = new b(fVar, this.f14035c[i2], cls, cls2);
                            }
                        } else if (fVar.g() == j.f.a.ENUM) {
                            this.f14034b[i2] = new d(fVar, this.f14035c[i2], cls, cls2);
                        } else {
                            this.f14034b[i2] = new e(fVar, this.f14035c[i2], cls, cls2);
                        }
                    } else if (fVar.g() == j.f.a.MESSAGE) {
                        this.f14034b[i2] = new i(fVar, this.f14035c[i2], cls, cls2, str2);
                    } else if (fVar.g() == j.f.a.ENUM) {
                        this.f14034b[i2] = new g(fVar, this.f14035c[i2], cls, cls2, str2);
                    } else if (fVar.g() == j.f.a.STRING) {
                        this.f14034b[i2] = new j(fVar, this.f14035c[i2], cls, cls2, str2);
                    } else {
                        this.f14034b[i2] = new h(fVar, this.f14035c[i2], cls, cls2, str2);
                    }
                    i2++;
                }
                int length2 = this.f14036d.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    this.f14036d[i3] = new c(this.f14033a, this.f14035c[i3 + length], cls, cls2);
                }
                this.f14037e = true;
                this.f14035c = null;
                return this;
            }
        }

        /* access modifiers changed from: private */
        public a b(j.f fVar) {
            if (fVar.v() != this.f14033a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else if (!fVar.u()) {
                return this.f14034b[fVar.a()];
            } else {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
        }

        /* access modifiers changed from: private */
        public c a(j.C0232j jVar) {
            if (jVar.b() == this.f14033a) {
                return this.f14036d[jVar.a()];
            }
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        private static class c {

            /* renamed from: a  reason: collision with root package name */
            private final j.a f14040a;

            /* renamed from: b  reason: collision with root package name */
            private final Method f14041b;

            /* renamed from: c  reason: collision with root package name */
            private final Method f14042c;

            /* renamed from: d  reason: collision with root package name */
            private final Method f14043d;

            c(j.a aVar, String str, Class<? extends t> cls, Class<? extends a> cls2) {
                this.f14040a = aVar;
                this.f14041b = t.b((Class) cls, "get" + str + "Case", new Class[0]);
                this.f14042c = t.b((Class) cls2, "get" + str + "Case", new Class[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("clear");
                sb.append(str);
                this.f14043d = t.b((Class) cls2, sb.toString(), new Class[0]);
            }

            public boolean a(t tVar) {
                return ((u.a) t.b(this.f14041b, (Object) tVar, new Object[0])).getNumber() != 0;
            }

            public boolean a(a aVar) {
                return ((u.a) t.b(this.f14042c, (Object) aVar, new Object[0])).getNumber() != 0;
            }

            public j.f b(t tVar) {
                int number = ((u.a) t.b(this.f14041b, (Object) tVar, new Object[0])).getNumber();
                if (number > 0) {
                    return this.f14040a.b(number);
                }
                return null;
            }

            public j.f b(a aVar) {
                int number = ((u.a) t.b(this.f14042c, (Object) aVar, new Object[0])).getNumber();
                if (number > 0) {
                    return this.f14040a.b(number);
                }
                return null;
            }
        }

        /* access modifiers changed from: private */
        public static boolean b(j.g gVar) {
            return gVar.i() == j.g.b.PROTO2;
        }

        private static class h implements a {

            /* renamed from: a  reason: collision with root package name */
            protected final Class<?> f14051a;

            /* renamed from: b  reason: collision with root package name */
            protected final Method f14052b;

            /* renamed from: c  reason: collision with root package name */
            protected final Method f14053c;

            /* renamed from: d  reason: collision with root package name */
            protected final Method f14054d;

            /* renamed from: e  reason: collision with root package name */
            protected final Method f14055e;

            /* renamed from: f  reason: collision with root package name */
            protected final Method f14056f;

            /* renamed from: g  reason: collision with root package name */
            protected final Method f14057g;
            protected final Method h;
            protected final Method i;
            protected final j.f j;
            protected final boolean k;
            protected final boolean l;

            h(j.f fVar, String str, Class<? extends t> cls, Class<? extends a> cls2, String str2) {
                Method method;
                Method method2;
                Method method3;
                this.j = fVar;
                this.k = fVar.w() != null;
                this.l = f.b(fVar.d()) || (!this.k && fVar.g() == j.f.a.MESSAGE);
                this.f14052b = t.b((Class) cls, "get" + str, new Class[0]);
                this.f14053c = t.b((Class) cls2, "get" + str, new Class[0]);
                this.f14051a = this.f14052b.getReturnType();
                this.f14054d = t.b((Class) cls2, "set" + str, this.f14051a);
                Method method4 = null;
                if (this.l) {
                    method = t.b((Class) cls, "has" + str, new Class[0]);
                } else {
                    method = null;
                }
                this.f14055e = method;
                if (this.l) {
                    method2 = t.b((Class) cls2, "has" + str, new Class[0]);
                } else {
                    method2 = null;
                }
                this.f14056f = method2;
                this.f14057g = t.b((Class) cls2, "clear" + str, new Class[0]);
                if (this.k) {
                    method3 = t.b((Class) cls, "get" + str2 + "Case", new Class[0]);
                } else {
                    method3 = null;
                }
                this.h = method3;
                if (this.k) {
                    method4 = t.b((Class) cls2, "get" + str2 + "Case", new Class[0]);
                }
                this.i = method4;
            }

            private int d(t tVar) {
                return ((u.a) t.b(this.h, (Object) tVar, new Object[0])).getNumber();
            }

            private int c(a aVar) {
                return ((u.a) t.b(this.i, (Object) aVar, new Object[0])).getNumber();
            }

            public Object a(t tVar) {
                return t.b(this.f14052b, (Object) tVar, new Object[0]);
            }

            public Object a(a aVar) {
                return t.b(this.f14053c, (Object) aVar, new Object[0]);
            }

            public Object b(t tVar) {
                return a(tVar);
            }

            public void a(a aVar, Object obj) {
                Object unused = t.b(this.f14054d, (Object) aVar, obj);
            }

            public void b(a aVar, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            public boolean c(t tVar) {
                if (this.l) {
                    return ((Boolean) t.b(this.f14055e, (Object) tVar, new Object[0])).booleanValue();
                }
                if (!this.k) {
                    return !a(tVar).equals(this.j.s());
                }
                if (d(tVar) == this.j.f()) {
                    return true;
                }
                return false;
            }

            public boolean b(a aVar) {
                if (this.l) {
                    return ((Boolean) t.b(this.f14056f, (Object) aVar, new Object[0])).booleanValue();
                }
                if (!this.k) {
                    return !a(aVar).equals(this.j.s());
                }
                if (c(aVar) == this.j.f()) {
                    return true;
                }
                return false;
            }

            public ac.a a() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }
        }

        private static class e implements a {

            /* renamed from: a  reason: collision with root package name */
            protected final Class f14044a = this.f14047d.getReturnType();

            /* renamed from: b  reason: collision with root package name */
            protected final Method f14045b;

            /* renamed from: c  reason: collision with root package name */
            protected final Method f14046c;

            /* renamed from: d  reason: collision with root package name */
            protected final Method f14047d;

            /* renamed from: e  reason: collision with root package name */
            protected final Method f14048e;

            /* renamed from: f  reason: collision with root package name */
            protected final Method f14049f;

            /* renamed from: g  reason: collision with root package name */
            protected final Method f14050g;
            protected final Method h;
            protected final Method i;
            protected final Method j;

            e(j.f fVar, String str, Class<? extends t> cls, Class<? extends a> cls2) {
                this.f14045b = t.b((Class) cls, "get" + str + "List", new Class[0]);
                this.f14046c = t.b((Class) cls2, "get" + str + "List", new Class[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("get");
                sb.append(str);
                this.f14047d = t.b((Class) cls, sb.toString(), Integer.TYPE);
                this.f14048e = t.b((Class) cls2, "get" + str, Integer.TYPE);
                this.f14049f = t.b((Class) cls2, "set" + str, Integer.TYPE, this.f14044a);
                this.f14050g = t.b((Class) cls2, ProductAction.ACTION_ADD + str, this.f14044a);
                this.h = t.b((Class) cls, "get" + str + "Count", new Class[0]);
                this.i = t.b((Class) cls2, "get" + str + "Count", new Class[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("clear");
                sb2.append(str);
                this.j = t.b((Class) cls2, sb2.toString(), new Class[0]);
            }

            public Object a(t tVar) {
                return t.b(this.f14045b, (Object) tVar, new Object[0]);
            }

            public Object a(a aVar) {
                return t.b(this.f14046c, (Object) aVar, new Object[0]);
            }

            public Object b(t tVar) {
                return a(tVar);
            }

            public void a(a aVar, Object obj) {
                d(aVar);
                for (Object b2 : (List) obj) {
                    b(aVar, b2);
                }
            }

            public Object a(t tVar, int i2) {
                return t.b(this.f14047d, (Object) tVar, Integer.valueOf(i2));
            }

            public Object a(a aVar, int i2) {
                return t.b(this.f14048e, (Object) aVar, Integer.valueOf(i2));
            }

            public void b(a aVar, Object obj) {
                Object unused = t.b(this.f14050g, (Object) aVar, obj);
            }

            public boolean c(t tVar) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            public boolean b(a aVar) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            public int d(t tVar) {
                return ((Integer) t.b(this.h, (Object) tVar, new Object[0])).intValue();
            }

            public int c(a aVar) {
                return ((Integer) t.b(this.i, (Object) aVar, new Object[0])).intValue();
            }

            public void d(a aVar) {
                Object unused = t.b(this.j, (Object) aVar, new Object[0]);
            }

            public ac.a a() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }
        }

        private static class b implements a {

            /* renamed from: a  reason: collision with root package name */
            private final j.f f14038a;

            /* renamed from: b  reason: collision with root package name */
            private final ac f14039b;

            b(j.f fVar, String str, Class<? extends t> cls, Class<? extends a> cls2) {
                this.f14038a = fVar;
                this.f14039b = e((t) t.b(t.b((Class) cls, "getDefaultInstance", new Class[0]), (Object) null, new Object[0])).d();
            }

            private aa<?, ?> e(t tVar) {
                return tVar.g(this.f14038a.f());
            }

            private aa<?, ?> e(a aVar) {
                return aVar.f(this.f14038a.f());
            }

            private aa<?, ?> f(a aVar) {
                return aVar.g(this.f14038a.f());
            }

            public Object a(t tVar) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < d(tVar); i++) {
                    arrayList.add(a(tVar, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public Object a(a aVar) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < c(aVar); i++) {
                    arrayList.add(a(aVar, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public Object b(t tVar) {
                return a(tVar);
            }

            public void a(a aVar, Object obj) {
                d(aVar);
                for (Object b2 : (List) obj) {
                    b(aVar, b2);
                }
            }

            public Object a(t tVar, int i) {
                return e(tVar).b().get(i);
            }

            public Object a(a aVar, int i) {
                return e(aVar).b().get(i);
            }

            public void b(a aVar, Object obj) {
                f(aVar).c().add((ac) obj);
            }

            public boolean c(t tVar) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            public boolean b(a aVar) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            public int d(t tVar) {
                return e(tVar).b().size();
            }

            public int c(a aVar) {
                return e(aVar).b().size();
            }

            public void d(a aVar) {
                f(aVar).c().clear();
            }

            public ac.a a() {
                return this.f14039b.H();
            }
        }

        private static final class g extends h {
            private j.d m;
            private Method n = t.b(this.f14051a, "valueOf", j.e.class);
            private Method o = t.b(this.f14051a, "getValueDescriptor", new Class[0]);
            private boolean p;
            private Method q;
            private Method r;
            private Method s;

            g(j.f fVar, String str, Class<? extends t> cls, Class<? extends a> cls2, String str2) {
                super(fVar, str, cls, cls2, str2);
                this.m = fVar.z();
                this.p = fVar.d().k();
                if (this.p) {
                    this.q = t.b((Class) cls, "get" + str + "Value", new Class[0]);
                    this.r = t.b((Class) cls2, "get" + str + "Value", new Class[0]);
                    this.s = t.b((Class) cls2, "set" + str + "Value", Integer.TYPE);
                }
            }

            public Object a(t tVar) {
                if (!this.p) {
                    return t.b(this.o, super.a(tVar), new Object[0]);
                }
                return this.m.b(((Integer) t.b(this.q, (Object) tVar, new Object[0])).intValue());
            }

            public Object a(a aVar) {
                if (!this.p) {
                    return t.b(this.o, super.a(aVar), new Object[0]);
                }
                return this.m.b(((Integer) t.b(this.r, (Object) aVar, new Object[0])).intValue());
            }

            public void a(a aVar, Object obj) {
                if (this.p) {
                    Object unused = t.b(this.s, (Object) aVar, Integer.valueOf(((j.e) obj).getNumber()));
                    return;
                }
                super.a(aVar, t.b(this.n, (Object) null, obj));
            }
        }

        private static final class d extends e {
            private j.d k;
            private final Method l = t.b(this.f14044a, "valueOf", j.e.class);
            private final Method m = t.b(this.f14044a, "getValueDescriptor", new Class[0]);
            private boolean n;
            private Method o;
            private Method p;
            private Method q;
            private Method r;

            d(j.f fVar, String str, Class<? extends t> cls, Class<? extends a> cls2) {
                super(fVar, str, cls, cls2);
                this.k = fVar.z();
                this.n = fVar.d().k();
                if (this.n) {
                    this.o = t.b((Class) cls, "get" + str + "Value", Integer.TYPE);
                    this.p = t.b((Class) cls2, "get" + str + "Value", Integer.TYPE);
                    this.q = t.b((Class) cls2, "set" + str + "Value", Integer.TYPE, Integer.TYPE);
                    this.r = t.b((Class) cls2, ProductAction.ACTION_ADD + str + "Value", Integer.TYPE);
                }
            }

            public Object a(t tVar) {
                ArrayList arrayList = new ArrayList();
                int d2 = d(tVar);
                for (int i = 0; i < d2; i++) {
                    arrayList.add(a(tVar, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public Object a(a aVar) {
                ArrayList arrayList = new ArrayList();
                int c2 = c(aVar);
                for (int i = 0; i < c2; i++) {
                    arrayList.add(a(aVar, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public Object a(t tVar, int i) {
                if (!this.n) {
                    return t.b(this.m, super.a(tVar, i), new Object[0]);
                }
                return this.k.b(((Integer) t.b(this.o, (Object) tVar, Integer.valueOf(i))).intValue());
            }

            public Object a(a aVar, int i) {
                if (!this.n) {
                    return t.b(this.m, super.a(aVar, i), new Object[0]);
                }
                return this.k.b(((Integer) t.b(this.p, (Object) aVar, Integer.valueOf(i))).intValue());
            }

            public void b(a aVar, Object obj) {
                if (this.n) {
                    Object unused = t.b(this.r, (Object) aVar, Integer.valueOf(((j.e) obj).getNumber()));
                    return;
                }
                super.b(aVar, t.b(this.l, (Object) null, obj));
            }
        }

        private static final class j extends h {
            private final Method m;
            private final Method n;
            private final Method o;

            j(j.f fVar, String str, Class<? extends t> cls, Class<? extends a> cls2, String str2) {
                super(fVar, str, cls, cls2, str2);
                this.m = t.b((Class) cls, "get" + str + "Bytes", new Class[0]);
                this.n = t.b((Class) cls2, "get" + str + "Bytes", new Class[0]);
                this.o = t.b((Class) cls2, "set" + str + "Bytes", f.class);
            }

            public Object b(t tVar) {
                return t.b(this.m, (Object) tVar, new Object[0]);
            }

            public void a(a aVar, Object obj) {
                if (obj instanceof f) {
                    Object unused = t.b(this.o, (Object) aVar, obj);
                    return;
                }
                super.a(aVar, obj);
            }
        }

        private static final class i extends h {
            private final Method m = t.b(this.f14051a, "newBuilder", new Class[0]);
            private final Method n;

            i(j.f fVar, String str, Class<? extends t> cls, Class<? extends a> cls2, String str2) {
                super(fVar, str, cls, cls2, str2);
                this.n = t.b((Class) cls2, "get" + str + "Builder", new Class[0]);
            }

            private Object a(Object obj) {
                if (this.f14051a.isInstance(obj)) {
                    return obj;
                }
                return ((ac.a) t.b(this.m, (Object) null, new Object[0])).c((ac) obj).t();
            }

            public void a(a aVar, Object obj) {
                super.a(aVar, a(obj));
            }

            public ac.a a() {
                return (ac.a) t.b(this.m, (Object) null, new Object[0]);
            }
        }

        /* renamed from: com.google.c.t$f$f  reason: collision with other inner class name */
        private static final class C0234f extends e {
            private final Method k = t.b(this.f14044a, "newBuilder", new Class[0]);
            private final Method l;

            C0234f(j.f fVar, String str, Class<? extends t> cls, Class<? extends a> cls2) {
                super(fVar, str, cls, cls2);
                this.l = t.b((Class) cls2, "get" + str + "Builder", Integer.TYPE);
            }

            private Object a(Object obj) {
                if (this.f14044a.isInstance(obj)) {
                    return obj;
                }
                return ((ac.a) t.b(this.k, (Object) null, new Object[0])).c((ac) obj).u();
            }

            public void b(a aVar, Object obj) {
                super.b(aVar, a(obj));
            }

            public ac.a a() {
                return (ac.a) t.b(this.k, (Object) null, new Object[0]);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() throws ObjectStreamException {
        return new s.i(this);
    }

    protected static int a(int i, Object obj) {
        if (obj instanceof String) {
            return h.b(i, (String) obj);
        }
        return h.c(i, (f) obj);
    }

    protected static int a(Object obj) {
        if (obj instanceof String) {
            return h.b((String) obj);
        }
        return h.b((f) obj);
    }

    protected static void a(h hVar, int i, Object obj) throws IOException {
        if (obj instanceof String) {
            hVar.a(i, (String) obj);
        } else {
            hVar.a(i, (f) obj);
        }
    }
}
