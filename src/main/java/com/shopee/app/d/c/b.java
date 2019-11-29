package com.shopee.app.d.c;

import com.garena.android.appkit.b.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.p;
import com.shopee.app.util.n;
import com.shopee.app.web.protocol.StartChatMessage;

public class b extends Cdo {
    public b(n nVar, p pVar, bh bhVar, UserInfo userInfo) {
        super(nVar, pVar, bhVar, userInfo);
    }

    /* access modifiers changed from: protected */
    public void a(int i, int i2, long j) {
        StartChatMessage startChatMessage = new StartChatMessage();
        startChatMessage.setItemID(j);
        startChatMessage.setUserID(i2);
        startChatMessage.setShopID(i);
        this.f16402a.a("BUY_NOW_SEND_OFFER", new a(startChatMessage));
    }
}
