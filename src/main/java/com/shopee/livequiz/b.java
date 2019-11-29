package com.shopee.livequiz;

import android.content.Context;
import com.shopee.livequiz.e.a;
import com.shopee.sdk.d.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f29675a;

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (b.class) {
            if (f29675a == null) {
                f29675a = new a(context);
            }
            aVar = f29675a;
        }
        return aVar;
    }

    public static a a() {
        return f29675a;
    }

    public static c b() {
        c cVar = new c("LiveQuizRouter");
        cVar.a(new a());
        return cVar;
    }
}
