package com.shopee.app.network.d.i;

import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.SearchHint;
import com.squareup.wire.Message;

public abstract class a extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f18417a;

    /* renamed from: b  reason: collision with root package name */
    private int f18418b;

    /* renamed from: c  reason: collision with root package name */
    private int f18419c;

    /* renamed from: d  reason: collision with root package name */
    private int f18420d;

    public int b() {
        return 66;
    }

    public abstract int c();

    public Integer e() {
        return null;
    }

    public String j() {
        return null;
    }

    public void a(String str, int i, int i2, int i3) {
        this.f18417a = str;
        this.f18418b = i;
        this.f18419c = i2;
        this.f18420d = i3;
        g();
    }

    public String d() {
        return this.f18417a;
    }

    public Message q_() {
        SearchHint.Builder builder = new SearchHint.Builder();
        builder.requestid(i().a()).type(Integer.valueOf(c())).limit(Integer.valueOf(this.f18419c)).keyword(this.f18417a).match_type(e()).match_value(j()).country("ID").version(2).offset(Integer.valueOf(this.f18418b)).platform(4);
        int i = this.f18420d;
        if (i != 0) {
            builder.catid(Integer.valueOf(i));
        }
        return builder.build();
    }
}
