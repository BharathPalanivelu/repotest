package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.kv;
import com.google.android.libraries.places.internal.kv.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class kv<MessageType extends kv<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends ju<MessageType, BuilderType> {

    /* renamed from: b  reason: collision with root package name */
    private static Map<Object, kv<?, ?>> f12902b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private int f12903a = -1;
    public ng r = ng.f13014a;

    public static abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType> extends kv<MessageType, BuilderType> implements mc {

        /* renamed from: a  reason: collision with root package name */
        public kp<c> f12907a = kp.f12884d;
    }

    static final class c implements kq<c> {
        public final int a() {
            throw new NoSuchMethodError();
        }

        public final nr b() {
            throw new NoSuchMethodError();
        }

        public final ns c() {
            throw new NoSuchMethodError();
        }

        public final boolean d() {
            throw new NoSuchMethodError();
        }

        public final boolean e() {
            throw new NoSuchMethodError();
        }

        public final mb f() {
            throw new NoSuchMethodError();
        }

        public final mf g() {
            throw new NoSuchMethodError();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    public enum d {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public abstract Object a(d dVar, Object obj);

    public String toString() {
        return lt.a((ma) this, super.toString());
    }

    public int hashCode() {
        if (this.q != 0) {
            return this.q;
        }
        this.q = mm.f12971a.a(this).a(this);
        return this.q;
    }

    public static abstract class a<MessageType extends kv<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends jv<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        public MessageType f12904a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12905b = false;

        /* renamed from: c  reason: collision with root package name */
        private final MessageType f12906c;

        public a(MessageType messagetype) {
            this.f12906c = messagetype;
            this.f12904a = (kv) messagetype.a(d.NEW_MUTABLE_INSTANCE, (Object) null);
        }

        public final void b() {
            if (this.f12905b) {
                MessageType messagetype = (kv) this.f12904a.a(d.NEW_MUTABLE_INSTANCE, (Object) null);
                a(messagetype, this.f12904a);
                this.f12904a = messagetype;
                this.f12905b = false;
            }
        }

        public final boolean g() {
            return kv.a(this.f12904a, false);
        }

        public final BuilderType a(MessageType messagetype) {
            b();
            a(this.f12904a, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            mm.f12971a.a(messagetype).b(messagetype, messagetype2);
        }

        public final /* synthetic */ jv a() {
            return (a) clone();
        }

        public final /* synthetic */ ma c() {
            if (this.f12905b) {
                return this.f12904a;
            }
            this.f12904a.e();
            this.f12905b = true;
            return this.f12904a;
        }

        public final /* synthetic */ ma d() {
            MessageType messagetype;
            if (this.f12905b) {
                messagetype = this.f12904a;
            } else {
                this.f12904a.e();
                this.f12905b = true;
                messagetype = this.f12904a;
            }
            kv kvVar = (kv) messagetype;
            if (kvVar.g()) {
                return kvVar;
            }
            throw new ne();
        }

        public final /* synthetic */ ma k() {
            return this.f12906c;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            MessageType messagetype;
            a aVar = (a) ((kv) this.f12906c).j();
            if (this.f12905b) {
                messagetype = this.f12904a;
            } else {
                this.f12904a.e();
                this.f12905b = true;
                messagetype = this.f12904a;
            }
            aVar.a((kv) messagetype);
            return aVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((kv) a(d.GET_DEFAULT_INSTANCE, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return mm.f12971a.a(this).a(this, (kv) obj);
    }

    public void e() {
        mm.f12971a.a(this).c(this);
    }

    public final <MessageType extends kv<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType f() {
        return (a) a(d.NEW_BUILDER, (Object) null);
    }

    public final boolean g() {
        return a(this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: package-private */
    public final int d() {
        return this.f12903a;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        this.f12903a = i;
    }

    public final void a(kk kkVar) throws IOException {
        mm.f12971a.a(getClass()).a(this, nt.a(kkVar));
    }

    public final int h() {
        if (this.f12903a == -1) {
            this.f12903a = mm.f12971a.a(this).b(this);
        }
        return this.f12903a;
    }

    static <T extends kv<?, ?>> T a(Class<T> cls) {
        T t = (kv) f12902b.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (kv) f12902b.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (kv) ((kv) nk.a(cls)).a(d.GET_DEFAULT_INSTANCE, (Object) null);
            if (t != null) {
                f12902b.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public static <T extends kv<?, ?>> void a(Class<T> cls, T t) {
        f12902b.put(cls, t);
    }

    public static Object a(ma maVar, String str, Object[] objArr) {
        return new mo(maVar, str, objArr);
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

    protected static final <T extends kv<T, ?>> boolean a(T t, boolean z) {
        T t2 = null;
        byte byteValue = ((Byte) t.a(d.GET_MEMOIZED_IS_INITIALIZED, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d2 = mm.f12971a.a(t).d(t);
        if (z) {
            d dVar = d.SET_MEMOIZED_IS_INITIALIZED;
            if (d2) {
                t2 = t;
            }
            t.a(dVar, (Object) t2);
        }
        return d2;
    }

    public static <E> lc<E> a(lc<E> lcVar) {
        int size = lcVar.size();
        return lcVar.b(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ mb i() {
        a aVar = (a) a(d.NEW_BUILDER, (Object) null);
        aVar.a(this);
        return aVar;
    }

    public final /* synthetic */ mb j() {
        return (a) a(d.NEW_BUILDER, (Object) null);
    }

    public final /* synthetic */ ma k() {
        return (kv) a(d.GET_DEFAULT_INSTANCE, (Object) null);
    }
}
