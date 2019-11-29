package com.thoughtworks.xstream.core.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ObjectIdDictionary {
    private final Map map = new HashMap();
    /* access modifiers changed from: private */
    public final ReferenceQueue queue = new ReferenceQueue();

    private interface Wrapper {
        boolean equals(Object obj);

        Object get();

        int hashCode();

        String toString();
    }

    private static class IdWrapper implements Wrapper {
        private final int hashCode;
        private final Object obj;

        public IdWrapper(Object obj2) {
            this.hashCode = System.identityHashCode(obj2);
            this.obj = obj2;
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object obj2) {
            return this.obj == ((Wrapper) obj2).get();
        }

        public String toString() {
            return this.obj.toString();
        }

        public Object get() {
            return this.obj;
        }
    }

    private class WeakIdWrapper extends WeakReference implements Wrapper {
        private final int hashCode;

        public WeakIdWrapper(Object obj) {
            super(obj, ObjectIdDictionary.this.queue);
            this.hashCode = System.identityHashCode(obj);
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object obj) {
            return get() == ((Wrapper) obj).get();
        }

        public String toString() {
            Object obj = get();
            if (obj == null) {
                return "(null)";
            }
            return obj.toString();
        }
    }

    public void associateId(Object obj, Object obj2) {
        this.map.put(new WeakIdWrapper(obj), obj2);
        cleanup();
    }

    public Object lookupId(Object obj) {
        return this.map.get(new IdWrapper(obj));
    }

    public boolean containsId(Object obj) {
        return this.map.containsKey(new IdWrapper(obj));
    }

    public void removeId(Object obj) {
        this.map.remove(new IdWrapper(obj));
        cleanup();
    }

    public int size() {
        cleanup();
        return this.map.size();
    }

    private void cleanup() {
        while (true) {
            WeakIdWrapper weakIdWrapper = (WeakIdWrapper) this.queue.poll();
            if (weakIdWrapper != null) {
                this.map.remove(weakIdWrapper);
            } else {
                return;
            }
        }
    }
}
