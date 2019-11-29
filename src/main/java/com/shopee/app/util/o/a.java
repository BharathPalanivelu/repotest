package com.shopee.app.util.o;

import com.garena.android.appkit.tools.b;
import com.shopee.id.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26462a;

    public a() {
        this(false, 1, (g) null);
    }

    public a(boolean z) {
        this.f26462a = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(boolean z, int i, g gVar) {
        this((i & 1) != 0 ? false : z);
    }

    public final int a() {
        return b.a(this.f26462a ? R.color.red_official_shop : R.color.primary);
    }

    public final int b() {
        return this.f26462a ? R.drawable.btn_red_official_shop : R.drawable.btn_primary;
    }
}
