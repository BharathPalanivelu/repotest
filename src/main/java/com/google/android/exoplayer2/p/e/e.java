package com.google.android.exoplayer2.p.e;

import android.text.Layout;
import com.google.android.exoplayer2.s.a;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private String f11160a;

    /* renamed from: b  reason: collision with root package name */
    private int f11161b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11162c;

    /* renamed from: d  reason: collision with root package name */
    private int f11163d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11164e;

    /* renamed from: f  reason: collision with root package name */
    private int f11165f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f11166g = -1;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private float k;
    private String l;
    private e m;
    private Layout.Alignment n;

    public int a() {
        if (this.h == -1 && this.i == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = this.h == 1 ? 1 : 0;
        if (this.i == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    public boolean b() {
        return this.f11165f == 1;
    }

    public e a(boolean z) {
        a.b(this.m == null);
        this.f11165f = z ? 1 : 0;
        return this;
    }

    public boolean c() {
        return this.f11166g == 1;
    }

    public e b(boolean z) {
        a.b(this.m == null);
        this.f11166g = z ? 1 : 0;
        return this;
    }

    public e c(boolean z) {
        a.b(this.m == null);
        this.h = z ? 1 : 0;
        return this;
    }

    public e d(boolean z) {
        a.b(this.m == null);
        this.i = z ? 1 : 0;
        return this;
    }

    public String d() {
        return this.f11160a;
    }

    public e a(String str) {
        a.b(this.m == null);
        this.f11160a = str;
        return this;
    }

    public int e() {
        if (this.f11162c) {
            return this.f11161b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public e a(int i2) {
        a.b(this.m == null);
        this.f11161b = i2;
        this.f11162c = true;
        return this;
    }

    public boolean f() {
        return this.f11162c;
    }

    public int g() {
        if (this.f11164e) {
            return this.f11163d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public e b(int i2) {
        this.f11163d = i2;
        this.f11164e = true;
        return this;
    }

    public boolean h() {
        return this.f11164e;
    }

    public e a(e eVar) {
        return a(eVar, true);
    }

    private e a(e eVar, boolean z) {
        if (eVar != null) {
            if (!this.f11162c && eVar.f11162c) {
                a(eVar.f11161b);
            }
            if (this.h == -1) {
                this.h = eVar.h;
            }
            if (this.i == -1) {
                this.i = eVar.i;
            }
            if (this.f11160a == null) {
                this.f11160a = eVar.f11160a;
            }
            if (this.f11165f == -1) {
                this.f11165f = eVar.f11165f;
            }
            if (this.f11166g == -1) {
                this.f11166g = eVar.f11166g;
            }
            if (this.n == null) {
                this.n = eVar.n;
            }
            if (this.j == -1) {
                this.j = eVar.j;
                this.k = eVar.k;
            }
            if (z && !this.f11164e && eVar.f11164e) {
                b(eVar.f11163d);
            }
        }
        return this;
    }

    public e b(String str) {
        this.l = str;
        return this;
    }

    public String i() {
        return this.l;
    }

    public Layout.Alignment j() {
        return this.n;
    }

    public e a(Layout.Alignment alignment) {
        this.n = alignment;
        return this;
    }

    public e a(float f2) {
        this.k = f2;
        return this;
    }

    public e c(int i2) {
        this.j = i2;
        return this;
    }

    public int k() {
        return this.j;
    }

    public float l() {
        return this.k;
    }
}
