package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetWithdrawStatus extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_TRANSID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer transid;

    public SetWithdrawStatus(String str, Integer num, Integer num2, Integer num3) {
        this.requestid = str;
        this.shopid = num;
        this.transid = num2;
        this.status = num3;
    }

    private SetWithdrawStatus(Builder builder) {
        this(builder.requestid, builder.shopid, builder.transid, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetWithdrawStatus)) {
            return false;
        }
        SetWithdrawStatus setWithdrawStatus = (SetWithdrawStatus) obj;
        if (!equals((Object) this.requestid, (Object) setWithdrawStatus.requestid) || !equals((Object) this.shopid, (Object) setWithdrawStatus.shopid) || !equals((Object) this.transid, (Object) setWithdrawStatus.transid) || !equals((Object) this.status, (Object) setWithdrawStatus.status)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.transid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetWithdrawStatus> {
        public String requestid;
        public Integer shopid;
        public Integer status;
        public Integer transid;

        public Builder() {
        }

        public Builder(SetWithdrawStatus setWithdrawStatus) {
            super(setWithdrawStatus);
            if (setWithdrawStatus != null) {
                this.requestid = setWithdrawStatus.requestid;
                this.shopid = setWithdrawStatus.shopid;
                this.transid = setWithdrawStatus.transid;
                this.status = setWithdrawStatus.status;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder transid(Integer num) {
            this.transid = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public SetWithdrawStatus build() {
            checkRequiredFields();
            return new SetWithdrawStatus(this);
        }
    }
}
