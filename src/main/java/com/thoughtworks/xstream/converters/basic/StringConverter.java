package com.thoughtworks.xstream.converters.basic;

import com.thoughtworks.xstream.core.util.WeakCache;
import java.util.Collections;
import java.util.Map;

public class StringConverter extends AbstractSingleValueConverter {
    private static final int LENGTH_LIMIT = 38;
    private final Map cache;
    private final int lengthLimit;

    public StringConverter(Map map, int i) {
        this.cache = map;
        this.lengthLimit = i;
    }

    public StringConverter(Map map) {
        this(map, 38);
    }

    public StringConverter(int i) {
        this(Collections.synchronizedMap(new WeakCache()), i);
    }

    public StringConverter() {
        this(38);
    }

    public boolean canConvert(Class cls) {
        return cls.equals(String.class);
    }

    public Object fromString(String str) {
        if (this.cache == null || str == null) {
            return str;
        }
        if (this.lengthLimit >= 0 && str.length() > this.lengthLimit) {
            return str;
        }
        String str2 = (String) this.cache.get(str);
        if (str2 != null) {
            return str2;
        }
        this.cache.put(str, str);
        return str;
    }
}
