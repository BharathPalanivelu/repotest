package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.ui.common.e;
import com.shopee.protocol.action.AddItemComment;
import com.shopee.protocol.shop.CommentTagInfo;
import com.shopee.protocol.shop.CommentTagInfoList;
import com.shopee.protocol.shop.ItemCmt;
import java.util.ArrayList;

public class be extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18175a;

    /* renamed from: b  reason: collision with root package name */
    private long f18176b;

    /* renamed from: c  reason: collision with root package name */
    private String f18177c;

    /* renamed from: d  reason: collision with root package name */
    private e[] f18178d;

    public void a(int i, long j, String str, e[] eVarArr) {
        this.f18175a = i;
        this.f18176b = j;
        this.f18177c = str;
        this.f18178d = eVarArr;
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        CommentTagInfoList.Builder builder;
        if (this.f18178d.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (e eVar : this.f18178d) {
                CommentTagInfo.Builder builder2 = new CommentTagInfo.Builder();
                builder2.infoid(Long.valueOf((long) eVar.a())).length(Integer.valueOf(eVar.b())).offset(Integer.valueOf(eVar.c())).type(0);
                arrayList.add(builder2.build());
            }
            builder = new CommentTagInfoList.Builder();
            builder.tags(arrayList);
        } else {
            builder = null;
        }
        ItemCmt.Builder builder3 = new ItemCmt.Builder();
        builder3.shopid(Integer.valueOf(this.f18175a)).itemid(Long.valueOf(this.f18176b)).comment(this.f18177c);
        if (builder != null) {
            builder3.mentioned(e.f.a(builder.build().toByteArray()));
        }
        AddItemComment.Builder builder4 = new AddItemComment.Builder();
        builder4.requestid(i().a()).comment(builder3.build());
        return new f(78, builder4.build().toByteArray());
    }
}
