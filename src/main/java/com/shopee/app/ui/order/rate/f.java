package com.shopee.app.ui.order.rate;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.shopee.app.data.viewmodel.OrderRateItemInfo;
import com.shopee.app.h.q;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.a.z;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.order.d;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import java.util.List;

public class f extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f23787a;

    /* renamed from: b  reason: collision with root package name */
    View f23788b;

    /* renamed from: c  reason: collision with root package name */
    Activity f23789c;

    /* renamed from: d  reason: collision with root package name */
    d f23790d;

    /* renamed from: e  reason: collision with root package name */
    bc f23791e;

    /* renamed from: f  reason: collision with root package name */
    r f23792f;

    /* renamed from: g  reason: collision with root package name */
    a f23793g;
    private final long h;
    private final int i;
    private final int j;
    private final int k;
    private List<OrderRateItemInfo> l;

    public f(Context context, long j2, int i2, int i3, int i4) {
        super(context);
        this.h = j2;
        this.i = i2;
        this.j = i3;
        this.k = i4;
        ((d) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f23791e.a(this.f23790d);
        this.f23790d.a(this);
        this.f23793g.notifyDataSetChanged();
        this.f23790d.a(this.h, this.i, this.j, this.k);
    }

    public void a(List<OrderRateItemInfo> list) {
        if (list == null || list.size() <= 0) {
            f();
            return;
        }
        this.f23787a.setVisibility(0);
        this.f23788b.setVisibility(8);
        this.l = list;
        this.f23793g.a(list);
        e();
    }

    private void e() {
        this.f23787a.removeAllViews();
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            LinearLayout linearLayout = this.f23787a;
            linearLayout.addView(this.f23793g.getView(i2, (View) null, linearLayout));
            if (i2 == 0) {
                ((b) this.f23793g.getView(0, (View) null, this.f23787a)).e();
            }
        }
    }

    public void b() {
        this.f23789c.finish();
    }

    private void f() {
        this.f23787a.setVisibility(8);
        this.f23788b.setVisibility(0);
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void c() {
        this.f23790d.a(this.l);
    }

    public static class a extends z<OrderRateItemInfo> {
        /* access modifiers changed from: protected */
        public n<OrderRateItemInfo> a(Context context, int i) {
            return c.a(context);
        }
    }

    public void d() {
        this.f23792f.b();
    }
}
