package com.google.b.a.a;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private a<String, Pattern> f13580a;

    public c(int i) {
        this.f13580a = new a<>(i);
    }

    public Pattern a(String str) {
        Pattern a2 = this.f13580a.a(str);
        if (a2 != null) {
            return a2;
        }
        Pattern compile = Pattern.compile(str);
        this.f13580a.a(str, compile);
        return compile;
    }

    private static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private LinkedHashMap<K, V> f13581a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f13582b;

        public a(int i) {
            this.f13582b = i;
            this.f13581a = new LinkedHashMap<K, V>(((i * 4) / 3) + 1, 0.75f, true) {
                /* access modifiers changed from: protected */
                public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                    return size() > a.this.f13582b;
                }
            };
        }

        public synchronized V a(K k) {
            return this.f13581a.get(k);
        }

        public synchronized void a(K k, V v) {
            this.f13581a.put(k, v);
        }
    }
}
