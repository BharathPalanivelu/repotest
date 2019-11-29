package com.thoughtworks.xstream.converters.javabean;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ComparingPropertySorter implements PropertySorter {
    private final Comparator comparator;

    public ComparingPropertySorter(Comparator comparator2) {
        this.comparator = comparator2;
    }

    public Map sort(Class cls, Map map) {
        TreeMap treeMap = new TreeMap(this.comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
