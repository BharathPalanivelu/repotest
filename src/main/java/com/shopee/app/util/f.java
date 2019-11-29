package com.shopee.app.util;

import android.os.Bundle;
import com.google.a.l;
import com.google.a.o;
import d.d.b.j;
import java.util.Map;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f26349a = new f();

    public enum a {
        Boolean,
        Number,
        String,
        Null,
        Unsupported
    }

    private f() {
    }

    public final Bundle a(o oVar) {
        j.b(oVar, "jsonObject");
        try {
            Bundle bundle = new Bundle();
            for (Map.Entry next : oVar.a()) {
                Object value = next.getValue();
                j.a(value, "entry.value");
                int i = g.f26354a[h.a((l) value).ordinal()];
                if (i == 1) {
                    Object value2 = next.getValue();
                    j.a(value2, "entry.value");
                    bundle.putBoolean((String) next.getKey(), ((l) value2).h());
                } else if (i == 2) {
                    Object value3 = next.getValue();
                    j.a(value3, "entry.value");
                    bundle.putDouble((String) next.getKey(), ((l) value3).d());
                } else if (i == 3) {
                    Object value4 = next.getValue();
                    j.a(value4, "entry.value");
                    bundle.putString((String) next.getKey(), ((l) value4).c());
                } else if (i == 4) {
                    bundle.putString((String) next.getKey(), (String) null);
                }
            }
            return bundle;
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }
}
