package com.shopee.feeds.feedlibrary.b;

import android.content.Context;
import com.shopee.feeds.feedlibrary.a.a;
import com.shopee.feeds.feedlibrary.data.c.e;
import com.shopee.feeds.feedlibrary.data.entity.FollowingEntity;
import com.shopee.feeds.feedlibrary.util.u;

public class d extends a<com.shopee.feeds.feedlibrary.view.a.d> {

    /* renamed from: b  reason: collision with root package name */
    Context f27587b;

    /* renamed from: c  reason: collision with root package name */
    e f27588c;

    public d(Context context) {
        this.f27587b = context;
        this.f27588c = new e(context);
    }

    public void a(final String str, int i) {
        this.f27588c.a(str, i, false, 3, new a() {
            public void a(Object obj, String str) {
                FollowingEntity followingEntity = (FollowingEntity) obj;
                if (d.this.a() != null) {
                    ((com.shopee.feeds.feedlibrary.view.a.d) d.this.a()).a(str, followingEntity);
                }
            }

            public void a(String str) {
                if (!com.shopee.feeds.feedlibrary.util.d.a(str)) {
                    u.a(d.this.f27587b, str);
                }
            }
        });
    }
}
