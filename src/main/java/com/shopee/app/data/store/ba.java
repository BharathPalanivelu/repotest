package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.google.a.c.a;
import com.shopee.app.util.ad;
import com.shopee.app.util.k.g;
import java.util.ArrayList;
import java.util.List;

public class ba extends ay {

    /* renamed from: a  reason: collision with root package name */
    ad<List<String>> f17240a;

    public ba(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f17240a = new ad<>(sharedPreferences, "product_upload_list", "[]", new a<List<String>>() {
        });
    }

    public synchronized List<g> a() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f17240a.a()) {
            g a2 = g.a(str);
            if (a2 != null) {
                arrayList.add(a2);
                arrayList2.add(str);
            }
        }
        this.f17240a.a(arrayList2);
        return arrayList;
    }

    public void a(List<g> list) {
        com.garena.android.appkit.d.a.a("saving product", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (g a2 : list) {
            arrayList.add(g.a(a2));
        }
        this.f17240a.a(arrayList);
    }

    public synchronized void a(g gVar) {
        com.garena.android.appkit.d.a.a("updating product", new Object[0]);
        List<g> a2 = a();
        ArrayList arrayList = new ArrayList();
        for (g next : a2) {
            if (next.requestId.equals(gVar.requestId)) {
                arrayList.add(gVar);
            } else {
                arrayList.add(next);
            }
        }
        a((List<g>) arrayList);
    }

    public synchronized void b(g gVar) {
        com.garena.android.appkit.d.a.a("discarding product", new Object[0]);
        List<g> a2 = a();
        ArrayList arrayList = new ArrayList();
        for (g next : a2) {
            if (!next.requestId.equals(gVar.requestId)) {
                arrayList.add(next);
            }
        }
        a((List<g>) arrayList);
    }
}
