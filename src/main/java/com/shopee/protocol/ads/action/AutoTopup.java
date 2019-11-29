package com.shopee.protocol.ads.action;

import com.google.android.gms.location.places.Place;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;
import e.f;

public final class AutoTopup extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final Long DEFAULT_CTIME = 0L;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public AutoTopup(Long l, Integer num, Long l2, Long l3, Long l4, Integer num2, f fVar) {
        this.id = l;
        this.userid = num;
        this.amount = l2;
        this.ctime = l3;
        this.mtime = l4;
        this.status = num2;
        this.extinfo = fVar;
    }

    private AutoTopup(Builder builder) {
        this(builder.id, builder.userid, builder.amount, builder.ctime, builder.mtime, builder.status, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoTopup)) {
            return false;
        }
        AutoTopup autoTopup = (AutoTopup) obj;
        if (!equals((Object) this.id, (Object) autoTopup.id) || !equals((Object) this.userid, (Object) autoTopup.userid) || !equals((Object) this.amount, (Object) autoTopup.amount) || !equals((Object) this.ctime, (Object) autoTopup.ctime) || !equals((Object) this.mtime, (Object) autoTopup.mtime) || !equals((Object) this.status, (Object) autoTopup.status) || !equals((Object) this.extinfo, (Object) autoTopup.extinfo)) {
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
        Long l2 = this.amount;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.ctime;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.mtime;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AutoTopup> {
        public Long amount;
        public Long ctime;
        public f extinfo;
        public Long id;
        public Long mtime;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(AutoTopup autoTopup) {
            super(autoTopup);
            if (autoTopup != null) {
                this.id = autoTopup.id;
                this.userid = autoTopup.userid;
                this.amount = autoTopup.amount;
                this.ctime = autoTopup.ctime;
                this.mtime = autoTopup.mtime;
                this.status = autoTopup.status;
                this.extinfo = autoTopup.extinfo;
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

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public AutoTopup build() {
            return new AutoTopup(this);
        }
    }

    public enum Status implements ProtoEnum {
        START(0),
        TRY_DEDUCT(1),
        NOTIFY(2),
        DEDUCT_SUCC(3),
        DAILY_CHECK(4),
        REFUND(5),
        REFUND_FAIL(6),
        GEN_INVOICE(7),
        BOUND_FLAG(1024),
        TOPUP_SUCC(1025),
        REFUND_SUCC(1026),
        CHECK_FAIL(1027),
        DEDUCT_FAIL(1028),
        START_ABORT(Place.TYPE_SYNTHETIC_GEOCODE),
        NOTIFY_ABORT(Place.TYPE_TRANSIT_STATION),
        DAILY_CHECK_ABORT(1031),
        UNKNOWN(Integer.MAX_VALUE);
        
        private final int value;

        private Status(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
