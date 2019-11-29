package com.shopee.app.d.c;

import com.garena.android.appkit.tools.a.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.g.c;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.ChatOfferInfo;
import java.util.Iterator;

/* renamed from: com.shopee.app.d.c.do  reason: invalid class name */
public class Cdo extends a {

    /* renamed from: c  reason: collision with root package name */
    private final p f16824c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f16825d;

    /* renamed from: e  reason: collision with root package name */
    private final bh f16826e;

    /* renamed from: f  reason: collision with root package name */
    private long f16827f;

    /* renamed from: g  reason: collision with root package name */
    private long f16828g;
    private int h;
    private int i;
    private long j;
    private long k;
    private int l;
    private int m;
    private az n;
    private ItemDetail o;
    private long p;

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, long j2) {
    }

    /* access modifiers changed from: protected */
    public String d() {
        return "SendOfferChatInteractor";
    }

    public Cdo(n nVar, p pVar, bh bhVar, UserInfo userInfo) {
        super(nVar);
        this.f16824c = pVar;
        this.f16826e = bhVar;
        this.f16825d = userInfo;
    }

    public void a(long j2, long j3, long j4, int i2, int i3, long j5, int i4, int i5, long j6, ItemDetail itemDetail) {
        this.j = j2;
        this.f16827f = j3;
        this.f16828g = j4;
        this.h = i2;
        this.i = i3;
        this.k = j5;
        this.l = i4;
        this.m = i5;
        this.n = new c();
        this.o = itemDetail;
        this.p = j6;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        DBUserInfo a2 = this.f16826e.a(this.i);
        UserData userData = new UserData();
        b.a(a2, userData);
        if (userData.isHolidayModeOn()) {
            this.f16402a.a().x.a(Integer.valueOf(this.i)).a();
            return;
        }
        DBChatMessage dBChatMessage = new DBChatMessage();
        ChatOfferInfo.Builder builder = new ChatOfferInfo.Builder();
        builder.price(Long.valueOf(this.k)).currency("IDR").quantity(Integer.valueOf(this.l)).offerStatus(Integer.valueOf(this.m)).itemid(Long.valueOf(this.f16827f)).item_name(this.o.getItemName()).offerid(Long.valueOf(this.p)).imageUrl(this.o.getImages()).price_before_discount(Long.valueOf(this.o.getPriceBeforeDiscount())).original_price(Long.valueOf(this.o.getPrice())).shopid(Integer.valueOf(this.h));
        long j2 = this.f16828g;
        if (j2 > 0) {
            builder.modelid(Long.valueOf(j2));
            if (this.o.getModelDetails() != null) {
                Iterator<ModelDetail> it = this.o.getModelDetails().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ModelDetail next = it.next();
                    if (next.getModelId() == this.f16828g) {
                        builder.model_name(next.getName()).price_before_discount(Long.valueOf(next.getPriceBeforeDiscount())).original_price(Long.valueOf(next.getPrice()));
                        break;
                    }
                }
            }
        }
        dBChatMessage.d(this.f16825d.getUserId());
        dBChatMessage.c(this.j);
        dBChatMessage.c(this.h);
        dBChatMessage.e(this.i);
        dBChatMessage.a(builder.build().toByteArray());
        dBChatMessage.b(this.f16827f);
        dBChatMessage.b(3);
        dBChatMessage.a(a.a());
        dBChatMessage.a(this.n.i().a());
        dBChatMessage.f(1);
        long j3 = this.f16828g;
        if (j3 > 0) {
            dBChatMessage.e(j3);
        }
        this.f16824c.a(dBChatMessage);
        az azVar = this.n;
        if (azVar instanceof c) {
            ((c) azVar).a(dBChatMessage, this.l, this.k, this.p);
        }
        this.f16402a.a("CHAT_LOCAL_SEND", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(dBChatMessage, this.f16825d.isMyShop(this.h))));
        a(this.h, this.i, this.f16827f);
    }
}
