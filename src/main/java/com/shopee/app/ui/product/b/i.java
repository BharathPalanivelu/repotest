package com.shopee.app.ui.product.b;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.facebook.share.internal.ShareConstants;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.product.b.a.d;
import com.shopee.app.util.q.c;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.f;
import com.shopee.app.util.q.g;
import com.shopee.id.R;
import d.d.b.j;

public final class i extends f {

    /* renamed from: a  reason: collision with root package name */
    private final d f24398a;

    public i(d dVar) {
        j.b(dVar, "config");
        this.f24398a = dVar;
    }

    public e.C0408e a() {
        return e.C0408e.DTS;
    }

    public g b() {
        return this.f24398a;
    }

    /* access modifiers changed from: protected */
    public com.shopee.app.util.q.d a(e eVar, c cVar, boolean z) {
        j.b(eVar, TouchesHelper.TARGET_KEY);
        j.b(cVar, "messageSupplier");
        e.b bVar = (e.b) eVar;
        if (bVar.c()) {
            if (!(this.f24398a.a().length == 0)) {
                d.b a2 = this.f24398a.a(bVar.b());
                if (a2 == null) {
                    String e2 = b.e(R.string.sp_dts_invalid_preorder_toggle_msg);
                    j.a((Object) e2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    return a(z, e2);
                } else if (bVar.d() >= a2.a() && bVar.d() <= a2.b()) {
                    return d.b.f26486a;
                } else {
                    String a3 = b.a(R.string.sp_dts_invalid_day_rang_msg, Integer.valueOf(a2.a()), Integer.valueOf(a2.b()));
                    j.a((Object) a3, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                    return a(z, a3);
                }
            }
        }
        return d.b.f26486a;
    }
}
