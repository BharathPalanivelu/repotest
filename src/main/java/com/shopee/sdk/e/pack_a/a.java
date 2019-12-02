package com.shopee.sdk.e.pack_a;

import android.content.SharedPreferences;
import android.util.LruCache;

import java.util.Map;

public class a<K, T> extends d<Map<K, T>> {

    /* renamed from: a  reason: collision with root package name */
    private a<K, T>.a f30349a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30350b;

    @Deprecated
    /* renamed from: a */
    public Map<K, T> c() {
        return null;
    }

    @Deprecated
    /* renamed from: a */
    public void b(Map<K, T> map) {
    }

    public a(SharedPreferences sharedPreferences, int i, String str, Class<K> cls, Class<T> cls2) {
        super(sharedPreferences, str, com.shopee.sdk.f.a.f30358b, (com.google.a.c.a) com.google.a.c.a.getParameterized(Map.class, cls, cls2));
        this.f30350b = i;
    }

    public synchronized T a(K k) {
        d();
        return this.f30349a.get(k);
    }

    public synchronized void a(K k, T t) {
        d();
        this.f30349a.put(k, t);
        b(k, t);
    }

    public synchronized Map<K, T> b() {
        d();
        return this.f30349a.snapshot();
    }

    private void b(K k, T t) {
        Map map = (Map) super.c();
        map.put(k, t);
        super.b(map);
    }

    private void d() {
        if (this.f30349a == null) {
            this.f30349a = new C0468a(this.f30350b);
            for (Map.Entry entry : ((Map) super.c()).entrySet()) {
                this.f30349a.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: com.shopee.sdk.e.a.a$a  reason: collision with other inner class name */
    private class C0468a extends LruCache<K, T> {
        public C0468a(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        public void entryRemoved(boolean z, K k, T t, T t2) {
            if (z) {
                Map map = (Map) a.super.c();
                map.remove(k);
                a.super.b(map);
            }
        }
    }
}
