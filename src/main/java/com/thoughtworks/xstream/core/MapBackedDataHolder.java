package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.DataHolder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapBackedDataHolder implements DataHolder {
    private final Map map;

    public MapBackedDataHolder() {
        this(new HashMap());
    }

    public MapBackedDataHolder(Map map2) {
        this.map = map2;
    }

    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public void put(Object obj, Object obj2) {
        this.map.put(obj, obj2);
    }

    public Iterator keys() {
        return Collections.unmodifiableCollection(this.map.keySet()).iterator();
    }
}
