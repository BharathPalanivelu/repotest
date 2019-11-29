package com.shopee.app.d.c;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.f.e;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.bh;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.h.o;
import com.shopee.app.network.d.bq;
import com.shopee.app.network.d.bu;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import com.shopee.protocol.shop.Shop;
import com.shopee.protocol.shop.ShopCover;
import com.shopee.protocol.shop.ShopExtInfo;
import e.f;
import java.util.ArrayList;
import java.util.List;

public class dz extends a {

    /* renamed from: c  reason: collision with root package name */
    private int f16876c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f16877d;

    /* renamed from: e  reason: collision with root package name */
    private String f16878e;

    /* renamed from: f  reason: collision with root package name */
    private bh f16879f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16880g;
    private List<ShopCover> h;
    private String i;
    private String j;
    private bq k;

    /* access modifiers changed from: protected */
    public String d() {
        return "SubmitShopProfileInteractor";
    }

    protected dz(n nVar, bh bhVar) {
        super(nVar);
        this.f16879f = bhVar;
    }

    public void a(String str, String str2, String str3, String str4, List<ShopCover> list, boolean z, bq bqVar) {
        this.f16877d = str3;
        this.i = str;
        this.j = str2;
        this.f16878e = str4;
        this.h = list;
        this.f16880g = z;
        this.k = bqVar;
        this.f16876c = 0;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<ShopCover> list = this.h;
        if (list == null || list.isEmpty()) {
            e();
            return;
        }
        boolean z = true;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            int h2 = o.a().h(this.h.get(i2).image_url);
            if (!(h2 == -1 || h2 == 2)) {
                z = false;
            }
        }
        if (z) {
            e();
            return;
        }
        if (this.f16876c == 6) {
            ResponseCommon.Builder builder = new ResponseCommon.Builder();
            builder.errcode = -100;
            ResponseCommon build = builder.build();
            this.f16402a.a("UPDATE_SHOP_INFO_ERROR", new a(new com.shopee.app.network.c.d.a(build.errcode.intValue(), build.err_message, build)));
        } else {
            e.a().a(new Runnable() {
                public void run() {
                    dz.this.c();
                }
            }, 5000);
        }
        this.f16876c++;
    }

    private void e() {
        DBUserInfo a2 = this.f16879f.a(((Integer) ak.a().d().b(-1)).intValue());
        if (!this.i.equals("-1")) {
            a2.g(this.i);
        }
        DBShopInfo b2 = this.f16879f.b(((Integer) ak.a().i().b(-1)).intValue());
        if (!this.j.equals("-1")) {
            b2.e(this.j);
        }
        b2.a(this.f16877d);
        b2.b(this.f16878e);
        this.f16879f.a(b2);
        this.f16879f.a(a2);
        bu buVar = new bu();
        Shop.Builder builder = new Shop.Builder();
        builder.shopid(Integer.valueOf(b2.b())).name(b2.d()).description(b2.e()).cover(b2.h());
        List<ShopCover> list = this.h;
        if (list != null) {
            if (!list.isEmpty()) {
                ShopExtInfo.Builder builder2 = new ShopExtInfo.Builder();
                builder2.covers(af.a(this.h, new af.b<String, ShopCover>() {
                    /* renamed from: a */
                    public String map(ShopCover shopCover) {
                        return shopCover.image_url;
                    }
                }));
                builder2.shop_covers(this.h);
                builder2.update_shop_covers(true);
                builder.extinfo(f.a(builder2.build().toByteArray()));
            } else {
                ShopExtInfo.Builder builder3 = new ShopExtInfo.Builder();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                builder3.covers(arrayList2);
                arrayList2.add("");
                builder3.shop_covers(arrayList);
                builder3.update_shop_covers(true);
                builder.extinfo(f.a(builder3.build().toByteArray()));
            }
        }
        buVar.a(builder.build(), this.f16880g);
        this.k.a(this.i);
    }
}
