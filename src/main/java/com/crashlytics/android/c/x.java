package com.crashlytics.android.c;

import com.crashlytics.android.c.am;
import io.a.a.a.c;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class x implements am {

    /* renamed from: a  reason: collision with root package name */
    private final File[] f6603a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f6604b = new HashMap(an.f6427a);

    /* renamed from: c  reason: collision with root package name */
    private final String f6605c;

    public x(String str, File[] fileArr) {
        this.f6603a = fileArr;
        this.f6605c = str;
    }

    public String a() {
        return this.f6603a[0].getName();
    }

    public String b() {
        return this.f6605c;
    }

    public File c() {
        return this.f6603a[0];
    }

    public File[] d() {
        return this.f6603a;
    }

    public Map<String, String> e() {
        return Collections.unmodifiableMap(this.f6604b);
    }

    public void f() {
        for (File file : this.f6603a) {
            c.h().a("CrashlyticsCore", "Removing invalid report file at " + file.getPath());
            file.delete();
        }
    }

    public am.a g() {
        return am.a.JAVA;
    }
}
