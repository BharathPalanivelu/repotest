package com.salesforce.android.service.common.utilities.internal.device;

import android.content.Context;
import android.content.SharedPreferences;
import com.salesforce.android.service.common.utilities.internal.android.UUIDProvider;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class DeviceIdentifier {
    private static final String SHARED_PREFS_KEY_DEVICE_ID = "unique_device_id";
    private static final String SHARED_PREFS_NAME = "com.salesforce.android.service";
    private static final String UNKNOWN_DEVICE_ID = "UNKNOWN-DEVICE-ID";
    private final String mDeviceId;
    private final SharedPreferences mSharedPreferences;

    protected DeviceIdentifier(Builder builder) {
        this.mSharedPreferences = builder.mSharedPreferences;
        if (isDeviceIdentified()) {
            this.mDeviceId = loadDeviceId();
            return;
        }
        this.mDeviceId = builder.mUUIDProvider.randomUUID().toString();
        saveDeviceId(this.mDeviceId);
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    private boolean isDeviceIdentified() {
        return this.mSharedPreferences.contains(SHARED_PREFS_KEY_DEVICE_ID);
    }

    private void saveDeviceId(String str) {
        this.mSharedPreferences.edit().putString(SHARED_PREFS_KEY_DEVICE_ID, str).apply();
    }

    private String loadDeviceId() {
        return this.mSharedPreferences.getString(SHARED_PREFS_KEY_DEVICE_ID, UNKNOWN_DEVICE_ID);
    }

    public static class Builder {
        private Context mContext;
        protected SharedPreferences mSharedPreferences;
        protected UUIDProvider mUUIDProvider;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder sharedPreferences(SharedPreferences sharedPreferences) {
            this.mSharedPreferences = sharedPreferences;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder uuidProvider(UUIDProvider uUIDProvider) {
            this.mUUIDProvider = uUIDProvider;
            return this;
        }

        public DeviceIdentifier build() {
            Arguments.checkNotNull(this.mContext);
            if (this.mSharedPreferences == null) {
                this.mSharedPreferences = this.mContext.getSharedPreferences(DeviceIdentifier.SHARED_PREFS_NAME, 0);
            }
            if (this.mUUIDProvider == null) {
                this.mUUIDProvider = new UUIDProvider();
            }
            return new DeviceIdentifier(this);
        }
    }
}
