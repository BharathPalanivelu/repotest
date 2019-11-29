package com.shopee.app.network.d.f;

import android.text.TextUtils;
import com.beetalklib.network.d.f;
import com.shopee.app.network.d.az;
import com.shopee.app.util.as;
import com.shopee.protocol.action.AccountExist;

public class a extends az {

    /* renamed from: a  reason: collision with root package name */
    private String f18265a;

    /* renamed from: b  reason: collision with root package name */
    private String f18266b;

    public void a(String str) {
        this.f18265a = as.a(str);
        g();
    }

    public void b(String str) {
        this.f18266b = str;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        AccountExist.Builder builder = new AccountExist.Builder();
        builder.requestid(i().a()).check_has_pwd(true);
        if (!TextUtils.isEmpty(this.f18265a)) {
            builder.phone(this.f18265a);
        }
        if (!TextUtils.isEmpty(this.f18266b)) {
            builder.email(this.f18266b);
        }
        builder.country("ID");
        return new f(93, builder.build().toByteArray());
    }
}
