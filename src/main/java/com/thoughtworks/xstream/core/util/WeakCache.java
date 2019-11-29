package com.thoughtworks.xstream.core.util;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class WeakCache extends AbstractMap {
    private final Map map;

    private interface Visitor {
        Object visit(Object obj);
    }

    public WeakCache() {
        this(new WeakHashMap());
    }

    public WeakCache(Map map2) {
        this.map = map2;
    }

    public Object get(Object obj) {
        Reference reference = (Reference) this.map.get(obj);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public Object put(Object obj, Object obj2) {
        Reference reference = (Reference) this.map.put(obj, createReference(obj2));
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public Object remove(Object obj) {
        Reference reference = (Reference) this.map.remove(obj);
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    /* access modifiers changed from: protected */
    public Reference createReference(Object obj) {
        return new WeakReference(obj);
    }

    public boolean containsValue(final Object obj) {
        if (((Boolean) iterate(new Visitor() {
            public Object visit(Object obj) {
                if (obj.equals(obj)) {
                    return Boolean.TRUE;
                }
                return null;
            }
        }, 0)) == Boolean.TRUE) {
            return true;
        }
        return false;
    }

    public int size() {
        if (this.map.size() == 0) {
            return 0;
        }
        final int[] iArr = {0};
        iterate(new Visitor() {
            public Object visit(Object obj) {
                int[] iArr = iArr;
                iArr[0] = iArr[0] + 1;
                return null;
            }
        }, 0);
        return iArr[0];
    }

    public Collection values() {
        final ArrayList arrayList = new ArrayList();
        if (this.map.size() != 0) {
            iterate(new Visitor() {
                public Object visit(Object obj) {
                    arrayList.add(obj);
                    return null;
                }
            }, 0);
        }
        return arrayList;
    }

    public Set entrySet() {
        final HashSet hashSet = new HashSet();
        if (this.map.size() != 0) {
            iterate(new Visitor() {
                public Object visit(Object obj) {
                    final Map.Entry entry = (Map.Entry) obj;
                    hashSet.add(new Map.Entry() {
                        public Object getKey() {
                            return entry.getKey();
                        }

                        public Object getValue() {
                            return ((Reference) entry.getValue()).get();
                        }

                        public Object setValue(Object obj) {
                            Reference reference = (Reference) entry.setValue(WeakCache.this.createReference(obj));
                            if (reference != null) {
                                return reference.get();
                            }
                            return null;
                        }
                    });
                    return null;
                }
            }, 2);
        }
        return hashSet;
    }

    private Object iterate(Visitor visitor, int i) {
        Iterator it = this.map.entrySet().iterator();
        Object obj = null;
        while (obj == null && it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object obj2 = ((Reference) entry.getValue()).get();
            if (obj2 == null) {
                it.remove();
            } else if (i == 0) {
                obj = visitor.visit(obj2);
            } else if (i == 1) {
                obj = visitor.visit(entry.getKey());
            } else if (i == 2) {
                obj = visitor.visit(entry);
            }
        }
        return obj;
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public void clear() {
        this.map.clear();
    }

    public Set keySet() {
        return this.map.keySet();
    }

    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return this.map.toString();
    }
}
