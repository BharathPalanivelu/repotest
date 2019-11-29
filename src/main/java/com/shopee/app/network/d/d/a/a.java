package com.shopee.app.network.d.d.a;

import com.shopee.protocol.search.action.MatchType;
import com.shopee.protocol.search.action.MatchTypeIndex;
import com.shopee.protocol.search.action.RequestSearchItem;
import com.shopee.protocol.search.action.SearchCondition;
import com.squareup.wire.Message;
import java.util.Collections;

public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    private String f18245b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f18246c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f18247d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f18248e;

    /* renamed from: f  reason: collision with root package name */
    private int f18249f;

    public int b() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int c() {
        return 101;
    }

    private a(C0273a aVar) {
        this.f18245b = aVar.f18250a;
        this.f18246c = aVar.f18251b;
        this.f18247d = aVar.f18252c;
        this.f18248e = aVar.f18253d;
        this.f18249f = aVar.f18254e;
    }

    public int d() {
        return this.f18246c.intValue();
    }

    public Message q_() {
        h();
        RequestSearchItem.Builder builder = new RequestSearchItem.Builder();
        builder.header(e()).keyword(this.f18245b).offset(this.f18246c).limit(this.f18247d).sorttype(this.f18248e).condition(new SearchCondition.Builder().country("ID").matches(Collections.singletonList(new MatchType.Builder().match_type(MatchTypeIndex.MATCH_SHOP).id(Collections.singletonList(Long.valueOf((long) this.f18249f))).build())).build());
        return builder.build();
    }

    /* renamed from: com.shopee.app.network.d.d.a.a$a  reason: collision with other inner class name */
    public static final class C0273a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f18250a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Integer f18251b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Integer f18252c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Integer f18253d = 2;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f18254e;

        public C0273a a(String str) {
            this.f18250a = str;
            return this;
        }

        public C0273a a(Integer num) {
            this.f18251b = num;
            return this;
        }

        public C0273a b(Integer num) {
            this.f18252c = num;
            return this;
        }

        public C0273a a(int i) {
            this.f18254e = i;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
