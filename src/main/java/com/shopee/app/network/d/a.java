package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.ui.common.e;
import com.shopee.protocol.action.AddFeedComment;
import com.shopee.protocol.action.FeedComment;
import com.shopee.protocol.shop.CommentTagInfo;
import com.shopee.protocol.shop.CommentTagInfoList;
import java.util.ArrayList;

public class a extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18064a;

    /* renamed from: b  reason: collision with root package name */
    private long f18065b;

    /* renamed from: c  reason: collision with root package name */
    private String f18066c;

    /* renamed from: d  reason: collision with root package name */
    private e[] f18067d;

    public void a(int i, long j, String str, e[] eVarArr) {
        this.f18064a = i;
        this.f18065b = j;
        this.f18066c = str;
        this.f18067d = eVarArr;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        CommentTagInfoList.Builder builder;
        if (this.f18067d.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (e eVar : this.f18067d) {
                CommentTagInfo.Builder builder2 = new CommentTagInfo.Builder();
                builder2.infoid(Long.valueOf((long) eVar.a())).length(Integer.valueOf(eVar.b())).offset(Integer.valueOf(eVar.c())).type(0);
                arrayList.add(builder2.build());
            }
            builder = new CommentTagInfoList.Builder();
            builder.tags(arrayList);
        } else {
            builder = null;
        }
        FeedComment.Builder builder3 = new FeedComment.Builder();
        builder3.shopid(Integer.valueOf(this.f18064a)).feedid(Long.valueOf(this.f18065b)).comment(this.f18066c);
        if (builder != null) {
            builder3.mentioned(e.f.a(builder.build().toByteArray()));
        }
        AddFeedComment.Builder builder4 = new AddFeedComment.Builder();
        builder4.requestid(i().a()).cmt(builder3.build());
        return new f(191, builder4.build().toByteArray());
    }
}
