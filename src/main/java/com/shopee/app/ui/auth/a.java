package com.shopee.app.ui.auth;

import android.content.Context;
import com.google.a.o;
import com.shopee.app.tracking.trackingv3.model.ViewCommon;

abstract class a extends com.garena.android.uikit.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    protected final String f19480a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19481b = false;

    /* renamed from: c  reason: collision with root package name */
    private final ViewCommon f19482c;

    /* access modifiers changed from: package-private */
    public abstract void a(o oVar, ViewCommon viewCommon);

    public a(Context context, String str) {
        super(context);
        this.f19480a = str;
        this.f19482c = new ViewCommon(true, false, System.currentTimeMillis() + "");
    }

    public void a() {
        super.a();
        if (!this.f19481b) {
            o oVar = new o();
            oVar.a("acquisition_source", this.f19480a);
            a(oVar, this.f19482c);
            this.f19481b = true;
        }
    }
}
