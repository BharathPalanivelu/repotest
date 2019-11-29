package com.shopee.app.react.modules.ui.contactpicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.react.bridge.Promise;
import com.google.a.o;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.react.protocol.ContactPickerResult;
import com.shopee.app.web.WebRegister;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private Promise f18825a;

    public void a(Activity activity, Promise promise) {
        this.f18825a = promise;
        Intent intent = new Intent("android.intent.action.PICK", Uri.parse("content://contacts"));
        intent.setType("vnd.android.cursor.dir/phone_v2");
        activity.startActivityForResult(intent, 3);
    }

    public void a(o oVar) {
        if (this.f18825a != null) {
            String str = "";
            String c2 = oVar.b("phone") ? oVar.c("phone").c() : str;
            if (oVar.b("name")) {
                str = oVar.c("name").c();
            }
            if (!TextUtils.isEmpty(c2) || !TextUtils.isEmpty(str)) {
                this.f18825a.resolve(WebRegister.GSON.b((Object) new ContactPickerResult.Builder().data(new ContactPickerResult.ContactData(str, c2)).error(0).build()));
                this.f18825a = null;
                return;
            }
            a(1);
        }
    }

    public void a(int i) {
        if (this.f18825a != null) {
            this.f18825a.resolve(WebRegister.GSON.b((Object) new ContactPickerResult.Builder().error(i).build()));
            this.f18825a = null;
        }
    }
}
