package com.shopee.app.ui.sharing.instagram;

import android.app.Activity;
import android.text.TextUtils;
import com.shopee.app.ui.sharing.base.b;
import com.shopee.app.ui.sharing.base.common.CommonAppShareData;
import d.d.b.j;

public final class a extends com.shopee.app.ui.sharing.base.common.a {
    public String h() {
        return "com.instagram.android";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Activity activity, b bVar) {
        super(activity, bVar);
        j.b(activity, "activity");
        j.b(bVar, "shareListener");
    }

    /* renamed from: a */
    public boolean b(CommonAppShareData commonAppShareData) {
        j.b(commonAppShareData, "appShareData");
        return (TextUtils.isEmpty(commonAppShareData.getText()) && commonAppShareData.getImage() == null && commonAppShareData.getVideo() == null) ? false : true;
    }
}
