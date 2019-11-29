package com.shopee.app.data.store;

import c.a.a.a.d;
import com.google.a.c.a;
import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.util.an;
import com.shopee.app.web.WebRegister;
import java.util.List;

public class at extends ay {
    public at() {
        super(ar.a().getSharedPreferences(a(), 0));
    }

    public List<Long> a(OrderKey orderKey) {
        return a(new d(this.mPref, orderKey.getKey(), "[]").a());
    }

    public void a(OrderKey orderKey, List<Long> list) {
        new d(this.mPref, orderKey.getKey(), "[]").a(a(list));
    }

    public void a(OrderKey orderKey, long j) {
        d dVar = new d(this.mPref, orderKey.getKey(), "[]");
        List<Long> a2 = a(dVar.a());
        if (!a2.contains(Long.valueOf(j))) {
            a2.add(0, Long.valueOf(j));
        }
        dVar.a(a(a2));
    }

    public void a(boolean z, long j) {
        for (Integer intValue : an.f26158a) {
            d dVar = new d(this.mPref, new OrderKey(z, intValue.intValue()).getKey(), "[]");
            List<Long> a2 = a(dVar.a());
            a2.remove(Long.valueOf(j));
            dVar.a(a(a2));
        }
    }

    public void b(OrderKey orderKey, long j) {
        d dVar = new d(this.mPref, orderKey.getKey(), "[]");
        List<Long> a2 = a(dVar.a());
        a2.remove(Long.valueOf(j));
        dVar.a(a(a2));
    }

    private String a(List<Long> list) {
        return WebRegister.GSON.b(list, new a<List<Long>>() {
        }.getType());
    }

    private List<Long> a(String str) {
        return (List) WebRegister.GSON.a(str, new a<List<Long>>() {
        }.getType());
    }

    public static String a() {
        return "order_noti_list_" + ak.a().d().b(-1);
    }
}
