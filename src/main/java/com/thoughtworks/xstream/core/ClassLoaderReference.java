package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.core.util.CompositeClassLoader;

public final class ClassLoaderReference {
    private transient ClassLoader reference;

    public ClassLoaderReference(ClassLoader classLoader) {
        setReference(classLoader);
    }

    public ClassLoader getReference() {
        return this.reference;
    }

    public void setReference(ClassLoader classLoader) {
        if (classLoader instanceof com.thoughtworks.xstream.core.util.ClassLoaderReference) {
            classLoader = ((com.thoughtworks.xstream.core.util.ClassLoaderReference) classLoader).getReference();
        }
        this.reference = classLoader;
    }

    private Object readResolve() {
        this.reference = new CompositeClassLoader();
        return this;
    }
}
