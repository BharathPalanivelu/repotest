package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetActivityList;
import java.util.Arrays;

public class r extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18445a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f18446b;

    /* renamed from: c  reason: collision with root package name */
    private int f18447c;

    public void a(int i, int i2) {
        this.f18445a = i;
        this.f18446b = Integer.valueOf(i2);
        this.f18447c = -1;
        g();
    }

    public void a(int i, int i2, int i3) {
        this.f18445a = i;
        this.f18446b = Integer.valueOf(i2);
        this.f18447c = i3;
        g();
    }

    public int b() {
        return this.f18445a;
    }

    public int c() {
        return this.f18446b.intValue();
    }

    public int d() {
        return this.f18447c;
    }

    /* access modifiers changed from: protected */
    public f a() {
        GetActivityList.Builder builder = new GetActivityList.Builder();
        builder.requestid(i().a()).last_activity_id(Integer.valueOf(this.f18445a)).limit(this.f18446b);
        if (this.f18447c != -1) {
            builder.activity_type_list(Arrays.asList(new Integer[]{3, 8, 4, 9}));
        }
        return new f(95, builder.build().toByteArray());
    }
}
