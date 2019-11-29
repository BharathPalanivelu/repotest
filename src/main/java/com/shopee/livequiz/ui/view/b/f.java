package com.shopee.livequiz.ui.view.b;

import android.app.Activity;
import android.util.SparseArray;
import com.shopee.livequiz.ui.view.a.b;
import com.shopee.sdk.modules.ui.a.a;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<b> f30031a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private d f30032b;

    /* renamed from: c  reason: collision with root package name */
    private e f30033c;

    /* renamed from: d  reason: collision with root package name */
    private b f30034d;

    /* renamed from: e  reason: collision with root package name */
    private a f30035e;

    /* renamed from: f  reason: collision with root package name */
    private g f30036f;

    /* renamed from: g  reason: collision with root package name */
    private c f30037g;

    public f(Activity activity) {
        this.f30032b = new d(activity);
        this.f30033c = new e(activity);
        this.f30034d = new b(activity);
        this.f30035e = new a(activity);
        this.f30036f = new g(activity);
        this.f30037g = new c(activity);
        this.f30031a.put(1, this.f30032b);
        this.f30031a.put(2, this.f30033c);
        this.f30031a.put(3, this.f30034d);
        this.f30031a.put(4, this.f30035e);
        this.f30031a.put(5, this.f30036f);
        this.f30031a.put(6, this.f30037g);
    }

    public void a(int i) {
        b bVar = this.f30031a.get(i);
        if (bVar != null) {
            bVar.a();
        }
    }

    public void b(int i) {
        b bVar = this.f30031a.get(i);
        if (bVar != null) {
            bVar.c();
        }
    }

    public d a() {
        return this.f30032b;
    }

    public b b() {
        return this.f30034d;
    }

    public a c() {
        return this.f30035e;
    }

    public g d() {
        return this.f30036f;
    }

    public c e() {
        return this.f30037g;
    }

    public void a(String str, String str2, String str3, Activity activity) {
        com.shopee.sdk.b.a().c().a(activity, new a.C0472a().a(str).d(str3).b(str2).a(), new com.shopee.sdk.f.b<Integer>() {
            public void a(int i, String str) {
            }

            public void a(Integer num) {
                num.intValue();
            }
        });
    }
}
