package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.core.Caching;
import com.thoughtworks.xstream.core.util.SerializationMembers;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationMethodInvoker implements Caching {
    SerializationMembers serializationMembers = new SerializationMembers();

    public Object callReadResolve(Object obj) {
        return this.serializationMembers.callReadResolve(obj);
    }

    public Object callWriteReplace(Object obj) {
        return this.serializationMembers.callWriteReplace(obj);
    }

    public boolean supportsReadObject(Class cls, boolean z) {
        return this.serializationMembers.supportsReadObject(cls, z);
    }

    public void callReadObject(Class cls, Object obj, ObjectInputStream objectInputStream) {
        this.serializationMembers.callReadObject(cls, obj, objectInputStream);
    }

    public boolean supportsWriteObject(Class cls, boolean z) {
        return this.serializationMembers.supportsWriteObject(cls, z);
    }

    public void callWriteObject(Class cls, Object obj, ObjectOutputStream objectOutputStream) {
        this.serializationMembers.callWriteObject(cls, obj, objectOutputStream);
    }

    public void flushCache() {
        this.serializationMembers.flushCache();
    }
}
