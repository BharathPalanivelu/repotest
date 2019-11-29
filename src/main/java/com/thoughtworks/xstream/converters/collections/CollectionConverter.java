package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;

public class CollectionConverter extends AbstractCollectionConverter {
    private final Class type;

    public CollectionConverter(Mapper mapper) {
        this(mapper, (Class) null);
    }

    public CollectionConverter(Mapper mapper, Class cls) {
        super(mapper);
        this.type = cls;
        if (cls != null && !Collection.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(cls + " not of type " + Collection.class);
        }
    }

    public boolean canConvert(Class cls) {
        Class cls2 = this.type;
        if (cls2 != null) {
            return cls.equals(cls2);
        }
        return cls.equals(ArrayList.class) || cls.equals(HashSet.class) || cls.equals(LinkedList.class) || cls.equals(Vector.class) || (JVM.is14() && cls.getName().equals("java.util.LinkedHashSet"));
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        for (Object writeItem : (Collection) obj) {
            writeItem(writeItem, marshallingContext, hierarchicalStreamWriter);
        }
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Collection collection = (Collection) createCollection(unmarshallingContext.getRequiredType());
        populateCollection(hierarchicalStreamReader, unmarshallingContext, collection);
        return collection;
    }

    /* access modifiers changed from: protected */
    public void populateCollection(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Collection collection) {
        populateCollection(hierarchicalStreamReader, unmarshallingContext, collection, collection);
    }

    /* access modifiers changed from: protected */
    public void populateCollection(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Collection collection, Collection collection2) {
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            addCurrentElementToCollection(hierarchicalStreamReader, unmarshallingContext, collection, collection2);
            hierarchicalStreamReader.moveUp();
        }
    }

    /* access modifiers changed from: protected */
    public void addCurrentElementToCollection(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Collection collection, Collection collection2) {
        collection2.add(readItem(hierarchicalStreamReader, unmarshallingContext, collection));
    }

    /* access modifiers changed from: protected */
    public Object createCollection(Class cls) {
        Class cls2 = this.type;
        if (cls2 != null) {
            cls = cls2;
        }
        return super.createCollection(cls);
    }
}
