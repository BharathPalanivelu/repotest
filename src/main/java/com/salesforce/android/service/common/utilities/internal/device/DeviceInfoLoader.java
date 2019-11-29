package com.salesforce.android.service.common.utilities.internal.device;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.salesforce.android.service.common.utilities.internal.android.AndroidInfo;
import com.salesforce.android.service.common.utilities.internal.device.DeviceIdentifier;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Locale;

public class DeviceInfoLoader {
    public static final String USER_AGENT = "android";
    private String mAppName;
    private String mAppVersion;
    private final String mDeviceId;
    private String mDeviceInfo;
    private String mDeviceOsVersion;

    protected DeviceInfoLoader(Builder builder) {
        AndroidInfo androidInfo = builder.mAndroidInfo;
        PackageInfo packageInfo = builder.mPackageInfo;
        this.mDeviceId = builder.mDeviceIdentifier.getDeviceId();
        this.mAppName = builder.mPackageName;
        this.mAppVersion = String.format(Locale.getDefault(), "%s (%d)", new Object[]{packageInfo.versionName, Integer.valueOf(packageInfo.versionCode)});
        this.mDeviceInfo = String.format("%s %s %s", new Object[]{"android", androidInfo.getDeviceManufacturer(), androidInfo.getDeviceModel()});
        this.mDeviceOsVersion = androidInfo.getDeviceOSVersion();
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public String getDeviceInfo() {
        return this.mDeviceInfo;
    }

    public String getDeviceOsVersion() {
        return this.mDeviceOsVersion;
    }

    public static class Builder {
        protected AndroidInfo mAndroidInfo;
        private Context mContext;
        protected DeviceIdentifier mDeviceIdentifier;
        protected PackageInfo mPackageInfo;
        protected String mPackageName;

        public Builder with(Context context) {
            this.mContext = context;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder androidInfo(AndroidInfo androidInfo) {
            this.mAndroidInfo = androidInfo;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder packageInfo(PackageInfo packageInfo) {
            this.mPackageInfo = packageInfo;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder deviceIdentifier(DeviceIdentifier deviceIdentifier) {
            this.mDeviceIdentifier = deviceIdentifier;
            return this;
        }

        public DeviceInfoLoader build() {
            Arguments.checkNotNull(this.mContext);
            this.mPackageName = this.mContext.getPackageName();
            if (this.mAndroidInfo == null) {
                this.mAndroidInfo = new AndroidInfo();
            }
            if (this.mPackageInfo == null) {
                try {
                    this.mPackageInfo = this.mContext.getPackageManager().getPackageInfo(this.mPackageName, 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            }
            if (this.mDeviceIdentifier == null) {
                this.mDeviceIdentifier = new DeviceIdentifier.Builder().with(this.mContext).build();
            }
            return new DeviceInfoLoader(this);
        }
    }
}
