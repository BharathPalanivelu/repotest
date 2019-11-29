package com.shopee.sdk;

import com.shopee.sdk.d.c;
import com.shopee.sdk.modules.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f30336a;

    /* renamed from: b  reason: collision with root package name */
    private static List<c> f30337b;

    /* renamed from: c  reason: collision with root package name */
    private static com.shopee.sdk.c.b f30338c;

    public static a a() {
        return f30336a;
    }

    public static void a(a aVar) {
        f30336a = aVar;
    }

    public static List<c> b() {
        return f30337b;
    }

    public static void a(c cVar) {
        if (f30337b == null) {
            f30337b = new ArrayList();
        }
        f30337b.add(cVar);
    }

    public static synchronized com.shopee.sdk.c.b c() {
        com.shopee.sdk.c.b bVar;
        synchronized (b.class) {
            if (f30338c == null) {
                f30338c = new com.shopee.sdk.c.b(Executors.newSingleThreadExecutor());
            }
            bVar = f30338c;
        }
        return bVar;
    }
}
