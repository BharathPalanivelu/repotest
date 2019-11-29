package com.shopee.app.h;

import android.util.Pair;
import com.shopee.app.network.d.az;
import com.shopee.app.util.g.a;
import java.util.HashMap;
import java.util.Map;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static o f17684a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Integer> f17685b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Integer> f17686c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Pair<Integer, Integer>> f17687d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private Map<String, az> f17688e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private Map<String, a> f17689f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private Map<String, com.shopee.app.util.k.a> f17690g = new HashMap();

    public static o a() {
        if (f17684a == null) {
            f17684a = new o();
        }
        return f17684a;
    }

    public void a(String str, int i) {
        this.f17685b.put(str, Integer.valueOf(i));
    }

    public void a(String str) {
        this.f17685b.remove(str);
        this.f17687d.remove(str);
    }

    public int b(String str) {
        if (this.f17685b.get(str) == null) {
            return -1;
        }
        return this.f17685b.get(str).intValue();
    }

    public void a(String str, Pair<Integer, Integer> pair) {
        this.f17687d.put(str, pair);
    }

    public Pair<Integer, Integer> c(String str) {
        return this.f17687d.get(str) == null ? new Pair<>(-1, -1) : this.f17687d.get(str);
    }

    public void a(String str, a aVar) {
        this.f17689f.put(str, aVar);
    }

    public com.shopee.app.util.k.a d(String str) {
        return this.f17690g.remove(str);
    }

    public void a(String str, com.shopee.app.util.k.a aVar) {
        this.f17690g.put(str, aVar);
    }

    public a e(String str) {
        return this.f17689f.remove(str);
    }

    public void a(az azVar) {
        this.f17688e.put(azVar.i().a(), azVar);
    }

    public az f(String str) {
        return this.f17688e.remove(str);
    }

    public az g(String str) {
        return this.f17688e.get(str);
    }

    public synchronized void b(String str, int i) {
        this.f17686c.put(str, Integer.valueOf(i));
    }

    public synchronized int h(String str) {
        if (!this.f17686c.containsKey(str)) {
            return -1;
        }
        return this.f17686c.get(str).intValue();
    }
}
