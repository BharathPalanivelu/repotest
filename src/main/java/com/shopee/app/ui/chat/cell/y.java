package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.b.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat.ChatProductMessage;
import com.shopee.app.g.e;
import com.shopee.app.h.r;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.chat2.q;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class y extends FrameLayout implements View.OnClickListener, View.OnLongClickListener, n<ChatMessage>, am {

    /* renamed from: a  reason: collision with root package name */
    TextView f20157a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20158b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20159c;

    /* renamed from: d  reason: collision with root package name */
    TextView f20160d;

    /* renamed from: e  reason: collision with root package name */
    TextView f20161e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f20162f;

    /* renamed from: g  reason: collision with root package name */
    View f20163g;
    int h;
    int i;
    int j;
    int k;
    View l;
    View m;
    ak n;
    ao o;
    UserInfo p;
    bi q;
    b r;
    private final boolean s;
    private final an t;
    private ChatProductMessage u;

    public y(Context context, an anVar, boolean z) {
        super(context);
        ((com.shopee.app.ui.chat.b) ((x) context).b()).a(this);
        this.t = anVar;
        this.s = z;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20161e.setTextColor(this.i);
        this.f20158b.setTextColor(this.k);
        this.f20157a.setTextColor(this.j);
        this.f20163g.setOnClickListener(this);
        this.f20163g.setOnLongClickListener(this);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.u.isDisallowNegotiate()) {
            r.a().b((int) R.string.sp_offer_not_allowed);
        } else {
            this.q.a("MAKE_OFFER_ITEM_VIEW", new a(new q(this.u.getShopId(), this.u.getItemId())));
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.q.a("BUY_NOW_ITEM_VIEW", new a(new q(this.u.getShopId(), this.u.getItemId())));
        this.r.a("item_buy_now_button", "", b.a(this.u.getItemId(), (long) this.u.getShopId()));
    }

    public void a(ChatMessage chatMessage) {
        this.u = (ChatProductMessage) chatMessage;
        if (this.u.isOfferAndBuyEnabled()) {
            this.f20159c.setClickable(true);
            this.f20160d.setClickable(true);
            this.f20159c.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
            this.f20160d.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
            if (this.u.isDisallowNegotiate()) {
                this.f20159c.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black26));
            } else {
                this.f20159c.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
            }
        } else {
            this.f20159c.setClickable(false);
            this.f20160d.setClickable(false);
            this.f20159c.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black26));
            this.f20160d.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black26));
        }
        f a2 = f.a(getContext());
        a2.a().a().c().a((Object) this.u.getName()).b();
        this.f20157a.setText(this.u.getName());
        an anVar = this.t;
        if (anVar != null) {
            anVar.setContentBackground(R.color.white);
        }
        if (TextUtils.isEmpty(this.u.getPriceBeforeDiscount())) {
            this.f20158b.setVisibility(8);
        } else {
            Long a3 = e.a(this.u.getPriceBeforeDiscount(), "IDR");
            if (a3 == null || a3.longValue() <= 0) {
                this.f20158b.setVisibility(8);
            } else {
                this.f20158b.setVisibility(0);
                f a4 = f.a(getContext());
                a4.a().a((Object) this.u.getPriceBeforeDiscount()).a().b(this.k).b().c().b();
                a4.a(this.f20158b);
            }
        }
        a2.a(this.f20157a);
        this.f20161e.setText(this.u.getPrice());
        z.b(getContext()).a(this.u.getThumbUrl()).a(this.f20162f);
        if (this.p.isMyShop(chatMessage.getShopId()) || this.u.getItemId() <= 0) {
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        this.m.setVisibility(0);
    }

    public void onClick(View view) {
        if (this.u.getItemId() <= 0) {
            this.n.c(this.u.getShopId(), this.u.getSnapshotId());
            return;
        }
        this.n.b(this.u.getShopId(), this.u.getItemId());
        this.r.a("item", "", b.a(this.u.getItemId(), (long) this.u.getShopId()));
    }

    public void b() {
        if (this.u.getSendStatus() == 2) {
            a.a((View) this, (ChatMessage) this.u);
        }
    }

    public boolean onLongClick(View view) {
        if (this.u.getSendStatus() != 2) {
            return false;
        }
        a.a((View) this, (ChatMessage) this.u);
        return true;
    }
}
