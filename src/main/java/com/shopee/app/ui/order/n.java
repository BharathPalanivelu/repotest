package com.shopee.app.ui.order;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.app.util.ae;

public class n extends RelativeLayout implements ae.b {

    /* renamed from: a  reason: collision with root package name */
    TextView f23735a;

    /* renamed from: b  reason: collision with root package name */
    View f23736b;

    /* renamed from: c  reason: collision with root package name */
    int f23737c;

    /* renamed from: d  reason: collision with root package name */
    int f23738d;

    /* renamed from: e  reason: collision with root package name */
    private long f23739e;

    public n(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i = this.f23737c;
        int i2 = this.f23738d;
        setPadding(i, i2, i, i2);
    }

    public long getIdentifier() {
        return this.f23739e;
    }

    public boolean a(long j) {
        return j == this.f23739e;
    }

    public void setOrderId(long j) {
        this.f23739e = j;
    }

    public void setDividerVisibility(int i) {
        this.f23736b.setVisibility(i);
    }

    public void setOrderNumber(String str) {
        this.f23735a.setText(str);
    }
}
