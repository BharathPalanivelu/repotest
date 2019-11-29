package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayConverter extends AbstractCollectionConverter {
    public ArrayConverter(Mapper mapper) {
        super(mapper);
    }

    public boolean canConvert(Class cls) {
        return cls.isArray();
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            writeItem(Array.get(obj, i), marshallingContext, hierarchicalStreamWriter);
        }
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        ArrayList<Object> arrayList = new ArrayList<>();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            arrayList.add(readItem(hierarchicalStreamReader, unmarshallingContext, (Object) null));
            hierarchicalStreamReader.moveUp();
        }
        Object newInstance = Array.newInstance(unmarshallingContext.getRequiredType().getComponentType(), arrayList.size());
        int i = 0;
        for (Object obj : arrayList) {
            Array.set(newInstance, i, obj);
            i++;
        }
        return newInstance;
    }
}
