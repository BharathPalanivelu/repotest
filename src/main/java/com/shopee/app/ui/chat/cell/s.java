package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.a.a.f;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.dp;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat.ChatOrderMessage;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.af;
import com.shopee.app.util.ai;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class s extends FrameLayout implements View.OnClickListener, View.OnLongClickListener, n<ChatMessage>, am {

    /* renamed from: a  reason: collision with root package name */
    TextView f20139a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20140b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20141c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f20142d;

    /* renamed from: e  reason: collision with root package name */
    int f20143e;

    /* renamed from: f  reason: collision with root package name */
    int f20144f;

    /* renamed from: g  reason: collision with root package name */
    int f20145g;
    int h;
    ak i;
    ao j;
    UserInfo k;
    private final boolean l;
    private ChatOrderMessage m;
    private f n;
    private f o;
    private final an p;

    public interface a {
        void a(s sVar);
    }

    public s(Context context, an anVar, boolean z) {
        super(context);
        this.l = z;
        this.p = anVar;
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20141c.setTextColor(this.h);
        this.f20139a.setTextColor(this.f20144f);
        this.f20140b.setTextColor(this.f20144f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.n = f.a(getContext());
        this.n.a((int) R.string.sp_order_id).b().b().a(": ").b().b().a().a("ordersn").b();
        this.o = f.a(getContext());
        this.o.a((int) R.string.sp_label_total).b().b().a(": ").b().b().a().a("total").b();
    }

    public void a(ChatMessage chatMessage) {
        this.m = (ChatOrderMessage) chatMessage;
        this.n.b("ordersn").a((Object) this.m.getOrderSN());
        this.n.a(this.f20139a);
        this.o.b("total").a((Object) this.m.getTotalPriceStr());
        this.o.a(this.f20140b);
        String a2 = a(this.m.getListType(), this.m.isReturnRequested());
        if (TextUtils.isEmpty(a2)) {
            a2 = this.m.getOrderStatus();
        }
        this.f20141c.setText(a2);
        if (!af.a(this.m.getImageList())) {
            ai.a(getContext()).a(this.m.getImageList(), this.f20142d);
        }
        an anVar = this.p;
        if (anVar != null) {
            anVar.setContentBackground(R.color.white);
        }
    }

    private String a(int i2, int i3) {
        if (i3 == -1) {
            return "";
        }
        boolean z = true;
        if (i3 != 1) {
            z = false;
        }
        return dp.a(i2, z);
    }

    public void onClick(View view) {
        if (this.m.getListType() != 9 || this.k.isMyShop(this.m.getShopId())) {
            this.i.a(this.m.getOrderId(), this.m.getShopId());
        } else {
            this.i.a(this.m.getCheckoutId(), this.m.getOrderId(), this.m.getShopId());
        }
    }

    public void b() {
        if (this.m.getSendStatus() == 2) {
            a.a((View) this, (ChatMessage) this.m);
        }
    }

    public boolean onLongClick(View view) {
        if (this.m.getSendStatus() != 2) {
            return false;
        }
        a.a((View) this, (ChatMessage) this.m);
        return true;
    }
}
