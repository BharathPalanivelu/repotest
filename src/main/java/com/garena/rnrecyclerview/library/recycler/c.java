package com.garena.rnrecyclerview.library.recycler;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f8600a;

    /* renamed from: b  reason: collision with root package name */
    public String f8601b;

    /* renamed from: c  reason: collision with root package name */
    public String f8602c;

    /* renamed from: d  reason: collision with root package name */
    public int f8603d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f8604e = "";

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return ((c) obj).f8602c.equals(this.f8602c);
        }
        return false;
    }

    public String toString() {
        return "ReactRecyclerData{type=" + this.f8600a + ", typeString='" + this.f8601b + '\'' + ", id='" + this.f8602c + '\'' + '}';
    }
}
