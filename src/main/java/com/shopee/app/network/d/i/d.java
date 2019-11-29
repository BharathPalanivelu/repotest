package com.shopee.app.network.d.i;

import com.shopee.app.application.ar;
import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.SearchUser;
import com.squareup.wire.Message;

public class d extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f18423a;

    /* renamed from: b  reason: collision with root package name */
    private int f18424b;

    /* renamed from: c  reason: collision with root package name */
    private int f18425c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18426d;

    public int b() {
        return 90;
    }

    public void a(String str, int i, int i2, boolean z) {
        this.f18423a = str;
        this.f18424b = i;
        this.f18425c = i2;
        this.f18426d = z;
        g();
    }

    public Message q_() {
        return new SearchUser.Builder().requestid(i().a()).country("ID").keyword(this.f18423a).limit(Integer.valueOf(this.f18424b)).sessionid(ar.f().e().deviceStore().d()).offset(Integer.valueOf(this.f18425c)).official_only(Boolean.valueOf(this.f18426d)).platform(4).build();
    }

    public String c() {
        return this.f18423a;
    }
}
