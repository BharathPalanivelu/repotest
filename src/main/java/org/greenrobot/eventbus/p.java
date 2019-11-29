package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.a.b;

class p {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, List<o>> f34033a = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final a[] f34034e = new a[4];

    /* renamed from: b  reason: collision with root package name */
    private List<b> f34035b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f34036c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f34037d;

    p(List<b> list, boolean z, boolean z2) {
        this.f34035b = list;
        this.f34036c = z;
        this.f34037d = z2;
    }

    /* access modifiers changed from: package-private */
    public List<o> a(Class<?> cls) {
        List<o> list;
        List<o> list2 = f34033a.get(cls);
        if (list2 != null) {
            return list2;
        }
        if (this.f34037d) {
            list = c(cls);
        } else {
            list = b(cls);
        }
        if (!list.isEmpty()) {
            f34033a.put(cls, list);
            return list;
        }
        throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    private List<o> b(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f34043f != null) {
            a2.h = b(a2);
            if (a2.h != null) {
                for (o oVar : a2.h.b()) {
                    if (a2.a(oVar.f34027a, oVar.f34029c)) {
                        a2.f34038a.add(oVar);
                    }
                }
            } else {
                c(a2);
            }
            a2.b();
        }
        return a(a2);
    }

    private List<o> a(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f34038a);
        aVar.a();
        synchronized (f34034e) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                } else if (f34034e[i] == null) {
                    f34034e[i] = aVar;
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    private a a() {
        synchronized (f34034e) {
            for (int i = 0; i < 4; i++) {
                a aVar = f34034e[i];
                if (aVar != null) {
                    f34034e[i] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    private org.greenrobot.eventbus.a.a b(a aVar) {
        if (!(aVar.h == null || aVar.h.c() == null)) {
            org.greenrobot.eventbus.a.a c2 = aVar.h.c();
            if (aVar.f34043f == c2.a()) {
                return c2;
            }
        }
        List<b> list = this.f34035b;
        if (list == null) {
            return null;
        }
        for (b a2 : list) {
            org.greenrobot.eventbus.a.a a3 = a2.a(aVar.f34043f);
            if (a3 != null) {
                return a3;
            }
        }
        return null;
    }

    private List<o> c(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f34043f != null) {
            c(a2);
            a2.b();
        }
        return a(a2);
    }

    private void c(a aVar) {
        Method[] methodArr;
        try {
            methodArr = aVar.f34043f.getDeclaredMethods();
        } catch (Throwable unused) {
            methodArr = aVar.f34043f.getMethods();
            aVar.f34044g = true;
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    m mVar = (m) method.getAnnotation(m.class);
                    if (mVar != null) {
                        Class cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f34038a.add(new o(method, cls, mVar.a(), mVar.c(), mVar.b()));
                        }
                    }
                } else if (this.f34036c && method.isAnnotationPresent(m.class)) {
                    throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f34036c && method.isAnnotationPresent(m.class)) {
                throw new e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final List<o> f34038a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final Map<Class, Object> f34039b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        final Map<String, Class> f34040c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        final StringBuilder f34041d = new StringBuilder(128);

        /* renamed from: e  reason: collision with root package name */
        Class<?> f34042e;

        /* renamed from: f  reason: collision with root package name */
        Class<?> f34043f;

        /* renamed from: g  reason: collision with root package name */
        boolean f34044g;
        org.greenrobot.eventbus.a.a h;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(Class<?> cls) {
            this.f34043f = cls;
            this.f34042e = cls;
            this.f34044g = false;
            this.h = null;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f34038a.clear();
            this.f34039b.clear();
            this.f34040c.clear();
            this.f34041d.setLength(0);
            this.f34042e = null;
            this.f34043f = null;
            this.f34044g = false;
            this.h = null;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Method method, Class<?> cls) {
            Object put = this.f34039b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.f34039b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        private boolean b(Method method, Class<?> cls) {
            this.f34041d.setLength(0);
            this.f34041d.append(method.getName());
            StringBuilder sb = this.f34041d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.f34041d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f34040c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f34040c.put(sb2, put);
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.f34044g) {
                this.f34043f = null;
                return;
            }
            this.f34043f = this.f34043f.getSuperclass();
            String name = this.f34043f.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f34043f = null;
            }
        }
    }
}
