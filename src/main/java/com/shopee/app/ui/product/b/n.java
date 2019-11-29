package com.shopee.app.ui.product.b;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.shopee.app.network.http.data.ListingConfig;
import com.shopee.app.ui.product.b.a.a;
import com.shopee.app.ui.product.b.a.b;
import com.shopee.app.ui.product.b.a.c;
import com.shopee.app.ui.product.b.a.d;
import com.shopee.app.ui.product.b.a.h;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.f;
import com.shopee.app.util.q.g;
import d.d.b.j;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final ListingConfig f24403a;

    public n(ListingConfig listingConfig) {
        j.b(listingConfig, "listingConfig");
        this.f24403a = listingConfig;
    }

    public final f a(e.C0408e eVar) {
        j.b(eVar, TouchesHelper.TARGET_KEY);
        g a2 = g.f26495b.a(eVar, this.f24403a);
        if (a2 instanceof a) {
            return new f((a) a2);
        }
        if (a2 instanceof b) {
            return new g((b) a2);
        }
        if (a2 instanceof c) {
            return new h((c) a2);
        }
        if (a2 instanceof d) {
            return new i((d) a2);
        }
        if (a2 instanceof com.shopee.app.ui.product.b.a.e) {
            return new j((com.shopee.app.ui.product.b.a.e) a2);
        }
        if (a2 instanceof com.shopee.app.ui.product.b.a.f) {
            return new k((com.shopee.app.ui.product.b.a.f) a2);
        }
        if (a2 instanceof com.shopee.app.ui.product.b.a.g) {
            return new l((com.shopee.app.ui.product.b.a.g) a2);
        }
        if (a2 instanceof h) {
            return new m((h) a2);
        }
        return null;
    }
}
