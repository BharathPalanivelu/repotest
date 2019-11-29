package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.f;
import com.google.firebase.components.h;
import com.google.firebase.components.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class b {

    /* renamed from: a  reason: collision with root package name */
    static final Map<String, b> f6824a = new androidx.b.a();

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f6825b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f6826c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f6827d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});

    /* renamed from: e  reason: collision with root package name */
    private static final List<String> f6828e = Arrays.asList(new String[0]);

    /* renamed from: f  reason: collision with root package name */
    private static final Set<String> f6829f = Collections.emptySet();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Object f6830g = new Object();
    private static final Executor h = new c();
    private final Context i;
    private final String j;
    private final d k;
    private final i l;
    private final SharedPreferences m;
    private final com.google.firebase.a.c n;
    /* access modifiers changed from: private */
    public final AtomicBoolean o = new AtomicBoolean(false);
    private final AtomicBoolean p = new AtomicBoolean();
    private final AtomicBoolean q;
    private final List<a> r = new CopyOnWriteArrayList();
    private final List<Object> s = new CopyOnWriteArrayList();

    @KeepForSdk
    public interface a {
        @KeepForSdk
        void a(boolean z);
    }

    public Context a() {
        i();
        return this.i;
    }

    public String b() {
        i();
        return this.j;
    }

    public d c() {
        i();
        return this.k;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.j.equals(((b) obj).b());
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.j).add("options", this.k).toString();
    }

    public static b d() {
        b bVar;
        synchronized (f6830g) {
            bVar = f6824a.get("[DEFAULT]");
            if (bVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return bVar;
    }

    public static b a(Context context) {
        synchronized (f6830g) {
            if (f6824a.containsKey("[DEFAULT]")) {
                b d2 = d();
                return d2;
            }
            d a2 = d.a(context);
            if (a2 == null) {
                Log.d("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            b a3 = a(context, a2);
            return a3;
        }
    }

    public static b a(Context context, d dVar) {
        return a(context, dVar, "[DEFAULT]");
    }

    public static b a(Context context, d dVar, String str) {
        b bVar;
        C0118b.b(context);
        String b2 = b(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f6830g) {
            boolean z = !f6824a.containsKey(b2);
            Preconditions.checkState(z, "FirebaseApp name " + b2 + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            bVar = new b(context, b2, dVar);
            f6824a.put(b2, bVar);
        }
        bVar.j();
        return bVar;
    }

    @KeepForSdk
    public <T> T a(Class<T> cls) {
        i();
        return this.l.a((Class) cls);
    }

    @KeepForSdk
    public boolean e() {
        i();
        return this.q.get();
    }

    protected b(Context context, String str, d dVar) {
        this.i = (Context) Preconditions.checkNotNull(context);
        this.j = Preconditions.checkNotEmpty(str);
        this.k = (d) Preconditions.checkNotNull(dVar);
        this.m = context.getSharedPreferences(a(str), 0);
        this.q = new AtomicBoolean(h());
        List<h> a2 = f.a(context).a();
        this.l = new i(h, a2, com.google.firebase.components.b.a(context, Context.class, new Class[0]), com.google.firebase.components.b.a(this, b.class, new Class[0]), com.google.firebase.components.b.a(dVar, d.class, new Class[0]), com.google.firebase.c.f.a("fire-android", ""), com.google.firebase.c.f.a("fire-core", "17.0.0"), com.google.firebase.c.b.b());
        this.n = (com.google.firebase.a.c) this.l.a(com.google.firebase.a.c.class);
    }

    private static String a(String str) {
        return "com.google.firebase.common.prefs:" + str;
    }

    private boolean h() {
        if (this.m.contains("firebase_data_collection_default_enabled")) {
            return this.m.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.i.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.i.getPackageName(), 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled"))) {
                    return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }

    private void i() {
        Preconditions.checkState(!this.p.get(), "FirebaseApp was deleted");
    }

    @KeepForSdk
    public boolean f() {
        return "[DEFAULT]".equals(b());
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (a a2 : this.r) {
            a2.a(z);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        boolean c2 = androidx.core.content.b.c(this.i);
        if (c2) {
            d.b(this.i);
        } else {
            this.l.a(f());
        }
        a(b.class, this, f6825b, c2);
        if (f()) {
            a(b.class, this, f6826c, c2);
            a(Context.class, this.i, f6827d, c2);
        }
    }

    private static String b(String str) {
        return str.trim();
    }

    private <T> void a(Class<T> cls, T t, Iterable<String> iterable, boolean z) {
        for (String next : iterable) {
            if (z) {
                try {
                    if (!f6828e.contains(next)) {
                    }
                } catch (ClassNotFoundException unused) {
                    if (!f6829f.contains(next)) {
                        Log.d("FirebaseApp", next + " is not linked. Skipping initialization.");
                    } else {
                        throw new IllegalStateException(next + " is missing, but is required. Check if it has been removed by Proguard.");
                    }
                } catch (NoSuchMethodException unused2) {
                    throw new IllegalStateException(next + "#getInstance has been removed by Proguard. Add keep rule to prevent it.");
                } catch (InvocationTargetException e2) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e2);
                } catch (IllegalAccessException e3) {
                    Log.wtf("FirebaseApp", "Failed to initialize " + next, e3);
                }
            }
            Method method = Class.forName(next).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke((Object) null, new Object[]{t});
            }
        }
    }

    @TargetApi(24)
    private static class d extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<d> f6833a = new AtomicReference<>();

        /* renamed from: b  reason: collision with root package name */
        private final Context f6834b;

        public d(Context context) {
            this.f6834b = context;
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (f6833a.get() == null) {
                d dVar = new d(context);
                if (f6833a.compareAndSet((Object) null, dVar)) {
                    context.registerReceiver(dVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (b.f6830g) {
                for (b a2 : b.f6824a.values()) {
                    a2.j();
                }
            }
            a();
        }

        public void a() {
            this.f6834b.unregisterReceiver(this);
        }
    }

    @TargetApi(14)
    /* renamed from: com.google.firebase.b$b  reason: collision with other inner class name */
    private static class C0118b implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<C0118b> f6831a = new AtomicReference<>();

        private C0118b() {
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f6831a.get() == null) {
                    C0118b bVar = new C0118b();
                    if (f6831a.compareAndSet((Object) null, bVar)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(bVar);
                    }
                }
            }
        }

        public void onBackgroundStateChanged(boolean z) {
            synchronized (b.f6830g) {
                Iterator it = new ArrayList(b.f6824a.values()).iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar.o.get()) {
                        bVar.a(z);
                    }
                }
            }
        }
    }

    private static class c implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private static final Handler f6832a = new Handler(Looper.getMainLooper());

        private c() {
        }

        public void execute(Runnable runnable) {
            f6832a.post(runnable);
        }
    }
}
