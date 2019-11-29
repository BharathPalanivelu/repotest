package com.thoughtworks.xstream.converters.enums;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.core.util.Fields;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Field;
import java.util.EnumMap;

public class EnumMapConverter extends MapConverter {
    private static final Field typeField = Fields.locate(EnumMap.class, Class.class, false);

    public EnumMapConverter(Mapper mapper) {
        super(mapper);
    }

    public boolean canConvert(Class cls) {
        return typeField != null && cls == EnumMap.class;
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Class cls = (Class) Fields.read(typeField, obj);
        String aliasForSystemAttribute = mapper().aliasForSystemAttribute("enum-type");
        if (aliasForSystemAttribute != null) {
            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, mapper().serializedClass(cls));
        }
        super.marshal(obj, hierarchicalStreamWriter, marshallingContext);
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String aliasForSystemAttribute = mapper().aliasForSystemAttribute("enum-type");
        if (aliasForSystemAttribute != null) {
            EnumMap enumMap = new EnumMap(mapper().realClass(hierarchicalStreamReader.getAttribute(aliasForSystemAttribute)));
            populateMap(hierarchicalStreamReader, unmarshallingContext, enumMap);
            return enumMap;
        }
        throw new ConversionException("No EnumType specified for EnumMap");
    }
}
