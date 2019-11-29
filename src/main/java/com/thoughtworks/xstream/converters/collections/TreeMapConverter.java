package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.Fields;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.core.util.PresortedMap;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapConverter extends MapConverter {
    private static final Comparator NULL_MARKER = new NullComparator();
    private static final Field comparatorField = Fields.locate(TreeMap.class, Comparator.class, false);

    private static final class NullComparator extends Mapper.Null implements Comparator {
        private NullComparator() {
        }

        public int compare(Object obj, Object obj2) {
            Comparable comparable = (Comparable) obj2;
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public TreeMapConverter(Mapper mapper) {
        super(mapper, TreeMap.class);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        marshalComparator(((SortedMap) obj).comparator(), hierarchicalStreamWriter, marshallingContext);
        super.marshal(obj, hierarchicalStreamWriter, marshallingContext);
    }

    /* access modifiers changed from: protected */
    public void marshalComparator(Comparator comparator, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        if (comparator != null) {
            hierarchicalStreamWriter.startNode("comparator");
            hierarchicalStreamWriter.addAttribute(mapper().aliasForSystemAttribute("class"), mapper().serializedClass(comparator.getClass()));
            marshallingContext.convertAnother(comparator);
            hierarchicalStreamWriter.endNode();
        }
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        TreeMap treeMap = comparatorField != null ? new TreeMap() : null;
        Comparator unmarshalComparator = unmarshalComparator(hierarchicalStreamReader, unmarshallingContext, treeMap);
        if (treeMap == null) {
            treeMap = unmarshalComparator == null ? new TreeMap() : new TreeMap(unmarshalComparator);
        }
        populateTreeMap(hierarchicalStreamReader, unmarshallingContext, treeMap, unmarshalComparator);
        return treeMap;
    }

    /* access modifiers changed from: protected */
    public Comparator unmarshalComparator(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, TreeMap treeMap) {
        Comparator comparator = null;
        if (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            if (hierarchicalStreamReader.getNodeName().equals("comparator")) {
                comparator = (Comparator) unmarshallingContext.convertAnother(treeMap, HierarchicalStreams.readClassType(hierarchicalStreamReader, mapper()));
            } else if (!hierarchicalStreamReader.getNodeName().equals("no-comparator")) {
                return NULL_MARKER;
            }
            hierarchicalStreamReader.moveUp();
        }
        return comparator;
    }

    /* access modifiers changed from: protected */
    public void populateTreeMap(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, TreeMap treeMap, Comparator comparator) {
        boolean z = comparator == NULL_MARKER;
        Comparator comparator2 = null;
        if (z) {
            comparator = null;
        }
        if (comparator != null && JVM.hasOptimizedTreeMapPutAll()) {
            comparator2 = comparator;
        }
        PresortedMap presortedMap = new PresortedMap(comparator2);
        if (z) {
            putCurrentEntryIntoMap(hierarchicalStreamReader, unmarshallingContext, treeMap, presortedMap);
            hierarchicalStreamReader.moveUp();
        }
        populateMap(hierarchicalStreamReader, unmarshallingContext, treeMap, presortedMap);
        try {
            if (JVM.hasOptimizedTreeMapPutAll()) {
                if (!(comparator == null || comparatorField == null)) {
                    comparatorField.set(treeMap, comparator);
                }
                treeMap.putAll(presortedMap);
            } else if (comparatorField != null) {
                comparatorField.set(treeMap, presortedMap.comparator());
                treeMap.putAll(presortedMap);
                comparatorField.set(treeMap, comparator);
            } else {
                treeMap.putAll(presortedMap);
            }
        } catch (IllegalAccessException e2) {
            throw new ConversionException("Cannot set comparator of TreeMap", e2);
        }
    }
}
