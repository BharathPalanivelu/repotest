package com.thoughtworks.xstream.persistence;

import java.util.AbstractSet;
import java.util.Iterator;

public class XmlSet extends AbstractSet {
    private final XmlMap map;

    public XmlSet(PersistenceStrategy persistenceStrategy) {
        this.map = new XmlMap(persistenceStrategy);
    }

    public Iterator iterator() {
        return this.map.values().iterator();
    }

    public int size() {
        return this.map.size();
    }

    public boolean add(Object obj) {
        if (this.map.containsValue(obj)) {
            return false;
        }
        this.map.put(findEmptyKey(), obj);
        return true;
    }

    private Long findEmptyKey() {
        long currentTimeMillis = System.currentTimeMillis();
        while (this.map.containsKey(new Long(currentTimeMillis))) {
            currentTimeMillis++;
        }
        return new Long(currentTimeMillis);
    }
}
