package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Voucher extends Message {
    public static final Integer DEFAULT_COLLECTION_STATUS = 0;
    public static final Long DEFAULT_COLLECTION_TIME = 0L;
    public static final Long DEFAULT_CREATION_TIME = 0L;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USAGE_STATUS = 0;
    public static final Long DEFAULT_USAGE_TIME = 0L;
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer collection_status;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long collection_time;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long creation_time;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer usage_status;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long usage_time;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String voucher_code;

    public Voucher(Integer num, Long l, String str, Long l2, Integer num2, Long l3, Integer num3, Long l4, Integer num4, Integer num5, Integer num6) {
        this.userid = num;
        this.promotionid = l;
        this.voucher_code = str;
        this.creation_time = l2;
        this.collection_status = num2;
        this.collection_time = l3;
        this.usage_status = num3;
        this.usage_time = l4;
        this.status = num4;
        this.start_time = num5;
        this.end_time = num6;
    }

    private Voucher(Builder builder) {
        this(builder.userid, builder.promotionid, builder.voucher_code, builder.creation_time, builder.collection_status, builder.collection_time, builder.usage_status, builder.usage_time, builder.status, builder.start_time, builder.end_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Voucher)) {
            return false;
        }
        Voucher voucher = (Voucher) obj;
        if (!equals((Object) this.userid, (Object) voucher.userid) || !equals((Object) this.promotionid, (Object) voucher.promotionid) || !equals((Object) this.voucher_code, (Object) voucher.voucher_code) || !equals((Object) this.creation_time, (Object) voucher.creation_time) || !equals((Object) this.collection_status, (Object) voucher.collection_status) || !equals((Object) this.collection_time, (Object) voucher.collection_time) || !equals((Object) this.usage_status, (Object) voucher.usage_status) || !equals((Object) this.usage_time, (Object) voucher.usage_time) || !equals((Object) this.status, (Object) voucher.status) || !equals((Object) this.start_time, (Object) voucher.start_time) || !equals((Object) this.end_time, (Object) voucher.end_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.promotionid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.voucher_code;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.creation_time;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.collection_status;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l3 = this.collection_time;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num3 = this.usage_status;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l4 = this.usage_time;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.start_time;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.end_time;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Voucher> {
        public Integer collection_status;
        public Long collection_time;
        public Long creation_time;
        public Integer end_time;
        public Long promotionid;
        public Integer start_time;
        public Integer status;
        public Integer usage_status;
        public Long usage_time;
        public Integer userid;
        public String voucher_code;

        public Builder() {
        }

        public Builder(Voucher voucher) {
            super(voucher);
            if (voucher != null) {
                this.userid = voucher.userid;
                this.promotionid = voucher.promotionid;
                this.voucher_code = voucher.voucher_code;
                this.creation_time = voucher.creation_time;
                this.collection_status = voucher.collection_status;
                this.collection_time = voucher.collection_time;
                this.usage_status = voucher.usage_status;
                this.usage_time = voucher.usage_time;
                this.status = voucher.status;
                this.start_time = voucher.start_time;
                this.end_time = voucher.end_time;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder creation_time(Long l) {
            this.creation_time = l;
            return this;
        }

        public Builder collection_status(Integer num) {
            this.collection_status = num;
            return this;
        }

        public Builder collection_time(Long l) {
            this.collection_time = l;
            return this;
        }

        public Builder usage_status(Integer num) {
            this.usage_status = num;
            return this;
        }

        public Builder usage_time(Long l) {
            this.usage_time = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Voucher build() {
            return new Voucher(this);
        }
    }
}
