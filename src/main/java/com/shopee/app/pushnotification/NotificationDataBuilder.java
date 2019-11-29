package com.shopee.app.pushnotification;

import android.content.Intent;

public class NotificationDataBuilder {
    private final NotificationData mNotificationData = new NotificationData();

    private NotificationDataBuilder() {
    }

    public NotificationDataBuilder withId(int i) {
        this.mNotificationData.setId(i);
        return this;
    }

    public NotificationDataBuilder ofType(int i) {
        this.mNotificationData.setType(i);
        return this;
    }

    public NotificationDataBuilder withMetadata(String str) {
        this.mNotificationData.setMetadata(str);
        return this;
    }

    public NotificationDataBuilder withTitle(String str) {
        this.mNotificationData.setTitle(str);
        return this;
    }

    public NotificationDataBuilder withMessage(String str) {
        this.mNotificationData.setMessage(str);
        return this;
    }

    public NotificationDataBuilder withImageUrl(String str) {
        this.mNotificationData.setImageUrl(str);
        return this;
    }

    public NotificationDataBuilder shouldStack(boolean z) {
        this.mNotificationData.setStacked(z);
        return this;
    }

    public NotificationDataBuilder withLaunchIntent(Intent intent) {
        this.mNotificationData.setIntent(intent);
        return this;
    }

    public NotificationDataBuilder shouldKeepSilent(boolean z) {
        this.mNotificationData.setSilentApplied(z);
        return this;
    }

    public NotificationDataBuilder useCustomSound(boolean z) {
        this.mNotificationData.setUseCustomSound(z);
        return this;
    }

    public NotificationDataBuilder belongsToGroup(boolean z) {
        this.mNotificationData.setInGroup(z);
        return this;
    }

    public NotificationData build() {
        return this.mNotificationData;
    }

    public static NotificationDataBuilder notificationData() {
        return new NotificationDataBuilder();
    }
}
