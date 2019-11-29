package com.crashlytics.android.c;

import android.content.Context;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.litesuits.orm.db.assit.SQLBuilder;
import io.a.a.a.a.b.g;
import io.a.a.a.a.b.n;
import io.a.a.a.a.b.o;
import io.a.a.a.a.b.p;
import io.a.a.a.a.c.d;
import io.a.a.a.a.c.m;
import io.a.a.a.a.e.e;
import io.a.a.a.a.g.q;
import io.a.a.a.a.g.t;
import io.a.a.a.c;
import io.a.a.a.i;
import io.a.a.a.l;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@d(a = {o.class})
public class k extends i<Void> {

    /* renamed from: a  reason: collision with root package name */
    private final long f6574a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f6575b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public l f6576c;

    /* renamed from: d  reason: collision with root package name */
    private l f6577d;
    private m k;
    private j l;
    private String m;
    private String n;
    private String o;
    private float p;
    private boolean q;
    private final ag r;
    private e s;
    private i t;
    private o u;

    public String a() {
        return "2.5.0.20";
    }

    public String b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public k() {
        this(1.0f, (m) null, (ag) null, false);
    }

    k(float f2, m mVar, ag agVar, boolean z) {
        this(f2, mVar, agVar, z, n.a("Crashlytics Exception Handler"));
    }

    k(float f2, m mVar, ag agVar, boolean z, ExecutorService executorService) {
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = f2;
        this.k = mVar == null ? new b() : mVar;
        this.r = agVar;
        this.q = z;
        this.t = new i(executorService);
        this.f6575b = new ConcurrentHashMap<>();
        this.f6574a = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public boolean h_() {
        return a(super.r());
    }

    /* access modifiers changed from: package-private */
    public boolean a(Context context) {
        Context context2 = context;
        if (this.q) {
            return false;
        }
        String a2 = new g().a(context2);
        if (a2 == null) {
            return false;
        }
        String m2 = io.a.a.a.a.b.i.m(context);
        if (b(m2, io.a.a.a.a.b.i.a(context2, "com.crashlytics.RequireBuildId", true))) {
            try {
                l h = c.h();
                h.c("CrashlyticsCore", "Initializing Crashlytics " + a());
                io.a.a.a.a.f.b bVar = new io.a.a.a.a.f.b(this);
                this.f6577d = new l("crash_marker", bVar);
                this.f6576c = new l("initialization_marker", bVar);
                ah a3 = ah.a(new io.a.a.a.a.f.d(r(), "com.crashlytics.android.core.CrashlyticsCore"), this);
                p pVar = this.r != null ? new p(this.r) : null;
                this.s = new io.a.a.a.a.e.b(c.h());
                this.s.a(pVar);
                p q2 = q();
                a a4 = a.a(context2, q2, a2, m2);
                z zVar = new z(context2, a4.f6400d);
                l h2 = c.h();
                h2.a("CrashlyticsCore", "Installer package name is: " + a4.f6399c);
                j jVar = r1;
                j jVar2 = new j(this, this.t, this.s, q2, a3, bVar, a4, zVar, new o().b(context2));
                this.l = jVar;
                boolean m3 = m();
                x();
                this.l.a(Thread.getDefaultUncaughtExceptionHandler());
                if (!m3 || !io.a.a.a.a.b.i.n(context)) {
                    c.h().a("CrashlyticsCore", "Exception handling initialization successful");
                    return true;
                }
                c.h().a("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                w();
                return false;
            } catch (Exception e2) {
                c.h().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e2);
                this.l = null;
                return false;
            }
        } else {
            throw new m("This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Void f() {
        k();
        this.l.e();
        try {
            t b2 = q.a().b();
            if (b2 == null) {
                c.h().d("CrashlyticsCore", "Received null settings, skipping report submission!");
                l();
                return null;
            } else if (!b2.f33265d.f33237c) {
                c.h().a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                l();
                return null;
            } else {
                n n2 = n();
                if (n2 != null && !this.l.a(n2)) {
                    c.h().a("CrashlyticsCore", "Could not finalize previous NDK sessions.");
                }
                if (!this.l.a(b2.f33263b)) {
                    c.h().a("CrashlyticsCore", "Could not finalize previous sessions.");
                }
                this.l.a(this.p, b2);
                l();
                return null;
            }
        } catch (Exception e2) {
            c.h().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e2);
        } catch (Throwable th) {
            l();
            throw th;
        }
    }

    public static k e() {
        return (k) c.a(k.class);
    }

    public void a(Throwable th) {
        if (this.q || !e("prior to logging exceptions.")) {
            return;
        }
        if (th == null) {
            c.h().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.l.b(Thread.currentThread(), th);
        }
    }

    public void a(String str) {
        a(3, "CrashlyticsCore", str);
    }

    private void a(int i, String str, String str2) {
        if (!this.q && e("prior to logging messages.")) {
            this.l.a(System.currentTimeMillis() - this.f6574a, b(i, str, str2));
        }
    }

    public void b(String str) {
        if (!this.q && e("prior to setting user data.")) {
            this.m = f(str);
            this.l.a(this.m, this.o, this.n);
        }
    }

    public void c(String str) {
        if (!this.q && e("prior to setting user data.")) {
            this.o = f(str);
            this.l.a(this.m, this.o, this.n);
        }
    }

    public void d(String str) {
        if (!this.q && e("prior to setting user data.")) {
            this.n = f(str);
            this.l.a(this.m, this.o, this.n);
        }
    }

    public void a(String str, String str2) {
        String str3;
        if (this.q || !e("prior to setting keys.")) {
            return;
        }
        if (str == null) {
            Context r2 = r();
            if (r2 == null || !io.a.a.a.a.b.i.i(r2)) {
                c.h().e("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", (Throwable) null);
                return;
            }
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        String f2 = f(str);
        if (this.f6575b.size() < 64 || this.f6575b.containsKey(f2)) {
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = f(str2);
            }
            this.f6575b.put(f2, str3);
            this.l.a((Map<String, String>) this.f6575b);
            return;
        }
        c.h().a("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
    }

    public void a(String str, boolean z) {
        a(str, Boolean.toString(z));
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> g() {
        return Collections.unmodifiableMap(this.f6575b);
    }

    /* access modifiers changed from: package-private */
    public String h() {
        if (q().a()) {
            return this.m;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String i() {
        if (q().a()) {
            return this.n;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String j() {
        if (q().a()) {
            return this.o;
        }
        return null;
    }

    private void w() {
        AnonymousClass1 r0 = new io.a.a.a.a.c.g<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                return k.this.f();
            }

            public io.a.a.a.a.c.e b() {
                return io.a.a.a.a.c.e.IMMEDIATE;
            }
        };
        for (io.a.a.a.a.c.l a2 : v()) {
            r0.a(a2);
        }
        Future submit = s().f().submit(r0);
        c.h().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            c.h().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e2);
        } catch (ExecutionException e3) {
            c.h().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e3);
        } catch (TimeoutException e4) {
            c.h().e("CrashlyticsCore", "Crashlytics timed out during initialization.", e4);
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.t.a(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                k.this.f6576c.a();
                c.h().a("CrashlyticsCore", "Initialization marker file created.");
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.t.b(new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                try {
                    boolean c2 = k.this.f6576c.c();
                    l h = c.h();
                    h.a("CrashlyticsCore", "Initialization marker file removed: " + c2);
                    return Boolean.valueOf(c2);
                } catch (Exception e2) {
                    c.h().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e2);
                    return false;
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return ((Boolean) this.t.a(new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(k.this.f6576c.b());
            }
        })).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public n n() {
        o oVar = this.u;
        if (oVar != null) {
            return oVar.a();
        }
        return null;
    }

    private void x() {
        if (Boolean.TRUE.equals((Boolean) this.t.a(new a(this.f6577d)))) {
            try {
                this.k.a();
            } catch (Exception e2) {
                c.h().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f6577d.a();
    }

    private static String b(int i, String str, String str2) {
        return io.a.a.a.a.b.i.b(i) + Constants.URL_PATH_DELIMITER + str + SQLBuilder.BLANK + str2;
    }

    private static boolean e(String str) {
        k e2 = e();
        if (e2 != null && e2.l != null) {
            return true;
        }
        l h = c.h();
        h.e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + str, (Throwable) null);
        return false;
    }

    private static String f(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }

    private static final class a implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private final l f6582a;

        public a(l lVar) {
            this.f6582a = lVar;
        }

        /* renamed from: a */
        public Boolean call() throws Exception {
            if (!this.f6582a.b()) {
                return Boolean.FALSE;
            }
            c.h().a("CrashlyticsCore", "Found previous crash marker.");
            this.f6582a.c();
            return Boolean.TRUE;
        }
    }

    private static final class b implements m {
        public void a() {
        }

        private b() {
        }
    }

    static boolean b(String str, boolean z) {
        if (!z) {
            c.h().a("CrashlyticsCore", "Configured not to require a build ID.");
            return true;
        } else if (!io.a.a.a.a.b.i.d(str)) {
            return true;
        } else {
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".     |  | ");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".   \\ |  | /");
            Log.e("CrashlyticsCore", ".    \\    /");
            Log.e("CrashlyticsCore", ".     \\  /");
            Log.e("CrashlyticsCore", ".      \\/");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".      /\\");
            Log.e("CrashlyticsCore", ".     /  \\");
            Log.e("CrashlyticsCore", ".    /    \\");
            Log.e("CrashlyticsCore", ".   / |  | \\");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".");
            return false;
        }
    }
}
