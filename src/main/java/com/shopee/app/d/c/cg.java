package com.shopee.app.d.c;

import com.garena.android.appkit.d.a;
import com.shopee.app.data.store.g;
import com.shopee.app.database.orm.bean.DBAttributeCache;
import com.shopee.app.network.d.ay;
import com.shopee.app.network.f;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseMatchAttribute;
import com.shopee.protocol.shop.AttributeInstance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cg extends a {

    /* renamed from: c  reason: collision with root package name */
    private final g f16681c;

    /* renamed from: d  reason: collision with root package name */
    private int f16682d;

    /* renamed from: e  reason: collision with root package name */
    private List<u> f16683e;

    /* access modifiers changed from: protected */
    public String d() {
        return "MatchItemAttributeInteractor";
    }

    protected cg(n nVar, g gVar) {
        super(nVar);
        this.f16681c = gVar;
    }

    public void a(int i, List<u> list) {
        this.f16682d = i;
        this.f16683e = list;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        ResponseMatchAttribute responseMatchAttribute;
        if (af.a(this.f16683e)) {
            this.f16683e = new ArrayList();
        }
        DBAttributeCache a2 = this.f16681c.a(this.f16682d, new ArrayList());
        if (!(a2 == null || a2.b() == null)) {
            try {
                responseMatchAttribute = (ResponseMatchAttribute) f.f18486a.parseFrom(a2.b(), ResponseMatchAttribute.class);
            } catch (IOException e2) {
                a.a(e2);
                responseMatchAttribute = null;
            }
            if (responseMatchAttribute != null) {
                HashMap hashMap = new HashMap(responseMatchAttribute.narrow_down.size());
                for (AttributeInstance next : responseMatchAttribute.narrow_down) {
                    hashMap.put(next.attr_id, next);
                }
                for (u next2 : this.f16683e) {
                    int a3 = next2.a();
                    if (hashMap.containsKey(Integer.valueOf(a3))) {
                        AttributeInstance attributeInstance = (AttributeInstance) hashMap.get(Integer.valueOf(a3));
                        if (!af.a(attributeInstance.values) && !attributeInstance.values.contains(next2.b())) {
                            next2.a(0);
                        }
                    }
                }
            }
        }
        this.f16683e = af.a(this.f16683e, new af.a<u>() {
            /* renamed from: a */
            public boolean shouldInclude(u uVar) {
                return uVar.c() == 1;
            }
        });
        DBAttributeCache a4 = this.f16681c.a(this.f16682d, this.f16683e);
        ay ayVar = new ay();
        ayVar.a(a4);
        ayVar.a(this.f16682d, a4.a(), this.f16683e);
    }
}
