package com.thoughtworks.xstream.mapper;

import java.util.HashSet;
import java.util.Set;

public class ImmutableTypesMapper extends MapperWrapper {
    private final Set immutableTypes = new HashSet();

    public ImmutableTypesMapper(Mapper mapper) {
        super(mapper);
    }

    public void addImmutableType(Class cls) {
        this.immutableTypes.add(cls);
    }

    public boolean isImmutableValueType(Class cls) {
        if (this.immutableTypes.contains(cls)) {
            return true;
        }
        return super.isImmutableValueType(cls);
    }
}
