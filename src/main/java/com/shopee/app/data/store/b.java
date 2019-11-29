package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.google.a.c.a;
import com.shopee.app.util.j.c;
import java.util.List;
import java.util.Map;

public class b extends ay {

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.app.util.j.b<Long> f17220a;

    /* renamed from: b  reason: collision with root package name */
    private com.shopee.app.util.j.b<Long> f17221b;

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.app.util.j.b<Long> f17222c;

    /* renamed from: d  reason: collision with root package name */
    private com.shopee.app.util.j.b<Long> f17223d;

    /* renamed from: e  reason: collision with root package name */
    private com.shopee.app.util.j.b<Long> f17224e;

    /* renamed from: f  reason: collision with root package name */
    private com.shopee.app.util.j.b<Long> f17225f;

    /* renamed from: g  reason: collision with root package name */
    private com.shopee.app.util.j.b<Long> f17226g;
    private com.shopee.app.util.j.b<Long> h;
    private com.shopee.app.util.j.b<Long> i;
    private com.shopee.app.util.j.b<Long> j;
    private com.shopee.app.util.j.b<Long> k;
    private c<Integer, Long> l;

    public b(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f17220a = new com.shopee.app.util.j.b<>(sharedPreferences, "ab_order_list", new a<List<Long>>() {
        });
        this.f17221b = new com.shopee.app.util.j.b<>(sharedPreferences, "ab_promo_list", new a<List<Long>>() {
        });
        this.f17222c = new com.shopee.app.util.j.b<>(sharedPreferences, "ab_stock_list", new a<List<Long>>() {
        });
        this.l = new c<>(sharedPreferences, "ab_probe_map", new a<Map<Integer, Long>>() {
        });
        this.f17223d = new com.shopee.app.util.j.b<>(sharedPreferences, "ab_wallet_updates", new a<List<Long>>() {
        });
        this.f17224e = new com.shopee.app.util.j.b<>(sharedPreferences, "ab_imp_updates", new a<List<Long>>() {
        });
        this.f17225f = new com.shopee.app.util.j.b<>(sharedPreferences, "ab_rating_updates", new a<List<Long>>() {
        });
        this.f17226g = new com.shopee.app.util.j.b<>(sharedPreferences, "ab_paid_ads", new a<List<Long>>() {
        });
        this.h = new com.shopee.app.util.j.b<>(sharedPreferences, "ab_feeds", new a<List<Long>>() {
        });
        this.i = new com.shopee.app.util.j.b<>(sharedPreferences, "ab_foody_now", new a<List<Long>>() {
        });
        this.j = new com.shopee.app.util.j.b<>(sharedPreferences, "ab_discuss_msg", new a<List<Long>>() {
        });
        this.k = new com.shopee.app.util.j.b<>(sharedPreferences, "ab_paylater", new a<List<Long>>() {
        });
    }

    public long a(int i2) {
        return com.shopee.app.d.b.b.a(this.l.b(Integer.valueOf(i2)));
    }

    public void a(int i2, long j2) {
        this.l.a(Integer.valueOf(i2), Long.valueOf(j2));
    }

    public void a(List<Long> list, int i2) {
        e(i2).b(list);
    }

    public void b(int i2) {
        e(i2).c();
    }

    public List<Long> c(int i2) {
        return (List) e(i2).a();
    }

    private com.shopee.app.util.j.b<Long> e(int i2) {
        if (i2 == 1) {
            return this.f17221b;
        }
        if (i2 == 2) {
            return this.f17222c;
        }
        switch (i2) {
            case 6:
                return this.f17224e;
            case 7:
                return this.f17225f;
            case 8:
                return this.f17223d;
            case 9:
                return this.f17226g;
            case 10:
                return this.h;
            case 11:
                return this.i;
            case 12:
                return this.j;
            case 13:
                return this.k;
            default:
                return this.f17220a;
        }
    }

    public boolean d(int i2) {
        if (i2 == 4) {
            return true;
        }
        return !(this.f17220a == e(i2));
    }
}
