package com.shopee.livequiz;

import android.content.Context;
import com.shopee.livequiz.b.c;

public class a extends com.shopee.sdk.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static int f29668a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f29669b;

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.livequiz.data.b.a f29670c;

    public a(Context context) {
        super(context);
        this.f29669b = context;
    }

    public com.shopee.livequiz.data.b.a a() {
        if (this.f29670c == null) {
            this.f29670c = new com.shopee.livequiz.data.b.a(this.f29669b.getSharedPreferences("game_model", 0));
        }
        return this.f29670c;
    }

    public c b() {
        return c.a(this.f29669b);
    }

    public Context c() {
        return this.f29669b;
    }
}
