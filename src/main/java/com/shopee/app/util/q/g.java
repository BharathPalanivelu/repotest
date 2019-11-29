package com.shopee.app.util.q;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.shopee.app.network.http.data.ListingConfig;
import com.shopee.app.ui.product.b.a.b;
import com.shopee.app.ui.product.b.a.c;
import com.shopee.app.ui.product.b.a.d;
import com.shopee.app.ui.product.b.a.f;
import com.shopee.app.ui.product.b.a.h;
import com.shopee.app.util.q.e;
import d.d.b.j;

public interface g {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26495b = a.f26496a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f26496a = new a();

        private a() {
        }

        public final g a(e.C0408e eVar, ListingConfig listingConfig) {
            g gVar;
            j.b(eVar, TouchesHelper.TARGET_KEY);
            j.b(listingConfig, "listingConfig");
            try {
                switch (h.f26497a[eVar.ordinal()]) {
                    case 1:
                        gVar = com.shopee.app.ui.product.b.a.a.f24354a.a(listingConfig);
                        break;
                    case 2:
                        gVar = b.f24356a.a(listingConfig);
                        break;
                    case 3:
                        gVar = c.f24358a.a(listingConfig);
                        break;
                    case 4:
                        gVar = d.f24361a.a(listingConfig);
                        break;
                    case 5:
                        gVar = com.shopee.app.ui.product.b.a.e.f24366a.a(listingConfig);
                        break;
                    case 6:
                        gVar = f.f24370a.a(listingConfig);
                        break;
                    case 7:
                        gVar = com.shopee.app.ui.product.b.a.g.f24373a.a(listingConfig);
                        break;
                    case 8:
                        gVar = h.f24376a.a(listingConfig);
                        break;
                    default:
                        return null;
                }
                return gVar;
            } catch (Exception e2) {
                Throwable th = e2;
                com.garena.android.appkit.d.a.a(th);
                com.garena.b.a.a.a("Invalid Listing Config::" + eVar.name(), th);
                return null;
            }
        }
    }
}
