package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.a.a.f;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.dp;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.chat.b;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class p extends FrameLayout implements n<ChatMessage> {

    /* renamed from: a  reason: collision with root package name */
    TextView f20130a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20131b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20132c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f20133d;

    /* renamed from: e  reason: collision with root package name */
    TextView f20134e;

    /* renamed from: f  reason: collision with root package name */
    Button f20135f;

    /* renamed from: g  reason: collision with root package name */
    bi f20136g;
    UserInfo h;
    ak i;
    private OrderDetail j;
    private f k;
    private f l;

    public p(Context context) {
        super(context);
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.k = f.a(getContext());
        this.k.a((int) R.string.sp_order_id).b().b().a(": ").b().b().a().a("ordersn").b();
        this.l = f.a(getContext());
        this.l.a((int) R.string.sp_label_total).b().b().a(": ").b().b().a().a("total").b();
        this.f20132c.setMaxWidth(com.garena.android.appkit.tools.b.b() / 2);
    }

    public void a(ChatMessage chatMessage) {
        this.j = (OrderDetail) chatMessage.getData();
        setVisibility(0);
        this.k.b("ordersn").a((Object) this.j.getSerialNumber());
        this.k.a(this.f20130a);
        this.l.b("total").a((Object) au.a(this.j.getPriceBeforeDiscount(), this.j.getCurrency()));
        this.l.a(this.f20131b);
        this.f20132c.setText(dp.a(this.j.getListType(), this.j.returnRequested()));
        if (!af.a(this.j.getImages())) {
            z.b(getContext()).a(this.j.getImages().get(0)).a(this.f20133d);
        }
        if (chatMessage.isTW()) {
            if (chatMessage.getSendStatus() != 0) {
                this.f20134e.setVisibility(4);
            } else {
                this.f20134e.setVisibility(0);
            }
            this.f20135f.setVisibility(8);
            return;
        }
        this.f20134e.setVisibility(8);
        this.f20135f.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.j.getListType() != 9 || this.h.isMyShop(this.j.getShopId())) {
            this.i.a(this.j.getOrderId(), this.j.getShopId());
        } else {
            this.i.a(this.j.getCheckoutId(), this.j.getOrderId(), this.j.getShopId());
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.j.getOrderStatus() > 0) {
            this.f20136g.a().aq.a(this.j).a();
        }
    }
}
