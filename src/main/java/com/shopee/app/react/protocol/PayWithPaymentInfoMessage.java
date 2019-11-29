package com.shopee.app.react.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class PayWithPaymentInfoMessage {
    private final String qrcode;
    private final String sessionKey;

    public PayWithPaymentInfoMessage() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ PayWithPaymentInfoMessage copy$default(PayWithPaymentInfoMessage payWithPaymentInfoMessage, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payWithPaymentInfoMessage.qrcode;
        }
        if ((i & 2) != 0) {
            str2 = payWithPaymentInfoMessage.sessionKey;
        }
        return payWithPaymentInfoMessage.copy(str, str2);
    }

    public final String component1() {
        return this.qrcode;
    }

    public final String component2() {
        return this.sessionKey;
    }

    public final PayWithPaymentInfoMessage copy(String str, String str2) {
        j.b(str, "qrcode");
        j.b(str2, "sessionKey");
        return new PayWithPaymentInfoMessage(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayWithPaymentInfoMessage)) {
            return false;
        }
        PayWithPaymentInfoMessage payWithPaymentInfoMessage = (PayWithPaymentInfoMessage) obj;
        return j.a((Object) this.qrcode, (Object) payWithPaymentInfoMessage.qrcode) && j.a((Object) this.sessionKey, (Object) payWithPaymentInfoMessage.sessionKey);
    }

    public int hashCode() {
        String str = this.qrcode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sessionKey;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PayWithPaymentInfoMessage(qrcode=" + this.qrcode + ", sessionKey=" + this.sessionKey + SQLBuilder.PARENTHESES_RIGHT;
    }

    public PayWithPaymentInfoMessage(String str, String str2) {
        j.b(str, "qrcode");
        j.b(str2, "sessionKey");
        this.qrcode = str;
        this.sessionKey = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PayWithPaymentInfoMessage(String str, String str2, int i, g gVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getQrcode() {
        return this.qrcode;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }
}
