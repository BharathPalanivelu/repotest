package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.google.a.c.a;
import com.shopee.app.util.ad;
import com.shopee.app.util.af;
import java.util.ArrayList;
import java.util.List;

public class d extends ay {

    /* renamed from: a  reason: collision with root package name */
    private ad<List<Integer>> f17294a;

    /* renamed from: b  reason: collision with root package name */
    private ad<List<Integer>> f17295b;

    public d(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f17294a = new ad<>(sharedPreferences, "all_id_list", "[]", new a<List<Integer>>() {
        });
        this.f17295b = new ad<>(sharedPreferences, "cmt_id_list", "[]", new a<List<Integer>>() {
        });
    }

    public void a(int i) {
        a(c(i));
    }

    public void a(List<Integer> list, int i) {
        a(list, c(i));
    }

    private void a(List<Integer> list, ad<List<Integer>> adVar) {
        try {
            final List a2 = adVar.a();
            a2.addAll(af.a(list, new af.a<Integer>() {
                /* renamed from: a */
                public boolean shouldInclude(Integer num) {
                    return !a2.contains(num);
                }
            }));
            adVar.a(a2);
        } catch (Exception unused) {
            adVar.a(new ArrayList());
        }
    }

    private void a(ad<List<Integer>> adVar) {
        adVar.a(new ArrayList());
    }

    private ad<List<Integer>> c(int i) {
        if (i != 4) {
            return this.f17294a;
        }
        return this.f17295b;
    }

    public List<Integer> b(int i) {
        return c(i).a();
    }
}
