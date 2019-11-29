package com.shopee.app.data.store;

import android.content.SharedPreferences;
import c.a.a.a.b;
import c.a.a.a.c;
import com.garena.android.appkit.tools.a.a;

public class bb extends ay {

    /* renamed from: a  reason: collision with root package name */
    private b f17242a;

    /* renamed from: b  reason: collision with root package name */
    private b f17243b;

    /* renamed from: c  reason: collision with root package name */
    private c f17244c;

    /* renamed from: d  reason: collision with root package name */
    private c f17245d;

    /* renamed from: e  reason: collision with root package name */
    private b f17246e;

    public bb(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f17242a = new b(sharedPreferences, "mRatingActionStatus", -1);
        this.f17243b = new b(sharedPreferences, "mRatingPurchaseStatus", -1);
        this.f17244c = new c(sharedPreferences, "idForShowRatingInAction", 0);
        this.f17245d = new c(sharedPreferences, "mIdForShowRatingInPurchase", 0);
        this.f17246e = new b(sharedPreferences, "mShowRatingTime", 0);
    }

    public int a() {
        return this.f17242a.a();
    }

    public void a(int i) {
        this.f17242a.a(i);
    }

    public int b() {
        return this.f17243b.a();
    }

    public void b(int i) {
        this.f17243b.a(i);
    }

    public long c() {
        return this.f17244c.a();
    }

    public void a(long j) {
        this.f17244c.a(j);
    }

    public long d() {
        return this.f17245d.a();
    }

    public void b(long j) {
        this.f17245d.a(j);
    }

    public int e() {
        return this.f17246e.a();
    }

    public void c(int i) {
        this.f17246e.a(i);
    }

    public boolean f() {
        return a.a() - e() < 2592000;
    }

    public boolean g() {
        return a() == 0 && !f();
    }

    public boolean h() {
        return b() == 0 && !f();
    }

    public boolean c(long j) {
        if ((a() == 1 || a() == 0 || a() == 2) && c() == j) {
            return true;
        }
        return false;
    }

    public boolean i() {
        return (a() == -1 && b() == -1) || !f();
    }

    public boolean j() {
        return (b() == -1 && a() == -1) || !f();
    }

    public boolean d(long j) {
        if ((b() == 2 || b() == 1 || b() == 0) && d() == j) {
            return true;
        }
        return false;
    }
}
