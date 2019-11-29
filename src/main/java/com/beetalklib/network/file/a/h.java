package com.beetalklib.network.file.a;

import com.beetalklib.network.d.c;
import com.beetalklib.network.d.f;
import com.beetalklib.network.e.b;

public class h implements c {

    /* renamed from: a  reason: collision with root package name */
    private com.beetalklib.network.d.h f5560a;

    /* renamed from: b  reason: collision with root package name */
    private b f5561b;

    /* renamed from: c  reason: collision with root package name */
    private c f5562c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5563d = true;

    public h(String str, int i) {
        this.f5560a = new com.beetalklib.network.d.h(str, i);
    }

    /* access modifiers changed from: protected */
    public boolean a(String str, int i) {
        com.beetalklib.network.d.h hVar = this.f5560a;
        return hVar != null && hVar.a(str, i);
    }

    public synchronized com.beetalklib.network.d.b a(c cVar) {
        if (this.f5561b == null || !this.f5561b.isAlive()) {
            this.f5561b = new b(this.f5560a, this);
            this.f5561b.start();
        }
        this.f5562c = cVar;
        return this.f5561b.c();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f5562c = null;
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return this.f5562c != null;
    }

    public void a(int i, int i2) {
        c cVar = this.f5562c;
        if (cVar != null) {
            cVar.a(i, i2);
        }
    }

    public void a(f fVar) {
        c cVar = this.f5562c;
        if (cVar != null) {
            cVar.a(fVar);
        }
    }

    public void b(f fVar) {
        c cVar = this.f5562c;
        if (cVar != null) {
            cVar.b(fVar);
        }
    }

    public void a(int i) {
        c cVar = this.f5562c;
        if (cVar != null) {
            cVar.a(i);
        }
        if (!this.f5563d) {
            this.f5561b.interrupt();
            this.f5561b.d();
            this.f5560a = null;
        }
    }

    public void b(int i) {
        c cVar = this.f5562c;
        if (cVar != null) {
            cVar.b(i);
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.f5563d) {
            this.f5563d = false;
            if (this.f5561b != null) {
                if (!this.f5560a.d()) {
                    this.f5561b.interrupt();
                    this.f5561b.d();
                    return;
                }
                b bVar = this.f5561b;
                if (bVar != null) {
                    bVar.c().b();
                }
            }
        }
    }

    public c d() {
        return this.f5562c;
    }
}
