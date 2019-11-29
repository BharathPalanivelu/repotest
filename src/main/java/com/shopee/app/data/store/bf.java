package com.shopee.app.data.store;

import android.content.SharedPreferences;
import android.util.Pair;
import c.a.a.a.b;
import c.a.a.a.c;
import com.google.a.c.a;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.data.viewmodel.ChatCounter;
import com.shopee.app.data.viewmodel.RedDotData;
import com.shopee.app.util.ad;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class bf extends ay {

    /* renamed from: a  reason: collision with root package name */
    private ad<Map<Integer, ChatCounter.ChatCount>> f17262a = new ad<>(this.mPref, "unread_chat1", ServiceLogger.PLACEHOLDER, new a<Map<Integer, ChatCounter.ChatCount>>() {
    });

    /* renamed from: b  reason: collision with root package name */
    private ad<Set<Long>> f17263b = new ad<>(this.mPref, "unread_activity", "[]", new a<Set<Long>>() {
    });

    /* renamed from: c  reason: collision with root package name */
    private c.a.a.a.a f17264c = new c.a.a.a.a(this.mPref, "unread_dot_activity", false);

    /* renamed from: d  reason: collision with root package name */
    private b f17265d = new b(this.mPref, "cart_item_counter", 0);

    /* renamed from: e  reason: collision with root package name */
    private c f17266e = new c(this.mPref, "coin_count_counter", 0);

    /* renamed from: f  reason: collision with root package name */
    private ad<Set<Long>> f17267f = new ad<>(this.mPref, "unread_follow", "[]", new a<Set<Long>>() {
    });

    /* renamed from: g  reason: collision with root package name */
    private c.a.a.a.a f17268g = new c.a.a.a.a(this.mPref, "unread_dot_follow", false);
    private ad<Set<Pair<Long, Integer>>> h = new ad<>(this.mPref, "unread_action_required_v2", "[]", new a<Set<Pair<Long, Integer>>>() {
    });
    private ad<RedDotData> i = new ad<>(this.mPref, "feed_red_dot_data", ServiceLogger.PLACEHOLDER, new a<RedDotData>() {
    });

    public bf(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public Map<Integer, ChatCounter.ChatCount> a() {
        Map<Integer, ChatCounter.ChatCount> a2 = this.f17262a.a();
        return a2 == null ? new HashMap() : a2;
    }

    public void a(Map<Integer, ChatCounter.ChatCount> map) {
        this.f17262a.a(map);
    }

    public Set<Long> b() {
        Set<Long> a2 = this.f17263b.a();
        return a2 == null ? new HashSet() : a2;
    }

    public void a(Set<Long> set) {
        this.f17263b.a(set);
    }

    public boolean c() {
        return this.f17264c.a();
    }

    public void a(boolean z) {
        this.f17264c.a(z);
    }

    public Set<Pair<Long, Integer>> d() {
        Set<Pair<Long, Integer>> a2 = this.h.a();
        return a2 == null ? new HashSet() : a2;
    }

    public void b(Set<Pair<Long, Integer>> set) {
        this.h.a(set);
    }

    public Set<Long> e() {
        Set<Long> a2 = this.f17267f.a();
        return a2 == null ? new HashSet() : a2;
    }

    public void c(Set<Long> set) {
        this.f17267f.a(set);
    }

    public boolean f() {
        return this.f17268g.a();
    }

    public void b(boolean z) {
        this.f17268g.a(z);
    }

    public int g() {
        return this.f17265d.a();
    }

    public void a(int i2) {
        this.f17265d.a(i2);
    }

    public long h() {
        return this.f17266e.a();
    }

    public void a(long j) {
        this.f17266e.a(j);
    }

    public void a(RedDotData redDotData) {
        this.i.a(redDotData);
    }

    public RedDotData i() {
        return this.i.a();
    }
}
