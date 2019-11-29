package com.thoughtworks.xstream.converters.reflection;

public class Sun14ReflectionProvider extends SunUnsafeReflectionProvider {
    public Sun14ReflectionProvider() {
    }

    public Sun14ReflectionProvider(FieldDictionary fieldDictionary) {
        super(fieldDictionary);
    }

    private Object readResolve() {
        init();
        return this;
    }
}
