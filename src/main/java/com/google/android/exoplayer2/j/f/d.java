package com.google.android.exoplayer2.j.f;

import android.text.Layout;
import com.google.android.exoplayer2.n.t;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private String f10584a;

    /* renamed from: b  reason: collision with root package name */
    private String f10585b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f10586c;

    /* renamed from: d  reason: collision with root package name */
    private String f10587d;

    /* renamed from: e  reason: collision with root package name */
    private String f10588e;

    /* renamed from: f  reason: collision with root package name */
    private int f10589f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10590g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private float o;
    private Layout.Alignment p;

    public d() {
        a();
    }

    public void a() {
        this.f10584a = "";
        this.f10585b = "";
        this.f10586c = Collections.emptyList();
        this.f10587d = "";
        this.f10588e = null;
        this.f10590g = false;
        this.i = false;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.p = null;
    }

    public void a(String str) {
        this.f10584a = str;
    }

    public void b(String str) {
        this.f10585b = str;
    }

    public void a(String[] strArr) {
        this.f10586c = Arrays.asList(strArr);
    }

    public void c(String str) {
        this.f10587d = str;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.f10584a.isEmpty() && this.f10585b.isEmpty() && this.f10586c.isEmpty() && this.f10587d.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int a2 = a(a(a(0, this.f10584a, str, 1073741824), this.f10585b, str2, 2), this.f10587d, str3, 4);
        if (a2 == -1 || !Arrays.asList(strArr).containsAll(this.f10586c)) {
            return 0;
        }
        return a2 + (this.f10586c.size() * 4);
    }

    public int b() {
        if (this.l == -1 && this.m == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = this.l == 1 ? 1 : 0;
        if (this.m == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    public boolean c() {
        return this.j == 1;
    }

    public boolean d() {
        return this.k == 1;
    }

    public d a(boolean z) {
        this.k = z ? 1 : 0;
        return this;
    }

    public d b(boolean z) {
        this.l = z ? 1 : 0;
        return this;
    }

    public d c(boolean z) {
        this.m = z ? 1 : 0;
        return this;
    }

    public String e() {
        return this.f10588e;
    }

    public d d(String str) {
        this.f10588e = t.d(str);
        return this;
    }

    public int f() {
        if (this.f10590g) {
            return this.f10589f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public d a(int i2) {
        this.f10589f = i2;
        this.f10590g = true;
        return this;
    }

    public boolean g() {
        return this.f10590g;
    }

    public int h() {
        if (this.i) {
            return this.h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public d b(int i2) {
        this.h = i2;
        this.i = true;
        return this;
    }

    public boolean i() {
        return this.i;
    }

    public Layout.Alignment j() {
        return this.p;
    }

    public int k() {
        return this.n;
    }

    public float l() {
        return this.o;
    }

    private static int a(int i2, String str, String str2, int i3) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }
}
