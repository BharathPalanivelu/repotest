package com.shopee.feeds.feedlibrary;

import android.content.Context;
import com.shopee.feeds.feedlibrary.c.a;
import com.shopee.sdk.d.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f27570a;

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (b.class) {
            if (f27570a == null) {
                f27570a = new a(context);
            }
            aVar = f27570a;
        }
        return aVar;
    }

    public static c a() {
        c cVar = new c("FeedRouter");
        cVar.a(new com.shopee.feeds.feedlibrary.c.b());
        cVar.a(new a());
        return cVar;
    }

    public static a b() {
        return f27570a;
    }
}
