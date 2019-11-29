package com.shopee.app.ui.order.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.util.ae;
import com.shopee.app.util.z;
import com.shopee.id.R;
import java.util.List;

public class f extends RelativeLayout implements ae.b {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f23885a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23886b;

    /* renamed from: c  reason: collision with root package name */
    TextView f23887c;

    /* renamed from: d  reason: collision with root package name */
    TextView f23888d;

    /* renamed from: e  reason: collision with root package name */
    TextView f23889e;

    /* renamed from: f  reason: collision with root package name */
    TextView f23890f;

    /* renamed from: g  reason: collision with root package name */
    TextView f23891g;
    String h;
    TextView i;
    View j;
    View k;
    int l;
    int m;
    int n;
    private int o;
    private List<Long> p;
    private boolean q;

    public f(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i2 = this.n;
        setPadding(i2, 0, i2, 0);
    }

    public void setIds(List<Long> list) {
        this.p = list;
    }

    public long getIdentifier() {
        return this.p.get(0).longValue();
    }

    public boolean a(long j2) {
        return this.p.contains(Long.valueOf(j2));
    }

    public void setProductImage(String str) {
        z.b(getContext()).a(str).a(this.f23885a);
    }

    public void setProductName(String str) {
        this.f23886b.setText(str);
    }

    public void a(String str, String str2) {
        com.a.a.f a2 = com.a.a.f.a(getContext(), this.h);
        if (str.equals(str2)) {
            str2 = "";
        }
        a2.a().a().b().b(b.a(R.color.black26)).a(this.l).c().a((Object) str2).b();
        a2.a().a().b(b.a(R.color.primary)).a(this.l).c().a((Object) str).b();
        a2.a(this.f23888d);
        if (this.q) {
            a2.a(this.f23889e);
        }
    }

    public void b(String str, String str2) {
        com.a.a.f a2 = com.a.a.f.a(getContext(), this.h);
        a2.a().a().b(this.o).a(this.l).c().a((Object) str).b();
        if (str.equals(str2)) {
            str2 = "";
        }
        a2.a().a().b().b(b.a(R.color.black26)).a(this.l).c().a((Object) str2).b();
        a2.a(this.f23888d);
        if (this.q) {
            a2.a(this.f23889e);
        }
    }

    public void setWholeSalePrice(String str) {
        com.a.a.f a2 = com.a.a.f.a(getContext(), this.h);
        a2.a().a().b(this.o).a(this.l).c().a((Object) str).b();
        a2.a().a().b(b.a(R.color.black26)).a(this.l).c().a((Object) "[" + b.e(R.string.wholesale) + "]").b();
        a2.a(this.f23888d);
        if (this.q) {
            a2.a(this.f23889e);
        }
    }

    public void setVariation(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f23887c.setVisibility(4);
            return;
        }
        this.f23887c.setVisibility(0);
        this.f23887c.setText(b.e(R.string.sp_label_variation) + ": " + str);
    }

    public void setQuantity(int i2) {
        this.f23890f.setText(b.a(R.string.sp_order_first_item_buy_n_count, Integer.valueOf(i2)));
    }

    public void setAsReturn(boolean z) {
        if (z) {
            this.o = b.a(R.color.black26);
            this.f23886b.setTextColor(this.o);
            this.f23885a.setImageAlpha(102);
            this.f23890f.setTextColor(this.o);
            this.f23887c.setTextColor(this.o);
            this.i.setVisibility(0);
            this.f23891g.setAlpha(0.4f);
            return;
        }
        this.o = b.a(R.color.black87);
        this.f23886b.setTextColor(this.o);
        this.f23887c.setTextColor(b.a(R.color.black54));
        this.f23890f.setTextColor(b.a(R.color.black65));
        this.f23885a.setImageAlpha(255);
        this.i.setVisibility(8);
        this.f23891g.setAlpha(1.0f);
    }

    public void setAsBundle(boolean z) {
        this.q = z;
        if (z) {
            this.k.setVisibility(0);
            this.f23888d.setVisibility(8);
            this.f23890f.setVisibility(8);
            return;
        }
        this.k.setVisibility(8);
        this.f23888d.setVisibility(0);
        this.f23890f.setVisibility(0);
    }

    public void setFreeReturnReturnPeriod(int i2) {
        int i3 = 0;
        this.f23891g.setText(b.a(R.string.official_shop_return_refund, Integer.valueOf(i2)));
        TextView textView = this.f23891g;
        if (i2 <= 0) {
            i3 = 4;
        }
        textView.setVisibility(i3);
    }
}
