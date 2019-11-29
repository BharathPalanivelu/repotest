package com.google.android.exoplayer2.p.g;

import android.text.Layout;
import com.google.android.exoplayer2.s.v;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private String f11189a;

    /* renamed from: b  reason: collision with root package name */
    private String f11190b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f11191c;

    /* renamed from: d  reason: collision with root package name */
    private String f11192d;

    /* renamed from: e  reason: collision with root package name */
    private String f11193e;

    /* renamed from: f  reason: collision with root package name */
    private int f11194f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11195g;
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
        this.f11189a = "";
        this.f11190b = "";
        this.f11191c = Collections.emptyList();
        this.f11192d = "";
        this.f11193e = null;
        this.f11195g = false;
        this.i = false;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.p = null;
    }

    public void a(String str) {
        this.f11189a = str;
    }

    public void b(String str) {
        this.f11190b = str;
    }

    public void a(String[] strArr) {
        this.f11191c = Arrays.asList(strArr);
    }

    public void c(String str) {
        this.f11192d = str;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.f11189a.isEmpty() && this.f11190b.isEmpty() && this.f11191c.isEmpty() && this.f11192d.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int a2 = a(a(a(0, this.f11189a, str, 1073741824), this.f11190b, str2, 2), this.f11192d, str3, 4);
        if (a2 == -1 || !Arrays.asList(strArr).containsAll(this.f11191c)) {
            return 0;
        }
        return a2 + (this.f11191c.size() * 4);
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
        return this.f11193e;
    }

    public d d(String str) {
        this.f11193e = v.d(str);
        return this;
    }

    public int f() {
        if (this.f11195g) {
            return this.f11194f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public d a(int i2) {
        this.f11194f = i2;
        this.f11195g = true;
        return this;
    }

    public boolean g() {
        return this.f11195g;
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
