package com.c.a.c.b;

import com.c.a.c.a.b;
import com.c.a.c.b.d;
import com.c.a.c.c.n;
import com.c.a.c.h;
import java.io.File;
import java.util.List;

class a implements b.a<Object>, d {

    /* renamed from: a  reason: collision with root package name */
    private List<h> f5676a;

    /* renamed from: b  reason: collision with root package name */
    private final e<?> f5677b;

    /* renamed from: c  reason: collision with root package name */
    private final d.a f5678c;

    /* renamed from: d  reason: collision with root package name */
    private int f5679d;

    /* renamed from: e  reason: collision with root package name */
    private h f5680e;

    /* renamed from: f  reason: collision with root package name */
    private List<n<File, ?>> f5681f;

    /* renamed from: g  reason: collision with root package name */
    private int f5682g;
    private volatile n.a<?> h;
    private File i;

    a(e<?> eVar, d.a aVar) {
        this(eVar.l(), eVar, aVar);
    }

    a(List<h> list, e<?> eVar, d.a aVar) {
        this.f5679d = -1;
        this.f5676a = list;
        this.f5677b = eVar;
        this.f5678c = aVar;
    }

    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f5681f == null || !c()) {
                this.f5679d++;
                if (this.f5679d >= this.f5676a.size()) {
                    return false;
                }
                h hVar = this.f5676a.get(this.f5679d);
                this.i = this.f5677b.b().a(new b(hVar, this.f5677b.f()));
                File file = this.i;
                if (file != null) {
                    this.f5680e = hVar;
                    this.f5681f = this.f5677b.a(file);
                    this.f5682g = 0;
                }
            } else {
                this.h = null;
                while (!z && c()) {
                    List<n<File, ?>> list = this.f5681f;
                    int i2 = this.f5682g;
                    this.f5682g = i2 + 1;
                    this.h = list.get(i2).a(this.i, this.f5677b.g(), this.f5677b.h(), this.f5677b.e());
                    if (this.h != null && this.f5677b.a((Class<?>) this.h.f5951c.d())) {
                        this.h.f5951c.a(this.f5677b.d(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    private boolean c() {
        return this.f5682g < this.f5681f.size();
    }

    public void b() {
        n.a<?> aVar = this.h;
        if (aVar != null) {
            aVar.f5951c.b();
        }
    }

    public void a(Object obj) {
        this.f5678c.a(this.f5680e, obj, this.h.f5951c, com.c.a.c.a.DATA_DISK_CACHE, this.f5680e);
    }

    public void a(Exception exc) {
        this.f5678c.a(this.f5680e, exc, this.h.f5951c, com.c.a.c.a.DATA_DISK_CACHE);
    }
}
