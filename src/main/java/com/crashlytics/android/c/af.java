package com.crashlytics.android.c;

import com.crashlytics.android.c.am;
import io.a.a.a.c;
import java.io.File;
import java.util.Map;

class af implements am {

    /* renamed from: a  reason: collision with root package name */
    private final File f6410a;

    public String a() {
        return null;
    }

    public File c() {
        return null;
    }

    public Map<String, String> e() {
        return null;
    }

    public af(File file) {
        this.f6410a = file;
    }

    public void f() {
        for (File file : d()) {
            c.h().a("CrashlyticsCore", "Removing native report file at " + file.getPath());
            file.delete();
        }
        c.h().a("CrashlyticsCore", "Removing native report directory at " + this.f6410a);
        this.f6410a.delete();
    }

    public String b() {
        return this.f6410a.getName();
    }

    public File[] d() {
        return this.f6410a.listFiles();
    }

    public am.a g() {
        return am.a.NATIVE;
    }
}
