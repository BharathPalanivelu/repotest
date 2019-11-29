package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.i;

public class SalesforceNotificationBuilder implements NotificationBuilder {
    private final i.d mNotificationCompatBuilder;

    protected SalesforceNotificationBuilder(i.d dVar) {
        this.mNotificationCompatBuilder = dVar;
    }

    public static class Builder {
        private String mChannelId;
        private i.d mNotificationCompatBuilder;

        public Builder channel(NotificationChannel notificationChannel) {
            if (notificationChannel != null) {
                this.mChannelId = notificationChannel.getId();
            }
            return this;
        }

        public Builder notificationCompatBuilder(i.d dVar) {
            this.mNotificationCompatBuilder = dVar;
            return this;
        }

        public SalesforceNotificationBuilder build(Context context) {
            if (this.mChannelId == null && Build.VERSION.SDK_INT >= 26) {
                this.mChannelId = "miscellaneous";
            }
            if (this.mNotificationCompatBuilder == null) {
                this.mNotificationCompatBuilder = new i.d(context, this.mChannelId);
            }
            return new SalesforceNotificationBuilder(this.mNotificationCompatBuilder);
        }
    }

    public NotificationBuilder addAction(i.a aVar) {
        this.mNotificationCompatBuilder.a(aVar);
        return this;
    }

    public NotificationBuilder setWhen(long j) {
        this.mNotificationCompatBuilder.a(j);
        return this;
    }

    public NotificationBuilder setShowWhen(boolean z) {
        this.mNotificationCompatBuilder.a(z);
        return this;
    }

    public NotificationBuilder setUsesChronometer(boolean z) {
        this.mNotificationCompatBuilder.b(z);
        return this;
    }

    public NotificationBuilder setSmallIcon(int i) {
        this.mNotificationCompatBuilder.a(i);
        return this;
    }

    public NotificationBuilder setSmallIcon(int i, int i2) {
        this.mNotificationCompatBuilder.a(i, i2);
        return this;
    }

    public NotificationBuilder setContentTitle(CharSequence charSequence) {
        this.mNotificationCompatBuilder.a(charSequence);
        return this;
    }

    public NotificationBuilder setContentText(CharSequence charSequence) {
        this.mNotificationCompatBuilder.b(charSequence);
        return this;
    }

    public NotificationBuilder setSubText(CharSequence charSequence) {
        this.mNotificationCompatBuilder.c(charSequence);
        return this;
    }

    public NotificationBuilder setRemoteInputHistory(CharSequence[] charSequenceArr) {
        this.mNotificationCompatBuilder.a(charSequenceArr);
        return this;
    }

    public NotificationBuilder setNumber(int i) {
        this.mNotificationCompatBuilder.b(i);
        return this;
    }

    public NotificationBuilder setContentInfo(CharSequence charSequence) {
        this.mNotificationCompatBuilder.d(charSequence);
        return this;
    }

    public NotificationBuilder setProgress(int i, int i2, boolean z) {
        this.mNotificationCompatBuilder.a(i, i2, z);
        return this;
    }

    public NotificationBuilder setContent(RemoteViews remoteViews) {
        this.mNotificationCompatBuilder.a(remoteViews);
        return this;
    }

    public NotificationBuilder setContentIntent(PendingIntent pendingIntent) {
        this.mNotificationCompatBuilder.a(pendingIntent);
        return this;
    }

    public NotificationBuilder setDeleteIntent(PendingIntent pendingIntent) {
        this.mNotificationCompatBuilder.b(pendingIntent);
        return this;
    }

    public NotificationBuilder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
        this.mNotificationCompatBuilder.a(pendingIntent, z);
        return this;
    }

    public NotificationBuilder setTicker(CharSequence charSequence) {
        this.mNotificationCompatBuilder.e(charSequence);
        return this;
    }

    public NotificationBuilder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
        this.mNotificationCompatBuilder.a(charSequence, remoteViews);
        return this;
    }

    public NotificationBuilder setLargeIcon(Bitmap bitmap) {
        this.mNotificationCompatBuilder.a(bitmap);
        return this;
    }

    public NotificationBuilder setSound(Uri uri) {
        this.mNotificationCompatBuilder.a(uri);
        return this;
    }

    public NotificationBuilder setSound(Uri uri, int i) {
        this.mNotificationCompatBuilder.a(uri, i);
        return this;
    }

    public NotificationBuilder setVibrate(long[] jArr) {
        this.mNotificationCompatBuilder.a(jArr);
        return this;
    }

    public NotificationBuilder setLights(int i, int i2, int i3) {
        this.mNotificationCompatBuilder.a(i, i2, i3);
        return this;
    }

    public NotificationBuilder setOngoing(boolean z) {
        this.mNotificationCompatBuilder.c(z);
        return this;
    }

    public NotificationBuilder setOnlyAlertOnce(boolean z) {
        this.mNotificationCompatBuilder.d(z);
        return this;
    }

    public NotificationBuilder setAutoCancel(boolean z) {
        this.mNotificationCompatBuilder.e(z);
        return this;
    }

    public NotificationBuilder setLocalOnly(boolean z) {
        this.mNotificationCompatBuilder.f(z);
        return this;
    }

    public NotificationBuilder setCategory(String str) {
        this.mNotificationCompatBuilder.a(str);
        return this;
    }

    public NotificationBuilder setDefaults(int i) {
        this.mNotificationCompatBuilder.c(i);
        return this;
    }

    public NotificationBuilder setPriority(int i) {
        this.mNotificationCompatBuilder.d(i);
        return this;
    }

    public NotificationBuilder addPerson(String str) {
        this.mNotificationCompatBuilder.b(str);
        return this;
    }

    public NotificationBuilder setGroup(String str) {
        this.mNotificationCompatBuilder.c(str);
        return this;
    }

    public NotificationBuilder setGroupSummary(boolean z) {
        this.mNotificationCompatBuilder.g(z);
        return this;
    }

    public NotificationBuilder setSortKey(String str) {
        this.mNotificationCompatBuilder.d(str);
        return this;
    }

    public NotificationBuilder addExtras(Bundle bundle) {
        this.mNotificationCompatBuilder.a(bundle);
        return this;
    }

    public NotificationBuilder setExtras(Bundle bundle) {
        this.mNotificationCompatBuilder.b(bundle);
        return this;
    }

    public Bundle getExtras() {
        return this.mNotificationCompatBuilder.a();
    }

    public NotificationBuilder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this.mNotificationCompatBuilder.a(i, charSequence, pendingIntent);
        return this;
    }

    public NotificationBuilder setStyle(i.g gVar) {
        this.mNotificationCompatBuilder.a(gVar);
        return this;
    }

    public NotificationBuilder setColor(int i) {
        this.mNotificationCompatBuilder.e(i);
        return this;
    }

    public NotificationBuilder setVisibility(int i) {
        this.mNotificationCompatBuilder.f(i);
        return this;
    }

    public NotificationBuilder setPublicVersion(Notification notification) {
        this.mNotificationCompatBuilder.a(notification);
        return this;
    }

    public NotificationBuilder setCustomContentView(RemoteViews remoteViews) {
        this.mNotificationCompatBuilder.b(remoteViews);
        return this;
    }

    public NotificationBuilder setCustomBigContentView(RemoteViews remoteViews) {
        this.mNotificationCompatBuilder.c(remoteViews);
        return this;
    }

    public NotificationBuilder setCustomHeadsUpContentView(RemoteViews remoteViews) {
        this.mNotificationCompatBuilder.d(remoteViews);
        return this;
    }

    public NotificationBuilder extend(i.e eVar) {
        this.mNotificationCompatBuilder.a(eVar);
        return this;
    }

    public NotificationBuilder setChannelId(String str) {
        this.mNotificationCompatBuilder.e(str);
        return this;
    }

    public Notification build() {
        return this.mNotificationCompatBuilder.b();
    }
}
