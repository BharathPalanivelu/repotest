package com.shopee.app.network.http.data.user;

import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class UserAccessTokenRequest {
    @c(a = "client_id")
    private final String clientId;

    public static /* synthetic */ UserAccessTokenRequest copy$default(UserAccessTokenRequest userAccessTokenRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAccessTokenRequest.clientId;
        }
        return userAccessTokenRequest.copy(str);
    }

    public final String component1() {
        return this.clientId;
    }

    public final UserAccessTokenRequest copy(String str) {
        return new UserAccessTokenRequest(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof UserAccessTokenRequest) && j.a((Object) this.clientId, (Object) ((UserAccessTokenRequest) obj).clientId);
        }
        return true;
    }

    public int hashCode() {
        String str = this.clientId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "UserAccessTokenRequest(clientId=" + this.clientId + SQLBuilder.PARENTHESES_RIGHT;
    }

    public UserAccessTokenRequest(String str) {
        this.clientId = str;
    }

    public final String getClientId() {
        return this.clientId;
    }
}
