package com.shopee.app.react.view.modiface;

import com.facebook.react.bridge.ReadableArray;
import d.d.a.b;
import d.d.b.j;
import d.p;

public final class f {
    public static final void a(ReadableArray readableArray, b<Object, p> bVar) {
        j.b(readableArray, "$this$forEach");
        j.b(bVar, "action");
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            switch (g.f19067a[readableArray.getType(i).ordinal()]) {
                case 1:
                    bVar.a(null);
                    break;
                case 2:
                    bVar.a(Boolean.valueOf(readableArray.getBoolean(i)));
                    break;
                case 3:
                    bVar.a(Double.valueOf(readableArray.getDouble(i)));
                    break;
                case 4:
                    bVar.a(readableArray.getString(i));
                    break;
                case 5:
                    bVar.a(readableArray.getMap(i));
                    break;
                case 6:
                    bVar.a(readableArray.getArray(i));
                    break;
                default:
                    throw new IllegalArgumentException("Could not convert object at index: " + i + '.');
            }
        }
    }
}
