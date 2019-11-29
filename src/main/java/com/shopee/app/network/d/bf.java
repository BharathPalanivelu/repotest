package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.SendVmail;

public class bf extends az {

    /* renamed from: a  reason: collision with root package name */
    private String f18179a;

    /* renamed from: b  reason: collision with root package name */
    private int f18180b = 1;

    /* renamed from: c  reason: collision with root package name */
    private int f18181c;

    public void a(String str) {
        this.f18179a = str;
        g();
    }

    public void a(String str, int i) {
        this.f18179a = str;
        this.f18180b = i;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        SendVmail.Builder builder = new SendVmail.Builder();
        builder.requestid(i().a()).email(this.f18179a).country("ID").type(Integer.valueOf(this.f18180b));
        return new f(79, builder.build().toByteArray());
    }

    public int b() {
        return this.f18181c;
    }

    public void a(int i) {
        this.f18181c = i;
    }
}
