package com.shopee.app.ui.home.d;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    private List<b> f22155a = new ArrayList();

    public void a(b bVar) {
        this.f22155a.add(bVar);
    }

    public void b() {
        for (b b2 : this.f22155a) {
            b2.b();
        }
    }

    public void c() {
        for (b c2 : this.f22155a) {
            c2.c();
        }
    }

    public void f() {
        for (b f2 : this.f22155a) {
            f2.f();
        }
        this.f22155a.clear();
    }

    public void a(Activity activity, int i, int i2, Intent intent) {
        for (b a2 : this.f22155a) {
            a2.a(activity, i, i2, intent);
        }
    }
}
