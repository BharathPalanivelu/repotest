package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class VoucherWallet extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_REWARD_TYPE = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    public static final Integer DEFAULT_USED_COUNT = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_USE_TYPE = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer reward_type;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer total_count;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer use_type;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer used_count;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String voucher_code;

    public VoucherWallet(Integer num, Integer num2, Long l, String str, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, f fVar) {
        this.userid = num;
        this.ctime = num2;
        this.promotionid = l;
        this.voucher_code = str;
        this.use_type = num3;
        this.reward_type = num4;
        this.start_time = num5;
        this.end_time = num6;
        this.total_count = num7;
        this.used_count = num8;
        this.status = num9;
        this.extinfo = fVar;
    }

    private VoucherWallet(Builder builder) {
        this(builder.userid, builder.ctime, builder.promotionid, builder.voucher_code, builder.use_type, builder.reward_type, builder.start_time, builder.end_time, builder.total_count, builder.used_count, builder.status, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoucherWallet)) {
            return false;
        }
        VoucherWallet voucherWallet = (VoucherWallet) obj;
        if (!equals((Object) this.userid, (Object) voucherWallet.userid) || !equals((Object) this.ctime, (Object) voucherWallet.ctime) || !equals((Object) this.promotionid, (Object) voucherWallet.promotionid) || !equals((Object) this.voucher_code, (Object) voucherWallet.voucher_code) || !equals((Object) this.use_type, (Object) voucherWallet.use_type) || !equals((Object) this.reward_type, (Object) voucherWallet.reward_type) || !equals((Object) this.start_time, (Object) voucherWallet.start_time) || !equals((Object) this.end_time, (Object) voucherWallet.end_time) || !equals((Object) this.total_count, (Object) voucherWallet.total_count) || !equals((Object) this.used_count, (Object) voucherWallet.used_count) || !equals((Object) this.status, (Object) voucherWallet.status) || !equals((Object) this.extinfo, (Object) voucherWallet.extinfo)) {
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
        Integer num2 = this.ctime;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.promotionid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.voucher_code;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.use_type;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.reward_type;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.start_time;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.end_time;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.total_count;
        int hashCode9 = (hashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.used_count;
        int hashCode10 = (hashCode9 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.status;
        int hashCode11 = (hashCode10 + (num9 != null ? num9.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VoucherWallet> {
        public Integer ctime;
        public Integer end_time;
        public f extinfo;
        public Long promotionid;
        public Integer reward_type;
        public Integer start_time;
        public Integer status;
        public Integer total_count;
        public Integer use_type;
        public Integer used_count;
        public Integer userid;
        public String voucher_code;

        public Builder() {
        }

        public Builder(VoucherWallet voucherWallet) {
            super(voucherWallet);
            if (voucherWallet != null) {
                this.userid = voucherWallet.userid;
                this.ctime = voucherWallet.ctime;
                this.promotionid = voucherWallet.promotionid;
                this.voucher_code = voucherWallet.voucher_code;
                this.use_type = voucherWallet.use_type;
                this.reward_type = voucherWallet.reward_type;
                this.start_time = voucherWallet.start_time;
                this.end_time = voucherWallet.end_time;
                this.total_count = voucherWallet.total_count;
                this.used_count = voucherWallet.used_count;
                this.status = voucherWallet.status;
                this.extinfo = voucherWallet.extinfo;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
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

        public Builder use_type(Integer num) {
            this.use_type = num;
            return this;
        }

        public Builder reward_type(Integer num) {
            this.reward_type = num;
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

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public Builder used_count(Integer num) {
            this.used_count = num;
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

        public VoucherWallet build() {
            return new VoucherWallet(this);
        }
    }
}
