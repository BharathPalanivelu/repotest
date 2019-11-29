package com.shopee.app.web.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class AddReminderMessage {

    /* renamed from: android  reason: collision with root package name */
    private final ReminderAndroidData f26575android;
    private final Integer endDate;
    private final Integer reminderOffset;
    private final Integer startDate;
    private final String title;

    public static /* synthetic */ AddReminderMessage copy$default(AddReminderMessage addReminderMessage, String str, Integer num, Integer num2, Integer num3, ReminderAndroidData reminderAndroidData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addReminderMessage.title;
        }
        if ((i & 2) != 0) {
            num = addReminderMessage.startDate;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = addReminderMessage.endDate;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            num3 = addReminderMessage.reminderOffset;
        }
        Integer num6 = num3;
        if ((i & 16) != 0) {
            reminderAndroidData = addReminderMessage.f26575android;
        }
        return addReminderMessage.copy(str, num4, num5, num6, reminderAndroidData);
    }

    public final String component1() {
        return this.title;
    }

    public final Integer component2() {
        return this.startDate;
    }

    public final Integer component3() {
        return this.endDate;
    }

    public final Integer component4() {
        return this.reminderOffset;
    }

    public final ReminderAndroidData component5() {
        return this.f26575android;
    }

    public final AddReminderMessage copy(String str, Integer num, Integer num2, Integer num3, ReminderAndroidData reminderAndroidData) {
        return new AddReminderMessage(str, num, num2, num3, reminderAndroidData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddReminderMessage)) {
            return false;
        }
        AddReminderMessage addReminderMessage = (AddReminderMessage) obj;
        return j.a((Object) this.title, (Object) addReminderMessage.title) && j.a((Object) this.startDate, (Object) addReminderMessage.startDate) && j.a((Object) this.endDate, (Object) addReminderMessage.endDate) && j.a((Object) this.reminderOffset, (Object) addReminderMessage.reminderOffset) && j.a((Object) this.f26575android, (Object) addReminderMessage.f26575android);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.startDate;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.endDate;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.reminderOffset;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 31;
        ReminderAndroidData reminderAndroidData = this.f26575android;
        if (reminderAndroidData != null) {
            i = reminderAndroidData.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "AddReminderMessage(title=" + this.title + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", reminderOffset=" + this.reminderOffset + ", android=" + this.f26575android + SQLBuilder.PARENTHESES_RIGHT;
    }

    public AddReminderMessage(String str, Integer num, Integer num2, Integer num3, ReminderAndroidData reminderAndroidData) {
        this.title = str;
        this.startDate = num;
        this.endDate = num2;
        this.reminderOffset = num3;
        this.f26575android = reminderAndroidData;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getStartDate() {
        return this.startDate;
    }

    public final Integer getEndDate() {
        return this.endDate;
    }

    public final Integer getReminderOffset() {
        return this.reminderOffset;
    }

    public final ReminderAndroidData getAndroid() {
        return this.f26575android;
    }

    public final String getMessage() {
        ReminderAndroidData reminderAndroidData = this.f26575android;
        if (reminderAndroidData != null) {
            String message = reminderAndroidData.getMessage();
            if (message != null) {
                return message;
            }
        }
        return "";
    }

    public final String getRedirect() {
        ReminderAndroidData reminderAndroidData = this.f26575android;
        if (reminderAndroidData != null) {
            String redirect = reminderAndroidData.getRedirect();
            if (redirect != null) {
                return redirect;
            }
        }
        return "";
    }
}
