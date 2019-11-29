package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private final String f14788a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f14789b;

    /* renamed from: c  reason: collision with root package name */
    private y[] f14790c;

    /* renamed from: d  reason: collision with root package name */
    private final c f14791d;

    /* renamed from: e  reason: collision with root package name */
    private Map<x, Object> f14792e;

    /* renamed from: f  reason: collision with root package name */
    private final long f14793f;

    public w(String str, byte[] bArr, y[] yVarArr, c cVar) {
        this(str, bArr, yVarArr, cVar, System.currentTimeMillis());
    }

    public w(String str, byte[] bArr, y[] yVarArr, c cVar, long j) {
        this.f14788a = str;
        this.f14789b = bArr;
        this.f14790c = yVarArr;
        this.f14791d = cVar;
        this.f14792e = null;
        this.f14793f = j;
    }

    public String a() {
        return this.f14788a;
    }

    public byte[] b() {
        return this.f14789b;
    }

    public y[] c() {
        return this.f14790c;
    }

    public c d() {
        return this.f14791d;
    }

    public Map<x, Object> e() {
        return this.f14792e;
    }

    public void a(x xVar, Object obj) {
        if (this.f14792e == null) {
            this.f14792e = new EnumMap(x.class);
        }
        this.f14792e.put(xVar, obj);
    }

    public void a(Map<x, Object> map) {
        if (map != null) {
            Map<x, Object> map2 = this.f14792e;
            if (map2 == null) {
                this.f14792e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void a(y[] yVarArr) {
        y[] yVarArr2 = this.f14790c;
        if (yVarArr2 == null) {
            this.f14790c = yVarArr;
        } else if (yVarArr != null && yVarArr.length > 0) {
            y[] yVarArr3 = new y[(yVarArr2.length + yVarArr.length)];
            System.arraycopy(yVarArr2, 0, yVarArr3, 0, yVarArr2.length);
            System.arraycopy(yVarArr, 0, yVarArr3, yVarArr2.length, yVarArr.length);
            this.f14790c = yVarArr3;
        }
    }

    public String toString() {
        return this.f14788a;
    }
}
