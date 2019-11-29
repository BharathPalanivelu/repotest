package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.core.Caching;
import com.thoughtworks.xstream.core.util.OrderRetainingMap;
import com.thoughtworks.xstream.io.StreamException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortableFieldKeySorter implements FieldKeySorter, Caching {
    private final Map map = new HashMap();

    public Map sort(Class cls, Map map2) {
        if (!this.map.containsKey(cls)) {
            return map2;
        }
        OrderRetainingMap orderRetainingMap = new OrderRetainingMap();
        FieldKey[] fieldKeyArr = (FieldKey[]) map2.keySet().toArray(new FieldKey[map2.size()]);
        Arrays.sort(fieldKeyArr, (Comparator) this.map.get(cls));
        for (int i = 0; i < fieldKeyArr.length; i++) {
            orderRetainingMap.put(fieldKeyArr[i], map2.get(fieldKeyArr[i]));
        }
        return orderRetainingMap;
    }

    public void registerFieldOrder(Class cls, String[] strArr) {
        this.map.put(cls, new FieldComparator(strArr));
    }

    private class FieldComparator implements Comparator {
        private final String[] fieldOrder;

        public FieldComparator(String[] strArr) {
            this.fieldOrder = strArr;
        }

        public int compare(String str, String str2) {
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            while (true) {
                String[] strArr = this.fieldOrder;
                if (i >= strArr.length) {
                    break;
                }
                if (strArr[i].equals(str)) {
                    i2 = i;
                }
                if (this.fieldOrder[i].equals(str2)) {
                    i3 = i;
                }
                i++;
            }
            if (i2 != -1 && i3 != -1) {
                return i2 - i3;
            }
            throw new StreamException("You have not given XStream a list of all fields to be serialized.");
        }

        public int compare(Object obj, Object obj2) {
            return compare(((FieldKey) obj).getFieldName(), ((FieldKey) obj2).getFieldName());
        }
    }

    public void flushCache() {
        this.map.clear();
    }
}
