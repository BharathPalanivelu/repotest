package com.shopee.app.application.a.a;

import android.app.Activity;
import com.shopee.app.application.a.b;
import com.shopee.app.application.ar;
import com.shopee.app.ui.home.c;

public class h implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f15836a = true;

    public void a(Activity activity) {
    }

    public void a(ar arVar, Activity activity) {
    }

    public void b(ar arVar, Activity activity) {
    }

    public void c(Activity activity) {
    }

    public void d(Activity activity) {
    }

    public void e(Activity activity) {
    }

    public void f(Activity activity) {
    }

    public void b(Activity activity) {
        if (activity instanceof c) {
            if (this.f15836a) {
                ((c) activity).q();
            }
            this.f15836a = true;
            return;
        }
        this.f15836a = false;
    }
}
