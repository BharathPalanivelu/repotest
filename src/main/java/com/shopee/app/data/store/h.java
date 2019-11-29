package com.shopee.app.data.store;

import android.content.SharedPreferences;
import c.a.a.a.b;
import com.google.a.c.a;
import com.shopee.app.data.viewmodel.BannerData;
import com.shopee.app.data.viewmodel.RecommendBannerData;
import com.shopee.app.util.ad;
import java.util.List;

public class h extends ay {

    /* renamed from: a  reason: collision with root package name */
    private ad<List<BannerData>> f17303a;

    /* renamed from: b  reason: collision with root package name */
    private ad<List<RecommendBannerData>> f17304b;

    /* renamed from: c  reason: collision with root package name */
    private b f17305c;

    public h(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f17303a = new ad<>(sharedPreferences, "activity_banners", "[]", new a<List<BannerData>>() {
        });
        this.f17304b = new ad<>(sharedPreferences, "recommend_banners", "[]", new a<List<RecommendBannerData>>() {
        });
        this.f17305c = new b(sharedPreferences, "last_sync_time");
    }

    public void a(List<BannerData> list) {
        this.f17303a.a(list);
    }

    public void b(List<RecommendBannerData> list) {
        this.f17304b.a(list);
    }

    public List<RecommendBannerData> a() {
        return this.f17304b.a();
    }

    public int b() {
        return this.f17305c.a();
    }

    public void c() {
        this.f17305c.a(com.garena.android.appkit.tools.a.a.a());
    }
}
