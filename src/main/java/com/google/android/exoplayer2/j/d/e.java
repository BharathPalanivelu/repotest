package com.google.android.exoplayer2.j.d;

import android.text.Layout;
import com.google.android.exoplayer2.n.a;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private String f10555a;

    /* renamed from: b  reason: collision with root package name */
    private int f10556b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10557c;

    /* renamed from: d  reason: collision with root package name */
    private int f10558d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10559e;

    /* renamed from: f  reason: collision with root package name */
    private int f10560f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f10561g = -1;
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
        return this.f10560f == 1;
    }

    public e a(boolean z) {
        a.b(this.m == null);
        this.f10560f = z ? 1 : 0;
        return this;
    }

    public boolean c() {
        return this.f10561g == 1;
    }

    public e b(boolean z) {
        a.b(this.m == null);
        this.f10561g = z ? 1 : 0;
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
        return this.f10555a;
    }

    public e a(String str) {
        a.b(this.m == null);
        this.f10555a = str;
        return this;
    }

    public int e() {
        if (this.f10557c) {
            return this.f10556b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public e a(int i2) {
        a.b(this.m == null);
        this.f10556b = i2;
        this.f10557c = true;
        return this;
    }

    public boolean f() {
        return this.f10557c;
    }

    public int g() {
        if (this.f10559e) {
            return this.f10558d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public e b(int i2) {
        this.f10558d = i2;
        this.f10559e = true;
        return this;
    }

    public boolean h() {
        return this.f10559e;
    }

    public e a(e eVar) {
        return a(eVar, true);
    }

    private e a(e eVar, boolean z) {
        if (eVar != null) {
            if (!this.f10557c && eVar.f10557c) {
                a(eVar.f10556b);
            }
            if (this.h == -1) {
                this.h = eVar.h;
            }
            if (this.i == -1) {
                this.i = eVar.i;
            }
            if (this.f10555a == null) {
                this.f10555a = eVar.f10555a;
            }
            if (this.f10560f == -1) {
                this.f10560f = eVar.f10560f;
            }
            if (this.f10561g == -1) {
                this.f10561g = eVar.f10561g;
            }
            if (this.n == null) {
                this.n = eVar.n;
            }
            if (this.j == -1) {
                this.j = eVar.j;
                this.k = eVar.k;
            }
            if (z && !this.f10559e && eVar.f10559e) {
                b(eVar.f10558d);
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
