package com.shopee.app.util.q;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.facebook.share.internal.ShareConstants;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import d.d.b.j;

public abstract class f {
    /* access modifiers changed from: protected */
    public abstract d a(e eVar, c cVar, boolean z);

    public abstract e.C0408e a();

    public abstract g b();

    public final d b(e eVar, c cVar, boolean z) {
        j.b(eVar, TouchesHelper.TARGET_KEY);
        j.b(cVar, "messageSupplier");
        if (eVar.a() == a()) {
            return a(eVar, cVar, z);
        }
        throw new IllegalStateException("Expected [" + a().name() + "] but found [" + eVar.a().name() + ']');
    }

    /* access modifiers changed from: protected */
    public final d a(boolean z, String str) {
        j.b(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (z) {
            return new d.a(str);
        }
        return new d.c(str);
    }
}
