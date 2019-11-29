package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CreateCommRule extends Message {
    public static final Long DEFAULT_CAP = 0L;
    public static final Integer DEFAULT_CAT_ID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_GROUP_ID = 0;
    public static final Long DEFAULT_RATE = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long cap;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer cat_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer group_id;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long rate;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;

    public CreateCommRule(String str, Integer num, Integer num2, Integer num3, String str2, Long l, Long l2) {
        this.requestid = str;
        this.cat_id = num;
        this.group_id = num2;
        this.status = num3;
        this.country = str2;
        this.cap = l;
        this.rate = l2;
    }

    private CreateCommRule(Builder builder) {
        this(builder.requestid, builder.cat_id, builder.group_id, builder.status, builder.country, builder.cap, builder.rate);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateCommRule)) {
            return false;
        }
        CreateCommRule createCommRule = (CreateCommRule) obj;
        if (!equals((Object) this.requestid, (Object) createCommRule.requestid) || !equals((Object) this.cat_id, (Object) createCommRule.cat_id) || !equals((Object) this.group_id, (Object) createCommRule.group_id) || !equals((Object) this.status, (Object) createCommRule.status) || !equals((Object) this.country, (Object) createCommRule.country) || !equals((Object) this.cap, (Object) createCommRule.cap) || !equals((Object) this.rate, (Object) createCommRule.rate)) {
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
        Integer num = this.cat_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.group_id;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.cap;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.rate;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CreateCommRule> {
        public Long cap;
        public Integer cat_id;
        public String country;
        public Integer group_id;
        public Long rate;
        public String requestid;
        public Integer status;

        public Builder() {
        }

        public Builder(CreateCommRule createCommRule) {
            super(createCommRule);
            if (createCommRule != null) {
                this.requestid = createCommRule.requestid;
                this.cat_id = createCommRule.cat_id;
                this.group_id = createCommRule.group_id;
                this.status = createCommRule.status;
                this.country = createCommRule.country;
                this.cap = createCommRule.cap;
                this.rate = createCommRule.rate;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public CreateCommRule build() {
            return new CreateCommRule(this);
        }
    }
}
