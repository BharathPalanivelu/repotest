package com.shopee.app.d.c;

import android.text.TextUtils;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.bh;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.network.d.bq;
import com.shopee.app.network.d.bu;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.Shop;

public class dx extends a {

    /* renamed from: c  reason: collision with root package name */
    private String f16869c;

    /* renamed from: d  reason: collision with root package name */
    private String f16870d;

    /* renamed from: e  reason: collision with root package name */
    private String f16871e;

    /* renamed from: f  reason: collision with root package name */
    private String f16872f;

    /* renamed from: g  reason: collision with root package name */
    private bh f16873g;
    private int h;
    private Integer i;
    private bq j;
    private String k;

    /* access modifiers changed from: protected */
    public String d() {
        return "SubmitShopIteractor";
    }

    protected dx(n nVar, bh bhVar) {
        super(nVar);
        this.f16873g = bhVar;
    }

    public void a(String str, String str2, String str3, int i2, Integer num, String str4, String str5, bq bqVar) {
        this.f16869c = str;
        this.f16870d = str2;
        this.f16872f = str4;
        this.k = str5;
        this.f16871e = str3;
        this.h = i2;
        this.i = num;
        this.j = bqVar;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        e();
    }

    private void e() {
        DBUserInfo a2 = this.f16873g.a(((Integer) ak.a().d().b(-1)).intValue());
        if (!this.f16869c.equals("-1")) {
            a2.g(this.f16869c);
        }
        DBShopInfo b2 = this.f16873g.b(((Integer) ak.a().i().b(-1)).intValue());
        if (!this.f16870d.equals("-1")) {
            b2.e(this.f16870d);
        }
        this.f16873g.a(b2);
        this.f16873g.a(a2);
        bu buVar = new bu();
        Shop.Builder builder = new Shop.Builder();
        builder.shopid(Integer.valueOf(b2.b())).cover(b2.h());
        if (!TextUtils.isEmpty(this.f16872f)) {
            builder.description(this.f16872f.trim());
        }
        buVar.a(builder.build());
        this.j.a(a2.j(), this.f16871e, this.k, this.h, this.i);
    }
}
