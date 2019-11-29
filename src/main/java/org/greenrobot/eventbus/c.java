package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f33986a = "EventBus";

    /* renamed from: b  reason: collision with root package name */
    static volatile c f33987b;

    /* renamed from: c  reason: collision with root package name */
    private static final d f33988c = new d();

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f33989d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<q>> f33990e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f33991f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Class<?>, Object> f33992g;
    private final ThreadLocal<a> h;
    private final h i;
    private final l j;
    private final b k;
    private final a l;
    private final p m;
    private final ExecutorService n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final boolean t;
    private final int u;
    private final g v;

    public static c a() {
        if (f33987b == null) {
            synchronized (c.class) {
                if (f33987b == null) {
                    f33987b = new c();
                }
            }
        }
        return f33987b;
    }

    public c() {
        this(f33988c);
    }

    c(d dVar) {
        this.h = new ThreadLocal<a>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public a initialValue() {
                return new a();
            }
        };
        this.v = dVar.a();
        this.f33990e = new HashMap();
        this.f33991f = new HashMap();
        this.f33992g = new ConcurrentHashMap();
        this.i = dVar.b();
        h hVar = this.i;
        this.j = hVar != null ? hVar.a(this) : null;
        this.k = new b(this);
        this.l = new a(this);
        this.u = dVar.j != null ? dVar.j.size() : 0;
        this.m = new p(dVar.j, dVar.h, dVar.f34007g);
        this.p = dVar.f34001a;
        this.q = dVar.f34002b;
        this.r = dVar.f34003c;
        this.s = dVar.f34004d;
        this.o = dVar.f34005e;
        this.t = dVar.f34006f;
        this.n = dVar.i;
    }

    public void a(Object obj) {
        List<o> a2 = this.m.a(obj.getClass());
        synchronized (this) {
            for (o a3 : a2) {
                a(obj, a3);
            }
        }
    }

    private void a(Object obj, o oVar) {
        Class<?> cls = oVar.f34029c;
        q qVar = new q(obj, oVar);
        CopyOnWriteArrayList copyOnWriteArrayList = this.f33990e.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f33990e.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            } else if (i2 == size || oVar.f34030d > ((q) copyOnWriteArrayList.get(i2)).f34046b.f34030d) {
                copyOnWriteArrayList.add(i2, qVar);
            } else {
                i2++;
            }
        }
        copyOnWriteArrayList.add(i2, qVar);
        List list = this.f33991f.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f33991f.put(obj, list);
        }
        list.add(cls);
        if (!oVar.f34031e) {
            return;
        }
        if (this.t) {
            for (Map.Entry next : this.f33992g.entrySet()) {
                if (cls.isAssignableFrom((Class) next.getKey())) {
                    b(qVar, next.getValue());
                }
            }
            return;
        }
        b(qVar, this.f33992g.get(cls));
    }

    private void b(q qVar, Object obj) {
        if (obj != null) {
            a(qVar, obj, d());
        }
    }

    private boolean d() {
        h hVar = this.i;
        if (hVar != null) {
            return hVar.a();
        }
        return true;
    }

    private void a(Object obj, Class<?> cls) {
        List list = this.f33990e.get(cls);
        if (list != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = (q) list.get(i2);
                if (qVar.f34045a == obj) {
                    qVar.f34047c = false;
                    list.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    public synchronized void b(Object obj) {
        List<Class> list = this.f33991f.get(obj);
        if (list != null) {
            for (Class a2 : list) {
                a(obj, (Class<?>) a2);
            }
            this.f33991f.remove(obj);
        } else {
            g gVar = this.v;
            Level level = Level.WARNING;
            gVar.a(level, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public void c(Object obj) {
        a aVar = this.h.get();
        List<Object> list = aVar.f33995a;
        list.add(obj);
        if (!aVar.f33996b) {
            aVar.f33997c = d();
            aVar.f33996b = true;
            if (!aVar.f34000f) {
                while (!list.isEmpty()) {
                    try {
                        a(list.remove(0), aVar);
                    } finally {
                        aVar.f33996b = false;
                        aVar.f33997c = false;
                    }
                }
                return;
            }
            throw new e("Internal error. Abort state was not reset");
        }
    }

    private void a(Object obj, a aVar) throws Error {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.t) {
            List<Class<?>> a2 = a(cls);
            int size = a2.size();
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= a(obj, aVar, a2.get(i2));
            }
        } else {
            z = a(obj, aVar, cls);
        }
        if (!z) {
            if (this.q) {
                g gVar = this.v;
                Level level = Level.FINE;
                gVar.a(level, "No subscribers registered for event " + cls);
            }
            if (this.s && cls != i.class && cls != n.class) {
                c(new i(this, obj));
            }
        }
    }

    private boolean a(Object obj, a aVar, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f33990e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            aVar.f33999e = obj;
            aVar.f33998d = qVar;
            try {
                a(qVar, obj, aVar.f33997c);
                if (aVar.f34000f) {
                    return true;
                }
            } finally {
                aVar.f33999e = null;
                aVar.f33998d = null;
                aVar.f34000f = false;
            }
        }
        return true;
    }

    /* renamed from: org.greenrobot.eventbus.c$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33994a = new int[ThreadMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                org.greenrobot.eventbus.ThreadMode[] r0 = org.greenrobot.eventbus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33994a = r0
                int[] r0 = f33994a     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.POSTING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f33994a     // Catch:{ NoSuchFieldError -> 0x001f }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.MAIN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f33994a     // Catch:{ NoSuchFieldError -> 0x002a }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.MAIN_ORDERED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f33994a     // Catch:{ NoSuchFieldError -> 0x0035 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f33994a     // Catch:{ NoSuchFieldError -> 0x0040 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.ASYNC     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.c.AnonymousClass2.<clinit>():void");
        }
    }

    private void a(q qVar, Object obj, boolean z) {
        int i2 = AnonymousClass2.f33994a[qVar.f34046b.f34028b.ordinal()];
        if (i2 == 1) {
            a(qVar, obj);
        } else if (i2 != 2) {
            if (i2 == 3) {
                l lVar = this.j;
                if (lVar != null) {
                    lVar.a(qVar, obj);
                } else {
                    a(qVar, obj);
                }
            } else if (i2 != 4) {
                if (i2 == 5) {
                    this.l.a(qVar, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + qVar.f34046b.f34028b);
            } else if (z) {
                this.k.a(qVar, obj);
            } else {
                a(qVar, obj);
            }
        } else if (z) {
            a(qVar, obj);
        } else {
            this.j.a(qVar, obj);
        }
    }

    private static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f33989d) {
            list = f33989d.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, (Class<?>[]) cls2.getInterfaces());
                }
                f33989d.put(cls, list);
            }
        }
        return list;
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(j jVar) {
        Object obj = jVar.f34018a;
        q qVar = jVar.f34019b;
        j.a(jVar);
        if (qVar.f34047c) {
            a(qVar, obj);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(q qVar, Object obj) {
        try {
            qVar.f34046b.f34027a.invoke(qVar.f34045a, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            a(qVar, obj, e2.getCause());
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    private void a(q qVar, Object obj, Throwable th) {
        if (obj instanceof n) {
            if (this.p) {
                g gVar = this.v;
                Level level = Level.SEVERE;
                gVar.a(level, "SubscriberExceptionEvent subscriber " + qVar.f34045a.getClass() + " threw an exception", th);
                n nVar = (n) obj;
                g gVar2 = this.v;
                Level level2 = Level.SEVERE;
                gVar2.a(level2, "Initial event " + nVar.f34025c + " caused exception in " + nVar.f34026d, nVar.f34024b);
            }
        } else if (!this.o) {
            if (this.p) {
                g gVar3 = this.v;
                Level level3 = Level.SEVERE;
                gVar3.a(level3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + qVar.f34045a.getClass(), th);
            }
            if (this.r) {
                c(new n(this, th, obj, qVar.f34045a));
            }
        } else {
            throw new e("Invoking subscriber failed", th);
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<Object> f33995a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        boolean f33996b;

        /* renamed from: c  reason: collision with root package name */
        boolean f33997c;

        /* renamed from: d  reason: collision with root package name */
        q f33998d;

        /* renamed from: e  reason: collision with root package name */
        Object f33999e;

        /* renamed from: f  reason: collision with root package name */
        boolean f34000f;

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    public ExecutorService b() {
        return this.n;
    }

    public g c() {
        return this.v;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.u + ", eventInheritance=" + this.t + "]";
    }
}
