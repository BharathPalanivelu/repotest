package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetRecentItems extends Message {
    public static final Boolean DEFAULT_ID_ONLY = false;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NO_BANNED = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean id_only;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean no_banned;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;

    public GetRecentItems(String str, Integer num, Integer num2, Boolean bool, Boolean bool2, Integer num3, Integer num4, String str2) {
        this.requestid = str;
        this.shopid = num;
        this.type = num2;
        this.id_only = bool;
        this.no_banned = bool2;
        this.offset = num3;
        this.limit = num4;
        this.token = str2;
    }

    private GetRecentItems(Builder builder) {
        this(builder.requestid, builder.shopid, builder.type, builder.id_only, builder.no_banned, builder.offset, builder.limit, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetRecentItems)) {
            return false;
        }
        GetRecentItems getRecentItems = (GetRecentItems) obj;
        if (!equals((Object) this.requestid, (Object) getRecentItems.requestid) || !equals((Object) this.shopid, (Object) getRecentItems.shopid) || !equals((Object) this.type, (Object) getRecentItems.type) || !equals((Object) this.id_only, (Object) getRecentItems.id_only) || !equals((Object) this.no_banned, (Object) getRecentItems.no_banned) || !equals((Object) this.offset, (Object) getRecentItems.offset) || !equals((Object) this.limit, (Object) getRecentItems.limit) || !equals((Object) this.token, (Object) getRecentItems.token)) {
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
        Integer num2 = this.type;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.id_only;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.no_banned;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num3 = this.offset;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.limit;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetRecentItems> {
        public Boolean id_only;
        public Integer limit;
        public Boolean no_banned;
        public Integer offset;
        public String requestid;
        public Integer shopid;
        public String token;
        public Integer type;

        public Builder() {
        }

        public Builder(GetRecentItems getRecentItems) {
            super(getRecentItems);
            if (getRecentItems != null) {
                this.requestid = getRecentItems.requestid;
                this.shopid = getRecentItems.shopid;
                this.type = getRecentItems.type;
                this.id_only = getRecentItems.id_only;
                this.no_banned = getRecentItems.no_banned;
                this.offset = getRecentItems.offset;
                this.limit = getRecentItems.limit;
                this.token = getRecentItems.token;
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

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder id_only(Boolean bool) {
            this.id_only = bool;
            return this;
        }

        public Builder no_banned(Boolean bool) {
            this.no_banned = bool;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public GetRecentItems build() {
            return new GetRecentItems(this);
        }
    }
}
