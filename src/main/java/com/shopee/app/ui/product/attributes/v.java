package com.shopee.app.ui.product.attributes;

public class v {

    /* renamed from: a  reason: collision with root package name */
    public final int f24347a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24348b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24349c;

    /* renamed from: d  reason: collision with root package name */
    public final int f24350d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24351e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24352f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f24353g;
    private String h = "";
    private boolean i;

    public v(int i2, int i3, int i4, int i5, int i6, String str, boolean z) {
        this.f24347a = i2;
        this.f24348b = i3;
        this.f24349c = i4;
        this.f24350d = i5;
        this.f24351e = i6;
        this.f24352f = str;
        this.f24353g = z;
    }

    public String a() {
        return this.h;
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public boolean b() {
        return this.i;
    }

    public String toString() {
        return "VMAttributeListItem{attrId=" + this.f24347a + ", inputType=" + this.f24348b + ", attrType=" + this.f24349c + ", validateType=" + this.f24350d + ", itemType=" + this.f24351e + ", value='" + this.f24352f + '\'' + ", selected=" + this.f24353g + ", filter='" + this.h + '\'' + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        if (this.f24347a != vVar.f24347a || this.f24348b != vVar.f24348b || this.f24349c != vVar.f24349c || this.f24350d != vVar.f24350d || this.f24351e != vVar.f24351e || this.f24353g != vVar.f24353g || this.i != vVar.i) {
            return false;
        }
        String str = this.f24352f;
        if (str == null ? vVar.f24352f != null : !str.equals(vVar.f24352f)) {
            return false;
        }
        String str2 = this.h;
        if (str2 != null) {
            return str2.equals(vVar.h);
        }
        if (vVar.h == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((((((((this.f24347a * 31) + this.f24348b) * 31) + this.f24349c) * 31) + this.f24350d) * 31) + this.f24351e) * 31;
        String str = this.f24352f;
        int i3 = 0;
        int hashCode = (((i2 + (str != null ? str.hashCode() : 0)) * 31) + (this.f24353g ? 1 : 0)) * 31;
        String str2 = this.h;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((hashCode + i3) * 31) + (this.i ? 1 : 0);
    }

    public boolean c() {
        int i2 = this.f24350d;
        return i2 == 3 || i2 == 1 || i2 == 4 || i2 == 2;
    }

    public boolean d() {
        return this.f24350d == 6;
    }
}
