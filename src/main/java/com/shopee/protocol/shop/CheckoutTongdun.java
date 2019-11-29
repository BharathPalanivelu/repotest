package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CheckoutTongdun extends Message {
    public static final Integer DEFAULT_BEHAVIOR_CHECK_RECORD_ID = 0;
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_DECODE_STATUS = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final String DEFAULT_FINAL_DECISION = "";
    public static final Integer DEFAULT_FINAL_SCORE = 0;
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_PLATFORM = "";
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_TONGDUN_DF = "";
    public static final String DEFAULT_TONGDUN_INFO = "";
    public static final Long DEFAULT_TOTAL_PRICE = 0L;
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer behavior_check_record_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer decode_status;
    @ProtoField(tag = 16, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String final_decision;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer final_score;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String platform;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String tongdun_df;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String tongdun_info;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long total_price;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String voucher_code;

    public CheckoutTongdun(Long l, Integer num, Integer num2, Long l2, String str, String str2, Integer num3, String str3, Long l3, Long l4, String str4, Integer num4, String str5, Integer num5, String str6, f fVar) {
        this.id = l;
        this.userid = num;
        this.behavior_check_record_id = num2;
        this.checkoutid = l2;
        this.tongdun_df = str;
        this.country = str2;
        this.ctime = num3;
        this.voucher_code = str3;
        this.promotionid = l3;
        this.total_price = l4;
        this.platform = str4;
        this.final_score = num4;
        this.final_decision = str5;
        this.decode_status = num5;
        this.tongdun_info = str6;
        this.extinfo = fVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CheckoutTongdun(com.shopee.protocol.shop.CheckoutTongdun.Builder r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = r19
            java.lang.Long r2 = r0.id
            java.lang.Integer r3 = r0.userid
            java.lang.Integer r4 = r0.behavior_check_record_id
            java.lang.Long r5 = r0.checkoutid
            java.lang.String r6 = r0.tongdun_df
            java.lang.String r7 = r0.country
            java.lang.Integer r8 = r0.ctime
            java.lang.String r9 = r0.voucher_code
            java.lang.Long r10 = r0.promotionid
            java.lang.Long r11 = r0.total_price
            java.lang.String r12 = r0.platform
            java.lang.Integer r13 = r0.final_score
            java.lang.String r14 = r0.final_decision
            java.lang.Integer r15 = r0.decode_status
            r18 = r1
            java.lang.String r1 = r0.tongdun_info
            r16 = r1
            e.f r1 = r0.extinfo
            r17 = r1
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r19.setBuilder(r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.CheckoutTongdun.<init>(com.shopee.protocol.shop.CheckoutTongdun$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutTongdun)) {
            return false;
        }
        CheckoutTongdun checkoutTongdun = (CheckoutTongdun) obj;
        if (!equals((Object) this.id, (Object) checkoutTongdun.id) || !equals((Object) this.userid, (Object) checkoutTongdun.userid) || !equals((Object) this.behavior_check_record_id, (Object) checkoutTongdun.behavior_check_record_id) || !equals((Object) this.checkoutid, (Object) checkoutTongdun.checkoutid) || !equals((Object) this.tongdun_df, (Object) checkoutTongdun.tongdun_df) || !equals((Object) this.country, (Object) checkoutTongdun.country) || !equals((Object) this.ctime, (Object) checkoutTongdun.ctime) || !equals((Object) this.voucher_code, (Object) checkoutTongdun.voucher_code) || !equals((Object) this.promotionid, (Object) checkoutTongdun.promotionid) || !equals((Object) this.total_price, (Object) checkoutTongdun.total_price) || !equals((Object) this.platform, (Object) checkoutTongdun.platform) || !equals((Object) this.final_score, (Object) checkoutTongdun.final_score) || !equals((Object) this.final_decision, (Object) checkoutTongdun.final_decision) || !equals((Object) this.decode_status, (Object) checkoutTongdun.decode_status) || !equals((Object) this.tongdun_info, (Object) checkoutTongdun.tongdun_info) || !equals((Object) this.extinfo, (Object) checkoutTongdun.extinfo)) {
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
        Integer num2 = this.behavior_check_record_id;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.checkoutid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.tongdun_df;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str3 = this.voucher_code;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l3 = this.promotionid;
        int hashCode9 = (hashCode8 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.total_price;
        int hashCode10 = (hashCode9 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str4 = this.platform;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num4 = this.final_score;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str5 = this.final_decision;
        int hashCode13 = (hashCode12 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num5 = this.decode_status;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str6 = this.tongdun_info;
        int hashCode15 = (hashCode14 + (str6 != null ? str6.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckoutTongdun> {
        public Integer behavior_check_record_id;
        public Long checkoutid;
        public String country;
        public Integer ctime;
        public Integer decode_status;
        public f extinfo;
        public String final_decision;
        public Integer final_score;
        public Long id;
        public String platform;
        public Long promotionid;
        public String tongdun_df;
        public String tongdun_info;
        public Long total_price;
        public Integer userid;
        public String voucher_code;

        public Builder() {
        }

        public Builder(CheckoutTongdun checkoutTongdun) {
            super(checkoutTongdun);
            if (checkoutTongdun != null) {
                this.id = checkoutTongdun.id;
                this.userid = checkoutTongdun.userid;
                this.behavior_check_record_id = checkoutTongdun.behavior_check_record_id;
                this.checkoutid = checkoutTongdun.checkoutid;
                this.tongdun_df = checkoutTongdun.tongdun_df;
                this.country = checkoutTongdun.country;
                this.ctime = checkoutTongdun.ctime;
                this.voucher_code = checkoutTongdun.voucher_code;
                this.promotionid = checkoutTongdun.promotionid;
                this.total_price = checkoutTongdun.total_price;
                this.platform = checkoutTongdun.platform;
                this.final_score = checkoutTongdun.final_score;
                this.final_decision = checkoutTongdun.final_decision;
                this.decode_status = checkoutTongdun.decode_status;
                this.tongdun_info = checkoutTongdun.tongdun_info;
                this.extinfo = checkoutTongdun.extinfo;
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

        public Builder behavior_check_record_id(Integer num) {
            this.behavior_check_record_id = num;
            return this;
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder tongdun_df(String str) {
            this.tongdun_df = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder total_price(Long l) {
            this.total_price = l;
            return this;
        }

        public Builder platform(String str) {
            this.platform = str;
            return this;
        }

        public Builder final_score(Integer num) {
            this.final_score = num;
            return this;
        }

        public Builder final_decision(String str) {
            this.final_decision = str;
            return this;
        }

        public Builder decode_status(Integer num) {
            this.decode_status = num;
            return this;
        }

        public Builder tongdun_info(String str) {
            this.tongdun_info = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public CheckoutTongdun build() {
            return new CheckoutTongdun(this);
        }
    }
}
