package com.shopee.app.ui.chat2.buy;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.h.r;
import com.shopee.app.ui.a.y;
import com.shopee.app.ui.common.NPALinearLayoutManager;
import com.shopee.app.ui.common.ae;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.List;

public class d extends com.garena.android.uikit.a.a.a implements y.a<ItemDetail> {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f20391a;

    /* renamed from: b  reason: collision with root package name */
    b f20392b;

    /* renamed from: c  reason: collision with root package name */
    View f20393c;

    /* renamed from: d  reason: collision with root package name */
    TextView f20394d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f20395e;

    /* renamed from: f  reason: collision with root package name */
    bc f20396f;

    /* renamed from: g  reason: collision with root package name */
    Activity f20397g;
    ak h;
    private a i;
    private final int j;
    private final int k;
    private ae l;

    public d(Context context, int i2, int i3) {
        super(context);
        this.j = i2;
        this.k = i3;
        ((com.shopee.app.ui.chat.b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f20396f.a(this.f20392b);
        this.f20392b.a(this);
        this.i = new a(new b());
        this.i.a(this);
        this.f20394d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_no_product_yet));
        this.f20395e.setImageResource(R.drawable.ic_no_product);
        com.shopee.app.g.d.a(this.f20391a, this.f20393c, this.i);
        this.f20391a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        ((s) this.f20391a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.l = new ae(this.f20391a, this.i);
        this.l.a((ae.a) this.f20392b);
        this.f20391a.setAdapter(this.i);
        this.f20392b.a(this.j, this.k);
    }

    public void a(List<ItemDetail> list) {
        this.i.a(list);
        this.i.notifyItemRangeChanged(0, list.size());
    }

    public void a(View view, ItemDetail itemDetail, int i2) {
        if (itemDetail.getShopId() <= 0) {
            return;
        }
        if (itemDetail.getOffer() != null) {
            this.h.u();
        } else if (itemDetail.isOutStock()) {
            r.a().b((int) R.string.sp_item_out_of_stock_buy_tip);
        } else {
            this.f20392b.a(itemDetail);
        }
    }

    public void e() {
        this.l.c();
    }

    public void f() {
        this.l.b();
    }

    public void a(String str) {
        this.h.e(str);
    }

    private static class a extends y<ItemDetail> {
        public a(com.shopee.app.ui.a.s<ItemDetail> sVar) {
            super(sVar);
        }
    }

    private static class b implements com.shopee.app.ui.a.s<ItemDetail> {
        public int a() {
            return 2;
        }

        private b() {
        }

        public int a(ItemDetail itemDetail, int i) {
            return itemDetail.getShopId();
        }

        public View a(Context context, int i) {
            if (i != -2) {
                return com.shopee.app.ui.chat2.product.r.a(context, false);
            }
            return com.shopee.app.ui.chat2.product.b.a(context);
        }
    }
}
