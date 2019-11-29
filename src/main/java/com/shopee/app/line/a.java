package com.shopee.app.line;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;
import java.io.Serializable;

public final class a implements Serializable {
    private final String accessToken;
    private final String displayName;
    private final String pictureUrl;
    private final String userId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.a((Object) this.accessToken, (Object) aVar.accessToken) && j.a((Object) this.userId, (Object) aVar.userId) && j.a((Object) this.pictureUrl, (Object) aVar.pictureUrl) && j.a((Object) this.displayName, (Object) aVar.displayName);
    }

    public int hashCode() {
        String str = this.accessToken;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.userId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.pictureUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.displayName;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "LineAuthData(accessToken=" + this.accessToken + ", userId=" + this.userId + ", pictureUrl=" + this.pictureUrl + ", displayName=" + this.displayName + SQLBuilder.PARENTHESES_RIGHT;
    }

    public a(String str, String str2, String str3, String str4) {
        j.b(str, "accessToken");
        j.b(str2, "userId");
        j.b(str3, "pictureUrl");
        j.b(str4, "displayName");
        this.accessToken = str;
        this.userId = str2;
        this.pictureUrl = str3;
        this.displayName = str4;
    }

    public final String a() {
        return this.accessToken;
    }

    public final String b() {
        return this.userId;
    }

    public final String c() {
        return this.pictureUrl;
    }

    public final String d() {
        return this.displayName;
    }
}
