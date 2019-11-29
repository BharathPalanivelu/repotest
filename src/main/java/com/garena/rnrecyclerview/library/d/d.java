package com.garena.rnrecyclerview.library.d;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f8565a;

    /* renamed from: b  reason: collision with root package name */
    public int f8566b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8567c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f8566b != dVar.f8566b || this.f8567c != dVar.f8567c) {
            return false;
        }
        String str = this.f8565a;
        if (str != null) {
            return str.equals(dVar.f8565a);
        }
        if (dVar.f8565a == null) {
            return true;
        }
        return false;
    }
}
