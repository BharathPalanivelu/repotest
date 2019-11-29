package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.i;

public interface NotificationBuilder {
    NotificationBuilder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent);

    NotificationBuilder addAction(i.a aVar);

    NotificationBuilder addExtras(Bundle bundle);

    NotificationBuilder addPerson(String str);

    Notification build();

    NotificationBuilder extend(i.e eVar);

    Bundle getExtras();

    NotificationBuilder setAutoCancel(boolean z);

    NotificationBuilder setCategory(String str);

    NotificationBuilder setChannelId(String str);

    NotificationBuilder setColor(int i);

    NotificationBuilder setContent(RemoteViews remoteViews);

    NotificationBuilder setContentInfo(CharSequence charSequence);

    NotificationBuilder setContentIntent(PendingIntent pendingIntent);

    NotificationBuilder setContentText(CharSequence charSequence);

    NotificationBuilder setContentTitle(CharSequence charSequence);

    NotificationBuilder setCustomBigContentView(RemoteViews remoteViews);

    NotificationBuilder setCustomContentView(RemoteViews remoteViews);

    NotificationBuilder setCustomHeadsUpContentView(RemoteViews remoteViews);

    NotificationBuilder setDefaults(int i);

    NotificationBuilder setDeleteIntent(PendingIntent pendingIntent);

    NotificationBuilder setExtras(Bundle bundle);

    NotificationBuilder setFullScreenIntent(PendingIntent pendingIntent, boolean z);

    NotificationBuilder setGroup(String str);

    NotificationBuilder setGroupSummary(boolean z);

    NotificationBuilder setLargeIcon(Bitmap bitmap);

    NotificationBuilder setLights(int i, int i2, int i3);

    NotificationBuilder setLocalOnly(boolean z);

    NotificationBuilder setNumber(int i);

    NotificationBuilder setOngoing(boolean z);

    NotificationBuilder setOnlyAlertOnce(boolean z);

    NotificationBuilder setPriority(int i);

    NotificationBuilder setProgress(int i, int i2, boolean z);

    NotificationBuilder setPublicVersion(Notification notification);

    NotificationBuilder setRemoteInputHistory(CharSequence[] charSequenceArr);

    NotificationBuilder setShowWhen(boolean z);

    NotificationBuilder setSmallIcon(int i);

    NotificationBuilder setSmallIcon(int i, int i2);

    NotificationBuilder setSortKey(String str);

    NotificationBuilder setSound(Uri uri);

    NotificationBuilder setSound(Uri uri, int i);

    NotificationBuilder setStyle(i.g gVar);

    NotificationBuilder setSubText(CharSequence charSequence);

    NotificationBuilder setTicker(CharSequence charSequence);

    NotificationBuilder setTicker(CharSequence charSequence, RemoteViews remoteViews);

    NotificationBuilder setUsesChronometer(boolean z);

    NotificationBuilder setVibrate(long[] jArr);

    NotificationBuilder setVisibility(int i);

    NotificationBuilder setWhen(long j);
}
