package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.core.util.Primitives;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class NamedArrayConverter implements Converter {
    private final Class arrayType;
    private final String itemName;
    private final Mapper mapper;

    public NamedArrayConverter(Class cls, Mapper mapper2, String str) {
        if (cls.isArray()) {
            this.arrayType = cls;
            this.mapper = mapper2;
            this.itemName = str;
            return;
        }
        throw new IllegalArgumentException(cls.getName() + " is not an array");
    }

    public boolean canConvert(Class cls) {
        return cls == this.arrayType;
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Class cls;
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 == null) {
                cls = Mapper.Null.class;
            } else if (this.arrayType.getComponentType().isPrimitive()) {
                cls = Primitives.unbox(obj2.getClass());
            } else {
                cls = obj2.getClass();
            }
            ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, this.itemName, cls);
            if (!cls.equals(this.arrayType.getComponentType())) {
                String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("class");
                if (aliasForSystemAttribute != null) {
                    hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, this.mapper.serializedClass(cls));
                }
            }
            if (obj2 != null) {
                marshallingContext.convertAnother(obj2);
            }
            hierarchicalStreamWriter.endNode();
        }
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        ArrayList arrayList = new ArrayList();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader, this.mapper);
            Class<?> componentType = readClassAttribute == null ? this.arrayType.getComponentType() : this.mapper.realClass(readClassAttribute);
            Object obj = null;
            if (!Mapper.Null.class.equals(componentType)) {
                obj = unmarshallingContext.convertAnother((Object) null, componentType);
            }
            arrayList.add(obj);
            hierarchicalStreamReader.moveUp();
        }
        Object newInstance = Array.newInstance(this.arrayType.getComponentType(), arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
