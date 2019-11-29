package com.shopee.app.ui.auth.a;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.appuser.UserInfo;
import d.d.b.j;

public final class a extends com.garena.android.appkit.b.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f19483a;

    /* renamed from: b  reason: collision with root package name */
    private final UserInfo f19484b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.a((Object) this.f19483a, (Object) aVar.f19483a) && j.a((Object) this.f19484b, (Object) aVar.f19484b);
    }

    public int hashCode() {
        String str = this.f19483a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        UserInfo userInfo = this.f19484b;
        if (userInfo != null) {
            i = userInfo.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "BindAccountEvent(requestId=" + this.f19483a + ", userInfo=" + this.f19484b + SQLBuilder.PARENTHESES_RIGHT;
    }

    public final UserInfo a() {
        return this.f19484b;
    }

    public a(String str, UserInfo userInfo) {
        j.b(str, "requestId");
        j.b(userInfo, "userInfo");
        this.f19483a = str;
        this.f19484b = userInfo;
    }
}
