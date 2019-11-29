package io.a.a.a.a.b;

class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f33057a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f33058b;

    b(String str, boolean z) {
        this.f33057a = str;
        this.f33058b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f33058b != bVar.f33058b) {
            return false;
        }
        String str = this.f33057a;
        return str == null ? bVar.f33057a == null : str.equals(bVar.f33057a);
    }

    public int hashCode() {
        String str = this.f33057a;
        return ((str != null ? str.hashCode() : 0) * 31) + (this.f33058b ? 1 : 0);
    }
}
