package com.shopee.app.h.a;

public class f {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f17611a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f17612b;

    /* renamed from: c  reason: collision with root package name */
    public int f17613c;

    /* renamed from: d  reason: collision with root package name */
    public String f17614d;

    public f(String str, int i) {
        this.f17612b = str;
        this.f17613c = i;
    }

    public f(String str, String str2, int i) {
        this.f17612b = str2;
        this.f17613c = i;
        this.f17614d = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (!fVar.f17612b.equals(this.f17612b) || fVar.f17613c != this.f17613c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f17612b.hashCode();
    }
}
