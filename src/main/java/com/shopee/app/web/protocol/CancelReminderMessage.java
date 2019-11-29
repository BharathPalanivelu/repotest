package com.shopee.app.web.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class CancelReminderMessage {
    private final String reminderId;

    public static /* synthetic */ CancelReminderMessage copy$default(CancelReminderMessage cancelReminderMessage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cancelReminderMessage.reminderId;
        }
        return cancelReminderMessage.copy(str);
    }

    public final String component1() {
        return this.reminderId;
    }

    public final CancelReminderMessage copy(String str) {
        return new CancelReminderMessage(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CancelReminderMessage) && j.a((Object) this.reminderId, (Object) ((CancelReminderMessage) obj).reminderId);
        }
        return true;
    }

    public int hashCode() {
        String str = this.reminderId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CancelReminderMessage(reminderId=" + this.reminderId + SQLBuilder.PARENTHESES_RIGHT;
    }

    public CancelReminderMessage(String str) {
        this.reminderId = str;
    }

    public final String getReminderId() {
        return this.reminderId;
    }
}
