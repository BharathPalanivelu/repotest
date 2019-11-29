package com.google.c;

import com.google.c.ad;
import com.google.c.ay;
import com.google.c.b;
import com.google.c.q;
import com.google.c.s;
import com.google.c.s.a;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class s<MessageType extends s<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends b<MessageType, BuilderType> {

    /* renamed from: a  reason: collision with root package name */
    protected au f14005a = au.a();

    /* renamed from: b  reason: collision with root package name */
    protected int f14006b = -1;

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends s<MessageType, BuilderType> implements d<MessageType, BuilderType> {

        /* renamed from: c  reason: collision with root package name */
        protected q<e> f14013c = q.a();
    }

    public interface d extends ae {
    }

    public enum h {
        IS_INITIALIZED,
        VISIT,
        MERGE_FROM_STREAM,
        MAKE_IMMUTABLE,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    protected interface j {
        au a(au auVar, au auVar2);
    }

    /* access modifiers changed from: protected */
    public abstract Object a(h hVar, Object obj, Object obj2);

    public final MessageType f() {
        return (s) a(h.GET_DEFAULT_INSTANCE);
    }

    public final BuilderType g() {
        return (a) a(h.NEW_BUILDER);
    }

    public String toString() {
        return af.a(this, super.toString());
    }

    public int hashCode() {
        if (this.memoizedHashCode == 0) {
            f fVar = new f((AnonymousClass1) null);
            a(fVar, this);
            this.memoizedHashCode = fVar.f14018a;
        }
        return this.memoizedHashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!f().getClass().isInstance(obj)) {
            return false;
        }
        try {
            a(b.f14011a, (s) obj);
            return true;
        } catch (b.a unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        a(h.MAKE_IMMUTABLE);
        this.f14005a.b();
    }

    /* access modifiers changed from: protected */
    public Object a(h hVar) {
        return a(hVar, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void a(j jVar, MessageType messagetype) {
        a(h.VISIT, (Object) jVar, (Object) messagetype);
        this.f14005a = jVar.a(this.f14005a, messagetype.f14005a);
    }

    public static abstract class a<MessageType extends s<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends b.a<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        protected MessageType f14008a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f14009b;

        /* renamed from: c  reason: collision with root package name */
        private final MessageType f14010c;

        /* access modifiers changed from: protected */
        public void b() {
            if (this.f14009b) {
                MessageType messagetype = (s) this.f14008a.a(h.NEW_MUTABLE_INSTANCE);
                messagetype.a(g.f14019a, this.f14008a);
                this.f14008a = messagetype;
                this.f14009b = false;
            }
        }

        /* renamed from: c */
        public BuilderType clone() {
            BuilderType g2 = f().g();
            g2.a(e());
            return g2;
        }

        public MessageType e() {
            if (this.f14009b) {
                return this.f14008a;
            }
            this.f14008a.h();
            this.f14009b = true;
            return this.f14008a;
        }

        public BuilderType a(MessageType messagetype) {
            b();
            this.f14008a.a(g.f14019a, messagetype);
            return this;
        }

        public MessageType f() {
            return this.f14010c;
        }
    }

    /* renamed from: com.google.c.s$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14007a = new int[ay.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.google.c.ay$b[] r0 = com.google.c.ay.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14007a = r0
                int[] r0 = f14007a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.c.ay$b r1 = com.google.c.ay.b.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f14007a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.c.ay$b r1 = com.google.c.ay.b.ENUM     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.s.AnonymousClass1.<clinit>():void");
        }
    }

    static final class e implements q.a<e> {

        /* renamed from: a  reason: collision with root package name */
        final int f14014a;

        /* renamed from: b  reason: collision with root package name */
        final ay.a f14015b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f14016c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f14017d;

        public int f() {
            return this.f14014a;
        }

        public ay.a k() {
            return this.f14015b;
        }

        public ay.b h() {
            return this.f14015b.getJavaType();
        }

        public boolean p() {
            return this.f14016c;
        }

        public boolean q() {
            return this.f14017d;
        }

        public ad.a a(ad.a aVar, ad adVar) {
            return ((a) aVar).a((s) adVar);
        }

        /* renamed from: a */
        public int compareTo(e eVar) {
            return this.f14014a - eVar.f14014a;
        }
    }

    static Object a(Method method, Object obj, Object... objArr) {
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

    protected static final class i implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final String messageClassName;

        i(ad adVar) {
            this.messageClassName = adVar.getClass().getName();
            this.asBytes = adVar.e();
        }

        /* access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = Class.forName(this.messageClassName).getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((ad) declaredField.get((Object) null)).J().c(this.asBytes).v();
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e2);
            } catch (NoSuchFieldException unused) {
                return a();
            } catch (SecurityException e3) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Unable to call parsePartialFrom", e4);
            } catch (v e5) {
                throw new RuntimeException("Unable to understand proto buffer", e5);
            }
        }

        @Deprecated
        private Object a() throws ObjectStreamException {
            try {
                Field declaredField = Class.forName(this.messageClassName).getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((ad) declaredField.get((Object) null)).J().c(this.asBytes).v();
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e2);
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e3);
            } catch (SecurityException e4) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("Unable to call parsePartialFrom", e5);
            } catch (v e6) {
                throw new RuntimeException("Unable to understand proto buffer", e6);
            }
        }
    }

    static class b implements j {

        /* renamed from: a  reason: collision with root package name */
        static final b f14011a = new b();

        /* renamed from: b  reason: collision with root package name */
        static final a f14012b = new a();

        static final class a extends RuntimeException {
            a() {
            }
        }

        private b() {
        }

        public au a(au auVar, au auVar2) {
            if (auVar.equals(auVar2)) {
                return auVar;
            }
            throw f14012b;
        }
    }

    private static class f implements j {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f14018a;

        private f() {
            this.f14018a = 0;
        }

        /* synthetic */ f(AnonymousClass1 r1) {
            this();
        }

        public au a(au auVar, au auVar2) {
            this.f14018a = (this.f14018a * 53) + auVar.hashCode();
            return auVar;
        }
    }

    protected static class g implements j {

        /* renamed from: a  reason: collision with root package name */
        public static final g f14019a = new g();

        private g() {
        }

        public au a(au auVar, au auVar2) {
            return auVar2 == au.a() ? auVar : au.a(auVar, auVar2);
        }
    }
}
