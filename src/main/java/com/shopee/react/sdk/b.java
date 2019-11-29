package com.shopee.react.sdk;

import com.facebook.react.ReactInstanceManager;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static b f30171c;

    /* renamed from: a  reason: collision with root package name */
    private boolean f30172a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f30173b;

    /* renamed from: d  reason: collision with root package name */
    private ReactInstanceManager f30174d;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            d();
            bVar = f30171c;
        }
        return bVar;
    }

    private static void d() {
        b bVar = f30171c;
        if (bVar == null || !bVar.f30172a) {
            throw new RuntimeException("Need to call ReactSDK.init() first");
        }
    }

    public ReactInstanceManager b() {
        return this.f30174d;
    }

    public boolean c() {
        return this.f30173b;
    }
}
