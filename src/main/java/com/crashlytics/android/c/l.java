package com.crashlytics.android.c;

import io.a.a.a.a.f.a;
import io.a.a.a.c;
import java.io.File;
import java.io.IOException;

class l {

    /* renamed from: a  reason: collision with root package name */
    private final String f6583a;

    /* renamed from: b  reason: collision with root package name */
    private final a f6584b;

    public l(String str, a aVar) {
        this.f6583a = str;
        this.f6584b = aVar;
    }

    public boolean a() {
        try {
            return d().createNewFile();
        } catch (IOException e2) {
            io.a.a.a.l h = c.h();
            h.e("CrashlyticsCore", "Error creating marker: " + this.f6583a, e2);
            return false;
        }
    }

    public boolean b() {
        return d().exists();
    }

    public boolean c() {
        return d().delete();
    }

    private File d() {
        return new File(this.f6584b.a(), this.f6583a);
    }
}
