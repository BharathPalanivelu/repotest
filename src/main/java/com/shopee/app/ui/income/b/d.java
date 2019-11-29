package com.shopee.app.ui.income.b;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.income.ShopBalance;
import com.shopee.app.data.viewmodel.income.TransactionItem;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.a.z;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.income.a.e;
import com.shopee.app.ui.income.a.i;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import java.util.List;

public class d extends com.garena.android.uikit.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    ListView f23157a;

    /* renamed from: b  reason: collision with root package name */
    RelativeLayout f23158b;

    /* renamed from: c  reason: collision with root package name */
    View f23159c;

    /* renamed from: d  reason: collision with root package name */
    b f23160d;

    /* renamed from: e  reason: collision with root package name */
    bc f23161e;

    /* renamed from: f  reason: collision with root package name */
    ak f23162f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final int f23163g;
    private b h;
    private p i;
    private a j;

    public interface a {
        void a(d dVar);
    }

    public d(Context context, int i2) {
        super(context);
        this.f23163g = i2;
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f23161e.a(this.f23160d);
        this.f23160d.a(this);
        this.h = new b();
        int i2 = this.f23163g;
        if (i2 == 0) {
            this.j = i.a(getContext(), this.f23163g);
        } else if (i2 == 1) {
            this.j = com.shopee.app.ui.income.a.b.a(getContext(), this.f23163g);
        } else if (i2 == 2) {
            this.j = com.shopee.app.ui.income.a.b.a(getContext(), this.f23163g);
        }
        this.f23157a.addHeaderView(this.j);
        this.f23157a.setAdapter(this.h);
        this.i = new p(this.f23157a);
        this.i.a((p.a) this.f23160d);
        this.f23160d.a(this.f23163g);
        if (this.f23163g == 2) {
            this.f23160d.e();
        }
    }

    public void a(List<TransactionItem> list) {
        this.h.a(list);
        this.h.notifyDataSetChanged();
        if (this.h.getCount() < 1) {
            this.f23158b.setVisibility(0);
        } else {
            this.f23158b.setVisibility(8);
        }
    }

    public void e() {
        this.i.c();
    }

    public void f() {
        this.i.b();
    }

    /* access modifiers changed from: package-private */
    public void a(TransactionItem transactionItem) {
        if (transactionItem != null && transactionItem.getShopId() != 0) {
            if (this.f23163g == 1) {
                this.f23162f.a(transactionItem.getOrderId(), transactionItem.getShopId());
            } else {
                this.f23162f.d(transactionItem.getOrderId());
            }
        }
    }

    public void a(ShopBalance shopBalance) {
        this.j.a(shopBalance);
    }

    public void a(ShopDetail shopDetail) {
        this.j.a(shopDetail);
    }

    public void b(ShopBalance shopBalance) {
        this.j.b(shopBalance);
    }

    public void setSum(Long l) {
        this.j.setAmount(l);
    }

    public void a() {
        this.f23160d.c();
        this.j.b();
    }

    public void b() {
        this.f23160d.d();
        this.j.g();
    }

    public void g() {
        this.f23159c.setVisibility(0);
    }

    public void h() {
        this.f23159c.setVisibility(8);
    }

    public class b extends z<TransactionItem> {
        public b() {
        }

        /* access modifiers changed from: protected */
        public n<TransactionItem> a(Context context, int i) {
            return e.a(context, d.this.f23163g);
        }
    }
}
