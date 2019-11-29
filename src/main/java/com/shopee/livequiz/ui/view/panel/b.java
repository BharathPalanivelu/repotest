package com.shopee.livequiz.ui.view.panel;

import com.shopee.livequiz.c;
import com.shopee.livequiz.g.m;

public class b extends m {

    /* renamed from: a  reason: collision with root package name */
    private float f30084a;

    b() {
        this.f30084a = 1.0f;
        this.f30084a = ((float) a()) / ((float) com.garena.android.appkit.tools.b.g(c.e.land_panel_total_screen_height));
    }

    public int a(int i) {
        return (int) (this.f30084a * ((float) com.garena.android.appkit.tools.b.g(i)));
    }

    public int a() {
        int c2 = c();
        int d2 = d();
        return c2 > d2 ? d2 : c2;
    }
}
