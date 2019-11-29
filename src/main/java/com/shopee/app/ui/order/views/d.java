package com.shopee.app.ui.order.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.app.util.ae;
import com.shopee.app.util.z;
import com.shopee.id.R;
import java.util.List;

public class d extends RelativeLayout implements ae.b {

    /* renamed from: a  reason: collision with root package name */
    ImageView f23871a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23872b;

    /* renamed from: c  reason: collision with root package name */
    TextView f23873c;

    /* renamed from: d  reason: collision with root package name */
    View f23874d;

    /* renamed from: e  reason: collision with root package name */
    int f23875e;

    /* renamed from: f  reason: collision with root package name */
    int f23876f;

    /* renamed from: g  reason: collision with root package name */
    int f23877g;
    View h;
    private boolean i = true;
    private List<Long> j;

    public d(Context context) {
        super(context);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i2 = this.f23875e;
        setPadding(i2, 0, i2, 0);
    }

    public void setAvatar(String str) {
        z.a(getContext()).a(str).a().a(this.f23871a);
    }

    public void setIds(List<Long> list) {
        this.j = list;
    }

    public long getIdentifier() {
        return this.j.get(0).longValue();
    }

    public boolean a(long j2) {
        return this.j.contains(Long.valueOf(j2));
    }

    public void setUsername(String str) {
        this.f23872b.setText(str);
    }

    public void setStatus(String str) {
        this.f23873c.setTextColor(this.f23876f);
        this.f23873c.setText(str);
    }

    public void setPrice(String str) {
        this.f23873c.setTextColor(this.f23877g);
        this.f23873c.setText(str);
    }

    public void a(boolean z, View.OnClickListener onClickListener) {
        if (z) {
            this.f23873c.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.com_garena_shopee_ic_arrow_up, 0);
            this.f23873c.setOnClickListener(onClickListener);
            return;
        }
        this.f23873c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f23873c.setOnClickListener(onClickListener);
    }

    public void b() {
        this.i = true;
        this.f23873c.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.com_garena_shopee_ic_arrow_up, 0);
    }

    public void c() {
        this.i = false;
        this.f23873c.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.com_garena_shopee_ic_arrow_down, 0);
    }

    public boolean d() {
        return this.i;
    }

    public void a(boolean z) {
        this.f23874d.setVisibility(z ? 0 : 8);
    }

    public void setLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f23873c.setOnLongClickListener(onLongClickListener);
    }

    public void setOfficialShop(boolean z) {
        this.h.setVisibility(z ? 0 : 8);
    }
}
