package com.garena.rnrecyclerview.library.b;

import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.garena.rnrecyclerview.library.b;
import com.garena.rnrecyclerview.library.d.d;
import com.garena.rnrecyclerview.library.d.f;
import com.garena.rnrecyclerview.library.recycler.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, d> f8542a;

    /* renamed from: b  reason: collision with root package name */
    private f f8543b;

    public a(f fVar) {
        this.f8543b = fVar;
    }

    public List<c> a(ReadableMap readableMap) {
        try {
            if (this.f8542a == null) {
                this.f8542a = b(readableMap);
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
            this.f8543b.a(hashCode, (String) entry.getKey());
        }
        return hashMap;
    }

    private List<c> c(ReadableMap readableMap) {
        if (!readableMap.hasKey("dataSource")) {
            com.garena.b.a.a.b("REACT_RECYCLER", "DataSource has no 'dataSource' property");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        ReadableArray array = readableMap.getArray("dataSource");
        int i = -1;
        for (int i2 = 0; i2 < array.size(); i2++) {
            ReadableMap map = array.getMap(i2);
            String string = map.getString("viewType");
            String string2 = map.getString("id");
            String string3 = map.hasKey(ServerProtocol.DIALOG_PARAM_STATE) ? map.getString(ServerProtocol.DIALOG_PARAM_STATE) : "";
            if (this.f8542a.containsKey(string)) {
                d dVar = this.f8542a.get(string);
                if (dVar.f8567c) {
                    i = i2;
                }
                c cVar = new c();
                cVar.f8602c = string2;
                cVar.f8600a = dVar.f8566b;
                cVar.f8601b = string;
                cVar.f8603d = i;
                cVar.f8604e = string3;
                if (arrayList.contains(cVar)) {
                    com.garena.b.a.a.a("REACT_RECYCLER", String.format(Locale.ENGLISH, "Two rows in the dataSource have the same `id.hashCode()`. id=%1$s | pos: %2$d", new Object[]{string2, Integer.valueOf(i2)}));
                } else {
                    arrayList.add(cVar);
                }
            } else {
                com.garena.b.a.a.b("REACT_RECYCLER", String.format(Locale.ENGLISH, "Data id=%1$s | pos=%2$d has viewType='%3$s' which is not defied in the viewConfig.", new Object[]{string2, Integer.valueOf(i2), string}));
            }
        }
        return arrayList;
    }

    private boolean d(ReadableMap readableMap) {
        return this.f8542a.entrySet().equals(b(readableMap).entrySet());
    }
}
