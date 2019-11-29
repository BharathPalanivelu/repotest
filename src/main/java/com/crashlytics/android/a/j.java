package com.crashlytics.android.a;

import io.a.a.a.a.c.a.b;
import io.a.a.a.a.c.a.c;
import io.a.a.a.a.c.a.e;
import io.a.a.a.a.d.f;
import java.io.File;
import java.util.List;

class j implements f {

    /* renamed from: a  reason: collision with root package name */
    private final aa f6339a;

    /* renamed from: b  reason: collision with root package name */
    private final x f6340b;

    public static j a(aa aaVar) {
        return new j(aaVar, new x(new e(new w(new c(1000, 8), 0.1d), new b(5))));
    }

    j(aa aaVar, x xVar) {
        this.f6339a = aaVar;
        this.f6340b = xVar;
    }

    public boolean a(List<File> list) {
        long nanoTime = System.nanoTime();
        if (this.f6340b.a(nanoTime)) {
            if (this.f6339a.a(list)) {
                this.f6340b.a();
                return true;
            }
            this.f6340b.b(nanoTime);
        }
        return false;
    }
}
