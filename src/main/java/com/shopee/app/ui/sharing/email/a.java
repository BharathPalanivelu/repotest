package com.shopee.app.ui.sharing.email;

import android.app.Activity;
import android.content.Intent;
import com.shopee.app.ui.sharing.base.b;
import com.shopee.app.ui.sharing.base.helper.c;
import d.d.b.j;

public final class a extends com.shopee.app.ui.sharing.base.a<EmailShareData> {
    public boolean a(Activity activity) {
        j.b(activity, "activity");
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Activity activity, b bVar) {
        super(EmailShareData.class, activity, bVar);
        j.b(activity, "activity");
        j.b(bVar, "shareListener");
    }

    /* renamed from: a */
    public boolean b(EmailShareData emailShareData) {
        j.b(emailShareData, "shareData");
        if (emailShareData.getImage() == null) {
            CharSequence title = emailShareData.getTitle();
            if (title == null || title.length() == 0) {
                CharSequence content = emailShareData.getContent();
                return !(content == null || content.length() == 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void c(EmailShareData emailShareData) {
        j.b(emailShareData, "shareData");
        Activity b2 = b();
        if (b2 == null) {
            return;
        }
        if (emailShareData.getImage() != null) {
            a(emailShareData.getImage());
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.SUBJECT", emailShareData.getTitle());
        intent.putExtra("android.intent.extra.TEXT", emailShareData.getContent());
        b2.startActivity(intent);
        a(new com.shopee.app.ui.sharing.base.data.a(0, (String) null, 2, (g) null));
    }

    public void e() {
        a(new com.shopee.app.ui.sharing.base.data.a(1, (String) null, 2, (g) null));
    }

    public void b(String str) {
        j.b(str, "filePath");
        Activity b2 = b();
        if (b2 != null) {
            EmailShareData emailShareData = (EmailShareData) a();
            if (emailShareData != null) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("message/rfc822");
                intent.putExtra("android.intent.extra.SUBJECT", emailShareData.getTitle());
                intent.putExtra("android.intent.extra.TEXT", emailShareData.getContent());
                intent.putExtra("android.intent.extra.STREAM", c.b(b2, str));
                b2.startActivity(intent);
                a(new com.shopee.app.ui.sharing.base.data.a(0, (String) null, 2, (g) null));
            }
        }
    }
}
