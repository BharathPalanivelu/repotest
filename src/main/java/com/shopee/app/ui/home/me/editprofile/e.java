package com.shopee.app.ui.home.me.editprofile;

import com.garena.android.appkit.b.a;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.network.g;

public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public DBUserInfo f22353a;

    /* renamed from: b  reason: collision with root package name */
    public DBShopInfo f22354b;

    /* renamed from: c  reason: collision with root package name */
    public ShopDetail f22355c;

    /* renamed from: d  reason: collision with root package name */
    public g f22356d;

    public e(DBUserInfo dBUserInfo, DBShopInfo dBShopInfo, ShopDetail shopDetail, g gVar) {
        this.f22353a = dBUserInfo;
        this.f22354b = dBShopInfo;
        this.f22355c = shopDetail;
        this.f22356d = gVar;
    }
}
