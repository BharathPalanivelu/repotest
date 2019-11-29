package com.shopee.app.ui.sharing;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f25340a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25341b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25342c;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (j.a((Object) this.f25340a, (Object) aVar.f25340a)) {
                    if (this.f25341b == aVar.f25341b) {
                        if (this.f25342c == aVar.f25342c) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f25340a;
        return ((((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.f25341b).hashCode()) * 31) + Integer.valueOf(this.f25342c).hashCode();
    }

    public String toString() {
        return "ShareInfo(appId=" + this.f25340a + ", drawableId=" + this.f25341b + ", labelId=" + this.f25342c + SQLBuilder.PARENTHESES_RIGHT;
    }

    public a(String str, int i, int i2) {
        j.b(str, "appId");
        this.f25340a = str;
        this.f25341b = i;
        this.f25342c = i2;
    }

    public final String a() {
        return this.f25340a;
    }

    public final int b() {
        return this.f25341b;
    }

    public final int c() {
        return this.f25342c;
    }
}
