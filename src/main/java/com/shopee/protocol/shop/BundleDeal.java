package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class BundleDeal extends Message {
    public static final Long DEFAULT_BUNDLE_DEAL_ID = 0L;
    public static final f DEFAULT_BUNDLE_DEAL_RULE = f.f32736b;
    public static final Long DEFAULT_COMM_FEE = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_FLAG = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_REBATE_AMOUNT = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USAGE_LIMIT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long bundle_deal_id;
    @ProtoField(tag = 13, type = Message.Datatype.BYTES)
    public final f bundle_deal_rule;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long comm_fee;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 14, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long flag;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long rebate_amount;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer usage_limit;

    public BundleDeal(Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Long l2, Long l3, Integer num7, Long l4, String str, f fVar, f fVar2) {
        this.bundle_deal_id = l;
        this.shopid = num;
        this.start_time = num2;
        this.end_time = num3;
        this.ctime = num4;
        this.mtime = num5;
        this.status = num6;
        this.rebate_amount = l2;
        this.comm_fee = l3;
        this.usage_limit = num7;
        this.flag = l4;
        this.country = str;
        this.bundle_deal_rule = fVar;
        this.extinfo = fVar2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private BundleDeal(com.shopee.protocol.shop.BundleDeal.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Long r2 = r0.bundle_deal_id
            java.lang.Integer r3 = r0.shopid
            java.lang.Integer r4 = r0.start_time
            java.lang.Integer r5 = r0.end_time
            java.lang.Integer r6 = r0.ctime
            java.lang.Integer r7 = r0.mtime
            java.lang.Integer r8 = r0.status
            java.lang.Long r9 = r0.rebate_amount
            java.lang.Long r10 = r0.comm_fee
            java.lang.Integer r11 = r0.usage_limit
            java.lang.Long r12 = r0.flag
            java.lang.String r13 = r0.country
            e.f r14 = r0.bundle_deal_rule
            e.f r15 = r0.extinfo
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.BundleDeal.<init>(com.shopee.protocol.shop.BundleDeal$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BundleDeal)) {
            return false;
        }
        BundleDeal bundleDeal = (BundleDeal) obj;
        if (!equals((Object) this.bundle_deal_id, (Object) bundleDeal.bundle_deal_id) || !equals((Object) this.shopid, (Object) bundleDeal.shopid) || !equals((Object) this.start_time, (Object) bundleDeal.start_time) || !equals((Object) this.end_time, (Object) bundleDeal.end_time) || !equals((Object) this.ctime, (Object) bundleDeal.ctime) || !equals((Object) this.mtime, (Object) bundleDeal.mtime) || !equals((Object) this.status, (Object) bundleDeal.status) || !equals((Object) this.rebate_amount, (Object) bundleDeal.rebate_amount) || !equals((Object) this.comm_fee, (Object) bundleDeal.comm_fee) || !equals((Object) this.usage_limit, (Object) bundleDeal.usage_limit) || !equals((Object) this.flag, (Object) bundleDeal.flag) || !equals((Object) this.country, (Object) bundleDeal.country) || !equals((Object) this.bundle_deal_rule, (Object) bundleDeal.bundle_deal_rule) || !equals((Object) this.extinfo, (Object) bundleDeal.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.bundle_deal_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.start_time;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.end_time;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.status;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l2 = this.rebate_amount;
        int hashCode8 = (hashCode7 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.comm_fee;
        int hashCode9 = (hashCode8 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num7 = this.usage_limit;
        int hashCode10 = (hashCode9 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l4 = this.flag;
        int hashCode11 = (hashCode10 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode12 = (hashCode11 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.bundle_deal_rule;
        int hashCode13 = (hashCode12 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.extinfo;
        if (fVar2 != null) {
            i2 = fVar2.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BundleDeal> {
        public Long bundle_deal_id;
        public f bundle_deal_rule;
        public Long comm_fee;
        public String country;
        public Integer ctime;
        public Integer end_time;
        public f extinfo;
        public Long flag;
        public Integer mtime;
        public Long rebate_amount;
        public Integer shopid;
        public Integer start_time;
        public Integer status;
        public Integer usage_limit;

        public Builder() {
        }

        public Builder(BundleDeal bundleDeal) {
            super(bundleDeal);
            if (bundleDeal != null) {
                this.bundle_deal_id = bundleDeal.bundle_deal_id;
                this.shopid = bundleDeal.shopid;
                this.start_time = bundleDeal.start_time;
                this.end_time = bundleDeal.end_time;
                this.ctime = bundleDeal.ctime;
                this.mtime = bundleDeal.mtime;
                this.status = bundleDeal.status;
                this.rebate_amount = bundleDeal.rebate_amount;
                this.comm_fee = bundleDeal.comm_fee;
                this.usage_limit = bundleDeal.usage_limit;
                this.flag = bundleDeal.flag;
                this.country = bundleDeal.country;
                this.bundle_deal_rule = bundleDeal.bundle_deal_rule;
                this.extinfo = bundleDeal.extinfo;
            }
        }

        public Builder bundle_deal_id(Long l) {
            this.bundle_deal_id = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
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

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder rebate_amount(Long l) {
            this.rebate_amount = l;
            return this;
        }

        public Builder comm_fee(Long l) {
            this.comm_fee = l;
            return this;
        }

        public Builder usage_limit(Integer num) {
            this.usage_limit = num;
            return this;
        }

        public Builder flag(Long l) {
            this.flag = l;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder bundle_deal_rule(f fVar) {
            this.bundle_deal_rule = fVar;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public BundleDeal build() {
            return new BundleDeal(this);
        }
    }
}
