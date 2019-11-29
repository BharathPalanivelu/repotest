package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ContentInfo extends Message {
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.ONE_OF, tag = 3)
    public final ContactInfo contact_info;
    @ProtoField(label = Message.Label.ONE_OF, tag = 6)
    public final DeviceHFInfo deviceHF_info;
    @ProtoField(label = Message.Label.ONE_OF, tag = 7)
    public final DeviceLFInfo deviceLF_info;
    @ProtoField(label = Message.Label.ONE_OF, tag = 8)
    public final DeviceMFInfo deviceMF_info;
    @ProtoField(label = Message.Label.ONE_OF, tag = 9)
    public final InstalledAppInfo installed_info;
    @ProtoField(label = Message.Label.ONE_OF, tag = 5)
    public final LocationInfo location_info;
    @ProtoField(label = Message.Label.ONE_OF, tag = 4)
    public final PhoneInfo phone_info;
    @ProtoField(label = Message.Label.ONE_OF, tag = 2)
    public final SmsInfo sms_info;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer status;

    public ContentInfo(Integer num, SmsInfo smsInfo, ContactInfo contactInfo, PhoneInfo phoneInfo, LocationInfo locationInfo, DeviceHFInfo deviceHFInfo, DeviceLFInfo deviceLFInfo, DeviceMFInfo deviceMFInfo, InstalledAppInfo installedAppInfo) {
        this.status = num;
        this.sms_info = smsInfo;
        this.contact_info = contactInfo;
        this.phone_info = phoneInfo;
        this.location_info = locationInfo;
        this.deviceHF_info = deviceHFInfo;
        this.deviceLF_info = deviceLFInfo;
        this.deviceMF_info = deviceMFInfo;
        this.installed_info = installedAppInfo;
    }

    private ContentInfo(Builder builder) {
        this(builder.status, builder.sms_info, builder.contact_info, builder.phone_info, builder.location_info, builder.deviceHF_info, builder.deviceLF_info, builder.deviceMF_info, builder.installed_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContentInfo)) {
            return false;
        }
        ContentInfo contentInfo = (ContentInfo) obj;
        if (!equals((Object) this.status, (Object) contentInfo.status) || !equals((Object) this.sms_info, (Object) contentInfo.sms_info) || !equals((Object) this.contact_info, (Object) contentInfo.contact_info) || !equals((Object) this.phone_info, (Object) contentInfo.phone_info) || !equals((Object) this.location_info, (Object) contentInfo.location_info) || !equals((Object) this.deviceHF_info, (Object) contentInfo.deviceHF_info) || !equals((Object) this.deviceLF_info, (Object) contentInfo.deviceLF_info) || !equals((Object) this.deviceMF_info, (Object) contentInfo.deviceMF_info) || !equals((Object) this.installed_info, (Object) contentInfo.installed_info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.status;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        SmsInfo smsInfo = this.sms_info;
        int hashCode2 = (hashCode + (smsInfo != null ? smsInfo.hashCode() : 0)) * 37;
        ContactInfo contactInfo = this.contact_info;
        int hashCode3 = (hashCode2 + (contactInfo != null ? contactInfo.hashCode() : 0)) * 37;
        PhoneInfo phoneInfo = this.phone_info;
        int hashCode4 = (hashCode3 + (phoneInfo != null ? phoneInfo.hashCode() : 0)) * 37;
        LocationInfo locationInfo = this.location_info;
        int hashCode5 = (hashCode4 + (locationInfo != null ? locationInfo.hashCode() : 0)) * 37;
        DeviceHFInfo deviceHFInfo = this.deviceHF_info;
        int hashCode6 = (hashCode5 + (deviceHFInfo != null ? deviceHFInfo.hashCode() : 0)) * 37;
        DeviceLFInfo deviceLFInfo = this.deviceLF_info;
        int hashCode7 = (hashCode6 + (deviceLFInfo != null ? deviceLFInfo.hashCode() : 0)) * 37;
        DeviceMFInfo deviceMFInfo = this.deviceMF_info;
        int hashCode8 = (hashCode7 + (deviceMFInfo != null ? deviceMFInfo.hashCode() : 0)) * 37;
        InstalledAppInfo installedAppInfo = this.installed_info;
        if (installedAppInfo != null) {
            i2 = installedAppInfo.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ContentInfo> {
        public ContactInfo contact_info;
        public DeviceHFInfo deviceHF_info;
        public DeviceLFInfo deviceLF_info;
        public DeviceMFInfo deviceMF_info;
        public InstalledAppInfo installed_info;
        public LocationInfo location_info;
        public PhoneInfo phone_info;
        public SmsInfo sms_info;
        public Integer status;

        public Builder() {
        }

        public Builder(ContentInfo contentInfo) {
            super(contentInfo);
            if (contentInfo != null) {
                this.status = contentInfo.status;
                this.sms_info = contentInfo.sms_info;
                this.contact_info = contentInfo.contact_info;
                this.phone_info = contentInfo.phone_info;
                this.location_info = contentInfo.location_info;
                this.deviceHF_info = contentInfo.deviceHF_info;
                this.deviceLF_info = contentInfo.deviceLF_info;
                this.deviceMF_info = contentInfo.deviceMF_info;
                this.installed_info = contentInfo.installed_info;
            }
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder sms_info(SmsInfo smsInfo) {
            this.sms_info = smsInfo;
            this.contact_info = null;
            this.phone_info = null;
            this.location_info = null;
            this.deviceHF_info = null;
            this.deviceLF_info = null;
            this.deviceMF_info = null;
            this.installed_info = null;
            return this;
        }

        public Builder contact_info(ContactInfo contactInfo) {
            this.contact_info = contactInfo;
            this.sms_info = null;
            this.phone_info = null;
            this.location_info = null;
            this.deviceHF_info = null;
            this.deviceLF_info = null;
            this.deviceMF_info = null;
            this.installed_info = null;
            return this;
        }

        public Builder phone_info(PhoneInfo phoneInfo) {
            this.phone_info = phoneInfo;
            this.sms_info = null;
            this.contact_info = null;
            this.location_info = null;
            this.deviceHF_info = null;
            this.deviceLF_info = null;
            this.deviceMF_info = null;
            this.installed_info = null;
            return this;
        }

        public Builder location_info(LocationInfo locationInfo) {
            this.location_info = locationInfo;
            this.sms_info = null;
            this.contact_info = null;
            this.phone_info = null;
            this.deviceHF_info = null;
            this.deviceLF_info = null;
            this.deviceMF_info = null;
            this.installed_info = null;
            return this;
        }

        public Builder deviceHF_info(DeviceHFInfo deviceHFInfo) {
            this.deviceHF_info = deviceHFInfo;
            this.sms_info = null;
            this.contact_info = null;
            this.phone_info = null;
            this.location_info = null;
            this.deviceLF_info = null;
            this.deviceMF_info = null;
            this.installed_info = null;
            return this;
        }

        public Builder deviceLF_info(DeviceLFInfo deviceLFInfo) {
            this.deviceLF_info = deviceLFInfo;
            this.sms_info = null;
            this.contact_info = null;
            this.phone_info = null;
            this.location_info = null;
            this.deviceHF_info = null;
            this.deviceMF_info = null;
            this.installed_info = null;
            return this;
        }

        public Builder deviceMF_info(DeviceMFInfo deviceMFInfo) {
            this.deviceMF_info = deviceMFInfo;
            this.sms_info = null;
            this.contact_info = null;
            this.phone_info = null;
            this.location_info = null;
            this.deviceHF_info = null;
            this.deviceLF_info = null;
            this.installed_info = null;
            return this;
        }

        public Builder installed_info(InstalledAppInfo installedAppInfo) {
            this.installed_info = installedAppInfo;
            this.sms_info = null;
            this.contact_info = null;
            this.phone_info = null;
            this.location_info = null;
            this.deviceHF_info = null;
            this.deviceLF_info = null;
            this.deviceMF_info = null;
            return this;
        }

        public ContentInfo build() {
            return new ContentInfo(this);
        }
    }
}
