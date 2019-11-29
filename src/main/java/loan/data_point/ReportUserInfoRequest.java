package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ReportUserInfoRequest extends Message {
    public static final String DEFAULT_APP_VERSION = "";
    public static final Integer DEFAULT_CONTENT_TYPE = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final f DEFAULT_DEVICE_ID = f.f32736b;
    public static final f DEFAULT_ENCRYPT_DATA = f.f32736b;
    public static final String DEFAULT_ENCRYPT_DATA_HASH = "";
    public static final f DEFAULT_ENCRYPT_KEY = f.f32736b;
    public static final Integer DEFAULT_PLATFORM_TYPE = 0;
    public static final String DEFAULT_PUBLIC_IP = "";
    public static final Integer DEFAULT_USER_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String app_version;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer content_type;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f device_id;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f encrypt_data;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String encrypt_data_hash;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f encrypt_key;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer platform_type;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String public_ip;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer user_id;

    public ReportUserInfoRequest(Integer num, f fVar, f fVar2, String str, String str2, Integer num2, Integer num3, f fVar3, f fVar4, String str3, String str4) {
        this.user_id = num;
        this.device_id = fVar;
        this.device_fingerprint = fVar2;
        this.encrypt_data_hash = str;
        this.country = str2;
        this.platform_type = num2;
        this.content_type = num3;
        this.encrypt_key = fVar3;
        this.encrypt_data = fVar4;
        this.app_version = str3;
        this.public_ip = str4;
    }

    private ReportUserInfoRequest(Builder builder) {
        this(builder.user_id, builder.device_id, builder.device_fingerprint, builder.encrypt_data_hash, builder.country, builder.platform_type, builder.content_type, builder.encrypt_key, builder.encrypt_data, builder.app_version, builder.public_ip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReportUserInfoRequest)) {
            return false;
        }
        ReportUserInfoRequest reportUserInfoRequest = (ReportUserInfoRequest) obj;
        if (!equals((Object) this.user_id, (Object) reportUserInfoRequest.user_id) || !equals((Object) this.device_id, (Object) reportUserInfoRequest.device_id) || !equals((Object) this.device_fingerprint, (Object) reportUserInfoRequest.device_fingerprint) || !equals((Object) this.encrypt_data_hash, (Object) reportUserInfoRequest.encrypt_data_hash) || !equals((Object) this.country, (Object) reportUserInfoRequest.country) || !equals((Object) this.platform_type, (Object) reportUserInfoRequest.platform_type) || !equals((Object) this.content_type, (Object) reportUserInfoRequest.content_type) || !equals((Object) this.encrypt_key, (Object) reportUserInfoRequest.encrypt_key) || !equals((Object) this.encrypt_data, (Object) reportUserInfoRequest.encrypt_data) || !equals((Object) this.app_version, (Object) reportUserInfoRequest.app_version) || !equals((Object) this.public_ip, (Object) reportUserInfoRequest.public_ip)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.user_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        f fVar = this.device_id;
        int hashCode2 = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.device_fingerprint;
        int hashCode3 = (hashCode2 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        String str = this.encrypt_data_hash;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.platform_type;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.content_type;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        f fVar3 = this.encrypt_key;
        int hashCode8 = (hashCode7 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        f fVar4 = this.encrypt_data;
        int hashCode9 = (hashCode8 + (fVar4 != null ? fVar4.hashCode() : 0)) * 37;
        String str3 = this.app_version;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.public_ip;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReportUserInfoRequest> {
        public String app_version;
        public Integer content_type;
        public String country;
        public f device_fingerprint;
        public f device_id;
        public f encrypt_data;
        public String encrypt_data_hash;
        public f encrypt_key;
        public Integer platform_type;
        public String public_ip;
        public Integer user_id;

        public Builder() {
        }

        public Builder(ReportUserInfoRequest reportUserInfoRequest) {
            super(reportUserInfoRequest);
            if (reportUserInfoRequest != null) {
                this.user_id = reportUserInfoRequest.user_id;
                this.device_id = reportUserInfoRequest.device_id;
                this.device_fingerprint = reportUserInfoRequest.device_fingerprint;
                this.encrypt_data_hash = reportUserInfoRequest.encrypt_data_hash;
                this.country = reportUserInfoRequest.country;
                this.platform_type = reportUserInfoRequest.platform_type;
                this.content_type = reportUserInfoRequest.content_type;
                this.encrypt_key = reportUserInfoRequest.encrypt_key;
                this.encrypt_data = reportUserInfoRequest.encrypt_data;
                this.app_version = reportUserInfoRequest.app_version;
                this.public_ip = reportUserInfoRequest.public_ip;
            }
        }

        public Builder user_id(Integer num) {
            this.user_id = num;
            return this;
        }

        public Builder device_id(f fVar) {
            this.device_id = fVar;
            return this;
        }

        public Builder device_fingerprint(f fVar) {
            this.device_fingerprint = fVar;
            return this;
        }

        public Builder encrypt_data_hash(String str) {
            this.encrypt_data_hash = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder platform_type(Integer num) {
            this.platform_type = num;
            return this;
        }

        public Builder content_type(Integer num) {
            this.content_type = num;
            return this;
        }

        public Builder encrypt_key(f fVar) {
            this.encrypt_key = fVar;
            return this;
        }

        public Builder encrypt_data(f fVar) {
            this.encrypt_data = fVar;
            return this;
        }

        public Builder app_version(String str) {
            this.app_version = str;
            return this;
        }

        public Builder public_ip(String str) {
            this.public_ip = str;
            return this;
        }

        public ReportUserInfoRequest build() {
            return new ReportUserInfoRequest(this);
        }
    }
}
