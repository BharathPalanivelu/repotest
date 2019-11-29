package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetHotHashTag extends Message {
    public static final Integer DEFAULT_BEGIN = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NEED_DETAIL = false;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer begin;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean need_detail;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetHotHashTag(String str, Integer num, Integer num2, String str2, Boolean bool) {
        this.requestid = str;
        this.begin = num;
        this.limit = num2;
        this.country = str2;
        this.need_detail = bool;
    }

    private GetHotHashTag(Builder builder) {
        this(builder.requestid, builder.begin, builder.limit, builder.country, builder.need_detail);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetHotHashTag)) {
            return false;
        }
        GetHotHashTag getHotHashTag = (GetHotHashTag) obj;
        if (!equals((Object) this.requestid, (Object) getHotHashTag.requestid) || !equals((Object) this.begin, (Object) getHotHashTag.begin) || !equals((Object) this.limit, (Object) getHotHashTag.limit) || !equals((Object) this.country, (Object) getHotHashTag.country) || !equals((Object) this.need_detail, (Object) getHotHashTag.need_detail)) {
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
        Integer num = this.begin;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.need_detail;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetHotHashTag> {
        public Integer begin;
        public String country;
        public Integer limit;
        public Boolean need_detail;
        public String requestid;

        public Builder() {
        }

        public Builder(GetHotHashTag getHotHashTag) {
            super(getHotHashTag);
            if (getHotHashTag != null) {
                this.requestid = getHotHashTag.requestid;
                this.begin = getHotHashTag.begin;
                this.limit = getHotHashTag.limit;
                this.country = getHotHashTag.country;
                this.need_detail = getHotHashTag.need_detail;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder begin(Integer num) {
            this.begin = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder need_detail(Boolean bool) {
            this.need_detail = bool;
            return this;
        }

        public GetHotHashTag build() {
            return new GetHotHashTag(this);
        }
    }
}
