package f;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import f.c;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

class k {

    /* renamed from: a  reason: collision with root package name */
    private static final k f32958a = c();

    /* access modifiers changed from: package-private */
    public boolean a(Method method) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public Executor b() {
        return null;
    }

    k() {
    }

    static k a() {
        return f32958a;
    }

    private static k c() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new b();
        } catch (ClassNotFoundException unused2) {
            return new k();
        }
    }

    /* access modifiers changed from: package-private */
    public c.a a(Executor executor) {
        if (executor != null) {
            return new g(executor);
        }
        return f.f32904a;
    }

    /* access modifiers changed from: package-private */
    public Object a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    @IgnoreJRERequirement
    static class b extends k {
        b() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(Method method) {
            return method.isDefault();
        }

        /* access modifiers changed from: package-private */
        public Object a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor<MethodHandles.Lookup> declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[]{cls, -1}).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    static class a extends k {
        a() {
        }

        public Executor b() {
            return new C0507a();
        }

        /* access modifiers changed from: package-private */
        public c.a a(Executor executor) {
            if (executor != null) {
                return new g(executor);
            }
            throw new AssertionError();
        }

        /* renamed from: f.k$a$a  reason: collision with other inner class name */
        static class C0507a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            private final Handler f32959a = new Handler(Looper.getMainLooper());

            C0507a() {
            }

            public void execute(Runnable runnable) {
                this.f32959a.post(runnable);
            }
        }
    }
}
