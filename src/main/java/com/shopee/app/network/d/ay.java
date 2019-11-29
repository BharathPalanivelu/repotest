package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.database.orm.bean.DBAttributeCache;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.util.af;
import com.shopee.protocol.action.MatchItemAttribute;
import com.shopee.protocol.shop.AttributeValue;
import java.util.ArrayList;
import java.util.List;

public class ay extends az {

    /* renamed from: a  reason: collision with root package name */
    private int f18134a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f18135b;

    /* renamed from: c  reason: collision with root package name */
    private List<u> f18136c;

    /* renamed from: d  reason: collision with root package name */
    private DBAttributeCache f18137d;

    public void a(int i, byte[] bArr, List<u> list) {
        this.f18134a = i;
        this.f18135b = bArr;
        this.f18136c = list;
        h();
        g();
    }

    /* access modifiers changed from: protected */
    public f a() {
        MatchItemAttribute.Builder builder = new MatchItemAttribute.Builder();
        builder.requestid(i().a()).modelid(Integer.valueOf(this.f18134a)).country("ID").build();
        byte[] bArr = this.f18135b;
        if (bArr != null) {
            builder.signature(e.f.a(bArr));
        }
        if (!af.a(this.f18136c)) {
            ArrayList arrayList = new ArrayList();
            for (u next : this.f18136c) {
                AttributeValue.Builder builder2 = new AttributeValue.Builder();
                builder2.attr_id(Integer.valueOf(next.a())).value(next.b());
                arrayList.add(builder2.build());
            }
            builder.value(arrayList);
        }
        return new f(238, builder.build().toByteArray());
    }

    public int b() {
        return this.f18134a;
    }

    public void a(DBAttributeCache dBAttributeCache) {
        this.f18137d = dBAttributeCache;
    }

    public DBAttributeCache c() {
        return this.f18137d;
    }

    public List<u> d() {
        return this.f18136c;
    }
}
