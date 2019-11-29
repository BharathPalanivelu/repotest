package com.shopee.live.livestreaming.sztracking.base.net;

import com.shopee.live.livestreaming.util.p;
import com.shopee.sdk.b;
import f.b.a.a;
import f.e;
import f.n;

public class SZTrackingNetwork {
    private static n mRetrofit;

    public static n provideRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new n.a().a(b.a().g().a()).a(p.b()).a((e.a) a.a()).a((e.a) f.b.b.a.a(com.google.c.p.d())).a();
        }
        return mRetrofit;
    }
}
