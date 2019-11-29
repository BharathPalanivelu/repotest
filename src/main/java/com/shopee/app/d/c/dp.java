package com.shopee.app.d.c;

import com.garena.android.appkit.tools.a.a;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.d.b.g;
import com.shopee.app.util.g.b;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.shop.ChatOrderInfo;

public class dp extends a {

    /* renamed from: c  reason: collision with root package name */
    private final p f16829c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f16830d;

    /* renamed from: e  reason: collision with root package name */
    private final JobManager f16831e;

    /* renamed from: f  reason: collision with root package name */
    private final av f16832f;

    /* renamed from: g  reason: collision with root package name */
    private int f16833g;
    private long h;
    private OrderDetail i;

    /* access modifiers changed from: protected */
    public String d() {
        return "SendProductChatInteractor";
    }

    public dp(n nVar, p pVar, av avVar, UserInfo userInfo, JobManager jobManager) {
        super(nVar);
        this.f16829c = pVar;
        this.f16830d = userInfo;
        this.f16832f = avVar;
        this.f16831e = jobManager;
    }

    public void a(long j, int i2, OrderDetail orderDetail) {
        this.h = j;
        this.i = orderDetail;
        this.f16833g = i2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        g gVar = new g();
        DBChatMessage dBChatMessage = new DBChatMessage();
        dBChatMessage.d(this.f16830d.getUserId());
        dBChatMessage.c(this.h);
        dBChatMessage.c(this.i.getShopId());
        dBChatMessage.e(this.f16833g);
        dBChatMessage.a(new ChatOrderInfo.Builder().orderid(Long.valueOf(this.i.getOrderId())).checkoutid(Long.valueOf(this.i.getCheckoutId())).shopid(Integer.valueOf(this.i.getShopId())).ordersn(this.i.getSerialNumber()).total_price(Long.valueOf(this.i.getPriceBeforeDiscount())).currency(this.i.getCurrency()).order_status(a(this.i.getListType(), this.i.returnRequested())).item_image(this.i.getImages()).list_type(Integer.valueOf(this.i.getListType())).has_request_refund(Boolean.valueOf(this.i.returnRequested())).build().toByteArray());
        dBChatMessage.b(5);
        dBChatMessage.a(a.a());
        dBChatMessage.a(gVar.i().a());
        dBChatMessage.f(1);
        dBChatMessage.c(this.i.getShopId());
        dBChatMessage.d(this.i.getOrderId());
        this.f16829c.a(dBChatMessage);
        DBChat a2 = this.f16832f.a(this.f16833g);
        if (a2 != null) {
            a2.a(gVar.i().a());
            a2.g(a.a());
            this.f16832f.a(a2);
        }
        this.f16831e.addJobInBackground(new b(gVar.i().a()));
        this.f16402a.a("CHAT_LOCAL_SEND", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(dBChatMessage, this.f16830d.isMyShop(this.i.getShopId()))));
    }

    public static String a(int i2, boolean z) {
        if (z) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_tab_buyer_return);
        }
        if (i2 == 3) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_label_order_status_completed);
        }
        if (i2 == 4) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_label_order_status_canceled);
        }
        if (i2 == 7) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_label_order_status_to_ship);
        }
        if (i2 == 8) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_label_status_shipping);
        }
        if (i2 != 9) {
            return "";
        }
        return com.garena.android.appkit.tools.b.e(R.string.sp_label_order_status_unpaid);
    }
}
