package com.shopee.app.ui.actionbox.actionrequired;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.c.ef;
import com.shopee.app.data.store.bb;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class c extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f19347a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f19348b;

    /* renamed from: c  reason: collision with root package name */
    Button f19349c;

    /* renamed from: d  reason: collision with root package name */
    Button f19350d;

    /* renamed from: e  reason: collision with root package name */
    Button f19351e;

    /* renamed from: f  reason: collision with root package name */
    int f19352f;

    /* renamed from: g  reason: collision with root package name */
    int f19353g;
    ak h;
    bb i;
    bi j;
    ef k;
    private int l = 0;
    /* access modifiers changed from: private */
    public boolean m = true;

    public interface a {
        void a(c cVar);
    }

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public c(Context context) {
        super(context);
        a(context);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    public void a(int i2, boolean z) {
        this.l = i2;
        this.m = z;
        if (z) {
            setBackgroundColor(b.a(R.color.background));
        } else {
            setBackgroundColor(b.a(R.color.white));
        }
        a(this.l);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        this.l = i2;
        int i3 = this.l;
        if (i3 == 0) {
            this.f19348b.setVisibility(0);
            this.f19351e.setVisibility(8);
            this.f19347a.setText(R.string.sp_enjoying_shopee);
            this.f19350d.setText(R.string.sp_oh_yes);
            this.f19349c.setText(R.string.sp_not_really);
            this.f19350d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.a(1);
                    c.this.k.a(1, c.this.m);
                }
            });
            this.f19349c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.a(2);
                    c.this.k.a(2, c.this.m);
                }
            });
        } else if (i3 == 1) {
            this.f19348b.setVisibility(8);
            this.f19351e.setVisibility(0);
            this.f19347a.setText(R.string.sp_enjoying_shopee_confirmed);
            this.f19351e.setText(R.string.sp_rate_now);
            this.f19351e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.c();
                    c.this.h.a(c.this.getContext());
                }
            });
        } else if (i3 == 2) {
            this.f19348b.setVisibility(8);
            this.f19351e.setVisibility(0);
            this.f19347a.setText(R.string.sp_enjoying_shopee_denied);
            this.f19351e.setText(R.string.sp_give_feedback);
            this.f19351e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.c();
                    c.this.h.N();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        c();
    }

    /* access modifiers changed from: private */
    public void c() {
        this.k.a(3, this.m);
        setVisibility(8);
    }
}
