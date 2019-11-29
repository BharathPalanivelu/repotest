package com.shopee.app.network.c.i;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.network.c.i.w;
import com.shopee.protocol.action.Notification;

public class j implements w.a {
    public void a(Notification notification) {
        int a2 = b.a(notification.userid);
        long a3 = b.a(notification.msgid);
        ChatBadgeStore chatBadgeStore = ar.f().e().chatBadgeStore();
        chatBadgeStore.setServerSeen(a2, a3);
        com.garena.android.appkit.b.b.a("CHAT_BADGE_UPDATE2", new a(Integer.valueOf(chatBadgeStore.getTotalCount())), b.a.NETWORK_BUS);
    }
}
