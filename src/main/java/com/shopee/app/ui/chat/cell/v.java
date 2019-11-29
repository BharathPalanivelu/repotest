package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.b.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.h.r;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class v extends FrameLayout implements n<ChatMessage> {

    /* renamed from: a  reason: collision with root package name */
    TextView f20146a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20147b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20148c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f20149d;

    /* renamed from: e  reason: collision with root package name */
    View f20150e;

    /* renamed from: f  reason: collision with root package name */
    View f20151f;

    /* renamed from: g  reason: collision with root package name */
    TextView f20152g;
    TextView h;
    View i;
    TextView j;
    TextView k;
    View l;
    bi m;
    UserInfo n;
    ak o;
    b p;
    private ChatMessage q;
    private ItemDetail r;

    public v(Context context) {
        super(context);
        ((com.shopee.app.ui.chat.b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20150e.setVisibility(8);
        this.f20151f.setVisibility(0);
        this.f20148c.setMaxWidth(com.garena.android.appkit.tools.b.b() / 2);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.q.isDisallowNegotiate()) {
            r.a().b((int) R.string.sp_offer_not_allowed);
        } else {
            this.m.a().U.a(new Pair(this.r, (Object) null)).a();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.m.a("CHAT_OPTION_BUY_NOW_ITEM", new a(this.r));
        this.p.a("item_buy_now_button", "", b.a(this.r.getId(), (long) this.r.getShopId()));
    }

    public void a(ChatMessage chatMessage) {
        this.q = chatMessage;
        if (this.q.isOfferAndBuyEnabled()) {
            this.f20152g.setClickable(true);
            this.h.setClickable(true);
            this.f20152g.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
            this.h.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
            if (this.q.isDisallowNegotiate()) {
                this.f20152g.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black26));
            } else {
                this.f20152g.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
            }
        } else {
            this.f20152g.setClickable(false);
            this.h.setClickable(false);
            this.f20152g.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black26));
            this.h.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black26));
        }
        this.r = (ItemDetail) chatMessage.getData();
        if (this.r.hasPromotion()) {
            f a2 = f.a(getContext());
            a2.a().a((Object) this.r.getVariationNoOOSBeforeDiscountPriceString()).a().b(com.garena.android.appkit.tools.b.a(R.color.black26)).b().c().b();
            a2.a(this.f20147b);
        } else {
            this.f20147b.setText("");
        }
        setVisibility(0);
        this.f20146a.setText(this.r.getItemName());
        this.f20148c.setText(this.r.getVariationNoOOSPriceString());
        z.b(getContext()).a(this.r.getImages()).a(this.f20149d);
        if (this.n.isMyShop(this.r.getShopId())) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
        if (chatMessage.isTW()) {
            if (chatMessage.getSendStatus() != 0) {
                this.j.setVisibility(4);
            } else {
                this.j.setVisibility(0);
            }
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            return;
        }
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.j.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        ItemDetail itemDetail = this.r;
        if (itemDetail != null) {
            this.o.b(itemDetail.getShopId(), this.r.getId());
            this.p.a("item", "", b.a(this.r.getId(), (long) this.r.getShopId()));
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (!this.r.isFakeItem()) {
            this.m.a().k.a(this.r).a();
        }
    }
}
