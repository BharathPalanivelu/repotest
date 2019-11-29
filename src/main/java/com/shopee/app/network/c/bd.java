package com.shopee.app.network.c;

import android.text.TextUtils;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.g;
import com.shopee.app.database.orm.bean.DBAttributeCache;
import com.shopee.app.h.o;
import com.shopee.app.network.d.ay;
import com.shopee.app.network.f;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.util.af;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseMatchAttribute;
import com.shopee.protocol.shop.AttributeInstance;
import java.io.IOException;

public class bd extends c {
    public int a() {
        return 238;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseMatchAttribute responseMatchAttribute = (ResponseMatchAttribute) f.f18486a.parseFrom(bArr, 0, i, ResponseMatchAttribute.class);
        c(responseMatchAttribute.requestid);
        c().a(responseMatchAttribute, bArr);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newMatchItemAttributeProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17855a;

        /* renamed from: b  reason: collision with root package name */
        private final bi f17856b;

        /* renamed from: c  reason: collision with root package name */
        private final g f17857c;

        public a(n nVar, bi biVar, g gVar) {
            this.f17855a = nVar;
            this.f17856b = biVar;
            this.f17857c = gVar;
        }

        public void a(ResponseMatchAttribute responseMatchAttribute, byte[] bArr) {
            if (a(responseMatchAttribute)) {
                ay ayVar = (ay) o.a().f(responseMatchAttribute.requestid);
                if (ayVar != null) {
                    DBAttributeCache c2 = ayVar.c();
                    if (c2.b() == null) {
                        c2.a(responseMatchAttribute.signature.i());
                        c2.c(bArr);
                    } else if (!responseMatchAttribute.signature.equals(e.f.a(c2.a()))) {
                        c2.a(responseMatchAttribute.signature.i());
                        c2.c(bArr);
                    } else {
                        try {
                            responseMatchAttribute = (ResponseMatchAttribute) f.f18486a.parseFrom(c2.b(), ResponseMatchAttribute.class);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.f17857c.a(c2);
                    String str = null;
                    if (!af.a(responseMatchAttribute.suggest) && responseMatchAttribute.suggest.size() > 0) {
                        AttributeInstance attributeInstance = responseMatchAttribute.suggest.get(0);
                        int a2 = b.a(attributeInstance.attr_id);
                        if (!af.a(attributeInstance.values) && attributeInstance.values.size() > 0) {
                            str = b.a(attributeInstance.values.get(0));
                        }
                        if (a2 > 0 && !TextUtils.isEmpty(str)) {
                            this.f17856b.a("ON_ATTRIBUTE_AUTO_SELECTED", new com.garena.android.appkit.b.a(new u(a2, str, 2)));
                            this.f17855a.a("ON_ATTRIBUTE_AUTO_SELECTED", new com.garena.android.appkit.b.a(new u(a2, str, 2)));
                        }
                    }
                    for (AttributeInstance next : responseMatchAttribute.narrow_down) {
                        if (next.values != null && next.values.size() == 1) {
                            u uVar = new u(next.attr_id.intValue(), next.values.get(0), 2);
                            this.f17856b.a("ON_ATTRIBUTE_AUTO_SELECTED", new com.garena.android.appkit.b.a(uVar));
                            this.f17855a.a("ON_ATTRIBUTE_AUTO_SELECTED", new com.garena.android.appkit.b.a(uVar));
                        }
                    }
                    this.f17855a.a("CMD_MATCH_ATTRIBUTE_SUCCESS", (com.garena.android.appkit.b.a) new com.shopee.app.ui.product.add.af(ayVar.b(), ayVar.d()));
                }
            }
        }

        private boolean a(ResponseMatchAttribute responseMatchAttribute) {
            if (b.a(responseMatchAttribute.errcode) == 0) {
                return true;
            }
            this.f17855a.a("CMD_MATCH_ATTRIBUTE_ERROR", new com.garena.android.appkit.b.a(responseMatchAttribute.errcode));
            return false;
        }

        public void a() {
            this.f17855a.a("CMD_MATCH_ATTRIBUTE_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
