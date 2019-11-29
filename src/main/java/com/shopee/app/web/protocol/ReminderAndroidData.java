package com.shopee.app.web.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class ReminderAndroidData {
    private final String message;
    private final String redirect;

    public static /* synthetic */ ReminderAndroidData copy$default(ReminderAndroidData reminderAndroidData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reminderAndroidData.message;
        }
        if ((i & 2) != 0) {
            str2 = reminderAndroidData.redirect;
        }
        return reminderAndroidData.copy(str, str2);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.redirect;
    }

    public final ReminderAndroidData copy(String str, String str2) {
        return new ReminderAndroidData(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReminderAndroidData)) {
            return false;
        }
        ReminderAndroidData reminderAndroidData = (ReminderAndroidData) obj;
        return j.a((Object) this.message, (Object) reminderAndroidData.message) && j.a((Object) this.redirect, (Object) reminderAndroidData.redirect);
    }

    public int hashCode() {
        String str = this.message;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.redirect;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ReminderAndroidData(message=" + this.message + ", redirect=" + this.redirect + SQLBuilder.PARENTHESES_RIGHT;
    }

    public ReminderAndroidData(String str, String str2) {
        this.message = str;
        this.redirect = str2;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getRedirect() {
        return this.redirect;
    }
}
