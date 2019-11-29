package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.media.AudioAttributes;
import android.net.Uri;

public interface NotificationChannel {
    android.app.NotificationChannel asAndroidNotificationChannel();

    boolean canBypassDnd();

    boolean canShowBadge();

    void enableLights(boolean z);

    void enableVibration(boolean z);

    AudioAttributes getAudioAttributes();

    String getDescription();

    String getGroup();

    String getId();

    int getImportance();

    int getLightColor();

    int getLockscreenVisibility();

    CharSequence getName();

    Uri getSound();

    long[] getVibrationPattern();

    void setBypassDnd(boolean z);

    void setDescription(String str);

    void setGroup(String str);

    void setImportance(int i);

    void setLightColor(int i);

    void setLockscreenVisibility(int i);

    void setName(CharSequence charSequence);

    void setShowBadge(boolean z);

    void setSound(Uri uri, AudioAttributes audioAttributes);

    void setVibrationPattern(long[] jArr);

    boolean shouldShowLights();

    boolean shouldVibrate();
}
