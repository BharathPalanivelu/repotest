package com.shopee.app.ui.a;

import android.content.Context;
import com.garena.android.uikit.a.a.a;
import d.d.b.j;

public abstract class g extends a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19204a;

    public final void setTabShowing(boolean z) {
        this.f19204a = z;
    }

    public final boolean y_() {
        return this.f19204a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        super(context);
        j.b(context, "context");
    }

    public void a() {
        super.a();
        this.f19204a = true;
    }

    public void b() {
        super.b();
        this.f19204a = false;
    }
}
