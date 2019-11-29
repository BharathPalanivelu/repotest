package com.shopee.app.pushnotification;

import android.content.Intent;
import com.shopee.app.web.WebRegister;
import org.json.JSONException;

public class NotificationData {
    public static final int ID_APP_UPDATE = 4;
    public static final int ID_CHAT = 0;
    public static final int ID_DOWNLOAD = 64;
    public static final int ID_SILENT = 16;
    public static final int ID_VOICE_CALL = 8;
    public static final int ID_WARNING = 32;
    private boolean inGroup = false;
    private int mId;
    private String mImageUrl;
    private transient Intent mIntent;
    private boolean mIsStacked;
    private String mMessage;
    private String mMetadata;
    private boolean mSilentApplied = false;
    private String mTitle;
    private int mType;
    private boolean useCustomSound = false;

    protected NotificationData() {
    }

    private NotificationData(int i, int i2, String str, String str2, boolean z, String str3) {
        this.mId = i;
        this.mType = i2;
        this.mMessage = str;
        this.mMetadata = str2;
        this.mIsStacked = z;
        this.mImageUrl = str3;
    }

    public int getId() {
        return this.mId;
    }

    public int getType() {
        return this.mType;
    }

    public String getMetadata() {
        return this.mMetadata;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public boolean isStacked() {
        return this.mIsStacked;
    }

    public boolean isSilentMode() {
        return this.mSilentApplied;
    }

    public boolean useCustomSound() {
        return this.useCustomSound;
    }

    public String toString() {
        return WebRegister.GSON.b((Object) this);
    }

    public static NotificationData fromString(String str) throws JSONException {
        return (NotificationData) WebRegister.GSON.a(str, NotificationData.class);
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setMetadata(String str) {
        this.mMetadata = str;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public void setStacked(boolean z) {
        this.mIsStacked = z;
    }

    public void setSilentApplied(boolean z) {
        this.mSilentApplied = z;
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setUseCustomSound(boolean z) {
        this.useCustomSound = z;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isInGroup() {
        return this.inGroup;
    }

    public void setInGroup(boolean z) {
        this.inGroup = z;
    }
}
