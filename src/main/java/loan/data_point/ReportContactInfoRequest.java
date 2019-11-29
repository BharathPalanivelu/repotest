package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ReportContactInfoRequest extends Message {
    public static final f DEFAULT_ACCOUNT = f.f32736b;
    public static final Integer DEFAULT_ACC_SHOPID = 0;
    public static final Integer DEFAULT_ACC_TYPE = 0;
    public static final Integer DEFAULT_ACC_USERID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_DATA_HASH_ID = "";
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final f DEFAULT_DEVICE_ID = f.f32736b;
    public static final String DEFAULT_ITEM_ID = "";
    public static final f DEFAULT_NAME = f.f32736b;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USER_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer acc_shopid;
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer acc_type;
    @ProtoField(tag = 9, type = Message.Datatype.UINT32)
    public final Integer acc_userid;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f account;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String data_hash_id;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f device_id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String item_id;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f name;
    @ProtoField(tag = 11, type = Message.Datatype.UINT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer user_id;

    public ReportContactInfoRequest(String str, String str2, Integer num, f fVar, f fVar2, f fVar3, Integer num2, Integer num3, Integer num4, Integer num5, f fVar4, String str3) {
        this.country = str;
        this.item_id = str2;
        this.user_id = num;
        this.device_id = fVar;
        this.account = fVar2;
        this.name = fVar3;
        this.acc_type = num2;
        this.acc_userid = num3;
        this.acc_shopid = num4;
        this.status = num5;
        this.device_fingerprint = fVar4;
        this.data_hash_id = str3;
    }

    private ReportContactInfoRequest(Builder builder) {
        this(builder.country, builder.item_id, builder.user_id, builder.device_id, builder.account, builder.name, builder.acc_type, builder.acc_userid, builder.acc_shopid, builder.status, builder.device_fingerprint, builder.data_hash_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReportContactInfoRequest)) {
            return false;
        }
        ReportContactInfoRequest reportContactInfoRequest = (ReportContactInfoRequest) obj;
        if (!equals((Object) this.country, (Object) reportContactInfoRequest.country) || !equals((Object) this.item_id, (Object) reportContactInfoRequest.item_id) || !equals((Object) this.user_id, (Object) reportContactInfoRequest.user_id) || !equals((Object) this.device_id, (Object) reportContactInfoRequest.device_id) || !equals((Object) this.account, (Object) reportContactInfoRequest.account) || !equals((Object) this.name, (Object) reportContactInfoRequest.name) || !equals((Object) this.acc_type, (Object) reportContactInfoRequest.acc_type) || !equals((Object) this.acc_userid, (Object) reportContactInfoRequest.acc_userid) || !equals((Object) this.acc_shopid, (Object) reportContactInfoRequest.acc_shopid) || !equals((Object) this.status, (Object) reportContactInfoRequest.status) || !equals((Object) this.device_fingerprint, (Object) reportContactInfoRequest.device_fingerprint) || !equals((Object) this.data_hash_id, (Object) reportContactInfoRequest.data_hash_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.country;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.item_id;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.user_id;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.device_id;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.account;
        int hashCode5 = (hashCode4 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        f fVar3 = this.name;
        int hashCode6 = (hashCode5 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        Integer num2 = this.acc_type;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.acc_userid;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.acc_shopid;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        f fVar4 = this.device_fingerprint;
        int hashCode11 = (hashCode10 + (fVar4 != null ? fVar4.hashCode() : 0)) * 37;
        String str3 = this.data_hash_id;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReportContactInfoRequest> {
        public Integer acc_shopid;
        public Integer acc_type;
        public Integer acc_userid;
        public f account;
        public String country;
        public String data_hash_id;
        public f device_fingerprint;
        public f device_id;
        public String item_id;
        public f name;
        public Integer status;
        public Integer user_id;

        public Builder() {
        }

        public Builder(ReportContactInfoRequest reportContactInfoRequest) {
            super(reportContactInfoRequest);
            if (reportContactInfoRequest != null) {
                this.country = reportContactInfoRequest.country;
                this.item_id = reportContactInfoRequest.item_id;
                this.user_id = reportContactInfoRequest.user_id;
                this.device_id = reportContactInfoRequest.device_id;
                this.account = reportContactInfoRequest.account;
                this.name = reportContactInfoRequest.name;
                this.acc_type = reportContactInfoRequest.acc_type;
                this.acc_userid = reportContactInfoRequest.acc_userid;
                this.acc_shopid = reportContactInfoRequest.acc_shopid;
                this.status = reportContactInfoRequest.status;
                this.device_fingerprint = reportContactInfoRequest.device_fingerprint;
                this.data_hash_id = reportContactInfoRequest.data_hash_id;
            }
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public Builder user_id(Integer num) {
            this.user_id = num;
            return this;
        }

        public Builder device_id(f fVar) {
            this.device_id = fVar;
            return this;
        }

        public Builder account(f fVar) {
            this.account = fVar;
            return this;
        }

        public Builder name(f fVar) {
            this.name = fVar;
            return this;
        }

        public Builder acc_type(Integer num) {
            this.acc_type = num;
            return this;
        }

        public Builder acc_userid(Integer num) {
            this.acc_userid = num;
            return this;
        }

        public Builder acc_shopid(Integer num) {
            this.acc_shopid = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder device_fingerprint(f fVar) {
            this.device_fingerprint = fVar;
            return this;
        }

        public Builder data_hash_id(String str) {
            this.data_hash_id = str;
            return this;
        }

        public ReportContactInfoRequest build() {
            return new ReportContactInfoRequest(this);
        }
    }
}
