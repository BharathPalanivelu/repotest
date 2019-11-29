package com.shopee.feeds.feedlibrary.b;

import android.content.Context;
import com.shopee.feeds.feedlibrary.data.c.h;
import com.shopee.feeds.feedlibrary.data.e.a;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.SearchUserEntity;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.u;

public class e extends a<com.shopee.feeds.feedlibrary.view.a.e> {

    /* renamed from: b  reason: collision with root package name */
    Context f27591b;

    /* renamed from: c  reason: collision with root package name */
    private h f27592c;

    public e(Context context) {
        this.f27591b = context;
        this.f27592c = new h(context);
    }

    public String a(a aVar) {
        return this.f27592c.a(aVar);
    }

    public void a(String str, String str2, int i, int i2, int i3, final String str3) {
        this.f27592c.a(str, str2, i, i2, i3, false, 3, new com.shopee.feeds.feedlibrary.a.a() {
            public void a(Object obj, String str) {
                ProductEntity productEntity = (ProductEntity) obj;
                if (productEntity != null && e.this.a() != null) {
                    ((com.shopee.feeds.feedlibrary.view.a.e) e.this.a()).a(productEntity, str3);
                }
            }

            public void a(String str) {
                if (!d.a(str)) {
                    u.a(e.this.f27591b, str);
                }
                ((com.shopee.feeds.feedlibrary.view.a.e) e.this.a()).b(str3);
            }
        });
    }

    public void a(String str, int i, int i2, int i3) {
        this.f27592c.a(str, i, i2, i3, false, 3, new com.shopee.feeds.feedlibrary.a.a() {
            public void a(Object obj, String str) {
                SearchUserEntity searchUserEntity = (SearchUserEntity) obj;
                if (searchUserEntity != null && e.this.a() != null) {
                    ((com.shopee.feeds.feedlibrary.view.a.e) e.this.a()).a(searchUserEntity, "");
                }
            }

            public void a(String str) {
                if (!d.a(str)) {
                    u.a(e.this.f27591b, str);
                }
                ((com.shopee.feeds.feedlibrary.view.a.e) e.this.a()).b("");
            }
        });
    }
}
