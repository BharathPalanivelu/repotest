package com.shopee.app.ui.actionbar;

import android.app.Activity;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class g extends a.b {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f19312a;

    public g(Activity activity) {
        super("ACTION_BAR_CART", (int) R.drawable.ic_nav_cart_orange);
        this.f19312a = activity;
    }

    public void a() {
        ak.a(this.f19312a);
    }
}
