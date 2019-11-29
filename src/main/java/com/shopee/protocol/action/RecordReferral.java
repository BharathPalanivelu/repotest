package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RecordReferral extends Message {
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_REFERRAL_CODE = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String referral_code;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public RecordReferral(String str, String str2, String str3) {
        this.requestid = str;
        this.referral_code = str2;
        this.phone = str3;
    }

    private RecordReferral(Builder builder) {
        this(builder.requestid, builder.referral_code, builder.phone);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecordReferral)) {
            return false;
        }
        RecordReferral recordReferral = (RecordReferral) obj;
        if (!equals((Object) this.requestid, (Object) recordReferral.requestid) || !equals((Object) this.referral_code, (Object) recordReferral.referral_code) || !equals((Object) this.phone, (Object) recordReferral.phone)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.referral_code;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.phone;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RecordReferral> {
        public String phone;
        public String referral_code;
        public String requestid;

        public Builder() {
        }

        public Builder(RecordReferral recordReferral) {
            super(recordReferral);
            if (recordReferral != null) {
                this.requestid = recordReferral.requestid;
                this.referral_code = recordReferral.referral_code;
                this.phone = recordReferral.phone;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder referral_code(String str) {
            this.referral_code = str;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public RecordReferral build() {
            return new RecordReferral(this);
        }
    }
}
