package com.shopee.app.data.store.c;

import android.content.SharedPreferences;
import c.a.a.a.d;
import com.google.a.c.a;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.ay;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.util.an;
import com.shopee.app.web.WebRegister;
import java.util.List;

public class b extends ay {
    public b() {
        super(ar.a().getSharedPreferences(a(), 0));
    }

    public List<Long> a(int i) {
        SharedPreferences sharedPreferences = this.mPref;
        return a(new d(sharedPreferences, "u_" + i, "[]").a());
    }

    public void a(int i, List<Long> list) {
        SharedPreferences sharedPreferences = this.mPref;
        new d(sharedPreferences, "u_" + i, "[]").a(a(list));
    }

    public void b(int i, List<Long> list) {
        if (list != null && !list.isEmpty()) {
            SharedPreferences sharedPreferences = this.mPref;
            d dVar = new d(sharedPreferences, "u_" + i, "[]");
            List<Long> a2 = a(dVar.a());
            a2.addAll(list);
            dVar.a(a(a2));
        }
    }

    public List<Long> b(int i) {
        SharedPreferences sharedPreferences = this.mPref;
        return a(new d(sharedPreferences, "s_" + i, "[]").a());
    }

    public void c(int i, List<Long> list) {
        SharedPreferences sharedPreferences = this.mPref;
        new d(sharedPreferences, "s_" + i, "[]").a(a(list));
    }

    public void d(int i, List<Long> list) {
        if (list != null && !list.isEmpty()) {
            SharedPreferences sharedPreferences = this.mPref;
            d dVar = new d(sharedPreferences, "s_" + i, "[]");
            List<Long> a2 = a(dVar.a());
            a2.addAll(list);
            dVar.a(a(a2));
        }
    }

    public List<Long> a(OrderKey orderKey) {
        return a(new d(this.mPref, orderKey.getKey(), "[]").a());
    }

    public void a(OrderKey orderKey, List<Long> list) {
        new d(this.mPref, orderKey.getKey(), "[]").a(a(list));
    }

    public void b(OrderKey orderKey, List<Long> list) {
        if (list != null && !list.isEmpty()) {
            d dVar = new d(this.mPref, orderKey.getKey(), "[]");
            List<Long> a2 = a(dVar.a());
            a2.addAll(list);
            dVar.a(a(a2));
        }
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
            if (a2.size() > 0) {
                a2.remove(Long.valueOf(j));
                dVar.a(a(a2));
            }
        }
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
        return "order_id_list_" + ak.a().d().b(-1);
    }
}
