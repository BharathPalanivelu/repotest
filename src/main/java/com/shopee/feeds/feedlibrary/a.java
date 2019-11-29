package com.shopee.feeds.feedlibrary;

import android.content.Context;
import com.shopee.feeds.feedlibrary.a.b.c;
import com.shopee.feeds.feedlibrary.data.d.b;

public class a extends com.shopee.sdk.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static int f27286a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f27287b;

    /* renamed from: c  reason: collision with root package name */
    private b f27288c;

    public a(Context context) {
        super(context);
        this.f27287b = context;
        c.a(context);
    }

    public b a() {
        if (this.f27288c == null) {
            this.f27288c = new b(this.f27287b.getSharedPreferences("feed_module_store", 0));
        }
        return this.f27288c;
    }

    public com.shopee.feeds.feedlibrary.util.b.b b() {
        return com.shopee.feeds.feedlibrary.util.b.b.a(this.f27287b);
    }

    public Context c() {
        return this.f27287b;
    }
}
