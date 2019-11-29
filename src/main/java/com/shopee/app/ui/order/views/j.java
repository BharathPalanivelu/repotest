package com.shopee.app.ui.order.views;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.app.util.ae;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;

public class j extends RelativeLayout implements ae.b {

    /* renamed from: a  reason: collision with root package name */
    View f23897a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23898b;

    /* renamed from: c  reason: collision with root package name */
    int f23899c;

    /* renamed from: d  reason: collision with root package name */
    int f23900d;

    /* renamed from: e  reason: collision with root package name */
    ak f23901e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f23902f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f23903g;

    public interface a {
        void a(j jVar);
    }

    public j(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i = this.f23900d;
        int i2 = this.f23899c;
        setPadding(i, i2, i, i2);
        this.f23897a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                j.this.f23901e.d(j.this.f23902f, j.this.f23903g);
            }
        });
    }

    public void a(String str, long j, int i) {
        this.f23902f = j;
        this.f23903g = i;
        setStatus(str);
    }

    private void setStatus(String str) {
        this.f23898b.setText(str);
    }

    public long getIdentifier() {
        return this.f23902f;
    }

    public boolean a(long j) {
        return j == this.f23902f;
    }
}
