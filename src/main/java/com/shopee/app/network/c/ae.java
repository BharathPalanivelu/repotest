package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.protocol.action.ResponseExtractedHashTag;
import java.io.IOException;

public class ae extends c {
    public int a() {
        return 178;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseExtractedHashTag responseExtractedHashTag = (ResponseExtractedHashTag) f.f18486a.parseFrom(bArr, 0, i, ResponseExtractedHashTag.class);
        if (a(responseExtractedHashTag)) {
            ar.f().e().extractedHashTagProcessor().a(responseExtractedHashTag);
        }
    }

    private boolean a(ResponseExtractedHashTag responseExtractedHashTag) {
        return responseExtractedHashTag.errcode.intValue() == 0;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final SearchKeywordsStore f17789a;

        public a(SearchKeywordsStore searchKeywordsStore) {
            this.f17789a = searchKeywordsStore;
        }

        public void a(ResponseExtractedHashTag responseExtractedHashTag) {
            if (!af.a(responseExtractedHashTag.hashtag_list)) {
                for (String addHashTagEditHistory : responseExtractedHashTag.hashtag_list) {
                    this.f17789a.addHashTagEditHistory(addHashTagEditHistory);
                }
            }
        }
    }
}
