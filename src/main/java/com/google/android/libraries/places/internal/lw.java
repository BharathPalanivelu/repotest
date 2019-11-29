package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

class lw {
    public Map<?, ?> a(Object obj) {
        return (lv) obj;
    }

    public Object b(Object obj) {
        ((lv) obj).f12951a = false;
        return obj;
    }

    public lu<?, ?> c(Object obj) {
        throw new NoSuchMethodError();
    }

    public Object a(Object obj, Object obj2) {
        return b(obj, obj2);
    }

    public int a(int i, Object obj, Object obj2) {
        return b(i, obj, obj2);
    }

    lw() {
    }

    static <K, V> lv<K, V> b(Object obj, Object obj2) {
        lv<K, V> lvVar = (lv) obj;
        lv lvVar2 = (lv) obj2;
        if (!lvVar2.isEmpty()) {
            if (!lvVar.f12951a) {
                lvVar = lvVar.a();
            }
            lvVar.b();
            if (!lvVar2.isEmpty()) {
                lvVar.putAll(lvVar2);
            }
        }
        return lvVar;
    }

    static <K, V> int b(int i, Object obj, Object obj2) {
        lv lvVar = (lv) obj;
        if (lvVar.isEmpty()) {
            return 0;
        }
        Iterator it = lvVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
