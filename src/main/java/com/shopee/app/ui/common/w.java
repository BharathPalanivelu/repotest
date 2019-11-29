package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.chat.OfferItem;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class w extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    ImageView f21354a;

    /* renamed from: b  reason: collision with root package name */
    View f21355b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21356c;

    /* renamed from: d  reason: collision with root package name */
    TextView f21357d;

    /* renamed from: e  reason: collision with root package name */
    TextView f21358e;

    /* renamed from: f  reason: collision with root package name */
    TextView f21359f;

    /* renamed from: g  reason: collision with root package name */
    TextView f21360g;
    TextView h;
    String i;
    String j;
    int k;
    int l;
    int m;
    int n;
    int o;
    v p;
    bc q;
    ak r;
    private long s;
    private int t = -1;
    private ItemDetail u;
    private OfferItem v;

    public interface a {
        void a(w wVar);
    }

    public w(Context context) {
        super(context);
        a(context);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public w(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
        setBackgroundResource(R.drawable.bottom_border_white_background_highlight);
        setOnClickListener(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.q.a(this.p);
        this.p.a(this);
    }

    public void a(ItemDetail itemDetail) {
        this.u = itemDetail;
        this.f21356c.setText(itemDetail.getItemName());
        OfferItem offerItem = this.v;
        if (offerItem == null || (!offerItem.isOfferNew() && !this.v.isOfferAccept())) {
            this.f21357d.setText("");
        } else {
            this.f21357d.setText(this.v.getModelName());
        }
        c(itemDetail);
        b(itemDetail);
        z.b(getContext()).a(itemDetail.getImages()).a(this.f21354a);
    }

    private void b(ItemDetail itemDetail) {
        this.f21360g.setText(String.valueOf(itemDetail.getLikedCount()));
        this.h.setText(String.valueOf(itemDetail.getCmtCount()));
    }

    private void c(ItemDetail itemDetail) {
        int status = itemDetail.getStatus();
        if (status == 0 || status == 2 || status == 3 || status == 4 || status == 5) {
            this.f21358e.setTextColor(this.l);
            this.f21358e.setText(itemDetail.getVariationNoOOSPriceString());
            this.f21355b.setVisibility(0);
            return;
        }
        this.f21358e.setTextColor(b.a(R.color.black87));
        this.f21355b.setVisibility(8);
        int i2 = this.t;
        if (i2 == 1) {
            f a2 = f.a(getContext());
            a2.a().a((Object) itemDetail.getVariationPriceString(this.v.getModelId())).a().a(this.n).b(this.o).c().b();
            a2.a(this.f21358e);
        } else if (i2 == 2) {
            f a3 = f.a(getContext());
            a3.a().a((Object) au.b(this.s)).a().a(this.n).b(this.o).c().b();
            a3.a("  ").b();
            if (!au.b(this.s).equals(itemDetail.getVariationPriceString(this.v.getModelId()))) {
                a3.a().a((Object) itemDetail.getVariationPriceString(this.v.getModelId())).a().a(this.m).b(this.k).b().c().b();
            }
            a3.a(this.f21358e);
        } else if (itemDetail.hasPromotion()) {
            f a4 = f.a(getContext());
            a4.a().a((Object) itemDetail.getVariationNoOOSBeforeDiscountPriceString()).a().a(this.m).b(this.k).b().c().b();
            a4.a("  ").b();
            a4.a().a((Object) itemDetail.getVariationNoOOSPriceString()).a().a(this.n).b(this.o).c().b();
            a4.a(this.f21358e);
        } else {
            f a5 = f.a(getContext());
            String variationNoOOSPriceString = itemDetail.getVariationNoOOSPriceString();
            a5.a().a((Object) variationNoOOSPriceString).a().b(variationNoOOSPriceString.contains("-") ? this.o : this.l).c().b();
            a5.a(this.f21358e);
        }
    }

    public void setOfferInfo(OfferItem offerItem) {
        this.v = offerItem;
        this.t = offerItem.getOfferStatus();
        this.s = offerItem.getOfferPrice();
        ItemDetail itemDetail = this.u;
        if (itemDetail != null) {
            c(itemDetail);
            a(this.u);
        }
    }

    public void onClick(View view) {
        this.p.e();
    }

    public void a(int i2, long j2) {
        this.r.b(i2, j2);
    }
}
