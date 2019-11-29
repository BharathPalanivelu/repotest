package com.shopee.app.ui.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.garena.android.uikit.a.c;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.tracking.a;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.common.aq;
import com.shopee.app.ui.common.f;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.HashMap;
import java.util.Map;

public class g extends FrameLayout implements View.OnClickListener, c.b, r {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Integer, Integer> f23665a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<Integer, Integer> f23666b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    c f23667c;

    /* renamed from: d  reason: collision with root package name */
    View f23668d;

    /* renamed from: e  reason: collision with root package name */
    e f23669e;

    /* renamed from: f  reason: collision with root package name */
    bc f23670f;

    /* renamed from: g  reason: collision with root package name */
    a f23671g;
    SettingConfigStore h;
    ak i;
    private final int j;
    private final String k;

    public void a(int i2) {
    }

    static {
        f23665a.put(0, Integer.valueOf(R.string.sp_tab_buyer_to_pay));
        f23665a.put(1, Integer.valueOf(R.string.sp_tab_buyer_to_ship));
        f23665a.put(2, Integer.valueOf(R.string.sp_tab_buyer_to_receive));
        f23665a.put(3, Integer.valueOf(R.string.sp_tab_buyer_completed));
        f23665a.put(4, Integer.valueOf(R.string.sp_tab_buyer_closed));
        f23665a.put(5, Integer.valueOf(R.string.sp_tab_buyer_return));
        f23666b.put(0, Integer.valueOf(R.string.sp_tab_seller_to_pay));
        f23666b.put(1, Integer.valueOf(R.string.sp_tab_seller_to_ship));
        f23666b.put(2, Integer.valueOf(R.string.sp_tab_seller_to_receive));
        f23666b.put(3, Integer.valueOf(R.string.sp_tab_seller_completed));
        f23666b.put(4, Integer.valueOf(R.string.sp_tab_seller_closed));
        f23666b.put(5, Integer.valueOf(R.string.sp_tab_seller_return));
    }

    public g(Context context, int i2, String str) {
        super(context);
        this.j = i2;
        this.k = str;
        ((d) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f23670f.a(this.f23669e);
        this.f23669e.a(this);
        f fVar = new f(this.j, this.h.showToShipFilters(), this.k);
        this.f23667c.setAdapter(fVar);
        this.f23667c.setHeaderScrollListener(fVar);
        this.f23667c.a();
        this.f23667c.setTabIndicator(new aq(fVar.b()));
        this.f23667c.setTabChangeListener(this);
        this.f23669e.a(this.j);
        if (this.j == 0) {
            this.f23669e.e();
            this.f23668d = LayoutInflater.from(getContext()).inflate(R.layout.group_buy_order_notice_layout, this.f23667c, false);
            this.f23668d.setOnClickListener(this);
            this.f23667c.addView(this.f23668d, 1);
        }
    }

    public void b() {
        this.f23667c.b();
    }

    public void c() {
        this.f23667c.c();
    }

    public void d() {
        this.f23667c.d();
    }

    public void b(int i2, int i3) {
        c cVar = this.f23667c;
        f fVar = (f) cVar.findViewWithTag("ORDER_" + i2);
        if (fVar != null) {
            fVar.setNumber(Integer.valueOf(i3));
        }
    }

    public void setSelectedIndex(int i2) {
        this.f23667c.setSelectedIndex(i2);
    }

    public void a(int i2, int i3) {
        this.f23671g.b(i3);
    }

    public void e() {
        View view = this.f23668d;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void f() {
        View view = this.f23668d;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void onClick(View view) {
        this.i.o();
    }
}
