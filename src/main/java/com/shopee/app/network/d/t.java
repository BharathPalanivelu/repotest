package com.shopee.app.network.d;

import com.shopee.app.network.a.b;
import com.shopee.protocol.action.GetBatchItemScore;
import com.shopee.protocol.action.SearchItemScore;
import com.squareup.wire.Message;
import java.util.List;

public class t extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    public int f18449a;

    /* renamed from: b  reason: collision with root package name */
    private List<SearchItemScore> f18450b;

    public int b() {
        return 240;
    }

    public void a(List<SearchItemScore> list, int i) {
        this.f18450b = list;
        this.f18449a = i;
        h();
        g();
    }

    public Message q_() {
        GetBatchItemScore.Builder builder = new GetBatchItemScore.Builder();
        builder.requestid(i().a()).items(this.f18450b).build();
        return builder.build();
    }
}
