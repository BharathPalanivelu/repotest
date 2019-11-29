package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.HotHashTagInfo;
import com.shopee.protocol.action.ResponseGetHotHashTagList;
import java.io.IOException;
import java.util.ArrayList;

public class ag extends c {
    public int a() {
        return 175;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((ResponseGetHotHashTagList) f.f18486a.parseFrom(bArr, 0, i, ResponseGetHotHashTagList.class));
    }

    private a c() {
        return ar.f().e().getHotHashTagProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17792a;

        public a(n nVar) {
            this.f17792a = nVar;
        }

        private boolean b(ResponseGetHotHashTagList responseGetHotHashTagList) {
            return responseGetHotHashTagList.errcode.intValue() == 0;
        }

        public void a(ResponseGetHotHashTagList responseGetHotHashTagList) {
            if (b(responseGetHotHashTagList) && responseGetHotHashTagList.hashtag_list != null) {
                ArrayList arrayList = new ArrayList();
                for (HotHashTagInfo hotHashTagInfo : responseGetHotHashTagList.hashtag_list) {
                    arrayList.add("#" + hotHashTagInfo.hashtag);
                }
                this.f17792a.a("HOT_HASH_TAG_LOAD", new com.garena.android.appkit.b.a(arrayList));
            }
        }
    }
}
