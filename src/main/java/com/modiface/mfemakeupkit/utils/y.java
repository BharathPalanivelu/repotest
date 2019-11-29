package com.modiface.mfemakeupkit.utils;

import android.os.SystemClock;
import android.util.Log;

public class y {

    /* renamed from: a  reason: collision with root package name */
    static final String f15408a = "y";

    /* renamed from: b  reason: collision with root package name */
    private long f15409b;

    public y() {
        c();
    }

    public void a(double d2) {
        this.f15409b = SystemClock.elapsedRealtime() + Math.round(d2 * 1000.0d);
    }

    public double b() {
        double d2 = (double) d();
        Double.isNaN(d2);
        return d2 / 1000.0d;
    }

    public void c() {
        this.f15409b = SystemClock.elapsedRealtime();
    }

    public long d() {
        return SystemClock.elapsedRealtime() - this.f15409b;
    }

    public void b(String str, String str2) {
        Log.d(str, str2 + ": " + b() + " s");
    }

    public void c(String str, String str2) {
        Log.d(str, str2 + ": " + d() + " ms");
    }

    public double a() {
        return 1.0d / b();
    }

    public void b(String str) {
        b(f15408a, str);
    }

    public void c(String str) {
        c("Timer", str);
    }

    public void a(String str, String str2) {
        Log.d(str, str2 + ": " + a() + " fps");
    }

    public void a(String str) {
        a(f15408a, str);
    }
}
