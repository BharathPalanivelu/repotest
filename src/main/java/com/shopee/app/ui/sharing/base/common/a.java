package com.shopee.app.ui.sharing.base.common;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.shopee.app.ui.sharing.base.b;
import com.shopee.app.ui.sharing.base.helper.c;
import d.d.b.j;

public abstract class a extends com.shopee.app.ui.sharing.base.a<CommonAppShareData> {
    public abstract String h();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Activity activity, b bVar) {
        super(CommonAppShareData.class, activity, bVar);
        j.b(activity, "activity");
        j.b(bVar, "shareListener");
    }

    public boolean a(Activity activity) {
        j.b(activity, "activity");
        return c.a((Context) activity, h());
    }

    /* renamed from: a */
    public boolean b(CommonAppShareData commonAppShareData) {
        j.b(commonAppShareData, "appShareData");
        return !TextUtils.isEmpty(commonAppShareData.getText()) || commonAppShareData.getImage() != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void c(CommonAppShareData commonAppShareData) {
        j.b(commonAppShareData, "appShareData");
        if (commonAppShareData.getImage() != null) {
            a(commonAppShareData.getImage());
        } else if (commonAppShareData.getVideo() != null) {
            a(commonAppShareData.getVideo());
        } else if (commonAppShareData.getText() != null) {
            i();
        } else {
            a(new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null));
        }
    }

    public void b(String str) {
        j.b(str, "filePath");
        d(str);
    }

    public void c(String str) {
        j.b(str, "filePath");
        super.c(str);
        e(str);
    }

    public void i() {
        Activity b2 = b();
        if (b2 != null) {
            CommonAppShareData commonAppShareData = (CommonAppShareData) a();
            if (commonAppShareData != null) {
                a(c.a(b2, h(), commonAppShareData.getText()));
            }
        }
    }

    public void d(String str) {
        j.b(str, "filePath");
        Activity b2 = b();
        if (b2 != null) {
            String h = h();
            CommonAppShareData commonAppShareData = (CommonAppShareData) a();
            a(c.a(b2, h, commonAppShareData != null ? commonAppShareData.getText() : null, str));
        }
    }

    public void e(String str) {
        j.b(str, "filePath");
        Activity b2 = b();
        if (b2 != null) {
            String h = h();
            CommonAppShareData commonAppShareData = (CommonAppShareData) a();
            a(c.b(b2, h, commonAppShareData != null ? commonAppShareData.getText() : null, str));
        }
    }
}
