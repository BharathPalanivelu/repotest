package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class GetReportCursorRequest extends Message {
    public static final Integer DEFAULT_CONTENT_TYPE = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final f DEFAULT_DEVICE_ID = f.f32736b;
    public static final Integer DEFAULT_PLATFORM_TYPE = 0;
    public static final Integer DEFAULT_USER_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer content_type;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f device_id;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer platform_type;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer user_id;

    public GetReportCursorRequest(Integer num, f fVar, f fVar2, String str, Integer num2, Integer num3) {
        this.user_id = num;
        this.device_id = fVar;
        this.device_fingerprint = fVar2;
        this.country = str;
        this.platform_type = num2;
        this.content_type = num3;
    }

    private GetReportCursorRequest(Builder builder) {
        this(builder.user_id, builder.device_id, builder.device_fingerprint, builder.country, builder.platform_type, builder.content_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetReportCursorRequest)) {
            return false;
        }
        GetReportCursorRequest getReportCursorRequest = (GetReportCursorRequest) obj;
        if (!equals((Object) this.user_id, (Object) getReportCursorRequest.user_id) || !equals((Object) this.device_id, (Object) getReportCursorRequest.device_id) || !equals((Object) this.device_fingerprint, (Object) getReportCursorRequest.device_fingerprint) || !equals((Object) this.country, (Object) getReportCursorRequest.country) || !equals((Object) this.platform_type, (Object) getReportCursorRequest.platform_type) || !equals((Object) this.content_type, (Object) getReportCursorRequest.content_type)) {
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
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.platform_type;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.content_type;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetReportCursorRequest> {
        public Integer content_type;
        public String country;
        public f device_fingerprint;
        public f device_id;
        public Integer platform_type;
        public Integer user_id;

        public Builder() {
        }

        public Builder(GetReportCursorRequest getReportCursorRequest) {
            super(getReportCursorRequest);
            if (getReportCursorRequest != null) {
                this.user_id = getReportCursorRequest.user_id;
                this.device_id = getReportCursorRequest.device_id;
                this.device_fingerprint = getReportCursorRequest.device_fingerprint;
                this.country = getReportCursorRequest.country;
                this.platform_type = getReportCursorRequest.platform_type;
                this.content_type = getReportCursorRequest.content_type;
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

        public GetReportCursorRequest build() {
            return new GetReportCursorRequest(this);
        }
    }
}
