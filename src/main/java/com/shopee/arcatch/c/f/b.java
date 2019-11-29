package com.shopee.arcatch.c.f;

import android.content.Context;
import com.shopee.arcatch.b.c.e;
import com.shopee.e.a.a;
import com.shopee.sdk.d.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f7056a;

    /* renamed from: b  reason: collision with root package name */
    private static int f7057b;

    public static int a() {
        return f7057b;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (b.class) {
            if (f7056a == null) {
                f7056a = new a(context.getApplicationContext());
                f7057b = e.c(context);
                a.a(context);
            }
            aVar = f7056a;
        }
        return aVar;
    }

    public static a b() {
        return f7056a;
    }

    public static c c() {
        c cVar = new c("ArCatchRouter");
        cVar.a(new c());
        return cVar;
    }
}
