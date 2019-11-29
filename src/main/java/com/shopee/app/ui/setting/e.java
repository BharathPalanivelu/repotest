package com.shopee.app.ui.setting;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.be;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.x;

public class e extends LinearLayout implements a.C0318a {

    /* renamed from: a  reason: collision with root package name */
    TextView f25206a;

    /* renamed from: b  reason: collision with root package name */
    TextView f25207b;

    /* renamed from: c  reason: collision with root package name */
    TextView f25208c;

    /* renamed from: d  reason: collision with root package name */
    TextView f25209d;

    /* renamed from: e  reason: collision with root package name */
    TextView f25210e;

    /* renamed from: f  reason: collision with root package name */
    TextView f25211f;

    /* renamed from: g  reason: collision with root package name */
    be f25212g;
    r h;
    private final b i = c.a(getContext());

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public void onNegative() {
    }

    public e(Context context) {
        super(context);
        ((m) ((x) getContext()).b()).a(this);
    }

    public void onPositive() {
        ar.f().e().loginStore().i();
        this.h.a();
        ar.a(false);
    }
}
