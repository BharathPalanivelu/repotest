package com.salesforce.android.chat.core.internal.service;

import android.app.Notification;
import android.content.Context;
import com.salesforce.android.chat.core.R;
import com.salesforce.android.service.common.utilities.internal.android.notification.NotificationBuilder;
import com.salesforce.android.service.common.utilities.internal.android.notification.NotificationChannel;
import com.salesforce.android.service.common.utilities.internal.android.notification.NotificationManager;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationBuilder;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationChannel;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationManager;

class ChatServiceNotification {
    static final int NOTIFICATION_ID = 547;
    private final NotificationBuilder mNotificationBuilder;

    private ChatServiceNotification(Builder builder) {
        this.mNotificationBuilder = builder.mNotificationBuilder;
        builder.mNotificationManager.createNotificationChannel(builder.mNotificationChannel);
    }

    /* access modifiers changed from: package-private */
    public Notification getNotification(Context context) {
        return this.mNotificationBuilder.setSmallIcon(R.drawable.salesforce_chat_service_icon).setContentTitle(context.getString(R.string.chat_service_title)).setContentText(context.getString(R.string.chat_service_description)).setPriority(-2).build();
    }

    static class Builder {
        /* access modifiers changed from: private */
        public NotificationBuilder mNotificationBuilder;
        /* access modifiers changed from: private */
        public NotificationChannel mNotificationChannel;
        /* access modifiers changed from: private */
        public NotificationManager mNotificationManager;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder notificationChannel(NotificationChannel notificationChannel) {
            this.mNotificationChannel = notificationChannel;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder notificationManager(NotificationManager notificationManager) {
            this.mNotificationManager = notificationManager;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder notificationBuilder(NotificationBuilder notificationBuilder) {
            this.mNotificationBuilder = notificationBuilder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public ChatServiceNotification build(Context context) {
            if (this.mNotificationChannel == null) {
                this.mNotificationChannel = new SalesforceNotificationChannel(context.getString(R.string.chat_service_notification_channel_id), context.getString(R.string.chat_service_notification_channel_name), 1);
            }
            if (this.mNotificationManager == null) {
                this.mNotificationManager = SalesforceNotificationManager.from(context);
            }
            if (this.mNotificationBuilder == null) {
                this.mNotificationBuilder = new SalesforceNotificationBuilder.Builder().channel(this.mNotificationChannel).build(context);
            }
            return new ChatServiceNotification(this);
        }
    }
}
