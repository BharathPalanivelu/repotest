package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.Collections;

public class SingletonCollectionConverter extends CollectionConverter {
    private static final Class LIST = Collections.singletonList(Boolean.TRUE).getClass();
    private static final Class SET = Collections.singleton(Boolean.TRUE).getClass();

    public SingletonCollectionConverter(Mapper mapper) {
        super(mapper);
    }

    public boolean canConvert(Class cls) {
        return LIST == cls || SET == cls;
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        hierarchicalStreamReader.moveDown();
        Object readItem = readItem(hierarchicalStreamReader, unmarshallingContext, (Object) null);
        hierarchicalStreamReader.moveUp();
        if (unmarshallingContext.getRequiredType() == LIST) {
            return Collections.singletonList(readItem);
        }
        return Collections.singleton(readItem);
    }
}
