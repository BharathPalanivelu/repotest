package com.c.a.f;

import com.c.a.c.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f6171a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f6172b = new HashMap();

    public synchronized void a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f6171a);
        this.f6171a.clear();
        this.f6171a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f6171a.add(str);
            }
        }
    }

    public synchronized <T, R> List<k<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f6171a) {
            List<a> list = this.f6172b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f6174b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f6171a) {
            List<a> list = this.f6172b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f6173a);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void a(String str, k<T, R> kVar, Class<T> cls, Class<R> cls2) {
        a(str).add(new a(cls, cls2, kVar));
    }

    private synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> list;
        if (!this.f6171a.contains(str)) {
            this.f6171a.add(str);
        }
        list = this.f6172b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f6172b.put(str, list);
        }
        return list;
    }

    private static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final Class<R> f6173a;

        /* renamed from: b  reason: collision with root package name */
        final k<T, R> f6174b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<T> f6175c;

        public a(Class<T> cls, Class<R> cls2, k<T, R> kVar) {
            this.f6175c = cls;
            this.f6173a = cls2;
            this.f6174b = kVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f6175c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f6173a);
        }
    }
}
