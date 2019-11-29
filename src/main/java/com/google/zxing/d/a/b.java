package com.google.zxing.d.a;

import com.litesuits.orm.db.assit.SQLBuilder;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f14573a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14574b;

    public b(int i, int i2) {
        this.f14573a = i;
        this.f14574b = i2;
    }

    public final int a() {
        return this.f14573a;
    }

    public final int b() {
        return this.f14574b;
    }

    public final String toString() {
        return this.f14573a + SQLBuilder.PARENTHESES_LEFT + this.f14574b + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f14573a == bVar.f14573a && this.f14574b == bVar.f14574b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f14573a ^ this.f14574b;
    }
}
