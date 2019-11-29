package com.salesforce.android.service.common.utilities.internal.android.notification;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;

public class SalesforceNotificationChannel implements NotificationChannel {
    private NotificationChannel mNotificationChannel;

    public SalesforceNotificationChannel(String str, CharSequence charSequence, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationChannel = new OreoNotificationChannel(str, charSequence, i);
        } else {
            this.mNotificationChannel = new CompatNotificationChannel();
        }
    }

    public String getId() {
        return this.mNotificationChannel.getId();
    }

    public CharSequence getName() {
        return this.mNotificationChannel.getName();
    }

    public void setName(CharSequence charSequence) {
        this.mNotificationChannel.setName(charSequence);
    }

    public String getDescription() {
        return this.mNotificationChannel.getDescription();
    }

    public void setDescription(String str) {
        this.mNotificationChannel.setDescription(str);
    }

    public int getImportance() {
        return this.mNotificationChannel.getImportance();
    }

    public void setImportance(int i) {
        this.mNotificationChannel.setImportance(i);
    }

    public boolean canBypassDnd() {
        return this.mNotificationChannel.canBypassDnd();
    }

    public void setBypassDnd(boolean z) {
        this.mNotificationChannel.setBypassDnd(z);
    }

    public Uri getSound() {
        return this.mNotificationChannel.getSound();
    }

    public AudioAttributes getAudioAttributes() {
        return this.mNotificationChannel.getAudioAttributes();
    }

    public void setSound(Uri uri, AudioAttributes audioAttributes) {
        this.mNotificationChannel.setSound(uri, audioAttributes);
    }

    public boolean shouldShowLights() {
        return this.mNotificationChannel.shouldShowLights();
    }

    public int getLightColor() {
        return this.mNotificationChannel.getLightColor();
    }

    public void enableLights(boolean z) {
        this.mNotificationChannel.enableLights(z);
    }

    public void setLightColor(int i) {
        this.mNotificationChannel.setLightColor(i);
    }

    public boolean shouldVibrate() {
        return this.mNotificationChannel.shouldVibrate();
    }

    public void enableVibration(boolean z) {
        this.mNotificationChannel.enableVibration(z);
    }

    public long[] getVibrationPattern() {
        return this.mNotificationChannel.getVibrationPattern();
    }

    public void setVibrationPattern(long[] jArr) {
        this.mNotificationChannel.setVibrationPattern(jArr);
    }

    public int getLockscreenVisibility() {
        return this.mNotificationChannel.getLockscreenVisibility();
    }

    public void setLockscreenVisibility(int i) {
        this.mNotificationChannel.setLockscreenVisibility(i);
    }

    public boolean canShowBadge() {
        return this.mNotificationChannel.canShowBadge();
    }

    public void setShowBadge(boolean z) {
        this.mNotificationChannel.setShowBadge(z);
    }

    public String getGroup() {
        return this.mNotificationChannel.getGroup();
    }

    public void setGroup(String str) {
        this.mNotificationChannel.setGroup(str);
    }

    public NotificationChannel asAndroidNotificationChannel() {
        return this.mNotificationChannel.asAndroidNotificationChannel();
    }

    @TargetApi(26)
    protected static class OreoNotificationChannel implements NotificationChannel {
        private NotificationChannel mNotificationChannel;

        OreoNotificationChannel(String str, CharSequence charSequence, int i) {
            this.mNotificationChannel = new NotificationChannel(str, charSequence, i);
        }

        public String getId() {
            return this.mNotificationChannel.getId();
        }

        public CharSequence getName() {
            return this.mNotificationChannel.getName();
        }

        public void setName(CharSequence charSequence) {
            this.mNotificationChannel.setName(charSequence);
        }

        public String getDescription() {
            return this.mNotificationChannel.getDescription();
        }

        public void setDescription(String str) {
            this.mNotificationChannel.setDescription(str);
        }

        public int getImportance() {
            return this.mNotificationChannel.getImportance();
        }

        public void setImportance(int i) {
            this.mNotificationChannel.setImportance(i);
        }

        public boolean canBypassDnd() {
            return this.mNotificationChannel.canBypassDnd();
        }

        public void setBypassDnd(boolean z) {
            this.mNotificationChannel.setBypassDnd(z);
        }

        public Uri getSound() {
            return this.mNotificationChannel.getSound();
        }

        public AudioAttributes getAudioAttributes() {
            return this.mNotificationChannel.getAudioAttributes();
        }

        public void setSound(Uri uri, AudioAttributes audioAttributes) {
            this.mNotificationChannel.setSound(uri, audioAttributes);
        }

        public boolean shouldShowLights() {
            return this.mNotificationChannel.shouldShowLights();
        }

        public int getLightColor() {
            return this.mNotificationChannel.getLightColor();
        }

        public void enableLights(boolean z) {
            this.mNotificationChannel.enableLights(z);
        }

        public void setLightColor(int i) {
            this.mNotificationChannel.setLightColor(i);
        }

        public boolean shouldVibrate() {
            return this.mNotificationChannel.shouldVibrate();
        }

        public void enableVibration(boolean z) {
            this.mNotificationChannel.enableVibration(z);
        }

        public long[] getVibrationPattern() {
            return this.mNotificationChannel.getVibrationPattern();
        }

        public void setVibrationPattern(long[] jArr) {
            this.mNotificationChannel.setVibrationPattern(jArr);
        }

        public int getLockscreenVisibility() {
            return this.mNotificationChannel.getLockscreenVisibility();
        }

        public void setLockscreenVisibility(int i) {
            this.mNotificationChannel.setLockscreenVisibility(i);
        }

        public boolean canShowBadge() {
            return this.mNotificationChannel.canShowBadge();
        }

        public void setShowBadge(boolean z) {
            this.mNotificationChannel.setShowBadge(z);
        }

        public String getGroup() {
            return this.mNotificationChannel.getGroup();
        }

        public void setGroup(String str) {
            this.mNotificationChannel.setGroup(str);
        }

        public NotificationChannel asAndroidNotificationChannel() {
            return this.mNotificationChannel;
        }
    }

    protected static class CompatNotificationChannel implements NotificationChannel {
        public boolean canBypassDnd() {
            return false;
        }

        public boolean canShowBadge() {
            return false;
        }

        public void enableLights(boolean z) {
        }

        public void enableVibration(boolean z) {
        }

        public AudioAttributes getAudioAttributes() {
            return null;
        }

        public String getDescription() {
            return "";
        }

        public String getGroup() {
            return "";
        }

        public String getId() {
            return "";
        }

        public int getImportance() {
            return 0;
        }

        public int getLightColor() {
            return 0;
        }

        public int getLockscreenVisibility() {
            return 0;
        }

        public CharSequence getName() {
            return "";
        }

        public Uri getSound() {
            return null;
        }

        public void setBypassDnd(boolean z) {
        }

        public void setDescription(String str) {
        }

        public void setGroup(String str) {
        }

        public void setImportance(int i) {
        }

        public void setLightColor(int i) {
        }

        public void setLockscreenVisibility(int i) {
        }

        public void setName(CharSequence charSequence) {
        }

        public void setShowBadge(boolean z) {
        }

        public void setSound(Uri uri, AudioAttributes audioAttributes) {
        }

        public void setVibrationPattern(long[] jArr) {
        }

        public boolean shouldShowLights() {
            return false;
        }

        public boolean shouldVibrate() {
            return false;
        }

        protected CompatNotificationChannel() {
        }

        public long[] getVibrationPattern() {
            return new long[0];
        }

        public NotificationChannel asAndroidNotificationChannel() {
            throw new IllegalStateException("Notification Channels are not supported by this version of Android.");
        }
    }
}
