package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetChatItems extends Message {
    public static final Boolean DEFAULT_ID_ONLY = false;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Boolean DEFAULT_NO_BANNED = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean id_only;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean no_banned;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public GetChatItems(String str, Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2) {
        this.requestid = str;
        this.userid = num;
        this.offset = num2;
        this.limit = num3;
        this.id_only = bool;
        this.no_banned = bool2;
    }

    private GetChatItems(Builder builder) {
        this(builder.requestid, builder.userid, builder.offset, builder.limit, builder.id_only, builder.no_banned);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetChatItems)) {
            return false;
        }
        GetChatItems getChatItems = (GetChatItems) obj;
        if (!equals((Object) this.requestid, (Object) getChatItems.requestid) || !equals((Object) this.userid, (Object) getChatItems.userid) || !equals((Object) this.offset, (Object) getChatItems.offset) || !equals((Object) this.limit, (Object) getChatItems.limit) || !equals((Object) this.id_only, (Object) getChatItems.id_only) || !equals((Object) this.no_banned, (Object) getChatItems.no_banned)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.id_only;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.no_banned;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetChatItems> {
        public Boolean id_only;
        public Integer limit;
        public Boolean no_banned;
        public Integer offset;
        public String requestid;
        public Integer userid;

        public Builder() {
        }

        public Builder(GetChatItems getChatItems) {
            super(getChatItems);
            if (getChatItems != null) {
                this.requestid = getChatItems.requestid;
                this.userid = getChatItems.userid;
                this.offset = getChatItems.offset;
                this.limit = getChatItems.limit;
                this.id_only = getChatItems.id_only;
                this.no_banned = getChatItems.no_banned;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
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

        public Builder id_only(Boolean bool) {
            this.id_only = bool;
            return this;
        }

        public Builder no_banned(Boolean bool) {
            this.no_banned = bool;
            return this;
        }

        public GetChatItems build() {
            return new GetChatItems(this);
        }
    }
}
