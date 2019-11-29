package com.thoughtworks.xstream.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

public class PresortedSet implements SortedSet {
    private final Comparator comparator;
    private final List list;

    public PresortedSet() {
        this((Comparator) null);
    }

    public PresortedSet(Comparator comparator2) {
        this(comparator2, (Collection) null);
    }

    public PresortedSet(Comparator comparator2, Collection collection) {
        this.list = new ArrayList();
        this.comparator = comparator2;
        if (collection != null) {
            addAll(collection);
        }
    }

    public boolean add(Object obj) {
        return this.list.add(obj);
    }

    public boolean addAll(Collection collection) {
        return this.list.addAll(collection);
    }

    public void clear() {
        this.list.clear();
    }

    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    public boolean containsAll(Collection collection) {
        return this.list.containsAll(collection);
    }

    public boolean equals(Object obj) {
        return this.list.equals(obj);
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public Iterator iterator() {
        return this.list.iterator();
    }

    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    public boolean removeAll(Collection collection) {
        return this.list.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        return this.list.retainAll(collection);
    }

    public int size() {
        return this.list.size();
    }

    public List subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public Object[] toArray(Object[] objArr) {
        return this.list.toArray(objArr);
    }

    public Comparator comparator() {
        return this.comparator;
    }

    public Object first() {
        if (this.list.isEmpty()) {
            return null;
        }
        return this.list.get(0);
    }

    public SortedSet headSet(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Object last() {
        if (this.list.isEmpty()) {
            return null;
        }
        List list2 = this.list;
        return list2.get(list2.size() - 1);
    }

    public SortedSet subSet(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public SortedSet tailSet(Object obj) {
        throw new UnsupportedOperationException();
    }
}
