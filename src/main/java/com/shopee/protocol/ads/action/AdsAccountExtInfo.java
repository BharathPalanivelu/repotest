package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdsAccountExtInfo extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final AutoTopupSetting auto_topup_setting;
    @ProtoField(tag = 1)
    public final DailyPnSetting daily_pn_setting;

    public AdsAccountExtInfo(DailyPnSetting dailyPnSetting, AutoTopupSetting autoTopupSetting) {
        this.daily_pn_setting = dailyPnSetting;
        this.auto_topup_setting = autoTopupSetting;
    }

    private AdsAccountExtInfo(Builder builder) {
        this(builder.daily_pn_setting, builder.auto_topup_setting);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsAccountExtInfo)) {
            return false;
        }
        AdsAccountExtInfo adsAccountExtInfo = (AdsAccountExtInfo) obj;
        if (!equals((Object) this.daily_pn_setting, (Object) adsAccountExtInfo.daily_pn_setting) || !equals((Object) this.auto_topup_setting, (Object) adsAccountExtInfo.auto_topup_setting)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DailyPnSetting dailyPnSetting = this.daily_pn_setting;
        int i2 = 0;
        int hashCode = (dailyPnSetting != null ? dailyPnSetting.hashCode() : 0) * 37;
        AutoTopupSetting autoTopupSetting = this.auto_topup_setting;
        if (autoTopupSetting != null) {
            i2 = autoTopupSetting.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdsAccountExtInfo> {
        public AutoTopupSetting auto_topup_setting;
        public DailyPnSetting daily_pn_setting;

        public Builder() {
        }

        public Builder(AdsAccountExtInfo adsAccountExtInfo) {
            super(adsAccountExtInfo);
            if (adsAccountExtInfo != null) {
                this.daily_pn_setting = adsAccountExtInfo.daily_pn_setting;
                this.auto_topup_setting = adsAccountExtInfo.auto_topup_setting;
            }
        }

        public Builder daily_pn_setting(DailyPnSetting dailyPnSetting) {
            this.daily_pn_setting = dailyPnSetting;
            return this;
        }

        public Builder auto_topup_setting(AutoTopupSetting autoTopupSetting) {
            this.auto_topup_setting = autoTopupSetting;
            return this;
        }

        public AdsAccountExtInfo build() {
            return new AdsAccountExtInfo(this);
        }
    }
}
