package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.Types;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.io.Serializable;

public class LambdaConverter extends SerializableConverter {
    public LambdaConverter(Mapper mapper, ReflectionProvider reflectionProvider, ClassLoaderReference classLoaderReference) {
        super(mapper, reflectionProvider, classLoaderReference);
    }

    public boolean canConvert(Class cls) {
        return Types.isLambdaType(cls) && (JVM.canCreateDerivedObjectOutputStream() || !Serializable.class.isAssignableFrom(cls));
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        if (obj instanceof Serializable) {
            super.marshal(obj, hierarchicalStreamWriter, marshallingContext);
        }
    }
}
