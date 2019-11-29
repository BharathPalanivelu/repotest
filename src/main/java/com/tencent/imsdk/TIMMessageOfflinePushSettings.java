package com.tencent.imsdk;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.imcore.APNsInfo;
import com.tencent.imcore.AndroidOfflinePushInfo;
import com.tencent.imcore.OfflinePushInfo;

public class TIMMessageOfflinePushSettings {
    private AndroidSettings androidSettings = new AndroidSettings();
    private String descr;
    private byte[] ext;
    private IOSSettings iosSettings = new IOSSettings();
    private boolean isEnabled = true;

    public static class AndroidSettings {
        private NotifyMode notifyMode = NotifyMode.Normal;
        private Uri sound;
        private String title = "";

        public NotifyMode getNotifyMode() {
            return this.notifyMode;
        }

        public Uri getSound() {
            return this.sound;
        }

        public String getTitle() {
            return this.title;
        }

        public AndroidSettings setNotifyMode(NotifyMode notifyMode2) {
            if (notifyMode2 == null) {
                return this;
            }
            this.notifyMode = notifyMode2;
            return this;
        }

        public AndroidSettings setSound(Uri uri) {
            this.sound = uri;
            return this;
        }

        public AndroidSettings setTitle(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.title = str;
            return this;
        }
    }

    public static class IOSSettings {
        public static String NO_SOUND_NO_VIBRATION = "push.no_sound";
        /* access modifiers changed from: private */
        public boolean isBadgeEnabled = true;
        private String sound = "";

        public String getSound() {
            return this.sound;
        }

        public boolean isBadgeEnabled() {
            return this.isBadgeEnabled;
        }

        public IOSSettings setBadgeEnabled(boolean z) {
            this.isBadgeEnabled = z;
            return this;
        }

        public IOSSettings setSound(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            this.sound = str;
            return this;
        }
    }

    public enum NotifyMode {
        Normal(0),
        Custom(1);
        
        private int value;

        private NotifyMode(int i) {
            this.value = 0;
            this.value = i;
        }

        static NotifyMode convertFrom(long j) {
            for (NotifyMode notifyMode : values()) {
                if (((long) notifyMode.getValue()) == j) {
                    return notifyMode;
                }
            }
            return Normal;
        }

        /* access modifiers changed from: package-private */
        public final int getValue() {
            return this.value;
        }
    }

    protected static TIMMessageOfflinePushSettings convertFrom(OfflinePushInfo offlinePushInfo) {
        TIMMessageOfflinePushSettings tIMMessageOfflinePushSettings = new TIMMessageOfflinePushSettings();
        if (offlinePushInfo != null && offlinePushInfo.getIsValid()) {
            try {
                boolean z = true;
                tIMMessageOfflinePushSettings.setEnabled(offlinePushInfo.getFlag() == 0);
                tIMMessageOfflinePushSettings.setDescr(new String(offlinePushInfo.getDesc(), "utf-8"));
                tIMMessageOfflinePushSettings.setExt(offlinePushInfo.getExt());
                tIMMessageOfflinePushSettings.androidSettings.setTitle(new String(offlinePushInfo.getAndroidInfo().getTitle(), "utf-8"));
                tIMMessageOfflinePushSettings.androidSettings.setSound(Uri.parse(new String(offlinePushInfo.getAndroidInfo().getSound(), "utf-8")));
                tIMMessageOfflinePushSettings.androidSettings.setNotifyMode(NotifyMode.convertFrom(offlinePushInfo.getAndroidInfo().getNotifyMode()));
                tIMMessageOfflinePushSettings.iosSettings.setSound(new String(offlinePushInfo.getApns().getSound(), "utf-8"));
                IOSSettings iOSSettings = tIMMessageOfflinePushSettings.iosSettings;
                if (offlinePushInfo.getApns().getBadgeMode() != 0) {
                    z = false;
                }
                iOSSettings.setBadgeEnabled(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return tIMMessageOfflinePushSettings;
    }

    /* access modifiers changed from: protected */
    public OfflinePushInfo convertTo() {
        OfflinePushInfo offlinePushInfo = new OfflinePushInfo();
        offlinePushInfo.setIsValid(true);
        long j = 0;
        offlinePushInfo.setFlag(this.isEnabled ? 0 : 1);
        if (!TextUtils.isEmpty(this.descr)) {
            try {
                offlinePushInfo.setDesc(this.descr.getBytes("utf-8"));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        byte[] bArr = this.ext;
        if (bArr != null) {
            offlinePushInfo.setExt(bArr);
        }
        if (this.androidSettings != null) {
            AndroidOfflinePushInfo androidOfflinePushInfo = new AndroidOfflinePushInfo();
            try {
                if (!TextUtils.isEmpty(this.androidSettings.getTitle())) {
                    androidOfflinePushInfo.setTitle(this.androidSettings.getTitle().getBytes("utf-8"));
                }
                if (this.androidSettings.getSound() != null) {
                    androidOfflinePushInfo.setSound(this.androidSettings.getSound().toString().getBytes("utf-8"));
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            androidOfflinePushInfo.setNotifyMode((long) this.androidSettings.getNotifyMode().getValue());
            offlinePushInfo.setAndroidInfo(androidOfflinePushInfo);
        }
        if (this.iosSettings != null) {
            APNsInfo aPNsInfo = new APNsInfo();
            if (this.iosSettings.getSound() != null) {
                try {
                    aPNsInfo.setSound(this.iosSettings.getSound().getBytes("utf-8"));
                    if (!this.iosSettings.isBadgeEnabled) {
                        j = 1;
                    }
                    aPNsInfo.setBadgeMode(j);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            offlinePushInfo.setApns(aPNsInfo);
        }
        return offlinePushInfo;
    }

    public AndroidSettings getAndroidSettings() {
        return this.androidSettings;
    }

    public String getDescr() {
        return this.descr;
    }

    public byte[] getExt() {
        return this.ext;
    }

    public IOSSettings getIosSettings() {
        return this.iosSettings;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public TIMMessageOfflinePushSettings setAndroidSettings(AndroidSettings androidSettings2) {
        this.androidSettings = androidSettings2;
        return this;
    }

    public TIMMessageOfflinePushSettings setDescr(String str) {
        this.descr = str;
        return this;
    }

    public TIMMessageOfflinePushSettings setEnabled(boolean z) {
        this.isEnabled = z;
        return this;
    }

    public TIMMessageOfflinePushSettings setExt(byte[] bArr) {
        this.ext = bArr;
        return this;
    }

    public TIMMessageOfflinePushSettings setIosSettings(IOSSettings iOSSettings) {
        this.iosSettings = iOSSettings;
        return this;
    }
}
