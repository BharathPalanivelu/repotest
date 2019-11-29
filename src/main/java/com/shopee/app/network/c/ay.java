package com.shopee.app.network.c;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseUserLastSeen;
import com.shopee.protocol.action.UserLastSeen;
import java.io.IOException;

public class ay extends c {
    public int a() {
        return 189;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseUserLastSeen responseUserLastSeen = (ResponseUserLastSeen) f.f18486a.parseFrom(bArr, 0, i, ResponseUserLastSeen.class);
        c(responseUserLastSeen.requestid);
        c().a(responseUserLastSeen);
    }

    private a c() {
        return ar.f().e().getUserLastSeenProcessor();
    }

    public void a(String str) {
        c().a(-100);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17836a;

        /* access modifiers changed from: private */
        public void a(int i) {
        }

        a(n nVar) {
            this.f17836a = nVar;
        }

        public void a(ResponseUserLastSeen responseUserLastSeen) {
            if (b(responseUserLastSeen) && !af.a(responseUserLastSeen.user)) {
                for (UserLastSeen next : responseUserLastSeen.user) {
                    this.f17836a.a().ci.a(new Pair(Integer.valueOf(b.a(next.userid)), new Pair(Integer.valueOf(b.a(next.last_login)), Integer.valueOf(b.a(next.last_logout))))).a();
                }
            }
        }

        private boolean b(ResponseUserLastSeen responseUserLastSeen) {
            if (responseUserLastSeen.errcode.intValue() == 0) {
                return true;
            }
            a(responseUserLastSeen.errcode.intValue());
            return false;
        }
    }
}
