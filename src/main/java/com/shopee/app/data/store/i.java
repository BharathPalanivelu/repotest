package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.google.a.c.a;
import com.shopee.app.util.ad;
import com.shopee.app.util.af;
import java.util.ArrayList;
import java.util.List;

public abstract class i extends ay {

    /* renamed from: a  reason: collision with root package name */
    private ad<List<Long>> f17308a;

    protected i(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f17308a = new ad<>(sharedPreferences, "id_list", "[]", new a<List<Long>>() {
        });
    }

    public void a(List<Long> list) {
        try {
            final List<Long> b2 = b();
            b2.addAll(af.a(list, new af.a<Long>() {
                /* renamed from: a */
                public boolean shouldInclude(Long l) {
                    return !b2.contains(l);
                }
            }));
            this.f17308a.a(b2);
        } catch (Exception unused) {
            this.f17308a.a(new ArrayList());
        }
    }

    public void a(Long l) {
        List<Long> b2 = b();
        if (b2.contains(l)) {
            b2.remove(l);
            this.f17308a.a(b2);
        }
    }

    public void a() {
        this.f17308a.a(new ArrayList());
    }

    public List<Long> b() {
        return this.f17308a.a();
    }
}
