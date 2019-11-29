package com.shopee.app.data.store.c;

import android.content.SharedPreferences;
import c.a.a.a.b;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.data.store.ay;
import com.shopee.app.data.viewmodel.order.BuyerOrderCountItem;
import com.shopee.app.data.viewmodel.order.SellerOrderCountItem;
import com.shopee.app.util.ad;

public class a extends ay {

    /* renamed from: a  reason: collision with root package name */
    private ad<BuyerOrderCountItem> f17278a;

    /* renamed from: b  reason: collision with root package name */
    private ad<SellerOrderCountItem> f17279b;

    /* renamed from: c  reason: collision with root package name */
    private b f17280c;

    /* renamed from: d  reason: collision with root package name */
    private b f17281d;

    public a(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f17278a = new ad<>(sharedPreferences, "buyer_order_count_item", ServiceLogger.PLACEHOLDER, com.google.a.c.a.get(BuyerOrderCountItem.class));
        this.f17279b = new ad<>(sharedPreferences, "seller_order_count_item", ServiceLogger.PLACEHOLDER, com.google.a.c.a.get(SellerOrderCountItem.class));
        this.f17280c = new b(sharedPreferences, "group_buy_unpaid_order_count", 0);
        this.f17281d = new b(sharedPreferences, "group_buy_ongoing_order_count", 0);
    }

    public void a(BuyerOrderCountItem buyerOrderCountItem) {
        this.f17278a.a(buyerOrderCountItem);
    }

    public BuyerOrderCountItem a() {
        return this.f17278a.a();
    }

    public void a(SellerOrderCountItem sellerOrderCountItem) {
        this.f17279b.a(sellerOrderCountItem);
    }

    public SellerOrderCountItem b() {
        return this.f17279b.a();
    }

    public void a(int i) {
        this.f17280c.a(i);
    }

    public int c() {
        return this.f17280c.a();
    }

    public void b(int i) {
        this.f17281d.a(i);
    }

    public int d() {
        return this.f17281d.a();
    }
}
