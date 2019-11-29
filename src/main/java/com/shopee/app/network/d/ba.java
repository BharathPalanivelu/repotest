package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.RemoveActivity;

public class ba extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18162a;

    /* renamed from: b  reason: collision with root package name */
    private int f18163b;

    /* renamed from: c  reason: collision with root package name */
    private long f18164c;

    /* renamed from: d  reason: collision with root package name */
    private long f18165d;

    public long b() {
        return this.f18165d;
    }

    public void a(int i) {
        this.f18162a = i;
        this.f18163b = 0;
        g();
    }

    public void a(long j, long j2) {
        this.f18165d = j;
        this.f18164c = j2;
        this.f18163b = 1;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        RemoveActivity.Builder builder = new RemoveActivity.Builder();
        if (this.f18163b == 0) {
            builder.requestid(i().a()).activity_id(Integer.valueOf(this.f18162a));
        } else {
            builder.requestid(i().a()).activity_id(0).groupid(Long.valueOf(this.f18164c)).action_id(Long.valueOf(this.f18165d));
        }
        return new f(96, builder.build().toByteArray());
    }

    public int c() {
        return this.f18162a;
    }

    public int d() {
        return this.f18163b;
    }

    public long e() {
        return this.f18164c;
    }
}
