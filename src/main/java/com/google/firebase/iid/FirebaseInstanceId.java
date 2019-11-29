package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.a.d;
import com.google.firebase.b;
import com.google.firebase.c.g;
import com.tencent.imsdk.BaseConstants;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirebaseInstanceId {

    /* renamed from: a  reason: collision with root package name */
    private static final long f14074a = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: b  reason: collision with root package name */
    private static y f14075b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    private static ScheduledExecutorService f14076c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f14077d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final b f14078e;

    /* renamed from: f  reason: collision with root package name */
    private final q f14079f;

    /* renamed from: g  reason: collision with root package name */
    private b f14080g;
    private final t h;
    private final ac i;
    private boolean j;
    private final a k;

    public static FirebaseInstanceId getInstance() {
        return getInstance(b.d());
    }

    @Keep
    public static FirebaseInstanceId getInstance(b bVar) {
        return (FirebaseInstanceId) bVar.a(FirebaseInstanceId.class);
    }

    FirebaseInstanceId(b bVar, d dVar, g gVar) {
        this(bVar, new q(bVar.a()), ak.b(), ak.b(), dVar, gVar);
    }

    private class a {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f14082b = c();

        /* renamed from: c  reason: collision with root package name */
        private final d f14083c;

        /* renamed from: d  reason: collision with root package name */
        private com.google.firebase.a.b<com.google.firebase.a> f14084d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f14085e = b();

        a(d dVar) {
            this.f14083c = dVar;
            if (this.f14085e == null && this.f14082b) {
                this.f14084d = new as(this);
                dVar.a(com.google.firebase.a.class, this.f14084d);
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean a() {
            if (this.f14085e == null) {
                return this.f14082b && FirebaseInstanceId.this.f14078e.e();
            }
            return this.f14085e.booleanValue();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void a(boolean z) {
            if (this.f14084d != null) {
                this.f14083c.b(com.google.firebase.a.class, this.f14084d);
                this.f14084d = null;
            }
            SharedPreferences.Editor edit = FirebaseInstanceId.this.f14078e.a().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseInstanceId.this.i();
            }
            this.f14085e = Boolean.valueOf(z);
        }

        private final Boolean b() {
            Context a2 = FirebaseInstanceId.this.f14078e.a();
            SharedPreferences sharedPreferences = a2.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = a2.getPackageManager();
                if (packageManager == null) {
                    return null;
                }
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a2.getPackageName(), 128);
                if (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private final boolean c() {
            try {
                Class.forName("com.google.firebase.messaging.a");
                return true;
            } catch (ClassNotFoundException unused) {
                Context a2 = FirebaseInstanceId.this.f14078e.a();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(a2.getPackageName());
                ResolveInfo resolveService = a2.getPackageManager().resolveService(intent, 0);
                if (resolveService == null || resolveService.serviceInfo == null) {
                    return false;
                }
                return true;
            }
        }
    }

    private FirebaseInstanceId(b bVar, q qVar, Executor executor, Executor executor2, d dVar, g gVar) {
        this.j = false;
        if (q.a(bVar) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f14075b == null) {
                    f14075b = new y(bVar.a());
                }
            }
            this.f14078e = bVar;
            this.f14079f = qVar;
            if (this.f14080g == null) {
                b bVar2 = (b) bVar.a(b.class);
                if (bVar2 == null || !bVar2.a()) {
                    this.f14080g = new au(bVar, qVar, executor, gVar);
                } else {
                    this.f14080g = bVar2;
                }
            }
            this.f14080g = this.f14080g;
            this.f14077d = executor2;
            this.i = new ac(f14075b);
            this.k = new a(dVar);
            this.h = new t(executor);
            if (this.k.a()) {
                i();
                return;
            }
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    /* access modifiers changed from: private */
    public final void i() {
        ab b2 = b();
        if (h() || a(b2) || this.i.a()) {
            j();
        }
    }

    /* access modifiers changed from: package-private */
    public final b a() {
        return this.f14078e;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(boolean z) {
        this.j = z;
    }

    private final synchronized void j() {
        if (!this.j) {
            a(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(long j2) {
        a((Runnable) new aa(this, this.f14079f, this.i, Math.min(Math.max(30, j2 << 1), f14074a)), j2);
        this.j = true;
    }

    static void a(Runnable runnable, long j2) {
        synchronized (FirebaseInstanceId.class) {
            if (f14076c == null) {
                f14076c = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            f14076c.schedule(runnable, j2, TimeUnit.SECONDS);
        }
    }

    public String getId() {
        i();
        return k();
    }

    private static String k() {
        return q.a(f14075b.b("").a());
    }

    public long getCreationTime() {
        return f14075b.b("").b();
    }

    public Task<a> getInstanceId() {
        return a(q.a(this.f14078e), "*");
    }

    private final Task<a> a(String str, String str2) {
        return Tasks.forResult(null).continueWithTask(this.f14077d, new aq(this, str, c(str2)));
    }

    public void deleteInstanceId() throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            a(this.f14080g.a(k()));
            e();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    @Deprecated
    public String getToken() {
        ab b2 = b();
        if (this.f14080g.b() || a(b2)) {
            j();
        }
        return ab.a(b2);
    }

    public String getToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((a) a(a(str, str2))).a();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* access modifiers changed from: package-private */
    public final ab b() {
        return b(q.a(this.f14078e), "*");
    }

    @VisibleForTesting
    private static ab b(String str, String str2) {
        return f14075b.a("", str, str2);
    }

    /* access modifiers changed from: package-private */
    public final String c() throws IOException {
        return getToken(q.a(this.f14078e), "*");
    }

    private final <T> T a(Task<T> task) throws IOException {
        try {
            return Tasks.await(task, BaseConstants.DEFAULT_MSG_TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    e();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    public void deleteToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String c2 = c(str2);
            a(this.f14080g.b(k(), ab.a(b(str, c2)), str, c2));
            f14075b.b("", str, c2);
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    public final synchronized Task<Void> zza(String str) {
        Task<Void> a2;
        a2 = this.i.a(str);
        j();
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) throws IOException {
        ab b2 = b();
        if (!a(b2)) {
            a(this.f14080g.a(k(), b2.f14093a, str));
            return;
        }
        throw new IOException("token not available");
    }

    /* access modifiers changed from: package-private */
    public final void b(String str) throws IOException {
        ab b2 = b();
        if (!a(b2)) {
            a(this.f14080g.b(k(), b2.f14093a, str));
            return;
        }
        throw new IOException("token not available");
    }

    static boolean d() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void e() {
        f14075b.b();
        if (this.k.a()) {
            j();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return this.f14080g.a();
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        f14075b.c("");
        j();
    }

    @VisibleForTesting
    public final boolean zzq() {
        return this.k.a();
    }

    @VisibleForTesting
    public final void zzb(boolean z) {
        this.k.a(z);
    }

    private static String c(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ab abVar) {
        return abVar == null || abVar.b(this.f14079f.b());
    }

    /* access modifiers changed from: package-private */
    public final boolean h() {
        return this.f14080g.b();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task a(String str, String str2, Task task) throws Exception {
        String k2 = k();
        ab b2 = b(str, str2);
        if (!this.f14080g.b() && !a(b2)) {
            return Tasks.forResult(new az(k2, b2.f14093a));
        }
        return this.h.a(str, str2, new ap(this, k2, ab.a(b2), str, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task a(String str, String str2, String str3, String str4) {
        return this.f14080g.a(str, str2, str3, str4).onSuccessTask(this.f14077d, new ar(this, str3, str4, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task b(String str, String str2, String str3, String str4) throws Exception {
        f14075b.a("", str, str2, str4, this.f14079f.b());
        return Tasks.forResult(new az(str3, str4));
    }
}
