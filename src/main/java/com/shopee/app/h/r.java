package com.shopee.app.h;

import android.widget.Toast;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static r f17697a = new r();

    public static r a() {
        return f17697a;
    }

    private r() {
    }

    public void a(final String str) {
        f.a().a(new Runnable() {
            public void run() {
                a.e("BBToastManager:%s", str);
                Toast.makeText(ar.a(), str, 0).show();
            }
        });
    }

    public void b(final String str) {
        f.a().a(new Runnable() {
            public void run() {
                Toast.makeText(ar.a(), str, 0).show();
            }
        });
    }

    public void a(int i) {
        b(b.e(i));
    }

    public void b(int i) {
        a(b.e(i));
    }
}
