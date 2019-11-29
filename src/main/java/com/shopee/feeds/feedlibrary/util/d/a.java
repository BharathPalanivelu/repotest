package com.shopee.feeds.feedlibrary.util.d;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f28291a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f28292b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f28293c;

    a(String str, boolean z, boolean z2) {
        this.f28291a = str;
        this.f28292b = z;
        this.f28293c = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f28292b == aVar.f28292b && this.f28293c == aVar.f28293c) {
            return this.f28291a.equals(aVar.f28291a);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f28291a.hashCode() * 31) + (this.f28292b ? 1 : 0)) * 31) + (this.f28293c ? 1 : 0);
    }

    public String toString() {
        return "Permission{name='" + this.f28291a + '\'' + ", granted=" + this.f28292b + ", shouldShowRequestPermissionRationale=" + this.f28293c + '}';
    }
}
