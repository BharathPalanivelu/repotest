package com.garena.pay.android.f;

import android.app.Activity;
import android.view.View;
import com.garena.d.a;
import com.garena.pay.android.a.b;
import com.garena.pay.android.a.e;
import com.garena.pay.android.c.f;
import com.garena.pay.android.f.c;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static C0141a f8258a;

    /* renamed from: b  reason: collision with root package name */
    static c f8259b;

    /* renamed from: com.garena.pay.android.f.a$a  reason: collision with other inner class name */
    public interface C0141a {
        void a();

        void a(b.a aVar);
    }

    public static void a(Activity activity, final List<b.a> list, e eVar) {
        f8259b = new c(activity);
        int i = 0;
        f8259b.a(String.format(f.a(activity, a.f.s_picker_header_text), new Object[]{eVar.a()}));
        for (b.a next : list) {
            d dVar = new d();
            dVar.f8278e = next.e();
            dVar.f8276c = next.d();
            dVar.f8280g = Integer.valueOf(i);
            dVar.f8279f = next.a();
            dVar.f8274a = next.f();
            dVar.f8275b = next.g();
            f8259b.a((e) dVar);
            i++;
        }
        f8259b.a((c.a) new c.a() {
            public void a(Object obj) {
                Integer num = (Integer) obj;
                if (num.intValue() <= list.size() && a.f8258a != null) {
                    a.f8258a.a((b.a) list.get(num.intValue()));
                }
            }

            public void a() {
                a.f8258a.a();
            }
        });
    }

    public static void a(View view) {
        f8259b.a(8);
        f8259b.a();
        f8259b.a(view);
    }

    public static void a(C0141a aVar) {
        f8258a = aVar;
    }
}
