package com.shopee.app.ui.shopassistant.shopSetting;

import com.shopee.app.data.store.bh;
import com.shopee.app.h.m;
import com.shopee.app.util.n;

public class a extends com.shopee.app.d.c.a {

    /* renamed from: c  reason: collision with root package name */
    private final m f25536c;

    /* renamed from: d  reason: collision with root package name */
    private final bh f25537d;

    /* renamed from: e  reason: collision with root package name */
    private String f25538e;

    /* access modifiers changed from: protected */
    public String d() {
        return "AutoReplySettingInteractor";
    }

    protected a(n nVar, bh bhVar, m mVar) {
        super(nVar);
        this.f25537d = bhVar;
        this.f25536c = mVar;
    }

    public void a(String str) {
        this.f25538e = str;
        a();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r7 = this;
            com.shopee.app.data.store.bh r0 = r7.f25537d
            com.shopee.app.h.m r1 = r7.f25536c
            java.lang.Integer r1 = r1.g()
            int r1 = r1.intValue()
            com.shopee.app.database.orm.bean.DBShopInfo r0 = r0.b(r1)
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            byte[] r1 = r0.a()
            r2 = 0
            if (r1 == 0) goto L_0x002e
            int r3 = r1.length
            if (r3 == 0) goto L_0x002e
            com.squareup.wire.Wire r3 = com.shopee.app.network.f.f18486a     // Catch:{ IOException -> 0x002a }
            r4 = 0
            int r5 = r1.length     // Catch:{ IOException -> 0x002a }
            java.lang.Class<com.shopee.protocol.shop.ShopExtInfo> r6 = com.shopee.protocol.shop.ShopExtInfo.class
            com.squareup.wire.Message r1 = r3.parseFrom(r1, r4, r5, r6)     // Catch:{ IOException -> 0x002a }
            com.shopee.protocol.shop.ShopExtInfo r1 = (com.shopee.protocol.shop.ShopExtInfo) r1     // Catch:{ IOException -> 0x002a }
            goto L_0x002f
        L_0x002a:
            r1 = move-exception
            com.garena.android.appkit.d.a.a(r1)
        L_0x002e:
            r1 = r2
        L_0x002f:
            com.shopee.protocol.shop.ShopExtInfo$Builder r2 = new com.shopee.protocol.shop.ShopExtInfo$Builder
            r2.<init>()
            if (r1 == 0) goto L_0x003b
            com.shopee.protocol.shop.BuyerAddress r1 = r1.address
            r2.address(r1)
        L_0x003b:
            java.lang.String r1 = r7.f25538e
            if (r1 == 0) goto L_0x005c
            com.shopee.protocol.shop.ChatTextInfo$Builder r1 = new com.shopee.protocol.shop.ChatTextInfo$Builder
            r1.<init>()
            java.lang.String r3 = r7.f25538e
            java.lang.String r3 = r3.trim()
            r1.text(r3)
            com.shopee.protocol.shop.ChatTextInfo r1 = r1.build()
            byte[] r1 = r1.toByteArray()
            e.f r1 = e.f.a((byte[]) r1)
            r2.auto_reply_msg(r1)
        L_0x005c:
            com.shopee.protocol.shop.Shop$Builder r1 = new com.shopee.protocol.shop.Shop$Builder
            r1.<init>()
            int r0 = r0.b()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.shopee.protocol.shop.Shop$Builder r0 = r1.shopid(r0)
            com.shopee.protocol.shop.ShopExtInfo r2 = r2.build()
            byte[] r2 = r2.toByteArray()
            e.f r2 = e.f.a((byte[]) r2)
            r0.extinfo(r2)
            com.shopee.app.network.d.bu r0 = new com.shopee.app.network.d.bu
            r0.<init>()
            com.shopee.protocol.shop.Shop r1 = r1.build()
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.shopassistant.shopSetting.a.c():void");
    }
}
