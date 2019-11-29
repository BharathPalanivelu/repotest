package com.c.a.c.b.b;

import com.c.a.c.b.b.a;
import java.io.File;

public class d implements a.C0099a {

    /* renamed from: a  reason: collision with root package name */
    private final int f5730a;

    /* renamed from: b  reason: collision with root package name */
    private final a f5731b;

    public interface a {
        File a();
    }

    public d(a aVar, int i) {
        this.f5730a = i;
        this.f5731b = aVar;
    }

    public a a() {
        File a2 = this.f5731b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f5730a);
        }
        return null;
    }
}
