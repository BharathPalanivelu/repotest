package com.garena.imageeditor.a;

import android.graphics.PointF;
import com.garena.imageeditor.a.c.n;
import java.util.HashMap;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Object> f8096a;

    public g() {
        this.f8096a = new HashMap<>();
    }

    public g(g gVar) {
        this.f8096a = new HashMap<>(gVar.f8096a);
    }

    public float a(String str) {
        return ((Float) this.f8096a.get(str)).floatValue();
    }

    public PointF b(String str) {
        return (PointF) this.f8096a.get(str);
    }

    public String c(String str) {
        return (String) this.f8096a.get(str);
    }

    public void a(String str, Object obj) {
        this.f8096a.put(str, obj);
    }

    public int d(String str) {
        return ((Integer) this.f8096a.get(str)).intValue();
    }

    public boolean e(String str) {
        return ((Boolean) this.f8096a.get(str)).booleanValue();
    }

    public n f(String str) {
        return (n) this.f8096a.get(str);
    }
}
