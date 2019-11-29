package com.c.a.c.b;

import com.c.a.c.a;
import com.c.a.c.a.b;
import com.c.a.c.b.d;
import com.c.a.c.c.n;
import com.c.a.c.h;
import java.io.File;
import java.util.List;

class t implements b.a<Object>, d {

    /* renamed from: a  reason: collision with root package name */
    private final d.a f5868a;

    /* renamed from: b  reason: collision with root package name */
    private final e<?> f5869b;

    /* renamed from: c  reason: collision with root package name */
    private int f5870c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f5871d = -1;

    /* renamed from: e  reason: collision with root package name */
    private h f5872e;

    /* renamed from: f  reason: collision with root package name */
    private List<n<File, ?>> f5873f;

    /* renamed from: g  reason: collision with root package name */
    private int f5874g;
    private volatile n.a<?> h;
    private File i;
    private u j;

    public t(e<?> eVar, d.a aVar) {
        this.f5869b = eVar;
        this.f5868a = aVar;
    }

    public boolean a() {
        List<h> l = this.f5869b.l();
        boolean z = false;
        if (l.isEmpty()) {
            return false;
        }
        List<Class<?>> i2 = this.f5869b.i();
        while (true) {
            if (this.f5873f == null || !c()) {
                this.f5871d++;
                if (this.f5871d >= i2.size()) {
                    this.f5870c++;
                    if (this.f5870c >= l.size()) {
                        return false;
                    }
                    this.f5871d = 0;
                }
                h hVar = l.get(this.f5870c);
                Class cls = i2.get(this.f5871d);
                this.j = new u(hVar, this.f5869b.f(), this.f5869b.g(), this.f5869b.h(), this.f5869b.c(cls), cls, this.f5869b.e());
                this.i = this.f5869b.b().a(this.j);
                File file = this.i;
                if (file != null) {
                    this.f5872e = hVar;
                    this.f5873f = this.f5869b.a(file);
                    this.f5874g = 0;
                }
            } else {
                this.h = null;
                while (!z && c()) {
                    List<n<File, ?>> list = this.f5873f;
                    int i3 = this.f5874g;
                    this.f5874g = i3 + 1;
                    this.h = list.get(i3).a(this.i, this.f5869b.g(), this.f5869b.h(), this.f5869b.e());
                    if (this.h != null && this.f5869b.a((Class<?>) this.h.f5951c.d())) {
                        this.h.f5951c.a(this.f5869b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    private boolean c() {
        return this.f5874g < this.f5873f.size();
    }

    public void b() {
        n.a<?> aVar = this.h;
        if (aVar != null) {
            aVar.f5951c.b();
        }
    }

    public void a(Object obj) {
        this.f5868a.a(this.f5872e, obj, this.h.f5951c, a.RESOURCE_DISK_CACHE, this.j);
    }

    public void a(Exception exc) {
        this.f5868a.a(this.j, exc, this.h.f5951c, a.RESOURCE_DISK_CACHE);
    }
}
