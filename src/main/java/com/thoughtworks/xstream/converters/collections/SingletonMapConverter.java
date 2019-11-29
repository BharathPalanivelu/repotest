package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.Collections;

public class SingletonMapConverter extends MapConverter {
    private static final Class MAP = Collections.singletonMap(Boolean.TRUE, (Object) null).getClass();

    public SingletonMapConverter(Mapper mapper) {
        super(mapper);
    }

    public boolean canConvert(Class cls) {
        return MAP == cls;
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        hierarchicalStreamReader.moveDown();
        hierarchicalStreamReader.moveDown();
        Object readItem = readItem(hierarchicalStreamReader, unmarshallingContext, (Object) null);
        hierarchicalStreamReader.moveUp();
        hierarchicalStreamReader.moveDown();
        Object readItem2 = readItem(hierarchicalStreamReader, unmarshallingContext, (Object) null);
        hierarchicalStreamReader.moveUp();
        hierarchicalStreamReader.moveUp();
        return Collections.singletonMap(readItem, readItem2);
    }
}
