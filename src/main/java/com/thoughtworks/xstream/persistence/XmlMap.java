package com.thoughtworks.xstream.persistence;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

public class XmlMap extends AbstractMap {
    /* access modifiers changed from: private */
    public final PersistenceStrategy persistenceStrategy;

    public XmlMap(PersistenceStrategy persistenceStrategy2) {
        this.persistenceStrategy = persistenceStrategy2;
    }

    public int size() {
        return this.persistenceStrategy.size();
    }

    public Object get(Object obj) {
        return this.persistenceStrategy.get(obj);
    }

    public Object put(Object obj, Object obj2) {
        return this.persistenceStrategy.put(obj, obj2);
    }

    public Object remove(Object obj) {
        return this.persistenceStrategy.remove(obj);
    }

    public Set entrySet() {
        return new XmlMapEntries();
    }

    class XmlMapEntries extends AbstractSet {
        XmlMapEntries() {
        }

        public int size() {
            return XmlMap.this.size();
        }

        public boolean isEmpty() {
            return XmlMap.this.isEmpty();
        }

        public Iterator iterator() {
            return XmlMap.this.persistenceStrategy.iterator();
        }
    }
}
