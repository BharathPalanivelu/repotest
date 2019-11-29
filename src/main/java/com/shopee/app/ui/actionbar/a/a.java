package com.shopee.app.ui.actionbar.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.m;
import com.shopee.id.R;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f19272a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f19273b = b.a(R.color.primary);

    /* renamed from: c  reason: collision with root package name */
    private String f19274c;

    /* renamed from: d  reason: collision with root package name */
    private String f19275d;

    /* renamed from: e  reason: collision with root package name */
    private String f19276e;

    /* renamed from: f  reason: collision with root package name */
    private String f19277f;

    /* renamed from: g  reason: collision with root package name */
    private int f19278g = -1;
    private Drawable h;
    private m i;
    private Info.InfoBuilder j;
    private View.OnClickListener k;

    public a a(String str) {
        this.f19272a = str;
        return this;
    }

    public a a(int i2) {
        this.f19273b = i2;
        return this;
    }

    public a b(String str) {
        this.f19274c = str;
        return this;
    }

    public a c(String str) {
        this.f19275d = str;
        return this;
    }

    public a d(String str) {
        this.f19276e = str;
        return this;
    }

    public a e(String str) {
        this.f19277f = str;
        return this;
    }

    public a b(int i2) {
        this.f19278g = i2;
        return this;
    }

    public a.b a() {
        return new a.b(this.f19272a, this.f19273b, this.f19274c, this.f19275d, this.f19276e, this.f19277f, this.f19278g, this.h, this.i, this.j, this.k);
    }
}
