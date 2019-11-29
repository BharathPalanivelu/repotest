package com.shopee.arcatch.data.h5_bean;

import com.google.a.c.a;
import com.google.a.f;
import com.google.a.g;
import com.google.a.i;
import com.google.a.j;
import com.google.a.k;
import com.google.a.l;
import com.google.a.p;
import java.lang.reflect.Type;

public class H5ConfigParseUtil {
    private static final k<MetaValue> META_VALUE_JSON_DESERIALIZER = new k<MetaValue>() {
        public MetaValue deserialize(l lVar, Type type, j jVar) throws p {
            MetaValue metaValue = new MetaValue();
            if (lVar.i()) {
                i n = lVar.n();
                if (!(n == null || n.a() == 0)) {
                    metaValue.setValue(n.a(0).c());
                }
            } else if (lVar.k()) {
                metaValue.setValue(lVar.c());
            }
            return metaValue;
        }
    };
    private static final Type TypeMetaValue = new a<MetaValue>() {
    }.getType();

    public static ArCatchH5BeginBean parseArCatchH5BeginBean(String str) {
        f d2 = new g().a(TypeMetaValue, (Object) META_VALUE_JSON_DESERIALIZER).d();
        try {
            return (ArCatchH5BeginBean) d2.a(((ArCatchH5BeginParamsBean) d2.a(str, ArCatchH5BeginParamsBean.class)).getArCatchH5BeginBean(), ArCatchH5BeginBean.class);
        } catch (Exception e2) {
            com.shopee.e.a.a.a(e2, "parseArCatchH5BeginBean failed", new Object[0]);
            e2.printStackTrace();
            return null;
        }
    }
}
