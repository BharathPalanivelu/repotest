package com.shopee.app.ui.actionbar;

import android.app.Activity;
import com.shopee.app.ui.actionbar.a;
import com.shopee.id.R;

public class i extends a.b {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f19315a;

    public i(Activity activity) {
        super("ACTION_BAR_ACTIVITY_CLOSE", (int) R.drawable.com_garena_shopee_ic_close);
        this.f19315a = activity;
    }

    public void a() {
        this.f19315a.onBackPressed();
    }
}
