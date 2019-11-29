package com.shopee.app.react.modules.app.data;

import com.google.a.o;
import com.shopee.app.data.store.ChatBadgeStore;

public class n implements h {

    /* renamed from: a  reason: collision with root package name */
    private ChatBadgeStore f18764a;

    public n(ChatBadgeStore chatBadgeStore) {
        this.f18764a = chatBadgeStore;
    }

    public boolean a(String str) {
        return "unreadChatCount".equals(str);
    }

    public String b(String str) {
        int totalCount = this.f18764a.getTotalCount();
        o oVar = new o();
        oVar.a("count", (Number) Integer.valueOf(totalCount));
        return oVar.toString();
    }
}
