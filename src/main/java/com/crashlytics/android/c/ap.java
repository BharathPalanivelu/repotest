package com.crashlytics.android.c;

import com.crashlytics.android.c.am;
import io.a.a.a.c;
import io.a.a.a.l;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class ap implements am {

    /* renamed from: a  reason: collision with root package name */
    private final File f6439a;

    /* renamed from: b  reason: collision with root package name */
    private final File[] f6440b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f6441c;

    public ap(File file) {
        this(file, Collections.emptyMap());
    }

    public ap(File file, Map<String, String> map) {
        this.f6439a = file;
        this.f6440b = new File[]{file};
        this.f6441c = new HashMap(map);
        if (this.f6439a.length() == 0) {
            this.f6441c.putAll(an.f6427a);
        }
    }

    public File c() {
        return this.f6439a;
    }

    public File[] d() {
        return this.f6440b;
    }

    public String a() {
        return c().getName();
    }

    public String b() {
        String a2 = a();
        return a2.substring(0, a2.lastIndexOf(46));
    }

    public Map<String, String> e() {
        return Collections.unmodifiableMap(this.f6441c);
    }

    public void f() {
        l h = c.h();
        h.a("CrashlyticsCore", "Removing report at " + this.f6439a.getPath());
        this.f6439a.delete();
    }

    public am.a g() {
        return am.a.JAVA;
    }
}
