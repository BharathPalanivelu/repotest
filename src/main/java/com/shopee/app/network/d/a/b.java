package com.shopee.app.network.d.a;

import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ActionGetIdList;
import com.squareup.wire.Message;

public class b extends az implements com.shopee.app.network.a.b {

    /* renamed from: a  reason: collision with root package name */
    private long f18070a;

    /* renamed from: b  reason: collision with root package name */
    private int f18071b;

    /* renamed from: c  reason: collision with root package name */
    private long f18072c;

    /* renamed from: d  reason: collision with root package name */
    private int f18073d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f18074e = 4;

    public int b() {
        return 18;
    }

    public int c() {
        return this.f18074e;
    }

    public void a(long j, int i, int i2) {
        this.f18070a = j;
        this.f18071b = i;
        this.f18074e = i2;
        g();
    }

    public void a(long j, int i) {
        this.f18072c = j;
        this.f18074e = i;
        g();
    }

    public long d() {
        return this.f18070a;
    }

    public void a(int i) {
        this.f18073d = i;
    }

    public boolean e() {
        return this.f18073d != -1;
    }

    public boolean j() {
        return this.f18072c > 0;
    }

    public long k() {
        return this.f18072c;
    }

    public Message q_() {
        ActionGetIdList.Builder builder = new ActionGetIdList.Builder();
        builder.requestid(i().a()).need_grouped(true).request_number(Integer.valueOf(this.f18071b));
        long j = this.f18070a;
        if (j > 0) {
            builder.last_action_id(Long.valueOf(j));
        }
        if (j()) {
            builder.groupid(Long.valueOf(this.f18072c));
        }
        builder.action_cate(Integer.valueOf(this.f18074e));
        return builder.build();
    }
}
