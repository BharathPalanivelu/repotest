package com.shopee.app.ui.refund.detail;

import android.content.Context;
import android.widget.ScrollView;
import android.widget.TextView;
import com.a.a.f;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.ui.refund.b;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class c extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    TextView f24970a;

    /* renamed from: b  reason: collision with root package name */
    TextView f24971b;

    /* renamed from: c  reason: collision with root package name */
    TextView f24972c;

    /* renamed from: d  reason: collision with root package name */
    TextView f24973d;

    /* renamed from: e  reason: collision with root package name */
    int f24974e;

    /* renamed from: f  reason: collision with root package name */
    b f24975f;

    /* renamed from: g  reason: collision with root package name */
    bc f24976g;
    private f h;
    private f i;
    private f j;
    private f k;
    private final long l;
    private final int m;

    public void a(OrderDetail orderDetail) {
    }

    public c(Context context, long j2, int i2) {
        super(context);
        this.l = j2;
        this.m = i2;
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24976g.a(this.f24975f);
        this.f24975f.a(this);
        this.h = a("Refund Amount", "$48,000", this.f24970a);
        this.i = a("Payment Option", "VISA **** 4321", this.f24971b);
        this.j = a("Cancel Reason", "Other", this.f24972c);
        this.k = a("Explanation", "There is some description that will go in here, multiline.", this.f24973d);
    }

    private f a(String str, String str2, TextView textView) {
        f a2 = f.a(getContext());
        a2.a((Object) str).a().a(this.f24974e).b(com.garena.android.appkit.tools.b.a(R.color.black54)).c().b();
        a2.a((Object) "\n").b();
        a2.a((Object) str2).a(AppMeasurementSdk.ConditionalUserProperty.VALUE).b();
        a2.a(textView);
        return a2;
    }
}
