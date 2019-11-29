package com.shopee.app.network.d.f;

import android.text.TextUtils;
import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.app.util.as;
import com.shopee.protocol.action.SendVcode;
import com.shopee.protocol.ads.action.TrackingPlatformType;
import com.squareup.wire.Message;

public class m extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f18322a;

    /* renamed from: b  reason: collision with root package name */
    private String f18323b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18324c;

    /* renamed from: d  reason: collision with root package name */
    private String f18325d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18326e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18327f;

    /* renamed from: g  reason: collision with root package name */
    private int f18328g;

    public int b() {
        return 15;
    }

    public m(String str, String str2, int i) {
        this.f18322a = as.a(str);
        this.f18323b = str2;
        this.f18328g = i;
    }

    public m(String str, String str2, int i, boolean z) {
        this.f18322a = as.a(str);
        this.f18323b = str2;
        this.f18328g = i;
        this.f18324c = z;
    }

    public void a(String str, boolean z, boolean z2) {
        this.f18325d = str;
        this.f18326e = z;
        this.f18327f = z2;
        g();
    }

    public boolean c() {
        return this.f18326e;
    }

    public Message q_() {
        h();
        SendVcode.Builder builder = new SendVcode.Builder();
        builder.requestid(i().a());
        builder.country("ID");
        if (!TextUtils.isEmpty(this.f18325d)) {
            builder.m_token(this.f18325d);
        }
        if (!TextUtils.isEmpty(this.f18322a)) {
            builder.phone(this.f18322a);
        } else {
            builder.phone("");
        }
        if (this.f18326e) {
            builder.action_type(2);
        } else {
            builder.action_type(1);
        }
        if (!TextUtils.isEmpty(this.f18323b)) {
            builder.otp_seed(this.f18323b);
        }
        builder.operation(Integer.valueOf(this.f18328g));
        builder.new_otp(Boolean.valueOf(!this.f18327f));
        builder.appversion(297);
        builder.lazy(Boolean.valueOf(this.f18324c));
        builder.platform(Integer.valueOf(TrackingPlatformType.ANDROID_APP.getValue()));
        return builder.build();
    }
}
