package com.salesforce.android.service.common.liveagentclient.json;

import com.google.a.i;
import com.google.a.l;
import com.google.a.s;
import com.google.a.t;
import java.lang.reflect.Type;
import java.util.Collection;

class CollectionSerializer implements t<Collection<?>> {
    CollectionSerializer() {
    }

    public l serialize(Collection<?> collection, Type type, s sVar) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        i iVar = new i();
        for (Object a2 : collection) {
            iVar.a(sVar.a(a2));
        }
        return iVar;
    }
}
