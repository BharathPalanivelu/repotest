package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class InstalledAppInfo extends Message {
    public static final List<AppInfo> DEFAULT_APP_INFO = Collections.emptyList();
    public static final Integer DEFAULT_CLIENT_TIMESTAMP = 0;
    public static final String DEFAULT_ITEM_ID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = AppInfo.class, tag = 1)
    public final List<AppInfo> app_info;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer client_timestamp;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String item_id;

    public InstalledAppInfo(List<AppInfo> list, String str, Integer num) {
        this.app_info = immutableCopyOf(list);
        this.item_id = str;
        this.client_timestamp = num;
    }

    private InstalledAppInfo(Builder builder) {
        this(builder.app_info, builder.item_id, builder.client_timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstalledAppInfo)) {
            return false;
        }
        InstalledAppInfo installedAppInfo = (InstalledAppInfo) obj;
        if (!equals((List<?>) this.app_info, (List<?>) installedAppInfo.app_info) || !equals((Object) this.item_id, (Object) installedAppInfo.item_id) || !equals((Object) this.client_timestamp, (Object) installedAppInfo.client_timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<AppInfo> list = this.app_info;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        String str = this.item_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.client_timestamp;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<InstalledAppInfo> {
        public List<AppInfo> app_info;
        public Integer client_timestamp;
        public String item_id;

        public Builder() {
        }

        public Builder(InstalledAppInfo installedAppInfo) {
            super(installedAppInfo);
            if (installedAppInfo != null) {
                this.app_info = InstalledAppInfo.copyOf(installedAppInfo.app_info);
                this.item_id = installedAppInfo.item_id;
                this.client_timestamp = installedAppInfo.client_timestamp;
            }
        }

        public Builder app_info(List<AppInfo> list) {
            this.app_info = checkForNulls(list);
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public Builder client_timestamp(Integer num) {
            this.client_timestamp = num;
            return this;
        }

        public InstalledAppInfo build() {
            return new InstalledAppInfo(this);
        }
    }
}
