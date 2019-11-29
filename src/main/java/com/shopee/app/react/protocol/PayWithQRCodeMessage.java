package com.shopee.app.react.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class PayWithQRCodeMessage {
    private final String sessionKey;

    public PayWithQRCodeMessage() {
        this((String) null, 1, (g) null);
    }

    public static /* synthetic */ PayWithQRCodeMessage copy$default(PayWithQRCodeMessage payWithQRCodeMessage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payWithQRCodeMessage.sessionKey;
        }
        return payWithQRCodeMessage.copy(str);
    }

    public final String component1() {
        return this.sessionKey;
    }

    public final PayWithQRCodeMessage copy(String str) {
        j.b(str, "sessionKey");
        return new PayWithQRCodeMessage(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof PayWithQRCodeMessage) && j.a((Object) this.sessionKey, (Object) ((PayWithQRCodeMessage) obj).sessionKey);
        }
        return true;
    }

    public int hashCode() {
        String str = this.sessionKey;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "PayWithQRCodeMessage(sessionKey=" + this.sessionKey + SQLBuilder.PARENTHESES_RIGHT;
    }

    public PayWithQRCodeMessage(String str) {
        j.b(str, "sessionKey");
        this.sessionKey = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PayWithQRCodeMessage(String str, int i, g gVar) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }
}
