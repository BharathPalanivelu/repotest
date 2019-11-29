package com.google.maps.android.a.b;

import com.google.android.gms.maps.model.GroundOverlay;
import java.util.ArrayList;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, String> f14385a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<j, Object> f14386b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<b> f14387c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<e, GroundOverlay> f14388d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, String> f14389e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, n> f14390f;

    /* renamed from: g  reason: collision with root package name */
    private String f14391g;

    b(HashMap<String, String> hashMap, HashMap<String, n> hashMap2, HashMap<j, Object> hashMap3, HashMap<String, String> hashMap4, ArrayList<b> arrayList, HashMap<e, GroundOverlay> hashMap5, String str) {
        this.f14385a = hashMap;
        this.f14386b = hashMap3;
        this.f14390f = hashMap2;
        this.f14389e = hashMap4;
        this.f14387c = arrayList;
        this.f14388d = hashMap5;
        this.f14391g = str;
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, n> a() {
        return this.f14390f;
    }

    /* access modifiers changed from: package-private */
    public void a(j jVar, Object obj) {
        this.f14386b.put(jVar, obj);
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, String> b() {
        return this.f14389e;
    }

    /* access modifiers changed from: package-private */
    public HashMap<e, GroundOverlay> c() {
        return this.f14388d;
    }

    public n a(String str) {
        return this.f14390f.get(str);
    }

    /* access modifiers changed from: package-private */
    public HashMap<j, Object> d() {
        return this.f14386b;
    }

    public String b(String str) {
        return this.f14385a.get(str);
    }

    public boolean c(String str) {
        return this.f14385a.containsKey(str);
    }

    public boolean e() {
        return this.f14387c.size() > 0;
    }

    public Iterable<b> f() {
        return this.f14387c;
    }

    public Iterable<j> g() {
        return this.f14386b.keySet();
    }

    public String toString() {
        return "Container" + "{" + "\n properties=" + this.f14385a + ",\n placemarks=" + this.f14386b + ",\n containers=" + this.f14387c + ",\n ground overlays=" + this.f14388d + ",\n style maps=" + this.f14389e + ",\n styles=" + this.f14390f + "\n}\n";
    }
}
