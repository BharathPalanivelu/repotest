package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.Fields;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetConverter extends CollectionConverter {
    /* access modifiers changed from: private */
    public static final Object constantValue;
    private static final Field sortedMapField = (JVM.hasOptimizedTreeSetAddAll() ? Fields.locate(TreeSet.class, SortedMap.class, false) : null);
    private transient TreeMapConverter treeMapConverter;

    static {
        Map map;
        Object obj = null;
        if (sortedMapField != null) {
            TreeSet treeSet = new TreeSet();
            treeSet.add("1");
            treeSet.add("2");
            try {
                map = (Map) sortedMapField.get(treeSet);
            } catch (IllegalAccessException unused) {
                map = null;
            }
            if (map != null) {
                Object[] array = map.values().toArray();
                if (array[0] == array[1]) {
                    obj = array[0];
                }
            }
        } else {
            Field locate = Fields.locate(TreeSet.class, Object.class, true);
            if (locate != null) {
                try {
                    obj = locate.get((Object) null);
                } catch (IllegalAccessException unused2) {
                }
            }
        }
        constantValue = obj;
    }

    public TreeSetConverter(Mapper mapper) {
        super(mapper, TreeSet.class);
        readResolve();
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        this.treeMapConverter.marshalComparator(((SortedSet) obj).comparator(), hierarchicalStreamWriter, marshallingContext);
        super.marshal(obj, hierarchicalStreamWriter, marshallingContext);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.util.TreeMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.util.TreeSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.util.TreeMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.util.TreeSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.util.TreeSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.TreeSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.util.TreeMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.util.TreeSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.TreeMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.util.TreeMap} */
    /* JADX WARNING: type inference failed for: r4v7, types: [java.util.TreeSet] */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.util.TreeSet] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader r8, com.thoughtworks.xstream.converters.UnmarshallingContext r9) {
        /*
            r7 = this;
            com.thoughtworks.xstream.converters.collections.TreeMapConverter r0 = r7.treeMapConverter
            r1 = 0
            java.util.Comparator r0 = r0.unmarshalComparator(r8, r9, r1)
            boolean r2 = r0 instanceof com.thoughtworks.xstream.mapper.Mapper.Null
            if (r2 == 0) goto L_0x000d
            r3 = r1
            goto L_0x000e
        L_0x000d:
            r3 = r0
        L_0x000e:
            java.lang.reflect.Field r4 = sortedMapField
            if (r4 == 0) goto L_0x003a
            if (r3 != 0) goto L_0x001a
            java.util.TreeSet r4 = new java.util.TreeSet
            r4.<init>()
            goto L_0x001f
        L_0x001a:
            java.util.TreeSet r4 = new java.util.TreeSet
            r4.<init>(r3)
        L_0x001f:
            java.lang.reflect.Field r5 = sortedMapField     // Catch:{ IllegalAccessException -> 0x0031 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ IllegalAccessException -> 0x0031 }
            boolean r6 = r5 instanceof java.util.TreeMap
            if (r6 == 0) goto L_0x002d
            java.util.TreeMap r5 = (java.util.TreeMap) r5
            r1 = r4
            goto L_0x002e
        L_0x002d:
            r5 = r1
        L_0x002e:
            r4 = r1
            r1 = r5
            goto L_0x003b
        L_0x0031:
            r8 = move-exception
            com.thoughtworks.xstream.converters.ConversionException r9 = new com.thoughtworks.xstream.converters.ConversionException
            java.lang.String r0 = "Cannot get backing map of TreeSet"
            r9.<init>(r0, r8)
            throw r9
        L_0x003a:
            r4 = r1
        L_0x003b:
            if (r1 != 0) goto L_0x0065
            com.thoughtworks.xstream.core.util.PresortedSet r0 = new com.thoughtworks.xstream.core.util.PresortedSet
            r0.<init>(r3)
            if (r3 != 0) goto L_0x004a
            java.util.TreeSet r1 = new java.util.TreeSet
            r1.<init>()
            goto L_0x004f
        L_0x004a:
            java.util.TreeSet r1 = new java.util.TreeSet
            r1.<init>(r3)
        L_0x004f:
            r4 = r1
            if (r2 == 0) goto L_0x0058
            r7.addCurrentElementToCollection(r8, r9, r4, r0)
            r8.moveUp()
        L_0x0058:
            r7.populateCollection(r8, r9, r4, r0)
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x006a
            r4.addAll(r0)
            goto L_0x006a
        L_0x0065:
            com.thoughtworks.xstream.converters.collections.TreeMapConverter r2 = r7.treeMapConverter
            r2.populateTreeMap(r8, r9, r1, r0)
        L_0x006a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.converters.collections.TreeSetConverter.unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext):java.lang.Object");
    }

    private Object readResolve() {
        this.treeMapConverter = new TreeMapConverter(mapper()) {
            /* access modifiers changed from: protected */
            public void populateMap(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Map map, final Map map2) {
                TreeSetConverter.this.populateCollection(hierarchicalStreamReader, unmarshallingContext, new AbstractList() {
                    public Object get(int i) {
                        return null;
                    }

                    public boolean add(Object obj) {
                        return map2.put(obj, TreeSetConverter.constantValue != null ? TreeSetConverter.constantValue : obj) != null;
                    }

                    public int size() {
                        return map2.size();
                    }
                });
            }

            /* access modifiers changed from: protected */
            public void putCurrentEntryIntoMap(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Map map, Map map2) {
                Object readItem = readItem(hierarchicalStreamReader, unmarshallingContext, map);
                map2.put(readItem, readItem);
            }
        };
        return this;
    }
}
