package com.shopee.app.ui.shopassistant.chatSetting;

import com.shopee.app.d.c.a;
import com.shopee.app.data.store.bh;
import com.shopee.app.h.m;
import com.shopee.app.util.n;

public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    private final m f25393c;

    /* renamed from: d  reason: collision with root package name */
    private final bh f25394d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25395e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25396f = false;

    /* renamed from: g  reason: collision with root package name */
    private String f25397g;

    /* access modifiers changed from: protected */
    public String d() {
        return "ChatSettingInteractor";
    }

    protected c(n nVar, bh bhVar, m mVar) {
        super(nVar);
        this.f25394d = bhVar;
        this.f25393c = mVar;
    }

    public void a(boolean z, String str, boolean z2) {
        this.f25395e = z;
        this.f25397g = str;
        this.f25396f = z2;
        a();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r7 = this;
            com.shopee.app.data.store.bh r0 = r7.f25394d
            com.shopee.app.h.m r1 = r7.f25393c
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
            java.lang.String r1 = r7.f25397g
            if (r1 == 0) goto L_0x0065
            com.shopee.protocol.shop.ChatTextInfo$Builder r1 = new com.shopee.protocol.shop.ChatTextInfo$Builder
            r1.<init>()
            java.lang.String r3 = r7.f25397g
            java.lang.String r3 = r3.trim()
            r1.text(r3)
            com.shopee.protocol.shop.ChatTextInfo r1 = r1.build()
            byte[] r1 = r1.toByteArray()
            e.f r1 = e.f.a((byte[]) r1)
            r2.auto_reply_msg(r1)
            boolean r1 = r7.f25395e
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.auto_reply_on(r1)
        L_0x0065:
            boolean r1 = r7.f25396f
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.chat_disabled(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.shopassistant.chatSetting.c.c():void");
    }
}
