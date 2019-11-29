package com.shopee.app.d.c;

import com.garena.android.appkit.b.a;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.network.g;
import com.shopee.app.ui.home.me.editprofile.e;
import com.shopee.app.util.n;

public class bt extends a {

    /* renamed from: c  reason: collision with root package name */
    private final bh f16626c;

    /* renamed from: d  reason: collision with root package name */
    private final n f16627d;

    /* renamed from: e  reason: collision with root package name */
    private final SettingConfigStore f16628e;

    /* renamed from: f  reason: collision with root package name */
    private int f16629f;

    /* renamed from: g  reason: collision with root package name */
    private int f16630g;
    private g h;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetShopAndUserInfoInteractor";
    }

    protected bt(n nVar, bh bhVar, SettingConfigStore settingConfigStore) {
        super(nVar);
        this.f16627d = nVar;
        this.f16628e = settingConfigStore;
        this.f16626c = bhVar;
    }

    public void a(int i, int i2, g gVar) {
        this.f16629f = i;
        this.f16630g = i2;
        this.h = gVar;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        DBUserInfo a2 = this.f16626c.a(this.f16629f);
        DBShopInfo b2 = this.f16626c.b(this.f16630g);
        if (a2 != null && b2 != null) {
            ShopDetail shopDetail = new ShopDetail();
            b.a(a2, new UserData());
            b.a(b2, a2, shopDetail, this.f16628e);
            this.f16627d.a().aQ.a(shopDetail).a();
            this.f16627d.a("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", (a) new e(a2, b2, shopDetail, this.h));
        }
    }
}
