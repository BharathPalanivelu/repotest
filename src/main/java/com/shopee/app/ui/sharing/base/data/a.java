package com.shopee.app.ui.sharing.base.data;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f25351a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25352b;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (!(this.f25351a == aVar.f25351a) || !j.a((Object) this.f25352b, (Object) aVar.f25352b)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Integer.valueOf(this.f25351a).hashCode() * 31;
        String str = this.f25352b;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ShareResult(errorCode=" + this.f25351a + ", errorMessage=" + this.f25352b + SQLBuilder.PARENTHESES_RIGHT;
    }

    public a(int i, String str) {
        this.f25351a = i;
        this.f25352b = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i, String str, int i2, g gVar) {
        this(i, (i2 & 2) != 0 ? null : str);
    }

    public final int a() {
        return this.f25351a;
    }

    public final String b() {
        return this.f25352b;
    }
}
