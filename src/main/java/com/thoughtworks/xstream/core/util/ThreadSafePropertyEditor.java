package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.core.util.Pool;
import java.beans.PropertyEditor;

public class ThreadSafePropertyEditor {
    /* access modifiers changed from: private */
    public final Class editorType;
    private final Pool pool;

    public ThreadSafePropertyEditor(Class cls, int i, int i2) {
        if (PropertyEditor.class.isAssignableFrom(cls)) {
            this.editorType = cls;
            this.pool = new Pool(i, i2, new Pool.Factory() {
                public Object newInstance() {
                    try {
                        return ThreadSafePropertyEditor.this.editorType.newInstance();
                    } catch (InstantiationException e2) {
                        throw new ObjectAccessException("Could not call default constructor of " + ThreadSafePropertyEditor.this.editorType.getName(), e2);
                    } catch (IllegalAccessException e3) {
                        throw new ObjectAccessException("Could not call default constructor of " + ThreadSafePropertyEditor.this.editorType.getName(), e3);
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException(cls.getName() + " is not a " + PropertyEditor.class.getName());
    }

    public String getAsText(Object obj) {
        PropertyEditor fetchFromPool = fetchFromPool();
        try {
            fetchFromPool.setValue(obj);
            return fetchFromPool.getAsText();
        } finally {
            this.pool.putInPool(fetchFromPool);
        }
    }

    public Object setAsText(String str) {
        PropertyEditor fetchFromPool = fetchFromPool();
        try {
            fetchFromPool.setAsText(str);
            return fetchFromPool.getValue();
        } finally {
            this.pool.putInPool(fetchFromPool);
        }
    }

    private PropertyEditor fetchFromPool() {
        return (PropertyEditor) this.pool.fetchFromPool();
    }
}
