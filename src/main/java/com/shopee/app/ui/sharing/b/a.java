package com.shopee.app.ui.sharing.b;

import android.app.Activity;
import com.shopee.app.ui.sharing.base.b;
import d.d.b.j;

public final class a extends com.shopee.app.ui.sharing.base.common.a {
    public String h() {
        return "jp.naver.line.android";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Activity activity, b bVar) {
        super(activity, bVar);
        j.b(activity, "activity");
        j.b(bVar, "shareListener");
    }
}
