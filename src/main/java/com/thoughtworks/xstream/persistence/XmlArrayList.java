package com.thoughtworks.xstream.persistence;

import java.util.AbstractList;

public class XmlArrayList extends AbstractList {
    private final XmlMap map;

    public XmlArrayList(PersistenceStrategy persistenceStrategy) {
        this.map = new XmlMap(persistenceStrategy);
    }

    public int size() {
        return this.map.size();
    }

    public Object set(int i, Object obj) {
        rangeCheck(i);
        Object obj2 = get(i);
        this.map.put(new Integer(i), obj);
        return obj2;
    }

    public void add(int i, Object obj) {
        int size = size();
        if (i >= size + 1 || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        int i2 = i != size ? i - 1 : i;
        while (size > i2) {
            this.map.put(new Integer(size + 1), this.map.get(new Integer(size)));
            size--;
        }
        this.map.put(new Integer(i), obj);
    }

    private void rangeCheck(int i) {
        int size = size();
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
    }

    public Object get(int i) {
        rangeCheck(i);
        return this.map.get(new Integer(i));
    }

    public Object remove(int i) {
        int size = size();
        rangeCheck(i);
        Object obj = this.map.get(new Integer(i));
        while (true) {
            int i2 = size - 1;
            if (i < i2) {
                XmlMap xmlMap = this.map;
                Integer num = new Integer(i);
                i++;
                xmlMap.put(num, this.map.get(new Integer(i)));
            } else {
                this.map.remove(new Integer(i2));
                return obj;
            }
        }
    }
}
