package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.x;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.OfferCount;
import com.shopee.protocol.action.ResponseOfferCount;
import com.tencent.qalsdk.im_open.http;
import java.io.IOException;

public class am extends c {
    public int a() {
        return http.No_Content;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseOfferCount responseOfferCount = (ResponseOfferCount) f.f18486a.parseFrom(bArr, 0, i, ResponseOfferCount.class);
        c(responseOfferCount.requestid);
        c().a(responseOfferCount);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetOfferCountProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17809a;

        /* renamed from: b  reason: collision with root package name */
        private x f17810b;

        public a(n nVar, x xVar) {
            this.f17809a = nVar;
            this.f17810b = xVar;
        }

        public void a(ResponseOfferCount responseOfferCount) {
            if (b(responseOfferCount)) {
                if (!af.a(responseOfferCount.offer_count)) {
                    for (OfferCount next : responseOfferCount.offer_count) {
                        this.f17810b.a(b.a(next.userid), b.a(next.count));
                    }
                }
                this.f17809a.a("CMD_GET_OFFER_COUNT_SUCCESS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseOfferCount responseOfferCount) {
            if (responseOfferCount.errcode.intValue() == 0) {
                return true;
            }
            this.f17809a.a("CMD_GET_OFFER_COUNT_ERROR", new com.garena.android.appkit.b.a(responseOfferCount.errcode));
            return false;
        }

        public void a() {
            this.f17809a.a("CMD_GET_OFFER_COUNT_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
