package com.thoughtworks.xstream.core.util;

public class ClassLoaderReference extends ClassLoader {
    private transient ClassLoader reference;

    public ClassLoaderReference(ClassLoader classLoader) {
        this.reference = classLoader;
    }

    public Class loadClass(String str) throws ClassNotFoundException {
        return this.reference.loadClass(str);
    }

    public ClassLoader getReference() {
        return this.reference;
    }

    public void setReference(ClassLoader classLoader) {
        this.reference = classLoader;
    }

    private Object writeReplace() {
        return new Replacement();
    }

    static class Replacement {
        Replacement() {
        }

        private Object readResolve() {
            return new ClassLoaderReference(new CompositeClassLoader());
        }
    }
}
