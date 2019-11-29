package com.google.c;

import java.util.Iterator;
import java.util.Map;

public class w extends x {

    /* renamed from: b  reason: collision with root package name */
    private final ad f14063b;

    public w(ad adVar, p pVar, f fVar) {
        super(pVar, fVar);
        this.f14063b = adVar;
    }

    public ad a() {
        return a(this.f14063b);
    }

    public int hashCode() {
        return a().hashCode();
    }

    public boolean equals(Object obj) {
        return a().equals(obj);
    }

    public String toString() {
        return a().toString();
    }

    static class a<K> implements Map.Entry<K, Object> {

        /* renamed from: a  reason: collision with root package name */
        private Map.Entry<K, w> f14064a;

        private a(Map.Entry<K, w> entry) {
            this.f14064a = entry;
        }

        public K getKey() {
            return this.f14064a.getKey();
        }

        public Object getValue() {
            w value = this.f14064a.getValue();
            if (value == null) {
                return null;
            }
            return value.a();
        }

        public w a() {
            return this.f14064a.getValue();
        }

        public Object setValue(Object obj) {
            if (obj instanceof ad) {
                return this.f14064a.getValue().b((ad) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a  reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f14065a;

        public b(Iterator<Map.Entry<K, Object>> it) {
            this.f14065a = it;
        }

        public boolean hasNext() {
            return this.f14065a.hasNext();
        }

        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f14065a.next();
            return next.getValue() instanceof w ? new a(next) : next;
        }

        public void remove() {
            this.f14065a.remove();
        }
    }
}
