package com.shopee.app.ui.shopassistant.shopSetting;

import com.shopee.app.d.c.a;
import com.shopee.app.data.store.bh;
import com.shopee.app.h.m;
import com.shopee.app.util.n;

public class k extends a {

    /* renamed from: c  reason: collision with root package name */
    private final m f25582c;

    /* renamed from: d  reason: collision with root package name */
    private final bh f25583d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25584e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25585f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f25586g = null;

    /* access modifiers changed from: protected */
    public String d() {
        return "ShopSettingInteractor";
    }

    protected k(n nVar, bh bhVar, m mVar) {
        super(nVar);
        this.f25583d = bhVar;
        this.f25582c = mVar;
    }

    public void a(boolean z, boolean z2) {
        this.f25585f = z2;
        this.f25584e = z;
        a();
    }

    public void a(boolean z, boolean z2, boolean z3) {
        this.f25585f = z2;
        this.f25584e = z;
        this.f25586g = Boolean.valueOf(z3);
        a();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r8 = this;
            com.shopee.app.data.store.bh r0 = r8.f25583d
            com.shopee.app.h.m r1 = r8.f25582c
            java.lang.Integer r1 = r1.g()
            int r1 = r1.intValue()
            com.shopee.app.database.orm.bean.DBShopInfo r0 = r0.b(r1)
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            byte[] r1 = r0.q()
            com.shopee.protocol.shop.PaymentOption$Builder r2 = new com.shopee.protocol.shop.PaymentOption$Builder
            r2.<init>()
            boolean r3 = r8.f25584e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.shopee.protocol.shop.PaymentOption$Builder r2 = r2.enabled(r3)
            r3 = 3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            com.shopee.protocol.shop.PaymentOption$Builder r2 = r2.payment_method(r4)
            com.shopee.protocol.shop.PaymentOption r2 = r2.build()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r4.add(r2)
            r2 = 0
            if (r1 == 0) goto L_0x006f
            int r5 = r1.length
            if (r5 == 0) goto L_0x006f
            com.squareup.wire.Wire r5 = com.shopee.app.network.f.f18486a     // Catch:{ IOException -> 0x006b }
            int r6 = r1.length     // Catch:{ IOException -> 0x006b }
            java.lang.Class<com.shopee.protocol.shop.PaymentOptionList> r7 = com.shopee.protocol.shop.PaymentOptionList.class
            com.squareup.wire.Message r1 = r5.parseFrom(r1, r2, r6, r7)     // Catch:{ IOException -> 0x006b }
            com.shopee.protocol.shop.PaymentOptionList r1 = (com.shopee.protocol.shop.PaymentOptionList) r1     // Catch:{ IOException -> 0x006b }
            java.util.List<com.shopee.protocol.shop.PaymentOption> r1 = r1.option     // Catch:{ IOException -> 0x006b }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x006b }
        L_0x0052:
            boolean r5 = r1.hasNext()     // Catch:{ IOException -> 0x006b }
            if (r5 == 0) goto L_0x006f
            java.lang.Object r5 = r1.next()     // Catch:{ IOException -> 0x006b }
            com.shopee.protocol.shop.PaymentOption r5 = (com.shopee.protocol.shop.PaymentOption) r5     // Catch:{ IOException -> 0x006b }
            java.lang.Integer r6 = r5.payment_method     // Catch:{ IOException -> 0x006b }
            int r6 = r6.intValue()     // Catch:{ IOException -> 0x006b }
            if (r6 != r3) goto L_0x0067
            goto L_0x0052
        L_0x0067:
            r4.add(r5)     // Catch:{ IOException -> 0x006b }
            goto L_0x0052
        L_0x006b:
            r1 = move-exception
            com.garena.android.appkit.d.a.a(r1)
        L_0x006f:
            com.shopee.protocol.shop.PaymentOptionList$Builder r1 = new com.shopee.protocol.shop.PaymentOptionList$Builder
            r1.<init>()
            r1.option(r4)
            byte[] r3 = r0.a()
            r4 = 0
            if (r3 == 0) goto L_0x0091
            int r5 = r3.length
            if (r5 == 0) goto L_0x0091
            com.squareup.wire.Wire r5 = com.shopee.app.network.f.f18486a     // Catch:{ IOException -> 0x008d }
            int r6 = r3.length     // Catch:{ IOException -> 0x008d }
            java.lang.Class<com.shopee.protocol.shop.ShopExtInfo> r7 = com.shopee.protocol.shop.ShopExtInfo.class
            com.squareup.wire.Message r2 = r5.parseFrom(r3, r2, r6, r7)     // Catch:{ IOException -> 0x008d }
            com.shopee.protocol.shop.ShopExtInfo r2 = (com.shopee.protocol.shop.ShopExtInfo) r2     // Catch:{ IOException -> 0x008d }
            goto L_0x0092
        L_0x008d:
            r2 = move-exception
            com.garena.android.appkit.d.a.a(r2)
        L_0x0091:
            r2 = r4
        L_0x0092:
            com.shopee.protocol.shop.ShopExtInfo$Builder r3 = new com.shopee.protocol.shop.ShopExtInfo$Builder
            r3.<init>()
            if (r2 == 0) goto L_0x009e
            com.shopee.protocol.shop.BuyerAddress r2 = r2.address
            r3.address(r2)
        L_0x009e:
            boolean r2 = r8.f25585f
            r2 = r2 ^ 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3.disable_make_offer(r2)
            java.lang.Boolean r2 = r8.f25586g
            if (r2 == 0) goto L_0x00b0
            r3.enable_display_unitno(r2)
        L_0x00b0:
            com.shopee.protocol.shop.Shop$Builder r2 = new com.shopee.protocol.shop.Shop$Builder
            r2.<init>()
            int r0 = r0.b()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.shopee.protocol.shop.Shop$Builder r0 = r2.shopid(r0)
            com.shopee.protocol.shop.ShopExtInfo r3 = r3.build()
            byte[] r3 = r3.toByteArray()
            e.f r3 = e.f.a((byte[]) r3)
            com.shopee.protocol.shop.Shop$Builder r0 = r0.extinfo(r3)
            com.shopee.protocol.shop.PaymentOptionList r1 = r1.build()
            byte[] r1 = r1.toByteArray()
            e.f r1 = e.f.a((byte[]) r1)
            r0.payment(r1)
            com.shopee.app.network.d.bu r0 = new com.shopee.app.network.d.bu
            r0.<init>()
            com.shopee.protocol.shop.Shop r1 = r2.build()
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.shopassistant.shopSetting.k.c():void");
    }
}
