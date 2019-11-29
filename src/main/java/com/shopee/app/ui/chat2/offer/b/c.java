package com.shopee.app.ui.chat2.offer.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.g.d;
import com.shopee.app.h.r;
import com.shopee.app.ui.a.y;
import com.shopee.app.ui.chat.b;
import com.shopee.app.ui.chat2.ai;
import com.shopee.app.ui.common.NPALinearLayoutManager;
import com.shopee.app.ui.common.ae;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;

public class c extends com.garena.android.uikit.a.a.a implements y.a<ItemDetail> {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f20625a;

    /* renamed from: b  reason: collision with root package name */
    a f20626b;

    /* renamed from: c  reason: collision with root package name */
    View f20627c;

    /* renamed from: d  reason: collision with root package name */
    TextView f20628d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f20629e;

    /* renamed from: f  reason: collision with root package name */
    bc f20630f;

    /* renamed from: g  reason: collision with root package name */
    Activity f20631g;
    private final boolean h;
    private a i;
    private final int j;
    private final int k;
    private ae l;

    public c(Context context, int i2, int i3, boolean z) {
        super(context);
        this.j = i2;
        this.k = i3;
        this.h = z;
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f20630f.a(this.f20626b);
        this.f20626b.a(this);
        this.i = new a(new ai());
        this.i.a(this);
        if (this.h) {
            this.f20628d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_seller_disabled_offer2));
            this.f20629e.setImageResource(R.drawable.ic_offer_turned_off);
        } else {
            this.f20628d.setText(com.garena.android.appkit.tools.b.e(R.string.sp_no_product_yet));
            this.f20629e.setImageResource(R.drawable.ic_no_product);
        }
        d.a(this.f20625a, this.f20627c, this.i);
        this.f20625a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        ((s) this.f20625a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.l = new ae(this.f20625a, this.i);
        this.l.a((ae.a) this.f20626b);
        this.f20625a.setAdapter(this.i);
        if (this.h) {
            this.f20627c.setVisibility(0);
            this.f20625a.setVisibility(8);
            return;
        }
        this.f20626b.a(this.j, this.k);
    }

    public void a(ArrayList<ItemDetail> arrayList) {
        if (!this.h) {
            this.i.a(arrayList);
            this.i.notifyItemRangeChanged(0, arrayList.size());
        }
    }

    public void a(View view, ItemDetail itemDetail, int i2) {
        if (itemDetail.isOutStock()) {
            r.a().b((int) R.string.sp_item_out_of_stock_offer_tip);
        } else {
            this.f20626b.a(itemDetail);
        }
    }

    public void e() {
        this.l.c();
    }

    public void f() {
        this.l.b();
    }

    public void g() {
        this.f20631g.finish();
    }

    private static class a extends y<ItemDetail> {
        public a(com.shopee.app.ui.a.s<ItemDetail> sVar) {
            super(sVar);
        }
    }
}
