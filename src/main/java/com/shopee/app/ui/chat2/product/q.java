package com.shopee.app.ui.chat2.product;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import com.shopee.app.h.r;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.at;
import com.shopee.app.util.au;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class q extends FrameLayout implements n<ItemDetail> {

    /* renamed from: a  reason: collision with root package name */
    ImageView f20833a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20834b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20835c;

    /* renamed from: d  reason: collision with root package name */
    CheckBox f20836d;

    /* renamed from: e  reason: collision with root package name */
    TextView f20837e;

    /* renamed from: f  reason: collision with root package name */
    TextView f20838f;

    /* renamed from: g  reason: collision with root package name */
    TextView f20839g;
    int h;
    int i;
    int j;
    int k;
    int l;
    bi m;
    com.shopee.app.util.n n;
    bc o;
    e p;
    /* access modifiers changed from: private */
    public ItemDetail q;
    private final boolean r;
    private CompoundButton.OnCheckedChangeListener s = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                if (com.shopee.app.ui.chat.a.f20003c.size() >= 4) {
                    q.this.f20836d.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                    q.this.f20836d.setChecked(false);
                    q.this.f20836d.setOnCheckedChangeListener(this);
                    r.a().b((int) R.string.sp_select_product_max_reached);
                } else if (q.this.q.isFakeItem()) {
                    q.this.f20836d.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                    q.this.f20836d.setChecked(false);
                    q.this.f20836d.setOnCheckedChangeListener(this);
                    r.a().b((int) R.string.sp_item_detail_not_ready);
                } else {
                    com.shopee.app.ui.chat.a.f20003c.put(Long.valueOf(q.this.q.getId()), q.this.q);
                }
            } else if (com.shopee.app.ui.chat.a.f20003c.containsKey(Long.valueOf(q.this.q.getId()))) {
                com.shopee.app.ui.chat.a.f20003c.remove(Long.valueOf(q.this.q.getId()));
            }
            q.this.m.a("ON_PRODUCT_CHECK_CHANGE", new com.garena.android.appkit.b.a());
            q.this.n.a("NOTIFY_SIBLINGS", new com.garena.android.appkit.b.a());
        }
    };
    private View.OnClickListener t = new View.OnClickListener() {
        public void onClick(View view) {
            q.this.f20836d.setChecked(!q.this.f20836d.isChecked());
        }
    };

    public interface a {
        void a(q qVar);
    }

    public q(Context context, boolean z) {
        super(context);
        b();
        this.r = z;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.o.a(this.p);
        this.p.a(this);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        ((a) ((x) getContext()).b()).a(this);
    }

    public void c() {
        this.f20836d.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f20836d.setChecked(com.shopee.app.ui.chat.a.f20003c.containsKey(Long.valueOf(this.q.getId())));
        this.f20836d.setOnCheckedChangeListener(this.s);
    }

    public void a(ItemDetail itemDetail) {
        this.q = itemDetail;
        if (this.r) {
            setOnClickListener(this.t);
            this.f20836d.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            this.f20836d.setChecked(com.shopee.app.ui.chat.a.f20003c.containsKey(Long.valueOf(this.q.getId())));
            this.f20836d.setOnCheckedChangeListener(this.s);
        } else {
            this.f20836d.setVisibility(8);
        }
        if (itemDetail.getOffer() == null) {
            b(itemDetail);
        } else {
            a(itemDetail.getOffer());
        }
    }

    private void b(ItemDetail itemDetail) {
        this.f20834b.setText(itemDetail.getItemName());
        this.f20835c.setText(au.b(itemDetail.getPrice()));
        z.b(getContext()).a(itemDetail.getImages()).a(this.f20833a);
        int i2 = ((itemDetail.isFakeItem() || !itemDetail.isOutStock()) && !itemDetail.isDeList()) ? 8 : 0;
        this.f20838f.setVisibility(8);
        this.f20839g.setVisibility(4);
        this.f20837e.setVisibility(i2);
        this.f20837e.setText(itemDetail.isDeList() ? R.string.unlisted : R.string.sp_label_sold_out);
        if (itemDetail.isOutStock()) {
            this.f20834b.setTextColor(b.a(R.color.black54));
            at.a(getContext(), itemDetail).a(this.f20835c);
            return;
        }
        this.f20834b.setTextColor(b.a(R.color.black87));
        at.a(getContext(), itemDetail).a(this.f20835c);
    }

    private void a(VMOfferHistory vMOfferHistory) {
        this.f20837e.setVisibility(8);
        ItemDetail itemDetail = vMOfferHistory.getItemDetail();
        if (itemDetail == null) {
            itemDetail = new ItemDetail();
            com.shopee.app.d.b.b.a(vMOfferHistory.getSnapshot(), itemDetail);
        }
        this.f20834b.setText(itemDetail.getItemName());
        at.a(getContext(), itemDetail.getVariationNoOOSPriceString(), vMOfferHistory.getOffer().getOfferPrice()).a(this.f20835c);
        z.b(getContext()).a(itemDetail.getImages()).a(this.f20833a);
        ModelDetail variation = itemDetail.getVariation(vMOfferHistory.getOffer().getModelid());
        if (variation == null) {
            this.f20838f.setVisibility(8);
        } else {
            this.f20838f.setVisibility(0);
            this.f20838f.setText(variation.getName());
            at.a(getContext(), au.b(variation.getPrice()), vMOfferHistory.getOffer().getOfferPrice()).a(this.f20835c);
        }
        this.f20839g.setText("x " + vMOfferHistory.getOffer().getBuyCount());
        this.f20839g.setVisibility(0);
    }
}
