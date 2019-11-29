package com.crashlytics.android;

import com.crashlytics.android.a.b;
import com.crashlytics.android.b.c;
import com.crashlytics.android.c.k;
import io.a.a.a.i;
import io.a.a.a.j;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class a extends i<Void> implements j {

    /* renamed from: a  reason: collision with root package name */
    public final b f6272a;

    /* renamed from: b  reason: collision with root package name */
    public final c f6273b;

    /* renamed from: c  reason: collision with root package name */
    public final k f6274c;

    /* renamed from: d  reason: collision with root package name */
    public final Collection<? extends i> f6275d;

    public String a() {
        return "2.8.0.20";
    }

    public String b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Void f() {
        return null;
    }

    public a() {
        this(new b(), new c(), new k());
    }

    a(b bVar, c cVar, k kVar) {
        this.f6272a = bVar;
        this.f6273b = cVar;
        this.f6274c = kVar;
        this.f6275d = Collections.unmodifiableCollection(Arrays.asList(new i[]{bVar, cVar, kVar}));
    }

    public Collection<? extends i> c() {
        return this.f6275d;
    }

    public static a e() {
        return (a) io.a.a.a.c.a(a.class);
    }

    public static void a(Throwable th) {
        g();
        e().f6274c.a(th);
    }

    public static void a(String str) {
        g();
        e().f6274c.a(str);
    }

    public static void b(String str) {
        g();
        e().f6274c.b(str);
    }

    public static void c(String str) {
        g();
        e().f6274c.c(str);
    }

    public static void d(String str) {
        g();
        e().f6274c.d(str);
    }

    public static void a(String str, String str2) {
        g();
        e().f6274c.a(str, str2);
    }

    public static void a(String str, boolean z) {
        g();
        e().f6274c.a(str, z);
    }

    private static void g() {
        if (e() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
