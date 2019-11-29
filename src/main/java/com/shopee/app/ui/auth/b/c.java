package com.shopee.app.ui.auth.b;

import com.garena.android.appkit.b.a;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private final String f19504a;

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof c) && j.a((Object) this.f19504a, (Object) ((c) obj).f19504a);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f19504a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "LoginEvent(requestId=" + this.f19504a + SQLBuilder.PARENTHESES_RIGHT;
    }

    public c(String str) {
        j.b(str, "requestId");
        this.f19504a = str;
    }
}
