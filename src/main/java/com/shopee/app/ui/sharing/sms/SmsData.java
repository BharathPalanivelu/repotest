package com.shopee.app.ui.sharing.sms;

import androidx.annotation.Keep;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

@Keep
public final class SmsData {
    private final String text;

    public static /* synthetic */ SmsData copy$default(SmsData smsData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = smsData.text;
        }
        return smsData.copy(str);
    }

    public final String component1() {
        return this.text;
    }

    public final SmsData copy(String str) {
        j.b(str, "text");
        return new SmsData(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SmsData) && j.a((Object) this.text, (Object) ((SmsData) obj).text);
        }
        return true;
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SmsData(text=" + this.text + SQLBuilder.PARENTHESES_RIGHT;
    }

    public SmsData(String str) {
        j.b(str, "text");
        this.text = str;
    }

    public final String getText() {
        return this.text;
    }
}
