package io.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.a.a.a.a;
import io.a.a.a.a.b.p;
import io.a.a.a.a.c.d;
import io.a.a.a.a.c.k;
import io.a.a.a.a.c.l;
import io.a.a.a.a.c.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class c {

    /* renamed from: a  reason: collision with root package name */
    static volatile c f33278a;

    /* renamed from: b  reason: collision with root package name */
    static final l f33279b = new b();

    /* renamed from: c  reason: collision with root package name */
    final l f33280c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f33281d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f33282e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<? extends i>, i> f33283f;

    /* renamed from: g  reason: collision with root package name */
    private final ExecutorService f33284g;
    private final Handler h;
    /* access modifiers changed from: private */
    public final f<c> i;
    private final f<?> j;
    private final p k;
    private a l;
    private WeakReference<Activity> m;
    /* access modifiers changed from: private */
    public AtomicBoolean n = new AtomicBoolean(false);

    public String c() {
        return "1.4.1.19";
    }

    public String d() {
        return "io.fabric.sdk.android:fabric";
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f33289a;

        /* renamed from: b  reason: collision with root package name */
        private i[] f33290b;

        /* renamed from: c  reason: collision with root package name */
        private k f33291c;

        /* renamed from: d  reason: collision with root package name */
        private Handler f33292d;

        /* renamed from: e  reason: collision with root package name */
        private l f33293e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f33294f;

        /* renamed from: g  reason: collision with root package name */
        private String f33295g;
        private String h;
        private f<c> i;

        public a(Context context) {
            if (context != null) {
                this.f33289a = context;
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public a a(i... iVarArr) {
            if (this.f33290b == null) {
                this.f33290b = iVarArr;
                return this;
            }
            throw new IllegalStateException("Kits already set.");
        }

        public c a() {
            Map map;
            if (this.f33291c == null) {
                this.f33291c = k.a();
            }
            if (this.f33292d == null) {
                this.f33292d = new Handler(Looper.getMainLooper());
            }
            if (this.f33293e == null) {
                if (this.f33294f) {
                    this.f33293e = new b(3);
                } else {
                    this.f33293e = new b();
                }
            }
            if (this.h == null) {
                this.h = this.f33289a.getPackageName();
            }
            if (this.i == null) {
                this.i = f.f33299d;
            }
            i[] iVarArr = this.f33290b;
            if (iVarArr == null) {
                map = new HashMap();
            } else {
                map = c.b((Collection<? extends i>) Arrays.asList(iVarArr));
            }
            Map map2 = map;
            Context applicationContext = this.f33289a.getApplicationContext();
            return new c(applicationContext, map2, this.f33291c, this.f33292d, this.f33293e, this.f33294f, this.i, new p(applicationContext, this.h, this.f33295g, map2.values()), c.d(this.f33289a));
        }
    }

    static c a() {
        if (f33278a != null) {
            return f33278a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    c(Context context, Map<Class<? extends i>, i> map, k kVar, Handler handler, l lVar, boolean z, f fVar, p pVar, Activity activity) {
        this.f33282e = context;
        this.f33283f = map;
        this.f33284g = kVar;
        this.h = handler;
        this.f33280c = lVar;
        this.f33281d = z;
        this.i = fVar;
        this.j = a(map.size());
        this.k = pVar;
        a(activity);
    }

    public static c a(Context context, i... iVarArr) {
        if (f33278a == null) {
            synchronized (c.class) {
                if (f33278a == null) {
                    c(new a(context).a(iVarArr).a());
                }
            }
        }
        return f33278a;
    }

    private static void c(c cVar) {
        f33278a = cVar;
        cVar.k();
    }

    public c a(Activity activity) {
        this.m = new WeakReference<>(activity);
        return this;
    }

    public Activity b() {
        WeakReference<Activity> weakReference = this.m;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    private void k() {
        this.l = new a(this.f33282e);
        this.l.a(new a.b() {
            public void a(Activity activity, Bundle bundle) {
                c.this.a(activity);
            }

            public void a(Activity activity) {
                c.this.a(activity);
            }

            public void b(Activity activity) {
                c.this.a(activity);
            }
        });
        a(this.f33282e);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        StringBuilder sb;
        Future<Map<String, k>> b2 = b(context);
        Collection<i> g2 = g();
        m mVar = new m(b2, g2);
        ArrayList<i> arrayList = new ArrayList<>(g2);
        Collections.sort(arrayList);
        mVar.a(context, this, f.f33299d, this.k);
        for (i a2 : arrayList) {
            a2.a(context, this, this.j, this.k);
        }
        mVar.p();
        if (h().a("Fabric", 3)) {
            sb = new StringBuilder("Initializing ");
            sb.append(d());
            sb.append(" [Version: ");
            sb.append(c());
            sb.append("], with the following kits:\n");
        } else {
            sb = null;
        }
        for (i iVar : arrayList) {
            iVar.f33302f.c((l) mVar.f33302f);
            a(this.f33283f, iVar);
            iVar.p();
            if (sb != null) {
                sb.append(iVar.b());
                sb.append(" [Version: ");
                sb.append(iVar.a());
                sb.append("]\n");
            }
        }
        if (sb != null) {
            h().a("Fabric", sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Map<Class<? extends i>, i> map, i iVar) {
        d dVar = iVar.j;
        if (dVar != null) {
            for (Class cls : dVar.a()) {
                if (cls.isInterface()) {
                    for (i next : map.values()) {
                        if (cls.isAssignableFrom(next.getClass())) {
                            iVar.f33302f.c((l) next.f33302f);
                        }
                    }
                } else if (map.get(cls) != null) {
                    iVar.f33302f.c((l) map.get(cls).f33302f);
                } else {
                    throw new m("Referenced Kit was null, does the kit exist?");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static Activity d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public a e() {
        return this.l;
    }

    public ExecutorService f() {
        return this.f33284g;
    }

    public Collection<i> g() {
        return this.f33283f.values();
    }

    public static <T extends i> T a(Class<T> cls) {
        return (i) a().f33283f.get(cls);
    }

    public static l h() {
        if (f33278a == null) {
            return f33279b;
        }
        return f33278a.f33280c;
    }

    public static boolean i() {
        if (f33278a == null) {
            return false;
        }
        return f33278a.f33281d;
    }

    public static boolean j() {
        return f33278a != null && f33278a.n.get();
    }

    /* access modifiers changed from: private */
    public static Map<Class<? extends i>, i> b(Collection<? extends i> collection) {
        HashMap hashMap = new HashMap(collection.size());
        a((Map<Class<? extends i>, i>) hashMap, collection);
        return hashMap;
    }

    private static void a(Map<Class<? extends i>, i> map, Collection<? extends i> collection) {
        for (i iVar : collection) {
            map.put(iVar.getClass(), iVar);
            if (iVar instanceof j) {
                a(map, ((j) iVar).c());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public f<?> a(final int i2) {
        return new f() {

            /* renamed from: a  reason: collision with root package name */
            final CountDownLatch f33286a = new CountDownLatch(i2);

            public void a(Object obj) {
                this.f33286a.countDown();
                if (this.f33286a.getCount() == 0) {
                    c.this.n.set(true);
                    c.this.i.a(c.this);
                }
            }

            public void a(Exception exc) {
                c.this.i.a(exc);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Future<Map<String, k>> b(Context context) {
        return f().submit(new e(context.getPackageCodePath()));
    }
}
