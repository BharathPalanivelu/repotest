package com.shopee.app.ui.sharing.copyinfo;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import com.shopee.app.ui.sharing.base.b;
import d.d.b.j;
import d.m;

public final class a extends com.shopee.app.ui.sharing.base.a<CopyInfoData> {
    public boolean a(Activity activity) {
        j.b(activity, "activity");
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Activity activity, b bVar) {
        super(CopyInfoData.class, activity, bVar);
        j.b(activity, "activity");
        j.b(bVar, "shareListener");
    }

    /* renamed from: a */
    public boolean b(CopyInfoData copyInfoData) {
        j.b(copyInfoData, "shareData");
        CharSequence content = copyInfoData.getContent();
        return !(content == null || content.length() == 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void c(CopyInfoData copyInfoData) {
        j.b(copyInfoData, "shareData");
        Activity b2 = b();
        if (b2 != null) {
            Object systemService = b2.getSystemService("clipboard");
            if (systemService != null) {
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText((CharSequence) null, copyInfoData.getContent()));
                a(new com.shopee.app.ui.sharing.base.data.a(0, (String) null, 2, (g) null));
                return;
            }
            throw new m("null cannot be cast to non-null type android.content.ClipboardManager");
        }
    }
}
