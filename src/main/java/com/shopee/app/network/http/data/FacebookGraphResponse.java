package com.shopee.app.network.http.data;

import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class FacebookGraphResponse {
    @c(a = "error")
    private final Object error;

    public static /* synthetic */ FacebookGraphResponse copy$default(FacebookGraphResponse facebookGraphResponse, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = facebookGraphResponse.error;
        }
        return facebookGraphResponse.copy(obj);
    }

    public final Object component1() {
        return this.error;
    }

    public final FacebookGraphResponse copy(Object obj) {
        j.b(obj, "error");
        return new FacebookGraphResponse(obj);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FacebookGraphResponse) && j.a(this.error, ((FacebookGraphResponse) obj).error);
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.error;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "FacebookGraphResponse(error=" + this.error + SQLBuilder.PARENTHESES_RIGHT;
    }

    public FacebookGraphResponse(Object obj) {
        j.b(obj, "error");
        this.error = obj;
    }

    public final Object getError() {
        return this.error;
    }
}
