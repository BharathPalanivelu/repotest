package com.shopee.app.web.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class RequestAuthCodeFromCoreAuthMessage {
    private final String clientID;

    public static /* synthetic */ RequestAuthCodeFromCoreAuthMessage copy$default(RequestAuthCodeFromCoreAuthMessage requestAuthCodeFromCoreAuthMessage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestAuthCodeFromCoreAuthMessage.clientID;
        }
        return requestAuthCodeFromCoreAuthMessage.copy(str);
    }

    public final String component1() {
        return this.clientID;
    }

    public final RequestAuthCodeFromCoreAuthMessage copy(String str) {
        return new RequestAuthCodeFromCoreAuthMessage(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RequestAuthCodeFromCoreAuthMessage) && j.a((Object) this.clientID, (Object) ((RequestAuthCodeFromCoreAuthMessage) obj).clientID);
        }
        return true;
    }

    public int hashCode() {
        String str = this.clientID;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RequestAuthCodeFromCoreAuthMessage(clientID=" + this.clientID + SQLBuilder.PARENTHESES_RIGHT;
    }

    public RequestAuthCodeFromCoreAuthMessage(String str) {
        this.clientID = str;
    }

    public final String getClientID() {
        return this.clientID;
    }
}
