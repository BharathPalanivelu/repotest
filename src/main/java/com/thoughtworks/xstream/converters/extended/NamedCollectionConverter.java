package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

public class NamedCollectionConverter extends CollectionConverter {
    private final String name;
    private final Class type;

    public NamedCollectionConverter(Mapper mapper, String str, Class cls) {
        this((Class) null, mapper, str, cls);
    }

    public NamedCollectionConverter(Class cls, Mapper mapper, String str, Class cls2) {
        super(mapper, cls);
        this.name = str;
        this.type = cls2;
    }

    /* access modifiers changed from: protected */
    public void writeItem(Object obj, MarshallingContext marshallingContext, HierarchicalStreamWriter hierarchicalStreamWriter) {
        Class cls = obj == null ? Mapper.Null.class : obj.getClass();
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, this.name, cls);
        if (!cls.equals(this.type)) {
            String aliasForSystemAttribute = mapper().aliasForSystemAttribute("class");
            if (aliasForSystemAttribute != null) {
                hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, mapper().serializedClass(cls));
            }
        }
        if (obj != null) {
            marshallingContext.convertAnother(obj);
        }
        hierarchicalStreamWriter.endNode();
    }

    /* access modifiers changed from: protected */
    public Object readItem(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Object obj) {
        String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader, mapper());
        Class realClass = readClassAttribute == null ? this.type : mapper().realClass(readClassAttribute);
        if (Mapper.Null.class.equals(realClass)) {
            return null;
        }
        return unmarshallingContext.convertAnother(obj, realClass);
    }
}
