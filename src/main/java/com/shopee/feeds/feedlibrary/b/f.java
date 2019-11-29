package com.shopee.feeds.feedlibrary.b;

import android.content.Context;
import com.shopee.feeds.feedlibrary.a.a;
import com.shopee.feeds.feedlibrary.data.c.g;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.u;

public class f extends a<com.shopee.feeds.feedlibrary.view.a.f> {

    /* renamed from: b  reason: collision with root package name */
    Context f27596b;

    /* renamed from: c  reason: collision with root package name */
    g f27597c;

    public f(Context context) {
        this.f27596b = context;
        this.f27597c = new g(context);
    }

    public void a(String str, int i, int i2) {
        if (str.equals("seller_product")) {
            a(i, i2);
        } else if (str.equals("kol_like_product")) {
            b(i, i2);
        } else if (str.equals("kol_scan_product")) {
            c(i, i2);
        }
    }

    public void a(final int i, int i2) {
        this.f27597c.c(i, i2, 3, false, new a() {
            public void a(Object obj, String str) {
                f.this.a(i, obj);
            }

            public void a(String str) {
                f.this.a(i, str);
            }
        });
    }

    public void b(final int i, int i2) {
        this.f27597c.a(i, i2, 3, false, new a() {
            public void a(Object obj, String str) {
                f.this.a(i, obj);
            }

            public void a(String str) {
                f.this.a(i, str);
            }
        });
    }

    public void c(final int i, int i2) {
        this.f27597c.b(i, i2, 3, false, new a() {
            public void a(Object obj, String str) {
                f.this.a(i, obj);
            }

            public void a(String str) {
                f.this.a(i, str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i, Object obj) {
        ProductEntity productEntity = (ProductEntity) obj;
        if (productEntity != null && a() != null) {
            ((com.shopee.feeds.feedlibrary.view.a.f) a()).a(productEntity, i);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, String str) {
        if (!d.a(str)) {
            u.a(this.f27596b, str);
        }
        if (a() != null) {
            ((com.shopee.feeds.feedlibrary.view.a.f) a()).a(i);
        }
    }
}
