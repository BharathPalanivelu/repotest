package com.beetalklib.network.a.a;

import com.beetalklib.network.a.b.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f5488a;

    /* renamed from: b  reason: collision with root package name */
    private int f5489b;

    /* renamed from: c  reason: collision with root package name */
    private b f5490c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5491d = true;

    public a(b bVar) {
        this.f5490c = bVar;
    }

    public boolean a() {
        if (this.f5491d) {
            this.f5489b = 0;
        }
        return this.f5491d;
    }

    public boolean b() {
        return this.f5491d && this.f5490c.a() >= this.f5488a;
    }

    public boolean c() {
        return this.f5489b > this.f5490c.b();
    }

    public void d() {
        this.f5488a++;
        this.f5489b++;
    }

    public void e() {
        this.f5488a = 0;
        this.f5489b = 0;
    }

    public int f() {
        return this.f5490c.a(this.f5489b);
    }

    public void a(boolean z) {
        this.f5491d = z;
    }
}
