package com.thoughtworks.xstream.core.util;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PrioritizedList {
    private int lastId = 0;
    private int lowestPriority = Integer.MAX_VALUE;
    private final Set set = new TreeSet();

    public void add(Object obj, int i) {
        if (this.lowestPriority > i) {
            this.lowestPriority = i;
        }
        Set set2 = this.set;
        int i2 = this.lastId + 1;
        this.lastId = i2;
        set2.add(new PrioritizedItem(obj, i, i2));
    }

    public Iterator iterator() {
        return new PrioritizedItemIterator(this.set.iterator());
    }

    private static class PrioritizedItem implements Comparable {
        final int id;
        final int priority;
        final Object value;

        public PrioritizedItem(Object obj, int i, int i2) {
            this.value = obj;
            this.priority = i;
            this.id = i2;
        }

        public int compareTo(Object obj) {
            PrioritizedItem prioritizedItem = (PrioritizedItem) obj;
            int i = this.priority;
            int i2 = prioritizedItem.priority;
            if (i != i2) {
                return i2 - i;
            }
            return prioritizedItem.id - this.id;
        }

        public boolean equals(Object obj) {
            return this.id == ((PrioritizedItem) obj).id;
        }
    }

    private static class PrioritizedItemIterator implements Iterator {
        private Iterator iterator;

        public PrioritizedItemIterator(Iterator it) {
            this.iterator = it;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public Object next() {
            return ((PrioritizedItem) this.iterator.next()).value;
        }
    }
}
