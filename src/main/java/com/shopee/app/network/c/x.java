package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.am;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseQuickReplyList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class x extends c {
    public int a() {
        return 125;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseQuickReplyList responseQuickReplyList = (ResponseQuickReplyList) f.f18486a.parseFrom(bArr, 0, i, ResponseQuickReplyList.class);
        c(responseQuickReplyList.requestid);
        c().a(responseQuickReplyList);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetChatQuickReplyProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f18058a;

        /* renamed from: b  reason: collision with root package name */
        private final am f18059b;

        public a(n nVar, am amVar) {
            this.f18058a = nVar;
            this.f18059b = amVar;
        }

        public void a(ResponseQuickReplyList responseQuickReplyList) {
            if (b(responseQuickReplyList)) {
                this.f18059b.a(b.a(responseQuickReplyList.is_on));
                this.f18059b.a((List<String>) responseQuickReplyList.content == null ? new ArrayList() : responseQuickReplyList.content);
                this.f18058a.a("CMD_GET_CHAT_QUICKREPLY_SUCCESS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseQuickReplyList responseQuickReplyList) {
            if (responseQuickReplyList.errcode.intValue() == 0) {
                return true;
            }
            this.f18058a.a("CMD_GET_CHAT_QUICKREPLY_ERROR", new com.garena.android.appkit.b.a(responseQuickReplyList.errcode));
            return false;
        }

        public void a() {
            this.f18058a.a("CMD_GET_CHAT_QUICKREPLY_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
