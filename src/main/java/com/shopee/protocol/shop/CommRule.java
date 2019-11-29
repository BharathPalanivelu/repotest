package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CommRule extends Message {
    public static final Long DEFAULT_CAP = 0L;
    public static final Integer DEFAULT_CAT_ID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_GROUP_ID = 0;
    public static final Long DEFAULT_RATE = 0L;
    public static final Integer DEFAULT_RULE_ID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long cap;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer cat_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer group_id;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long rate;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rule_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public CommRule(Integer num, Integer num2, Integer num3, Integer num4, String str, Long l, Long l2, Integer num5) {
        this.rule_id = num;
        this.cat_id = num2;
        this.group_id = num3;
        this.status = num4;
        this.country = str;
        this.cap = l;
        this.rate = l2;
        this.ctime = num5;
    }

    private CommRule(Builder builder) {
        this(builder.rule_id, builder.cat_id, builder.group_id, builder.status, builder.country, builder.cap, builder.rate, builder.ctime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CommRule)) {
            return false;
        }
        CommRule commRule = (CommRule) obj;
        if (!equals((Object) this.rule_id, (Object) commRule.rule_id) || !equals((Object) this.cat_id, (Object) commRule.cat_id) || !equals((Object) this.group_id, (Object) commRule.group_id) || !equals((Object) this.status, (Object) commRule.status) || !equals((Object) this.country, (Object) commRule.country) || !equals((Object) this.cap, (Object) commRule.cap) || !equals((Object) this.rate, (Object) commRule.rate) || !equals((Object) this.ctime, (Object) commRule.ctime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.rule_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.cat_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.group_id;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.cap;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.rate;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num5 = this.ctime;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CommRule> {
        public Long cap;
        public Integer cat_id;
        public String country;
        public Integer ctime;
        public Integer group_id;
        public Long rate;
        public Integer rule_id;
        public Integer status;

        public Builder() {
        }

        public Builder(CommRule commRule) {
            super(commRule);
            if (commRule != null) {
                this.rule_id = commRule.rule_id;
                this.cat_id = commRule.cat_id;
                this.group_id = commRule.group_id;
                this.status = commRule.status;
                this.country = commRule.country;
                this.cap = commRule.cap;
                this.rate = commRule.rate;
                this.ctime = commRule.ctime;
            }
        }

        public Builder rule_id(Integer num) {
            this.rule_id = num;
            return this;
        }

        public Builder cat_id(Integer num) {
            this.cat_id = num;
            return this;
        }

        public Builder group_id(Integer num) {
            this.group_id = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder cap(Long l) {
            this.cap = l;
            return this;
        }

        public Builder rate(Long l) {
            this.rate = l;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public CommRule build() {
            return new CommRule(this);
        }
    }
}
