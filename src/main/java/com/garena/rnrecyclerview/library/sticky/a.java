package com.garena.rnrecyclerview.library.sticky;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.garena.rnrecyclerview.library.b;
import com.garena.rnrecyclerview.library.d.c;
import com.garena.rnrecyclerview.library.d.d;
import eu.davidea.flexibleadapter.b.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, d> f8612a;

    /* renamed from: b  reason: collision with root package name */
    private final c f8613b;

    public a(c cVar) {
        this.f8613b = cVar;
    }

    public List<f> a(ReadableMap readableMap) {
        try {
            if (this.f8612a == null) {
                this.f8612a = b(readableMap);
            } else if (b.f8541a) {
                d(readableMap);
            }
            return c(readableMap);
        } catch (Exception e2) {
            com.garena.b.a.a.b("REACT_RECYCLER", (Throwable) e2);
            return new ArrayList();
        }
    }

    private Map<String, d> b(ReadableMap readableMap) {
        if (!readableMap.hasKey("viewConfig")) {
            com.garena.b.a.a.b("REACT_RECYCLER", "DataSource has no 'viewConfig' property");
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        ReadableMap map = readableMap.getMap("viewConfig");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        while (true) {
            boolean z = true;
            if (!keySetIterator.hasNextKey()) {
                break;
            }
            String nextKey = keySetIterator.nextKey();
            ReadableMap map2 = map.getMap(nextKey);
            d dVar = new d();
            dVar.f8565a = nextKey;
            if (!map2.hasKey("isSticky") || !map2.getBoolean("isSticky")) {
                z = false;
            }
            dVar.f8567c = z;
            hashMap.put(dVar.f8565a, dVar);
        }
        TreeSet treeSet = new TreeSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            int hashCode = ((String) entry.getKey()).hashCode();
            if (treeSet.contains(Integer.valueOf(hashCode))) {
                hashCode = ((Integer) treeSet.last()).intValue() + 1;
            }
            treeSet.add(Integer.valueOf(hashCode));
            ((d) entry.getValue()).f8566b = hashCode;
        }
        return hashMap;
    }

    private List<f> c(ReadableMap readableMap) {
        ReadableMap readableMap2 = readableMap;
        if (!readableMap2.hasKey("dataSource")) {
            com.garena.b.a.a.b("REACT_RECYCLER", "DataSource has no 'dataSource' property");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        ReadableArray array = readableMap2.getArray("dataSource");
        com.garena.rnrecyclerview.library.sticky.a.a aVar = null;
        for (int i = 0; i < array.size(); i++) {
            ReadableMap map = array.getMap(i);
            String string = map.getString("viewType");
            String string2 = map.getString("id");
            if (this.f8612a.containsKey(string)) {
                d dVar = this.f8612a.get(string);
                if (dVar.f8567c) {
                    aVar = new com.garena.rnrecyclerview.library.sticky.a.a(string2, i, dVar, this.f8613b);
                } else {
                    com.garena.rnrecyclerview.library.sticky.a.b bVar = r6;
                    com.garena.rnrecyclerview.library.sticky.a.b bVar2 = new com.garena.rnrecyclerview.library.sticky.a.b(string2, i, dVar, this.f8613b, aVar);
                    if (arrayList.contains(bVar)) {
                        com.garena.b.a.a.a("REACT_RECYCLER", String.format(Locale.ENGLISH, "Two rows in the dataSource have the same `id.hashCode()`. id=%1$s | pos: %2$d", new Object[]{string2, Integer.valueOf(i)}));
                    } else {
                        arrayList.add(bVar);
                    }
                }
            } else {
                com.garena.b.a.a.b("REACT_RECYCLER", String.format(Locale.ENGLISH, "Data id=%1$s | pos=%2$d has viewType='%3$s' which is not defied in the viewConfig.", new Object[]{string2, Integer.valueOf(i), string}));
            }
        }
        return arrayList;
    }

    private boolean d(ReadableMap readableMap) {
        return this.f8612a.entrySet().equals(b(readableMap).entrySet());
    }
}
