package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;
import e.f;

public final class AutoTopupAuditLog extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final Long DEFAULT_CTIME = 0L;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_OPERATION = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer operation;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public AutoTopupAuditLog(Long l, Integer num, Integer num2, Long l2, Long l3, f fVar) {
        this.id = l;
        this.userid = num;
        this.operation = num2;
        this.ctime = l2;
        this.amount = l3;
        this.extinfo = fVar;
    }

    private AutoTopupAuditLog(Builder builder) {
        this(builder.id, builder.userid, builder.operation, builder.ctime, builder.amount, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoTopupAuditLog)) {
            return false;
        }
        AutoTopupAuditLog autoTopupAuditLog = (AutoTopupAuditLog) obj;
        if (!equals((Object) this.id, (Object) autoTopupAuditLog.id) || !equals((Object) this.userid, (Object) autoTopupAuditLog.userid) || !equals((Object) this.operation, (Object) autoTopupAuditLog.operation) || !equals((Object) this.ctime, (Object) autoTopupAuditLog.ctime) || !equals((Object) this.amount, (Object) autoTopupAuditLog.amount) || !equals((Object) this.extinfo, (Object) autoTopupAuditLog.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.operation;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.ctime;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.amount;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AutoTopupAuditLog> {
        public Long amount;
        public Long ctime;
        public f extinfo;
        public Long id;
        public Integer operation;
        public Integer userid;

        public Builder() {
        }

        public Builder(AutoTopupAuditLog autoTopupAuditLog) {
            super(autoTopupAuditLog);
            if (autoTopupAuditLog != null) {
                this.id = autoTopupAuditLog.id;
                this.userid = autoTopupAuditLog.userid;
                this.operation = autoTopupAuditLog.operation;
                this.ctime = autoTopupAuditLog.ctime;
                this.amount = autoTopupAuditLog.amount;
                this.extinfo = autoTopupAuditLog.extinfo;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder operation(Integer num) {
            this.operation = num;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public AutoTopupAuditLog build() {
            return new AutoTopupAuditLog(this);
        }
    }

    public enum Operation implements ProtoEnum {
        WALLET_DEDUCT(0),
        WALLET_REFUND(1);
        
        private final int value;

        private Operation(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
