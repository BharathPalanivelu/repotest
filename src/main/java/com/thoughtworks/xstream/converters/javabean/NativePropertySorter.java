package com.thoughtworks.xstream.converters.javabean;

import java.util.Map;

public class NativePropertySorter implements PropertySorter {
    public Map sort(Class cls, Map map) {
        return map;
    }
}
