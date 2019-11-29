package com.google.firebase.c;

final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final String f6835a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6836b;

    a(String str, String str2) {
        if (str != null) {
            this.f6835a = str;
            if (str2 != null) {
                this.f6836b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public String a() {
        return this.f6835a;
    }

    public String b() {
        return this.f6836b;
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f6835a + ", version=" + this.f6836b + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f6835a.equals(eVar.a()) || !this.f6836b.equals(eVar.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f6835a.hashCode() ^ 1000003) * 1000003) ^ this.f6836b.hashCode();
    }
}
