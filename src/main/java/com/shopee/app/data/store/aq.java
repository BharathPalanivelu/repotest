package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.garena.android.appkit.d.a;
import com.shopee.app.util.j.b;
import java.util.List;

public class aq extends ay {

    /* renamed from: a  reason: collision with root package name */
    private b<String> f17195a;

    public aq(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        a.b("preference:" + sharedPreferences + " preference as String:" + sharedPreferences.toString(), new Object[0]);
        this.f17195a = new b<>(sharedPreferences, "pending_notification_list", new com.google.a.c.a<List<String>>() {
        });
    }

    public void a(List<String> list) {
        this.f17195a.c();
        if (list != null && !list.isEmpty()) {
            if (list.size() <= 20) {
                this.f17195a.a(list);
            } else {
                this.f17195a.a(list.subList(list.size() - 20, list.size()));
            }
        }
    }

    public List<String> a() {
        return (List) this.f17195a.a();
    }
}
