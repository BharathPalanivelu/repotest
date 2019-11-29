package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CursorData extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.ONE_OF, tag = 2)
    public final ContactCursor contact_cursor;
    @ProtoField(label = Message.Label.ONE_OF, tag = 5)
    public final DeviceHFCursor deviceHF_cursor;
    @ProtoField(label = Message.Label.ONE_OF, tag = 6)
    public final DeviceLFCursor deviceLF_cursor;
    @ProtoField(label = Message.Label.ONE_OF, tag = 7)
    public final DeviceMFCursor deviceMF_cursor;
    @ProtoField(label = Message.Label.ONE_OF, tag = 8)
    public final InstalledAppCursor installed_app_cursor;
    @ProtoField(label = Message.Label.ONE_OF, tag = 4)
    public final LocationCursor location_cursor;
    @ProtoField(label = Message.Label.ONE_OF, tag = 3)
    public final PhoneCursor phone_cursor;
    @ProtoField(label = Message.Label.ONE_OF, tag = 1)
    public final SmsCursor sms_cursor;

    public CursorData(SmsCursor smsCursor, ContactCursor contactCursor, PhoneCursor phoneCursor, LocationCursor locationCursor, DeviceHFCursor deviceHFCursor, DeviceLFCursor deviceLFCursor, DeviceMFCursor deviceMFCursor, InstalledAppCursor installedAppCursor) {
        this.sms_cursor = smsCursor;
        this.contact_cursor = contactCursor;
        this.phone_cursor = phoneCursor;
        this.location_cursor = locationCursor;
        this.deviceHF_cursor = deviceHFCursor;
        this.deviceLF_cursor = deviceLFCursor;
        this.deviceMF_cursor = deviceMFCursor;
        this.installed_app_cursor = installedAppCursor;
    }

    private CursorData(Builder builder) {
        this(builder.sms_cursor, builder.contact_cursor, builder.phone_cursor, builder.location_cursor, builder.deviceHF_cursor, builder.deviceLF_cursor, builder.deviceMF_cursor, builder.installed_app_cursor);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CursorData)) {
            return false;
        }
        CursorData cursorData = (CursorData) obj;
        if (!equals((Object) this.sms_cursor, (Object) cursorData.sms_cursor) || !equals((Object) this.contact_cursor, (Object) cursorData.contact_cursor) || !equals((Object) this.phone_cursor, (Object) cursorData.phone_cursor) || !equals((Object) this.location_cursor, (Object) cursorData.location_cursor) || !equals((Object) this.deviceHF_cursor, (Object) cursorData.deviceHF_cursor) || !equals((Object) this.deviceLF_cursor, (Object) cursorData.deviceLF_cursor) || !equals((Object) this.deviceMF_cursor, (Object) cursorData.deviceMF_cursor) || !equals((Object) this.installed_app_cursor, (Object) cursorData.installed_app_cursor)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        SmsCursor smsCursor = this.sms_cursor;
        int i2 = 0;
        int hashCode = (smsCursor != null ? smsCursor.hashCode() : 0) * 37;
        ContactCursor contactCursor = this.contact_cursor;
        int hashCode2 = (hashCode + (contactCursor != null ? contactCursor.hashCode() : 0)) * 37;
        PhoneCursor phoneCursor = this.phone_cursor;
        int hashCode3 = (hashCode2 + (phoneCursor != null ? phoneCursor.hashCode() : 0)) * 37;
        LocationCursor locationCursor = this.location_cursor;
        int hashCode4 = (hashCode3 + (locationCursor != null ? locationCursor.hashCode() : 0)) * 37;
        DeviceHFCursor deviceHFCursor = this.deviceHF_cursor;
        int hashCode5 = (hashCode4 + (deviceHFCursor != null ? deviceHFCursor.hashCode() : 0)) * 37;
        DeviceLFCursor deviceLFCursor = this.deviceLF_cursor;
        int hashCode6 = (hashCode5 + (deviceLFCursor != null ? deviceLFCursor.hashCode() : 0)) * 37;
        DeviceMFCursor deviceMFCursor = this.deviceMF_cursor;
        int hashCode7 = (hashCode6 + (deviceMFCursor != null ? deviceMFCursor.hashCode() : 0)) * 37;
        InstalledAppCursor installedAppCursor = this.installed_app_cursor;
        if (installedAppCursor != null) {
            i2 = installedAppCursor.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CursorData> {
        public ContactCursor contact_cursor;
        public DeviceHFCursor deviceHF_cursor;
        public DeviceLFCursor deviceLF_cursor;
        public DeviceMFCursor deviceMF_cursor;
        public InstalledAppCursor installed_app_cursor;
        public LocationCursor location_cursor;
        public PhoneCursor phone_cursor;
        public SmsCursor sms_cursor;

        public Builder() {
        }

        public Builder(CursorData cursorData) {
            super(cursorData);
            if (cursorData != null) {
                this.sms_cursor = cursorData.sms_cursor;
                this.contact_cursor = cursorData.contact_cursor;
                this.phone_cursor = cursorData.phone_cursor;
                this.location_cursor = cursorData.location_cursor;
                this.deviceHF_cursor = cursorData.deviceHF_cursor;
                this.deviceLF_cursor = cursorData.deviceLF_cursor;
                this.deviceMF_cursor = cursorData.deviceMF_cursor;
                this.installed_app_cursor = cursorData.installed_app_cursor;
            }
        }

        public Builder sms_cursor(SmsCursor smsCursor) {
            this.sms_cursor = smsCursor;
            this.contact_cursor = null;
            this.phone_cursor = null;
            this.location_cursor = null;
            this.deviceHF_cursor = null;
            this.deviceLF_cursor = null;
            this.deviceMF_cursor = null;
            this.installed_app_cursor = null;
            return this;
        }

        public Builder contact_cursor(ContactCursor contactCursor) {
            this.contact_cursor = contactCursor;
            this.sms_cursor = null;
            this.phone_cursor = null;
            this.location_cursor = null;
            this.deviceHF_cursor = null;
            this.deviceLF_cursor = null;
            this.deviceMF_cursor = null;
            this.installed_app_cursor = null;
            return this;
        }

        public Builder phone_cursor(PhoneCursor phoneCursor) {
            this.phone_cursor = phoneCursor;
            this.sms_cursor = null;
            this.contact_cursor = null;
            this.location_cursor = null;
            this.deviceHF_cursor = null;
            this.deviceLF_cursor = null;
            this.deviceMF_cursor = null;
            this.installed_app_cursor = null;
            return this;
        }

        public Builder location_cursor(LocationCursor locationCursor) {
            this.location_cursor = locationCursor;
            this.sms_cursor = null;
            this.contact_cursor = null;
            this.phone_cursor = null;
            this.deviceHF_cursor = null;
            this.deviceLF_cursor = null;
            this.deviceMF_cursor = null;
            this.installed_app_cursor = null;
            return this;
        }

        public Builder deviceHF_cursor(DeviceHFCursor deviceHFCursor) {
            this.deviceHF_cursor = deviceHFCursor;
            this.sms_cursor = null;
            this.contact_cursor = null;
            this.phone_cursor = null;
            this.location_cursor = null;
            this.deviceLF_cursor = null;
            this.deviceMF_cursor = null;
            this.installed_app_cursor = null;
            return this;
        }

        public Builder deviceLF_cursor(DeviceLFCursor deviceLFCursor) {
            this.deviceLF_cursor = deviceLFCursor;
            this.sms_cursor = null;
            this.contact_cursor = null;
            this.phone_cursor = null;
            this.location_cursor = null;
            this.deviceHF_cursor = null;
            this.deviceMF_cursor = null;
            this.installed_app_cursor = null;
            return this;
        }

        public Builder deviceMF_cursor(DeviceMFCursor deviceMFCursor) {
            this.deviceMF_cursor = deviceMFCursor;
            this.sms_cursor = null;
            this.contact_cursor = null;
            this.phone_cursor = null;
            this.location_cursor = null;
            this.deviceHF_cursor = null;
            this.deviceLF_cursor = null;
            this.installed_app_cursor = null;
            return this;
        }

        public Builder installed_app_cursor(InstalledAppCursor installedAppCursor) {
            this.installed_app_cursor = installedAppCursor;
            this.sms_cursor = null;
            this.contact_cursor = null;
            this.phone_cursor = null;
            this.location_cursor = null;
            this.deviceHF_cursor = null;
            this.deviceLF_cursor = null;
            this.deviceMF_cursor = null;
            return this;
        }

        public CursorData build() {
            return new CursorData(this);
        }
    }
}
