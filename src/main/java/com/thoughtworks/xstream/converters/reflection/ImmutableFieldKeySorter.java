package com.thoughtworks.xstream.converters.reflection;

import java.util.Map;

public class ImmutableFieldKeySorter implements FieldKeySorter {
    public Map sort(Class cls, Map map) {
        return map;
    }
}
