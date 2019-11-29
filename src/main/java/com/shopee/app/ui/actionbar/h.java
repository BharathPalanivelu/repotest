package com.shopee.app.ui.actionbar;

import android.app.Activity;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.auth.AuthTabActivity_;
import com.shopee.id.R;

public class h extends a.b {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f19313a;

    /* renamed from: b  reason: collision with root package name */
    private final a f19314b;

    public interface a {
        void a();
    }

    public h(Activity activity, a aVar) {
        super("ACTION_BAR_ACTIVITY_CLOSE", (int) R.drawable.com_garena_shopee_ic_close);
        this.f19313a = activity;
        this.f19314b = aVar;
    }

    public void a() {
        a aVar = this.f19314b;
        if (aVar != null) {
            aVar.a();
        } else {
            ((AuthTabActivity_.a) AuthTabActivity_.a(this.f19313a).b(0).k(67108864)).a();
        }
    }
}
