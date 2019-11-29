package com.shopee.app.ui.home.d;

import com.shopee.app.h.r;
import com.shopee.app.ui.home.c;
import com.shopee.app.ui.home.m;
import com.shopee.id.R;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private final c f22149a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f22150b = false;

    public a(c cVar) {
        this.f22149a = cVar;
    }

    public boolean a() {
        m p = this.f22149a.p();
        if (p == null || !p.f()) {
            if (this.f22150b) {
                return false;
            }
            this.f22150b = true;
            r.a().a((int) R.string.sp_label_press_again_to_exit);
            p.postDelayed(new Runnable() {
                public void run() {
                    boolean unused = a.this.f22150b = false;
                }
            }, 2000);
        }
        return true;
    }
}
