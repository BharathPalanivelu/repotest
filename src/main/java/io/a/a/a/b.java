package io.a.a.a;

import android.util.Log;

public class b implements l {

    /* renamed from: a  reason: collision with root package name */
    private int f33277a;

    public b(int i) {
        this.f33277a = i;
    }

    public b() {
        this.f33277a = 4;
    }

    public boolean a(String str, int i) {
        return this.f33277a <= i;
    }

    public void a(String str, String str2, Throwable th) {
        if (a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void b(String str, String str2, Throwable th) {
        if (a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void c(String str, String str2, Throwable th) {
        if (a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void d(String str, String str2, Throwable th) {
        if (a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public void e(String str, String str2, Throwable th) {
        if (a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void a(String str, String str2) {
        a(str, str2, (Throwable) null);
    }

    public void b(String str, String str2) {
        b(str, str2, (Throwable) null);
    }

    public void c(String str, String str2) {
        c(str, str2, (Throwable) null);
    }

    public void d(String str, String str2) {
        d(str, str2, (Throwable) null);
    }

    public void e(String str, String str2) {
        e(str, str2, (Throwable) null);
    }

    public void a(int i, String str, String str2) {
        a(i, str, str2, false);
    }

    public void a(int i, String str, String str2, boolean z) {
        if (z || a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
