package com.google.a.b;

import com.google.a.b.b.b;
import com.google.a.c.a;
import com.google.a.h;
import com.google.a.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Type, h<?>> f8831a;

    /* renamed from: b  reason: collision with root package name */
    private final b f8832b = b.a();

    public c(Map<Type, h<?>> map) {
        this.f8831a = map;
    }

    public <T> i<T> a(a<T> aVar) {
        final Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        final h hVar = this.f8831a.get(type);
        if (hVar != null) {
            return new i<T>() {
                public T a() {
                    return hVar.a(type);
                }
            };
        }
        final h hVar2 = this.f8831a.get(rawType);
        if (hVar2 != null) {
            return new i<T>() {
                public T a() {
                    return hVar2.a(type);
                }
            };
        }
        i<T> a2 = a(rawType);
        if (a2 != null) {
            return a2;
        }
        i<T> a3 = a(type, rawType);
        if (a3 != null) {
            return a3;
        }
        return b(type, rawType);
    }

    private <T> i<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f8832b.a(declaredConstructor);
            }
            return new i<T>() {
                public T a() {
                    try {
                        return declaredConstructor.newInstance((Object[]) null);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    } catch (IllegalAccessException e4) {
                        throw new AssertionError(e4);
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> i<T> a(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    public T a() {
                        return new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    public T a() {
                        Type type = type;
                        if (type instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type2 instanceof Class) {
                                return EnumSet.noneOf((Class) type2);
                            }
                            throw new m("Invalid EnumSet type: " + type.toString());
                        }
                        throw new m("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    public T a() {
                        return new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    public T a() {
                        return new ArrayDeque();
                    }
                };
            }
            return new i<T>() {
                public T a() {
                    return new ArrayList();
                }
            };
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    public T a() {
                        return new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    public T a() {
                        return new ConcurrentHashMap();
                    }
                };
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    public T a() {
                        return new TreeMap();
                    }
                };
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new i<T>() {
                    public T a() {
                        return new h();
                    }
                };
            }
            return new i<T>() {
                public T a() {
                    return new LinkedHashMap();
                }
            };
        }
    }

    private <T> i<T> b(final Type type, final Class<? super T> cls) {
        return new i<T>() {

            /* renamed from: d  reason: collision with root package name */
            private final m f8849d = m.a();

            public T a() {
                try {
                    return this.f8849d.a(cls);
                } catch (Exception e2) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
                }
            }
        };
    }

    public String toString() {
        return this.f8831a.toString();
    }
}
