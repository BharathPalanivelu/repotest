package com.shopee.app.ui.sharing.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.shopee.app.ui.sharing.base.b;
import com.shopee.app.ui.sharing.base.common.CommonAppShareData;
import com.shopee.app.ui.sharing.base.data.ShareImage;
import com.shopee.app.ui.sharing.base.helper.c;
import d.d.b.j;

public final class a extends com.shopee.app.ui.sharing.base.a<CommonAppShareData> {
    public final String h() {
        return "com.pinterest";
    }

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
        if (commonAppShareData.getImage() != null) {
            CharSequence imageBase64 = commonAppShareData.getImage().getImageBase64();
            if (!(imageBase64 == null || imageBase64.length() == 0)) {
                return true;
            }
            CharSequence imageUrl = commonAppShareData.getImage().getImageUrl();
            if (!(imageUrl == null || imageUrl.length() == 0)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void c(CommonAppShareData commonAppShareData) {
        j.b(commonAppShareData, "appShareData");
        ShareImage image = commonAppShareData.getImage();
        if (image != null) {
            a(image);
        }
    }

    public void b(String str) {
        j.b(str, "filePath");
        Activity b2 = b();
        if (b2 != null) {
            CommonAppShareData commonAppShareData = (CommonAppShareData) a();
            if (commonAppShareData != null) {
                Uri b3 = c.b(b2, str);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setPackage(h());
                intent.putExtra("com.pinterest.EXTRA_DESCRIPTION", commonAppShareData.getText());
                intent.putExtra("android.intent.extra.STREAM", b3);
                intent.setType("image/*");
                b2.startActivity(intent);
            }
        }
    }

    public void e() {
        a(new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null));
    }
}
