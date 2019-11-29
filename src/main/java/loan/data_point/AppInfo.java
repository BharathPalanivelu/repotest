package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AppInfo extends Message {
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_APP_NAME = "";
    public static final Integer DEFAULT_FIRST_INSTALLED_TIME = 0;
    public static final Integer DEFAULT_LAST_UPDATED_TIME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String app_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String app_name;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer first_installed_time;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer last_updated_time;

    public AppInfo(String str, String str2, Integer num, Integer num2) {
        this.app_id = str;
        this.app_name = str2;
        this.first_installed_time = num;
        this.last_updated_time = num2;
    }

    private AppInfo(Builder builder) {
        this(builder.app_id, builder.app_name, builder.first_installed_time, builder.last_updated_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppInfo)) {
            return false;
        }
        AppInfo appInfo = (AppInfo) obj;
        if (!equals((Object) this.app_id, (Object) appInfo.app_id) || !equals((Object) this.app_name, (Object) appInfo.app_name) || !equals((Object) this.first_installed_time, (Object) appInfo.first_installed_time) || !equals((Object) this.last_updated_time, (Object) appInfo.last_updated_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.app_id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.app_name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.first_installed_time;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.last_updated_time;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AppInfo> {
        public String app_id;
        public String app_name;
        public Integer first_installed_time;
        public Integer last_updated_time;

        public Builder() {
        }

        public Builder(AppInfo appInfo) {
            super(appInfo);
            if (appInfo != null) {
                this.app_id = appInfo.app_id;
                this.app_name = appInfo.app_name;
                this.first_installed_time = appInfo.first_installed_time;
                this.last_updated_time = appInfo.last_updated_time;
            }
        }

        public Builder app_id(String str) {
            this.app_id = str;
            return this;
        }

        public Builder app_name(String str) {
            this.app_name = str;
            return this;
        }

        public Builder first_installed_time(Integer num) {
            this.first_installed_time = num;
            return this;
        }

        public Builder last_updated_time(Integer num) {
            this.last_updated_time = num;
            return this;
        }

        public AppInfo build() {
            return new AppInfo(this);
        }
    }
}
