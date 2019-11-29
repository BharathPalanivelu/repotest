package com.shopee.app.data.store;

import android.content.SharedPreferences;
import c.a.a.a.a;

public class bd extends ay {

    /* renamed from: a  reason: collision with root package name */
    private a f17248a;

    /* renamed from: b  reason: collision with root package name */
    private a f17249b;

    /* renamed from: c  reason: collision with root package name */
    private a f17250c;

    /* renamed from: d  reason: collision with root package name */
    private a f17251d;

    /* renamed from: e  reason: collision with root package name */
    private a f17252e;

    /* renamed from: f  reason: collision with root package name */
    private a f17253f;

    public bd(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f17248a = new a(sharedPreferences, "mShowMallTabPopup", true);
        this.f17249b = new a(sharedPreferences, "mShowMeTabBadge", true);
        this.f17250c = new a(sharedPreferences, "mShowSellerTabPopup", true);
        this.f17251d = new a(sharedPreferences, "mShowSellerTabRedDot", true);
        this.f17252e = new a(sharedPreferences, "mShowSellerAddProductRedDot", true);
        this.f17253f = new a(sharedPreferences, "mShowFeedTabNewBadge", true);
    }

    public void a(boolean z) {
        this.f17248a.a(z);
    }

    public boolean a() {
        return this.f17249b.a();
    }

    public void b(boolean z) {
        this.f17249b.a(z);
    }

    public void c(boolean z) {
        this.f17250c.a(z);
    }

    public void d(boolean z) {
        this.f17251d.a(z);
    }

    public void e(boolean z) {
        this.f17252e.a(z);
    }

    public boolean b() {
        return this.f17253f.a();
    }

    public void f(boolean z) {
        this.f17253f.a(z);
    }
}
