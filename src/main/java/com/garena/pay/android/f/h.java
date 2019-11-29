package com.garena.pay.android.f;

import android.app.Activity;
import android.view.View;
import com.garena.d.a;
import com.garena.pay.android.c.f;
import com.garena.pay.android.d;
import com.garena.pay.android.f.c;
import java.util.HashMap;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static a f8286a;

    /* renamed from: b  reason: collision with root package name */
    private static c f8287b;

    public interface a {
        void a();

        void a(d dVar);
    }

    public static void a(a aVar) {
        f8286a = aVar;
    }

    public static void a(Activity activity, final HashMap<String, d> hashMap) {
        f8287b = new c(activity);
        f8287b.a(f.a(activity, a.f.txt_choose_provider));
        for (String next : hashMap.keySet()) {
            d dVar = hashMap.get(next);
            if (!f.a(dVar.g())) {
                f8287b.a(dVar.f(), dVar.g(), f.a(activity, a.f.text_pay), (Object) next);
            } else {
                f8287b.a(dVar.f(), dVar.e(), f.a(activity, a.f.text_pay), (Object) next);
            }
        }
        f8287b.a((c.a) new c.a() {
            public void a(Object obj) {
                String str = (String) obj;
                if (str != null && h.f8286a != null) {
                    h.f8286a.a((d) hashMap.get(str));
                }
            }

            public void a() {
                h.f8286a.a();
            }
        });
    }

    public static void a(View view) {
        f8287b.a(8);
        f8287b.a();
        f8287b.a(view);
    }
}
