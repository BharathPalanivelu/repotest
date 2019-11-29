package com.shopee.app.util.j;

import android.content.SharedPreferences;
import android.util.LruCache;
import java.util.Map;

public class a<K, T> extends c<K, T> {

    /* renamed from: d  reason: collision with root package name */
    private a<K, T>.a f26380d;

    /* renamed from: e  reason: collision with root package name */
    private final int f26381e;

    @Deprecated
    public void a(Map<K, T> map) {
    }

    @Deprecated
    /* renamed from: c */
    public Map<K, T> a() {
        return null;
    }

    public a(SharedPreferences sharedPreferences, int i, String str, com.google.a.c.a aVar) {
        super(sharedPreferences, str, aVar);
        this.f26381e = i;
    }

    public synchronized T b(K k) {
        d();
        return this.f26380d.get(k);
    }

    public synchronized void a(K k, T t) {
        d();
        this.f26380d.put(k, t);
        b(k, t);
    }

    private void b(K k, T t) {
        Map map = (Map) super.a();
        map.put(k, t);
        super.a(map);
    }

    private void d() {
        if (this.f26380d == null) {
            this.f26380d = new C0405a(this.f26381e);
            for (Map.Entry entry : ((Map) super.a()).entrySet()) {
                this.f26380d.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: com.shopee.app.util.j.a$a  reason: collision with other inner class name */
    private class C0405a extends LruCache<K, T> {
        public C0405a(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        public void entryRemoved(boolean z, K k, T t, T t2) {
            if (z) {
                Map map = (Map) a.super.a();
                map.remove(k);
                a.super.a(map);
            }
        }
    }
}
