package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;

public class HierarchicalStreams {
    public static Class readClassType(HierarchicalStreamReader hierarchicalStreamReader, Mapper mapper) {
        String readClassAttribute = readClassAttribute(hierarchicalStreamReader, mapper);
        if (readClassAttribute == null) {
            return mapper.realClass(hierarchicalStreamReader.getNodeName());
        }
        return mapper.realClass(readClassAttribute);
    }

    public static String readClassAttribute(HierarchicalStreamReader hierarchicalStreamReader, Mapper mapper) {
        String str;
        String aliasForSystemAttribute = mapper.aliasForSystemAttribute("resolves-to");
        if (aliasForSystemAttribute == null) {
            str = null;
        } else {
            str = hierarchicalStreamReader.getAttribute(aliasForSystemAttribute);
        }
        if (str != null) {
            return str;
        }
        String aliasForSystemAttribute2 = mapper.aliasForSystemAttribute("class");
        return aliasForSystemAttribute2 != null ? hierarchicalStreamReader.getAttribute(aliasForSystemAttribute2) : str;
    }
}
