package com.shopee.app.ui.product.add.wholesale;

import androidx.databinding.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.g.e;
import com.shopee.app.util.af;
import com.shopee.id.R;

public class i extends a {

    /* renamed from: a  reason: collision with root package name */
    private k f24209a;

    public i(k kVar) {
        this.f24209a = kVar;
    }

    public boolean a() {
        return !af.a(this.f24209a.g());
    }

    public String b() {
        return b.a(R.string.wholesale_original_price, e.a(this.f24209a.e() != null ? this.f24209a.e().longValue() : 0, "IDR", true));
    }

    public boolean c() {
        return this.f24209a.e() != null;
    }
}
