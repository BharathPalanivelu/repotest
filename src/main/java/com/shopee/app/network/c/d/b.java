package com.shopee.app.network.c.d;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f17895a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17896b;

    /* renamed from: c  reason: collision with root package name */
    private final T f17897c;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (!(this.f17895a == bVar.f17895a) || !j.a((Object) this.f17896b, (Object) bVar.f17896b) || !j.a((Object) this.f17897c, (Object) bVar.f17897c)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Integer.valueOf(this.f17895a).hashCode() * 31;
        String str = this.f17896b;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        T t = this.f17897c;
        if (t != null) {
            i = t.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ResponseDetailData(errorCode=" + this.f17895a + ", errorMessage=" + this.f17896b + ", data=" + this.f17897c + SQLBuilder.PARENTHESES_RIGHT;
    }

    public b(int i, String str, T t) {
        this.f17895a = i;
        this.f17896b = str;
        this.f17897c = t;
    }

    public final int a() {
        return this.f17895a;
    }

    public final String b() {
        return this.f17896b;
    }

    public final T c() {
        return this.f17897c;
    }
}
