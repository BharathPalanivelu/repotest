package com.thoughtworks.xstream.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class PresortedMap implements SortedMap {
    private final Comparator comparator;
    private final ArraySet set;

    public boolean containsKey(Object obj) {
        return false;
    }

    private static class ArraySet extends ArrayList implements Set {
        private ArraySet() {
        }
    }

    public PresortedMap() {
        this((Comparator) null, new ArraySet());
    }

    public PresortedMap(Comparator comparator2) {
        this(comparator2, new ArraySet());
    }

    private PresortedMap(Comparator comparator2, ArraySet arraySet) {
        this.comparator = comparator2 == null ? new ArraySetComparator(arraySet) : comparator2;
        this.set = arraySet;
    }

    public Comparator comparator() {
        return this.comparator;
    }

    public Set entrySet() {
        return this.set;
    }

    public Object firstKey() {
        throw new UnsupportedOperationException();
    }

    public SortedMap headMap(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Set keySet() {
        ArraySet arraySet = new ArraySet();
        Iterator it = this.set.iterator();
        while (it.hasNext()) {
            arraySet.add(((Map.Entry) it.next()).getKey());
        }
        return arraySet;
    }

    public Object lastKey() {
        throw new UnsupportedOperationException();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public SortedMap tailMap(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Collection values() {
        ArraySet arraySet = new ArraySet();
        Iterator it = this.set.iterator();
        while (it.hasNext()) {
            arraySet.add(((Map.Entry) it.next()).getValue());
        }
        return arraySet;
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Object get(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    public Object put(final Object obj, final Object obj2) {
        this.set.add(new Map.Entry() {
            public Object getKey() {
                return obj;
            }

            public Object getValue() {
                return obj2;
            }

            public Object setValue(Object obj) {
                throw new UnsupportedOperationException();
            }
        });
        return null;
    }

    public void putAll(Map map) {
        for (Object add : map.entrySet()) {
            this.set.add(add);
        }
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.set.size();
    }

    private static class ArraySetComparator implements Comparator {
        private Map.Entry[] array;
        private final ArrayList list;

        ArraySetComparator(ArrayList arrayList) {
            this.list = arrayList;
        }

        public int compare(Object obj, Object obj2) {
            if (this.array == null || this.list.size() != this.array.length) {
                Map.Entry[] entryArr = new Map.Entry[this.list.size()];
                Map.Entry[] entryArr2 = this.array;
                if (entryArr2 != null) {
                    System.arraycopy(entryArr2, 0, entryArr, 0, entryArr2.length);
                }
                Map.Entry[] entryArr3 = this.array;
                for (int length = entryArr3 == null ? 0 : entryArr3.length; length < this.list.size(); length++) {
                    entryArr[length] = (Map.Entry) this.list.get(length);
                }
                this.array = entryArr;
            }
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < this.array.length && (i >= Integer.MAX_VALUE || i2 >= Integer.MAX_VALUE); i3++) {
                if (i == Integer.MAX_VALUE && obj == this.array[i3].getKey()) {
                    i = i3;
                }
                if (i2 == Integer.MAX_VALUE && obj2 == this.array[i3].getKey()) {
                    i2 = i3;
                }
            }
            return i - i2;
        }
    }
}
