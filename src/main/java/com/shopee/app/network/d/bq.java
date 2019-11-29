package com.shopee.app.network.d;

import android.text.TextUtils;
import com.beetalklib.network.d.f;
import com.shopee.protocol.action.SetUserInfo;
import com.shopee.protocol.shop.AccountExtInfo;

public class bq extends az {

    /* renamed from: a  reason: collision with root package name */
    private String f18215a;

    /* renamed from: b  reason: collision with root package name */
    private String f18216b;

    /* renamed from: c  reason: collision with root package name */
    private int f18217c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f18218d;

    /* renamed from: e  reason: collision with root package name */
    private String f18219e;

    public void a(String str) {
        this.f18215a = str;
        g();
    }

    public void a(String str, String str2, String str3, int i, Integer num) {
        this.f18215a = str;
        this.f18216b = str2;
        this.f18219e = str3;
        this.f18217c = i;
        this.f18218d = num;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        SetUserInfo.Builder builder = new SetUserInfo.Builder();
        builder.requestid(i().a()).country("ID");
        if (!TextUtils.isEmpty(this.f18215a)) {
            builder.portrait(this.f18215a);
        }
        if (!TextUtils.isEmpty(this.f18216b)) {
            builder.user_name(this.f18216b);
        }
        AccountExtInfo.Builder builder2 = new AccountExtInfo.Builder();
        builder2.gender(Integer.valueOf(this.f18217c));
        if (!TextUtils.isEmpty(this.f18219e)) {
            builder2.nickname(this.f18219e);
        }
        Integer num = this.f18218d;
        if (num != null) {
            builder2.birth_timestamp(num);
        }
        builder.extinfo(e.f.a(builder2.build().toByteArray()));
        return new f(67, builder.build().toByteArray());
    }
}
